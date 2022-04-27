package botGenerator.web.servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.common.io.Files;

import congabase.Project;
import congabase.Service;
import congabase.ServiceStatus;
import congabase.main.CongaData;
import generator.Language;

/**
 * @author Sara Pérez Soler
 * 
 * A servlet to to call an external services and parse from some tool files into a CONGA resource, 
 * also it creates a new CONGA project for the resource
 * 
 * Servlet implementation class CreateProject
 */
@WebServlet("/loadBot")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class LoadProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String FILE_EXTENSION = ".zip";
	public static final String ID = "id";
	private static final String FILE_ATTRIBUTE_NAME = "model-file";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Project project = null;
		CongaData conga = null;
		try {
			conga = CongaData.getCongaData(getServletContext());
			String parserId = request.getParameter("versionSelect");
			Service service = conga.getParserService(parserId);

			if (service == null) {
				getServletContext().setAttribute("msg", "You must select a tool and a version.");
				request.getRequestDispatcher("loadproject.jsp").forward(request, response);
				return;
			}

			String projectName = request.getParameter("projectName");
			if (projectName.isEmpty() || projectName.isBlank()) {
				getServletContext().setAttribute("msg", "The project must contain a name.");
				request.getRequestDispatcher("loadproject.jsp").forward(request, response);
				return;
			}

			String userString = (String) request.getSession().getAttribute("user");
			project = conga.getProject(userString, projectName);
			if (project != null) {
				getServletContext().setAttribute("msg", "A project with the name " + projectName + " already exit");
				request.getRequestDispatcher("loadproject.jsp").forward(request, response);
				return;
			}

			project = conga.newProject(projectName, userString, Language.ENGLISH.getLiteral());
			if (project != null) {
				File dst = readMultiPartFile(request, conga, project);
				if (dst == null) {
					getServletContext().setAttribute("msg", "Some error occurred reading the file");
					request.getRequestDispatcher("loadproject.jsp").forward(request, response);
					return;
				}

				if (service.getStatus() != ServiceStatus.ON) {
					SendServiceError.sendError(getServletContext(), conga, parserId, userString, request, response,  "loadproject.jsp");
					conga.delProject(userString, projectName);	
					return;
				}
				File ret = service.sendAndGetFile(dst, dst.getName());
				if (ret == null) {
					SendServiceError.sendError(getServletContext(), conga, parserId, userString, request, response, "loadproject.jsp");
					conga.delProject(userString, projectName);
					return;
				}
				conga.loadBotFile(project, ret);
				delete(ret);
				delete(dst.getParentFile());

				getServletContext().setAttribute("project", project);
				//service.setLastAccess(new Date());
				request.getRequestDispatcher("editor.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getServletContext().setAttribute("msg", "Some error occurred processing the file");
			if (conga != null && project!= null) {
				conga.delProject(project.getOwner().getNick(), project.getName());
			}
			request.getRequestDispatcher("loadproject.jsp").forward(request, response);
			return;
		}

	}

	private void delete(File f) {
		if (f.isDirectory()) {
			for (File child : f.listFiles()) {
				delete(child);
			}
		}
		f.delete();
	}

	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				String path = content.substring(content.indexOf("=") + 2, content.length() - 1);
				Path uri = new File(path).toPath();
				String filename = uri.getFileName().toString();
				if (!filename.endsWith(FILE_EXTENSION)) {
					filename = filename + FILE_EXTENSION;
				}
				return filename;
			}
		}
		return null;
	}

	private File readMultiPartFile(HttpServletRequest request, CongaData conga, Project project)
			throws IOException, ServletException {

		String tempPath = getServletContext().getRealPath("") + File.separator + "temp";
		File tempDir = new File(tempPath);
		if (!tempDir.exists())
			tempDir.mkdirs();

		String uploadPath = conga.getProjectFolderPath(project) + File.separator + "load";

		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdirs();

		// Copiar el fichero mandado por el usuario al directorio que se acaba de crear
		String fileName = null;
		String fileTempPath = "";
		String filePath = "";
		File dst = null;
		if (request.getPart(FILE_ATTRIBUTE_NAME) != null) {
			Part part = request.getPart(FILE_ATTRIBUTE_NAME);
			fileName = getFileName(part);
			fileTempPath = tempPath + File.separator + fileName;
			filePath = uploadPath + File.separator + fileName;
			part.write(fileTempPath);

			File src = new File(fileTempPath);
			dst = new File(filePath);
			if (!src.exists()) {
				return null;
			}
			Files.copy(src, dst);
			delete(src);
		}
		return dst;
	}

}

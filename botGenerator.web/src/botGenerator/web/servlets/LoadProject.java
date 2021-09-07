package botGenerator.web.servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

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
import congabase.main.CongaData;
import generator.Language;

/**
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
		try {
			CongaData conga = CongaData.getCongaData(getServletContext());
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
			Project project = conga.getProject(userString, projectName);
			if (project!= null) {
				getServletContext().setAttribute("msg", "A project with the name "+projectName+" already exit");
				request.getRequestDispatcher("loadproject.jsp").forward(request, response);
				return;
			}
			
			project = conga.newProject(projectName, userString, Language.ENGLISH.getLiteral());
			if (project != null) {

				// Comprobar que el usuario solo ha mandado un fichero
				if (request.getParts().size() != 2) {
//					getServletContext().setAttribute("msg", "You must select only one zip file.");
//					request.getRequestDispatcher("loadproject.jsp").forward(request, response);
//					return;
				}
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
						getServletContext().setAttribute("msg", "Some error ocurre at create.");
						request.getRequestDispatcher("loadproject.jsp").forward(request, response);
						return;
					}
					Files.copy(src, dst);
					delete(src);
				}
				if (dst != null) {
					File f = SendService.sendService(service, dst, fileName);
					conga.loadBotFile(project, f);
					delete(f);
				}
				delete(uploadDir);
				
				getServletContext().setAttribute("project", project);
				request.getRequestDispatcher("editor.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void delete(File f) {
		if (f.isDirectory()) {
			for (File child: f.listFiles()) {
				delete (child);
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
	


}

package botGenerator.web.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;

import congabase.Project;
import congabase.Service;
import congabase.ServiceStatus;
import congabase.main.CongaData;

/**
 * @author Sara Pérez Soler
 * 
 * A servlet to call an external services and generates code from a CONGA resource
 * 
 * Servlet implementation class Generator
 */
@WebServlet("/generator")
public class Generator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Generator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String projectName = request.getParameter("projectName");
		String userProject = (String) request.getSession().getAttribute("user");
		String generatorId = request.getParameter("serviceId");

		CongaData conga = null;
		try {
			conga = CongaData.getCongaData(getServletContext());
			Project project = conga.getProject(userProject, projectName);
			conga.saveAsXmi(project);
			File f = new File(conga.getProjectXMIPath(project));
			String botName = project.getName();
			Service service = conga.getGeneratorService(generatorId);
			if (service.getStatus()!=ServiceStatus.ON) {
				SendServiceError.sendError(getServletContext(), conga, generatorId, userProject, request, response, (String) getServletContext().getAttribute("jsp"));
				return;
			}
			File ret = service.sendAndGetFile(f, botName);
			if (ret == null) {
				SendServiceError.sendError(getServletContext(), conga, generatorId, userProject, request, response, (String) getServletContext().getAttribute("jsp"));
				return;
			}
			conga.addLastDateService(userProject, generatorId, new Date());
			response.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			response.setHeader("Content-Disposition", "filename=\""+service.getTool().getName()+"_"+botName+".zip\"");
			FileUtils.copyFile(ret, response.getOutputStream());
			ret.delete();
		} catch (Exception e) {
			SendServiceError.sendError(getServletContext(), conga, generatorId, userProject, request, response,(String) getServletContext().getAttribute("jsp"));
		}
	}

	

	

}

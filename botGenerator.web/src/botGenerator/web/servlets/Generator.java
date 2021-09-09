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
		String userString = (String) request.getSession().getAttribute("user");
		String generatorId = request.getParameter("serviceId");

		CongaData conga = null;
		try {
			conga = CongaData.getCongaData(getServletContext());
			Project project = conga.getProject(userString, projectName);
			conga.saveAsXmi(project);
			File f = new File(conga.getProjectXMIPath(project));
			String botName = project.getName();
			Service service = conga.getGeneratorService(generatorId);
			if (service.getStatus()!=ServiceStatus.ON) {
				SendService.sendError(getServletContext(), conga, generatorId, userString, request, response, (String) getServletContext().getAttribute("jsp"));
				return;
			}
			File ret = SendService.sendService(service, f, botName);
			if (ret == null) {
				SendService.sendError(getServletContext(), conga, generatorId, userString, request, response, (String) getServletContext().getAttribute("jsp"));
				return;
			}
			conga.addLastDateService(userString, generatorId, new Date());
			response.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			response.setHeader("Content-Disposition", "filename=\""+service.getTool().getName()+"_"+botName+".zip\"");
			FileUtils.copyFile(ret, response.getOutputStream());
			ret.delete();
		} catch (Exception e) {
			SendService.sendError(getServletContext(), conga, generatorId, userString, request, response,(String) getServletContext().getAttribute("jsp"));
		}
	}

	

	

}

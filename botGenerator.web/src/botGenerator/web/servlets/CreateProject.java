package botGenerator.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import congabase.Project;
import congabase.main.CongaData;
import generator.Language;

/**
 * @author Sara Pérez Soler
 * 
 * A servlet to create a new CONGA project and its resource
 * 
 * Servlet implementation class CreateProject
 */
@WebServlet("/createProject")
public class CreateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateProject() {
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
			String projectName = request.getParameter("projectName");
			if (projectName.isEmpty() || projectName.isBlank()) {
				getServletContext().setAttribute("msg", "The project must contain a name.");
				request.getRequestDispatcher("newproject.jsp").forward(request, response);
			} else {
				String language = request.getParameter("language");
				if (language == null) {
					language = Language.ENGLISH.getLiteral();
				}
				String userString = (String) request.getSession().getAttribute("user");

				CongaData conga = CongaData.getCongaData(getServletContext());
				Project project = conga.getProject(userString, projectName);
				if (project!= null) {
					getServletContext().setAttribute("msg", "A project with the name "+projectName+" already exit");
					request.getRequestDispatcher("loadproject.jsp").forward(request, response);
					return;
				}
				
				project = conga.newProject(projectName, userString, language.toUpperCase());
				if (project != null) {
					getServletContext().setAttribute("project", project);
					request.getRequestDispatcher("editor.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

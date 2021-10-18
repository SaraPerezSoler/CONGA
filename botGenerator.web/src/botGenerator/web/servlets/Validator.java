package botGenerator.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import congabase.Project;
import congabase.Service;
import congabase.ServiceStatus;
import congabase.main.CongaData;

/**
 * Servlet implementation class Validator
 */
@WebServlet("/validate")
public class Validator extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Fix to adapter at the new idea (ResourceValidation instead of BotValidation) dont forget bind MyResourceValidation
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String projectName = request.getParameter("projectName");
		String userProject = (String) request.getSession().getAttribute("user");
		String validatorId = request.getParameter("serviceId");
		CongaData conga = null;
		try {
			conga = CongaData.getCongaData(getServletContext());
			Project project = conga.getProject(userProject, projectName);
			Service s = conga.getValidatorService(validatorId);
			String param = "";
			if (s!=null) {
				if (s.getStatus()!=ServiceStatus.ON) {
					SendServiceError.sendError(getServletContext(), conga, validatorId, userProject, request, response, (String) getServletContext().getAttribute("jsp"));
					return;
				}
				param = "?toolName="+s.getTool().getName();
			}
			project.setCurrentValidator(s);
			conga.validate(project);
			request.getRequestDispatcher("/editor.jsp"+param).forward(request, response);
		} catch (Exception e) {
			SendServiceError.sendError(getServletContext(), conga, validatorId, userProject, request, response,(String) getServletContext().getAttribute("jsp"));
		}
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package botGenerator.web.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import congabase.AQuestion;
import congabase.Project;
import congabase.main.CongaData;

/**
 * @author Sara Pérez Soler
 * 
 * A servlet to starts a recommender questionnaire for a specific CONGA project
 * 
 * Servlet implementation class ProcesaFichero
 */
@WebServlet("/startQuestionnaire")
public class StartQuestionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StartQuestionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String projectName = request.getParameter("projectName");
		String userString = (String) request.getSession().getAttribute("user");
		CongaData conga;
		try {
			conga = CongaData.getCongaData(getServletContext());
			Project project = conga.getProject(userString, projectName);
			
			
			Map<String, String> evaluationLevel = new HashMap<String, String>();
			for (AQuestion ev : conga.getEvaluations(userString, projectName)) {
				String value = request.getParameter(ev.getQuestion().getName());
				evaluationLevel.put(ev.getQuestion().getName(), value);
			}
			conga.evaluateBot(project, evaluationLevel);

			RequestDispatcher jsp;
			jsp = request.getRequestDispatcher("/questionnaire2.jsp?projectName="+projectName);
			jsp.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

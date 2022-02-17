package botGenerator.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import congabase.AQuestion;
import congabase.Project;
import congabase.RelevanceLevel;
import congabase.main.CongaData;

/**
 * @author Sara Pérez Soler
 * 
 * A servlet to ends the recommender questionnaire and calculates the recommendations for a specific CONGA project
 * 
 * Servlet implementation class EndQuestionnaire
 */
@WebServlet("/endQuestionnaire")
public class EndQuestionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EndQuestionnaire() {
		super();
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
			
			
			for (AQuestion question : conga.getNOTEvaluations(userString, projectName)) {
				String name = question.getQuestion().getName();
				boolean multi = question.getQuestion().isMultiresponse();
				List<String> optionsList = new ArrayList<String>();
				if (multi) {
					String[] options = request.getParameterValues(name + "-Answer");
					if (options != null) {
						for (String opt : options) {
							optionsList.add(opt);
						}
					}
				} else {
					String opt = request.getParameter(name + "-Answer");
					if (opt != null) {
						optionsList.add(opt);
					}
				}
				String relevanceString = request.getParameter(name + "-Relevant");
				RelevanceLevel level = RelevanceLevel.get(relevanceString);
				if (level != RelevanceLevel.IRRELEVANT && optionsList.isEmpty()) {
					getServletContext().setAttribute("msg", "There are options which are not selected and not marked as irrelevant");
					request.getRequestDispatcher("questionnaire2.jsp").forward(request, response);
					return;
				}

				conga.addAnswer(project, question, optionsList, level);
			}
			conga.calculateRanking(project);

			RequestDispatcher jsp;
			jsp = request.getRequestDispatcher("/Ranking.jsp?projectName="+projectName);
			jsp.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}

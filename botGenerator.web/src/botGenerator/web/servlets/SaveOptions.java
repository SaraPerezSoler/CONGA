package botGenerator.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import congabase.User;
import congabase.main.CongaData;
import recommenderQuestionnaire.Option;
import recommenderQuestionnaire.Question;
import recommenderQuestionnaire.Tool;

/**
 * @author Sara Pérez Soler
 * 
 * A servlet to ends the recommender questionnaire and calculates the recommendations for a specific CONGA project
 * 
 * Servlet implementation class EndQuestionnaire
 */
@WebServlet("/saveOptions")
public class SaveOptions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveOptions() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userString = (String) request.getSession().getAttribute("user");
		String serviceId = request.getParameter("serviceId");
		
		CongaData conga;
		try {
			conga = CongaData.getCongaData(getServletContext());
			User user = conga.getUser(userString);
			if (user==null) {
				getServletContext().setAttribute("msg", "The user is not wel selected");
				request.getRequestDispatcher("NewRecommenderTool.jsp").forward(request, response);
				return;
			}
			String tool = request.getParameter("tool");
			Tool t = conga.getTool(tool);
			String version = request.getParameter("version");
			if (version == null || version.isEmpty() || version.isBlank()) {
				getServletContext().setAttribute("msg", "The tool version must be set");
				request.getRequestDispatcher("NewRecommenderTool.jsp").forward(request, response);
				return;
			}
			
			Map<String, List<String>> available = new HashMap<String, List<String>>();
			Map<String, List<String>> unavailable = new HashMap<String, List<String>>();
			Map<String, List<String>> possible = new HashMap<String, List<String>>();
			
			for (Question question: conga.getRecommenderQuestions()) {
				List<String> availableList = new ArrayList<String>();
				List<String> unavailableList = new ArrayList<String>();
				List<String> possibleList = new ArrayList<String>();
				for (Option opt: question.getOptions()) {
					String value = request.getParameter(question.getName()+"_"+opt.getText());
					switch (value) {
					case "Available":
						availableList.add(opt.getText());
						break;
					case "Unavailable":
						unavailableList.add(opt.getText());
						break;
					case "Possible":
						possibleList.add(opt.getText());
						break;
					default:
						break;
					}
				}
				available.put(question.getName(), availableList);
				unavailable.put(question.getName(), unavailableList);
				possible.put(question.getName(), possibleList);
			}
			
			if (serviceId == null || serviceId.isEmpty() || serviceId.isBlank()) {
				conga.addToolOptions(t, user, version, available, unavailable, possible);
			}else {
				conga.editToolOptions(serviceId, t, userString, version, available, unavailable, possible);
			}
			
			request.getRequestDispatcher("serviceManager.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}

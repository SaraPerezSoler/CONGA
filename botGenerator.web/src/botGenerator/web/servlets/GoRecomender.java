package botGenerator.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import botGenerator.web.xtextServlets.MyResourceBaseProvider;
import congabase.Project;

/**
 * @author Sara Pérez Soler
 * 
 * A servlet to save the first part of the recommender and redirect to the second
 * 
 * Servlet implementation class GoRecomender
 */
@WebServlet("/goRecommender")
public class GoRecomender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoRecomender() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resourceName = request.getParameter("resource");
		Project project = MyResourceBaseProvider.getProject(resourceName);
		
		RequestDispatcher jsp;
		jsp = request.getRequestDispatcher("/questionnaire2.jsp?projectName="+project.getName());
		jsp.forward(request, response);
	}

}

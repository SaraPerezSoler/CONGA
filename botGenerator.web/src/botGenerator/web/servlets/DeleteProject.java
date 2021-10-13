package botGenerator.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import congabase.main.CongaData;

/**
 * @author Sara Pérez Soler
 * 
 * A servlet to delete a CONGA project and its resource
 * 
 * Servlet implementation class DeleteProject
 */
@WebServlet("/deleteProject")
public class DeleteProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String project = request.getParameter("projectName");
		String userString = (String) request.getSession().getAttribute("user");
		try {
			CongaData conga = CongaData.getCongaData(getServletContext());
			conga.delProject(userString, project);
			request.getRequestDispatcher("/User.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package botGenerator.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import congabase.Project;
import congabase.main.CongaData;

/**
 * Servlet implementation class OpenProject
 */
@WebServlet("/openProject")
public class OpenProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenProject() {
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
			Project p = conga.getProject(userString, project);
			if (p!= null) {
				getServletContext().setAttribute("project", p);
				//////////////////////////////////////////////////////////////////////////////////
				//System.out.println(p.getName()+":"+conga.countObject(p));
				//conga.saveAsXmi(p);
				/////////////////////////////////////////////////////////////////////////////////
				request.getRequestDispatcher("/editor.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}

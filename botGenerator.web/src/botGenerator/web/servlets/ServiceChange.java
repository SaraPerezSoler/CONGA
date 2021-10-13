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
 * A servlet to switch the services status: ERROR to ON, ON to OFF and OFF to ON
 * 
 * Servlet implementation class ServiceChange
 */
@WebServlet("/serviceChange")
public class ServiceChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serviceId = request.getParameter("serviceId");
		String userString = (String) request.getSession().getAttribute("user");
		try {
			CongaData conga = CongaData.getCongaData(getServletContext());
			conga.changeService(userString, serviceId);
			request.getRequestDispatcher("/serviceManager.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

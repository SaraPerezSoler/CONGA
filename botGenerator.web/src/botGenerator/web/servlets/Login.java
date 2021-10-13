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
 * A servlet to Login in CONGA Web tool
 * 
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("lg_username");
		String password = request.getParameter("lg_password");
		
		CongaData congaData;
		try {
			congaData = CongaData.getCongaData(getServletContext());
			if (congaData.login (user, password)) {
				request.getSession().setAttribute("user", user);
				getServletContext().setAttribute("msg", null);
				request.getRequestDispatcher("User.jsp").forward(request, response);
			}else {
				getServletContext().setAttribute("msg", "Incorrect username or password.");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

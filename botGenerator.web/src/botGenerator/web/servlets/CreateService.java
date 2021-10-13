package botGenerator.web.servlets;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import congabase.User;
import congabase.main.CongaData;

/**
 * @author Sara Pérez Soler
 * 
 * A servlet to create a new CONGA service
 * 
 * Servlet implementation class AddService
 */
@WebServlet("/addService")
public class CreateService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("url");
		if (url.isEmpty() || url.isBlank()) {
			getServletContext().setAttribute("msg", "You should provider a valid URL");
			request.getRequestDispatcher("NewService.jsp").forward(request, response);
			return;
		}
		try {
			new URL(url).toURI();
		}catch (Exception exception) {
			getServletContext().setAttribute("msg", "You should provider a valid URL");
			request.getRequestDispatcher("NewService.jsp").forward(request, response);
			return;
		}
		
		try {
			String userString = (String) request.getSession().getAttribute("user");
			String tool = request.getParameter("tool");
			String version = request.getParameter("version");
			String type = request.getParameter("type");
			String auth_key = request.getParameter("auth_key");
			String auth_value = request.getParameter("auth_value");
			
			CongaData conga = CongaData.getCongaData(getServletContext());
			User user = conga.getUser(userString);
			if (user.containService(tool, version, type)) {
				getServletContext().setAttribute("msg", "You already have a service with the same tool, version and type");
				request.getRequestDispatcher("NewService.jsp").forward(request, response);
				return;
			}
			int i =0;
			Map<String, String> headers = new HashMap<>();
			String key  = request.getParameter("key_"+i);
			String value = request.getParameter("value_"+i);
			while (key != null && value!= null) {
				if (!key.isEmpty() && !key.isBlank())
				headers.put(key, value);
				i++;
				key  = request.getParameter("key_"+i);
				value = request.getParameter("value_"+i);
			}
			
			
			conga.newService(userString, url, tool, version, type, auth_key, auth_value, headers);
			request.getRequestDispatcher("serviceManager.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

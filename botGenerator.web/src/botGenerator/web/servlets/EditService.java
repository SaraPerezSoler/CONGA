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

import congabase.Service;
import congabase.User;
import congabase.main.CongaData;

/**
 * @author Sara Pérez Soler
 * 
 * A servlet to change a CONGA service features
 * 
 * Servlet implementation class EditService
 */
@WebServlet("/editService")
public class EditService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String serviceId = request.getParameter("serviceId");
		if (serviceId == null || serviceId.isEmpty() || serviceId.isBlank()) {
			request.getRequestDispatcher("serviceManager.jsp").forward(request, response);
			return;
		}
		String url = request.getParameter("url");
		if (url.isEmpty() || url.isBlank()) {
			getServletContext().setAttribute("msg", "You should provider a valid URL");
			request.getRequestDispatcher("editService.jsp?serviceId=" + serviceId).forward(request, response);
			return;
		}
		try {
			new URL(url).toURI();
		} catch (Exception exception) {
			getServletContext().setAttribute("msg", "You should provider a valid URL");
			request.getRequestDispatcher("editService.jsp?serviceId=" + serviceId).forward(request, response);
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
			Service service = conga.getService(userString, serviceId);
			User user = conga.getUser(userString);
			if (user.containService(tool, version, type) && (!service.getTool().getName().equals(tool)
					|| !service.getType().getName().equalsIgnoreCase(type) || !service.getVersion().equals(version))) {
				getServletContext().setAttribute("msg",
						"You already have a service with the same tool, version and type");
				request.getRequestDispatcher("editService.jsp?serviceId=" + serviceId).forward(request, response);
				return;
			}
			int i = 0;
			Map<String, String> headers = new HashMap<>();
			String key = request.getParameter("key_" + i);
			String value = request.getParameter("value_" + i);
			while (key != null && value != null) {
				if (!key.isEmpty() && !key.isBlank())
					headers.put(key, value);
				i++;
				key = request.getParameter("key_" + i);
				value = request.getParameter("value_" + i);
			}

			conga.modifyService(serviceId, userString, url, tool, version, type, auth_key, auth_value, headers);
			request.getRequestDispatcher("serviceManager.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

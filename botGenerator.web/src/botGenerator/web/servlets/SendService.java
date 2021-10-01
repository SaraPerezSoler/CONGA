package botGenerator.web.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import congabase.main.CongaData;

public class SendService {
	public static void sendError(ServletContext context, CongaData conga, String serviceId, String userString,HttpServletRequest request, HttpServletResponse response, String errorPage) throws ServletException, IOException {
		conga.errorService(userString, serviceId);
		context.setAttribute("msg", "This services don't work properly");
		if (errorPage == null || errorPage.isEmpty()) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher(errorPage).forward(request, response);
		}
		
		
	}
}

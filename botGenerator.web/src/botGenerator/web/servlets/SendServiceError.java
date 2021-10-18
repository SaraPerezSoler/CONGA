package botGenerator.web.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import congabase.main.CongaData;
/**
 * @author Sara Pérez Soler
 * 
 * A class to send an error when a service does not work properly
 * 
 **/
public class SendServiceError {
	public static void sendError(ServletContext context, CongaData conga, String serviceId, String userString,HttpServletRequest request, HttpServletResponse response, String errorPage) throws ServletException, IOException {
		conga.errorService(userString, serviceId);
		sendNotExecuting(context, conga, "This services don't work properly", serviceId, userString, request, response, errorPage);
		
	}
	
	public static void sendNotExecuting(ServletContext context, CongaData conga, String msg, String serviceId, String userString,HttpServletRequest request, HttpServletResponse response, String errorPage) throws ServletException, IOException {
		context.setAttribute("msg", msg);
		if (errorPage == null || errorPage.isEmpty()) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher(errorPage).forward(request, response);
		}
		
		
	}
}

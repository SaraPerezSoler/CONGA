package botGenerator.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.xtext.web.server.IServiceContext;
import org.xtext.botGenerator.validation.BotValidator;

import congabase.Project;

/**
 * Servlet implementation class Validator
 */
@WebServlet("/validate")
public class Validator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Project project = (Project) getServletContext().getAttribute("project");;
		try {
			BotValidator.BooleanValue = true;
			request.getRequestDispatcher("xtext-service?"+IServiceContext.SERVICE_TYPE+"=validate&resource="+project.getOwner().getNick() + "/" + project.getName()+".bot").include(request, response);
			BotValidator.BooleanValue = false;
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

package botGenerator.web.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.model.XtextWebDocument;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;
import org.eclipse.xtext.web.servlet.HttpServiceContext;
import org.json.JSONObject;
import org.xtext.botGenerator.validation.BotValidator;
import org.xtext.botGenerator.validation.ProblemSet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.inject.Inject;

import botGenerator.web.xtextServlets.BotServlet;
import congabase.Project;
import congabase.Service;
import congabase.main.CongaData;

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
		Project project = (Project) getServletContext().getAttribute("project");
		String validatorId = request.getParameter("serviceId");
		try {
			CongaData conga = CongaData.getCongaData(getServletContext());
			Service s = conga.getValidatorService(validatorId);
			conga.saveAsXmi(project);
			File f = new File(conga.getProjectXMIPath(project));
			String botName = project.getName();
			if (s!=null) {
				ObjectMapper mapper = new ObjectMapper();
				JSONObject obj = s.sendAndGetJSON(f, botName);
				ProblemSet set = mapper.readValue(obj.toString(), ProblemSet.class);
				System.out.println(set);
				set.setTool(s.getTool().getName());
				BotValidator.set = set;
			}else {
				BotValidator.set = null;
			}
//			IResourceValidator resourceValidator = BotServlet.getInjector().getInstance(IResourceValidator.class);
//			List<Issue> issues = resourceValidator.validate(conga.getProjectResource(project),
//		            CheckMode.EXPENSIVE_ONLY, CancelIndicator.NullImpl);
			
//			Gson gson = new Gson();
//			response.setContentType("text/x-json");
//			gson.toJson(issues, response.getWriter());
			
//			IServerResourceHandler resourceHandler = BotServlet.getInjector().getInstance(IServerResourceHandler.class);
//			HttpServiceContext serviceContext = new HttpServiceContext(request);
//			XtextWebDocument document = resourceHandler.get(File.separator + project.getOwner().getNick() + File.separator + project.getName() + File.separator + project.getName() + ".bot", serviceContext);
//			document.clearCachedServiceResults();
//			
			Resource resource = conga.getProjectResource(project);
			IResourceScopeCache cache =((XtextResource)resource).getCache();
			cache.clear(resource);
			
//			request.getRequestDispatcher("xtext-service?"+IServiceContext.SERVICE_TYPE+"=validate&clear=true&resource="+project.getOwner().getNick() + "/" + project.getName()+".bot").include(request, response);
			request.getRequestDispatcher("/editor.jsp").forward(request, response);
			//request.getRequestDispatcher("editor.jsp").forward(request, response);
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

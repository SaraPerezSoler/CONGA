package botGenerator.web.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.json.JSONObject;
import org.xtext.botGenerator.validation.BotValidator;

import com.fasterxml.jackson.databind.ObjectMapper;

import congabase.Project;
import congabase.Service;
import congabase.main.CongaData;
import validation.problems.ProblemSet;

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
	 * Fix to adapter at the new idea (ResourceValidation instead of BotValidation) dont forget bind MyResourceValidation
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
			String param = "";
			if (s!=null) {
				ObjectMapper mapper = new ObjectMapper();
				JSONObject obj = s.sendAndGetJSON(f, botName);
				ProblemSet set = mapper.readValue(obj.toString(), ProblemSet.class);
				set.setTool(s.getTool().getName());
				BotValidator.set = set;
				param = "?toolName="+s.getTool().getName();
			}else {
				BotValidator.set = null;
			}
			Resource resource = conga.getProjectResource(project);
			IResourceScopeCache cache =((XtextResource)resource).getCache();
			cache.clear(resource);
			
			request.getRequestDispatcher("/editor.jsp"+param).forward(request, response);
		} catch (Exception e) {
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

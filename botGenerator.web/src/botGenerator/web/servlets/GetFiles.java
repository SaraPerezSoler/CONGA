package botGenerator.web.servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import botGenerator.web.xtextServlets.MyFileResourceHandler;
import botGenerator.web.xtextServlets.MyResourceBaseProvider;
import congabase.Project;
import congabase.main.CongaData;

/**
 * Servlet implementation class GetFiles
 */
@WebServlet("/getfiles")
public class GetFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFiles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String resourceName = req.getParameter("resource");
		Project project = MyResourceBaseProvider.getProject(resourceName);
		String tool = req.getParameter("tool");
		String botName = resourceName.replace(".bot", "");
		
		File srcFile;
		try {
			srcFile = new File(CongaData.getCongaData(getServletContext()).getProjectFolderPath(project)+"/gen"+"/"+tool+"/"+project.getName()+".zip");
			if (!srcFile.exists()) {
				resp.setContentType("text/plain");
		        resp.getWriter().println("The file "+CongaData.getCongaData(getServletContext()).getProjectFolderPath(project)+"/"+tool+"/"+project.getName()+".zip doesn't exist");
			}else {
				resp.setContentType("application/octet-stream");
				resp.setHeader("Content-Disposition", "filename=\""+tool+"_"+botName+".zip\"");
				FileUtils.copyFile(srcFile, resp.getOutputStream());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

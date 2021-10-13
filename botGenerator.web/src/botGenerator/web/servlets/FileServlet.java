package botGenerator.web.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import congabase.main.CongaData;

/**
 * @author Sara Pérez Soler
 * 
 * A servlet to generate and return the PlantUML flow image of a project
 * 
 * Servlet implementation class FileServlet
 */
@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext cntx = request.getServletContext();
		String projectName = request.getParameter("projectName");
		String user = (String) request.getSession().getAttribute("user");
		try {
			CongaData conga = CongaData.getCongaData(getServletContext());
			// Get the absolute path of the image
			String filename = conga.generateFlowImage(user, projectName);
			// retrieve mimeType dynamically
			String mime = cntx.getMimeType(filename);
			if (mime == null) {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				return;
			}

			response.setContentType(mime);
			File file = new File(filename);
			response.setContentLength((int) file.length());

			FileInputStream in = new FileInputStream(file);
			OutputStream out = response.getOutputStream();

			// Copy the contents of the file to the output stream
			byte[] buf = new byte[1024];
			int count = 0;
			while ((count = in.read(buf)) >= 0) {
				out.write(buf, 0, count);
			}
			out.close();
			in.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

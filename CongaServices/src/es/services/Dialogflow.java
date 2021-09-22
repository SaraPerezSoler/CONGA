package es.services;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataParam;

import es.main.CongaResource;
import es.main.ToolFiles;
import es.main.generators.DialogflowGenerator;
import es.main.reverse.DialogflowReverse;
import generator.Bot;

@Path("/dialogflow")
public class Dialogflow {

	@POST
	@Path("/generator")
	@Consumes (MediaType.MULTIPART_FORM_DATA)
	@Produces (MediaType.APPLICATION_OCTET_STREAM)
	public Response generator (@Context ServletContext context, @FormDataParam("file") File file, @FormDataParam("name") String botName) {
		String folderPath = context.getInitParameter("ServicePath");
		CongaResource cs = new CongaResource(folderPath, file, botName);
		DialogflowGenerator generator = new DialogflowGenerator(folderPath+File.separator+"Generator", cs.getName(), botName);
		File f = generator.doGenerate(cs.getResource()); 
		cs.destroy();
		return Response.ok(f, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + f.getName() + "\"").build();
		
	}
	
	@POST
	@Path("/parser")
	@Consumes (MediaType.MULTIPART_FORM_DATA)
	@Produces (MediaType.APPLICATION_OCTET_STREAM)
	public Response parser (@Context ServletContext context, @FormDataParam("file") File file, @FormDataParam("name") String fileName) throws IOException {
		String folderPath = context.getInitParameter("ServicePath");
		ToolFiles tf = new ToolFiles(folderPath, file, fileName);
		DialogflowReverse parser = new DialogflowReverse();
		Bot bot = parser.getChatbot(tf.getFile()).getBot(); 
		File f = tf.createResource(bot);
		tf.destroy();
		return Response.ok(f, MediaType.APPLICATION_OCTET_STREAM)
				.header("Content-Disposition", "attachment; filename=\"" + f.getName() + "\"").build();
		
	}
}

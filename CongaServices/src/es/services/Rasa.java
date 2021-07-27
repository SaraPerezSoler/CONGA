package es.services;

import java.io.File;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataParam;

import es.main.CongaServices;
import es.main.generators.RasaGenerator;

@Path("/rasa")
public class Rasa {
	@POST
	@Path("/generator")
	@Consumes (MediaType.MULTIPART_FORM_DATA)
	//@Produces (MediaType.APPLICATION_OCTET_STREAM)
	public String generator (@Context ServletContext context, @FormDataParam("file") File file, @FormDataParam("botName") String botName) {
		String folderPath = context.getInitParameter("ServicePath");
		CongaServices cs = new CongaServices(folderPath, file, botName);
		RasaGenerator generator = new RasaGenerator(folderPath, cs.getName(), botName);
		File f = generator.doGenerate(cs.getResource()); 
		cs.destroy();
		
		return "Subido con exito!!";
		//cs.destroy();
		
	}
}

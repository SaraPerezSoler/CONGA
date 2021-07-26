package es.services;

import java.io.File;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/dialogflow")
public class Dialogflow {

	@POST
	@Path("generator")
	@Consumes (MediaType.APPLICATION_OCTET_STREAM)
	@Produces (MediaType.APPLICATION_OCTET_STREAM)
	public Response generator (@Context ServletContext context, @FormParam("file") File file, @FormParam("botName") String filename) {
		
	}
}

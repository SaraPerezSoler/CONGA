package es.main.parser.rasa.actions;

import java.io.File;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.internal.MultiPartWriter;


public class SaveFileServer extends CreateRequest{
//	private static final String URL = "http://dimo1.ii.uam.es:8080/FileServer/file/";

	public SaveFileServer(String url) {
		super(url);
	}

	public String saveFile (File file) {
		@SuppressWarnings("resource")
		final MultiPart multiPart = new FormDataMultiPart().field("file", file, MediaType.APPLICATION_OCTET_STREAM_TYPE)
				.field("fileName", file.getName(), MediaType.TEXT_PLAIN_TYPE);
		multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
		Response response;
		response=super.postRequest("upload", multiPart, MediaType.MULTIPART_FORM_DATA, MediaType.TEXT_PLAIN);
		try {
			readResponse(response);
		} catch (TextResponse e) {
			return e.getText();
		} catch (ForbiddenResponse | ResponseError | JSONResponse | FileResponse e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public File getFile (String path) throws ResponseError, ForbiddenResponse {
		System.out.println(path);
		System.out.println("Url_: " + getURL());
		path = path.replace(getURL(), "");
		System.out.println(path);
		return super.responseFile(path, null);
	}
	
	public String getRequired_slots(String id, String form) throws ResponseError, ForbiddenResponse {
		return super.responseText("required_slots/"+id+"/"+form, null);
	}
	
	@Override
	protected WebTarget getWebTarget(String path) {
		String url = super.getURL();
		ClientConfig config = new ClientConfig();
		config.getClasses().add(MultiPartWriter.class);
		Client client = ClientBuilder.newClient(config);
		return client.target(url).path(path);
	}
	
}

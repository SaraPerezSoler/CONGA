package reverse;

import java.io.File;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

public class SendFilesTest {

	public static void main(String[] args) {

		File file = new File("D:/CONGA/admin/test/test.xmi");
		@SuppressWarnings("resource")
		final MultiPart multiPart = new FormDataMultiPart().field("file", file, MediaType.APPLICATION_OCTET_STREAM_TYPE)
				.field("botName", "test", MediaType.TEXT_PLAIN_TYPE);
		multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/CongaServices/rasa/generator")
				.register(MultiPartFeature.class);
		Response response = target.request(MediaType.TEXT_PLAIN)
				.post(Entity.entity(multiPart, MediaType.MULTIPART_FORM_DATA_TYPE));
		
		MultivaluedMap<String, String> header = response.getStringHeaders();
		List<String> contentType = header.get("Content-type");
		
		String text = null;
		if (response.getStatus() >= 200 && response.getStatus() < 300) {
			if (contentType.contains(MediaType.TEXT_PLAIN)) {
				text = response.readEntity(String.class);

			}
		}
		System.out.println(text);

	}

}

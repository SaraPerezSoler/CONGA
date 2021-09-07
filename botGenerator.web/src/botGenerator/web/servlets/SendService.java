package botGenerator.web.servlets;

import java.io.File;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import congabase.KeyValue;
import congabase.Service;

public class SendService {
	public static File sendService(Service service, File file, String name) {
		@SuppressWarnings("resource")
		final MultiPart multiPart = new FormDataMultiPart().field("file", file, MediaType.APPLICATION_OCTET_STREAM_TYPE)
				.field("name", name, MediaType.TEXT_PLAIN_TYPE);
		multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(service.getUrl()).register(MultiPartFeature.class);
		if (service.getBasicAuth() != null) {
			if (!service.getBasicAuth().getKey().isEmpty() && !service.getBasicAuth().getKey().isBlank()) {
				HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(service.getBasicAuth().getKey(),
						service.getBasicAuth().getValue().toString().getBytes());
				target = target.register(feature);
			}
		}
		javax.ws.rs.client.Invocation.Builder builder = target.request(MediaType.APPLICATION_OCTET_STREAM);
		for (KeyValue keyValue : service.getHeaders()) {
			builder = builder.header(keyValue.getKey(), keyValue.getValue().toString());
		}
		Response response = builder.post(Entity.entity(multiPart, MediaType.MULTIPART_FORM_DATA_TYPE));

		MultivaluedMap<String, String> header = response.getStringHeaders();
		List<String> contentType = header.get("Content-type");
		if (response.getStatus() >= 200 && response.getStatus() < 300) {
			if (contentType.contains(MediaType.APPLICATION_OCTET_STREAM)) {
				File output = response.readEntity(File.class);
				String fname = null;
				List<String> contentDisposition = header.get("Content-Disposition");
				if (contentDisposition != null) {
					for (String s : contentDisposition) {
						if (s.contains("filename=")) {
							fname = s.substring(s.indexOf("filename=") + "filename=".length());
							fname = fname.split("\"")[1];
							// System.out.println(name);
						}
					}
				}
				File f = null;
				if (fname != null) {
					f = new File(output.getParent() + "/" + fname);
					if (f.exists()) {
						f.delete();
					}
					output.renameTo(f);

				}
				return f;
			}
		}
		return null;
	}
}

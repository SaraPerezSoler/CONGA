package dialogflow.restAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dialogflow.request.Request;
import dialogflow.request.Response;

@Path("/")
public class RestAccess {

	public static ObjectMapper mapper = new ObjectMapper();

	enum ArtworkPrices{
		sculpture(10), picture(1),ceramic(5);
		
		private int price;
		ArtworkPrices(int price) {
			this.price = price;
		}
		public int getPrice () {
			return price;
		}
	}
	
	enum MediaPrices{
		photography(50), video(200), renderin(290);
		
		private int price;
		MediaPrices(int price) {
			this.price = price;
		}
		public int getPrice () {
			return price;
		}
		
		public static MediaPrices getMedia (String name) {
			if (name.equalsIgnoreCase("photography")) {
				return photography;
			}else if (name.equalsIgnoreCase("video")) {
				return video;
			}else {
				return renderin;
			}
		}
	}
	
	@POST
	@Path("dialgoflow")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
	public javax.ws.rs.core.Response editProject(@Context ServletContext context, InputStream incomingData,
			@PathParam("name") String name) throws JsonParseException, JsonMappingException, IOException {
		String data = readIncomingData(incomingData);

		//System.out.println(data);

		Request request = mapper.readValue(data, Request.class);
		 System.out.println(request);

		try {
			String responseText =  processRequest(context, request, name);
			Response response = new Response();
			response.setFulfillmentText(responseText);
			return javax.ws.rs.core.Response.ok(mapper.writeValueAsString(response), MediaType.APPLICATION_JSON)
					.build();
		} catch (Exception e) {
			Response response = new Response();
			response.setFulfillmentText(e.getMessage());
			return javax.ws.rs.core.Response.ok(mapper.writeValueAsString(response), MediaType.APPLICATION_JSON)
					.build();
		}
	}

	private String readIncomingData(InputStream incomingData) {
		String text = "";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				text += line + "\n";
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}

	@GET
	@Path("hello/{name}")
	@Produces({ MediaType.TEXT_PLAIN })
	public String sayHello(@PathParam("name") String name) {
		return "Hello " + name + " dialogflow";
	}

	private String processRequest(ServletContext context, Request request, String mmodel)
			throws Exception {

		String artwork = (String) request.getParameter("artwork");
		ArtworkPrices artworkPrices = ArtworkPrices.valueOf(artwork);
		int num = (int) request.getParameter("num");
		String media = (String) request.getParameter("media");
		MediaPrices mediaPrices = MediaPrices.getMedia(media);
		
		int price = artworkPrices.price * mediaPrices.price * num;

		return "The price would be around" + price + ", but may depend on other factors, like the size of the artworks";

	}

	

}

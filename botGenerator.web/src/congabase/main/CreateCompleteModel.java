package congabase.main;


import com.fasterxml.jackson.databind.ObjectMapper;

import congabase.Project;
import generator.Bot;

public class CreateCompleteModel {

	public static void main(String[] args) throws Exception {

		CongaData congaData = CongaData.getCongaData("/CONGA");
		
		
		Project p = congaData.getProject("admin", "example");
		
		Bot bot = congaData.getBotProject(p);
		ObjectMapper mapper = new ObjectMapper();
		String object = mapper.writeValueAsString(bot);
		System.out.println(object);
		
		Bot bot2 = mapper.readValue(object, Bot.class);
		
		
	}

}

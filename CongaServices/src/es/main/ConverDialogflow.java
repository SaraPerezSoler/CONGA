package es.main;

import java.io.File;

import es.main.parser.DialogflowReverse;
import es.main.parser.dialogflow.agent.Agent;
import generator.Bot;
import generator.Language;

public class ConverDialogflow {

	private static final String FOLDER = "D:\\Desktop\\Dialogflow - copia\\xmi";
	private static final String FOLDER_BASE = "D:\\Desktop\\Dialogflow - copia";

	public static void main(String[] args) {
		String folderPath = FOLDER;

		File folderBase = new File(FOLDER_BASE);
		if (!folderBase.isDirectory()) {
			return;
		}
		System.out.println("NAME;RUN;#LANGUAGES;LANGUAGES;#INTENTS;#ENTITES;#ACTIONS;#FLOWS;#BUTTONS;#TEXT;#IMAGES;#EMPTY;#HTTPREQUEST;#LOOPS");
		for (File file : folderBase.listFiles()) {
			boolean run = false;
			Agent agent = null;
			ToolFiles tf = null;
			boolean err = false;
			try {
				tf = new ToolFiles(folderPath, file, file.getName());
				DialogflowReverse parser = new DialogflowReverse();
				agent = parser.getChatbot(tf.getFile());
			} catch (Exception e) {
				err=true;
				System.out.println(file.getName().replace(".zip", "") + ";N1");
			}
			if (!err) {
				try {
					int num_language = 0;
					String languages="";
					int num_intents = 0;
					int num_entities = 0;
					int num_action = 0;
					int num_flows = 0;
					
					int num_buttons = 0;
					int num_text = 0;
					int num_image = 0;
					int num_emptyAction = 0;
					int external_service = 0;
					int num_loops = 0;
					
					
					
					if (agent.getLanguage().equals("en")) {
						Bot bot = agent.getBot();
						File f = tf.createResource(bot);
						run = true;
						num_language = bot.getLanguages().size();
						for (Language lan: bot.getLanguages()) {
							languages+=lan+" ";
						}
						num_intents = bot.getIntents().size();
						num_entities = bot.getEntities().size();
						num_action = bot.getActions().size();
						num_flows = bot.getFlows().size();
						
						num_buttons = bot.getButtons().size();
						num_text = bot.getTexts().size();
						num_image = bot.getImages().size();
						num_emptyAction = bot.getEmpties().size();
						external_service = bot.getHttpRequests().size();
						num_loops = bot.getNumLoops();
					}


					String runString = "-";
					if (run) {
						runString = "Y";
					}
					
					System.out.println(
							agent.getName() +";"+runString+ ";"+num_language+";" + languages + ";" + num_intents + ";" + num_entities+";"+ num_action+";"+num_flows+";"+num_buttons+";"+num_text+";"+num_image+";"+num_emptyAction+";"+external_service+";"+num_loops
							);
				} catch (Exception e) {
					if (agent != null) {
						System.out.println(agent.getName() + ";N2");
					} else {
						System.out.println(file.getName().replace(".zip", "") + ";N3");
					}
				}
			}

		}
	}

}
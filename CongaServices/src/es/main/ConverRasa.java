package es.main;

import java.io.File;

import es.main.parser.RasaReverse;
import es.main.parser.rasa.bot.RasaBot;
import generator.Bot;
import generator.Language;

public class ConverRasa {

	private static final String FOLDER = "D:\\Desktop\\Rasa - copia\\xmi";
	private static final String FOLDER_BASE = "D:\\Desktop\\Rasa - copia";

	public static void main(String[] args) {
		String folderPath = FOLDER;

		File folderBase = new File(FOLDER_BASE);
		if (!folderBase.isDirectory()) {
			return;
		}
		System.out.println("NAME;RUN;#LANGUAGES;LANGUAGES;#INTENTS;#ENTITES;#ACTIONS;#FLOWS;#BUTTONS;#TEXT;#IMAGES;#EMPTY;#FORM;#ACTION;#HTTPREQUEST;#LOOPS");
		for (File file : folderBase.listFiles()) {
			boolean run = false;

			try {
				ToolFiles tf = new ToolFiles(folderPath, file, file.getName());
				RasaReverse parser = new RasaReverse();
				RasaBot agent = parser.getChatbot(tf.getFile());
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
				int num_formAction = 0;
				int num_actionAction = 0;
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
					
					num_actionAction = agent.getDomain().getNum_actions();
					num_formAction = agent.getDomain().getNum_forms();
				}
				
				String runString = "-";
				if (run) {
					runString = "Y";
				}
				
				String have_loops = "N";
				if (agent.isHaveLoops()) {
					have_loops = "Y";
				}
				//agent.getName() + "\t" + agent.getLanguage() + "\t" + have_loops + "\t" + runString
				//System.out.println(agent.getName()+"\t"+agent.getLanguage()+"\t"+have_loops+"\t"+ runString);
				System.out.println(
						agent.getName() +";"+runString+ ";"+num_language+";" + languages + ";" + num_intents + ";" + num_entities+";"+ num_action+";"+num_flows+";"+num_buttons+";"+num_text+";"+num_image+";"+num_emptyAction+";"+num_formAction+";"+num_actionAction+";"+external_service+";"+num_loops
						);
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println(file.getName().replace(".zip", "") + ";N3");
			}
			
			
		}
	}

}
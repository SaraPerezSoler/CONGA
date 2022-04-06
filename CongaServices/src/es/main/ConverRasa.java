package es.main;

import java.io.File;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.main.reverse.DialogflowReverse;
import es.main.reverse.RasaReverse;
import es.main.reverse.dialogflow.agent.Agent;
import es.main.reverse.rasa.bot.RasaBot;
import generator.Bot;

public class ConverRasa {

	private static final String FOLDER = "D:\\Desktop\\Rasa Chatbots - copia\\xmi";
	private static final String FOLDER_BASE = "D:\\Desktop\\Rasa Chatbots - copia";

	public static void main(String[] args) {
		String folderPath = FOLDER;

		File folderBase = new File(FOLDER_BASE);
		if (!folderBase.isDirectory()) {
			return;
		}
		for (File file : folderBase.listFiles()) {
			boolean run = false;

			try {
				ToolFiles tf = new ToolFiles(folderPath, file, file.getName());
				RasaReverse parser = new RasaReverse();
				RasaBot agent = parser.getChatbot(tf.getFile());
				if (agent.getLanguage().equals("en")) {
					Bot bot = agent.getBot();
					File f = tf.createResource(bot);
					run = true;
				}
				System.out.println(agent.getName()+"\t"+agent.getLanguage()+"\t"+run+"\t"+agent.isHaveLoops());
			} catch (Exception e) {
				System.out.println(file.getName()+"\t-\tERR\t");
			}
			
			
		}
	}

}

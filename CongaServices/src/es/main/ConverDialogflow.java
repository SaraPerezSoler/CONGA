package es.main;

import java.io.File;

import es.main.parser.DialogflowReverse;
import es.main.parser.dialogflow.agent.Agent;
import generator.Bot;

public class ConverDialogflow {

	private static final String FOLDER = "D:\\Desktop\\Chatbots\\xmi";
	private static final String FOLDER_BASE = "D:\\Desktop\\Chatbots";

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
				DialogflowReverse parser = new DialogflowReverse();
				Agent agent = parser.getChatbot(tf.getFile());
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
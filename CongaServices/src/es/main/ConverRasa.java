package es.main;

import java.io.File;

import es.main.parser.RasaReverse;
import es.main.parser.rasa.bot.RasaBot;
import generator.Bot;

public class ConverRasa {

	private static final String FOLDER = "D:\\Desktop\\Rasa - copia\\xmi";
	private static final String FOLDER_BASE = "D:\\Desktop\\Rasa - copia";

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
				
				String runString = "-";
				if (run) {
					runString = "Y";
				}
				
				String have_loops = "N";
				if (agent.isHaveLoops()) {
					have_loops = "Y";
				}
				//agent.getName() + "\t" + agent.getLanguage() + "\t" + have_loops + "\t" + runString
				System.out.println(agent.getName()+"\t"+agent.getLanguage()+"\t"+have_loops+"\t"+ runString);
			} catch (Exception e) {
				System.out.println(file.getName().replace(".zip", "") + "\t-\tN\tN");
			}
			
			
		}
	}

}
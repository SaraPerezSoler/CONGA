package es.main;

import java.io.File;

import es.main.parser.DialogflowReverse;
import es.main.parser.dialogflow.agent.Agent;
import generator.Bot;

public class ConverDialogflow {

	private static final String FOLDER = "D:\\Desktop\\Dialogflow - copia\\xmi";
	private static final String FOLDER_BASE = "D:\\Desktop\\Dialogflow - copia";

	public static void main(String[] args) {
		String folderPath = FOLDER;

		File folderBase = new File(FOLDER_BASE);
		if (!folderBase.isDirectory()) {
			return;
		}
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
				System.out.println(file.getName().replace(".zip", "") + "\t-\t-\tN");
			}
			if (!err) {
				try {
					if (agent.getLanguage().equals("en")) {
						Bot bot = agent.getBot();
						File f = tf.createResource(bot);
						run = true;
					}
					String have_loops = "N";
					if (agent.isHaveLoops()) {
						have_loops = "Y";
					}
					
					String have_econtainer_loops = "N";
					if (agent.isHaveeContainerLoops()) {
						have_econtainer_loops = "Y";
					}
					String runString = "-";
					if (run) {
						runString = "Y";
					}
					
					System.out.println(
							agent.getName() + "\t" + agent.getLanguage() + "\t" + have_loops + "\t" + runString +"\t"+have_econtainer_loops);
				} catch (Exception e) {
					if (agent != null) {
						System.out.println(agent.getName() + "\t" + agent.getLanguage() + "\t-\tN");
					} else {
						System.out.println(file.getName().replace(".zip", "") + "\t-\t-\tN");
					}
				}
			}

		}
	}

}
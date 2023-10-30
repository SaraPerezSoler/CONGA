package es.main;

import java.io.File;

import es.main.generators.BotGenerator;
import es.main.generators.Rasa2_0Generator;
import es.main.generators.Rasa3_0Generator;
import es.main.generators.RasaGenerator;
import es.main.parser.Rasa2_0Reverse;
import es.main.parser.Rasa3_0Reverse;
import es.main.parser.RasaReverse;
import es.main.parser.rasa.bot.RasaBot;
import generator.Bot;

public class RasaParserGenerator {

	public static final String GENERATOR = "generator";
	public static final String PARSER = "parser";
	
	public static final String RASA1 = "1";
	public static final String RASA2 = "2";
	public static final String RASA3 = "3";
	
	public static void main(String[] args) throws Exception {
		
		String src;
		String dest;
		String type = GENERATOR;
		String version = RASA1;
		if (args.length <2) {
			System.err.println("The program needs at least 2 argument: <file_path> <dest_path> <proccess (generator/parser)[optional: default generator]> <rasa version (1, 2 or 3)[optional: default 1]>");
			return;
		}
		src = args[0];
		dest = args[1];
		if (args.length >= 3) {
			if (args[2].equals(RASA1)||args[2].equals(RASA2)||args[2].equals(RASA3)) {
				version = args[2];
			}else if (args[2].equals(GENERATOR)||args[2].equals(PARSER)) {
				type = args[2];
			}
		}
		if (args.length >= 4) {
			if (args[3].equals(RASA1)||args[3].equals(RASA2)||args[3].equals(RASA3)) {
				version = args[3];
			}else if (args[3].equals(GENERATOR)||args[3].equals(PARSER)) {
				type = args[3];
			}
		}
		File file = new File (src);
		if (!file.exists()) {
			System.err.println("The provided file does not exist");
			return;
		}
		if (type.equals(GENERATOR)) {
			doRasaGenerator(file, dest, version);
		}else {
			doRasaParser(file, dest, version);
		}
	}
	
	public static File doRasaParser(String src, String dest, String version) throws Exception {
		File file = new File (src);
		if (!file.exists()) {
			System.err.println("The provided file does not exist");
			return null;
		}
		return doRasaParser(file, dest, version);
	}
	
	public static File doRasaParser(File src, String dest, String version) throws Exception {
		ToolFiles tf = new ToolFiles(dest, src, src.getName(), false);
		RasaBot rasaBot;
		if (version.equals(RASA1)) {
			RasaReverse parser = new RasaReverse();
			rasaBot = parser.getChatbot(tf.getFile());
		}else if (version.equals(RASA2)) {
			Rasa2_0Reverse parser = new Rasa2_0Reverse();
			rasaBot = parser.getChatbot(tf.getFile());
		}else {
			Rasa3_0Reverse parser = new Rasa3_0Reverse();
			rasaBot = parser.getChatbot(tf.getFile());
		}
		
		Bot bot = rasaBot.getBot();
		File f = tf.createResource(bot);
		return f;
	}
	
	public static File doRasaGenerator (String src, String dest, String version) {
		File file = new File (src);
		if (!file.exists()) {
			System.err.println("The provided file does not exist");
			return null;
		}
		return doRasaGenerator(file, dest, version);
	}
	public static File doRasaGenerator (File src, String dest, String version) {
		String name = src.getName().substring(0, src.getName().indexOf("."));
		CongaResource cr = new CongaResource(dest, src, name, false);
		BotGenerator generator;
		
		if (version.equals(RASA1)) {
			generator = new RasaGenerator(dest, cr.getName(), name);
		}else if (version.equals(RASA2)) {
			generator = new Rasa2_0Generator(dest, cr.getName(), name);
		}else {
			generator = new Rasa3_0Generator(dest, cr.getName(), name);
		}
		File f = generator.doGenerate(cr.getResource()); 
		return f;
	}

}

package reverse.rasa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import reverse.rasa.bot.Config;
import reverse.rasa.bot.Domain;
import reverse.rasa.bot.RasaBot;
import zipUtils.Unzipper;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.jsoup.Jsoup;

public class ReadRasaBot {
	public RasaBot getBot(File mainFile) throws Exception {
		File agentFiles = null;
		if (!mainFile.isDirectory() && mainFile.getName().endsWith(".zip")) {
			agentFiles = new Unzipper(mainFile.getCanonicalPath()).unzip();
			if (agentFiles == null) {
				return null;
			}
		}else {
			agentFiles = mainFile;
		}

		String agentName = agentFiles.getName();
		RasaBot rasaBot = new RasaBot(agentName);
		boolean agentCreated = false;
		boolean hasNLU = false;
		boolean hasDomain = false;
		boolean hasStories = false;
		boolean hasConfig = false;
		List<File> files = new ArrayList<File>();
		files.add(agentFiles);
		ObjectMapper om = new ObjectMapper(new YAMLFactory());
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		Parser parser = Parser.builder().build();
		while (agentCreated == false && !files.isEmpty()) {
			File currentFile = files.get(0);
			if (currentFile.isDirectory()) {
				for (File f : currentFile.listFiles()) {
					if (f.getName().equals("nlu.md")) {
						Node document = parser.parse(readFile(f));
						HtmlRenderer renderer = HtmlRenderer.builder().build();
						org.jsoup.nodes.Document html = Jsoup.parse(renderer.render(document)); 
						rasaBot.setNlu(html);
						//rasaBot.setNlu(readFile(f));
						hasNLU = true;
					} else if (f.getName().equals("domain.yml")) {
						rasaBot.setDomain(om.readValue(f, Domain.class));
						hasDomain = true;
					} else if (f.getName().equals("stories.md")) {
						rasaBot.setStories(readFile(f));
						hasStories = true;
					} else if (f.getName().equals("config.yml")) {
						rasaBot.setConfig(om.readValue(f, Config.class));
						hasConfig = true;
					} else if (f.isDirectory()) {
						files.add(f);
					}
					if (hasDomain && hasNLU && hasStories && hasConfig) {
						agentCreated = true;
					}
				}
			}
			files.remove(currentFile);
		}
		return rasaBot;
	}

	private String readFile(File f) {
		String text = "";
		if (f.isFile()) {
			try {
				Scanner myReader = new Scanner(f);
				while (myReader.hasNextLine()) {
					text += myReader.nextLine()+"\n";
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
		return text;
	}

}

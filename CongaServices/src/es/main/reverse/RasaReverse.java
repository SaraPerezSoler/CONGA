package es.main.reverse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import es.main.reverse.rasa.bot.Config;
import es.main.reverse.rasa.bot.Domain;
import es.main.reverse.rasa.bot.RasaBot;
import zipUtils.Unzipper;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.jsoup.Jsoup;

public class RasaReverse extends Reverse{
	private List<String> fileIgnore = new ArrayList<>();
	private static final String[] ignore = {"README.md", "readme.md", "Readme.md", "test_stories.yml"};
	public RasaReverse() {
		for (String s: ignore) {
			fileIgnore.add(s);
		}
	}

	public RasaReverse(List<String> fileIgnore) {
		for (String s: ignore) {
			fileIgnore.add(s);
		}
		this.fileIgnore.addAll(fileIgnore);
	}

	public RasaBot getChatbot(File mainFile) throws Exception {
		File agentFiles = null;
		if (!mainFile.isDirectory() && mainFile.getName().endsWith(".zip")) {
			agentFiles = new Unzipper(mainFile.getCanonicalPath()).unzip();
			if (agentFiles == null) {
				return null;
			}
		} else {
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
					if (!fileIgnore.contains(f.getName())) {
						if (f.getName().endsWith(".md")) {
							String info = readFile(f);
							if (info.contains("## intent:") || info.contains("## synonym:")
									|| info.contains("## regex:") || info.contains("## lookup:")) {
								String fileString = readFile(f);
								fileString = fileString.replaceAll("<!--.*-->", "");
								Node document = parser.parse(fileString);
								HtmlRenderer renderer = HtmlRenderer.builder().build();
								org.jsoup.nodes.Document html = Jsoup.parse(renderer.render(document));
								rasaBot.setNlu(html);
								// rasaBot.setNlu(readFile(f));
								hasNLU = true;
							} else {
								rasaBot.setStories(info);
								hasStories = true;
							}

						} else if (f.getName().equals("domain.yml")) {
							rasaBot.setDomain(om.readValue(f, Domain.class));
							hasDomain = true;
						} else if (f.getName().equals("config.yml") || f.getName().equals("nlu_config.yml")) {
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
			}
			files.remove(currentFile);
		}
		return rasaBot;
	}

	private String readFile(File f) {
		String text = "";
		if (f.isFile()) {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(f));
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();

			    while (line != null) {
			        sb.append(line);
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			    }
			    text = sb.toString();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (br!=null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return text;
	}

}

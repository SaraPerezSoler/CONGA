package congabase.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.xtext.botGenerator.BotStandaloneSetup;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

import generator.Bot;
import generator.GeneratorPackage;
import generator.TrainingPhrase;

public class ChatbotCountValues {
	private static final String INPUT_URI = "D:\\Desktop\\Evaluation";
	
	
	private static final String[] IGNORE_FILES = { "D:/Git/asymob/chatbots/botsInDSL" };
	private Injector injector;
	private XtextResourceSet resourceSetXtext;

	public static void main(String[] args) {

		ChatbotCountValues countValues = null;
		try {
			countValues = new ChatbotCountValues();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		File inputFile = new File(INPUT_URI);

		List<File> files = new ArrayList<File>();
		files.add(inputFile);

		while (!files.isEmpty()) {
			File f = files.get(0);
			boolean flag = false;
			for (String ignore : IGNORE_FILES) {
				if (extract(f.getAbsolutePath(), "").equals(ignore)) {
					flag = true;
					break;
				}
			}
			if (flag) {
				files.remove(f);
				continue;
			}
			if (f.isDirectory()) {
				for (File f1 : f.listFiles()) {
					files.add(f1);
				}
			} else if (f.getName().endsWith(".bot") || f.getName().endsWith(".BOT")) {
				try {
					String name = f.getName().replace(".bot", "").replace(".BOT", "");
					if (name.equals("Date")) {
						System.out.println("Date");
					}
					countValues.measure(f.getAbsolutePath());
				} catch (Exception e) {
					e.printStackTrace();
					//System.out.println("Error in " + f.getName());
				}
			}

			files.remove(f);
		}
	}

	private static URI createURI(String path, String cwd) {
		String uriString = path;
		if (uriString.startsWith("platform:/resource/"))
			return URI.createPlatformResourceURI(extract(uriString, "platform:/resource/"), true);
		if (uriString.startsWith("platform:/plugin/"))
			return URI.createPlatformPluginURI(extract(uriString, "platform:/plugin/"), true);
		if (uriString.startsWith("http:/"))
			return URI.createURI(path); // to allow loading http:/www.eclipse.org/emf/2002/Ecore,
		if (uriString.startsWith("C:"))
			return URI.createURI(extract(uriString, "C:"), true);
		if (uriString.startsWith("D:"))
			return URI.createURI(extract(uriString, "D:"), true);

		if (cwd == null)
			return URI.createURI(path);
		String absolutePath = new File(path).getAbsolutePath();
		return URI.createFileURI(absolutePath);
	}

	private static String extract(String s, String extract) {
		return s.substring(extract.length()).replaceAll("\\\\", "/");
	}

	public ChatbotCountValues() throws IOException {
		injector = new BotStandaloneSetup().createInjectorAndDoEMFRegistration();
		resourceSetXtext = injector.getInstance(XtextResourceSet.class);
		resourceSetXtext.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		resourceSetXtext.addLoadOption(XtextResource.OPTION_ENCODING, "UTF-8");
		
		if (!EPackage.Registry.INSTANCE.containsKey(GeneratorPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(GeneratorPackage.eNS_URI, GeneratorPackage.eINSTANCE);
		}
	}
	

	public void measure(String string) {
		Resource resource = resourceSetXtext.getResource(createURI(string, null), true);
		Bot bot = (Bot) resource.getContents().get(0);
		int numIntents = bot.getIntents().size();
		List<TrainingPhrase> tpList = Lists.newArrayList(IteratorExtensions.filter(bot.eAllContents(), TrainingPhrase.class));
		int numTp = tpList.size();
		int words = 0;
		for (TrainingPhrase tp: tpList) {
			words += CountTpWords(tp);
		}
		System.out.println(bot.getName()+";"+numIntents+";"+numTp+";"+words);
		
	}
	
	public int CountTpWords (TrainingPhrase tp) {
		String sentence = tp.getSentence();
		StringTokenizer tokenizer = new StringTokenizer(sentence);
		return tokenizer.countTokens();
	}
	
}

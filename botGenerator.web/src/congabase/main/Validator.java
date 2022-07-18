package congabase.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.xtext.botGenerator.BotStandaloneSetup;

import com.google.inject.Injector;

import generator.GeneratorPackage;

public class Validator {
//	private static final String INPUT_URI = "D:\\Desktop\\Rasa - copia\\xmi";
//	private static final String LOG_FILE = "D:\\Desktop\\Rasa - copia\\errors.txt";
	
	private static final String INPUT_URI = "D:\\Desktop\\Dialogflow - copia\\xmi";
	private static final String LOG_FILE = "D:\\Desktop\\Dialogflow - copia\\errors.txt";

	
	private static final String[] IGNORE_FILES = { "D:/Git/asymob/chatbots/botsInDSL" };
	private Injector injector;
	private XtextResourceSet resourceSetXtext;
	private IResourceValidator validator;
	private FileWriter outputWriter;

	public static void main(String[] args) {

		Validator validator = null;
		try {
			validator = new Validator(LOG_FILE);
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
					List<Issue>issues = validator.validate(f.getAbsolutePath());
					validator.printIssues(name, issues);
				} catch (Exception e) {
					e.printStackTrace();
					//System.out.println("Error in " + f.getName());
				}
			}

			files.remove(f);
		}
		try {
			validator.close();
		} catch (IOException e) {
			e.printStackTrace();
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

	public Validator(String outputFile) throws IOException {
		injector = new BotStandaloneSetup().createInjectorAndDoEMFRegistration();
		resourceSetXtext = injector.getInstance(XtextResourceSet.class);
		resourceSetXtext.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		resourceSetXtext.addLoadOption(XtextResource.OPTION_ENCODING, "UTF-8");
		
		validator = injector.getInstance(IResourceValidator.class);
		
		if (!EPackage.Registry.INSTANCE.containsKey(GeneratorPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(GeneratorPackage.eNS_URI, GeneratorPackage.eINSTANCE);
		}
		
		File output = new File(outputFile);
	    output.createNewFile();
	    this.outputWriter = new FileWriter(output);
	}

	public List<Issue> validate(String string) {
		// Load the resource
		Resource resource = resourceSetXtext.getResource(createURI(string, null), true);

		// Validate the resource
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		
		return list;
	}
	
	public void printIssues(String name, List<Issue> issues) throws IOException {
		if (issues.isEmpty()) {
			this.outputWriter.write(name+"\tValidation successful\n");
		}
		for (Issue i: issues) {
			this.outputWriter.write(name+"\t"+i.getSeverity()+"\t"+i.getLineNumber()+"\t"+i.getMessage()+"\n");
		}
	     
	}
	
	public void close() throws IOException {
		this.outputWriter.close();
	}
}

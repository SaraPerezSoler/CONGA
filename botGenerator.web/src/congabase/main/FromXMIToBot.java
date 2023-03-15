package congabase.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.xtext.botGenerator.BotStandaloneSetup;

import com.google.inject.Injector;

import generator.GeneratorPackage;

public class FromXMIToBot {

	private static final String INPUT_URI = "D:\\Desktop\\Dialogflow - copia\\xmi";
	private static final String OUTPUT_URI = "D:\\Desktop\\Dialogflow - copia\\xmi";

//	private static final String INPUT_URI = "D:\\Desktop\\Rasa - copia";
//	private static final String OUTPUT_URI = "D:\\Desktop\\Rasa - copia";
	
	private static final String [] IGNORE_FILES = {"D:/Git/asymob/chatbots/botsInDSL"};
	
	private static String baseInputFile;
	private ResourceSet resourceSet;
	private Injector injector;
	private XtextResourceSet resourceSetXtext;

	public static void main(String[] args) {

		FromXMIToBot parser = new FromXMIToBot();
		File inputFile = new File(INPUT_URI);
		if (!inputFile.isDirectory()) {
			baseInputFile = extract(inputFile.getParent(), "");
		}else {
			baseInputFile = extract(INPUT_URI, "");
		}
		List<File> files = new ArrayList<File>();
		files.add(inputFile);

		while (!files.isEmpty()) {
			File f = files.get(0);
			boolean flag = false;
			for (String ignore: IGNORE_FILES) {
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
			} else if (f.getName().endsWith(".xmi") || f.getName().endsWith(".XMI")) {

				try {
				String filepath = extract(f.getAbsolutePath(), "");
				String fileName = extract(filepath, baseInputFile);
				parser.XmiToDsl(f.getAbsolutePath(), OUTPUT_URI+"/"+fileName.replace(".xmi", ".bot"));
				}catch (Exception e) {
					System.out.println("Error in "+ f.getName());
				}

			}

			files.remove(f);
		}
	}

	public FromXMIToBot() {
		resourceSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		injector = new BotStandaloneSetup().createInjectorAndDoEMFRegistration();
		resourceSetXtext = injector.getInstance(XtextResourceSet.class);
		resourceSetXtext.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		//resourceSetXtext.addLoadOption(XtextResource.OPTION_ENCODING, "UTF-8");

		if (!EPackage.Registry.INSTANCE.containsKey(GeneratorPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(GeneratorPackage.eNS_URI, GeneratorPackage.eINSTANCE);
		}
	}

	public void XmiToDsl(String inputUri, String outputUri) {

		// Source
		Resource resourceXmi = resourceSet.getResource(createURI(inputUri, null), true);

		// Create new target file
		Resource resourceDsl = resourceSetXtext.createResource(createURI(outputUri, null));

		// Copy content
		resourceDsl.getContents().addAll(resourceXmi.getContents());

		try {
			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XtextResource.OPTION_ENCODING, "UTF-8");
			resourceDsl.save(options);

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

}

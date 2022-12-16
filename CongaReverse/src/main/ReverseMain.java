package main;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import generator.Bot;
import generator.GeneratorPackage;
import parser.Chatbot;
import parser.DialogflowReverse;
import parser.RasaReverse;
import parser.Reverse;

public class ReverseMain {

	private static final String DIALOGFLOW = "DIALOGFLOW";
	private static final String RASA = "RASA";
	public static ResourceSet resourceSet;
	
	public static void main(String[] args) {
		if (args.length < 2) {
			System.err.println("No chatbot file provided or tool name (Dialogflow or Rasa)");
			System.exit(-1);
		}
		Reverse parser = null;
		String fileName = null;
		String parserName = null;
		if (args[0].toUpperCase().equals(DIALOGFLOW)) {
			parser = new DialogflowReverse();
			parserName = args[0];
			fileName = args[1];
		} else if (args[0].toUpperCase().equals(RASA)) {
			parser = new RasaReverse();
			parserName = args[0];
			fileName = args[1];
		} else if (args[1].toUpperCase().equals(DIALOGFLOW)) {
			parser = new DialogflowReverse();
			parserName = args[1];
			fileName = args[0];
		} else if (args[1].toUpperCase().equals(RASA)) {
			parser = new RasaReverse();
			parserName = args[1];
			fileName = args[0];
		}else {
			System.err.println("No tool name provided");
			System.exit(-1);
		}

		File file = new File(fileName);
		if (file.exists()) {
			try {
				Chatbot agent = parser.getChatbot(file);
				Bot bot = agent.getBot();
				
				String resorcePath = fileName.replace(".zip", ".xmi");
				Resource resource = getResourceSet().createResource(URI.createFileURI(resorcePath));
				resource.getContents().add(bot);
				try {
					resource.save(null);
				} catch (IOException e) {
					System.err.println("Error saving the chatbot " + fileName + " using " + parserName);
					System.exit(-1);
				}
				
			} catch (Exception e) {
				System.err.println("Error reading the chatbot " + fileName + " using " + parserName);
				System.exit(-1);
			}
		}else {
			System.err.println("The file " + fileName + " does not exit");
			System.exit(-1);
		}
	}
	
	public static ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();

			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
					new XMIResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
					new XMIResourceFactoryImpl());
			
			if (!EPackage.Registry.INSTANCE.containsKey(GeneratorPackage.eNS_URI)) {
				EPackage.Registry.INSTANCE.put(GeneratorPackage.eNS_URI, GeneratorPackage.eINSTANCE);
			}

		}
		return resourceSet;
	}

}

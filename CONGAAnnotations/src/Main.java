import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import congaAnnotation.Annotation;
import congaAnnotation.IntentIntentValue;
import congaAnnotation.IntentValue;
import congaAnnotation.SemanticSimilarity;
import generator.Bot;
import generator.GeneratorPackage;

public class Main {
	private static ResourceSet resourceSet = null;
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

	public static void main(String[] args) throws Exception {
		String strPathIn, strPathOut;
		
		if (args.length == 2) {
			strPathIn = args[0];
			strPathOut = args[1];
		} else {
			System.err.println("The program needs 2 argument: <file_path> <dest_path>");
			return;
		}
		Bot bot = loadChatbot(strPathIn);
		File file = new File(strPathIn);
		String name = file.getName();
		if (bot != null) {
			// Aqui tienes la lista de matrices de confusion, una por lenguaje,
			// En principio lo más normal es que solo haya 1: ingles.
			Annotation annotation = GenerateAnnotations.calculateAnnotation(bot);
			String name1 = name.replace(".xmi", "Annotated.xmi");
			saveAnnotation(strPathOut, name1, annotation);
			name1 = name.replace(".xmi", "");
			generateStringFiles(strPathOut, name1, annotation);
			annotation.getSemanticSimilarities().clear();
			annotation.getTpAvgSims().clear();
			annotation.getTpIntentAvgSims().clear();
			name1 = name.replace(".xmi", "AnnotatedShort.xmi");
			saveAnnotation(strPathOut, name1, annotation);
		}
	}

	public static Bot loadChatbot(String src) throws Exception {
		File file = new File(src);
		if (!file.exists()) {
			System.err.println("The provided file does not exist");
			throw new Exception("The provided file does not exist");
		}
		Resource resource;
		resource = getResourceSet().getResource(URI.createFileURI(src), true);
		Bot bot = (Bot) resource.getContents().get(0);
		return bot;
	}
	
	public static void saveAnnotation(String src, String name, Annotation annotation) throws Exception {
		File file = new File(src);
		if (!file.exists()) {
			System.err.println("The provided file does not exist");
			throw new Exception("The provided file does not exist");
		}
		Resource resource;
		
		resource = getResourceSet().createResource(URI.createFileURI(src+"//"+name));
		resource.getContents().add(annotation);
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void generateStringFiles(String src, String name, Annotation annotation) throws Exception {
		File file = new File(src);
		if (!file.exists()) {
			System.err.println("The provided file does not exist");
			throw new Exception("The provided file does not exist");
		}
		FileWriter fichero = new FileWriter(src+"/"+name+"TPSimilaty.txt");
		PrintWriter pw = new PrintWriter(fichero);
		for (SemanticSimilarity ss: annotation.getSemanticSimilarities()) {
			pw.println(ss.getSimilarity());
			pw.println(ss.getTrainingPhrase1().getSentence());
			pw.println(ss.getTrainingPhrase2().getSentence());
			pw.println("---------------------------------------------------------------------------");
		}
		
		pw.close();
		
		fichero = new FileWriter(src+"/"+name+"IntentValues.txt");
		pw = new PrintWriter(fichero);
		for (IntentValue iv: annotation.getIntentValues()) {
			pw.println(iv.getIntent().getName());
			pw.println("Min1: "+iv.getMin1Value()+" --> "+iv.getMin1().getSentence());
			pw.println("Min2: "+iv.getMin2Value()+" --> "+iv.getMin2().getSentence());
			pw.println("Max1: "+iv.getMax1Value()+" --> "+iv.getMax1().getSentence());
			pw.println("Max2: "+iv.getMax2Value()+" --> "+iv.getMax2().getSentence());
			pw.println("---------------------------------------------------------------------------");
		}
		pw.close();
		
		fichero = new FileWriter(src+"/"+name+"IntentIntentValues.txt");
		pw = new PrintWriter(fichero);
		for (IntentIntentValue iiv: annotation.getIntentIntentValues()) {
			pw.println(iiv.getIntent1().getName()+" vs "+iiv.getIntent2().getName());
			pw.println("Min1: "+iiv.getMin1Value()+" --> "+iiv.getMin1().getSentence());
			pw.println("Min2: "+iiv.getMin2Value()+" --> "+iiv.getMin2().getSentence());
			pw.println("Max1: "+iiv.getMax1Value()+" --> "+iiv.getMax1().getSentence());
			pw.println("Max2: "+iiv.getMax2Value()+" --> "+iiv.getMax2().getSentence());
			pw.println("---------------------------------------------------------------------------");
		}
		pw.close();
	}

}

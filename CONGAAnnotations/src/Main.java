import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import congaAnnotation.Annotation;
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
			saveAnnotation(strPathOut, name, annotation);
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
		name = name.replace(".xmi", "Annotated.xmi");
		resource = getResourceSet().createResource(URI.createFileURI(src+"//"+name));
		resource.getContents().add(annotation);
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

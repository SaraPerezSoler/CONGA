package es.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import generator.GeneratorPackage;

public class CongaServices {

	private static String FOLDER_PATH = null;
	private String path;
	private String name;
	private static ResourceSet resourceSet = null;
	public static List<File> remove = new ArrayList<File>();
	private Resource resource = null;

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

	public CongaServices(String folderPath, File file, String botName) {
		removePrevius();
		if (FOLDER_PATH == null) {
			FOLDER_PATH = folderPath;
			File file1 = new File(FOLDER_PATH);
			if (!file1.exists()) {
				file1.mkdirs();
			}
		}
		String countString = "";
		int count = 0;
		File file2 = null;
		do {
			name = botName + countString;
			path = FOLDER_PATH + File.separator + name + ".xmi";
			file2 = new File(path);
			count++;
			countString = Integer.toString(count);
		} while (file2.exists());
		file.renameTo(file2);
		this.resource = getResourceSet().getResource(URI.createURI(path), true);
	}

	private void removePrevius() {
		for (File f : remove) {
			if (f.exists()) {
				removeFile(f);
			}
		}
		remove.clear();

	}

	private void removeFile(File file) {
		File[] contents = file.listFiles();
		if (contents != null) {
			for (File f : contents) {
				removeFile(f);
			}
		}
		file.delete();
	}

	public Resource getResource() {
		return resource;
	}
	
	public String getName() {
		return name;
	}

	public void destroy() {
		try {
			resource.delete(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if (file.exists()) {
//			file.delete();
//		}
	}

}

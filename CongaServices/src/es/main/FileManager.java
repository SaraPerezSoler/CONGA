package es.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import generator.GeneratorPackage;

public abstract class FileManager {
	protected static String FOLDER_PATH = null;
	private String path;
	private String name;
	private String ext;
	public static List<File> remove = new ArrayList<File>();
	private static ResourceSet resourceSet = null;

	public static ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();

			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
					new XMIResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
					new XMIResourceFactoryImpl());
//			resourceSet.getLoadOptions().put(XMIResource.OPTION_ENCODING, "UTF-8");
			if (!EPackage.Registry.INSTANCE.containsKey(GeneratorPackage.eNS_URI)) {
				EPackage.Registry.INSTANCE.put(GeneratorPackage.eNS_URI, GeneratorPackage.eINSTANCE);
			}

		}
		return resourceSet;
	}

	public FileManager(String folderPath, File file, String fname) {
		removePrevius();
		if (FOLDER_PATH == null) {
			FOLDER_PATH = folderPath;
			File file1 = new File(FOLDER_PATH);
			if (file1.exists()) {
				removeFile(file1);
			}
			file1.mkdirs();
		}
		String countString = "";
		int count = 0;
		File file2 = null;
		String[] split = fname.split("\\.");
		String auxName;
		if (split.length == 2) {
			auxName = split[0];
			ext = "." + split[1];
		} else {
			auxName = fname;
			ext = "";
		}
		do {

			name = auxName + countString;
			path = FOLDER_PATH + File.separator + name + ext;
			file2 = new File(path);
			count++;
			countString = Integer.toString(count);
		} while (file2.exists());
		file.renameTo(file2);
	}

	private void removePrevius() {
		for (File f : remove) {
			if (f.exists()) {
				removeFile(f);
			}
		}
		remove.clear();

	}

	protected void removeFile(File file) {
		File[] contents = file.listFiles();
		if (contents != null) {
			for (File f : contents) {
				removeFile(f);
			}
		}
		file.delete();
	}

	public void destroy() {
		remove.add(getFile());
	}

	public File getFile() {
		return new File(path);
	}

	public String getPath() {
		return path;
	}

	public String getName() {
		return name;
	}
}

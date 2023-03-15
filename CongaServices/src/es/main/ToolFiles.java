package es.main;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import generator.Bot;

public class ToolFiles extends FileManager{

	private String resorcePath;
	public ToolFiles(String folderPath, File file, String fname) {
		super (folderPath, file, fname);
	}

	public File createResource(Bot bot) {
		resorcePath = FOLDER_PATH+File.separator+getName()+".xmi";
		Resource resource = getResourceSet().createResource(URI.createFileURI(resorcePath));
		resource.getContents().add(bot);
		try {
			resource.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new File(resorcePath);
	}
	
	@Override
	public void destroy() {
		remove.add(new File(resorcePath));
		remove.add(getFile());
		super.destroy();
	}
	
	public void clean() {
		removeFile(getFile());
		super.destroy();
	}
}

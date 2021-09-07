package es.main;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class CongaResource extends FileManager{

	private Resource resource = null;

	public CongaResource(String folderPath, File file, String botName) {
		super (folderPath, file, botName+".xmi");
		this.resource = getResourceSet().getResource(URI.createURI(super.getPath()), true);
	}


	public Resource getResource() {
		return resource;
	}

	public void destroy() {
		try {
			resource.delete(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

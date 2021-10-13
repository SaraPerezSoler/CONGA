package botGenerator.web.xtextServlets;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.persistence.ResourceBaseProviderImpl;

import congabase.Project;
import congabase.main.CongaData;
/**
 * @author Sara Pérez Soler
 * 
 * Indicates to XText the resource path
 * 
 * **/
public class MyResourceBaseProvider implements IResourceBaseProvider {
	private final String resourceBase;

	public MyResourceBaseProvider(String resourceBase) {
		this.resourceBase = resourceBase;
	}

	@Override
	public URI getFileURI(String resourceId) {
		
			Project p = getProject(resourceId);
			if (p==null) {
				return new ResourceBaseProviderImpl(resourceBase).getFileURI(resourceId);
			}
			try {
				return URI.createFileURI(CongaData.getCongaData((String)null).getProjectFilePath(p));
			} catch (Exception e) {
				return new ResourceBaseProviderImpl(resourceBase).getFileURI(resourceId);
			}
	}

	public static Project getProject(String resourceId) {
		String[] splits = resourceId.split("/");
		if (splits.length != 2) {
			return null;
		}
		try {
			String user = splits[0];
			String project = splits[1].substring(0, splits[1].indexOf("."));
			Project p = CongaData.getCongaData((String)null).getProject(user, project); 
			return p;
		} catch (Exception e) {
			return null;
		}
	}

}

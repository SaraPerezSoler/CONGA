package botGenerator.web;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;
import org.eclipse.xtext.web.server.persistence.ResourceBaseProviderImpl;

import congabase.Project;
import congabase.main.CongaData;

public class MyResourceBaseProvider implements IResourceBaseProvider {
	private final String resourceBase;

	public MyResourceBaseProvider(String resourceBase) {
		this.resourceBase = resourceBase;
	}

	@Override
	public URI getFileURI(String resourceId) {
		String[] splits = resourceId.split("/");
		if (splits.length != 2) {
			return new ResourceBaseProviderImpl(resourceBase).getFileURI(resourceId);
		}
		try {
			String user = splits[0];
			String project = splits[1];
			Project p = CongaData.getCongaData((String)null).getProject(user, project);
			return URI.createFileURI(CongaData.getCongaData((String)null).getProjectFilePath(p));
			
		} catch (Exception e) {
			return new ResourceBaseProviderImpl(resourceBase).getFileURI(resourceId);
		}

	}

}

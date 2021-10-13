package botGenerator.web.xtextServlets;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;

import com.google.inject.Inject;

import congabase.Project;
import congabase.main.CongaData;

/**
 * @author Sara Pérez Soler
 * 
 * When a resource is modified, change the CONGA modification date
 * 
 * **/
public class MyFileResourceHandler extends org.eclipse.xtext.web.server.persistence.FileResourceHandler {
	@Inject
	private IResourceBaseProvider resourceBaseProvider;
	@Override
	public void put(IXtextWebDocument document, IServiceContext serviceContext) throws IOException {
		Project project;
		if (resourceBaseProvider instanceof MyResourceBaseProvider) {
			project = ((MyResourceBaseProvider)resourceBaseProvider).getProject(document.getResourceId());
			if (project != null) {
				try {
					CongaData.getCongaData((ServletContext)null).updateModified(project);
				} catch (Exception e) {
				}
			}
		}
		super.put(document, serviceContext);
	}
}

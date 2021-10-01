package botGenerator.web.xtextServlets;

import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;

public class MyXtextServiceDispatcher extends XtextServiceDispatcher {
	
	@Override
	public ServiceDescriptor getService(IServiceContext context) throws InvalidRequestException {
		String serviceType = context.getParameter("clear");
		if (serviceType!=null) {
			if (serviceType.equalsIgnoreCase("true")) {
				getResourceDocument(getResourceID(context), context).clearCachedServiceResults();
			}
		}
		
		return super.getService(context);
	}

}

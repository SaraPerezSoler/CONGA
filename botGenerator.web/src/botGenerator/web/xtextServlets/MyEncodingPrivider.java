package botGenerator.web.xtextServlets;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.parser.IEncodingProvider;

public class MyEncodingPrivider implements IEncodingProvider{

	@Override
	public String getEncoding(URI uri) {
		return "UTF-8";
	}
	

}

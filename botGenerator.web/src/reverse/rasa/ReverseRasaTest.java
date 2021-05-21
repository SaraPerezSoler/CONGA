package reverse.rasa;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import botGenerator.web.xtextServlets.BotServlet;
import generator.Bot;

public class ReverseRasaTest {
	public static void main(String[] args) throws IOException {
	
		File f = new File ("D:\\git\\VetClinic\\RasaBot");
		try {
			//RasaBot bot = new ReadRasaBot().getBot(f);
			Bot bot = new ReadRasaBot().getBot(f).getRasaBot();
			
			Injector injector = BotServlet.getInjector();
			XtextResourceSet resourceSetXtext = injector.getInstance(XtextResourceSet.class);
			resourceSetXtext.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
			Resource resource = resourceSetXtext.createResource(URI.createURI(bot.getName()+".bot"));
			resource.getContents().add(bot);
			resource.save(null);
			
			System.out.println("sdfsdf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

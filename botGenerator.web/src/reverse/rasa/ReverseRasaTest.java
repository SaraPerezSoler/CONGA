package reverse.rasa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import botGenerator.web.xtextServlets.BotServlet;
import generator.Bot;

public class ReverseRasaTest {
	public static void main(String[] args) throws IOException {
	
		List<String> fileIgnore = new ArrayList<>();
		fileIgnore.add("readme.md");
		fileIgnore.add("README.md");
		fileIgnore.add("Readme.md");
		File f = new File ("D:\\Desktop\\Rasa Examples\\1.10\\GitHub\\Building-a-Conversational-Chatbot-for-Slack-using-Rasa-and-Python-master");
		try {
			//RasaBot bot = new ReadRasaBot().getBot(f);
			Bot bot = new ReadRasaBot(fileIgnore).getBot(f).getRasaBot();
			
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

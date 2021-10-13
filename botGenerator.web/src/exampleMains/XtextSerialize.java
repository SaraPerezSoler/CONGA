package exampleMains;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.xtext.botGenerator.BotStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import com.google.inject.Injector;

import generator.Bot;
import generator.GeneratorPackage;


/**
 * @author Sara Pérez Soler
 * 
 * A test main
 * 
 * **/

public class XtextSerialize {

	public static void init() {
	    new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");

	    // Register respective language(s)
	    if (!EPackage.Registry.INSTANCE.containsKey(GeneratorPackage.eNS_URI)) {
	      EPackage.Registry.INSTANCE.put(GeneratorPackage.eNS_URI, GeneratorPackage.eINSTANCE);
	    }
	    
	    
	  }

	  public static void DslToXmi(String inputUri, String outputUri) {
	    init();

	    // Source
	    Injector injector = new BotStandaloneSetup().createInjectorAndDoEMFRegistration();
	    XtextResourceSet resourceSetXtext = injector.getInstance(XtextResourceSet.class);
	    resourceSetXtext.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
	    Resource resourceInput = resourceSetXtext.getResource(URI.createURI(inputUri), true);

	    // Create new target file
	    ResourceSet resourceSet = new ResourceSetImpl();
	    Resource resourceXmi = resourceSet.createResource(URI.createURI(outputUri));

	    // Copy content
	    resourceXmi.getContents().addAll(resourceInput.getContents());

	    try {
	      Map<String, String> options = new HashMap<String, String>();
	      options.put(XMLResource.OPTION_ENCODING, "UTF-8");

	      resourceXmi.save(options);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }

	  public static void XmiToDsl(String inputUri, String outputUri) {
	    init();

	    // Source
	    ResourceSet resourceSet = new ResourceSetImpl();
	    Resource resourceXmi = resourceSet.getResource(URI.createURI(inputUri), true);

	    // Create new target file
	    Injector injector = new BotStandaloneSetup().createInjectorAndDoEMFRegistration();
	    XtextResourceSet resourceSetXtext = injector.getInstance(XtextResourceSet.class);
	   resourceSetXtext.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
	    Resource resourceDsl = resourceSetXtext.createResource(URI.createURI(outputUri));

	    // Copy content
	    resourceDsl.getContents().addAll(resourceXmi.getContents());
	    
	    try {
	      resourceDsl.save(Collections.emptyMap());
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	  
		public static Resource SaveDSLBot(Bot bot, String outputUri) {
			init();
			// Create new target file
			Injector injector = new BotStandaloneSetup().createInjectorAndDoEMFRegistration();
			XtextResourceSet resourceSetXtext = injector.getInstance(XtextResourceSet.class);
			resourceSetXtext.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
			Resource resourceDsl = resourceSetXtext.createResource(URI.createURI(outputUri));

			// Copy content
			resourceDsl.getContents().add(bot);

			try {
				resourceDsl.save(Collections.emptyMap());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return resourceDsl;
		}
}

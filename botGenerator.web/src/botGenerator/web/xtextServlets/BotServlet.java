/*
 * generated by Xtext 2.23.0
 */
package botGenerator.web.xtextServlets;

import com.google.inject.Injector;

import congabase.main.CongaData;
import generator.GeneratorPackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.util.DisposableRegistry;
import org.eclipse.xtext.web.servlet.XtextServlet;

/**
 * Deploy this class into a servlet container to enable DSL-specific services.
 */
@WebServlet(name = "XtextServices", urlPatterns = "/xtext-service/*")
public class BotServlet extends XtextServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Injector injector;
	DisposableRegistry disposableRegistry;
	
	public void init() throws ServletException {
		super.init();
		
		this.disposableRegistry = getInjector().getInstance(DisposableRegistry.class);
		
		try {
			CongaData.getCongaData(getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		if (disposableRegistry != null) {
			disposableRegistry.dispose();
			disposableRegistry = null;
		}
		super.destroy();
	}
	public static Injector getInjector () {
		if (injector == null) {
			injector = new BotWebSetup().createInjectorAndDoEMFRegistration();
		}
		
		if (!EPackage.Registry.INSTANCE.containsKey(GeneratorPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(GeneratorPackage.eNS_URI, GeneratorPackage.eINSTANCE);
		}
		
		
		return injector;
	}
	
}

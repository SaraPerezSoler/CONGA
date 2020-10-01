package congabase.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.xtext.botGenerator.BotStandaloneSetup;
import org.xtext.botGenerator.generator.BotGenerator;

import com.google.inject.Injector;

import congabase.CongaSystem;
import congabase.CongabaseFactory;
import congabase.CongabasePackage;
import congabase.Project;
import congabase.User;
import congabase.exception.FatalException;
import generator.Bot;
import recommenderQuestionnaire.Questionnaire;
import recommenderQuestionnaire.RecommenderQuestionnairePackage;

public class CongaData {

	private static final String FILENAME = "CONGA.xmi";
	private static final String RECOMMENDER_FILE = "RecomenderModel.xmi";
	private static ResourceSet resourceSet = null;
	private static CongaData congaData;
	private static String PATH;

	private CongaSystem conga;
	private Resource resource;

	public static ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();

			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
					new XMIResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
					new XMIResourceFactoryImpl());
			if (!EPackage.Registry.INSTANCE.containsKey(RecommenderQuestionnairePackage.eNS_URI)) {
				EPackage.Registry.INSTANCE.put(RecommenderQuestionnairePackage.eNS_URI,
						RecommenderQuestionnairePackage.eINSTANCE);
			}
			if (!EPackage.Registry.INSTANCE.containsKey(CongabasePackage.eNS_URI)) {
				EPackage.Registry.INSTANCE.put(CongabasePackage.eNS_URI, CongabasePackage.eINSTANCE);
			}

		}
		return resourceSet;
	}

	public static String getPath() {
		return PATH;
	}

	public static CongaData getCongaData(ServletContext context) throws Exception {
		if (context != null) {
			String path = context.getInitParameter("project.files");
			return getCongaData(path);
		}
		return getCongaData((String) null);
	}

	public static CongaData getCongaData(String path) throws Exception {
		if (congaData == null) {
			if (path != null) {
				PATH = path;
				congaData = new CongaData(PATH);
				BotGenerator.newPath(PATH);

			}
		}
		return congaData;
	}

	private CongaData(String path) throws FatalException {
		File file = new File(path + "/" + FILENAME);
		if (file.exists()) {
			try {
				resource = getResourceSet().getResource(URI.createURI(path + "/" + FILENAME), true);
				conga = (CongaSystem) resource.getContents().get(0);
			} catch (Exception e) {
				e.printStackTrace();
				throw new FatalException("In class " + this.getClass().getName() + ": the file " + path + "/" + FILENAME
						+ " can be opened: ");
			}
		} else {
			this.resource = getResourceSet().createResource(URI.createURI(path + "/" + FILENAME));
			conga = CongabaseFactory.eINSTANCE.createCongaSystem();
			resource.getContents().add(conga);
			newUser("admin", "adminadmin");
			Resource qresource = getResourceSet().getResource(URI.createFileURI(path +"/"+RECOMMENDER_FILE), true);
			Questionnaire questionnaire = (Questionnaire) qresource.getContents().get(0);
			conga.setQuestionnaire(questionnaire);
		}

		save();
	}

	public void save() {
		try {
			resource.save(null);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Project newProject(String name, User owner) throws IOException {

		if (owner.get(name) != null) {
			return owner.get(name);
		}

		Project project = CongabaseFactory.eINSTANCE.createProject();
		project.setName(name);
		project.setOwner(owner);
		conga.getProjects().add(project);

		File botFolder = new File(getProjectFolderPath(project));
		if (!botFolder.exists()) {
			botFolder.mkdirs();
		}

		File botFile = new File(getProjectFilePath(project));
		if (botFile.exists()) {
			botFile.delete();
		}
		botFile.createNewFile();

		File startFile = new File(PATH + "/example1.bot");
		InputStream in = new FileInputStream(startFile);
		OutputStream out = new FileOutputStream(botFile);

		byte[] buf = new byte[1024];
		int len;

		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();

		Injector injector = new BotStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSetXtext = injector.getInstance(XtextResourceSet.class);
		resourceSetXtext.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSetXtext.getResource(URI.createURI(getProjectFilePath(project)), true);
		Bot bot = (Bot) resource.getContents().get(0);
		bot.setName(name);
		resource.save(null);

		save();
		return project;
	}

	public User newUser(String nick, String password) {
		User user = getUser(nick);
		if (user != null) {
			return user;
		}
		user = CongabaseFactory.eINSTANCE.createUser();
		user.setNick(nick);
		user.setPassword(password);
		conga.getUsers().add(user);
		save();
		return user;
	}

	public String getProjectFilePath(Project project) {
		return getProjectFolderPath(project) + "/" + project.getName() + ".bot";
	}

	public String getProjectFolderPath(Project project) {
		return PATH + "/" + project.getOwner().getNick() + "/" + project.getName();
	}

	public Project getProject(String user, String project) {
		User u = getUser(user);
		if (u != null) {
			return u.get(project);
		}
		return null;
	}

	public User getUser(String user) {
		return conga.getUser(user);
	}
}

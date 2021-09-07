package congabase.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.xtext.botGenerator.generator.BotGenerator;

import com.google.common.io.Files;
import com.google.inject.Injector;

import botGenerator.web.xtextServlets.BotServlet;
import congabase.AQuestion;
import congabase.CongaSystem;
import congabase.CongabaseFactory;
import congabase.CongabasePackage;
import congabase.KeyValue;
import congabase.Project;
import congabase.RelevanceLevel;
import congabase.Service;
import congabase.ServiceStatus;
import congabase.ServiceType;
import congabase.User;
import congabase.UserAnswer;
import congabase.exception.FatalException;
import congabase.plantUML.CreateFlowsDiagram;
import congabase.plantUML.UML;
import generator.Bot;
import generator.Language;
import recommenderQuestionnaire.Evaluation;
import recommenderQuestionnaire.Option;
import recommenderQuestionnaire.Question;
import recommenderQuestionnaire.Questionnaire;
import recommenderQuestionnaire.RecommenderQuestionnairePackage;
import recommenderQuestionnaire.Tool;
import recommenderQuestionnaire.evaluations.Evaluator;

public class CongaData {

	private static final String FILENAME = "CONGA.xmi";
	private static final String RECOMMENDER_FILE = "RecomenderModel.xmi";
	private static ResourceSet resourceSet = null;
	private static CongaData congaData;
	private static String PATH;
	private static long lastServiceId = 0;

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

	public Map<String, List<Service>> supportedGeneratorTools() {
		Map<String, List<Service>> ret = new HashMap<>();
		for (Service service : conga.getGenerators()) {
			if (service.getStatus() == ServiceStatus.ON) {
				List<Service> services = ret.get(service.getTool().getName());
				if (services == null) {
					services = new ArrayList<>();
					ret.put(service.getTool().getName(), services);
				}
				services.add(service);
			}
		}
		return ret;
	}
	
	public Map<String, List<Service>> supportedParserTools() {
		Map<String, List<Service>> ret = new HashMap<>();
		for (Service service : conga.getConverters()) {
			if (service.getStatus() == ServiceStatus.ON) {
				List<Service> services = ret.get(service.getTool().getName());
				if (services == null) {
					services = new ArrayList<>();
					ret.put(service.getTool().getName(), services);
				}
				services.add(service);
			}
		}
		return ret;
	}

	public List<Tool> getAllTools() {
		return conga.getQuestionnaire().getTools();
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
				BotGenerator.setIsPlugin(false);

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
				setLastServiceId();
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
			newUser("Sara", "friends");
			Resource qresource = getResourceSet().getResource(URI.createFileURI(path + "/" + RECOMMENDER_FILE), true);
			Questionnaire questionnaire = (Questionnaire) qresource.getContents().get(0);
			conga.setQuestionnaire(questionnaire);
		}
		Questionnaire questionnaire = conga.getQuestionnaire();
		try {
			Evaluator.loadEvaluators(questionnaire);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			throw new FatalException("Can not load the evaluators");
		}
		save();
	}

	public void setLastServiceId() {
		List<Service> services = new ArrayList<>();
		services.addAll(conga.getConverters());
		services.addAll(conga.getGenerators());
		services.addAll(conga.getValidators());
		Collections.sort(services, new Comparator<Service>() {

			@Override
			public int compare(Service o1, Service o2) {
				return Long.compare(o1.getServiceId(), o2.getServiceId());
			}

		});
		if (services.isEmpty()) {
			lastServiceId = 0;
		} else {
			lastServiceId = services.get(services.size() - 1).getServiceId() + 1;
		}
	}

	public void save() {
		try {
			resource.save(null);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void delProject(String userString, String project) {
		User user = getUser(userString);
		if (user == null) {
			return;
		}
		Project p = user.get(project);
		if (project == null) {
			return;
		}

		File botFile = new File(getProjectFilePath(p));
		if (botFile.exists()) {
			botFile.delete();
		}

		File botFolder = new File(getProjectFolderPath(p));
		if (botFolder.exists()) {
			deleteFolder(botFolder);
		}
		user.getProjects().remove(p);
		conga.getProjects().remove(p);
		save();
	}

	public void delService(String userString, String serviceId) {
		User user = getUser(userString);
		if (user == null) {
			return;
		}
		Service service = getService(userString, serviceId);
		if (service == null) {
			return;
		}
		user.getServices().remove(service);
		if (service.getType() == ServiceType.CONVERTER) {
			conga.getConverters().remove(service);
		} else if (service.getType() == ServiceType.GENERATOR) {
			conga.getGenerators().remove(service);
		} else {
			conga.getValidators().remove(service);
		}
		save();
	}

	private void deleteFolder(File file) {
		if (!file.exists()) {
			return;
		}
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				deleteFolder(f);
			}
		}

		file.delete();
	}

	public Project newProject(String projectName, String userString, String language) throws IOException {
		User user = getUser(userString);
		if (user == null) {
			return null;
		}
		return newProject(projectName, user, language);
	}

	public Project newProject(String name, User owner, String language) throws IOException {

		if (owner.get(name) != null) {
			return owner.get(name);
		}

		Project project = CongabaseFactory.eINSTANCE.createProject();
		project.setName(name);
		project.setOwner(owner);
		project.setCreationDate(new Date());
		project.setModificationDate(new Date());
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

		File startFile = new File(PATH + "/example2.bot");
		InputStream in = new FileInputStream(startFile);
		OutputStream out = new FileOutputStream(botFile);

		byte[] buf = new byte[1024];
		int len;

		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();

		Resource resource = getProjectResource(project);
		Bot bot = (Bot) resource.getContents().get(0);
		bot.setName(name);
		bot.getLanguages().clear();
		bot.getLanguages().add(Language.get(language));
		resource.save(null);

		save();
		return project;
	}

	public Service newService(String userString, String url, String tool, String version, String type, String auth_key,
			String auth_value, Map<String, String> headers) {
		User user = getUser(userString);
		if (user == null) {
			return null;
		}

		Service service = CongabaseFactory.eINSTANCE.createService();
		service.setUrl(url);
		service.setServiceId(lastServiceId);
		lastServiceId++;
		service.setStatus(ServiceStatus.ON);
		service.setTool(getTool(tool));
		ServiceType sType = ServiceType.valueOf(type.toUpperCase());
		service.setType(sType);
		service.setUser(user);
		service.setVersion(version);
		if (!auth_key.isEmpty() && !auth_key.isBlank()) {
			KeyValue keyValue = CongabaseFactory.eINSTANCE.createKeyValue();
			keyValue.setKey(auth_key);
			keyValue.setValue(auth_value);
			service.setBasicAuth(keyValue);
		}
		for (String key : headers.keySet()) {
			KeyValue keyValue = CongabaseFactory.eINSTANCE.createKeyValue();
			keyValue.setKey(key);
			keyValue.setValue(headers.get(key));
			service.getHeaders().add(keyValue);
		}

		if (sType == ServiceType.GENERATOR) {
			conga.getGenerators().add(service);
		} else if (sType == ServiceType.VALIDATOR) {
			conga.getValidators().add(service);
		} else {
			conga.getConverters().add(service);
		}
		save();
		return service;
	}

	public Service modifyService(String serviceId, String userString, String url, String tool, String version,
			String type, String auth_key, String auth_value, Map<String, String> headers) {
		Service service = getService(userString, serviceId);
		if (service != null) {
			service.setUrl(url);
			service.setStatus(ServiceStatus.ON);
			service.setTool(getTool(tool));
			ServiceType sType = ServiceType.valueOf(type.toUpperCase());
			service.setType(sType);
			service.setVersion(version);
			if (!auth_key.isEmpty() && !auth_key.isBlank()) {
				KeyValue keyValue = CongabaseFactory.eINSTANCE.createKeyValue();
				keyValue.setKey(auth_key);
				keyValue.setValue(auth_value);
				service.setBasicAuth(keyValue);
			}
			service.getHeaders().clear();
			for (String key : headers.keySet()) {
				KeyValue keyValue = CongabaseFactory.eINSTANCE.createKeyValue();
				keyValue.setKey(key);
				keyValue.setValue(headers.get(key));
				service.getHeaders().add(keyValue);
			}

			save();
			return service;
		}
		return null;
	}

	public void changeService(String userString, String serviceId) {
		Service selected = getService(userString, serviceId);
		if (selected != null) {
			if (selected.getStatus() != ServiceStatus.ON) {
				selected.setStatus(ServiceStatus.ON);
			} else {
				selected.setStatus(ServiceStatus.OFF);
			}
		}
		save();
	}

	public void errorService(String userString, String serviceId) {
		Service selected = getService(userString, serviceId);
		if (selected != null) {
			selected.setStatus(ServiceStatus.ERROR);
		}
		save();
	}
	
	public void addLastDateService(String userString, String serviceId, Date date) {
		Service selected = getService(userString, serviceId);
		if (selected != null) {
			selected.setLastAccess(date);
		}
		save();
		
	}

	public Service getService(String userString, String serviceId) {
		User user = getUser(userString);
		if (user == null) {
			return null;
		}
		long serviceLong;
		try {
			serviceLong = Long.parseLong(serviceId);
		} catch (Exception e) {
			return null;
		}
		Service selected = null;
		for (Service s : user.getServices()) {
			if (s.getServiceId() == serviceLong) {
				selected = s;
			}
		}
		return selected;
	}

	public Service getGeneratorService(String generatorId) {
		long serviceLong;
		try {
			serviceLong = Long.parseLong(generatorId);
		} catch (Exception e) {
			return null;
		}
		Service selected = null;
		for (Service s : conga.getGenerators()) {
			if (s.getServiceId() == serviceLong) {
				selected = s;
			}
		}
		return selected;
	}
	
	public Service getParserService(String generatorId) {
		long serviceLong;
		try {
			serviceLong = Long.parseLong(generatorId);
		} catch (Exception e) {
			return null;
		}
		Service selected = null;
		for (Service s : conga.getConverters()) {
			if (s.getServiceId() == serviceLong) {
				selected = s;
			}
		}
		return selected;
	}

	public Tool getTool(String tool) {
		for (Tool t : getAllTools()) {
			if (t.getName().equalsIgnoreCase(tool)) {
				return t;
			}
		}
		return null;
	}

	public void loadBotFile(Project project, File file) throws IOException {
		Resource resource = getProjectResource(project);
		Bot bot = extractBot(file);
		bot.setName(project.getName());
		resource.getContents().clear();
		resource.getContents().add(bot);
		resource.save(null);
	}
	
	public Bot extractBot(File f) throws IOException {
		URI uri = URI.createFileURI(f.getAbsolutePath());
		Resource resource = getResourceSet().getResource(uri, true);
		Bot b = (Bot)resource.getContents().get(0);
		resource.delete(null);
		return b;
	}

	public Bot getBotProject(Project project) {
		Resource resource = getProjectResource(project);
		Bot bot = (Bot) resource.getContents().get(0);
		return bot;
	}

	public Resource getProjectResource(Project project) {
		Injector injector = BotServlet.getInjector();
		XtextResourceSet resourceSetXtext = injector.getInstance(XtextResourceSet.class);
		resourceSetXtext.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSetXtext.getResource(URI.createURI(getProjectFilePath(project)), true);
		return resource;
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
		return getProjectFolderPath(project) + File.separator + project.getName() + ".bot";
	}

	public String getProjectFolderPath(Project project) {
		return PATH + File.separator + project.getOwner().getNick() + File.separator + project.getName();
	}

	public String getProjectXMIPath(Project project) {
		return getProjectFolderPath(project) + File.separator + project.getName() + ".xmi";
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

	public boolean login(String user, String password) {
		User u = getUser(user);
		if (u != null) {
			if (u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public String generateFlowImage(String userName, String projectName) {
		Project p = getProject(userName, projectName);
		if (p == null) {
			return "";
		}
		return generateFlowImage(p);
	}

	public String generateFlowImage(Project p) {
		Bot bot = getBotProject(p);
		Resource resource = getProjectResource(p);
		String text = new CreateFlowsDiagram().createUML(resource, bot.getFlows());
		String path = getProjectFolderPath(p) + "/" + p.getName() + ".txt";
		File txt = UML.write(path, text);
		File png = UML.getUML(txt);
		return png.getAbsolutePath();
	}

	public List<Project> getProjects(String username) {
		User user = getUser(username);
		if (user == null) {
			return new ArrayList<>();
		}
		return user.getProjects();
	}

	public List<Service> getServices(String username) {
		User user = getUser(username);
		if (user == null) {
			return new ArrayList<>();
		}
		return user.getServices();
	}

	public void updateModified(Project project) {
		project.setModificationDate(new Date());
		save();
	}

	public List<AQuestion> getEvaluations(String user, String projectString) {
		Project project = getProject(user, projectString);

		if (project.getQuestionnaire() == null) {
			createUserAnswer(project);
		}
		UserAnswer answers = project.getQuestionnaire();
		List<AQuestion> ret = new ArrayList<>();
		for (Evaluation ev : conga.getQuestionnaire().getEvaluations()) {
			ret.add(answers.getAnswer(ev));
		}
		return ret;
	}

	public List<AQuestion> getNOTEvaluations(String user, String projectString) {
		Project project = getProject(user, projectString);

		if (project.getQuestionnaire() == null) {
			createUserAnswer(project);
		}
		UserAnswer answers = project.getQuestionnaire();
		List<AQuestion> ret = new ArrayList<>();
		for (Question ev : conga.getQuestionnaire().getNOTEvaluations()) {
			ret.add(answers.getAnswer(ev));
		}
		return ret;
	}

	public Map<String, List<AQuestion>> getAllQuestions(String user, String projectName) {
		Map<String, List<AQuestion>> ret = new HashMap<>();
		ret.put("Evaluations", getEvaluations(user, projectName));
		ret.put("Questions", getNOTEvaluations(user, projectName));
		return ret;
	}

	public String[] getRelevantLevels(String questionName) {
		Question q = conga.getQuestionnaire().getQuestion(questionName);
		return RelevanceLevel.getLevelsString(q.isMultiresponse());

	}

	public void evaluateBot(Project project, Map<String, String> evaluationLevel) {

		Bot bot = getBotProject(project);
		UserAnswer answers = null;
		if (project.getQuestionnaire() != null) {
			answers = project.getQuestionnaire();
		} else {
			answers = CongabaseFactory.eINSTANCE.createUserAnswer();
			project.setQuestionnaire(answers);
		}
		for (String ev : evaluationLevel.keySet()) {
			Evaluation evaluation = (Evaluation) conga.getQuestionnaire().getQuestion(ev);
			List<Option> ans = evaluation.evaluate(bot);
			answerQuestion(evaluation, answers, ans, RelevanceLevel.get(evaluationLevel.get(ev)));
		}
		save();
	}

	private void answerQuestion(Question question, UserAnswer answers, List<Option> options, RelevanceLevel level) {
		AQuestion answer = answers.getAnswer(question);
		if (answer == null) {
			answer = CongabaseFactory.eINSTANCE.createAQuestion();
			answer.setQuestion(question);
			answers.getAnswers().add(answer);
		}
		answer.getSelecteds().clear();
		answer.getSelecteds().addAll(options);
		answer.setRelevance(level);
	}

	public void createUserAnswer(Project project) {
		if (project.getQuestionnaire() != null) {
			return;
		}
		UserAnswer answers = CongabaseFactory.eINSTANCE.createUserAnswer();
		project.setQuestionnaire(answers);
		for (Question q : conga.getQuestionnaire().getQuestions()) {
			AQuestion aQuestion = CongabaseFactory.eINSTANCE.createAQuestion();
			aQuestion.setQuestion(q);
			answers.getAnswers().add(aQuestion);
		}
		save();
	}

	public void addAnswer(Project project, AQuestion question, List<String> optionsList, RelevanceLevel level) {
		List<Option> options = new ArrayList<>();
		for (String opt : optionsList) {
			options.add(question.getQuestion().getOption(opt));
		}
		answerQuestion(question.getQuestion(), project.getQuestionnaire(), options, level);
		save();

	}

	public void calculateRanking(Project project) {
		if (project.getQuestionnaire() != null) {
			project.getQuestionnaire().calculateRanking(conga.getQuestionnaire().getTools());
			project.getQuestionnaire().setDate(new Date());
		}
		save();

	}

	public Map<String, Double> getRanking(String user, String projectName) {
		Project p = getProject(user, projectName);
		if (p.getQuestionnaire() == null) {
			return new HashMap<>();
		}
		Map<String, Double> ret = new HashMap<>();
		EMap<Tool, Double> ranking = p.getQuestionnaire().getRanking();
		for (Tool t : ranking.keySet()) {
			ret.put(t.getName(), ranking.get(t));
		}
		ret = ret.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		return ret;
	}

	public String getWinner(Project project) {
		Map<String, Double> ranking = getRanking(project.getOwner().getNick(), project.getName());
		String tool = ranking.keySet().iterator().next();
		return tool + " (" + String.format("%.2f", ranking.get(tool) * 100) + "%)";
	}

	public int countObject(Project p) {
		Resource resource = getProjectResource(p);
		TreeIterator<EObject> objects = resource.getAllContents();
		int count = 0;
		while (objects.hasNext()) {
			count++;
			objects.next();
		}
		return count;
	}

	public void saveAsXmi(Project p) {
		Bot bot = getBotProject(p);
		Resource xmiResource = getResourceSet().createResource(URI.createURI(getProjectXMIPath(p)));
		xmiResource.getContents().add(bot);
		try {
			xmiResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}

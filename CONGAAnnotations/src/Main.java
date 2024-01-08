import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import com.google.common.collect.Lists;

import congaAnnotation.Annotation;
import congaAnnotation.IntentIntentValue;
import congaAnnotation.IntentValue;
import congaAnnotation.SemanticSimilarity;
import generator.Bot;
import generator.GeneratorPackage;
import generator.Intent;
import generator.Language;
import generator.Parameter;
import generator.TrainingPhrase;
import generator.UserInteraction;

public class Main {
	private static ResourceSet resourceSet = null;

	public static ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();

			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
					new XMIResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
					new XMIResourceFactoryImpl());
			if (!EPackage.Registry.INSTANCE.containsKey(GeneratorPackage.eNS_URI)) {
				EPackage.Registry.INSTANCE.put(GeneratorPackage.eNS_URI, GeneratorPackage.eINSTANCE);
			}
		}
		return resourceSet;
	}

	public static void main(String[] args) throws Exception {
		String strPathIn, strPathOut;

		if (args.length == 2) {
			strPathIn = args[0];
			strPathOut = args[1];
		} else {
			System.err.println("The program needs 2 argument: <file_path> <dest_path>");
			return;
		}

		File file = new File(strPathIn);
		TensorflowHandler.getInstance();
		if (file.isDirectory()) {
			System.out.println(
					"name;num_language;languages;num_intents;num_fallbacks;num_trainingPhrases;avg_trainingPhrases;num_entities;num_param;num_action;num_flows;num_paths;min(pathSteps);max(pathSteps);avg(pathSteps);num_buttons;num_text;num_image;num_emptyAction;external_service;num_loops");
			for (File f : file.listFiles()) {
				String name = f.getName();
				try {
					Bot bot = loadChatbot(f);
					if (bot != null) {
//						long startTime = System.currentTimeMillis();
//						Annotation annotation = GenerateAnnotations.calculateAnnotation(bot);
//						long endTime1 = System.currentTimeMillis() - startTime;
//						String name1 = name.replace(".xmi", "Annotated.xmi");
//						saveAnnotation(strPathOut, name1, annotation);
//						long endTime2 = System.currentTimeMillis() - startTime;
//						name1 = name.replace(".xmi", "");
//						generateStringFiles(strPathOut, name1, annotation);
//						annotation.getSemanticSimilarities().clear();
//						annotation.getTpAvgSims().clear();
//						annotation.getTpIntentAvgSims().clear();
//						name1 = name.replace(".xmi", "AnnotatedShort.xmi");
//						saveAnnotation(strPathOut, name1, annotation);
//						long endTime3 = System.currentTimeMillis() - startTime;
//						System.out.println(name + ";" + endTime1 + ";" + endTime2 + ";" + endTime3);

						int num_language = 0;
						String languages = "";
						int num_intents = 0;
						int fallbackIntetns = 0;
						float num_trainingPhrases = 0;
						float avg_trainingPhrases = 0;
						int num_entities = 0;
						int num_action = 0;
						int num_flows = 0;
						int num_paths = 0;
						float min_pathSteps = 0;
						float max_pathSteps = 0;
						float avg_pathSteps = 0;

						int num_buttons = 0;
						int num_text = 0;
						int num_image = 0;
						int num_emptyAction = 0;
						int external_service = 0;
						int num_loops = 0;
						int num_param = Lists
								.newArrayList(IteratorExtensions.filter(bot.eAllContents(), Parameter.class)).size();
						num_language = bot.getLanguages().size();
						for (Language lan : bot.getLanguages()) {
							languages += lan + " ";
						}
						num_intents = bot.getIntents().size();
						fallbackIntetns = countNumFallback(bot.getIntents());
						
						float[] tpValues = getTrainingPhrasesValues(bot.getIntents());
						num_trainingPhrases = tpValues[0];
						avg_trainingPhrases = tpValues[1];
						num_entities = bot.getEntities().size();
						num_action = bot.getActions().size();
						num_flows = bot.getFlows().size();
						List<List<UserInteraction>> flattenFlows = flattenFlows(bot.getFlows());
						num_paths = flattenFlows.size();
						float[] steps = getPathStepsValues(flattenFlows);
						min_pathSteps = steps[0];
						max_pathSteps = steps[1];
						avg_pathSteps = steps[2];
						num_buttons = bot.getButtons().size();
						num_text = bot.getTexts().size();
						num_image = bot.getImages().size();
						num_emptyAction = bot.getEmpties().size();
						external_service = bot.getHttpRequests().size();
						num_loops = bot.getNumLoops();
						System.out.println(name + ";" + num_language + ";" + languages + ";" + num_intents + ";"
								+ fallbackIntetns+";" +num_trainingPhrases+";"+avg_trainingPhrases+ ";" + num_entities + ";" + num_param + ";" + num_action + ";"
								+ num_flows + ";" + num_paths + ";" + min_pathSteps + ";" + max_pathSteps + ";"
								+ avg_pathSteps + ";" + num_buttons + ";" + num_text + ";" + num_image + ";"
								+ num_emptyAction + ";" + external_service + ";" + num_loops);
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("Error al cargar " + name);
				}
			}
		} else {
			String name = file.getName();
			try {
				Bot bot = loadChatbot(file);
				if (bot != null) {
					Annotation annotation = GenerateAnnotations.calculateAnnotation(bot);
					String name1 = name.replace(".xmi", "Annotated.xmi");
					saveAnnotation(strPathOut, name1, annotation);
					name1 = name.replace(".xmi", "");
					generateStringFiles(strPathOut, name1, annotation);
					annotation.getSemanticSimilarities().clear();
					annotation.getTpAvgSims().clear();
					annotation.getTpIntentAvgSims().clear();
					name1 = name.replace(".xmi", "AnnotatedShort.xmi");
					saveAnnotation(strPathOut, name1, annotation);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error al cargar " + name);
			}
		}

	}

	public static Bot loadChatbot(String src) throws Exception {
		File file = new File(src);
		return loadChatbot(file);
	}

	public static Bot loadChatbot(File file) throws Exception {
		if (!file.exists()) {
			System.err.println("The provided file does not exist");
			throw new Exception("The provided file does not exist");
		}
		Resource resource;
		resource = getResourceSet().getResource(URI.createFileURI(file.getAbsolutePath()), true);
		Bot bot = (Bot) resource.getContents().get(0);
		return bot;
	}

	public static void saveAnnotation(String src, String name, Annotation annotation) throws Exception {
		File file = new File(src);
		if (!file.exists()) {
			System.err.println("The provided file does not exist");
			throw new Exception("The provided file does not exist");
		}
		Resource resource;

		resource = getResourceSet().createResource(URI.createFileURI(src + "//" + name));
		resource.getContents().add(annotation);
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void generateStringFiles(String src, String name, Annotation annotation) throws Exception {
		File file = new File(src);
		if (!file.exists()) {
			System.err.println("The provided file does not exist");
			throw new Exception("The provided file does not exist");
		}
		FileWriter fichero = new FileWriter(src + "/" + name + "TPSimilaty.txt");
		PrintWriter pw = new PrintWriter(fichero);
		for (SemanticSimilarity ss : annotation.getSemanticSimilarities()) {
			pw.println(ss.getSimilarity());
			pw.println(ss.getTrainingPhrase1().getSentence());
			pw.println(ss.getTrainingPhrase2().getSentence());
			pw.println("---------------------------------------------------------------------------");
		}

		pw.close();

		fichero = new FileWriter(src + "/" + name + "IntentValues.txt");
		pw = new PrintWriter(fichero);
		for (IntentValue iv : annotation.getIntentValues()) {
			pw.println(iv.getIntent().getName());
			pw.println("Min1: " + iv.getMin1Value() + " --> " + iv.getMin1().getSentence());
			pw.println("Min2: " + iv.getMin2Value() + " --> " + iv.getMin2().getSentence());
			pw.println("Max1: " + iv.getMax1Value() + " --> " + iv.getMax1().getSentence());
			pw.println("Max2: " + iv.getMax2Value() + " --> " + iv.getMax2().getSentence());
			pw.println("---------------------------------------------------------------------------");
		}
		pw.close();

		fichero = new FileWriter(src + "/" + name + "IntentIntentValues.txt");
		pw = new PrintWriter(fichero);
		for (IntentIntentValue iiv : annotation.getIntentIntentValues()) {
			pw.println(iiv.getIntent1().getName() + " vs " + iiv.getIntent2().getName());
			pw.println("Min1: " + iiv.getMin1Value() + " --> " + iiv.getMin1().getSentence());
			pw.println("Min2: " + iiv.getMin2Value() + " --> " + iiv.getMin2().getSentence());
			pw.println("Max1: " + iiv.getMax1Value() + " --> " + iiv.getMax1().getSentence());
			pw.println("Max2: " + iiv.getMax2Value() + " --> " + iiv.getMax2().getSentence());
			pw.println("---------------------------------------------------------------------------");
		}
		pw.close();
	}

	public static int countNumFallback(List<Intent> intents) {
		int count = 0;
		for (Intent intent : intents) {
			if (intent.isFallbackIntent()) {
				count++;
			}
		}
		return count;
	}

	public static List<List<UserInteraction>> flattenFlows(List<UserInteraction> flows) {
		List<List<UserInteraction>> ret = new ArrayList<List<UserInteraction>>();
		for (UserInteraction flow : flows) {
			ret.addAll(flattenPath(new ArrayList<UserInteraction>(), flow));
		}
		return ret;
	}

	public static List<List<UserInteraction>> flattenPath(List<UserInteraction> prev, UserInteraction user) {
		List<List<UserInteraction>> ret = new ArrayList<List<UserInteraction>>();
		if (user.getTarget() == null) {
			prev.add(user);
			ret.add(prev);
			return ret;
		}
		if (user.getTarget().getOutcoming().isEmpty()) {
			prev.add(user);
			ret.add(prev);
			return ret;
		}

		for (UserInteraction child : user.getTarget().getOutcoming()) {
			List<UserInteraction> prevCopy = new ArrayList<UserInteraction>();
			prevCopy.addAll(prev);
			prevCopy.add(user);
			ret.addAll(flattenPath(prevCopy, child));
		}
		return ret;
	}

	public static float[] getPathStepsValues(List<List<UserInteraction>> paths) {
		float[] values = new float[3];
		float min = Integer.MAX_VALUE;
		float max = 0;
		float med = 0;
		for (List<UserInteraction> path : paths) {
			if (min > path.size()) {
				min = path.size();
			}
			if (max < path.size()) {
				max = path.size();
			}
			med += path.size();
		}
		med = med / paths.size();
		values[0] = min;
		values[1] = max;
		values[2] = med;
		return values;
	}
	public static float[] getTrainingPhrasesValues(List<Intent> intents) {
		float[] values = new float[2];
		float total = 0;
		float med = 0;
		for (Intent intent : intents) {
			total += Lists
					.newArrayList(IteratorExtensions.filter(intent.eAllContents(), TrainingPhrase.class)).size();
		}
		med = total / intents.size();
		
		values[0] = total;
		values[1] = med;
		return values;
	}
}

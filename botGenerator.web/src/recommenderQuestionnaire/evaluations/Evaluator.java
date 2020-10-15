package recommenderQuestionnaire.evaluations;


import java.util.ArrayList;
import java.util.List;

import generator.Bot;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import recommenderQuestionnaire.Evaluation;
import recommenderQuestionnaire.Questionnaire;

import java.lang.reflect.*;

public abstract class Evaluator {

	protected List<String> options = null;
	protected String text;

	public static void loadEvaluators(Questionnaire questionnaire) throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// Buscar todas las clases que van a evaluarse sobre el modelo
		List<Class<? extends Evaluator>> evaluators = new ArrayList<>();
		new FastClasspathScanner(Evaluator.class.getPackage().getName())
				.matchSubclassesOf(Evaluator.class, evaluators::add).scan();

		// Crear una instancia de cada clase
		for (Class<? extends Evaluator> evaluatorClass : evaluators) {
			// Obtenemos el constructos, si es null pasamos al siguiente
			Constructor<? extends Evaluator> evaluatorConstructor = evaluatorClass
					.getConstructor(new Class[] { List.class });

			if (evaluatorConstructor != null) {
				Evaluation qEvaluation = questionnaire.getEvaluation(evaluatorClass.getName());
				List<String> options;
				// Si el modelo no tiene la evaluación la crea
				if (qEvaluation != null) {
					options = qEvaluation.getOptionsString();
					Evaluator ev = evaluatorConstructor.newInstance(options);
					qEvaluation.setEvaluator(ev);

				}
			}
		}

	}

	protected String getText() {
		if (text == null) {
			text = "";
		}
		return text;
	}

	public Evaluator(List<String> options) {
		this.options = options;
	}

	public String getValue(String val) {
		for (String opt : getOptions()) {
			if (opt.equalsIgnoreCase(val)) {
				return opt;
			}
		}
		return null;
	}

	protected abstract boolean getMultiresponse();

	/* returns the list of options the bot satisfy */
	public abstract List<String> evaluate(Bot bot);

	protected List<String> getOptions() {
		return options;
	}

	protected void setOptions(List<String> options) {
		this.options = options;
	}
}

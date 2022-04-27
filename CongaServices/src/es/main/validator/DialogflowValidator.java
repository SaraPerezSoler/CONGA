package es.main.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import es.main.generators.DialogflowGenerator;
import generator.Action;
import generator.Bot;
import generator.GeneratorPackage;
import generator.HTTPRequest;
import generator.Intent;
import generator.UserInteraction;
import validation.problems.Problem;
import validation.problems.Problem.Severity;

public class DialogflowValidator {

	public List<Problem> validate (Resource resource){
		List<Problem> problems = new ArrayList<Problem>();
		Iterator<Bot>botIterator= IteratorExtensions.filter(resource.getAllContents(), Bot.class);
		
		if (!botIterator.hasNext()) {
			//problems.add(new Problem(Severity.ERROR, null, GeneratorPackage.Literals.BOT.getName(), "The bot definition is not correct", GeneratorPackage.Literals.ELEMENT__NAME.getName()));
			return problems;
		}
		//problems.add(new Problem(Severity.WARNING, null, GeneratorPackage.Literals.INTENT.getName(), "The bot definition is not correct", GeneratorPackage.Literals.ELEMENT__NAME.getName()));

		Bot bot = botIterator.next();
		//problems.add(new Problem(Severity.WARNING, bot.getIntents().get(0), GeneratorPackage.Literals.INTENT.getName(), "The intent warning", GeneratorPackage.Literals.ELEMENT__NAME.getName()));

//		if (!botIterator.hasNext()) {
//			problems.add(new Problem(Severity.ERROR, bot, GeneratorPackage.Literals.BOT.getName(), "The bot definition is not correct", GeneratorPackage.Literals.ELEMENT__NAME.getName()));
//			return problems;
//		}

		for (UserInteraction flow: bot.getFlows()) {
			problems.addAll(checkIntentName(flow));
		}
		for (Action act: bot.getActions()) {
			problems.addAll(checkHttpAcion(act, bot));
			problems.addAll(checkHttpAcionData(act, bot));
		}
		
		
		return problems;
	}
	
	private List<Problem> checkIntentName (UserInteraction flow){
		List<Problem> problems = new ArrayList<Problem>();
		List<List<Intent>> flows = flowFlatten(flow);
		for (List<Intent> intents: flows) {
			int size = intents.size();
			if (size > DialogflowGenerator.maxSize) {
				size = DialogflowGenerator.maxSize;
			}
			for (Intent intent: intents) {
				if (intent.getName().length()>((DialogflowGenerator.limit/(size+1))-3)) {
					problems.add(new Problem(Severity.WARNING, intent, GeneratorPackage.Literals.INTENT.getName(), "The name of the intent "+intent.getName()+" is going to be shortened in at least one flow", GeneratorPackage.Literals.ELEMENT__NAME.getName()));
				}
			}
		}
		
		return problems;
	}
	
	
	
	private List<List<Intent>> flowFlatten (UserInteraction flow) {
		if (flow.getTarget() == null || flow.getTarget().getOutcoming().isEmpty()) {
				List<Intent> ret = new ArrayList<Intent>();
				List<List<Intent>> ret_ret = new ArrayList<List<Intent>>();
				ret.add(flow.getIntent());
				ret_ret.add(ret);
				return ret_ret;
		}
		
		List<List<Intent>> ret = new ArrayList<List<Intent>>();
		for (int i=0; i<flow.getTarget().getOutcoming().size(); i++) {
			List<List<Intent>> aux = flowFlatten(flow.getTarget().getOutcoming().get(i));
			for (List<Intent> intents : aux) {
				intents.add(flow.getIntent());
				ret.add(intents);
			}
		}
		return ret;
		
	}
	private List<Problem> checkHttpAcion (Action action, Bot bot){
		List<Problem> problems = new ArrayList<Problem>();
		if (action instanceof HTTPRequest) {
			for (Action act: bot.getActions()) {
				if (act  instanceof HTTPRequest && !action.equals(act)) {
					problems.add(new Problem(Severity.WARNING, action,GeneratorPackage.Literals.HTTP_REQUEST.getName(), "Dialogflow only handles one HTTPAction", GeneratorPackage.Literals.ELEMENT__NAME.getName()));
				}
			}
		}
		
		return problems;
	}
	private List<Problem> checkHttpAcionData (Action action, Bot bot){
		List<Problem> problems = new ArrayList<Problem>();
		if (action instanceof HTTPRequest) {
			problems.add(new Problem(Severity.WARNING, action,GeneratorPackage.Literals.HTTP_REQUEST.getName(), "The data of the request will be ignored, Dialogflow sends all the info in JSON format", GeneratorPackage.Literals.ELEMENT__NAME.getName()));
		}
		
		return problems;
	}
	
}

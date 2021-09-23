package es.main.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import es.main.generators.DialogflowGenerator;
import es.main.validator.Problem.Severity;
import generator.Bot;
import generator.Intent;
import generator.UserInteraction;

public class DialogflowValidator {

	public List<Problem> validate (Resource resource){
		List<Problem> problems = new ArrayList<Problem>();
		Iterator<Bot>botIterator= IteratorExtensions.filter(resource.getAllContents(), Bot.class);
		
		if (!botIterator.hasNext()) {
			problems.add(new Problem(Severity.ERROR, null, Bot.class.getName(), "The bot definition is not correct"));
			return problems;
		}
		Bot bot = botIterator.next();
		if (!botIterator.hasNext()) {
			problems.add(new Problem(Severity.ERROR, null, Bot.class.getName(), "The bot definition is not correct"));
			return problems;
		}
		
		for (UserInteraction flow: bot.getFlows()) {
			problems.addAll(checkIntentName(flow));
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
					problems.add(new Problem(Severity.WARNING, intent, Intent.class.getName(), "The name of the intent "+intent.getName()+" is going to be shortened in at least one flow"));
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
}

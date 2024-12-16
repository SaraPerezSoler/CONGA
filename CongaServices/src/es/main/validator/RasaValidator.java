package es.main.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import generator.Bot;
import generator.GeneratorPackage;
import generator.Intent;
import generator.Language;
import generator.UserInteraction;
import validation.problems.Problem;
import validation.problems.Problem.Severity;

public class RasaValidator {

	public List<Problem> validate (Resource resource){
		List<Problem> problems = new ArrayList<Problem>();
		Iterator<Bot>botIterator= IteratorExtensions.filter(resource.getAllContents(), Bot.class);
		
		if (!botIterator.hasNext()) {
			return problems;
		}

		Bot bot = botIterator.next();

		problems.addAll(checkLanguages(bot));
		problems.addAll(checkfallbackIntent(bot));

		for (UserInteraction flow: bot.getFlows()) {
			problems.addAll(checkLoops(flow));
		}
		
		
		return problems;
	}

	private List<Problem> checkLanguages(Bot bot) {
		List<Problem> problems = new ArrayList<Problem>();
		EList<Language> languages = bot.getLanguages();
		if (languages.size()>1) {
			problems.add(new Problem(Severity.WARNING, bot, GeneratorPackage.Literals.BOT.getName(),
					"Rasa does not support multi-language chatbots, the generator creates one chatbot per language",
					GeneratorPackage.Literals.BOT__LANGUAGES.getName()));
		}

		return problems;
	}
	
	private List<Problem> checkfallbackIntent(Bot bot) {
		List<Problem> problems = new ArrayList<Problem>();
		EList<Intent> intents = bot.getIntents();
		int cont = 0;
		for (Intent intent: intents) {
			if (intent.isFallbackIntent()) {
				cont ++;
			}
		}
		if (cont>1) {
			problems.add(new Problem(Severity.WARNING, bot, GeneratorPackage.Literals.BOT.getName(),
					"Rasa does not support more than one fallback intent, only the first one is taken into account",
					GeneratorPackage.Literals.BOT__INTENTS.getName()));
		}

		return problems;
	}
	
	private List<Problem> checkLoops(UserInteraction flow) {
		List<Problem> problems = new ArrayList<Problem>();
		if (flow.getBackTo() != null) {
			problems.add(new Problem(Severity.WARNING, flow, GeneratorPackage.Literals.USER_INTERACTION.getName(),
					"The Rasa generator unfolds the loops up to 5 repetitions",
					GeneratorPackage.Literals.USER_INTERACTION__BACK_TO.getName()));
		}
		if (flow.getTarget()!=null) {
			if (!flow.getTarget().getBackTo().isEmpty()) {
				problems.add(new Problem(Severity.WARNING, flow.getTarget(), GeneratorPackage.Literals.BOT_INTERACTION.getName(),
						"The Rasa generator unfolds the loops up to 5 repetitions",
						GeneratorPackage.Literals.BOT_INTERACTION__BACK_TO.getName()));
			}
			for (UserInteraction ui: flow.getTarget().getOutcoming()) {
				problems.addAll(checkLoops(ui));
			}
		}

		return problems;
	}
}

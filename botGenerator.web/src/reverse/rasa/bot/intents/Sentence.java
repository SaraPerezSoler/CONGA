package reverse.rasa.bot.intents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Element;

import generator.Bot;
import generator.GeneratorFactory;
import generator.Intent;
import generator.TrainingPhrase;

public class Sentence {
	private List<Token> tokens = new ArrayList<>();
	private boolean hasParam = false;

	public Sentence(String sentence) {
		int endIndex = 0;

		String auxSent = sentence;
		boolean literal = true;
		while (!auxSent.isEmpty() && !auxSent.isBlank()) {
			if (literal) {
				String literalString;
				endIndex = auxSent.indexOf("[");
				if (endIndex == -1) {
					literalString = auxSent;
				} else {
					literalString = auxSent.substring(0, endIndex);
				}
				if (!literalString.isEmpty()) {
					tokens.add(new Literal(literalString));
				}
				auxSent = auxSent.substring(literalString.length());
				literal = false;
			} else {
				String literalString;
				endIndex = auxSent.indexOf(")");
				if (endIndex == -1) {
					endIndex = auxSent.indexOf("}");
				}
				if (endIndex == -1) {
					literalString = auxSent;
				} else {
					literalString = auxSent.substring(0, endIndex + 1);
				}
				if (!literalString.isEmpty()) {
					tokens.add(new Entity(literalString));
				}
				auxSent = auxSent.substring(literalString.length());
				literal = true;
				hasParam = true;
			}
		}
	}

	public Sentence(Element line) {
		String senteceString = line.text();
		Iterator<Element> params = line.getElementsByTag("a").iterator();
		while (params.hasNext()) {
			Element param = params.next();
			String toke = senteceString.substring(0, senteceString.indexOf(param.text()));
			saveToken(toke);
			tokens.add(new Entity(param));
			senteceString = senteceString.substring(senteceString.indexOf(param.text()) + param.text().length());
		}
		saveToken(senteceString);
	}

	public void saveToken(String string) {

		if (string.contains("[") && string.contains("]") && string.contains("{") && string.contains("}")) {
			String firstSubString = string.substring(0, string.indexOf("["));
			String secondSubString = string.substring(string.indexOf("["), string.indexOf("}")+"}".length());
			String thirdSubString = string.substring(string.indexOf("}")+"}".length());

			if (!firstSubString.isEmpty() && !firstSubString.isBlank()) {
				tokens.add(new Literal(firstSubString));
			}
			if (!secondSubString.isEmpty() && !secondSubString.isBlank()) {
				tokens.add(new Entity(secondSubString));
			}
			saveToken(thirdSubString);
		} else {
			if (!string.isEmpty() && !string.isBlank()) {
				tokens.add(new Literal(string));
			}
		}

	}

	public boolean hasParam() {
		return hasParam;
	}

	public List<Entity> getParams() {
		List<Entity> ret = new ArrayList<>();
		for (Token tok : tokens) {
			if (tok instanceof Entity) {
				ret.add((Entity) tok);
			}
		}
		return ret;
	}

	public TrainingPhrase createBotSentence(Bot bot, Intent intent) {
		TrainingPhrase phrase = GeneratorFactory.eINSTANCE.createTrainingPhrase();
		for (Token token: tokens) {
			phrase.getTokens().add(token.createBotToken(bot, intent));
		}
		return phrase;
	}
}

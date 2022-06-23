package es.main.parser.rasa.bot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import es.main.parser.rasa.bot.intents.Intent;
import es.main.parser.rasa.bot.intents.Sentence;
import generator.Bot;
import generator.Entity;
import generator.GeneratorFactory;
import generator.LanguageEntity;
import generator.RegexInput;
import generator.SimpleInput;
import generator.TrainingPhrase;

public class Nlu {

	private List<Intent> intents = new ArrayList<>();
	private Map<String, List<String>> synonym = new HashMap<>();
	private Map<String, List<String>> regex = new HashMap<>();

	public Nlu(Document html) {
		add(html);
	}
	
	public void add(Document html) {
		Iterator<Element> elements = html.getElementsByTag("h2").iterator();
		while (elements.hasNext()) {
			Element element = elements.next();
			Element ul = element.nextElementSibling();
			if (element.text().startsWith("intent:")) {
				String name = element.text().replace("intent:", "");
				name =name.replaceAll("[^A-Za-z0-9_\\-/]", "");
				intents.add(new Intent(name, ul));
			} else if (element.text().startsWith("regex:")) {
				String name = element.text().replace("regex:", "");
				name =name.replaceAll("[^A-Za-z0-9_\\-/]", "");
				saveRegex(name, ul);
			} else if (element.text().startsWith("synonym:")) {
				String name = element.text().replace("synonym:", "");
				name =name.replaceAll("[^A-Za-z0-9_\\-/]", "");
				saveSynonyms(name, ul);
			} else if (element.text().startsWith("lookup:")) {
				String name = element.text().replace("lookup:", "");
				name =name.replaceAll("[^A-Za-z0-9_\\-/]", "");
				saveSynonyms(name, ul);
			}
		}
		
	}

	private void saveRegex(String name, Element ul) {
		Iterator<Element> regexs = ul.getElementsByTag("li").iterator();
		List<String> regexsList = new ArrayList<>();
		while (regexs.hasNext()) {
			Element nextRegex = regexs.next();
			try {
				//Pattern.compile(nextRegex.text());
				regexsList.add(nextRegex.text());
			} catch (PatternSyntaxException e) {
				//System.out.println("Error:"+);
			}
		}
		this.regex.put(name, regexsList);
	}

	private void saveSynonyms(String name, Element ul) {
		Iterator<Element> synonyms = ul.getElementsByTag("li").iterator();
		List<String> synonymList = new ArrayList<>();
		while (synonyms.hasNext()) {
			Element nextSynonym = synonyms.next();
			synonymList.add(nextSynonym.text());
		}
		this.synonym.put(name, synonymList);
	}

	public List<Intent> getIntents() {
		return intents;
	}

	public void setIntents(List<Intent> intents) {
		this.intents = intents;
	}

	public void saveBotEntities(Bot bot) {

		for (String key : this.regex.keySet()) {
			Entity entity = GeneratorFactory.eINSTANCE.createEntity();
			entity.setName(key);

			LanguageEntity langInputs = GeneratorFactory.eINSTANCE.createLanguageEntity();
			langInputs.setLanguage(bot.getLanguages().get(0));

			for (String s : this.regex.get(key)) {
				RegexInput entry = GeneratorFactory.eINSTANCE.createRegexInput();
				entry.setExpresion(s);
				langInputs.getInputs().add(entry);
			}
			entity.getInputs().add(langInputs);
			bot.getEntities().add(entity);
		}

		for (Intent intent : this.intents) {
			for (Sentence sentence : intent.getSentences()) {
				if (sentence.hasParam()) {
					for (es.main.parser.rasa.bot.intents.Entity param : sentence.getParams()) {
						List<String> synonyms = new ArrayList<>();

						if (param.getValue() != null) {
							synonyms.add(param.getLiteral());
							if (this.synonym.containsKey(param.getValue())) {
								synonyms.addAll(this.synonym.get(param.getValue()));
							}
							if (this.synonym.containsKey(param.getLiteral())) {
								synonyms.addAll(this.synonym.get(param.getLiteral()));
							}
							createEntity(bot, param.getEntity(), param.getValue(), synonyms);
						} else if (this.synonym.containsKey(param.getLiteral())) {
							synonyms.addAll(this.synonym.get(param.getLiteral()));
							createEntity(bot, param.getEntity(), param.getLiteral(), synonyms);
						} else if (bot.getEntity(param.getEntity()) != null) {
							createEntity(bot, param.getEntity(), param.getLiteral(), synonyms);
						}
					}
				}
			}
		}
	}

	public void saveBotIntents(Bot bot) {
		for (Intent intent : this.intents) {
			generator.Intent in;
			if ((in=bot.getIntent(intent.getName()))!= null) {
				for (Sentence sentence : intent.getSentences()) {
					TrainingPhrase tp = sentence.createBotSentence(bot, in);
					//if (in.getInputs().get(0).contains(tp)) {
						in.getInputs().get(0).getInputs().add(tp);
					//}
				}
			}else {
				if (bot.containsElement(intent.getName())) {
					intent.setName(intent.getName()+"Intent");
				}
				if ((in=bot.getIntent(intent.getName()))!= null) {
					for (Sentence sentence : intent.getSentences()) {
						TrainingPhrase tp = sentence.createBotSentence(bot, in);
						//if (in.getInputs().get(0).contains(tp)) {
							in.getInputs().get(0).getInputs().add(tp);
						//}
					}
				}else {
					bot.getIntents().add(intent.createBotIntent(bot));
				}
			}
		}
	}

	private void createEntity(Bot bot, String entityName, String entryName, List<String> synonyms) {
		Entity entity = bot.getEntity(entityName);

		if (entity == null) {
			entity = GeneratorFactory.eINSTANCE.createEntity();
			entity.setName(entityName);
			LanguageEntity langInputs = GeneratorFactory.eINSTANCE.createLanguageEntity();
			langInputs.setLanguage(bot.getLanguages().get(0));
			entity.getInputs().add(langInputs);
			bot.getEntities().add(entity);
		}
		if (!entity.isRegex()) {
			LanguageEntity langInputs = entity.getInputs().get(0);
			SimpleInput entry = (SimpleInput) langInputs.getInput(entryName);
			if (entry == null) {
				entry = GeneratorFactory.eINSTANCE.createSimpleInput();
				entry.setName(entryName);
				langInputs.getInputs().add(entry);
			}
			for (String syn : synonyms) {
				if (!entry.getValues().contains(syn)) {
					entry.getValues().add(syn);
				}
			}
		}
	}


}

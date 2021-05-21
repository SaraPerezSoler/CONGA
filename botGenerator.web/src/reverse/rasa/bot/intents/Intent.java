package reverse.rasa.bot.intents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Element;

import generator.Bot;
import generator.GeneratorFactory;
import generator.IntentLanguageInputs;
import generator.LanguageInput;

public class Intent {

	private String name;
	private List<Sentence> sentences = new ArrayList<>(); 
	
	public Intent(String section) {
		String fistLine = section.substring(0, section.indexOf("\n"));
		name = fistLine;
		String[] sents = section.replaceFirst(fistLine+"\n", "").split("-");
		for (String sent: sents) {
			if (!sent.isEmpty() && !sent.isBlank())
				sentences.add(new Sentence(sent.replace("\n", " ")));
		}
	}

	public Intent(String name2, Element ul) {
		this.name = name2;
		Iterator<Element> li = ul.getElementsByTag("li").iterator();
		while (li.hasNext()) {
			Element line = li.next();
			sentences.add(new Sentence(line));
			
		}
	}

	public generator.Intent getBotIntent() {
		generator.Intent ret = GeneratorFactory.eINSTANCE.createIntent();
		ret.setName(name);
		for (Sentence sentence: sentences) {
			if (sentence.hasParam()) {
				List<Entity> param = sentence.getParams();
			}
		}
		return ret;
	}

	public List<Sentence> getSentences() {
		return this.sentences;
	}

	/*public void addBotEntity(Bot bot) {
		
		for (Sentence sentence: sentences) {
			if (sentence.hasParam()){
				for (Entity param: sentence.getParams()) {
					generator.Entity entity = bot.getEntity(param.getEntity());
					
					if (entity == null){
						entity = GeneratorFactory.eINSTANCE.createEntity();
						entity.setName(param.getEntity());
						LanguageInput input = GeneratorFactory.eINSTANCE.createLanguageInput();
						input.setLanguage(bot.getLanguages().get(0));
					}
					if (entity.getInputs().get(0).getInput(param.getValue())==null) {
						EntityInput entry = GeneratorFactory.eINSTANCE.createSimpleInput();
						
					}
				}
			}
		}
		return null;
	}*/
	
	public generator.Intent createBotIntent(Bot bot){
		generator.Intent botIntent = GeneratorFactory.eINSTANCE.createIntent();
		botIntent.setName(name);
		IntentLanguageInputs languageInput = GeneratorFactory.eINSTANCE.createIntentLanguageInputs();
		languageInput.setLanguage(bot.getLanguages().get(0));
		botIntent.getInputs().add(languageInput);
		for (Sentence sentence : getSentences()) {
			languageInput.getInputs().add(sentence.createBotSentence(bot, botIntent));
		}
		return botIntent;
	}
}

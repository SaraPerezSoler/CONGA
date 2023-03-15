package es.main.parser.dialogflow.agent.intents;

import java.util.List;

import es.main.parser.dialogflow.agent.Agent;
import generator.Bot;
import generator.GeneratorFactory;
import generator.Intent;
import generator.Language;
import generator.LanguageIntent;

public class UserSaysLanguage {

	private String language;
	private List<TrainingPhrase> phrases;

	public String getLanguage() {
		if (language == null) {
			language = "";
		}
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<TrainingPhrase> getPhrases() {
		return phrases;
	}

	public void setPhrases(List<TrainingPhrase> phrases) {
		this.phrases = phrases;
	}

	public LanguageIntent getBotLanguageInput(Intent intent, Bot bot) {

		LanguageIntent languageInput = null;
		Language language = Agent.castLanguage(getLanguage());
		for (LanguageIntent lanIntent : intent.getInputs()) {
			if (lanIntent.getLanguage().equals(language)) {
				languageInput = lanIntent;
			}
		}
		if (languageInput == null) {
			languageInput = GeneratorFactory.eINSTANCE.createLanguageIntent();
			languageInput.setLanguage(language);
		}

		for (TrainingPhrase phrase : getPhrases()) {
			generator.TrainingPhrase training = phrase.getBotTrainingPhrase(intent, bot);
			languageInput.getInputs().add(training);
		}
		return languageInput;
	}

}

package parser.dialogflow.agent.intents;

import java.util.List;

import parser.dialogflow.agent.Agent;
import generator.Bot;
import generator.GeneratorFactory;
import generator.Intent;
import generator.IntentLanguageInputs;
import generator.Language;

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

	public IntentLanguageInputs getBotLanguageInput(Intent intent, Bot bot) {

		IntentLanguageInputs languageInput = null;
		Language language = Agent.castLanguage(getLanguage());
		for (IntentLanguageInputs lanIntent : intent.getInputs()) {
			if (lanIntent.getLanguage().equals(language)) {
				languageInput = lanIntent;
			}
		}
		if (languageInput == null) {
			languageInput = GeneratorFactory.eINSTANCE.createIntentLanguageInputs();
			languageInput.setLanguage(language);
		}

		for (TrainingPhrase phrase : getPhrases()) {
			generator.TrainingPhrase training = phrase.getBotTrainingPhrase(intent, bot);
			languageInput.getInputs().add(training);
		}
		return languageInput;
	}

}

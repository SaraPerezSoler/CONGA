package es.main.parser.dialogflow.agent.intents;

import java.util.List;

import es.main.parser.dialogflow.agent.Agent;
import generator.Bot;
import generator.GeneratorFactory;
import generator.Intent;
import generator.IntentLanguageInputs;

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
		IntentLanguageInputs languageInput = GeneratorFactory.eINSTANCE.createIntentLanguageInputs();
		languageInput.setLanguage(Agent.castLanguage(getLanguage()));
		for (TrainingPhrase phrase : getPhrases()) {
			generator.TrainingPhrase training = phrase.getBotTrainingPhrase(intent, bot);
			languageInput.getInputs().add(training);
		}
		return languageInput;
	}
	
	
}

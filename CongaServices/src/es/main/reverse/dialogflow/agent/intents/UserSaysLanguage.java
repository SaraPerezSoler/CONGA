package es.main.reverse.dialogflow.agent.intents;

import java.util.List;

import es.main.reverse.dialogflow.agent.Agent;
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
	public IntentLanguageInputs getBotLanguageInput(Intent intent) {
		IntentLanguageInputs languageInput = GeneratorFactory.eINSTANCE.createIntentLanguageInputs();
		languageInput.setLanguage(Agent.castLanguage(getLanguage()));
		for (TrainingPhrase phrase : getPhrases()) {
			generator.TrainingPhrase training = phrase.getBotTrainingPhrase(intent);
			languageInput.getInputs().add(training);
		}
		return languageInput;
	}
	
	
}

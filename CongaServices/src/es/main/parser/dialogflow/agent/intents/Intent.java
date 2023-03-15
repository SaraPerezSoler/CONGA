package es.main.parser.dialogflow.agent.intents;

import java.util.ArrayList;
import java.util.List;

import es.main.parser.dialogflow.agent.Agent;
import generator.Action;
import generator.Bot;
import generator.GeneratorFactory;
import generator.LanguageIntent;

public class Intent {
	
	private String name;
	private List<String> contexts = new ArrayList<>();
	private List<Response> responses = new ArrayList<>();
	private boolean webhookUsed;
	private boolean fallbackIntent;
	private List<UserSaysLanguage> usersays= new ArrayList<>();
	
	private generator.Intent intent = null;
	private List<Action> actions = null;

		
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name.replace(".", " ");
	}


	public List<String> getContexts() {
		if (contexts == null) {
			return new ArrayList<>();
		}
		return contexts;
	}


	public void setContexts(List<String> context) {
		this.contexts = context;
	}


	public List<Response> getResponses() {
		return responses;
	}


	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}


	public boolean isWebhookUsed() {
		return webhookUsed;
	}


	public void setWebhookUsed(boolean webhookUsed) {
		this.webhookUsed = webhookUsed;
	}


	public boolean isFallbackIntent() {
		return fallbackIntent;
	}


	public void setFallbackIntent(boolean fallbackIntent) {
		this.fallbackIntent = fallbackIntent;
	}


	public List<UserSaysLanguage> getUsersays() {
		return usersays;
	}


	public void setUsersays(List<UserSaysLanguage> usersays) {
		this.usersays = usersays;
	}


	public void addUsersays(UserSaysLanguage userSaysLanguage) {
		if (this.usersays == null) {
			this.usersays = new ArrayList<UserSaysLanguage>();
		}
		this.usersays.add(userSaysLanguage);
	}


	public generator.Intent getBotIntent(Bot bot) {
		if (intent!= null) {
			return intent;
		}
		intent = GeneratorFactory.eINSTANCE.createIntent();
		intent.setName(getName());
		intent.setFallbackIntent(isFallbackIntent());
		
		for (Response responses : getResponses()) {
			for (Parameter param : responses.getParameters()) {
				intent.getParameters().add(param.getBotParam(bot));
			}
		}

		for (UserSaysLanguage usersays : getUsersays()) {
			LanguageIntent languageInput = usersays.getBotLanguageInput(intent, bot);
			intent.getInputs().add(languageInput);
		}
		
		return intent;
		
	}
	
	public List<Action> getBotIntentActions(Bot bot, Agent agent) {
		if (actions!= null) {
			return actions;
		}
		actions = new ArrayList<>();
		if (isWebhookUsed()) {
			actions.add(bot.getAction("HttpRequest"));
			actions.add(bot.getAction("HttpResponse"));
		}
		for (Response response: getResponses()) {
			actions.addAll(response.getBotActions(getBotIntent(bot), bot, agent));
		}
		return actions;
		
	}


	public boolean containsAffectedContext(String context) {
		for (Response response: getResponses()) {
			if (response.containsAffextedContext(context)) {
				return true;
			}
		}
		return false;
	}
}


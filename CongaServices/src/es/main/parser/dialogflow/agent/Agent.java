package es.main.parser.dialogflow.agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.main.parser.Chatbot;
import es.main.parser.dialogflow.agent.entities.Entity;
import es.main.parser.dialogflow.agent.intents.Context;
import es.main.parser.dialogflow.agent.intents.Intent;
import es.main.parser.dialogflow.agent.intents.Message;
import generator.Action;
import generator.Bot;
import generator.BotInteraction;
import generator.GeneratorFactory;
import generator.HTTPRequest;
import generator.HTTPRequestToke;
import generator.HTTPResponse;
import generator.HTTPReturnType;
import generator.Language;
import generator.TextInput;
import generator.LanguageText;
import generator.UserInteraction;

public class Agent extends Chatbot {

	private String name;
	private String language;
	private Webhook webhook;
	private List<String> supportedLanguages = new ArrayList<>();
	private List<Intent> intents = new ArrayList<>();
	private List<Entity> entities = new ArrayList<>();
	private boolean haveLoops = false;
	private boolean haveeContainerLoops = false;

	private HTTPRequest request;
	private HTTPResponse response;

	private Map<Action, List<Action>> similarActions = new HashMap<Action, List<Action>>();
	private Map<generator.Intent, List<generator.Intent>> similarIntents = new HashMap<>();

	private Map<String, Map<Intent, UserInteraction>> flow_intent = new HashMap<String, Map<Intent, UserInteraction>>();
	
	public Agent() {
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setWebhook(Webhook webhook) {
		this.webhook = webhook;
	}

	public Webhook getWebhook() {
		return webhook;
	}

	@Override
	public String toString() {
		return "Agent [language=" + language + ", webhook=" + webhook + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSupportedLanguages() {
		return supportedLanguages;
	}

	public void setSupportedLanguages(List<String> supportedLanguages) {
		this.supportedLanguages = supportedLanguages;
	}

	public List<Intent> getIntents() {
		return intents;
	}

	public List<Intent> getIntents(Context context) {
		List<Intent> intents = new ArrayList<Intent>();

		for (Intent intent : getIntents()) {
			if (intent.getContexts().contains(context.getName())) {
				intents.add(intent);
			}
		}
		return intents;
	}

	public Intent getIntentsByAffectedContext(String context) {
		for (Intent intent : getIntents()) {
			if (intent.containsAffectedContext(context)) {
				return intent;
			}
		}
		return null;

	}

	public void setIntents(List<Intent> intents) {
		this.intents = intents;
	}

	public List<Entity> getEntities() {
		if (entities == null) {
			entities = new ArrayList<>();
		}
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}

	public Bot getBot() {
		Bot bot = GeneratorFactory.eINSTANCE.createBot();

		bot.setName(getName());

		for (String language : getLanguages()) {
			bot.getLanguages().add(castLanguage(language));
		}
		for (Entity entity : getEntities()) {
			generator.Entity botEntity = entity.getBotEntity();
			int i = 1;
			String name = botEntity.getName();
			while (bot.containsElement(botEntity.getName()) == true) {
				botEntity.setName(name + i);
				i++;
			}
			bot.getEntities().add(botEntity);
		}
		Entity.endBotCompositeEntity(bot);

		if (getWebhook() != null) {
			request = getWebhook().getRequestAction();
		} else {
			request = Webhook.getDefaultRequest();
		}
		response = getDefaultResponse(request);

		saveAction(request, bot);
		saveAction(response, bot);

		for (Intent intent : getIntents()) {
			generator.Intent botIntent = intent.getBotIntent(bot);
			saveIntent(botIntent, bot);
			for (Action action : intent.getBotIntentActions(bot, this)) {
				saveAction(action, bot);
			}
		}
		int i = 0;
		for (Intent intent : getIntents()) {
			if (intent.getContexts().isEmpty()) {
				UserInteraction interaction = startFlow(intent, bot, i);
				if (!bot.getFlows().contains(interaction)) {
					bot.getFlows().add(interaction);
					i++;
				}
			}
		}
		boolean needWebhook = false;
		for (UserInteraction flow: bot.getFlows()) {
			if (flow.flowHasAction(request)) {
				needWebhook = true;
				break;
			}
		}
		if (!needWebhook) {
			bot.getActions().remove(request);
			bot.getActions().remove(response);
		}
		return bot;
	}
	

	private void saveIntent(generator.Intent botIntent, Bot bot) {
		boolean hasSimiliar = false;
		for (generator.Intent key : similarIntents.keySet()) {
			if (botIntent.isSimilarTo(key)) {
				List<generator.Intent> list = similarIntents.get(key);
				if (!list.contains(botIntent)) {
					list.add(botIntent);
				}
				hasSimiliar = true;
				break;
			}
		}
		if (hasSimiliar == false) {
			int i = 1;
			String name = botIntent.getName();
			while (bot.containsElement(botIntent.getName()) == true) {
				botIntent.setName(name + i);
				i++;
			}

			List<generator.Intent> list = new ArrayList<generator.Intent>();
			list.add(botIntent);
			similarIntents.put(botIntent, list);

			bot.getIntents().add(botIntent);
		}
	}

	private generator.Intent getIntent(generator.Intent botIntent) {
		for (generator.Intent key : similarIntents.keySet()) {
			if (similarIntents.get(key).contains(botIntent)) {
				return key;
			}
		}
		return null;
	}

	private void saveAction(Action action, Bot bot) {
		boolean hasSimiliar = false;
		for (Action key : similarActions.keySet()) {
			if (action.isSimilarTo(key)) {
				List<Action> list = similarActions.get(key);
				if (!list.contains(action)) {
					list.add(action);
				}
				hasSimiliar = true;
				break;
			}
		}
		if (hasSimiliar == false) {
			int i = 1;
			String name = action.getName();
			while (bot.containsElement(action.getName()) == true) {
				action.setName(name + i);
				i++;
			}

			List<Action> list = new ArrayList<Action>();
			list.add(action);
			similarActions.put(action, list);
			bot.getActions().add(action);
		}
	}

	private generator.Action getAction(Action action) {
		for (Action key : similarActions.keySet()) {
			if (similarActions.get(key).contains(action)) {
				return key;
			}
		}
		return null;
	}

	private UserInteraction startFlow(Intent intent, Bot bot, int numPath) {
		UserInteraction interaction = null;
		for (UserInteraction aux : bot.getFlows()) {
			if (aux.getIntent().equals(getIntent(intent.getBotIntent(bot)))) {
				interaction = aux;
				numPath = bot.getFlows().indexOf(aux);
				break;
			}
		}

		return completeInteraction(interaction, intent, bot, numPath + "");

	}

	private int num_userInteraction = 1;
	private int num_botInteraction = 1;

	private UserInteraction completeInteraction(UserInteraction interaction, Intent intent, Bot bot, String numPath) {
		if (interaction == null) {
			interaction = GeneratorFactory.eINSTANCE.createUserInteraction();
			interaction.setIntent(getIntent(intent.getBotIntent(bot)));
			interaction.setName("user" + num_userInteraction);
			num_userInteraction++;

			if (flow_intent.get(numPath) == null) {
				flow_intent.put(numPath, new HashMap<Intent, UserInteraction>());
			}
			flow_intent.get(numPath).put(intent, interaction);
		}
		BotInteraction botInteraction = GeneratorFactory.eINSTANCE.createBotInteraction();
		botInteraction.setName("bot" + num_botInteraction);
		num_botInteraction++;
		for (Action act : intent.getBotIntentActions(bot, this)) {
			botInteraction.getActions().add(getAction(act));
		}
		if (botInteraction.getActions().isEmpty()) {
			Action empty = Message.emptyAction(intent.getBotIntent(bot), bot);
			saveAction(empty, bot);
			Action aux = getAction(empty);
			botInteraction.getActions().add(aux);
		}
		interaction.setTarget(botInteraction);

		List<Context> affectedContext = new ArrayList<>();
		intent.getResponses().forEach((r) -> affectedContext.addAll(r.getAffectedContexts()));
		int i = 0;
		for (Context context : affectedContext) {
			for (Intent followUp : getIntents(context)) {
				UserInteraction aux = getInPath(numPath, followUp);
				if (aux != null) {
//					if (botInteraction.eContainer().equals(aux)) {
//						haveeContainerLoops=true;
//					}else {
						haveLoops = true;
						botInteraction.getBackTo().add(aux);
//					}
				} else {
					aux = continueFlow(followUp, bot, botInteraction, numPath + "_" + i);
					botInteraction.getOutcoming().add(aux);
					i++;
				}
			}
		}
		return interaction;
	}

	private UserInteraction getInPath(String numPath, Intent followUp) {
		String[] nums = numPath.split("_");
		String path = "";
		String sep = "";
		for (String n : nums) {
			path += sep + n;
			sep = "_";
			if (flow_intent.get(path) != null) {
				if (flow_intent.get(path).containsKey(followUp)) {
					return flow_intent.get(path).get(followUp);
				}
			}
		}
		return null;
	}

	private UserInteraction continueFlow(Intent intent, Bot bot, BotInteraction prevBotInteraction, String numPath) {
		UserInteraction interaction = null;
		for (UserInteraction aux : prevBotInteraction.getOutcoming()) {
			if (aux.getIntent().equals(getIntent(intent.getBotIntent(bot)))) {
				interaction = aux;
				break;
			}
		}
		return completeInteraction(interaction, intent, bot, numPath);
	}

	public static Language castLanguage(String language) {
		if (language == null) {
			return Language.ENGLISH;
		}
		if (language.startsWith("en")) {
			return Language.ENGLISH;
		}else if (language.startsWith("es")) {
			return Language.SPANISH;
		}else if (language.startsWith("da")) {
			return Language.DANISH;
		}else if (language.startsWith("de")) {
			return Language.GERMAN;
		}else if (language.startsWith("fr")) {
			return Language.FRENCH;
		}else if (language.startsWith("hi")) {
			return Language.HINDI;
		}else if (language.startsWith("id")) {
			return Language.INDONESIAN;
		}else if (language.startsWith("it")) {
			return Language.ITALIAN;
		}else if (language.startsWith("ja")) {
			return Language.JAPANESE;
		}else if (language.startsWith("ko")) {
			return Language.KOREAN;
		}else if (language.startsWith("nl")) {
			return Language.DUTCH;
		}else if (language.startsWith("no")) {
			return Language.NORWEGIAN;
		}else if (language.startsWith("pl")) {
			return Language.POLISH;
		}else if (language.startsWith("pt")) {
			return Language.PORTUGUESE;
		}else if (language.startsWith("ru")) {
			return Language.RUSIAN;
		}else if (language.startsWith("sv")) {
			return Language.SWEDISH;
		}else if (language.startsWith("th")) {
			return Language.THAI;
		}else if (language.startsWith("tr")) {
			return Language.TURKISH;
		}else if (language.startsWith("uk")) {
			return Language.UKRANIAN;
		}else if (language.startsWith("zh")) {
			return Language.CHINESE;
		}else {
			return Language.ENGLISH;
		}
	}

	private HTTPResponse getDefaultResponse(HTTPRequest request) {
		HTTPResponse ret = GeneratorFactory.eINSTANCE.createHTTPResponse();
		ret.setName("HttpResponse");
		ret.setHTTPRequest(request);

		for (String lan : getLanguages()) {
			boolean exists = false;
			Language language = castLanguage(lan);
			for (LanguageText lanInput : ret.getInputs()) {
				if (lanInput.getLanguage().equals(language)) {
					exists = true;
				}
			}
			if (!exists) {
				LanguageText lanInput = GeneratorFactory.eINSTANCE.createLanguageText();
				lanInput.setLanguage(language);
				TextInput input = GeneratorFactory.eINSTANCE.createTextInput();
				HTTPRequestToke token = GeneratorFactory.eINSTANCE.createHTTPRequestToke();
				token.setType(HTTPReturnType.TEXT);
				input.getTokens().add(token);
				lanInput.getInputs().add(input);
				ret.getInputs().add(lanInput);
			}
		}
		return ret;
	}

	private List<String> getLanguages() {
		List<String> languages = new ArrayList<>();
		languages.add(getLanguage());
		languages.addAll(getSupportedLanguages());
		return languages;
	}

	public boolean isHaveLoops() {
		return haveLoops;
	}

	public void setHaveLoops(boolean haveLoops) {
		this.haveLoops = haveLoops;
	}

	public boolean isHaveeContainerLoops() {
		return haveeContainerLoops;
	}

	public void setHaveeContainerLoops(boolean haveeContainerLoops) {
		this.haveeContainerLoops = haveeContainerLoops;
	}

}

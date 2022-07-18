package es.main.parser.rasa.bot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import generator.Bot;
import generator.GeneratorFactory;
import generator.Language;
import generator.LanguageText;
import generator.Literal;
import generator.TextInput;
import generator.UserInteraction;

public class Config {

	private String language;
	private List<Map<String, Object>> policies;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Language getBotLanguage() {
		if (language == null) {
			return Language.ENGLISH;
		}
		switch (language) {
		case "en":
			return Language.ENGLISH;
		case "es":
			return Language.SPANISH;
		case "da":
			return Language.DANISH;
		case "de":
			return Language.GERMAN;
		case "fr":
			return Language.FRENCH;
		case "hi":
			return Language.HINDI;
		case "id":
			return Language.INDONESIAN;
		case "it":
			return Language.ITALIAN;
		case "ja":
			return Language.JAPANESE;
		case "ko":
			return Language.KOREAN;
		case "nl":
			return Language.DUTCH;
		case "no":
			return Language.NORWEGIAN;
		case "pl":
			return Language.POLISH;
		case "pt":
			return Language.PORTUGUESE;
		case "ru":
			return Language.RUSIAN;
		case "sv":
			return Language.SWEDISH;
		case "th":
			return Language.THAI;
		case "tr":
			return Language.TURKISH;
		case "uk":
			return Language.UKRANIAN;
		case "zh":
			return Language.CHINESE;
		default:
			return Language.ENGLISH;
		}
	}

	public List<Map<String, Object>> getPolicies() {
		if (policies == null) {
			policies = new ArrayList<Map<String, Object>>();
		}
		return policies;
	}

	public void setPolicies(List<Map<String, Object>> policies) {
		this.policies = policies;
	}

	public void setFallback(Bot bot) {
		for (Map<String, Object> policy : getPolicies()) {
			if (policy.containsKey("name") && (policy.get("name") instanceof String)) {
				if (((String) policy.get("name")).equals("FallbackPolicy")) {
					generator.Intent botIntent = GeneratorFactory.eINSTANCE.createIntent();
					botIntent.setName("FallbackIntent");
					botIntent.setFallbackIntent(true);
					bot.getIntents().add(botIntent);
					UserInteraction interaction = GeneratorFactory.eINSTANCE.createUserInteraction();
					interaction.setIntent(botIntent);

					if (policy.containsKey("fallback_action_name")
							&& (policy.get("fallback_action_name") instanceof String)) {
						String action_name = (String) policy.get("fallback_action_name");
						if (action_name.equals("action_default_fallback")) {
							action_name = "utter_default";
							if (bot.getActionStartWith(action_name).isEmpty()) {
								if (bot.getAction(action_name + "_text") == null) {
									String name = action_name + "_text";
									generator.Text action = GeneratorFactory.eINSTANCE.createText();
									action.setName(name);
									LanguageText input = GeneratorFactory.eINSTANCE.createLanguageText();
									input.setLanguage(bot.getLanguages().get(0));
									action.getInputs().add(input);

									TextInput textInput = GeneratorFactory.eINSTANCE.createTextInput();
									Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
									literal.setText("Sorry, I don't undestand you ");
									textInput.getTokens().add(literal);

									input.getInputs().add(textInput);
									bot.getActions().add(action);
								}
							}
						}

						List<generator.Action> actions = bot.getActionStartWith(action_name);
						generator.BotInteraction bInteraction = GeneratorFactory.eINSTANCE.createBotInteraction();
						bInteraction.getActions().addAll(actions);
						interaction.setTarget(bInteraction);
					}

					bot.getFlows().add(interaction);

				}
			}
		}

	}

}

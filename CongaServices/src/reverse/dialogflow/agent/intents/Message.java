package reverse.dialogflow.agent.intents;

import java.util.ArrayList;
import java.util.List;

import generator.Action;
import generator.Bot;
import generator.GeneratorFactory;
import generator.Image;
import generator.Intent;
import generator.Literal;
import generator.Parameter;
import generator.ParameterToken;
import generator.Text;
import generator.TextInput;
import generator.TextLanguageInput;
import reverse.dialogflow.agent.Agent;

public class Message {
	private String type;
	private String lang;
	private List<String> speech;
	private String imageUrl;

	private static final int TEXT_TYPE = 0;
	private static final int IMAGE_TYPE = 3;

//	public int getType() {
//		return (int)type;
//	}
//	public void setType(int type) {
//		this.type = type;
//	}

	public int getType() {
		try {
			return Integer.parseInt(type);
		} catch (Exception e) {
			return -1;
		}
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLang() {
		if (lang == null) {
			lang = "";
		}
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public List<String> getSpeech() {
		if (speech == null) {
			speech = new ArrayList<>();
		}
		return speech;
	}

	public void setSpeech(List<String> speech) {
		this.speech = speech;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Action getBotAction(Intent intent, int textCounter, int imgCounter, Bot bot, Agent agent) {
		if (getType() == IMAGE_TYPE) {
			String actionName = intent.getName() + "ImgResp" + imgCounter;
			Image ret = GeneratorFactory.eINSTANCE.createImage();
			ret.setName(actionName);
			ret.setURL(getImageUrl());
			return ret;
		} else {

			TextLanguageInput textLang = GeneratorFactory.eINSTANCE.createTextLanguageInput();
			textLang.setLanguage(Agent.castLanguage(getLang()));
			if (getSpeech().isEmpty()) {
				textLang.getInputs().add(createTextInputs("", intent, agent, bot));
			}
			for (String textString : getSpeech()) {
				textLang.getInputs().add(createTextInputs(textString, intent, agent, bot));
			}

			for (int j = 1; j <= textCounter; j++) {
				String actionName = intent.getName() + "TxtResp" + j;
				Action ret = bot.getAction(actionName);
				if (ret != null && ret instanceof Text) {
					TextLanguageInput aux = ((Text) ret).getInput(Agent.castLanguage(getLang()));
					if (aux == null) {
						((Text) ret).getInputs().add(textLang);
						return ((Text) ret);
					}
				}
			}

			String actionName = intent.getName() + "TxtResp" + textCounter;
			Text ret = GeneratorFactory.eINSTANCE.createText();
			ret.setName(actionName);
			((Text) ret).getInputs().add(textLang);
			return ret;
		}
	}

	private static TextInput createTextInputs(String text, Intent intent, Agent agent, Bot bot) {
		TextInput ret = GeneratorFactory.eINSTANCE.createTextInput();

		String input = "";
		for (String split : text.split(" ")) {
			if (split.startsWith("$")) {
				if (!input.isEmpty()) {
					Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
					literal.setText(input);
					ret.getTokens().add(literal);
					input = "";
				}
				Parameter param = intent.getParameter(split.replace("$", ""));
				if (param != null) {
					ParameterToken token = GeneratorFactory.eINSTANCE.createParameterToken();
					token.setParameter(param);
					ret.getTokens().add(token);
				}
			} else if (split.startsWith("#")) {
				String[] paramValues = split.split("\\.");
				if (paramValues.length != 2) {
					input += split;
				} else {
					if (!input.isEmpty()) {
						Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
						literal.setText(input);
						ret.getTokens().add(literal);
						input = "";
					}
					String context = paramValues[0].replace("#", "");
					String name = paramValues[1].replaceAll(",|;", "");
					reverse.dialogflow.agent.intents.Intent fromI = agent.getIntentsByAffectedContext(context);
					if (fromI != null) {
						Intent from = fromI.getBotIntent(bot);
						Parameter param = from.getParameter(name);
						if (param != null) {
							ParameterToken token = GeneratorFactory.eINSTANCE.createParameterToken();
							token.setParameter(param);
							ret.getTokens().add(token);
						}
					}
				}
			} else {
				input += split + " ";
			}
		}
		if (!input.isEmpty()) {
			Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
			literal.setText(input);
			ret.getTokens().add(literal);
			input = "";
		}
		return ret;
	}

	public static Action emptyAction(Intent intent, Bot bot) {
		String actionName = intent.getName() + "TxtResp";
		Text ret = GeneratorFactory.eINSTANCE.createText();
		ret.setName(actionName);

		TextLanguageInput textLang = GeneratorFactory.eINSTANCE.createTextLanguageInput();
		textLang.setLanguage(bot.getLanguages().get(0));
		textLang.getInputs().add(createTextInputs("", intent, null, bot));
		((Text) ret).getInputs().add(textLang);
		return ret;
	}

}
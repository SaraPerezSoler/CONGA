package es.main.parser.rasa.bot.stories;

import java.util.ArrayList;
import java.util.List;

import es.main.parser.rasa.bot.Domain;
import generator.Bot;
import generator.GeneratorFactory;
import generator.Intent;

public class UserInteraction {
	private String intent;
	private BotInteraction next;
	private List<generator.UserInteraction> generated;

	public UserInteraction(String info) {
		intent = info.substring(info.indexOf("* ") + "* ".length(), info.indexOf("\n"));
		intent = intent.replaceAll("\\{.*\\}", "").replaceAll("[^A-Za-z0-9_\\-/]", "");
		if (intent.contains(" ")) {
			intent = intent.substring(0, intent.indexOf(" "));
		}
		if (intent.endsWith(":")) {
			intent = intent.substring(0, intent.length() - ":".length());
		}

		info = info.substring(info.indexOf("\n") + "\n".length());
		if (!info.isBlank() && !info.isEmpty()) {
			next = new BotInteraction(info);
		}
	}

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}

	public BotInteraction getNext() {
		return next;
	}

	public void setNext(BotInteraction next) {
		this.next = next;
	}

	public List<generator.UserInteraction> getBotUserInteraction(Bot bot) {
		Intent intent = bot.getIntent(getIntent());
		if (intent == null) {
			intent = bot.getIntent(getIntent()+"Intent");
		}
		List<Intent> intents = new ArrayList<Intent>();
		
		if (intent == null) {
			intents.addAll(bot.getIntentStartsWith(getIntent() + "/"));
		} else {
			intents.add(intent);
		}

		if (intents.isEmpty()) {
			String name = getIntent();
			if (bot.containsElement(name)) {
				name = name+"Intent";
			}
			intent = GeneratorFactory.eINSTANCE.createIntent();
			intent.setName(name);
			bot.getIntents().add(intent);
			intents.add(intent);
		}

		List<generator.UserInteraction> ret = new ArrayList<generator.UserInteraction>();

		for (Intent i : intents) {
			generator.UserInteraction interacction = GeneratorFactory.eINSTANCE.createUserInteraction();
			interacction.setIntent(i);
			if (next != null) {
				interacction.setTarget(next.getBotBotInteraction(bot));
			}
			ret.add(interacction);
		}
		this.generated = ret;
		return ret;

	}

	public void setParameters(Bot bot) {
		if (next != null) {
			next.setParameters(bot);
		}
	}

	@Override
	public String toString() {
		if (next!=null) {
			return "user "+ intent +"=>"+next.toString(); 
		}else {
			return "user "+ intent +";";
		}
	}

}

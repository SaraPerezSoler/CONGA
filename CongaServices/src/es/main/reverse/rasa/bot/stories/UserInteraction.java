package es.main.reverse.rasa.bot.stories;

import es.main.reverse.rasa.bot.Domain;
import generator.Bot;
import generator.GeneratorFactory;
import generator.Intent;

public class UserInteraction {
	private String intent;
	private BotInteraction next;
	private generator.UserInteraction generated;

	public UserInteraction(String info) {
		intent = info.substring(info.indexOf("* ") + "* ".length(), info.indexOf("\n"));
		intent = intent.replaceAll("\\{.*\\}", "");
		if (intent.contains(" ")) {
			intent = intent.substring(0, intent.indexOf(" "));
		}
		if (intent.endsWith(":")) {
			intent = intent.substring(0, intent.length()-":".length());
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

	public generator.UserInteraction getBotUserInteraction(Bot bot) {
		Intent intent = bot.getIntent(getIntent());
		if (intent == null) {
			intent = GeneratorFactory.eINSTANCE.createIntent();
			intent.setName(getIntent());
			bot.getIntents().add(intent);
		}

		generator.UserInteraction interacction = GeneratorFactory.eINSTANCE.createUserInteraction();
		interacction.setIntent(intent);
		if (next != null) {
			interacction.setTarget(next.getBotBotInteraction(bot));
		}
		this.generated = interacction;
		return interacction;

	}

	public void setParameters(Bot bot) {
		if (next != null) {
			next.setParameters(bot);
		}
		
	}

}

package reverse.rasa.bot.stories;

import generator.Bot;
import generator.GeneratorFactory;
import generator.Intent;

public class UserInteraction {
	private String intent;
	private BotInteraction next;

	public UserInteraction(String info) {
		intent = info.substring(info.indexOf("* ") + "* ".length(), info.indexOf("\n"));
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
		if (intent != null) {
			generator.UserInteraction interacction = GeneratorFactory.eINSTANCE.createUserInteraction();
			interacction.setIntent(intent);
			if (next !=null) {
				interacction.setTarget(next.getBotBotInteraction(bot));
			}
			return interacction;
		}
		return null;
	}

}

package reverse.rasa.bot.intents;

import generator.Bot;

public abstract class Token {

	protected abstract generator.Token createBotToken(Bot bot, generator.Intent intent);

	
}

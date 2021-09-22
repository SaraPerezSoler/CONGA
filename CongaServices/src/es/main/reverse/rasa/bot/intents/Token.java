package es.main.reverse.rasa.bot.intents;

import generator.Bot;

public abstract class Token {

	protected abstract generator.Token createBotToken(Bot bot, generator.Intent intent);

	
}

package reverse.rasa.bot.intents;

import generator.Bot;
import generator.GeneratorFactory;

public class Literal extends Token {
	private String text;
	
	public Literal(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	protected generator.Token createBotToken(Bot bot, generator.Intent intent) {
		generator.Literal lit = GeneratorFactory.eINSTANCE.createLiteral();
		lit.setText(text);
		return lit;
	}
	
	
}

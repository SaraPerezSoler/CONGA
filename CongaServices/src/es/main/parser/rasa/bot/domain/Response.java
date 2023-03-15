package es.main.parser.rasa.bot.domain;

import java.util.ArrayList;
import java.util.List;

import generator.Bot;
import generator.GeneratorFactory;
import generator.Literal;
import generator.TextInput;

public class Response {

	private String text;
	private String image;
	private List<Button> buttons = new ArrayList<Button>();
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}

	public TextInput getTextInput(Bot bot) {
		TextInput ret = GeneratorFactory.eINSTANCE.createTextInput(); 
		Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
		literal.setText(text);
		ret.getTokens().add(literal);
		return ret;
	}


}

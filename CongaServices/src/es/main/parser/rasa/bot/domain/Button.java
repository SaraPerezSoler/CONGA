package es.main.parser.rasa.bot.domain;

import generator.GeneratorFactory;

public class Button {
	private String payload;
	private String title;
	private String text;
	
	public Button() {
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public generator.Button getButton() {
		generator.Button button = GeneratorFactory.eINSTANCE.createButton();
		if (title != null && !title.isEmpty()) {
			button.setValue(title);
		}else if (text != null && !text.isEmpty()) {
			button.setValue(text);
		}else {
			button.setValue(payload);
		}
		button.setAction(payload);
		return button;
	}
 
}

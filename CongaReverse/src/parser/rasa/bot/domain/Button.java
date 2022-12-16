package parser.rasa.bot.domain;

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

 
}

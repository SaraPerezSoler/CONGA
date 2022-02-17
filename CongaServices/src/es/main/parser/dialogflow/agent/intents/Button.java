package es.main.parser.dialogflow.agent.intents;

import generator.GeneratorFactory;

public class Button {

	private String text;
	private String postback;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPostback() {
		return postback;
	}
	public void setPostback(String postback) {
		this.postback = postback;
	}
	public generator.Button getBotButton() {
		generator.Button ret = GeneratorFactory.eINSTANCE.createButton();
		ret.setValue(getText());
		ret.setAction(getPostback());
		return ret;
	}
	
	
}

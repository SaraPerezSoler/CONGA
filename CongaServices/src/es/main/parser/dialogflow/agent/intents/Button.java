package es.main.parser.dialogflow.agent.intents;

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
	
	
}

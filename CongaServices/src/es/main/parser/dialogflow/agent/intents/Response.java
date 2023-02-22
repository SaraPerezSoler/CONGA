package es.main.parser.dialogflow.agent.intents;

import java.util.ArrayList;
import java.util.List;

import es.main.parser.dialogflow.agent.Agent;
import generator.Action;
import generator.Bot;
import generator.ButtonAction;
import generator.Image;
import generator.Text;

public class Response {
	private List<Context> affectedContexts = new ArrayList<Context>();
	private List<Parameter> parameters = new ArrayList<>();
	private List<Message> messages = new ArrayList<>();
	private int textCounter = 1;
	private int imgCounter = 1;
	private int buttonCounter = 1;

	public List<Context> getAffectedContexts() {
		return affectedContexts;
	}

	public void setAffectedContexts(List<Context> affectedContext) {
		this.affectedContexts = affectedContext;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Action> getBotActions(generator.Intent intent, Bot bot, Agent agent) {
		List<Action> ret = new ArrayList<>();
		for (Message message : getMessages()) {
			Action act = message.getBotAction(intent, textCounter, imgCounter, buttonCounter, bot, agent);
			if (act != null) {
				if (act instanceof Text) {
					textCounter++;
				} else if (act instanceof Image) {
					imgCounter++;
				} else if (act instanceof ButtonAction) {
					buttonCounter++;
				}
				ret.add(act);
			}
		}
		return ret;
	}

	public boolean containsAffextedContext(String contextName) {
		for (Context context : getAffectedContexts()) {
			if (context.getName().equals(contextName)) {
				return true;
			}
		}
		return false;
	}

}
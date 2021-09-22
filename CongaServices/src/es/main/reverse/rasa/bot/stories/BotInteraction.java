package es.main.reverse.rasa.bot.stories;

import java.util.ArrayList;
import java.util.List;

import es.main.reverse.rasa.bot.Domain;
import generator.Action;
import generator.Bot;
import generator.GeneratorFactory;
import generator.Literal;
import generator.Parameter;
import generator.ParameterToken;
import generator.Text;
import generator.TextInput;
import generator.Token;

public class BotInteraction {
	private List<String> actions = new ArrayList<>();
	private UserInteraction next;
	private generator.BotInteraction generated;

	public BotInteraction(String info) {
		int index = info.indexOf("*");
		String text;
		if (index == -1) {
			text = info;
		} else {
			text = info.substring(0, index);
		}

		String[] actionsNames = text.replace(" \n", "").replace("\n", "").replace("  ", " ").replace("  ", " ").replace("- ", "-")
				.replace(" -", "-").split("-");
		for (String act : actionsNames) {
			if (!act.isBlank() && !act.isEmpty()) {
				actions.add(act);
			}
		}

		if (index != -1) {
			info = info.substring(index);
			next = new UserInteraction(info);
		}
	}

	public List<String> getActions() {
		return actions;
	}

	public void setActions(List<String> actions) {
		this.actions = actions;
	}

	public void addAction(String action) {
		actions.add(action);
	}

	public UserInteraction getNext() {
		return next;
	}

	public void setNext(UserInteraction next) {
		this.next = next;
	}

	public generator.BotInteraction getBotBotInteraction(Bot bot) {
		List<Action> actions = new ArrayList<>();
		for (String action : this.actions) {
			actions.addAll(bot.getActionStartWith(action));
		}

		generator.BotInteraction botInteraction = GeneratorFactory.eINSTANCE.createBotInteraction();

		if (actions.isEmpty()) {
			if (bot.getAction(Domain.defaultEmptyAction.getName()) == null) {
				bot.getActions().add(Domain.defaultEmptyAction);
			}
			actions.add(Domain.defaultEmptyAction);
		}
		botInteraction.getActions().addAll(actions);
		if (next != null) {
			botInteraction.getOutcoming().add(next.getBotUserInteraction(bot));
		}
		this.generated = botInteraction;
		return botInteraction;
	}
	
	public void setParameters(Bot bot) {
		for (Action action: this.generated.getActions()) {
			if (action instanceof Text) {
				getParameter((Text)action, this.generated);
			}
		}
		if (next!=null) {
			next.setParameters(bot);
			
		}
	}
	
	
	
	private void getParameter(Text action, generator.BotInteraction interaction){
		
		for (TextInput input: action.getInputs().get(0).getInputs()) {
			List<Token> list = new ArrayList<>();
			list.addAll(input.getTokens());
			input.getTokens().clear();
			for (Token token: list) {
				if (token instanceof Literal) {
					String text = ((Literal)token).getText();
					while (text.contains("{") && text.contains("}")) {
						String literal = text.substring(0, text.indexOf("{"));
						String param = text.substring(text.indexOf("{")+1, text.indexOf("}"));
						text = text.substring(text.indexOf("}")+1);
						if (!literal.isEmpty() && !literal.isBlank()) {
							Literal lit = GeneratorFactory.eINSTANCE.createLiteral();
							lit.setText(literal);
							input.getTokens().add(lit);
						}
						
						if (!param.isEmpty() && !param.isBlank()) {
							Parameter parameter = findParam(param, interaction);
							if (parameter==null) {
								Literal lit = GeneratorFactory.eINSTANCE.createLiteral();
								lit.setText(param);
								input.getTokens().add(lit);
							}else {
								ParameterToken paramToken = GeneratorFactory.eINSTANCE.createParameterToken();
								paramToken.setParameter(parameter);
								input.getTokens().add(paramToken);
							}
						}
					}
					if (!text.isEmpty() && !text.isBlank()) {
						Literal lit = GeneratorFactory.eINSTANCE.createLiteral();
						lit.setText(text);
						input.getTokens().add(lit);
					}
				}else {
					input.getTokens().add(token);
				}
			}
			
		}
	}
	
	private Parameter findParam (String paramName, generator.BotInteraction interaction) {
		if (interaction.getIncoming().getIntent().getParameter(paramName)!=null) {
			return interaction.getIncoming().getIntent().getParameter(paramName);
		}
		if (interaction.getIncoming().getSrc() == null) {
			return null;
		}else {
			return findParam(paramName, interaction.getIncoming().getSrc());
		}
	}

}

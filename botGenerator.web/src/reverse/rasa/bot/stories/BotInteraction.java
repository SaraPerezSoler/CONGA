package reverse.rasa.bot.stories;

import java.util.ArrayList;
import java.util.List;

import generator.Action;
import generator.Bot;
import generator.GeneratorFactory;
import reverse.rasa.bot.Domain;

public class BotInteraction {
	private List<String> actions = new ArrayList<>();
	private UserInteraction next;

	public BotInteraction(String info) {
		int index = info.indexOf("*");
		String text;
		if (index == -1) {
			text = info;
		} else {
			text = info.substring(0, index);
		}
		String[] actionsNames = text.replace("\n", "").replace("  ", " ").replace("  ", " ").replace("- ", "-")
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
			actions.addAll(bot.getActionsContains(action));
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

		return botInteraction;
	}

}

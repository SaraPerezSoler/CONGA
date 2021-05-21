package reverse.rasa.bot;

import java.util.ArrayList;
import java.util.List;

import generator.Bot;
import generator.BotInteraction;
import generator.Comparable;
import reverse.rasa.bot.stories.UserInteraction;

public class Stories {

	private List<UserInteraction> paths = new ArrayList<>();

	public Stories(String stories) {
		String[] pathsStrings = stories.split("##");
		for (String p : pathsStrings) {
			if (!p.isBlank() && !p.isEmpty()) {
				String s = p.substring(p.indexOf("*"));
				paths.add(new UserInteraction(s));
			}
		}
	}

	public void saveBotFlows(Bot bot) {
		for (UserInteraction path : paths) {
			generator.UserInteraction currentInteraction = path.getBotUserInteraction(bot);
			boolean hasSimilarPath = false;
			for (generator.UserInteraction userInteraction : bot.getFlows()) {
				if (compareUserInteraction(userInteraction, currentInteraction)) {
					hasSimilarPath = true;
					break;
				}
			}
			if (!hasSimilarPath) {
				bot.getFlows().add(currentInteraction);
			}

		}
	}

	private boolean compareUserInteraction(generator.UserInteraction interaction1, generator.UserInteraction current) {
		if (current.getIntent().isSimilarTo(interaction1.getIntent())) {
			if (current.getTarget() != null && interaction1.getTarget() != null) {
				compareBotInteraction(interaction1.getTarget(), current.getTarget());
			} else if (current.getTarget() != null && interaction1.getTarget() == null) {
				interaction1.setTarget(current.getTarget());
			}
			return true;
		} else {
			return false;
		}
	}

	private void compareBotInteraction(BotInteraction interaction1, BotInteraction current) {
		if (!Comparable.isSimilarStatic(current.getActions(), interaction1.getActions())) {
			interaction1.getActions().addAll(current.getActions());
		}
		boolean hasSimilarPath = false;
		generator.UserInteraction currentNext = current.getOutcoming().get(0);
		for (generator.UserInteraction next : interaction1.getOutcoming()) {
			if (compareUserInteraction(next, currentNext)) {
				hasSimilarPath = true;
				break;
			}
		}
		if (!hasSimilarPath) {
			interaction1.getOutcoming().add(currentNext);
		}

	}

}

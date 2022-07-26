package es.main.parser.rasa.bot;

import java.util.ArrayList;
import java.util.List;

import es.main.parser.rasa.bot.stories.UserInteraction;
import generator.Bot;
import generator.BotInteraction;
import generator.Comparable;

public class Stories {

	private List<UserInteraction> paths = new ArrayList<>();

	public Stories(String stories) {
		add(stories);
	}

	public void add(String stories) {
		stories = stories.replaceAll("<!--.*-->", "");
		while (stories.contains("  ")) {
			stories = stories.replace("  ", " ");
		}
		stories = stories.replace(" \n", "\n").replace("\r", "").replaceAll("\n# ", "\n## ");
		String[] pathsStrings = stories.split("##");
		for (String p : pathsStrings) {
			if (!p.isBlank() && !p.isEmpty()) {
				if (p.indexOf("*") != -1) {
					String s = p.substring(p.indexOf("*"));
					paths.add(new UserInteraction(s));
				}
			}
		}

	}

	public void saveBotFlows(Bot bot) {
		for (UserInteraction path : paths) {
			List<generator.UserInteraction> currentInteractions = path.getBotUserInteraction(bot);
			boolean hasSimilarPath = false;
			for (generator.UserInteraction ci : currentInteractions) {
				for (generator.UserInteraction userInteraction : bot.getFlows()) {
					if (compareUserInteraction(userInteraction, ci)) {
						hasSimilarPath = true;
						break;
					}
				}
				if (!hasSimilarPath) {
					bot.getFlows().add(ci);
				}
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
		if (!current.getOutcoming().isEmpty()) {
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

	public void setParameters(Bot bot) {
		for (UserInteraction interaction : this.paths) {
			interaction.setParameters(bot);
		}

	}

}

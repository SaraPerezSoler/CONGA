package es.main.parser.rasa.bot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import es.main.parser.rasa.bot.stories.UserInteraction;
import generator.Bot;
import generator.BotInteraction;
import generator.Comparable;

public class Stories {

	private List<UserInteraction> paths = new ArrayList<>();
	private int n = 3;

	public Stories(String stories) {
		add(stories);
	}

	public void add(String stories) {
		stories = stories.replaceAll("<!--.*-->", "");
		while (stories.contains("  ")) {
			stories = stories.replace("  ", " ");
		}
		Map<String, List<String>> checkpoints = new HashMap<>();
		stories = stories.replace(" \n", "\n").replaceAll("\n# ", "\n## ");
		String[] pathsStrings = stories.split("##");
		String storiesToAdd = "";
		for (String story : pathsStrings) {
			if (!story.isBlank() && !story.isEmpty()) {
				if (story.contains("checkpoint:")) {
					String[] data = story.split("- checkpoint:");
					String initialCheckpoint = "";
					if (data.length == 2) {
						if (data[1].split("\n").length > 1 && !data[1].split("\n")[1].isBlank()
								&& !data[1].split("\n")[1].isEmpty()) {
							initialCheckpoint = data[1].split("\n")[0];
						}
					}
					if (data.length == 3) {
						initialCheckpoint = data[1].split("\n")[0];
					}
					initialCheckpoint = initialCheckpoint.replaceAll(" ", "");

					if (!initialCheckpoint.isEmpty() && !initialCheckpoint.isBlank()) {
						List<String> checks = new ArrayList<>();
						String storyToAdd = getCheckpointData(story);
						if (checkpoints.keySet().contains(initialCheckpoint)) {
							checks = checkpoints.get(initialCheckpoint);
						}
						checks.add(storyToAdd);
						checkpoints.put(initialCheckpoint, checks);
					} else {
						storiesToAdd += "## " + story;
					}
				} else {
					storiesToAdd += "## " + story;
				}
			}
		}
		storiesToAdd = completeStoriesWithCheckpoints(storiesToAdd, checkpoints);
		storiesToAdd = completeStoriesWithOrStatement(storiesToAdd);
		pathsStrings = storiesToAdd.split("##");
		for (String p : pathsStrings) {
			if (!p.isBlank() && !p.isEmpty()) {
				if (p.indexOf("*") != -1) {
					String s = p.substring(p.indexOf("*"));
					paths.add(new UserInteraction(s));
				}
			}
		}

	}

	private String completeStoriesWithOrStatement(String stories) {
		String allStories = "";

		for (String story : stories.split("##")) {
			if (!story.isBlank() && !story.isEmpty()) {
				if (story.contains("- or:")) {

					String control = story;

					while (control.contains("- or:")) {

						String storiesControl = "";
						for (String storyControl : control.split("##")) {
							if (!storyControl.isEmpty() && !storyControl.isBlank()) {
								if (storyControl.contains("- or:")) {
									String[] data = storyControl.split("- or:", 2);
									String storyBeforeOr = data[0];
									String storyAfterOr = "";
									Boolean isOrData = true;
									String orData = "";
									for (String line : data[1].split(System.lineSeparator())) {
										if (!line.isBlank()) {
											if (line.contains("*") && isOrData) {
												orData += line + System.lineSeparator();
											} else {
												if (line.contains("- action")) {
													isOrData = isOrData && line.contains("*");
												}
												if (!isOrData) {
													storyAfterOr += line + System.lineSeparator();
												}
											}
										}
									}
									for (String intent : orData.split(System.lineSeparator())) {
										String storyToAdd = storyBeforeOr + System.lineSeparator() + intent
												+ System.lineSeparator() + storyAfterOr;
										storiesControl += "##" + storyToAdd + System.lineSeparator();
									}
								} else {
									storiesControl += "##" + storyControl + System.lineSeparator();
								}
							}
						}
						control = storiesControl;
					}
					allStories += control;
				} else {
					allStories += "##" + story + System.lineSeparator();
				}
			}
		}

		return allStories;
	}

	private String completeStoriesWithCheckpoints(String stories, Map<String, List<String>> checkpoints) {
		String allStories = "";

		for (String story : stories.split("##")) {
			if (!story.isBlank() && !story.isEmpty()) {
				if (story.contains("checkpoint:")) {

					String control = story;

					while (control.contains("checkpoint:")) {

						String storiesControl = "";
						for (String storyControl : control.split("##")) {
							if (!storyControl.isEmpty() && !storyControl.isBlank()) {
								if (storyControl.contains("checkpoint:")) {

									String[] data = storyControl.split("- checkpoint:");
									String finalCheckpoint = "";
									if (data.length == 2) {
										if (!(data[1].split("\n").length > 1 && !data[1].split("\n")[1].isBlank()
												&& !data[1].split("\n")[1].isEmpty())) {
											finalCheckpoint = data[1].split("\n")[0];
										}
									}
									if (data.length == 3) {
										finalCheckpoint = data[2].split("\n")[0];
									}
									finalCheckpoint = finalCheckpoint.replaceAll(" ", "");
									if (!finalCheckpoint.isEmpty() && !finalCheckpoint.isBlank()) {
										for (String key : checkpoints.keySet()) {

											if (key.contains(finalCheckpoint)) {
												String storyWithFinalCkp = storyControl;
												storyWithFinalCkp = storyWithFinalCkp
														.replaceAll("- checkpoint: " + key, "")
														.replaceAll("- checkpoint:" + key, "")
														.replaceAll("- checkpoint: " + key + " ", "")
														.replaceAll("- checkpoint:" + key + " ", "")
														.replaceAll("- checkpoint:", "")
														.replaceAll(key.replaceAll("\r", ""), "")
														.replaceAll("(?m)^(?:\\h*\\n)+", "");
												for (String checkpointData : checkpoints.get(key)) {
													String storyToAdd = storyWithFinalCkp;
													storyToAdd += checkpointData;
													storyToAdd = storyToAdd.replaceAll("(?m)^(?:\\h*\\n)+", "");
													if (countCkpInStory(storyControl, checkpointData) >= n) {
														storiesControl += "##" + storyWithFinalCkp + "\n\n";
													} else {
														storiesControl += "##" + storyToAdd + "\n\n";
													}

												}
											}
										}
									}
								} else {
									storiesControl += "##" + storyControl + "\n\n";
								}
							}
						}
						control = storiesControl;
					}

					allStories += control;

				} else {
					allStories += "##" + story;
				}
			}
		}

		return allStories;
	}

	private int countCkpInStory(String story, String ckp) {
		String[] lines = ckp.split("\n");
		StringBuilder sb = new StringBuilder();

		for (String line : lines) {
			if (!line.contains("- checkpoint:")) {
				sb.append(line).append("\n");
			}
		}

		ckp = sb.toString();
		return story.split(ckp).length - 1;
	}

	private String getCheckpointData(String story) {
		String data = "";
		Boolean initialCheckpoint = false;
		for (String line : story.split("\n")) {
			if (initialCheckpoint) {
				data += line + "\n";
			}
			if (line.contains("- checkpoint:")) {
				initialCheckpoint = true;
			}
		}
		return data;
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

	public void setRequiredParameters(Bot bot, Domain domain) {
		for (UserInteraction interaction : this.paths) {
			interaction.setRequiredParameters(bot, domain);
		}
	}

}

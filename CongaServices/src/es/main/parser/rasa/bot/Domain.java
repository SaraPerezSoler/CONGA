package es.main.parser.rasa.bot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.main.parser.rasa.bot.domain.Button;
import es.main.parser.rasa.bot.domain.Response;
import es.main.parser.rasa.bot.domain.Slot;
import generator.Action;
import generator.Bot;
import generator.ButtonAction;
import generator.Empty;
import generator.GeneratorFactory;
import generator.Image;
import generator.LanguageButton;
import generator.Text;
import generator.LanguageText;

public class Domain {

	private List<Object> intents = new ArrayList<>();
	private List<String> entities = new ArrayList<>();
	private List<String> actions = new ArrayList<>();
	private List<String> forms = new ArrayList<>();
	private Map<String, Slot> slots;
	private Map<String, List<Response>> responses;
	public static Action defaultEmptyAction;

	private int num_actions = 0;
	private int num_forms = 0;
	
	public static final String TEXT_SUFIX= "_text";
	public static final String IMG_SUFIX= "_img";
	public static final String BUTTON_SUFIX= "_btn";
	public static final String EMPTY_SUFIX= "_empty";
	

	public List<Object> getIntents() {
		return intents;
	}

	public void setIntents(List<Object> intents) {
		this.intents = intents;
	}

	public List<String> getEntities() {
		return entities;
	}

	public void setEntities(List<String> entities) {
		this.entities = entities;
	}

	public List<String> getActions() {
		return actions;
	}

	public void setActions(List<String> actions) {
		this.actions = actions;
	}

	public List<String> getForms() {
		return forms;
	}

	/*
	 * public void setForms(List<String> forms) {
	 * 
	 * this.forms = forms; }
	 */

	public void setForms(Object forms) {
		if (forms instanceof List<?>) {
			this.forms = (List<String>) forms;
		} else if (forms instanceof Map<?, ?>) {
			this.forms = new ArrayList<>();
			this.forms.addAll(((Map<String, Object>) forms).keySet());
		}
	}

	public Map<String, Slot> getSlots() {
		return slots;
	}

	public void setSlots(Map<String, Slot> slots) {
		this.slots = slots;
	}

	public Map<String, List<Response>> getResponses() {
		return responses;
	}

	public void setResponses(Map<String, List<Response>> responses) {
		this.responses = responses;
	}

	public void setTemplates(Map<String, List<Response>> responses) {
		this.responses = responses;
	}

	public void saveBotActions(Bot bot) {
		defaultEmptyAction = GeneratorFactory.eINSTANCE.createEmpty();
		defaultEmptyAction.setName("DefaultEmptyAction");
		Set<String> actions = new HashSet<>();
		actions.addAll(getActions());
		actions.addAll(this.responses.keySet());

		for (String actionName : actions) {
			if (responses.containsKey(actionName)) {
				int imageCount = 1;
				int buttonCount = 1;
				int emptyCount = 1;
				Text text = null;
				Image image = null;
				ButtonAction button = null;
				List<Response> responses = this.responses.get(actionName);
				for (Response response : responses) {
					if (response.getImage() != null && !response.getImage().isEmpty()
							&& !response.getImage().isBlank()) {
						String name = actionName + IMG_SUFIX;
						if (imageCount != 1) {
							name += imageCount;
						}
						image = GeneratorFactory.eINSTANCE.createImage();
						image.setName(name);
						image.setURL(response.getImage());
						image.setCaption(response.getText());
						imageCount++;
						bot.getActions().add(image);
					} else if (!response.getButtons().isEmpty()) {
						String name = actionName + BUTTON_SUFIX;
						if (buttonCount != 1) {
							name += buttonCount;
						}
						button = GeneratorFactory.eINSTANCE.createButtonAction();
						button.setName(name);
						LanguageButton input = GeneratorFactory.eINSTANCE.createLanguageButton();
						input.setLanguage(bot.getLanguages().get(0));
						for (Button b : response.getButtons()) {
							input.getButtons().add(b.getButton());
						}
						button.getInputs().add(input);
						bot.getActions().add(button);
						if(response.getText()!=null && !response.getText().isEmpty()) {
							input.getInputs().add(response.getTextInput(bot));
						}
					} else if (response.getText() != null && !response.getText().isEmpty()
							&& !response.getText().isBlank()) {
						if (text == null) {
							String name = actionName + TEXT_SUFIX;
							text = GeneratorFactory.eINSTANCE.createText();
							text.setName(name);
							LanguageText input = GeneratorFactory.eINSTANCE.createLanguageText();
							input.setLanguage(bot.getLanguages().get(0));
							text.getInputs().add(input);
							bot.getActions().add(text);
						}
						text.getInputs().get(0).getInputs().add(response.getTextInput(bot));
					} else {
						String name = actionName + EMPTY_SUFIX;
						if (emptyCount != 1) {
							name += emptyCount;
						}
						Empty empty = GeneratorFactory.eINSTANCE.createEmpty();
						empty.setName(name);
						emptyCount++;
						bot.getActions().add(empty);
						empty.setDescription("UNKNOWN_RASA");
					}
				}

			} else {
				String name = actionName + EMPTY_SUFIX;
				Empty empty = GeneratorFactory.eINSTANCE.createEmpty();
				empty.setName(name);
				empty.setDescription("RASA_ACTION");
				bot.getActions().add(empty);
				num_actions++;
				
			}
		}

		for (String formName : forms) {
			String name = formName + EMPTY_SUFIX;
			Empty empty = GeneratorFactory.eINSTANCE.createEmpty();
			empty.setName(name);
			empty.setDescription("RASA_FORM");
			bot.getActions().add(empty);
			num_forms++;
		}
	}

	public int getNum_actions() {
		return num_actions;
	}

	public void setNum_actions(int num_actions) {
		this.num_actions = num_actions;
	}

	public int getNum_forms() {
		return num_forms;
	}

	public void setNum_forms(int num_forms) {
		this.num_forms = num_forms;
	}

}

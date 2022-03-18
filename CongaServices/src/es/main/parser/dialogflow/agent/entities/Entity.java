package es.main.parser.dialogflow.agent.entities;

import java.util.ArrayList;
import java.util.List;

import es.main.parser.dialogflow.agent.Agent;
import generator.EntityInput;
import generator.GeneratorFactory;
import generator.LanguageInput;
import generator.RegexInput;
import generator.SimpleInput;

public class Entity {

	private String name;
	private boolean isEnum;
	private boolean isRegexp;
	private List<EntryLanguage> entriesLanguage;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsEnum() {
		return isEnum;
	}

	public void setIsEnum(boolean isEnum) {
		this.isEnum = isEnum;
	}

	public boolean getIsRegexp() {
		return isRegexp;
	}

	public void setIsRegexp(boolean isRegexp) {
		this.isRegexp = isRegexp;
	}

	public List<EntryLanguage> getEntriesLanguage() {
		if (entriesLanguage == null) {
			entriesLanguage = new ArrayList<EntryLanguage>();
		}
		return entriesLanguage;
	}

	public void setEntriesLanguage(List<EntryLanguage> entriesLanguage) {
		this.entriesLanguage = entriesLanguage;
	}

	public void addEntry(EntryLanguage entry) {
		if (entriesLanguage == null) {
			entriesLanguage = new ArrayList<EntryLanguage>();
		}
		entriesLanguage.add(entry);
	}

	public generator.Entity getBotEntity() {
		if (getIsRegexp() == true) {
			generator.Entity ret = GeneratorFactory.eINSTANCE.createEntity();
			ret.setName(getName());
			for (EntryLanguage entryLan : getEntriesLanguage()) {
				LanguageInput input = GeneratorFactory.eINSTANCE.createLanguageInput();
				input.setLanguage(Agent.castLanguage(entryLan.getLanguage()));
				for (Entry entry : entryLan.getEntries()) {
					RegexInput regex = GeneratorFactory.eINSTANCE.createRegexInput();
					regex.setExpresion(entry.getValue());
					input.getInputs().add(regex);
				}
				ret.getInputs().add(input);
			}
			return ret;

		} else if (getIsEnum() == false) {
			generator.Entity ret = GeneratorFactory.eINSTANCE.createEntity();
			ret.setName(getName());
			for (EntryLanguage entryLan : getEntriesLanguage()) {
				LanguageInput input = GeneratorFactory.eINSTANCE.createLanguageInput();
				input.setLanguage(Agent.castLanguage(entryLan.getLanguage()));
				for (Entry entry : entryLan.getEntries()) {
					EntityInput aux;
					if ((aux = input.getInput(entry.getValue())) != null) {
						if (aux instanceof SimpleInput) {
							for (String syn : entry.getSynonyms()) {
								if (!((SimpleInput) aux).getValues().contains(syn)) {
									((SimpleInput) aux).getValues().add(syn);
								}
							}
						}
					} else {
						SimpleInput simpleInput = GeneratorFactory.eINSTANCE.createSimpleInput();
						simpleInput.setName(entry.getValue());
						simpleInput.getValues().addAll(entry.getSynonyms());
						input.getInputs().add(simpleInput);
					}
				}
				ret.getInputs().add(input);
			}
			return ret;
		} else {
			// TODO
			return null;
		}
	}

}

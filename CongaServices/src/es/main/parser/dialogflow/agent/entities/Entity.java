package es.main.parser.dialogflow.agent.entities;

import java.util.ArrayList;
import java.util.List;

import es.main.parser.dialogflow.agent.Agent;
import generator.Bot;
import generator.CompositeInput;
import generator.EntityInput;
import generator.EntityToken;
import generator.GeneratorFactory;

import generator.LanguageEntity;
import generator.Literal;
import generator.RegexInput;
import generator.SimpleInput;
import generator.Token;

public class Entity {

	private String name;
	private boolean isEnum;
	private boolean isRegexp;
	private generator.Entity entity;
	private List<EntryLanguage> entriesLanguage;
	
	
	private static List<Entity> COMPOSITES = new ArrayList<Entity>();

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
				LanguageEntity input = GeneratorFactory.eINSTANCE.createLanguageEntity();
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
				LanguageEntity input = GeneratorFactory.eINSTANCE.createLanguageEntity();
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
			entity = ret;
			return entity;
		} else {
			COMPOSITES.add(this);
			entity = GeneratorFactory.eINSTANCE.createEntity();
			entity.setName(getName());
			return entity;
		}
	}
	
	public void getBotCompositeEntity(Bot bot) {
		if (getIsEnum()) {
			for (EntryLanguage entryLan : getEntriesLanguage()) {
				LanguageEntity input = GeneratorFactory.eINSTANCE.createLanguageEntity();
				input.setLanguage(Agent.castLanguage(entryLan.getLanguage()));
				for (Entry entry : entryLan.getEntries()) {
					CompositeInput compositeInput = GeneratorFactory.eINSTANCE.createCompositeInput();
					String[] split = entry.getValue().split(" ");
					for (String s: split) {
						Token token = null;
						if (s.startsWith("@")) {
							generator.Entity entity = bot.getEntity(s);
							if (entity!=null) {
								token = GeneratorFactory.eINSTANCE.createEntityToken();
								((EntityToken)token).setEntity(entity);
							}
						}
						if (token == null) {
							token = GeneratorFactory.eINSTANCE.createLiteral();
							((Literal)token).setText(s);
						}
						compositeInput.getExpresion().add(token);
					}
					input.getInputs().add(compositeInput);
				}
				entity.getInputs().add(input);
			}
		}
	}
	
	public static void endBotCompositeEntity(Bot bot) {
		for (Entity entity: COMPOSITES) {
			entity.getBotCompositeEntity(bot);
		}
	}

	@Override
	public String toString() {
		return "Entity [name=" + name + ", isEnum=" + isEnum + ", isRegexp=" + isRegexp + "]";
	}

}

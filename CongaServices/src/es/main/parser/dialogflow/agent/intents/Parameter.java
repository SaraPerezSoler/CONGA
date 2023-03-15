package es.main.parser.dialogflow.agent.intents;

import java.util.ArrayList;
import java.util.List;

import es.main.parser.dialogflow.agent.Agent;
import generator.Bot;
import generator.DefaultEntity;
import generator.Entity;
import generator.GeneratorFactory;
import generator.LanguagePrompt;

public class Parameter{
	private boolean required;
	private String dataType;
	private String name;
	private boolean isList;
	private List<Prompt> prompts = new ArrayList<>();
	
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public String getDataType() {
		if (dataType== null) {
			dataType="";
		}
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isList() {
		return isList;
	}
	public void setList(boolean isList) {
		this.isList = isList;
	}
	public List<Prompt> getPrompts() {
		return prompts;
	}
	public void setPrompts(List<Prompt> prompts) {
		this.prompts = prompts;
	}
	public generator.Parameter getBotParam(Bot bot) {
		generator.Parameter parameter = GeneratorFactory.eINSTANCE.createParameter();
		parameter.setName(getName());
		parameter.setIsList(isList());
		parameter.setRequired(isRequired());
		
		for (Prompt prompt : getPrompts()) {
			LanguagePrompt promptLan = parameter.getPrompt(Agent.castLanguage(prompt.getLang()));
			if (promptLan == null) {
				promptLan = GeneratorFactory.eINSTANCE.createLanguagePrompt();
				promptLan.setLanguage(Agent.castLanguage(prompt.getLang()));
				parameter.getPrompts().add(promptLan);
			}
			promptLan.getPrompts().add(prompt.getValue());
		}
		
		Entity entity = bot.getEntity(getDataType());
		if (entity == null) {
			DefaultEntity default_ = getDefaultEntity(getDataType());
			parameter.setDefaultEntity(default_);
		} else {
			parameter.setEntity(entity);
		}
		return parameter;
	}
	
	public static DefaultEntity getDefaultEntity(String dataType) {
		switch (dataType) {
		case "@sys.number-integer":
			return DefaultEntity.NUMBER;
		case "@sys.number":
			return DefaultEntity.FLOAT;
		case "@sys.date":
			return DefaultEntity.DATE;
		case "@sys.time":
			return DefaultEntity.TIME;
		default:
			return DefaultEntity.TEXT;
		}
	}
	
	
}

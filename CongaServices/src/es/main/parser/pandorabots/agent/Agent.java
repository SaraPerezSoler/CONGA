package es.main.parser.pandorabots.agent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

import generator.Action;
import generator.Bot;
import generator.Entity;
import generator.GeneratorFactory;
import generator.HTTPRequest;
import generator.Intent;
import generator.LanguageIntent;
import generator.Language;
import generator.LanguageEntity;
import generator.Literal;
import generator.SimpleInput;
import generator.Text;
import generator.TrainingPhrase;
import generator.UserInteraction;

public class Agent {
	private String name;
	private List<Category> categories;
	private List<SetFile> setFiles;
	private List<MapFile> mapFiles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void addCategories(List<Category> categories) {
		if (this.categories == null)
			this.categories = new ArrayList<Category>(categories);

		else
			this.categories.addAll(categories);
	}

	public List<SetFile> getSetFiles() {
		return setFiles;
	}

	public void setSetFiles(List<SetFile> setFiles) {
		this.setFiles = setFiles;
	}

	public void addSetFiles(List<SetFile> setFiles) {
		if (this.setFiles == null)
			this.setFiles = new ArrayList<SetFile>();

		this.setFiles.addAll(setFiles);
	}

	public void addSetFile(SetFile setFile) {
		if (this.setFiles == null)
			this.setFiles = new ArrayList<SetFile>();

		this.setFiles.add(setFile);
	}

	public List<MapFile> getMapFiles() {
		return mapFiles;
	}

	public void setMapFiles(List<MapFile> mapFiles) {
		this.mapFiles = mapFiles;
	}

	public void addMapFiles(List<MapFile> mapFiles) {
		if (this.mapFiles == null)
			this.mapFiles = new ArrayList<MapFile>();

		this.mapFiles.addAll(mapFiles);
	}

	public void addMapFile(MapFile mapFile) {
		if (this.mapFiles == null)
			this.mapFiles = new ArrayList<MapFile>();

		for (MapFile map: this.mapFiles)
			if (map.getName().equals(mapFile.getName()))
				return;
		
		this.mapFiles.add(mapFile);
	}

	@Override
	public String toString() {
		String ret = "Agent [name=" + name + "\n" + "categories=\n";

		for (Category c : categories)
			ret += c + "\n";

		return ret + "setFiles=" + setFiles + ", \n" + "mapFiles=" + mapFiles + "\n" + "]";
	}

	// Realiza las transformaciones necesarias para transformar el agente en un bot de CONGA,
	// devolviendo el resultado final
	public Bot getBot() {
		Bot bot = GeneratorFactory.eINSTANCE.createBot();

		bot.getLanguages().add(Language.ENGLISH);
		
		clearTexts();
		
		bot.setName(name);
		
		// GUARDADO DE ENTITIES
		bot.getEntities().addAll(getEntities());

		// GUARDADO DE INTENTS BÁSICOS
		bot.getIntents().addAll(getIntents(bot.getEntities()));
		
		// GUARDADO DE FLUJOS EN INTENTS
		List<UserInteraction> flows = getFlows(bot.getIntents(), bot.getEntities());
		AgentIntentsGetter.clearExtraParameters(flows);
		getOutcomingsInFlows(flows, bot);
		bot.getFlows().addAll(AgentIntentsGetter.copyFlows(flows));
		AgentIntentsGetter.clearShorterPaths(bot.getFlows());
		
		// GUARDADO DE ACTIONS
		bot.getActions().addAll(getActions(bot.getFlows()));
		
		AgentIntentsGetter.setParameterNames(bot);
		
		for (int i = 0; i < bot.getIntents().size(); i++)
			bot.getIntents().get(i).setName("Intent_" + i);
		
		return bot;
	}

	// Limpia las entradas y salidas de tipo texto que hay en los patterns y contestaciones
	// de cada category quitando espacios en blanco y saltos de línea
	public void clearTexts() {
		for (Category category: this.categories) {
			if (category.pattern != null && category.pattern.text != null)
				category.pattern.text = category.pattern.text.trim();
			
			if (category.template != null) {
				if (category.template.text != null)
					category.template.text = category.template.text.trim();
				
				if (category.template.srais != null) {
					for (Srai srai: category.template.srais) {
						if (srai.text != null) {
							srai.text = srai.text.trim();
							
							if (srai.stars != null)
								srai.text += " ";
						}
					}
				}
				
				if (category.template.think != null) {
					if (category.template.think.text != null)
						category.template.think.text = category.template.think.text.trim();
					
					if (category.template.think.srais != null) {
						for (Srai srai: category.template.think.srais) {
							if (srai.text != null) {
								srai.text = srai.text.trim();
								
								if (srai.stars != null)
									srai.text += " ";
							}
						}
					}
				}
				
				if (category.template.condition != null)
					clearOptionsRC(category.template.condition);
			}
		}
	}
	
	// Limpia las salidas 
	public void clearOptionsRC(Condition condition) {
		for (Option option: condition.options) {
			if (option.srais != null) {
				for (Srai srai: option.srais) {
					if (srai.text != null)
						srai.text = srai.text.trim();
				}
			}
			
			if (option.think != null && option.think.srais != null) {
				for (Srai srai: option.think.srais) {
					if (srai.text != null) {
						srai.text = srai.text.trim();
						
						if (srai.stars != null)
							srai.text += " ";
					}
				}
			}
			
			if (option.condition != null)
				clearOptionsRC(option.condition);
		}
	}
	
	// Recoge las entities siempre y cuando se utilicen los maps de Pandorabots como
	// entities
	public List<generator.Entity> getEntities() {
		List<generator.Entity> entities = new ArrayList<generator.Entity>();

		if (mapFiles != null) {
			for (MapFile map : mapFiles) {
				Entity entity = GeneratorFactory.eINSTANCE.createEntity();
				LanguageEntity languageInput = GeneratorFactory.eINSTANCE.createLanguageEntity();
	
				entity.setName(map.name);
				languageInput.setLanguage(Language.ENGLISH);
	
				for (String key : map.content.keySet()) {
					SimpleInput input = GeneratorFactory.eINSTANCE.createSimpleInput();
					input.setName(key);
					input.getValues().addAll(map.content.get(key));
					languageInput.getInputs().add(input);
				}
	
				entity.getInputs().add(languageInput);
				entities.add(entity);
			}
		}
		
		return entities;
	}
	
	// Recoge los intents de Pandorabots como intents de CONGA
	public List<Intent> getIntents(List<Entity> entities) {
		List<Intent> intents = new ArrayList<Intent>();
		int fallbackFlag = 0;
		
		for (int i = 0; i < categories.size(); i++) {
			Intent intent = GeneratorFactory.eINSTANCE.createIntent();
			Category category = categories.get(i);

			if (category.pattern != null) {
				// Caso en que la categoría sólo contenga sets de tipo <set>example</set>
				if (category.pattern.text == null)
					AgentIntentsGetter.addCategoryWithOnlyPatternSets(category, intent);
	
				// Caso en que contenga texto y pueda o no contener sets
				else {
					// Caso en que contenga fechas
					if (category.pattern.text.contains("* slash * slash *")
							|| category.pattern.text.contains("*slash*slash*"))
						AgentIntentsGetter.addCategoryWithDate(category, intent, entities);
	
					// Caso en que contenga horas
					else if (category.pattern.text.contains("* colon *") || 
							 category.pattern.text.contains("*colon*"))
						AgentIntentsGetter.addCategoryWithHour(category, intent);
					
					// Caso base: intents que contengan texto y puedan o no contener parámetros
					else
						AgentIntentsGetter.addCategoryBasic(category, intent, entities);
				}
				
//				intent.setName("Intent_" + i);
			}
			
			intents.add(intent);
		}
		
		// Comprobación de si el bot tiene fallbacks, en caso contrario se añade uno
		for (Intent intent: intents) {
			if (intent.isFallbackIntent()) {
				fallbackFlag = 1;
				break;
			}
		}

		if (fallbackFlag == 0) {
			Intent fallbackIntent = GeneratorFactory.eINSTANCE.createIntent();
			LanguageIntent fallbackLanguageEntity = GeneratorFactory.eINSTANCE.createLanguageIntent();
			TrainingPhrase fallbackPhrase = GeneratorFactory.eINSTANCE.createTrainingPhrase();
			Literal fallbackLiteral = GeneratorFactory.eINSTANCE.createLiteral();
			fallbackLiteral.setText("*");
			fallbackPhrase.getTokens().add(fallbackLiteral);
			fallbackLanguageEntity.getInputs().add(fallbackPhrase);
			fallbackIntent.getInputs().add(fallbackLanguageEntity);
			fallbackIntent.setFallbackIntent(true);
			fallbackIntent.setName("Fallback");
			intents.add(fallbackIntent);
		}
		
		return intents;
	}

	// Procesa los datos de Agent para extraer los flujos de conversación
	public List<UserInteraction> getFlows(List<Intent> intents, List<Entity> entities) {
		List<UserInteraction> ret = new ArrayList<UserInteraction>();
		
		for (int i = 0; i < categories.size(); i++) {
			List<UserInteraction> categoryFlows = AgentIntentsGetter.getMainFlows(categories.get(i), intents.get(i), intents, entities);
			if (categoryFlows != null)
				ret.addAll(categoryFlows);
		}
		
		return ret;
	}
	
	// Recorre los flujos de conversación añadiendo las conexiones a profundidades superiores a 1 (outcomings)
	public void getOutcomingsInFlows(List<UserInteraction> flows, Bot bot) {
		List<Intent> newIntents = new ArrayList<Intent>();
		List<Action> newActions = new ArrayList<Action>();
		
		AgentIntentsGetter.getOutcomingsFlows(new ArrayList<UserInteraction>(flows), flows, 0, newIntents, newActions);
		bot.getActions().addAll(newActions);
		bot.getIntents().addAll(newIntents);
	}
	
	// Extrae las actions de los flujos de conversación creados anteriormente
	public List<Action> getActions(List<UserInteraction> flows) {
		List<Action> actions = new ArrayList<Action>();
		List<Action> ret = new ArrayList<Action>();
		int num = 0;
		
		for (UserInteraction flow: flows)
			actions.addAll(flow.getTarget().getActions());
		
	    // Introducción de nombres únicos en las actions
	    for (Action action: actions) {
	    	action.setName("Action_" + num);
	    	num++;
	    }
	    
	    java.util.Set<Action> s = new TreeSet<Action>(new Comparator<Action>() {
	        @Override
	        public int compare(Action a1, Action a2) {
	        	// Caso en que sean actions textuales
	        	if (a1 instanceof Text && a2 instanceof Text &&
	        		AgentIntentsGetter.equalTextInputs((Text)a1, (Text)a2)) {
	        		return 0;
	        	}
	        	
	        	// Caso en que sean actions de tipo HTTP
	        	else if (a1 instanceof HTTPRequest && a2 instanceof HTTPRequest &&
		        		AgentIntentsGetter.equalHTTPRequest((HTTPRequest)a1, (HTTPRequest)a2)) {
	        		return 0;
	        	}
	        	
	        	else
	        		return 1;
	        }
	    });
	    
        s.addAll(actions);
	    ret.addAll(s);
	    
	    // Se intercambian las actions repetidas en los flows que correspondan
	    for (UserInteraction flow: flows) {
	    	HashMap<Action, Action> changeActions = new HashMap<Action, Action>();
	    	
	    	for (Action a1: flow.getTarget().getActions()) {
	    		for (Action a2: actions) {
	    			if ((a1 instanceof Text && a2 instanceof Text &&
	    	        		AgentIntentsGetter.equalTextInputs((Text)a1, (Text)a2)) || 
	    				(a1 instanceof HTTPRequest && a2 instanceof HTTPRequest &&
	    		        		AgentIntentsGetter.equalHTTPRequest((HTTPRequest)a1, (HTTPRequest)a2))) {
	    				changeActions.put(a1, a2);
	    				break;
	    			}
	    		}
	    	}
	    	
	    	for (Action key: changeActions.keySet()) {
	    		flow.getTarget().getActions().remove(key);
	    		flow.getTarget().getActions().add(changeActions.get(key));
	    	}
	    }
	    
    	return ret;
	}
}

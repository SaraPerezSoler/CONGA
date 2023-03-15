package es.main.parser.pandorabots.agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import generator.Action;
import generator.Bot;
import generator.BotInteraction;
import generator.DefaultEntity;
import generator.Entity;
import generator.GeneratorFactory;
import generator.HTTPRequest;
import generator.Intent;
import generator.LanguageIntent;
import generator.KeyValue;
import generator.Language;
import generator.Literal;
import generator.Method;
import generator.Parameter;
import generator.ParameterReferenceToken;
import generator.LanguagePrompt;
import generator.Text;
import generator.TextInput;
import generator.LanguageText;
import generator.TrainingPhrase;
import generator.UserInteraction;

public class AgentIntentsGetter {
	//// Funciones para gestionar las distintas formas que pueden tomar los intents
	// Función para gestionar los intents que únicamente contengan argumentos de tipo <set>sample</set>
	public static void addCategoryWithOnlyPatternSets(Category category, Intent intent) {
		if (category.pattern.sets != null && !category.pattern.sets.isEmpty()) {
			LanguageIntent languageInput = GeneratorFactory.eINSTANCE.createLanguageIntent();
			TrainingPhrase phrase = GeneratorFactory.eINSTANCE.createTrainingPhrase();

			for (SetAttr set : category.pattern.sets) {
				ParameterReferenceToken parameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
				Parameter parameter = GeneratorFactory.eINSTANCE.createParameter();
				LanguagePrompt prompt = GeneratorFactory.eINSTANCE.createLanguagePrompt();
				
				parameter.setName(set.name);
				parameter.setRequired(true);
				
				prompt.setLanguage(Language.ENGLISH);
				prompt.getPrompts().add("Tell me the " + set.name);
				parameter.setName(set.name);
				parameter.getPrompts().add(prompt);
				parameter.setRequired(true);
				parameterRef.setTextReference(set.name);
				parameterRef.setParameter(parameter);
				phrase.getTokens().add(parameterRef);
				intent.getParameters().add(parameter);
			}

			languageInput.getInputs().add(phrase);
			languageInput.setLanguage(Language.ENGLISH);
			intent.getInputs().add(languageInput);
		}
	}

	// Función para gestionar los intents cuya entrada contenga fechas en el formato DD/MM/AA
	public static void addCategoryWithDate(Category category, Intent intent, List<Entity> entities) {
		LanguageIntent languageInput = GeneratorFactory.eINSTANCE.createLanguageIntent();
		TrainingPhrase phrase = GeneratorFactory.eINSTANCE.createTrainingPhrase();

		String[] tokens1 = category.pattern.text.split("\\* slash \\* slash \\*");
		String[] tokens2 = category.pattern.text.split("\\*slash\\*slash\\*");
		
		List<String> tokens;
		if (tokens1.length > tokens2.length && tokens2.length != 0 || tokens1.length == 0) {
			tokens = List.of(tokens1);
		}
		
		else if (tokens1.length == tokens2.length && tokens2.length == 1)
			tokens = List.of(tokens1[0].length() < tokens2[0].length() ? tokens1 : tokens2);
		
		else
			tokens = List.of(tokens2);
		
		// Caso en que el intent únicamente esté formado por la fecha
		if (tokens.size() == 0) {
			ParameterReferenceToken parameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
			Parameter parameter = GeneratorFactory.eINSTANCE.createParameter();
			LanguagePrompt prompt = GeneratorFactory.eINSTANCE.createLanguagePrompt();
			
			prompt.setLanguage(Language.ENGLISH);
			prompt.getPrompts().add("Tell me the date.");
			parameter.setRequired(true);
			parameter.getPrompts().add(prompt);
			parameter.setDefaultEntity(DefaultEntity.DATE);
			parameterRef.setTextReference("DD/MM/AAAA");
			parameterRef.setParameter(parameter);
			phrase.getTokens().add(parameterRef);
			intent.getParameters().add(parameter);
		}
		
		// Caso en que el intent está formado por fecha y otros elementos
		else {
			int dateOccurrences1 = countOccurrences(category.pattern.text, "* slash * slash *");
			int dateOccurrences2 = countOccurrences(category.pattern.text, "*slash*slash*");
			int dateCount = dateOccurrences1 > dateOccurrences2 ? dateOccurrences1 : dateOccurrences2;
			ParameterReferenceToken dateParameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
			Parameter dateParameter = GeneratorFactory.eINSTANCE.createParameter();

			for (String token : tokens) {
				// Caso en que haya horas en el fragmento y otros elementos o no
				if (token.contains("* colon *") || token.contains("*colon*")) {
					String[] innerTokens1 = token.split("\\* colon \\*");
					String[] innerTokens2 = token.split("\\*colon\\*");

					List<String> innerTokens; 
					if (innerTokens1.length > innerTokens2.length && innerTokens2.length != 0)
						innerTokens = List.of(innerTokens1);
					
					else if (innerTokens1.length == innerTokens2.length && innerTokens2.length == 1)
						innerTokens = List.of(innerTokens1[0].length() < innerTokens2[0].length() ? innerTokens1 : innerTokens2);
					
					else
						innerTokens = List.of(innerTokens2);
					
					// Caso en que el fragmento únicamente contenga hora
					if (innerTokens.size() == 0) {
						ParameterReferenceToken innerParameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
						Parameter innerParameter = GeneratorFactory.eINSTANCE.createParameter();
						LanguagePrompt prompt = GeneratorFactory.eINSTANCE.createLanguagePrompt();
						
						prompt.setLanguage(Language.ENGLISH);
						prompt.getPrompts().add("Tell me the time.");
						innerParameter.setRequired(true);
						innerParameter.getPrompts().add(prompt);
						innerParameter.setDefaultEntity(DefaultEntity.TIME);
						innerParameterRef.setTextReference("HH:MM");
						innerParameterRef.setParameter(innerParameter);
						phrase.getTokens().add(innerParameterRef);
						intent.getParameters().add(innerParameter);
					}
					
					// Caso en que el fragmento contenga más información además de la hora
					else {
						int timeOccurrences1 = countOccurrences(category.pattern.text, "* colon *");
						int timeOccurrences2 = countOccurrences(category.pattern.text, "*colon*");
						int timeCount = timeOccurrences1 > timeOccurrences2 ? timeOccurrences1 : timeOccurrences2;
						
						for (String innerToken : innerTokens) {
							ParameterReferenceToken hourParameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
							Parameter hourParameter = GeneratorFactory.eINSTANCE.createParameter();
							LanguagePrompt hourPrompt = GeneratorFactory.eINSTANCE.createLanguagePrompt();
							
							// Caso en que haya otros parámetros en el fragmento
							if (innerToken.contains("*")) {
								String[] innerTokensStar = innerToken.split("\\*");
								for (String innerToken2 : innerTokensStar) {
									Literal innerLiteral = GeneratorFactory.eINSTANCE.createLiteral();
									ParameterReferenceToken innerParameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
									Parameter innerParameter = GeneratorFactory.eINSTANCE.createParameter();
									LanguagePrompt prompt = GeneratorFactory.eINSTANCE.createLanguagePrompt();
									
									// Guardado de texto previo al parametro
									innerLiteral.setText(innerToken2);
									phrase.getTokens().add(innerLiteral);

									// Guardado del parámetro
									prompt.setLanguage(Language.ENGLISH);
									prompt.getPrompts().add("I need a parameter.");
									innerParameter.setRequired(true);
									innerParameter.getPrompts().add(prompt);
									innerParameter.setDefaultEntity(DefaultEntity.TEXT);
									innerParameterRef.setTextReference("parameter");
									innerParameterRef.setParameter(innerParameter);
									phrase.getTokens().add(innerParameterRef);
									intent.getParameters().add(innerParameter);
								}
							}
							
							// Caso en que el fragmento sólo contenga texto
							else {
								Literal innerLiteral = GeneratorFactory.eINSTANCE.createLiteral();
								
								// Guardado de texto previo al parametro
								innerLiteral.setText(innerToken);
								phrase.getTokens().add(innerLiteral);
							}
							
							// Control de adición de parámetros de tipo hora
							if (timeCount > 0) {
								hourPrompt.setLanguage(Language.ENGLISH);
								hourPrompt.getPrompts().add("Tell me the hour.");
								hourParameter.setRequired(true);
								hourParameter.getPrompts().add(hourPrompt);
								hourParameter.setDefaultEntity(DefaultEntity.TIME);
								hourParameterRef.setTextReference("HH:MM");
								hourParameterRef.setParameter(hourParameter);
								phrase.getTokens().add(hourParameterRef);
								intent.getParameters().add(hourParameter);
								timeCount -= 1;
							}
						}
					}
				}
				
				// Caso en que haya otros parámetros en el fragmento
				else if (token.contains("*")) {				
					String[] innerTokens = category.pattern.text.split("\\*");
					for (String innerToken : innerTokens) {
						Literal innerLiteral = GeneratorFactory.eINSTANCE.createLiteral();
						ParameterReferenceToken parameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
						Parameter parameter = GeneratorFactory.eINSTANCE.createParameter();
						LanguagePrompt prompt = GeneratorFactory.eINSTANCE.createLanguagePrompt();
						
						// Guardado de texto previo al parametro
						innerLiteral.setText(innerToken);
						phrase.getTokens().add(innerLiteral);

						// Guardado del parámetro
						prompt.setLanguage(Language.ENGLISH);
						prompt.getPrompts().add("I need a parameter.");
						parameter.setRequired(true);
						parameter.getPrompts().add(prompt);
						parameter.setDefaultEntity(DefaultEntity.TEXT);
						parameterRef.setTextReference("parameter");
						parameterRef.setParameter(parameter);
						phrase.getTokens().add(parameterRef);
						intent.getParameters().add(parameter);
					}
				}
				
				// Caso en que el fragmento sólo contenga texto
				else {
					Literal innerLiteral = GeneratorFactory.eINSTANCE.createLiteral();
					
					// Guardado de texto previo al parametro
					innerLiteral.setText(token);
					phrase.getTokens().add(innerLiteral);
				}
				
				// Control de adición de parámetros de tipo fecha
				if (dateCount > 0) {
					LanguagePrompt datePrompt = GeneratorFactory.eINSTANCE.createLanguagePrompt();

					// Guardado del parámetro
					datePrompt.setLanguage(Language.ENGLISH);
					datePrompt.getPrompts().add("Tell me the date.");
					dateParameter.setRequired(true);
					dateParameter.getPrompts().add(datePrompt);
					dateParameter.setDefaultEntity(DefaultEntity.DATE);
					dateParameterRef.setTextReference("DD/MM/AAAA");
					dateParameterRef.setParameter(dateParameter);
					phrase.getTokens().add(dateParameterRef);
					intent.getParameters().add(dateParameter);
					dateCount -= 1;
				}
			}
			
			// Caso en que contenga sets en el pattern
			if (category.pattern.sets != null)
				intentAddSets(category.pattern.sets, intent, entities, phrase);
		}
		
		languageInput.getInputs().add(phrase);
		languageInput.setLanguage(Language.ENGLISH);
		intent.getInputs().add(languageInput);
	}

	// Función para gestionar los intents cuya entrada contenga horas en el formato HH:MM
	public static void addCategoryWithHour(Category category, Intent intent) {
		LanguageIntent languageInput = GeneratorFactory.eINSTANCE.createLanguageIntent();
		TrainingPhrase phrase = GeneratorFactory.eINSTANCE.createTrainingPhrase();
		String[] tokens1 = category.pattern.text.split("\\* colon \\*");
		String[] tokens2 = category.pattern.text.split("\\*colon\\*");

		List<String> tokens; 
		if (tokens1.length > tokens2.length && tokens2.length != 0 || tokens1.length == 0)
			tokens = List.of(tokens1);
		
		else if (tokens1.length == tokens2.length && tokens2.length == 1)
			tokens = List.of(tokens1[0].length() < tokens2[0].length() ? tokens1 : tokens2);
		
		else
			tokens = List.of(tokens2);
		
		// Caso en que el fragmento únicamente contenga hora
		if (tokens.size() == 0) {
			ParameterReferenceToken innerParameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
			Parameter innerParameter = GeneratorFactory.eINSTANCE.createParameter();
			LanguagePrompt hourPrompt = GeneratorFactory.eINSTANCE.createLanguagePrompt();

			// Guardado del parámetro
			hourPrompt.setLanguage(Language.ENGLISH);
			hourPrompt.getPrompts().add("Tell me the hour.");
			innerParameter.setRequired(true);
			innerParameter.getPrompts().add(hourPrompt);
			innerParameter.setDefaultEntity(DefaultEntity.TIME);
			innerParameterRef.setTextReference("HH:MM");
			innerParameterRef.setParameter(innerParameter);
			phrase.getTokens().add(innerParameterRef);
			intent.getParameters().add(innerParameter);
		}
		
		// Caso en que el fragmento contenga más información además de la hora
		else {
			int timeOccurrences1 = countOccurrences(category.pattern.text, "* colon *");
			int timeOccurrences2 = countOccurrences(category.pattern.text, "*colon*");
			int timeCount = timeOccurrences1 > timeOccurrences2 ? timeOccurrences1 : timeOccurrences2;
			
			for (String token : tokens) {
				ParameterReferenceToken hourParameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
				Parameter hourParameter = GeneratorFactory.eINSTANCE.createParameter();
				
				// Caso en que haya otros parámetros en el fragmento
				if (token.contains("*")) {
					String[] innerTokensStar = token.split("\\*");
					for (String innerToken2 : innerTokensStar) {
						Literal innerLiteral = GeneratorFactory.eINSTANCE.createLiteral();
						ParameterReferenceToken innerParameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
						Parameter innerParameter = GeneratorFactory.eINSTANCE.createParameter();
						LanguagePrompt prompt = GeneratorFactory.eINSTANCE.createLanguagePrompt();

						// Guardado de texto previo al parametro
						innerLiteral.setText(innerToken2);
						phrase.getTokens().add(innerLiteral);

						// Guardado del parámetro
						prompt.setLanguage(Language.ENGLISH);
						prompt.getPrompts().add("I need a parameter.");
						innerParameter.setRequired(true);
						innerParameter.getPrompts().add(prompt);
						innerParameter.setDefaultEntity(DefaultEntity.TEXT);
						innerParameterRef.setTextReference("parameter");
						innerParameterRef.setParameter(innerParameter);
						phrase.getTokens().add(innerParameterRef);
						intent.getParameters().add(innerParameter);
					}
				}
				
				// Caso en que el fragmento sólo contenga texto
				else {
					Literal innerLiteral = GeneratorFactory.eINSTANCE.createLiteral();
					
					// Guardado de texto previo al parametro
					innerLiteral.setText(token);
					phrase.getTokens().add(innerLiteral);
				}
				
				// Control de adición de parámetros de tipo hora
				if (timeCount > 0) {
					LanguagePrompt hourPrompt = GeneratorFactory.eINSTANCE.createLanguagePrompt();

					// Guardado del parámetro
					hourPrompt.setLanguage(Language.ENGLISH);
					hourPrompt.getPrompts().add("Tell me the hour.");
					hourParameter.setRequired(true);
					hourParameter.getPrompts().add(hourPrompt);
					hourParameter.setDefaultEntity(DefaultEntity.TIME);
					hourParameterRef.setTextReference("HH:MM");
					hourParameterRef.setParameter(hourParameter);
					phrase.getTokens().add(hourParameterRef);
					intent.getParameters().add(hourParameter);
					timeCount -= 1;
				}
			}
		}
		
		languageInput.getInputs().add(phrase);
		languageInput.setLanguage(Language.ENGLISH);
		intent.getInputs().add(languageInput);
	}

	// Función para gestionar los intents básicos, es decir, aquellos que están formados por texto y parámetros o sets
	public static void addCategoryBasic(Category category, Intent intent, List<Entity> entities) {
		// Caso en que el intent contenga sólo texto
		if (!category.pattern.text.contains("*")) {
			LanguageIntent languageInput = GeneratorFactory.eINSTANCE.createLanguageIntent();
			TrainingPhrase phrase = GeneratorFactory.eINSTANCE.createTrainingPhrase();
			Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
			
			if (category.pattern.text == null)
				literal.setText("");
			
			else
				literal.setText(category.pattern.text);
			
			phrase.getTokens().add(literal);

			// Caso en que contenga sets en el pattern
			if (category.pattern.sets != null)
				intentAddSets(category.pattern.sets, intent, entities, phrase);

			languageInput.getInputs().add(phrase);
			languageInput.setLanguage(Language.ENGLISH);
			intent.getInputs().add(languageInput);
		}
		
		// Caso en que contenga *s
		else {
			LanguageIntent languageInput = GeneratorFactory.eINSTANCE.createLanguageIntent();
			TrainingPhrase phrase = GeneratorFactory.eINSTANCE.createTrainingPhrase();

			// Sets contenidos en todo el template
			List<Set> sets = getAllTemplateSets(category.template);
			
			String[] tokens = category.pattern.text.split("\\*");
			
			if (tokens.length == 0) {
				Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
				literal.setText("*");
				phrase.getTokens().add(literal);
				intent.setFallbackIntent(true);
			}
			
			int tokenIndex = 1;
			for (String token : tokens) {
				Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
				ParameterReferenceToken parameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
				Parameter parameter = GeneratorFactory.eINSTANCE.createParameter();
				LanguagePrompt prompt = GeneratorFactory.eINSTANCE.createLanguagePrompt();
				int setsFlag = 0;
				
				// Guardado de texto previo al parametro
				if (token == null)
					literal.setText("");
				
				else
					literal.setText(token);
				
				phrase.getTokens().add(literal);

				// Guardado del parámetro
				// Si el template tiene sets, entonces se busca el nombre del parámetro y se asocia a este
				if (!sets.isEmpty()) {
					for (Set set: sets) {
						if (setsFlag == 0 && set.stars != null && !set.stars.isEmpty()) {
							for (Star star: set.stars) {
								if (star.index == tokenIndex || tokens.length == 1) {
									parameter.setName(set.name);
									setsFlag = 1;
									break;
								}
							}
						} else {
							setsFlag = 0;
							break;
						}
					}
				}

				prompt.setLanguage(Language.ENGLISH);
				prompt.getPrompts().add("I need a parameter.");
				parameter.setRequired(true);
				parameter.getPrompts().add(prompt);
				parameter.setDefaultEntity(DefaultEntity.TEXT);
				parameterRef.setTextReference("parameter");
				parameterRef.setParameter(parameter);
				phrase.getTokens().add(parameterRef);
				intent.getParameters().add(parameter);
				
				tokenIndex += 1;
			}
			
			// Caso en que contenga sets en el pattern
			if (category.pattern.sets != null)
				intentAddSets(category.pattern.sets, intent, entities, phrase);

			languageInput.getInputs().add(phrase);
			languageInput.setLanguage(Language.ENGLISH);
			intent.getInputs().add(languageInput);
		}
	}
	
	//// Funciones para gestionar los flujos de conversación
	// Función para gestionar los flujos de conversación directos, a nivel 1
	public static List<UserInteraction> getMainFlows(Category category, Intent intent, List<Intent> intents, List<Entity> entities) {
		List<UserInteraction> ret = new ArrayList<UserInteraction>();
		List<LanguageText> responses = getAllIntentDirectResponses(category, intents);
		UserInteraction flow = GeneratorFactory.eINSTANCE.createUserInteraction();
		BotInteraction target = GeneratorFactory.eINSTANCE.createBotInteraction();
		
		// Caso en que el target no tenga responses
		if (responses.isEmpty()) {
			// Caso en que tenga una llamada de tipo HTTP (callapi)
			if (category.template != null && category.template.callapi != null)
				addCallapi(category.template.callapi, target, entities);
			
			else
				return null;
		}
		
		else {
			for (LanguageText response: responses) {
				Text targetText = GeneratorFactory.eINSTANCE.createText();
				
				targetText.getInputs().add(response);
				target.getActions().add(targetText);
			}
			
			// Caso en que tenga una llamada de tipo HTTP (callapi)
			if (category.template.callapi != null)
				addCallapi(category.template.callapi, target, entities);
		}

		flow.setTarget(target);
		flow.setIntent(intent);
		ret.add(flow);
		
		return ret;
	}
	
	// Función para gestionar los flujos de conversación indirectos.
	public static void getOutcomingsFlows(List<UserInteraction> currentFlows, List<UserInteraction> flows, 
			int num, List<Intent> intentsGenerated, List<Action> actionsGenerated) {
		List<UserInteraction> futureFlows = new ArrayList<UserInteraction>();
		
		// DEBUG
//		List<List<?>> debug = new ArrayList<List<?>>();
		
		for (UserInteraction cFlow: currentFlows) {
			// Comparación de intents y targets
			for (UserInteraction flow: flows) {
				try {
					List<?> tokens1 = ((Text) cFlow.getTarget().getActions().get(0)).getInputs().get(0).getInputs().get(0).getTokens();
					List<?> tokens2 = ((TrainingPhrase) flow.getIntent().getInputs().get(0).getInputs().get(0)).getTokens();
					List<?> tokens3 = ((Text) flow.getTarget().getActions().get(0)).getInputs().get(0).getInputs().get(0).getTokens();

					// Caso en que el target sea el mismo que el intent, y por tanto, se produzca una recursión infinita
					// cuando el usuario entra a este intent
					if (equalTokens(tokens2, tokens3))
						continue;
					
					else {
						if (equalTokens(tokens1, tokens2)) {
							List<UserInteraction> flowToCopy = new ArrayList<UserInteraction>();
							UserInteraction copiedFlow;
							
							flowToCopy.add(flow);
							copiedFlow = copyFlows(flowToCopy).get(0);
							copiedFlow.getIntent().setName(copiedFlow.getIntent() + "_" + num);
							for (Action action: copiedFlow.getTarget().getActions())
								action.setName(action.getName() + "_" + num);
							
							intentsGenerated.add(copiedFlow.getIntent());
							actionsGenerated.addAll(copiedFlow.getTarget().getActions());
							
							cFlow.getTarget().getOutcoming().add(copiedFlow);
							futureFlows.add(flow);
							
							// DEBUG
		//					debug.add(tokens2);
							
							break;
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
		if (!futureFlows.isEmpty())
			getOutcomingsFlows(futureFlows, flows, num + 1, intentsGenerated, actionsGenerated);
	}
	
	// Hace una copia de los flows y sus referencias internas
	public static List<UserInteraction> copyFlows(List<UserInteraction> flows) {
		List<UserInteraction> ret = new ArrayList<UserInteraction>();
		
		for (UserInteraction flow: flows) {
			UserInteraction flowCopy = GeneratorFactory.eINSTANCE.createUserInteraction();
			
			// Variables del Intent
			Intent intentCopy = GeneratorFactory.eINSTANCE.createIntent();
			LanguageIntent languageInputCopy = GeneratorFactory.eINSTANCE.createLanguageIntent();
			TrainingPhrase phraseCopy = GeneratorFactory.eINSTANCE.createTrainingPhrase();
			
			// Variables del Target
			BotInteraction targetCopy = GeneratorFactory.eINSTANCE.createBotInteraction();
			
			languageInputCopy.setLanguage(Language.ENGLISH);
			languageInputCopy.getInputs().add(phraseCopy);
			intentCopy.setName(flow.getIntent().getName());
			intentCopy.getInputs().add(languageInputCopy);
			flowCopy.setIntent(flow.getIntent());
			
			// Parte de copia del Target
			for (var action: flow.getTarget().getActions()) {
				if (action instanceof Text) {
					Text textCopy = GeneratorFactory.eINSTANCE.createText();
					LanguageText textLanguageInputCopy = GeneratorFactory.eINSTANCE.createLanguageText();
					TextInput textInputCopy = GeneratorFactory.eINSTANCE.createTextInput();
					
					for (var token: ((Text) action).getInputs().get(0).getInputs().get(0).getTokens()) {
						if (token instanceof Literal) {
							Literal literalCopy = GeneratorFactory.eINSTANCE.createLiteral();
							literalCopy.setText(((Literal) token).getText());
							
							textInputCopy.getTokens().add(literalCopy);
						}
						
						else if (token instanceof ParameterReferenceToken) {
							ParameterReferenceToken parameterReferenceTokenCopy = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
							
							parameterReferenceTokenCopy.setTextReference(((ParameterReferenceToken) token).getTextReference());
							parameterReferenceTokenCopy.setParameter(((ParameterReferenceToken) token).getParameter());
							textInputCopy.getTokens().add(parameterReferenceTokenCopy);
						}
						
						else {
							System.out.println("El token no es un Literal o un Parameter en el target.");
						}
					}
					
					textLanguageInputCopy.getInputs().add(textInputCopy);
					textLanguageInputCopy.setLanguage(Language.ENGLISH);
					textCopy.setName(action.getName());
					textCopy.getInputs().add(textLanguageInputCopy);
					targetCopy.getActions().add(action);
				}
				
				else if (action instanceof HTTPRequest) {
					HTTPRequest httpRequestCopy = GeneratorFactory.eINSTANCE.createHTTPRequest();
					
					if (((HTTPRequest) action).getURL() != null)
						httpRequestCopy.setURL(((HTTPRequest) action).getURL());
					
					if (((HTTPRequest) action).getName() != null)
						httpRequestCopy.setName(((HTTPRequest) action).getName());
					
					if (((HTTPRequest) action).getMethod() != null)
						httpRequestCopy.setMethod(((HTTPRequest) action).getMethod());
					
					if (((HTTPRequest) action).getData() != null) {
						for (KeyValue keyValue: ((HTTPRequest) action).getData()) {
							// Caso en que el keyvalue guarde texto
							if (keyValue.getValue() instanceof Literal) {
								KeyValue keyValueCopy = GeneratorFactory.eINSTANCE.createKeyValue();
								Literal literalCopy = GeneratorFactory.eINSTANCE.createLiteral();
								
								literalCopy.setText(((Literal) keyValue.getValue()).getText());
								keyValueCopy.setKey(keyValue.getKey());
								keyValueCopy.setValue(literalCopy);
								httpRequestCopy.getData().add(keyValueCopy);
							}
							
							// Caso en que el keyValue guarde un parámetro
							if (keyValue.getValue() instanceof ParameterReferenceToken) {
								KeyValue keyValueCopy = GeneratorFactory.eINSTANCE.createKeyValue();
								ParameterReferenceToken parameterRefCopy = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
								Parameter parameterCopy = GeneratorFactory.eINSTANCE.createParameter();
								LanguagePrompt promptCopy = GeneratorFactory.eINSTANCE.createLanguagePrompt();
								
								promptCopy.setLanguage(Language.ENGLISH);
								promptCopy.getPrompts().add("Tell me the " + keyValue.getKey());
								
								parameterCopy.getPrompts().add(promptCopy);
								parameterCopy.setName(((ParameterReferenceToken) keyValue.getValue()).getParameter().getName());
								parameterCopy.setDefaultEntity(((ParameterReferenceToken) keyValue.getValue()).getParameter().getDefaultEntity());
								parameterCopy.setEntity(((ParameterReferenceToken) keyValue.getValue()).getParameter().getEntity());
								parameterRefCopy.setTextReference(((ParameterReferenceToken) keyValue.getValue()).getTextReference());
								parameterRefCopy.setParameter(parameterCopy);
								
								keyValueCopy.setKey(keyValue.getKey());
								keyValueCopy.setValue(parameterRefCopy);
								httpRequestCopy.getData().add(keyValueCopy);
							}
						}
					}
					
					if (((HTTPRequest) action).getHeaders() != null) {
						KeyValue keyValueCopy = GeneratorFactory.eINSTANCE.createKeyValue();
						keyValueCopy.setKey(((HTTPRequest) action).getHeaders().get(0).getKey());
						keyValueCopy.setValue(((HTTPRequest) action).getHeaders().get(0).getValue());
						
						httpRequestCopy.getHeaders().add(keyValueCopy);
					}
					
					targetCopy.getActions().add(httpRequestCopy);
				}
				
				else {
					System.out.println("El action no es de tipo Text o HTTPRequest.");
				}
			}
			
			if (flow.getTarget().getOutcoming() != null) {
				List<UserInteraction> outcomingFlowsCopy = copyFlows(flow.getTarget().getOutcoming());
				targetCopy.getOutcoming().addAll(outcomingFlowsCopy);
			}
			
			flowCopy.setTarget(targetCopy);
			ret.add(flowCopy);
		}
		
		return ret;
	}
	
	// Función para añadir llamadas HTTP
	public static void addCallapi(Callapi callapi, BotInteraction target, List<Entity> entities) {
		HTTPRequest httpRequest = GeneratorFactory.eINSTANCE.createHTTPRequest();
		
		if (callapi.url != null)
			httpRequest.setURL(callapi.url);
		
		if (callapi.response_code_var != null)
			httpRequest.setName(callapi.response_code_var);
		
		if (callapi.method != null)
			httpRequest.setMethod(castMethod(callapi.method));
		
		// El método por defecto en Pandorabots si no se indica es GET
		else
			httpRequest.setMethod(Method.GET);
		
		if (callapi.queryParams != null) {
			for (CallapiQuery param: callapi.queryParams) {

				// Caso en que el parámetro tenga texto
				if (param.text != null) {
					KeyValue keyValue = GeneratorFactory.eINSTANCE.createKeyValue();
					Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
					
					if (param.text == null)
						literal.setText("");
					
					else
						literal.setText(param.text);

					keyValue.setKey(param.name + "_text");
					keyValue.setValue(literal);
					httpRequest.getData().add(keyValue);
				}
				
				// Caso en que el parámetro tenga llamadas a variables guardadas
//				if (param.gets != null) {
//					List<Parameter> botParameters = getParameters(bot);
//					
//					for (Get get: param.gets) {
//						for (Parameter parameter: botParameters) {
//							if (parameter.getName().equals(get.name)) {
//								KeyValue keyValue = GeneratorFactory.eINSTANCE.createKeyValue();
//								ParameterReferenceToken parameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
//
//								parameterRef.setTextReference(param.name);
//								parameterRef.setParameter(parameter);
//								
//								keyValue.setKey(param.name + "_param_" + get.name);
//								keyValue.setValue(parameterRef);
//								httpRequest.getData().add(keyValue);
//								break;
//							}
//						}
//					}
//				}
			}
		}
		
		if (callapi.header != null)
			httpRequest.setHeader("header", callapi.header.name.text);
		
		target.getActions().add(httpRequest);
	}
	
	//// Funciones auxiliares para realizar tareas concretas
	// Función que comprueba si un LanguageText es igual a otro
	public static boolean equalTextInputs(Text input1, Text input2) {
		List<LanguageText> internalInputs1 = input1.getInputs();
		List<LanguageText> internalInputs2 = input2.getInputs();
		
		if (internalInputs1.size() == internalInputs2.size()) {
			for (int i = 0; i < internalInputs1.size(); i++) {
				try {
					List<?> tokens1 = internalInputs1.get(i).getInputs().get(0).getTokens();
					List<?> tokens2 = internalInputs2.get(i).getInputs().get(0).getTokens();
					
					return equalTokens(tokens1, tokens2);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			return true;
		}
		
		else
			return false;
	}
	
	// Función para comprobar que dos listas de tokens son iguales
	public static boolean equalTokens(List<?> tokens1, List<?> tokens2) {
		if (tokens1.size() == tokens2.size()) {
			for (int j = 0; j < tokens1.size(); j++) {
				var token1 = tokens1.get(j);
				var token2 = tokens2.get(j);
				
				// Caso en que los tokens sean literales
				if (token1 instanceof Literal &&
					token2 instanceof Literal) {
					if (!((Literal) token1).getText().equals(((Literal) token2).getText()))
						return false;
				}
				
				// Caso en que los tokens sean parámetros
				else if (token1 instanceof ParameterReferenceToken && 
						 token2 instanceof ParameterReferenceToken) {
					continue;
				}
				
				else {
					return false;
				}
			}
			
			return true;
		}
		
		return false;
	}
		
	// Función que comprueba si un HTTPRequest es igual a otro
	// TODO: Mejorar comparación si es conveniente
	public static boolean equalHTTPRequest(HTTPRequest http1, HTTPRequest http2) {
		if (http1.getName().equals(http2.getName()))
			return true;
		
		else
			return false;
	}
	
	// Castea el String con el nombre del método de llamada HTTP a la enumeración definida
	public static Method castMethod(String methodName) {
		if (methodName.toUpperCase().equals("POST"))
			return Method.POST;
		
		else if (methodName.toUpperCase().equals("GET"))
			return Method.GET;
		
		else
			return Method.POST;
	}
	
	// Devuelve todas las posibles respuestas de una categoría
	public static List<LanguageText> getAllIntentDirectResponses(Category category, List<Intent> intents) {
		List<LanguageText> ret = new ArrayList<LanguageText>();
	
		if (category.template != null) {
			// Caso en que el template tenga texto
			if (category.template.text != null && !category.template.text.isBlank()) {
				LanguageText languageInput = GeneratorFactory.eINSTANCE.createLanguageText();
				TextInput textInput = GeneratorFactory.eINSTANCE.createTextInput();
				Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
				
				if (category.pattern.text == null)
					literal.setText("");
				
				else
					literal.setText(category.pattern.text);
				
				textInput.getTokens().add(literal);
				languageInput.setLanguage(Language.ENGLISH);
				languageInput.getInputs().add(textInput);
				ret.add(languageInput);
			}
			
			// Caso en que el template tenga srais
			if (category.template.srais != null) {
				ret.addAll(addResponseSrais(category.template.srais, intents));
			}
			
			// Caso en que el template tenga conditions
			if (category.template.condition != null) {
				ret.addAll(getConditionResponsesREC(category.template.condition, intents, new ArrayList<LanguageText>()));
			}
			
			// Caso en el que el template tenga un think con srais
			if (category.template.think != null && category.template.think.srais != null) {
				ret.addAll(addResponseSrais(category.template.think.srais, intents));
			}
		}
		
		return ret;
	}
	
	// Añade las respuestas de un intent formadas por srais en forma de lista
	public static List<LanguageText> addResponseSrais(List<Srai> srais, List<Intent> intents) {
		List<LanguageText> ret = new ArrayList<LanguageText>();
		
		for (Srai srai: srais) {
			LanguageText languageInput = GeneratorFactory.eINSTANCE.createLanguageText();
			TextInput textInput = GeneratorFactory.eINSTANCE.createTextInput();
			Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
			
			if (srai.text == null)
				literal.setText("");
			
			else
				literal.setText(srai.text);
			
			textInput.getTokens().add(literal);

			// Si el srai tiene referencias a argumentos del pattern, 
			// se busca qué parámetros son en el intent que sea y se añaden
			if (srai.stars != null) {
				for (Intent intent: intents) {
					try {
						var firstToken = intent.getInputs().get(0).getInputs().get(0);
						if (firstToken instanceof Literal && ((Literal) firstToken).getText().equals(srai.text)) {
							List<Parameter> parameters = new ArrayList<Parameter>();
							
							// Se recogen los parámetros del intent en cuestión
							for (var token: intent.getInputs().get(0).getInputs()) {
								if (token instanceof ParameterReferenceToken) {
									parameters.add(((ParameterReferenceToken) token).getParameter());
								}
							}
							
							// Caso en que sólo haya un parámetro
							if (srai.stars.size() == 1 && !parameters.isEmpty()) {
								ParameterReferenceToken parameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
								
								parameterRef.setParameter(parameters.get(0));
								parameterRef.setTextReference(parameters.get(0).getName());
								textInput.getTokens().add(parameterRef);
								break;
							}
	
							// Caso en que haya más de un parámetro (fechas y horas no soportadas)
							else {
								// Se hace el matching de los parámetros con sus índices 
								// o en caso de error se añade un parámetro genérico -> No se puede
								// porque los parámetros del target
								// deben estár presentes en el intent
								for (Star star: srai.stars) {
									ParameterReferenceToken parameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
									
									try {
										parameterRef.setParameter(parameters.get(star.index - 1));
									} catch(Exception e) {
										// TODO: handle exception
									}
									
									textInput.getTokens().add(parameterRef);
									break;
								}
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				
				// En caso de no encontrar el intent al que se hace referencia en la lista de intents,
				// se añaden las stars como parámetros -> No se puede por la razón expuesta en el caso anterior
//				if (starsFound > 0) {
//					for (int i = 0; i < starsFound; i++) {
//						ParameterReferenceToken parameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
//						Parameter parameter = GeneratorFactory.eINSTANCE.createParameter();
//						LanguagePrompt prompt = GeneratorFactory.eINSTANCE.createLanguagePrompt();
//						
//						prompt.setLanguage(Language.ENGLISH);
//						prompt.getPrompts().add("I need a parameter.");
//						parameter.setRequired(true);
//						parameter.getPrompts().add(prompt);
//						parameter.setDefaultEntity(DefaultEntity.TEXT);
//						parameterRef.setParameter(parameter);
//						parameterRef.setTextReference(parameter.getName() != null ? parameter.getName() : "parameter");
//						textInput.getTokens().add(parameterRef);
//					}
//				}
			}

			languageInput.setLanguage(Language.ENGLISH);
			languageInput.getInputs().add(textInput);
			ret.add(languageInput);
		}
		
		return ret;
	}
	
	// Recoge todas las posibles respuestas de un condicional y sus posibles árboles de condicionales
	// y las devuelve en forma de lista
	public static List<LanguageText> getConditionResponsesREC(Condition condition, List<Intent> intents, List<LanguageText> list) {
		for (Option option: condition.options) {
			// Caso en que la opción tenga texto
			if (option.text != null) {
				LanguageText languageInput = GeneratorFactory.eINSTANCE.createLanguageText();
				TextInput textInput = GeneratorFactory.eINSTANCE.createTextInput();
				Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
				
				if (option.text == null)
					literal.setText("");
				
				else
					literal.setText(option.text);
				
				textInput.getTokens().add(literal);
				languageInput.setLanguage(Language.ENGLISH);
				languageInput.getInputs().add(textInput);
				list.add(languageInput);
			}
			
			// Caso en que la opción tenga srais
			if (option.srais != null) {
				for (Srai srai: option.srais) {
					LanguageText languageInput = GeneratorFactory.eINSTANCE.createLanguageText();
					TextInput textInput = GeneratorFactory.eINSTANCE.createTextInput();
					Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
					
					if (srai.text == null)
						literal.setText("");
					
					else
						literal.setText(srai.text);
					
					textInput.getTokens().add(literal);

					// Si el srai tiene referencias a argumentos del pattern, 
					// se busca qué parámetros son en el intent que sea y se añaden
					if (srai.stars != null) {
						for (Intent intent: intents) {
							try {
								var firstToken = intent.getInputs().get(0).getInputs().get(0);
								if (firstToken instanceof Literal && ((Literal) firstToken).getText().equals(srai.text)) {
									List<Parameter> parameters = new ArrayList<Parameter>();
									
									// Se recogen los parámetros del intent en cuestión
									for (var token: intent.getInputs().get(0).getInputs()) {
										if (token instanceof ParameterReferenceToken) {
											parameters.add(((ParameterReferenceToken) token).getParameter());
										}
									}
									
									// Caso en que sólo haya un parámetro
									if (srai.stars.size() == 1 && !parameters.isEmpty()) {
										ParameterReferenceToken parameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
										
										parameterRef.setTextReference(parameters.get(0).getName() != null ? parameters.get(0).getName() : "parameter");
										parameterRef.setParameter(parameters.get(0));
										textInput.getTokens().add(parameterRef);
										break;
									}
	
									// Caso en que haya más de un parámetro (fechas y horas no soportadas)
									else {
										// Se hace el matching de los parámetros con sus índices 
										// o en caso de error se añade un parámetro genérico
										for (Star star: srai.stars) {
											ParameterReferenceToken parameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
											
											try {
												parameterRef.setParameter(parameters.get(star.index - 1));
											} catch(Exception e) {
//												Parameter parameter = GeneratorFactory.eINSTANCE.createParameter();
//												LanguagePrompt prompt = GeneratorFactory.eINSTANCE.createLanguagePrompt();
//												
//												prompt.setLanguage(Language.ENGLISH);
//												prompt.getPrompts().add("I need a parameter.");
//												parameter.setRequired(true);
//												parameter.getPrompts().add(prompt);
//												parameter.setDefaultEntity(DefaultEntity.TEXT);
//												parameterRef.setTextReference(parameter.getName() != null ? parameter.getName() : "parameter");
//												parameterRef.setParameter(parameter);
//												textInput.getTokens().add(parameterRef);
											}
											
											textInput.getTokens().add(parameterRef);
											break;
										}
									}
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
					}

					languageInput.setLanguage(Language.ENGLISH);
					languageInput.getInputs().add(textInput);
					list.add(languageInput);
				}
			}
			
			// Caso en el que la opción tenga un think con srais
			if (option.think != null && option.think.srais != null) {
				list.addAll(addResponseSrais(option.think.srais, intents));
			}
			
			// Caso en que la opción contenga a su vez otro condicional
			if (option.condition != null) {
				list.addAll(getConditionResponsesREC(option.condition, intents, list));
			}
		}
		
		return list;
	}
	
	// Dada una lista no-vacía de sets del patrón de una categoría, añade dichos sets a la frase en forma de parámetros
	public static void intentAddSets(List<SetAttr> sets, Intent intent, List<Entity> entities, TrainingPhrase phrase) {
		for (SetAttr set : sets) {
			ParameterReferenceToken parameterRef = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
			Parameter parameter = GeneratorFactory.eINSTANCE.createParameter();
			LanguagePrompt prompt = GeneratorFactory.eINSTANCE.createLanguagePrompt();

			if (entities != null) {
				for (Entity entity : entities) {
					if (entity.getName().equals(set.name)) {
						parameter.setEntity(entity);
						break;
					}
				}
			}

			prompt.setLanguage(Language.ENGLISH);
			prompt.getPrompts().add("Tell me the " + set.name);
			parameter.setRequired(true);
			parameter.getPrompts().add(prompt);
			parameter.setName(set.name);
			parameter.setDefaultEntity(DefaultEntity.TEXT);
			parameterRef.setTextReference(set.name);
			parameterRef.setParameter(parameter);
			phrase.getTokens().add(parameterRef);
			intent.getParameters().add(parameter);
		}
	}
	
	// Devuelve todos los sets que hay en el template a las distintas profundidades posibles
	public static List<Set> getAllTemplateSets(Template template) {
		List<Set> ret = new ArrayList<Set>();
		
		if (template.think != null && template.think.sets != null)
			ret.addAll(template.think.sets);
		
		if (template.condition != null)
			for (Option li: template.condition.options)
				if (li.think != null && !li.think.sets.isEmpty())
					ret.addAll(li.think.sets);
			
		return ret;
	}
	
	// Rellena los nombres vacíos de los parámetros
	public static void setParameterNames(Bot bot) {
		int num = 0;
		List<Parameter> parameters = getParameters(bot);
		
		for (Parameter parameter: parameters) {
			if (parameter.getName() == null) {
				parameter.setName("Parameter_" + num);
				num++;
			}
		}
	}
	
	// Devuelve los parámetros contenidos en todo el bot
	public static List<Parameter> getParameters(Bot bot) {
		List<Parameter> ret = new ArrayList<Parameter>();
		
		// Rellenado de nombres de los parámetros ubicados en los intents
		for (Intent intent: bot.getIntents()) {
			if (intent.getParameters() != null) {
				ret.addAll(intent.getParameters());
			}
		}
		
		// Rellenado de nombres de los parámetros ubicados en los actions
		for (Action action: bot.getActions()) {
			if (action instanceof Text) {
				for (TextInput input: ((Text) action).getInputs().get(0).getInputs()) {
					 for (var token: input.getTokens()) {
						 if (token instanceof ParameterReferenceToken) {
							 ret.add(((ParameterReferenceToken) token).getParameter());
						 }
					 }
				}
			}
		}
		
		for (UserInteraction flow: bot.getFlows())
			ret.addAll(flow.getIntent().getParameters());
		
		return ret;
	}
	
	// Elimina los parámetros que se encuentran en el target pero no en el intent, generando problemas
	public static void clearExtraParameters(List<UserInteraction> flows) {
		for (UserInteraction flow: flows) {
			Map<TextInput, List<ParameterReferenceToken>> targetParameters = new HashMap<TextInput, List<ParameterReferenceToken>>();
			
			// Extracción de los parámetros que hay en el target
			for (Action action: flow.getTarget().getActions()) {
				if (action instanceof Text) {
					for (TextInput input: ((Text) action).getInputs().get(0).getInputs()) {
						List<ParameterReferenceToken> parameters = new ArrayList<ParameterReferenceToken>();
						
						for (var token: input.getTokens()) {
							 if (token instanceof ParameterReferenceToken) {
								 parameters.add((ParameterReferenceToken) token);
							 }
						}
						
						if (parameters.size() != 0)
							targetParameters.put(input, parameters);
					}
				}
			}
			
			// Limpieza de parámetros
			for (Parameter parameter: flow.getIntent().getParameters()) {
				List<TextInput> inputsToRemove = new ArrayList<TextInput>();
				
				for (TextInput key: targetParameters.keySet()) {
					List<ParameterReferenceToken> parameters = targetParameters.get(key);
					List<ParameterReferenceToken> parametersToRemove = new ArrayList<ParameterReferenceToken>();
					
					for (ParameterReferenceToken targetParam: parameters) {
						if (targetParam.getParameter().getDefaultEntity().equals(parameter.getDefaultEntity()))
							parametersToRemove.add(targetParam);
					}
					
					parameters.removeAll(parametersToRemove);
					
					if (parameters.size() == 0) 
						inputsToRemove.add(key);
				}
				
				for (TextInput key: inputsToRemove)
					targetParameters.remove(key);
			}
			
			// Si hay parámetros en el target que no están en el intent
			if (targetParameters.size() != 0) {
				for (TextInput key: targetParameters.keySet()) {
					key.getTokens().removeAll(targetParameters.get(key));
				}
			}
		}
	}
	
	// Elimina los caminos equivalentes más cortos
	public static void clearShorterPaths(List<UserInteraction> flows) {
		for (UserInteraction flow: flows) {
			List<UserInteraction> outcomings = flow.getTarget().getOutcoming();
			if (outcomings != null) {
				if (outcomings.size() == 1) {
					List<UserInteraction> tempList = new ArrayList<UserInteraction>();
					tempList.add(outcomings.get(0));
					clearShorterPaths(tempList);
				}
				
				else {
					List<UserInteraction> toRemove = new ArrayList<UserInteraction>();
					
					for (UserInteraction outcoming1: outcomings) {
						if (!toRemove.contains(outcoming1)) {
							for (UserInteraction outcoming2: outcomings) {
								if (!toRemove.contains(outcoming2)) {
									if (outcoming1 != outcoming2) {
										int res = isLongerPath(outcoming1, outcoming2);
										if (res == 0)
											continue;
										
										else if (res == -1) {
											toRemove.add(outcoming1);
										}
										
										else {
											toRemove.add(outcoming2);
										}
									}
								}
							}
						}
					}
					
					outcomings.removeAll(toRemove);
					
					// Eliminación de caminos más profundos
					for (UserInteraction outcoming: outcomings) {
						List<UserInteraction> tempList = new ArrayList<UserInteraction>();
						tempList.add(outcoming);
						clearShorterPaths(tempList);
					}
				}
			}
		}
	}
	
	// Devuelve 1 si el camino del flow a es más largo que el del flow b, siendo ambos equivalentes,
	// 0 si son distintos, y -1 si b es más largo que a
	public static int isLongerPath(UserInteraction a, UserInteraction b) {
		// Caso en que los targets no sean iguales
		if (!equivalentTargets(a.getTarget().getActions(), b.getTarget().getActions()))
			return 0;
		
		// Caso en que se trate del mismo target
		else {
			// A no tiene outcomings
			if (a.getTarget().getOutcoming() == null || a.getTarget().getOutcoming().isEmpty()) {
				// Ni A ni B tienen outcomings
				if (b.getTarget().getOutcoming() == null || b.getTarget().getOutcoming().isEmpty())
					return 1;
				
				// A no tiene outcomings pero B sí
				else
					return -1;
			}
			
			// A tiene outcomings
			else {
				// A tiene outcomings y B no
				if (b.getTarget().getOutcoming() == null || b.getTarget().getOutcoming().isEmpty())
					return 1;
				
				// A y B tienen outcomings
				else {
					List<UserInteraction> outcomingsA = a.getTarget().getOutcoming();
					List<UserInteraction> outcomingsB = b.getTarget().getOutcoming();
					
					// Si los outcomings de A son más que los de B
					if (outcomingsA.size() > outcomingsB.size()) {
						for (UserInteraction outcomingB: outcomingsB) {
							int flag = 0;
							
							for (UserInteraction outcomingA: outcomingsA) {
								if (equivalentTargets(outcomingA.getTarget().getActions(), 
										outcomingB.getTarget().getActions())) {
									flag = 1;
									break;
								}
							}
							
							// Caso en que los outcomings de B no estén contenidos en los de A
							if (flag == 0)
								return 0;
						}
						
						// A contiene a B
						return 1;
					}
					
					// Si los outcomings de B son más que los de A
					else if (outcomingsA.size() < outcomingsB.size()) {
						for (UserInteraction outcomingA: outcomingsA) {
							int flag = 0;
							
							for (UserInteraction outcomingB: outcomingsB) {
								if (equivalentTargets(outcomingA.getTarget().getActions(), 
										outcomingB.getTarget().getActions())) {
									flag = 1;
									break;
								}
							}
							
							// Caso en que los outcomings de A no estén contenidos en los de B
							if (flag == 0)
								return 0;
						}
						
						// B contiene a A
						return -1;
					}
					
					// Caso en que A y B tengan la misma cantidad de outcomings
					else {
						for (UserInteraction outcomingA: outcomingsA) {
							int flag = 0;
							
							for (UserInteraction outcomingB: outcomingsB) {
								if (equivalentTargets(outcomingA.getTarget().getActions(), 
										outcomingB.getTarget().getActions())) {
									flag = 1;
									break;
								}
							}
							
							// Caso en que los outcomings de A no sean los mismos que los de B
							if (flag == 0)
								return 0;
						}
						
						// Caso en que los outcomings de A son iguales que los de B
						List<Integer> results = new ArrayList<Integer>();
						
						// Extracción del mismo outcoming y búsqueda de si es más largo o distinto
						for (UserInteraction outcomingA: outcomingsA) {
							for (UserInteraction outcomingB: outcomingsB) {
								if (equivalentTargets(outcomingA.getTarget().getActions(), 
										outcomingB.getTarget().getActions())) {
									results.add(isLongerPath(outcomingA, outcomingB));
									break;
								}
							}
						}
						
						if (results.contains(0))
							return 0;
						
						else
							return results.get(0);
					}
				}
			}
		}
	}
	
	// Comprueba si las acciones A son equivalentes a las acciones B
	public static boolean equivalentTargets(List<Action> actionsA, List<Action> actionsB) {
		if (actionsA.size() != actionsB.size())
			return false;
		
		else {
			for (Action a: actionsA) {
				int flag = 0;
				for (Action b: actionsB) {
		        	if (a instanceof Text && b instanceof Text &&
		        		AgentIntentsGetter.equalTextInputs((Text)a, (Text)b)) {
		        		flag = 1;
		        		break;
		        	}
		        	
		        	else if (a instanceof HTTPRequest && b instanceof HTTPRequest &&
			        		AgentIntentsGetter.equalHTTPRequest((HTTPRequest)a, (HTTPRequest)b)) {
		        		flag = 1;
		        		break;
		        	}
				}
				
				// Caso en que no se encuentre una action en la lista de actions del otro target
				if (flag == 0)
					return false;
			}
			
			return true;
		}
	}
	
	//// Funciones necesarias pero ajenas a la tarea que se está tratando
	// Cuenta el numero de apariciones de un substring en un string
	// Credit: https://stackoverflow.com/questions/767759/occurrences-of-substring-in-a-string
	public static int countOccurrences(String source, String substring) {
		int lastIndex = 0;
		int count = 0;

		while(lastIndex != -1){
		    lastIndex = source.indexOf(substring, lastIndex);

		    if(lastIndex != -1) {
		        count ++;
		        lastIndex += substring.length();
		    }
		}
		
		return count;
	}
}

/*
 * generated by Xtext 2.19.0
 */
package org.xtext.botGenerator.validation

import generator.Bot
import generator.GeneratorPackage
import generator.HTTPRequestToke
import generator.HTTPReturnType
import generator.Intent
import generator.ParameterReferenceToken
import generator.TrainingPhrase
import org.eclipse.xtext.validation.Check
import generator.Element
import java.util.ArrayList
import generator.Parameter
import generator.SimpleInput
import generator.HTTPResponse
import generator.BotInteraction
import generator.Language
import generator.IntentLanguageInputs
import generator.PromptLanguage
import generator.TextLanguageInput
import generator.Text
import generator.Action
import generator.LanguageInput
import generator.EntityInput
import generator.Entity
import generator.RegexInput
import generator.GeneratorFactory
import java.util.regex.Pattern
import java.util.regex.PatternSyntaxException
import generator.Literal
import generator.DefaultEntity

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class BotValidator extends AbstractBotValidator {

//	public static val INVALID_NAME = 'invalidName'
//
//	@Check
//	def checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.name.charAt(0))) {
//			warning('Name should start with a capital', 
//					BotPackage.Literals.GREETING__NAME,
//					INVALID_NAME)
//		}
//	}
	public static boolean BooleanValue = false;

	@Check
	def checkHTTTPRequestTokenDataKey(HTTPRequestToke httpRequestToken) {
		if (httpRequestToken.type != HTTPReturnType.DATA && !httpRequestToken.dataKey.isEmpty) {
			warning('The data key is only using with the data type of http request',
				GeneratorPackage.Literals.HTTP_REQUEST_TOKE__DATA_KEY, "invalid data key")
		}
	}

	@Check
	def checkParameterReferences(ParameterReferenceToken references) {
		var container = references.eContainer
		if (!(container instanceof TrainingPhrase)) {
			return
		}
		var containercontainer = container.eContainer
		if (!(containercontainer instanceof Intent)) {
			return
		}
		var intent = containercontainer as Intent
		if (!intent.parameters.contains(references.parameter)) {
			error("This parameter is not from the list of intents parameters",
				GeneratorPackage.Literals.PARAMETER_REFERENCE_TOKEN__PARAMETER)
		}
	}

	@Check
	def flowPath(Bot bot) {
		for (var i = 0; i < bot.flows.size; i++) {
			var current = bot.flows.get(i);
			for (var j = i + 1; j < bot.flows.size; j++) {
				var nexts = bot.flows.get(j)
				if (current.intent === nexts.intent) {
					error("Only one path can start with the intent " + current.intent.name,
						GeneratorPackage.Literals.BOT__FLOWS)
				}
			}
		}
	}

	@Check
	def flowPathState(BotInteraction state) {
		for (var i = 0; i < state.outcoming.size; i++) {
			var current = state.outcoming.get(i);
			for (var j = i + 1; j < state.outcoming.size; j++) {
				var nexts = state.outcoming.get(j)
				if (current.intent === nexts.intent) {
					error("Only one path can start with the intent " + current.intent.name,
						GeneratorPackage.Literals.BOT_INTERACTION__OUTCOMING)
				}
			}
		}
	}

	@Check
	def nameUnique(Element e) {
		var container = e.eContainer;
		if (container instanceof Bot) {
			var elements = new ArrayList<Element>();
			elements.addAll(container.intents);
			elements.addAll(container.actions)
			elements.addAll(container.entities)

			for (Element i : elements) {
				if ((!i.equals(e)) && i.name.equals(e.name)) {
					error("There are several elements with the name " + i.name +
						". The name of the elements must be unique", GeneratorPackage.Literals.ELEMENT__NAME)
				}
			}
		}
	}

	@Check
	def nameUnique(Parameter param) {
		var container = param.eContainer;
		if (container instanceof Intent) {
			for (Parameter p : container.parameters) {
				if ((!param.equals(p)) && param.name.equals(p.name)) {
					error("There are several parameters with the name " + p.name +
						" in this intent. The name of the parameters must be unique",
						GeneratorPackage.Literals.ELEMENT__NAME)
				}
			}
		}
	}

	@Check
	def nameUnique(SimpleInput input) {
		var container = input.eContainer;
		if (container instanceof LanguageInput) {
			for (EntityInput i : container.inputs) {
				if (i instanceof SimpleInput) {
					if ((!input.equals(i)) && input.name.equals(i.name)) {
						error("There are several entries with the name " + i.name +
							" in this entity. The name of the entries must be unique",
							GeneratorPackage.Literals.ELEMENT__NAME)
					}
				}
			}
		}
	}

	@Check
	def paramEntity(Parameter param) {

		if (param.entity === null && param.defaultEntity === null) {
			var intent = param.eContainer
			if (intent instanceof Intent) {
				var index = intent.parameters.indexOf(param)
				if (index == intent.parameters.size - 1) {
					error("The parameter must have a entity", GeneratorPackage.Literals.PARAMETER__ENTITY)
					return;
				}
				var stop = false
				do {
					var param2 = intent.parameters.get(index + 1)
					if (param2.entity !== null || param2.defaultEntity !== null) {
						stop = true;
						param.entity = param2.entity;
						param.defaultEntity = param2.defaultEntity;
						param.isList = param2.isList
						param.required = param2.isRequired
						for (PromptLanguage prompt : param2.prompts) {
							var prompt2 = GeneratorFactory.eINSTANCE.createPromptLanguage
							prompt2.language = prompt.language
							for (String s : prompt.prompts) {
								prompt2.prompts.add(s)
							}
							param.prompts.add(prompt2)
						}
					}
					index++;
					if (index == intent.parameters.size) {
						stop = true;
					}
				} while (!stop)
				if (param.entity === null && param.defaultEntity === null) {
					error("The parameter must have a entity", GeneratorPackage.Literals.PARAMETER__ENTITY)
					return;
				}
			}
		}
	}

	@Check
	def requestExecution(BotInteraction interaction) {
		for (action : interaction.actions) {
			if (action instanceof HTTPResponse) {
				var index = interaction.actions.indexOf(action)
				if (index == 0) {
					error("Before an HttpResponse must go the HttpRequest which reference",
						GeneratorPackage.Literals.BOT_INTERACTION__ACTIONS)
				} else if (interaction.actions.get(index - 1) !== action.HTTPRequest) {
					error("Before an HttpResponse must go the HttpRequest which reference",
						GeneratorPackage.Literals.BOT_INTERACTION__ACTIONS)
				}
			}
		}
	}

	@Check
	def entityLanguage(Entity entity) {
		var entityLan = new ArrayList<Language>();
		var container = entity.eContainer
		if (container instanceof Bot) {
			for (LanguageInput input : entity.inputs) {
				if (input.language == Language.EMPTY) {
					input.language = container.languages.get(0);
				}
				if (!entityLan.contains(input.language)) {
					entityLan.add(input.language)
				}
			}
			for (Language lan : container.languages) {
				if (!entityLan.contains(lan)) {
					warning("The chatbot supports " + lan.literal.toLowerCase().toFirstUpper +
						", but this entity does not have an input in this language",
						GeneratorPackage.Literals.ELEMENT__NAME)
				}
			}
		}
	}

	@Check
	def entityLanguage(LanguageInput input) {
		var bot = input.eContainer.eContainer
		var entity = input.eContainer
		if (bot instanceof Bot) {
			if (entity instanceof Entity) {
				if (input.language == Language.EMPTY) {
					input.language = bot.languages.get(0);
				}
				if (!bot.languages.contains(input.language)) {
					error("The input languages must be one of the chatbot languages",
						GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
				}
				for (LanguageInput input2 : entity.inputs) {
					if (!input.equals(input2) && input.language.equals(input2.language)) {
						error("The intent can not have several inputs with the same language",
							GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
					}
				}
			}
		}
	}

	@Check
	def intentLanguage(Intent intent) {
		var intentLan = new ArrayList<Language>();
		var container = intent.eContainer
		if (container instanceof Bot) {
			for (IntentLanguageInputs input : intent.inputs) {
				if (input.language == Language.EMPTY) {
					input.language = container.languages.get(0);
				}
				if (!intentLan.contains(input.language)) {
					intentLan.add(input.language)
				}
			}
			for (Language lan : container.languages) {
				if (BooleanValue == false) {
					if (!intentLan.contains(lan) && intent.fallbackIntent !== true) {
						warning("The chatbot supports " + lan.literal.toLowerCase().toFirstUpper +
							", but this intent does not have an input in this language",
							GeneratorPackage.Literals.ELEMENT__NAME)
					}
				}
			}
		}
	}

	@Check
	def intentLanguage(IntentLanguageInputs input) {
		var bot = input.eContainer.eContainer
		var intent = input.eContainer
		if (bot instanceof Bot) {
			if (intent instanceof Intent) {
				if (input.language == Language.EMPTY) {
					input.language = bot.languages.get(0);
				}
				if (!bot.languages.contains(input.language)) {
					error("The input languages must be one of the chatbot languages",
						GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
				}
				for (IntentLanguageInputs input2 : intent.inputs) {
					if (!input.equals(input2) && input.language.equals(input2.language)) {
						error("The intent can not have several inputs with the same language",
							GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
					}
				}
			}
		}
	}

	@Check
	def paramLanguage(PromptLanguage prompt) {
		var bot = prompt.eContainer.eContainer.eContainer
		var param = prompt.eContainer
		if (bot instanceof Bot) {
			if (param instanceof Parameter) {
				if (prompt.language == Language.EMPTY) {
					prompt.language = bot.languages.get(0)
				}
				if (!bot.languages.contains(prompt.language)) {
					error("The prompt language must be some of the chatbot languages",
						GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
				}

				for (PromptLanguage prompt2 : param.prompts) {
					if (!prompt.equals(prompt2) && prompt.language.equals(prompt2.language)) {
						error("The parameter can not have several prompts with the same language",
							GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
					}
				}
			}
		}
	}

	@Check
	def paramLanguage(Parameter param) {
		var paramLan = new ArrayList<Language>();
		var container = param.eContainer.eContainer
		if (container instanceof Bot) {
			for (PromptLanguage input : param.prompts) {
				if (input.language == Language.EMPTY) {
					input.language = container.languages.get(0);
				}
				if (!paramLan.contains(input.language)) {
					paramLan.add(input.language)
				}
			}
			if (!param.prompts.empty) {
				for (Language lan : container.languages) {
					if (!paramLan.contains(lan)) {
						warning("The chatbot supports " + lan.literal.toLowerCase().toFirstUpper +
							", but this parameter does not have a prompt in this language",
							GeneratorPackage.Literals.ELEMENT__NAME)
					}
				}
			}
		}
	}

	@Check
	def textLanguage(TextLanguageInput text) {
		var bot = text.eContainer.eContainer
		var action = text.eContainer
		if (bot instanceof Bot) {
			if (text.language == Language.EMPTY) {
				text.language = bot.languages.get(0)
			}
			if (!bot.languages.contains(text.language)) {
				error("The text language must be some of the chatbot languages",
					GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
			}
			if (action instanceof Text) {
				for (TextLanguageInput text2 : action.inputs) {
					if (!text.equals(text2) && text.language.equals(text2.language)) {
						error("The text response can not have several inputs with the same language",
							GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
					}
				}
			} else if (action instanceof HTTPResponse) {
				for (TextLanguageInput text2 : action.inputs) {
					if (!text.equals(text2) && text.language.equals(text2.language)) {
						error("The http response can not have several inputs with the same language",
							GeneratorPackage.Literals.WITH_LANGUAGE__LANGUAGE)
					}
				}
			}
		}
	}

	@Check
	def entityType(Entity entity) {
		var has_regex = false
		var has_simple = false
		var has_composite = false
		for (LanguageInput language : entity.inputs) {
			for (EntityInput input : language.inputs) {
				if (input instanceof RegexInput) {
					if (has_simple || has_composite) {
						error("Entities only can have one entry type, regex, simple or composite",
							GeneratorPackage.Literals.ENTITY__INPUTS)
					}
					has_regex = true
				} else if (input instanceof SimpleInput) {
					if (has_regex || has_composite) {
						error("Entities only can have one entry type, regex, simple or composite",
							GeneratorPackage.Literals.ENTITY__INPUTS)
					}
					has_simple = true
				} else {
					if (has_regex || has_simple) {
						error("Entities only can have one entry type, regex, simple or composite",
							GeneratorPackage.Literals.ENTITY__INPUTS)
					}
					has_composite = true
				}
			}
		}
	}

	@Check
	def regexSyntax(RegexInput input) {
		try {
			Pattern.compile(input.expresion)
		} catch (PatternSyntaxException exception) {
			error(exception.description, GeneratorPackage.Literals.REGEX_INPUT__EXPRESION)
		}
	}

	@Check
	def textLanguage(Action action) {
		var actionLan = new ArrayList<Language>();

		var bot = action.eContainer

		if (bot instanceof Bot) {
			if (action instanceof Text) {
				for (TextLanguageInput input : action.inputs) {
					if (input.language == Language.EMPTY) {
						input.language = bot.languages.get(0);
					}
					if (!actionLan.contains(input.language)) {
						actionLan.add(input.language)
					}
				}
				for (Language lan : bot.languages) {
					if (!actionLan.contains(lan)) {
						warning("The chatbot supports " + lan.literal.toLowerCase().toFirstUpper +
							", but this text response does not have an input in this language",
							GeneratorPackage.Literals.ELEMENT__NAME)
					}
				}
			} else if (action instanceof HTTPResponse) {
				for (TextLanguageInput input : action.inputs) {
					if (input.language == Language.EMPTY) {
						input.language = bot.languages.get(0);
					}
					if (!actionLan.contains(input.language)) {
						actionLan.add(input.language)
					}
				}
				for (Language lan : bot.languages) {
					if (!actionLan.contains(lan)) {
						warning("The chatbot supports " + lan.literal.toLowerCase().toFirstUpper +
							",but this http response does not have an input in this language",
							GeneratorPackage.Literals.ELEMENT__NAME)
					}
				}
			}
		}
	}

	@Check
	def similarPhrases(TrainingPhrase phrase) {
		var bot = phrase.eContainer.eContainer.eContainer;
		if (bot instanceof Bot) {
			var trainingPhrases = (bot as Bot).eAllContents.filter(TrainingPhrase).toList
			for (tp : trainingPhrases) {
				if (phrase.isSimilarTo(tp) && !phrase.equals(tp)) {
					warning("Two training phrases should not be equals",
						GeneratorPackage.Literals.TRAINING_PHRASE__TOKENS)
				}
			}
		}
	}

	@Check
	def atLeastTreeTrainingPhrases(IntentLanguageInputs intent) {
		if (intent.inputs.length < 3) {
			var hasRegex = false;
			for (intentInput : intent.inputs) {
				if (intentInput instanceof RegexInput) {
					hasRegex = true;
				}
			}
			if (!hasRegex) {
				warning("The intents must contains at least tree training phrases or one regex per language",
					GeneratorPackage.Literals.INTENT_LANGUAGE_INPUTS__INPUTS)
			}
		}
	}

	@Check
	def trainingPhraseWithOnlyTextEntity(TrainingPhrase phrase) {
		var onlyTextEntity = true
		for (token : phrase.tokens) {
			if (token instanceof Literal) {
				onlyTextEntity = false;
			} else if (token instanceof ParameterReferenceToken) {
				if ((token as ParameterReferenceToken).parameter.entity !== null ||
					(token as ParameterReferenceToken).parameter.defaultEntity != DefaultEntity.TEXT) {
					onlyTextEntity = false;
				}
			}
		}
		if (onlyTextEntity) {
			warning("Training phrases should contains something different to a text parameter",
				GeneratorPackage.Literals.TRAINING_PHRASE__TOKENS)
		}
	}
}

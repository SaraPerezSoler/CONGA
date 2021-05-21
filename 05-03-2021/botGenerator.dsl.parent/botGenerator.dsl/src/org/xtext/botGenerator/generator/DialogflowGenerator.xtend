package org.xtext.botGenerator.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import generator.Bot
import generator.HTTPRequest
import generator.Token
import generator.Literal
import generator.EntityToken
import generator.UserInteraction
import generator.DefaultEntity
import generator.Parameter
import generator.Text
import generator.Image
import generator.ParameterReferenceToken
import generator.ParameterToken
import generator.TextInput
import generator.Language
import generator.IntentLanguageInputs
import generator.TextLanguageInput
import generator.LanguageInput
import generator.EntityInput
import generator.RegexInput
import generator.SimpleInput
import generator.CompositeInput
import generator.TrainingPhrase
import generator.Entity
import java.util.List
import java.util.UUID
import zipUtils.Zip

class DialogflowGenerator {
	String path;
	protected static String uri;
	Zip zip;
	
	def doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context, Zip zip) {
		var resourceName = resource.URI.lastSegment.substring(0, resource.URI.lastSegment.indexOf("."));
		var bot = resource.allContents.filter(Bot).toList.get(0);
		var requests = resource.allContents.filter(HTTPRequest).toList;
		
		path = resourceName + "/Dialogflow"
		
		
		this.zip = zip;
		
		fsa.generateFile(path + '/package.json', "{\n \"version\": \"1.0.0\"\n}")
		var packageValue = fsa.readBinaryFile(path + '/package.json')
		zip.addFile("package.json", packageValue)

		if (!requests.isEmpty) {
			var request = requests.get(0) as HTTPRequest
			fsa.generateFile(path + '/agent.json', agentJSON(bot, request))
		} else {
			fsa.generateFile(path + '/agent.json', agentJSON(bot, null))
		}
		var agentValue = fsa.readBinaryFile(path + '/agent.json')
		zip.addFile('agent.json', agentValue)

		var entities = resource.allContents.filter(Entity).toList;
		for (Entity entity : entities) {
			
			fsa.generateFile(path + '/entities/' + entity.name + '.json', entityFile(entity))
			var entityValue = fsa.readBinaryFile(path + '/entities/' + entity.name + '.json')
			zip.addFileToFolder('entities', entity.name + '.json', entityValue)
			
			var lan = Language.ENGLISH;

			for (LanguageInput input : entity.inputs) {
				lan = bot.languages.get(0);
				if (input.language != Language.EMPTY) {
					lan = input.language
				}
				fsa.generateFile(path + '/entities/' + entity.name + '_entries_' + lan.languageAbbreviation + '.json',
					entriesFile(input))
				var entityLanValue = fsa.readBinaryFile(path + '/entities/' + entity.name + '_entries_' + lan.languageAbbreviation + '.json')
				zip.addFileToFolder('entities',	entity.name + '_entries_' + lan.languageAbbreviation + '.json', entityLanValue)
			}			
		}

		for (UserInteraction transition : bot.flows) {
			createTransitionFiles(transition, "", fsa, bot)
		}
		zip.close

	}

	def void createTransitionFiles(UserInteraction transition, String prefix, IFileSystemAccess2 fsa, Bot bot) {

		fsa.generateFile(path + '/intents/' + prefix + transition.intent.name + '.json',
			transition.intentFile(prefix, bot))
		var intentValue = fsa.readBinaryFile(path + '/intents/' + prefix + transition.intent.name + '.json')
			
		zip.addFileToFolder('intents', prefix + transition.intent.name + '.json', intentValue)

		for (IntentLanguageInputs input : transition.intent.inputs) {
			var lan = bot.languages.get(0)
			if (input.language != Language.EMPTY) {
				lan = input.language
			}
			fsa.generateFile(
				path + '/intents/' + prefix + transition.intent.name + '_usersays_' + lan.languageAbbreviation +
					'.json', input.usersayFile)
			var intentLanValue = fsa.readBinaryFile(path + '/intents/' + prefix + transition.intent.name + '_usersays_' + lan.languageAbbreviation +
					'.json')
			zip.addFileToFolder('intents',
				prefix + transition.intent.name + '_usersays_' + lan.languageAbbreviation + '.json', intentLanValue)
		}
		if (transition.target !== null) {
			var newPrefix = prefix + transition.intent.name + " - ";
			for (UserInteraction t : transition.target.outcoming) {
				createTransitionFiles(t, newPrefix, fsa, bot)
			}
		}
	}

	def contextName(UserInteraction transition, String prefix) {
		var name = prefix + transition.intent.name + " - " + "followup"
		name = name.replaceAll(" ", "");
		return name
	}

	def contextName(String prefix) {
		var name = prefix + "followup"
		name = name.replaceAll(" ", "");
		return name
	}

	def speechText(TextLanguageInput textAction) {
		var ret = ""
		for (TextInput input : textAction.inputs) {
			ret += "\""
			for (Token token : input.tokens) {
				if (token instanceof Literal) {
					ret += token.text + " "
				} else if (token instanceof ParameterToken) {
					ret += "$" + token.parameter.name + " "
				}
			}
			ret += "\""
			if (!isTheLast(textAction.inputs, input)) {
				ret += ","
			}
			ret += "\n"
		}
		return ret;
	}

	def paramType(Parameter param) {
		if (param.entity !== null) {
			return "@" + param.entity.name
		} else {
			switch (param.defaultEntity) {
				case (DefaultEntity.TEXT):
					return "@sys.any"
				case (DefaultEntity.DATE):
					return "@sys.date"
				case (DefaultEntity.TIME):
					return "@sys.time"
				case (DefaultEntity.NUMBER):
					return "@sys.number-integer"
				case (DefaultEntity.FLOAT):
					return "@sys.number"
			}
		}
	}

	def intentFile(UserInteraction transition, String prefix, Bot bot) '''
		«var webhook =false»
		{
			"id": "«UUID.randomUUID().toString»",
			"name": "«prefix + transition.intent.name»",
			"auto": true,
			«IF transition.src!==null»
				"contexts": ["«contextName(prefix)»"],
			«ELSE»
				"contexts": [],
			«ENDIF»
			"responses": [
				{
					"resetContexts": false,
					"affectedContexts": [
						«IF transition.target!== null»
							«IF !transition.target.outcoming.isEmpty»
								{
									"name": "«contextName(transition, prefix)»",
									"parameters": {},
									"lifespan": 2
								}
							«ENDIF»
						«ENDIF»
					],
					"parameters": [
						«FOR parameter : transition.intent.parameters»
							{
								"id": "«UUID.randomUUID().toString»",
								"required": «parameter.required»,
								"dataType": "«parameter.paramType()»",
								"name": "«parameter.name»",
								"value": "$«parameter.name»",
								"prompts": [
									«FOR prompt :parameter.prompts»
										«FOR text : prompt.prompts»
											{
												«IF prompt.language != Language.EMPTY»
													"lang": "«prompt.language.languageAbbreviation»",
												«ELSE»
													"lang": "«bot.languages.get(0).languageAbbreviation»",
												«ENDIF»
												"value": "«text»"
											}«IF !isTheLast(parameter.prompts, prompt) || !isTheLast(prompt.prompts, text)»,«ENDIF»
										«ENDFOR»
									«ENDFOR»
								],
								"isList":«parameter.isList» 
							}«IF !isTheLast(transition.intent.parameters, parameter)»,«ENDIF»
						«ENDFOR»
					],
					"messages": [
						«IF transition.target!==null»
							«var coma=""»
							«FOR action:transition.target.actions»
								«IF action instanceof Text»
									«FOR texLanguage : action.inputs»
										«coma»
										{
											"type": 0,
											«IF texLanguage.language != Language.EMPTY»
												"lang": "«texLanguage.language.languageAbbreviation»",
											«ELSE»
												"lang": "«bot.languages.get(0).languageAbbreviation»",
											«ENDIF»
											"condition": "",
											"speech": [
												«texLanguage.speechText»
											]
										}
										«{coma=","; ""}»
									«ENDFOR»
								«ELSEIF action instanceof Image»
									«coma»
									{
										"type": 3,
										"condition": "",
										"imageUrl": "«(action as Image).URL»"
									}
									«{coma=","; ""}»
								«ELSEIF action instanceof HTTPRequest»
									«{webhook=true; ""}»
								«ENDIF»
							«ENDFOR »
			«ENDIF»
			],
			"defaultResponsePlatforms": {},
			"speech": []
			}
			],
			"priority": 500000,
			"webhookUsed": «webhook»,
			"webhookForSlotFilling": false,
			"fallbackIntent": «transition.intent.fallbackIntent»,
			"events": [],
			"conditionalResponses": [],
			"condition": "",
			"conditionalFollowupEvents": []
		}
	'''

	def agentJSON(Bot bot, HTTPRequest request) '''
		{
		  "language": "«bot.languages.get(0).languageAbbreviation»",
		  "defaultTimezone": "Europe/Madrid",
		  «IF request !== null »
		  	"webhook": {
		  	  "url": "«returnText(request.URL)»",
		  	  «IF request.basicAuth !== null»
		  	  	"username": "«returnText(request.basicAuth.key)»",
		  	  «ELSE»
		  	  	"username": "",
		  	  «ENDIF»
		  	  "headers": {
		  	   «FOR  header : request.headers»
		  	   	"«header.key»": "«(header.value as Literal).text»"«IF !request.headers.isTheLast(header)»,«ENDIF»
		  	   «ENDFOR»
		  	  },
		  	  "available": true,
		  	  "useForDomains": false,
		  	  "cloudFunctionsEnabled": false,
		  	  "cloudFunctionsInitialized": false
		  	},
		  «ENDIF»
		  "isPrivate": true,
		  "customClassifierMode": "use.after",
		  "mlMinConfidence": 0.3,
		  "supportedLanguages": [
		  «IF bot.languages.size > 1»
		  	«FOR  i : 1..bot.languages.size-1»
		  		"«bot.languages.get(i).languageAbbreviation»"«IF !bot.languages.isTheLast(bot.languages.get(i))»,«ENDIF»
		  	«ENDFOR»
		  «ENDIF»
		  ],
		  "onePlatformApiVersion": "v2",
		  "analyzeQueryTextSentiment": false,
		  "enabledKnowledgeBaseNames": [],
		  "knowledgeServiceConfidenceAdjustment": -0.4,
		  "dialogBuilderMode": false,
		  "baseActionPackagesUrl": ""
		}
		
	'''

	def usersayFile(IntentLanguageInputs intent) '''
		[
		«FOR phrase : intent.inputs»
		«IF phrase instanceof TrainingPhrase»
			{
			  "id": "«UUID.randomUUID().toString»",
			  "data": [
			«FOR token: phrase.tokens»
				«IF token instanceof Literal»
					{
					  "text": "«token.text»",
					  "userDefined": false
					},
				«ELSEIF token instanceof ParameterReferenceToken»
					{
					  "text": "«(token as ParameterReferenceToken).textReference»",
					  "alias": "«(token as ParameterReferenceToken).parameter.name»",
					  "meta": "«(token as ParameterReferenceToken).parameter.paramType»",
					  "userDefined": true
					},
				«ENDIF»
				{
					"text": " ",
					"userDefined": false
				}«IF !phrase.tokens.isTheLast(token)»,«ENDIF»
			«ENDFOR»
			],
			"isTemplate": false,
			"count": 0,
			"updated": 0
			}«IF !isTheLast(intent.inputs, phrase)»,«ENDIF»
			«ENDIF»
		 «ENDFOR»
		 ]
	'''

	def returnText(String value) {
		if (value.isEmpty) {
			return '';
		}
		return value
	}

	def languageAbbreviation(Language lan) {
		switch (lan) {
			case Language.ENGLISH:
				return 'en'
			case Language.SPANISH:
				return 'es'
			case Language.DANISH:
				return 'da'
			case Language.GERMAN:
				return 'de'
			case Language.FRENCH:
				return 'fr'
			case Language.HINDI:
				return 'hi'
			case Language.INDONESIAN:
				return 'id'
			case Language.ITALIAN:
				return 'it'
			case Language.JAPANESE:
				return 'ja'
			case Language.KOREAN:
				return 'ko'
			case Language.DUTCH:
				return 'nl'
			case Language.NORWEGIAN:
				return 'no'
			case Language.POLISH:
				return 'pl'
			case Language.PORTUGUESE:
				return 'pt'
			case Language.RUSIAN:
				return 'ru'
			case Language.SWEDISH:
				return 'sv'
			case Language.THAI:
				return 'th'
			case Language.TURKISH:
				return 'tr'
			case Language.UKRANIAN:
				return 'uk'
			case Language.CHINESE:
				return 'zh'
			default:
				return 'en'
		}
	}

	def entityFile(Entity entity) '''
		
		{
			"id": "«UUID.randomUUID().toString»",
			"name": "«entity.name»",
			"isOverridable": true,	  
			«IF BotGenerator.entityType(entity) === BotGenerator.REGEX»
			"isEnum": false,
			"isRegexp":true,
			"automatedExpansion": true,
			"allowFuzzyExtraction": false
			«ELSEIF BotGenerator.entityType(entity) === BotGenerator.SIMPLE»
			"isEnum": false,
			"isRegexp": false,
			"automatedExpansion": true,
			"allowFuzzyExtraction": true
			«ELSE»
			"isEnum": true,
			"isRegexp": false,
			"automatedExpansion": false,
			"allowFuzzyExtraction": false
			«ENDIF»
		}
	'''



	def entityIsSimple(Entity entity) {
	}

	def entriesFile(LanguageInput entity) '''
		[
			«FOR entry : entity.inputs»
				{
				   «entry(entry)»
				} «IF !entity.inputs.isTheLast(entry)»,«ENDIF»
			«ENDFOR»
		]
	'''
	
	def entry(EntityInput entry){
		if (entry instanceof SimpleInput){
			return entry(entry)
		}else if (entry instanceof CompositeInput){
			return entry(entry)
		}else if (entry instanceof RegexInput){
			return entry(entry)
		}
	}
	
	def entry(SimpleInput entry)'''
		"value": "«entry.name»",
		"synonyms": [
			"«entry.name»"«IF !entry.values.empty»,«ENDIF»
			«FOR synonym: entry.values»
			"«synonym»"«IF !entry.values.isTheLast(synonym)»,«ENDIF»
			«ENDFOR»
		]
	'''
	
	def entry(CompositeInput entry)'''
		"value": "«entry.compositeEntry»",
		"synonyms": [
			"«entry.compositeEntry»"
		]
	'''
	def entry(RegexInput entry)'''
		"value": "«entry.expresion»",
		"synonyms": [
			"«entry.expresion»"
		]
	'''

	def static isTheLast(List<?> list, Object object) {
		if (list.indexOf(object) == list.size - 1) {
			return true;
		}
		return false;

	}

	def getCompositeEntry(CompositeInput entry) {
		var ret = "";
		for (Token token : entry.expresion) {
			if (token instanceof Literal) {
				ret += token.text + " "
			} else if (token instanceof EntityToken) {
				ret += "@" + token.entity.name + ":" + token.entity.name + " "
			}
		}
		return ret;
	}
}

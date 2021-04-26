/*
 * generated by Xtext 2.19.0
 */
package org.xtext.botGenerator.formatting2

import com.google.inject.Inject
import generator.Bot
import generator.Intent
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.xtext.botGenerator.services.BotGrammarAccess

class BotFormatter extends AbstractFormatter2 {
	
	@Inject extension BotGrammarAccess

	def dispatch void format(Bot bot, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (intent : bot.intents) {
			intent.format
		}
		for (entity : bot.entities) {
			entity.format
		}
		for (action : bot.actions) {
			action.format
		}
		for (transition : bot.flows) {
			transition.format
		}
	}

	def dispatch void format(Intent intent, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (trainingPhrase : intent.inputs) {
			trainingPhrase.format
		}
		for (parameter : intent.parameters) {
			parameter.format
		}
	}
	
	// TODO: implement for Transition, State, TrainingPhrase, Simple, Composite, CompositeInput, Text, HTTPRequest, TextInputs, KeyValue
}
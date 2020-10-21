/*
 * generated by Xtext 2.19.0
 */
package org.xtext.botGenerator.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import generator.Entity
import generator.RegexInput
import generator.SimpleInput
import generator.Intent
import zipUtils.Zip;
import org.eclipse.core.resources.ResourcesPlugin

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class BotGenerator extends AbstractGenerator {
	public static final int REGEX = 0;
	public static final int SIMPLE = 1;
	public static final int COMPOSITE = 2;
	public static final int TRAINING = 3;
	static boolean isPlugin = true;
	static String newpath;

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var resourceName = resource.URI.lastSegment.substring(0, resource.URI.lastSegment.indexOf("."));
		var uri = ""
		if (isPlugin) {
			var workspacePath = ResourcesPlugin.workspace.getRoot().location.toString()
			uri = workspacePath + "/" + fsa.getURI("src-gen").toPlatformString(true);
		} else {
			uri = newpath+"/";
		}
		var dialogflowGeneratorUri = resource.URI.devicePath.replace(resource.URI.lastSegment, "")+"/Dialogflow"
		var dialogflowZip = new Zip(dialogflowGeneratorUri, resourceName)
		var dialogflow = new DialogflowGenerator()
		dialogflow.doGenerate(resource, fsa, context, dialogflowZip)
		
		var rasaUri = resource.URI.devicePath.replace(resource.URI.lastSegment, "")+"/Rasa"
		var rasaZip = new Zip(rasaUri, resourceName)
		var rasa = new RasaGenerator()
	    rasa.doGenerate(resource, fsa, context, rasaZip)
	}

	def static entityType(Entity entity) {
		if (entity !== null) {
			var input = entity.inputs.get(0)
			if (input.inputs.get(0) instanceof RegexInput) {
				return REGEX
			} else if (input.inputs.get(0) instanceof SimpleInput) {
				return SIMPLE
			} else {
				return COMPOSITE
			}
		}
	}

	static def setIsPlugin(boolean value) {
		isPlugin = value
	}

	static def newPath(String path) {
		isPlugin = false;
		newpath = path
	}

	def static intentType(Intent intent) {
		var input = intent.inputs.get(0)
		if (input.inputs.get(0) instanceof RegexInput) {
			return REGEX
		} else {
			return TRAINING
		}
	}

}

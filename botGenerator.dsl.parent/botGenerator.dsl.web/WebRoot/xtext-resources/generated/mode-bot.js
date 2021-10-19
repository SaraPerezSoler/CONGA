define(["ace/lib/oop", "ace/mode/text", "ace/mode/text_highlight_rules"], function(oop, mText, mTextHighlightRules) {
	var HighlightRules = function() {
		var keywords = "Button|Chatbot|Composite|Empty|FORM|Fallback|Image|JSON|Regex|Request|Response|Simple|Text|URL|actions|ar|ba|basicAuth|bu|caption|chatbot|composite|cz|da|data|dataType|date|de|en|entities|entity|es|false|fi|float|flows|fr|get|gr|headers|hi|id|image|in|inputs|intents|isList|it|ja|ko|language|mage|nl|no|number|parameters|pattern|pl|post|prompts|pt|required|response|ru|status_code|sv|synonyms|text|th|time|tr|true|uk|user|zh";
		this.$rules = {
			"start": [
				{token: "comment", regex: "\\/\\/.*$"},
				{token: "comment", regex: "\\/\\*", next : "comment"},
				{token: "string", regex: '["](?:(?:\\\\.)|(?:[^"\\\\]))*?["]'},
				{token: "string", regex: "['](?:(?:\\\\.)|(?:[^'\\\\]))*?[']"},
				{token: "constant.numeric", regex: "[+-]?\\d+(?:(?:\\.\\d*)?(?:[eE][+-]?\\d+)?)?\\b"},
				{token: "lparen", regex: "[\\[({]"},
				{token: "rparen", regex: "[\\])}]"},
				{token: "keyword", regex: "\\b(?:" + keywords + ")\\b"}
			],
			"comment": [
				{token: "comment", regex: ".*?\\*\\/", next : "start"},
				{token: "comment", regex: ".+"}
			]
		};
	};
	oop.inherits(HighlightRules, mTextHighlightRules.TextHighlightRules);
	
	var Mode = function() {
		this.HighlightRules = HighlightRules;
	};
	oop.inherits(Mode, mText.Mode);
	Mode.prototype.$id = "xtext/bot";
	Mode.prototype.getCompletions = function(state, session, pos, prefix) {
		return [];
	}
	
	return {
		Mode: Mode
	};
});

/*
 * generated by Xtext 2.23.0
 */
package org.xtext.botGenerator.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.xtext.botGenerator.parser.antlr.internal.InternalBotParser;
import org.xtext.botGenerator.services.BotGrammarAccess;

public class BotParser extends AbstractAntlrParser {

	@Inject
	private BotGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalBotParser createParser(XtextTokenStream stream) {
		return new InternalBotParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Bot";
	}

	public BotGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(BotGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

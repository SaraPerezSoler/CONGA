/*
 * generated by Xtext 2.25.0
 */
package org.xtext.botGenerator.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class BotAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/xtext/botGenerator/parser/antlr/internal/InternalBot.tokens");
	}
}

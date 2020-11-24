package org.xtext.botGenerator.generator;

public class standAloneExample {

	public static void main(String[] args) {
		BotPlatformStandAlone generator = BotPlatformStandAlone.getBotPlatformStandAlone();
		generator.runGenerator("D:/Google Drive/Presentaciones/2020 ER/bookFlight.bot", "D:/Desktop/temp");
	}
}

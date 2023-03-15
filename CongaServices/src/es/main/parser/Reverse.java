package es.main.parser;

import java.io.File;
import java.io.IOException;


public abstract class Reverse {

	public abstract Chatbot getChatbot(File zip) throws Exception;
	
	protected void removeFile(File file) {
		File[] contents = file.listFiles();
		if (contents != null) {
			for (File f : contents) {
				removeFile(f);
			}
		}
		file.delete();
	}
}

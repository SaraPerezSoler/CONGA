package parser.rasa.bot;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Actions {

	private Map<String, List<String>> requieredParameters;
	
	public Actions(String text) {
		String [] classes = text.split("class");
		Pattern pattern = Pattern.compile("^.*(FormAction):");
		for (String class_:classes) {
			if (pattern.matcher(class_).matches()) {
				String name = class_.substring(class_.indexOf("def name(self)"));
				
			}
		}
	}
}

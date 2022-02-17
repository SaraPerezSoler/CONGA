package es.main.parser.pandorabots.agent;

import java.util.ArrayList;
import java.util.List;

public class SetFile {
	public String name;
	public List<String> content;

	public SetFile() {
		content = new ArrayList<String>();
	}

	public SetFile(String name) {
		this.name = name;
		content = new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getContent() {
		return content;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "SetFile [name=" + name + ", content=" + content + "]";
	}
}

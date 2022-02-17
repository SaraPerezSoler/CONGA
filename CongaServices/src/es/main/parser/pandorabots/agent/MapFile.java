package es.main.parser.pandorabots.agent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapFile {
	public String name;
	public Map<String, List<String>> content;

	public MapFile() {
	}

	public MapFile(String name) {
		this.name = name;
	}

	public MapFile(Map<String, List<String>> content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, List<String>> getContent() {
		return content;
	}

	public void setContent(Map<String, List<String>> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "MapFile [name=" + name + ", content=" + content + "]";
	}

}

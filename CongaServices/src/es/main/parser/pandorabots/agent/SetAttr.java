package es.main.parser.pandorabots.agent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SetAttr {
	@JacksonXmlText
	public String name;

	public SetAttr() {
	}

	public SetAttr(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SetAttr [name=" + name + "]";
	}
}

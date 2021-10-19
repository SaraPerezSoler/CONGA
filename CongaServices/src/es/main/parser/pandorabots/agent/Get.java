package es.main.parser.pandorabots.agent;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "get")
public class Get {
	public String name;

	public Get() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Get [name=" + name + "]";
	}
}

package es.main.parser.pandorabots.agent;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "condition")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Condition {
	@JacksonXmlProperty(isAttribute = true)
	public String name;
//	@JacksonXmlElementWrapper(useWrapping = false, localName = "li")
//	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "li")
	public List<Option> options = new ArrayList<Option>();

	public Condition() {
	}

	public Condition(String name, List<Option> options) {
		this.name = name;
		this.options = options;
	}

	public String getVarName() {
		return name;
	}

	public void setVarName(String varName) {
		this.name = varName;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Condition [name=" + name + ", options=" + options + "]";
	}
}

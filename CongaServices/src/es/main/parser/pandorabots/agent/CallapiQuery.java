package es.main.parser.pandorabots.agent;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "query")
public class CallapiQuery {
	@JacksonXmlProperty(isAttribute = true, localName = "name")
	public String name;
	@JacksonXmlText
	public String text;
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "get")
	public List<Get> gets;

	public CallapiQuery() {
	}

	public CallapiQuery(String name, String text, List<Get> gets) {
		this.name = name;
		this.text = text;
		this.gets = gets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Get> getGets() {
		return gets;
	}

	public void setGets(List<Get> gets) {
		this.gets = gets;
	}

	@Override
	public String toString() {
		return "CallapiQuery [name=" + name + ", text=" + text + ", gets=" + gets + "]";
	}
}

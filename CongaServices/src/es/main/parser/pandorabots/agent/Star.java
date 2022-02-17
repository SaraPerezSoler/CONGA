package es.main.parser.pandorabots.agent;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "star")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Star {
//	private String id;
	@JacksonXmlProperty(isAttribute = true)
	public int index;
	@JacksonXmlText
	public String text;
	
	public Star() {
//		id = UUID.randomUUID().toString();
	}

	public Star(int index, String text) {
		this.index = index;
		this.text = text;
	}

	public Star(int index) {
//		id = UUID.randomUUID().toString();
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

//	@Override
//	public String toString() {
//		return "Star [index=" + index + "]";
//	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Star [index=" + index + ", text=" + text + "]";
	}	
}

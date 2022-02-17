package es.main.parser.pandorabots.agent;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "name")
public class CallapiHeaderName {
	@JacksonXmlText
	public String text;

	public CallapiHeaderName() {
	}

	public CallapiHeaderName(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "CallapiHeaderName [text=" + text + "]";
	}
}

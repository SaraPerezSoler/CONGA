package es.main.parser.pandorabots.agent;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "header")
public class CallapiHeader {
	public CallapiHeaderName name;

	public CallapiHeader() {
	}

	public CallapiHeader(CallapiHeaderName name) {
		this.name = name;
	}

	public CallapiHeaderName getName() {
		return name;
	}

	public void setName(CallapiHeaderName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CallapiHeader [name=" + name + "]";
	}
}

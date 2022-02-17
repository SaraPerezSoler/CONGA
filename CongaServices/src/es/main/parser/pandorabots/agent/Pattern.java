package es.main.parser.pandorabots.agent;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "pattern")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Pattern {
	@JacksonXmlText
	public String text;
//	@JacksonXmlText
//	@JacksonXmlElementWrapper(useWrapping = false)
//	public List<String> texts;
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "set")
	public List<SetAttr> sets;
//	@JacksonXmlProperty(localName = "set")
//	public SetAttr set;

	public Pattern() {
	}

	public Pattern(String text, List<SetAttr> sets) {
		this.text = text;
		this.sets = sets;
	}

//	public Pattern(String text, SetAttr set) {
//		super();
//		this.text = text;
//		this.set = set;
//	}
//
//	public SetAttr getSet() {
//		return set;
//	}
//
//	public void setSet(SetAttr set) {
//		this.set = set;
//	}

//	@Override
//	public String toString() {
//		return "Pattern [text=" + text + ", set=" + set + "]";
//	}

	public Pattern(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<SetAttr> getSets() {
		return sets;
	}

	public void setSets(List<SetAttr> sets) {
		this.sets = sets;
	}

	@Override
	public String toString() {
		return "Pattern [text=" + text + ", sets=" + sets + "]";
	}
}

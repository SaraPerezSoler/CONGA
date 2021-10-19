package es.main.parser.pandorabots.agent;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "li")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Option {
	@JacksonXmlProperty(isAttribute = true)
	public String value;
	public Star star;
	@JacksonXmlText
	public String text;
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "srai")
	public List<Srai> srais;
	public Condition condition;
	public Think think;

	public Option() {
	}

	public Option(String value, Star star, String text, List<Srai> srais, Condition condition, Think think) {
		super();
		this.value = value;
		this.star = star;
		this.text = text;
		this.srais = srais;
		this.condition = condition;
		this.think = think;
	}

	public Option(String text) {
		super();
		this.text = text;
	}

	public Option(String value, String text) {
		super();
		this.value = value;
		this.text = text;
	}

	public Option(String value, Star star) {
		super();
		this.value = value;
		this.star = star;
	}

	public Option(String value, Condition condition) {
		super();
		this.value = value;
		this.condition = condition;
	}

	public Option(String value, String text, Condition condition) {
		super();
		this.value = value;
		this.text = text;
		this.condition = condition;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Srai> getSrais() {
		return srais;
	}

	public void setSrais(List<Srai> srais) {
		this.srais = srais;
	}

	public Think getThink() {
		return think;
	}

	public void setThink(Think think) {
		this.think = think;
	}

	@Override
	public String toString() {
		return "Option [value=" + value + ", star=" + star + ", text=" + text + ", srais=" + srais + ", condition="
				+ condition + ", think=" + think + "]";
	}
}

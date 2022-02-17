package es.main.parser.pandorabots.agent;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "set")
public class Set {
	@JacksonXmlProperty(isAttribute = true, localName = "name")
	public String name;
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "star")
	public List<Star> stars;
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "srai")
	public List<Srai> srais;
	public Get getVar;
	@JacksonXmlText
	public String text;

	public Set() {
	}

	public Set(String name, List<Star> stars, List<Srai> srais, Get getVar, String text) {
		super();
		this.name = name;
		this.stars = stars;
		this.srais = srais;
		this.getVar = getVar;
		this.text = text;
	}

	public Set(String name, String text) {
		this.name = name;
		this.text = text;
	}

	public Set(String name, List<Srai> srais) {
		this.name = name;
		this.srais = srais;
	}

	public Set(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Star> getStars() {
		return stars;
	}

	public void setStars(List<Star> stars) {
		this.stars = stars;
	}

	public Get getGetVar() {
		return getVar;
	}

	public void setGetVar(Get getVar) {
		this.getVar = getVar;
	}

	public List<Srai> getSrais() {
		return srais;
	}

	public void setSrais(List<Srai> srais) {
		this.srais = srais;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Set [name=" + name + ", stars=" + stars + ", srais=" + srais + ", getVar=" + getVar + ", text=" + text
				+ "]";
	}
}
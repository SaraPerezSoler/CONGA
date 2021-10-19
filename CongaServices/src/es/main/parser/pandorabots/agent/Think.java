package es.main.parser.pandorabots.agent;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "think")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Think {
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "set")
	public List<Set> sets;
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "srai")
	public List<Srai> srais;
	@JacksonXmlText
	public String text;

	public Think() {
	}

//	public Think(List<Set> sets, List<Srai> srais, String text) {
//		this.sets = sets;
//		this.srais = srais;
//		this.text = text;
//	}


	public Think(List<?> things, String text) {
		for (var thing: things) {
			if (thing instanceof Set) {
				if (sets == null)
					sets = new ArrayList<Set>();
				
				sets.add((Set) thing);
			}
			
			else {
				if (srais == null)
					srais = new ArrayList<Srai>();
				
				srais.add((Srai) thing);
			}
		}
		
		this.text = text;
	}
	
	public Think(List<Set> sets, List<Srai> srais) {
		this.sets = sets;
		this.srais = srais;
	}
	
	public Think(String text) {
		this.text = text;
	}

//	public Think(List<Set> sets) {
//		this.sets = sets;
//	}

	public Think(List<?> things) {
		for (var thing: things) {
			if (thing instanceof Set) {
				if (sets == null)
					sets = new ArrayList<Set>();
				
				sets.add((Set) thing);
			}
			
			else {
				if (srais == null)
					srais = new ArrayList<Srai>();
				
				srais.add((Srai) thing);
			}
		}
	}
//	public Think(List<Srai> srais) {
//		this.srais = srais;
//	}

	public List<Set> getSets() {
		return sets;
	}

	public void setSets(List<Set> sets) {
		this.sets = sets;
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
		return "Think [sets=" + sets + ", srais=" + srais + ", text=" + text + "]";
	}
//	@Override
//	public String toString() {
//		return "Think [sets=" + sets + ", srais=" + srais + "]";
//	}

}

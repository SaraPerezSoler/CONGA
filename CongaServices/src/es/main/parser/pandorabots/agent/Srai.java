package es.main.parser.pandorabots.agent;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.DomHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "srai")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Srai {
	@JacksonXmlElementWrapper(useWrapping = false)
	@JacksonXmlProperty(localName = "star")
	public List<Star> stars;
	@JacksonXmlText
	public String text;
	
	public Srai() {}
	
	public Srai(String text, List<Star> stars) {
		this.text = text;
		this.stars = stars;
	}
	
	public Srai(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public List<Star> getStars() {
		return stars;
	}

	public void setStars(List<Star> stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "Srai [text=" + text + ", stars=" + stars + "]";
	}
}

class DeSerializer extends StdDeserializer<Srai> {

	protected DeSerializer() {
		super(Srai.class);
	}

	@Override
	public Srai deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String name = p.getText();
//		TreeNode node = p.getCodec().readTree(p);
//		String name = node.get("name").toString();
//		String value = node.toString();

//		int i = 0;
//		var currentVal = node.get(i);
//		while (currentVal != null) {
//			System.out.println("\n....\n" + currentVal + "\n....\n");
//		}

		// use p.getText() and p.nextToken to navigate through the xml and construct
		// Person object
//		if(p.getCurrentValue() instanceof List)
//			for (var elems: (p.getCurrentValue()))

//		return new Set(name, "\n" + p.getText() + "\n");
//		return new Srai("\n....\n" + name + "\n----\n" + value + "\n----\n");
		return new Srai("\n....\n" + name + "\n....\n");
	}
}
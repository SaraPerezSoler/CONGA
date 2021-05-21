package reverse.rasa.bot.intents;

import org.json.JSONObject;
import org.jsoup.nodes.Element;

import generator.Bot;
import generator.DefaultEntity;
import generator.GeneratorFactory;
import generator.Parameter;
import generator.ParameterReferenceToken;

public class Entity extends Token {

	private String literal;
	private String entity;
	private String role;
	private String group;
	private String value;

	public Entity(String literalString) {
		this.literal = literalString.substring(literalString.indexOf("[")+1, literalString.indexOf("]"));
		literalString = literalString.replace("["+this.literal+"]", "");
		if (literalString.contains("(")&& literalString.contains(")")) {
			this.entity = literalString.substring(literalString.indexOf("(")+1, literalString.indexOf(")"));
		}else if (literalString.startsWith("{")&& literalString.endsWith("}")) {
			JSONObject object = new JSONObject(literalString); 
			if (object.has("entity")) {
				this.entity = object.getString("entity");
			}
			if (object.has("role")) {
				this.role = object.getString("role");
			}
			if (object.has("group")) {
				this.group = object.getString("group");
			}
			if (object.has("value")) {
				this.value = object.getString("value");
			}
		}
	}

	public Entity(Element param) {
		this.entity = param.attr("href");
		this.literal = param.text();
	}

	public String getLiteral() {
		return literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	protected generator.Token createBotToken(Bot bot, generator.Intent intent) {
		ParameterReferenceToken token = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
		token.setTextReference(literal);
		
		Parameter param = intent.getParameter(entity);
		
		if (param==null) {
			param = createParameter(bot, intent);
			intent.getParameters().add(param);
		}
		
		token.setParameter(param);
		
		return token;
	}
	
	private Parameter createParameter(Bot bot, generator.Intent intent) {
		Parameter param = GeneratorFactory.eINSTANCE.createParameter();
		param.setName(entity);
		generator.Entity ent = bot.getEntity(entity);
		if (ent == null) {
			if (entity.contains("time")) {
				param.setDefaultEntity(DefaultEntity.TIME);
			}else if (entity.contains("date")) {
				param.setDefaultEntity(DefaultEntity.DATE);
			}else {
				param.setDefaultEntity(DefaultEntity.TEXT);
			}
		}else {
			param.setEntity(ent);
		}
		return param;
	}

}

package es.main.parser.dialogflow.agent.intents;

import java.util.List;

import generator.Bot;
import generator.DefaultEntity;
import generator.Entity;
import generator.GeneratorFactory;
import generator.Literal;
import generator.ParameterReferenceToken;

public class TrainingPhrase {
	
	private List<Data> data;
	private boolean isTemplate;
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	public boolean isTemplate() {
		return isTemplate;
	}
	public void setTemplate(boolean isTemplate) {
		this.isTemplate = isTemplate;
	}
	public generator.TrainingPhrase getBotTrainingPhrase(generator.Intent intent, Bot bot) {
		generator.TrainingPhrase training = GeneratorFactory.eINSTANCE.createTrainingPhrase();
		String text = "";
		for (Data data : getData()) {
			if (!data.getAlias().isEmpty()) {
				if (!text.isEmpty()) {
					Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
					literal.setText(text);
					training.getTokens().add(literal);
					text = "";
				}
				generator.Parameter param = intent.getParameter(data.getAlias());
				if (param == null) {
					param = createParam(data, bot);
					intent.getParameters().add(param);
				}
				ParameterReferenceToken reference = GeneratorFactory.eINSTANCE.createParameterReferenceToken();
				reference.setTextReference(data.getText());
				reference.setParameter(param);
				training.getTokens().add(reference);
			} else {
				text+=data.getText();
			}
		}
		if (!text.isEmpty()) {
			Literal literal = GeneratorFactory.eINSTANCE.createLiteral();
			literal.setText(text);
			training.getTokens().add(literal);
			text = "";
		}
		return training;
	}
	
	private generator.Parameter createParam (Data data, Bot bot) {
		generator.Parameter parameter = GeneratorFactory.eINSTANCE.createParameter();
		parameter.setName(data.getAlias());
		
		String type = data.getMeta().replace("@", "");
		Entity entity = bot.getEntity(type);
		if (entity == null) {
			DefaultEntity default_ = Parameter.getDefaultEntity(type);
			parameter.setDefaultEntity(default_);
		} else {
			parameter.setEntity(entity);
		}
		return parameter;
	}
	
}

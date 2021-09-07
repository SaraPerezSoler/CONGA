package reverse.dialogflow.agent.intents;

import java.util.List;

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
	public generator.TrainingPhrase getBotTrainingPhrase(generator.Intent intent) {
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
	
}

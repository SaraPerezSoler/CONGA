
import congaAnnotation.Annotation;
import congaAnnotation.AvgSim;
import congaAnnotation.CongaAnnotationFactory;
import congaAnnotation.IntentAvgSim;
import congaAnnotation.SemanticSimilarity;
import generator.Bot;
import generator.Intent;
import generator.LanguageIntent;
import generator.TrainingPhrase;

public class GenerateAnnotations {

	public static Annotation calculateAnnotation(Bot bot) {
		Annotation annotation = CongaAnnotationFactory.eINSTANCE.createAnnotation();
		for (Intent i1 : bot.getIntents()) {
			for (LanguageIntent lan1 : i1.getInputs()) {
				for (TrainingPhrase tp1 : lan1.getInputs()) {
					AvgSim avg = CongaAnnotationFactory.eINSTANCE.createAvgSim();
					avg.setTrainingPhrase(tp1);
					avg.setAvg(0);
					int numSentence = 0;
					for (Intent i2 : bot.getIntents()) {
						IntentAvgSim intentAvg = CongaAnnotationFactory.eINSTANCE.createIntentAvgSim();
						intentAvg.setTrainingPhrase(tp1);
						intentAvg.setIntent(i2);
						intentAvg.setAvg(0);
						LanguageIntent lan2 = i2.getInput(lan1.getLanguage());
						int numIntentSentence = 0;
						if (lan2 != null) {
							for (TrainingPhrase tp2 : lan2.getInputs()) {
								if (!tp1.equals(tp2)) {
									SemanticSimilarity semSim = CongaAnnotationFactory.eINSTANCE
											.createSemanticSimilarity();
									semSim.setTrainingPhrase1(tp1);
									semSim.setTrainingPhrase2(tp2);
									float confusing = matrixImport.calculateConfusing(tp1.getSentence(), tp2.getSentence());
									semSim.setSimilarity(confusing);
									annotation.getSemanticSimilarities().add(semSim);
									numSentence++;
									numIntentSentence++;
									// avg
									double aux = avg.getAvg();
									avg.setAvg(aux + confusing);
									if (avg.getMin() == null || avg.getMinValue() > confusing) {
										avg.setMin(tp2);
										avg.setMinValue(confusing);
									}
									if (avg.getMax() == null || avg.getMaxValue() < confusing) {
										avg.setMax(tp2);
										avg.setMaxValue(confusing);
									}
									// IntentAvg
									aux = intentAvg.getAvg();
									intentAvg.setAvg(aux + confusing);
									if (intentAvg.getMin() == null || intentAvg.getMinValue() > confusing) {
										intentAvg.setMin(tp2);
										intentAvg.setMinValue(confusing);
									}
									if (intentAvg.getMax() == null || intentAvg.getMaxValue() < confusing) {
										intentAvg.setMax(tp2);
										intentAvg.setMaxValue(confusing);
									}
								}
							}
						}
						double aux = intentAvg.getAvg();
						intentAvg.setAvg(aux / numIntentSentence);
						annotation.getIntentAvgSims().add(intentAvg);
					}
					double aux = avg.getAvg();
					avg.setAvg(aux/numSentence);
					annotation.getAvgSims().add(avg);
				}
			}
		}
		return annotation;
	}
}

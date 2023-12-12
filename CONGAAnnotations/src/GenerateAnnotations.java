
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import congaAnnotation.Annotation;
import congaAnnotation.CongaAnnotationFactory;
import congaAnnotation.IntentIntentValue;
import congaAnnotation.IntentValue;
import congaAnnotation.SemanticSimilarity;
import congaAnnotation.TPAvg;
import congaAnnotation.TPIntentAvgSim;
import generator.Bot;
import generator.Intent;
import generator.LanguageIntent;
import generator.TrainingPhrase;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import com.google.common.collect.Lists;

public class GenerateAnnotations {

	public static Annotation calculateAnnotation(Bot bot) {
		Annotation annotation = CongaAnnotationFactory.eINSTANCE.createAnnotation();
		for (Intent i1 : bot.getIntents()) {
			List<TrainingPhrase> list1 = Lists.newArrayList(IteratorExtensions.filter(i1.eAllContents(), TrainingPhrase.class));
			if (!i1.isFallbackIntent() && list1.size()>1) {
				Map<Intent, IntentIntentValue> iivalues = new HashMap<>();
				IntentValue ivalue = CongaAnnotationFactory.eINSTANCE.createIntentValue();
				ivalue.setIntent(i1);

				for (LanguageIntent lan1 : i1.getInputs()) {
					for (TrainingPhrase tp1 : lan1.getInputs()) {
						TPAvg avg = CongaAnnotationFactory.eINSTANCE.createTPAvg();
						avg.setTrainingPhrase(tp1);
						avg.setAvg(0);
						int numSentence = 0;
						for (Intent i2 : bot.getIntents()) {
							List<TrainingPhrase> list2 = Lists.newArrayList(IteratorExtensions.filter(i2.eAllContents(), TrainingPhrase.class));
							if (!i2.isFallbackIntent() && list2.size()>0) {
								TPIntentAvgSim intentAvg = CongaAnnotationFactory.eINSTANCE.createTPIntentAvgSim();
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
											float confusing = matrixImport.calculateConfusing(tp1.getSentence(),
													tp2.getSentence());
											semSim.setSimilarity(confusing);
											annotation.getSemanticSimilarities().add(semSim);
											numSentence++;
											numIntentSentence++;
											// avg
											float aux = avg.getAvg();
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

									float aux = intentAvg.getAvg();
									intentAvg.setAvg(aux / numIntentSentence);
									annotation.getTpIntentAvgSims().add(intentAvg);

								}
								if (i1.equals(i2)) {
									if (ivalue.getMin1() == null || ivalue.getMin1Value() > intentAvg.getAvg()) {
										ivalue.setMin2(ivalue.getMin1());
										ivalue.setMin2Value(ivalue.getMin1Value());
										ivalue.setMin1(intentAvg.getTrainingPhrase());
										ivalue.setMin1Value(intentAvg.getAvg());
									} else if (ivalue.getMin2() == null || ivalue.getMin2Value() > intentAvg.getAvg()) {
										ivalue.setMin2(intentAvg.getTrainingPhrase());
										ivalue.setMin2Value(intentAvg.getAvg());
									}

									if (ivalue.getMax1() == null || ivalue.getMax1Value() < intentAvg.getAvg()) {
										ivalue.setMax2(ivalue.getMax1());
										ivalue.setMax2Value(ivalue.getMax1Value());
										ivalue.setMax1(intentAvg.getTrainingPhrase());
										ivalue.setMax1Value(intentAvg.getAvg());
									} else if (ivalue.getMax2() == null || ivalue.getMax2Value() < intentAvg.getAvg()) {
										ivalue.setMax2(intentAvg.getTrainingPhrase());
										ivalue.setMax2Value(intentAvg.getAvg());
									}
								} else {
									IntentIntentValue iivalue = iivalues.get(i2);
									if (iivalue == null) {
										iivalue = CongaAnnotationFactory.eINSTANCE.createIntentIntentValue();
										iivalue.setIntent1(i1);
										iivalue.setIntent2(i2);
										iivalues.put(i2, iivalue);
									}
									if (iivalue.getMin1() == null || iivalue.getMin1Value() > intentAvg.getAvg()) {
										iivalue.setMin2(iivalue.getMin1());
										iivalue.setMin2Value(iivalue.getMin1Value());
										iivalue.setMin1(intentAvg.getTrainingPhrase());
										iivalue.setMin1Value(intentAvg.getAvg());
									} else if (iivalue.getMin2() == null
											|| iivalue.getMin2Value() > intentAvg.getAvg()) {
										iivalue.setMin2(intentAvg.getTrainingPhrase());
										iivalue.setMin2Value(intentAvg.getAvg());
									}

									if (iivalue.getMax1() == null || iivalue.getMax1Value() < intentAvg.getAvg()) {
										iivalue.setMax2(iivalue.getMax1());
										iivalue.setMax2Value(iivalue.getMax1Value());
										iivalue.setMax1(intentAvg.getTrainingPhrase());
										iivalue.setMax1Value(intentAvg.getAvg());
									} else if (iivalue.getMax2() == null
											|| iivalue.getMax2Value() < intentAvg.getAvg()) {
										iivalue.setMax2(intentAvg.getTrainingPhrase());
										iivalue.setMax2Value(intentAvg.getAvg());
									}

								}
							}
						}
						float aux = avg.getAvg();
						avg.setAvg(aux / numSentence);
						annotation.getTpAvgSims().add(avg);
					}
				}
				if (list1.size()>1) {
					annotation.getIntentValues().add(ivalue);
				}
				annotation.getIntentIntentValues().addAll(iivalues.values());
			}
		}

		return annotation;
	}
}

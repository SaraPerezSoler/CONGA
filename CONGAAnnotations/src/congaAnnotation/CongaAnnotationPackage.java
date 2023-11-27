/**
 */
package congaAnnotation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see congaAnnotation.CongaAnnotationFactory
 * @model kind="package"
 * @generated
 */
public interface CongaAnnotationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "congaAnnotation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "congaAnnotation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "congaAnnotation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CongaAnnotationPackage eINSTANCE = congaAnnotation.impl.CongaAnnotationPackageImpl.init();

	/**
	 * The meta object id for the '{@link congaAnnotation.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congaAnnotation.impl.AnnotationImpl
	 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Semantic Similarities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__SEMANTIC_SIMILARITIES = 0;

	/**
	 * The feature id for the '<em><b>Avg Sims</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__AVG_SIMS = 1;

	/**
	 * The feature id for the '<em><b>Intent Avg Sims</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__INTENT_AVG_SIMS = 2;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congaAnnotation.impl.SemanticSimilarityImpl <em>Semantic Similarity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congaAnnotation.impl.SemanticSimilarityImpl
	 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getSemanticSimilarity()
	 * @generated
	 */
	int SEMANTIC_SIMILARITY = 1;

	/**
	 * The feature id for the '<em><b>Training Phrase1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_SIMILARITY__TRAINING_PHRASE1 = 0;

	/**
	 * The feature id for the '<em><b>Training Phrase2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_SIMILARITY__TRAINING_PHRASE2 = 1;

	/**
	 * The feature id for the '<em><b>Similarity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_SIMILARITY__SIMILARITY = 2;

	/**
	 * The number of structural features of the '<em>Semantic Similarity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_SIMILARITY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Semantic Similarity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEMANTIC_SIMILARITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congaAnnotation.impl.AvgSimImpl <em>Avg Sim</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congaAnnotation.impl.AvgSimImpl
	 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getAvgSim()
	 * @generated
	 */
	int AVG_SIM = 2;

	/**
	 * The feature id for the '<em><b>Training Phrase</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVG_SIM__TRAINING_PHRASE = 0;

	/**
	 * The feature id for the '<em><b>Avg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVG_SIM__AVG = 1;

	/**
	 * The feature id for the '<em><b>Min</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVG_SIM__MIN = 2;

	/**
	 * The feature id for the '<em><b>Max</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVG_SIM__MAX = 3;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVG_SIM__MIN_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVG_SIM__MAX_VALUE = 5;

	/**
	 * The number of structural features of the '<em>Avg Sim</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVG_SIM_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Avg Sim</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVG_SIM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congaAnnotation.impl.IntentAvgSimImpl <em>Intent Avg Sim</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congaAnnotation.impl.IntentAvgSimImpl
	 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getIntentAvgSim()
	 * @generated
	 */
	int INTENT_AVG_SIM = 3;

	/**
	 * The feature id for the '<em><b>Training Phrase</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_AVG_SIM__TRAINING_PHRASE = 0;

	/**
	 * The feature id for the '<em><b>Intent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_AVG_SIM__INTENT = 1;

	/**
	 * The feature id for the '<em><b>Avg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_AVG_SIM__AVG = 2;

	/**
	 * The feature id for the '<em><b>Min</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_AVG_SIM__MIN = 3;

	/**
	 * The feature id for the '<em><b>Max</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_AVG_SIM__MAX = 4;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_AVG_SIM__MIN_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_AVG_SIM__MAX_VALUE = 6;

	/**
	 * The number of structural features of the '<em>Intent Avg Sim</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_AVG_SIM_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Intent Avg Sim</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_AVG_SIM_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link congaAnnotation.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see congaAnnotation.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the containment reference list '{@link congaAnnotation.Annotation#getSemanticSimilarities <em>Semantic Similarities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Semantic Similarities</em>'.
	 * @see congaAnnotation.Annotation#getSemanticSimilarities()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_SemanticSimilarities();

	/**
	 * Returns the meta object for the containment reference list '{@link congaAnnotation.Annotation#getAvgSims <em>Avg Sims</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Avg Sims</em>'.
	 * @see congaAnnotation.Annotation#getAvgSims()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_AvgSims();

	/**
	 * Returns the meta object for the containment reference list '{@link congaAnnotation.Annotation#getIntentAvgSims <em>Intent Avg Sims</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intent Avg Sims</em>'.
	 * @see congaAnnotation.Annotation#getIntentAvgSims()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_IntentAvgSims();

	/**
	 * Returns the meta object for class '{@link congaAnnotation.SemanticSimilarity <em>Semantic Similarity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Semantic Similarity</em>'.
	 * @see congaAnnotation.SemanticSimilarity
	 * @generated
	 */
	EClass getSemanticSimilarity();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.SemanticSimilarity#getTrainingPhrase1 <em>Training Phrase1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Training Phrase1</em>'.
	 * @see congaAnnotation.SemanticSimilarity#getTrainingPhrase1()
	 * @see #getSemanticSimilarity()
	 * @generated
	 */
	EReference getSemanticSimilarity_TrainingPhrase1();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.SemanticSimilarity#getTrainingPhrase2 <em>Training Phrase2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Training Phrase2</em>'.
	 * @see congaAnnotation.SemanticSimilarity#getTrainingPhrase2()
	 * @see #getSemanticSimilarity()
	 * @generated
	 */
	EReference getSemanticSimilarity_TrainingPhrase2();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.SemanticSimilarity#getSimilarity <em>Similarity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Similarity</em>'.
	 * @see congaAnnotation.SemanticSimilarity#getSimilarity()
	 * @see #getSemanticSimilarity()
	 * @generated
	 */
	EAttribute getSemanticSimilarity_Similarity();

	/**
	 * Returns the meta object for class '{@link congaAnnotation.AvgSim <em>Avg Sim</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Avg Sim</em>'.
	 * @see congaAnnotation.AvgSim
	 * @generated
	 */
	EClass getAvgSim();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.AvgSim#getTrainingPhrase <em>Training Phrase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Training Phrase</em>'.
	 * @see congaAnnotation.AvgSim#getTrainingPhrase()
	 * @see #getAvgSim()
	 * @generated
	 */
	EReference getAvgSim_TrainingPhrase();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.AvgSim#getAvg <em>Avg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Avg</em>'.
	 * @see congaAnnotation.AvgSim#getAvg()
	 * @see #getAvgSim()
	 * @generated
	 */
	EAttribute getAvgSim_Avg();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.AvgSim#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Min</em>'.
	 * @see congaAnnotation.AvgSim#getMin()
	 * @see #getAvgSim()
	 * @generated
	 */
	EReference getAvgSim_Min();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.AvgSim#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Max</em>'.
	 * @see congaAnnotation.AvgSim#getMax()
	 * @see #getAvgSim()
	 * @generated
	 */
	EReference getAvgSim_Max();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.AvgSim#getMinValue <em>Min Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see congaAnnotation.AvgSim#getMinValue()
	 * @see #getAvgSim()
	 * @generated
	 */
	EAttribute getAvgSim_MinValue();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.AvgSim#getMaxValue <em>Max Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see congaAnnotation.AvgSim#getMaxValue()
	 * @see #getAvgSim()
	 * @generated
	 */
	EAttribute getAvgSim_MaxValue();

	/**
	 * Returns the meta object for class '{@link congaAnnotation.IntentAvgSim <em>Intent Avg Sim</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intent Avg Sim</em>'.
	 * @see congaAnnotation.IntentAvgSim
	 * @generated
	 */
	EClass getIntentAvgSim();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentAvgSim#getTrainingPhrase <em>Training Phrase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Training Phrase</em>'.
	 * @see congaAnnotation.IntentAvgSim#getTrainingPhrase()
	 * @see #getIntentAvgSim()
	 * @generated
	 */
	EReference getIntentAvgSim_TrainingPhrase();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentAvgSim#getIntent <em>Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intent</em>'.
	 * @see congaAnnotation.IntentAvgSim#getIntent()
	 * @see #getIntentAvgSim()
	 * @generated
	 */
	EReference getIntentAvgSim_Intent();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.IntentAvgSim#getAvg <em>Avg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Avg</em>'.
	 * @see congaAnnotation.IntentAvgSim#getAvg()
	 * @see #getIntentAvgSim()
	 * @generated
	 */
	EAttribute getIntentAvgSim_Avg();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentAvgSim#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Min</em>'.
	 * @see congaAnnotation.IntentAvgSim#getMin()
	 * @see #getIntentAvgSim()
	 * @generated
	 */
	EReference getIntentAvgSim_Min();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentAvgSim#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Max</em>'.
	 * @see congaAnnotation.IntentAvgSim#getMax()
	 * @see #getIntentAvgSim()
	 * @generated
	 */
	EReference getIntentAvgSim_Max();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.IntentAvgSim#getMinValue <em>Min Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see congaAnnotation.IntentAvgSim#getMinValue()
	 * @see #getIntentAvgSim()
	 * @generated
	 */
	EAttribute getIntentAvgSim_MinValue();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.IntentAvgSim#getMaxValue <em>Max Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see congaAnnotation.IntentAvgSim#getMaxValue()
	 * @see #getIntentAvgSim()
	 * @generated
	 */
	EAttribute getIntentAvgSim_MaxValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CongaAnnotationFactory getCongaAnnotationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link congaAnnotation.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congaAnnotation.impl.AnnotationImpl
		 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Semantic Similarities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__SEMANTIC_SIMILARITIES = eINSTANCE.getAnnotation_SemanticSimilarities();

		/**
		 * The meta object literal for the '<em><b>Avg Sims</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__AVG_SIMS = eINSTANCE.getAnnotation_AvgSims();

		/**
		 * The meta object literal for the '<em><b>Intent Avg Sims</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__INTENT_AVG_SIMS = eINSTANCE.getAnnotation_IntentAvgSims();

		/**
		 * The meta object literal for the '{@link congaAnnotation.impl.SemanticSimilarityImpl <em>Semantic Similarity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congaAnnotation.impl.SemanticSimilarityImpl
		 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getSemanticSimilarity()
		 * @generated
		 */
		EClass SEMANTIC_SIMILARITY = eINSTANCE.getSemanticSimilarity();

		/**
		 * The meta object literal for the '<em><b>Training Phrase1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEMANTIC_SIMILARITY__TRAINING_PHRASE1 = eINSTANCE.getSemanticSimilarity_TrainingPhrase1();

		/**
		 * The meta object literal for the '<em><b>Training Phrase2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEMANTIC_SIMILARITY__TRAINING_PHRASE2 = eINSTANCE.getSemanticSimilarity_TrainingPhrase2();

		/**
		 * The meta object literal for the '<em><b>Similarity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEMANTIC_SIMILARITY__SIMILARITY = eINSTANCE.getSemanticSimilarity_Similarity();

		/**
		 * The meta object literal for the '{@link congaAnnotation.impl.AvgSimImpl <em>Avg Sim</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congaAnnotation.impl.AvgSimImpl
		 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getAvgSim()
		 * @generated
		 */
		EClass AVG_SIM = eINSTANCE.getAvgSim();

		/**
		 * The meta object literal for the '<em><b>Training Phrase</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AVG_SIM__TRAINING_PHRASE = eINSTANCE.getAvgSim_TrainingPhrase();

		/**
		 * The meta object literal for the '<em><b>Avg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AVG_SIM__AVG = eINSTANCE.getAvgSim_Avg();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AVG_SIM__MIN = eINSTANCE.getAvgSim_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AVG_SIM__MAX = eINSTANCE.getAvgSim_Max();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AVG_SIM__MIN_VALUE = eINSTANCE.getAvgSim_MinValue();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AVG_SIM__MAX_VALUE = eINSTANCE.getAvgSim_MaxValue();

		/**
		 * The meta object literal for the '{@link congaAnnotation.impl.IntentAvgSimImpl <em>Intent Avg Sim</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congaAnnotation.impl.IntentAvgSimImpl
		 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getIntentAvgSim()
		 * @generated
		 */
		EClass INTENT_AVG_SIM = eINSTANCE.getIntentAvgSim();

		/**
		 * The meta object literal for the '<em><b>Training Phrase</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_AVG_SIM__TRAINING_PHRASE = eINSTANCE.getIntentAvgSim_TrainingPhrase();

		/**
		 * The meta object literal for the '<em><b>Intent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_AVG_SIM__INTENT = eINSTANCE.getIntentAvgSim_Intent();

		/**
		 * The meta object literal for the '<em><b>Avg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENT_AVG_SIM__AVG = eINSTANCE.getIntentAvgSim_Avg();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_AVG_SIM__MIN = eINSTANCE.getIntentAvgSim_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_AVG_SIM__MAX = eINSTANCE.getIntentAvgSim_Max();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENT_AVG_SIM__MIN_VALUE = eINSTANCE.getIntentAvgSim_MinValue();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENT_AVG_SIM__MAX_VALUE = eINSTANCE.getIntentAvgSim_MaxValue();

	}

} //CongaAnnotationPackage

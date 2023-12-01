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
	 * The feature id for the '<em><b>Tp Avg Sims</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__TP_AVG_SIMS = 1;

	/**
	 * The feature id for the '<em><b>Tp Intent Avg Sims</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__TP_INTENT_AVG_SIMS = 2;

	/**
	 * The feature id for the '<em><b>Intent Intent Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__INTENT_INTENT_VALUES = 3;

	/**
	 * The feature id for the '<em><b>Intent Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__INTENT_VALUES = 4;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = 5;

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
	 * The meta object id for the '{@link congaAnnotation.impl.TPAvgImpl <em>TP Avg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congaAnnotation.impl.TPAvgImpl
	 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getTPAvg()
	 * @generated
	 */
	int TP_AVG = 2;

	/**
	 * The feature id for the '<em><b>Training Phrase</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_AVG__TRAINING_PHRASE = 0;

	/**
	 * The feature id for the '<em><b>Avg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_AVG__AVG = 1;

	/**
	 * The feature id for the '<em><b>Min</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_AVG__MIN = 2;

	/**
	 * The feature id for the '<em><b>Max</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_AVG__MAX = 3;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_AVG__MIN_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_AVG__MAX_VALUE = 5;

	/**
	 * The number of structural features of the '<em>TP Avg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_AVG_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>TP Avg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_AVG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congaAnnotation.impl.TPIntentAvgSimImpl <em>TP Intent Avg Sim</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congaAnnotation.impl.TPIntentAvgSimImpl
	 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getTPIntentAvgSim()
	 * @generated
	 */
	int TP_INTENT_AVG_SIM = 3;

	/**
	 * The feature id for the '<em><b>Training Phrase</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_INTENT_AVG_SIM__TRAINING_PHRASE = 0;

	/**
	 * The feature id for the '<em><b>Intent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_INTENT_AVG_SIM__INTENT = 1;

	/**
	 * The feature id for the '<em><b>Avg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_INTENT_AVG_SIM__AVG = 2;

	/**
	 * The feature id for the '<em><b>Min</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_INTENT_AVG_SIM__MIN = 3;

	/**
	 * The feature id for the '<em><b>Max</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_INTENT_AVG_SIM__MAX = 4;

	/**
	 * The feature id for the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_INTENT_AVG_SIM__MIN_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_INTENT_AVG_SIM__MAX_VALUE = 6;

	/**
	 * The number of structural features of the '<em>TP Intent Avg Sim</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_INTENT_AVG_SIM_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>TP Intent Avg Sim</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TP_INTENT_AVG_SIM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congaAnnotation.impl.IntentValueImpl <em>Intent Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congaAnnotation.impl.IntentValueImpl
	 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getIntentValue()
	 * @generated
	 */
	int INTENT_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Intent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_VALUE__INTENT = 0;

	/**
	 * The feature id for the '<em><b>Min1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_VALUE__MIN1 = 1;

	/**
	 * The feature id for the '<em><b>Max1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_VALUE__MAX1 = 2;

	/**
	 * The feature id for the '<em><b>Min1 Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_VALUE__MIN1_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Max1 Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_VALUE__MAX1_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Min2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_VALUE__MIN2 = 5;

	/**
	 * The feature id for the '<em><b>Max2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_VALUE__MAX2 = 6;

	/**
	 * The feature id for the '<em><b>Min2 Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_VALUE__MIN2_VALUE = 7;

	/**
	 * The feature id for the '<em><b>Max2 Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_VALUE__MAX2_VALUE = 8;

	/**
	 * The number of structural features of the '<em>Intent Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_VALUE_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Intent Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congaAnnotation.impl.IntentIntentValueImpl <em>Intent Intent Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congaAnnotation.impl.IntentIntentValueImpl
	 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getIntentIntentValue()
	 * @generated
	 */
	int INTENT_INTENT_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Intent1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_INTENT_VALUE__INTENT1 = 0;

	/**
	 * The feature id for the '<em><b>Intent2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_INTENT_VALUE__INTENT2 = 1;

	/**
	 * The feature id for the '<em><b>Min1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_INTENT_VALUE__MIN1 = 2;

	/**
	 * The feature id for the '<em><b>Max1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_INTENT_VALUE__MAX1 = 3;

	/**
	 * The feature id for the '<em><b>Min1 Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_INTENT_VALUE__MIN1_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Max1 Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_INTENT_VALUE__MAX1_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Min2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_INTENT_VALUE__MIN2 = 6;

	/**
	 * The feature id for the '<em><b>Max2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_INTENT_VALUE__MAX2 = 7;

	/**
	 * The feature id for the '<em><b>Min2 Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_INTENT_VALUE__MIN2_VALUE = 8;

	/**
	 * The feature id for the '<em><b>Max2 Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_INTENT_VALUE__MAX2_VALUE = 9;

	/**
	 * The number of structural features of the '<em>Intent Intent Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_INTENT_VALUE_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Intent Intent Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_INTENT_VALUE_OPERATION_COUNT = 0;


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
	 * Returns the meta object for the containment reference list '{@link congaAnnotation.Annotation#getTpAvgSims <em>Tp Avg Sims</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tp Avg Sims</em>'.
	 * @see congaAnnotation.Annotation#getTpAvgSims()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_TpAvgSims();

	/**
	 * Returns the meta object for the containment reference list '{@link congaAnnotation.Annotation#getTpIntentAvgSims <em>Tp Intent Avg Sims</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tp Intent Avg Sims</em>'.
	 * @see congaAnnotation.Annotation#getTpIntentAvgSims()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_TpIntentAvgSims();

	/**
	 * Returns the meta object for the containment reference list '{@link congaAnnotation.Annotation#getIntentIntentValues <em>Intent Intent Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intent Intent Values</em>'.
	 * @see congaAnnotation.Annotation#getIntentIntentValues()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_IntentIntentValues();

	/**
	 * Returns the meta object for the containment reference list '{@link congaAnnotation.Annotation#getIntentValues <em>Intent Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intent Values</em>'.
	 * @see congaAnnotation.Annotation#getIntentValues()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_IntentValues();

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
	 * Returns the meta object for class '{@link congaAnnotation.TPAvg <em>TP Avg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TP Avg</em>'.
	 * @see congaAnnotation.TPAvg
	 * @generated
	 */
	EClass getTPAvg();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.TPAvg#getTrainingPhrase <em>Training Phrase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Training Phrase</em>'.
	 * @see congaAnnotation.TPAvg#getTrainingPhrase()
	 * @see #getTPAvg()
	 * @generated
	 */
	EReference getTPAvg_TrainingPhrase();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.TPAvg#getAvg <em>Avg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Avg</em>'.
	 * @see congaAnnotation.TPAvg#getAvg()
	 * @see #getTPAvg()
	 * @generated
	 */
	EAttribute getTPAvg_Avg();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.TPAvg#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Min</em>'.
	 * @see congaAnnotation.TPAvg#getMin()
	 * @see #getTPAvg()
	 * @generated
	 */
	EReference getTPAvg_Min();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.TPAvg#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Max</em>'.
	 * @see congaAnnotation.TPAvg#getMax()
	 * @see #getTPAvg()
	 * @generated
	 */
	EReference getTPAvg_Max();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.TPAvg#getMinValue <em>Min Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see congaAnnotation.TPAvg#getMinValue()
	 * @see #getTPAvg()
	 * @generated
	 */
	EAttribute getTPAvg_MinValue();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.TPAvg#getMaxValue <em>Max Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see congaAnnotation.TPAvg#getMaxValue()
	 * @see #getTPAvg()
	 * @generated
	 */
	EAttribute getTPAvg_MaxValue();

	/**
	 * Returns the meta object for class '{@link congaAnnotation.TPIntentAvgSim <em>TP Intent Avg Sim</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TP Intent Avg Sim</em>'.
	 * @see congaAnnotation.TPIntentAvgSim
	 * @generated
	 */
	EClass getTPIntentAvgSim();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.TPIntentAvgSim#getTrainingPhrase <em>Training Phrase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Training Phrase</em>'.
	 * @see congaAnnotation.TPIntentAvgSim#getTrainingPhrase()
	 * @see #getTPIntentAvgSim()
	 * @generated
	 */
	EReference getTPIntentAvgSim_TrainingPhrase();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.TPIntentAvgSim#getIntent <em>Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intent</em>'.
	 * @see congaAnnotation.TPIntentAvgSim#getIntent()
	 * @see #getTPIntentAvgSim()
	 * @generated
	 */
	EReference getTPIntentAvgSim_Intent();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.TPIntentAvgSim#getAvg <em>Avg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Avg</em>'.
	 * @see congaAnnotation.TPIntentAvgSim#getAvg()
	 * @see #getTPIntentAvgSim()
	 * @generated
	 */
	EAttribute getTPIntentAvgSim_Avg();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.TPIntentAvgSim#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Min</em>'.
	 * @see congaAnnotation.TPIntentAvgSim#getMin()
	 * @see #getTPIntentAvgSim()
	 * @generated
	 */
	EReference getTPIntentAvgSim_Min();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.TPIntentAvgSim#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Max</em>'.
	 * @see congaAnnotation.TPIntentAvgSim#getMax()
	 * @see #getTPIntentAvgSim()
	 * @generated
	 */
	EReference getTPIntentAvgSim_Max();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.TPIntentAvgSim#getMinValue <em>Min Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Value</em>'.
	 * @see congaAnnotation.TPIntentAvgSim#getMinValue()
	 * @see #getTPIntentAvgSim()
	 * @generated
	 */
	EAttribute getTPIntentAvgSim_MinValue();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.TPIntentAvgSim#getMaxValue <em>Max Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Value</em>'.
	 * @see congaAnnotation.TPIntentAvgSim#getMaxValue()
	 * @see #getTPIntentAvgSim()
	 * @generated
	 */
	EAttribute getTPIntentAvgSim_MaxValue();

	/**
	 * Returns the meta object for class '{@link congaAnnotation.IntentValue <em>Intent Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intent Value</em>'.
	 * @see congaAnnotation.IntentValue
	 * @generated
	 */
	EClass getIntentValue();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentValue#getIntent <em>Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intent</em>'.
	 * @see congaAnnotation.IntentValue#getIntent()
	 * @see #getIntentValue()
	 * @generated
	 */
	EReference getIntentValue_Intent();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentValue#getMin1 <em>Min1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Min1</em>'.
	 * @see congaAnnotation.IntentValue#getMin1()
	 * @see #getIntentValue()
	 * @generated
	 */
	EReference getIntentValue_Min1();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentValue#getMax1 <em>Max1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Max1</em>'.
	 * @see congaAnnotation.IntentValue#getMax1()
	 * @see #getIntentValue()
	 * @generated
	 */
	EReference getIntentValue_Max1();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.IntentValue#getMin1Value <em>Min1 Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min1 Value</em>'.
	 * @see congaAnnotation.IntentValue#getMin1Value()
	 * @see #getIntentValue()
	 * @generated
	 */
	EAttribute getIntentValue_Min1Value();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.IntentValue#getMax1Value <em>Max1 Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max1 Value</em>'.
	 * @see congaAnnotation.IntentValue#getMax1Value()
	 * @see #getIntentValue()
	 * @generated
	 */
	EAttribute getIntentValue_Max1Value();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentValue#getMin2 <em>Min2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Min2</em>'.
	 * @see congaAnnotation.IntentValue#getMin2()
	 * @see #getIntentValue()
	 * @generated
	 */
	EReference getIntentValue_Min2();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentValue#getMax2 <em>Max2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Max2</em>'.
	 * @see congaAnnotation.IntentValue#getMax2()
	 * @see #getIntentValue()
	 * @generated
	 */
	EReference getIntentValue_Max2();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.IntentValue#getMin2Value <em>Min2 Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min2 Value</em>'.
	 * @see congaAnnotation.IntentValue#getMin2Value()
	 * @see #getIntentValue()
	 * @generated
	 */
	EAttribute getIntentValue_Min2Value();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.IntentValue#getMax2Value <em>Max2 Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max2 Value</em>'.
	 * @see congaAnnotation.IntentValue#getMax2Value()
	 * @see #getIntentValue()
	 * @generated
	 */
	EAttribute getIntentValue_Max2Value();

	/**
	 * Returns the meta object for class '{@link congaAnnotation.IntentIntentValue <em>Intent Intent Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intent Intent Value</em>'.
	 * @see congaAnnotation.IntentIntentValue
	 * @generated
	 */
	EClass getIntentIntentValue();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentIntentValue#getIntent1 <em>Intent1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intent1</em>'.
	 * @see congaAnnotation.IntentIntentValue#getIntent1()
	 * @see #getIntentIntentValue()
	 * @generated
	 */
	EReference getIntentIntentValue_Intent1();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentIntentValue#getIntent2 <em>Intent2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intent2</em>'.
	 * @see congaAnnotation.IntentIntentValue#getIntent2()
	 * @see #getIntentIntentValue()
	 * @generated
	 */
	EReference getIntentIntentValue_Intent2();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentIntentValue#getMin1 <em>Min1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Min1</em>'.
	 * @see congaAnnotation.IntentIntentValue#getMin1()
	 * @see #getIntentIntentValue()
	 * @generated
	 */
	EReference getIntentIntentValue_Min1();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentIntentValue#getMax1 <em>Max1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Max1</em>'.
	 * @see congaAnnotation.IntentIntentValue#getMax1()
	 * @see #getIntentIntentValue()
	 * @generated
	 */
	EReference getIntentIntentValue_Max1();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.IntentIntentValue#getMin1Value <em>Min1 Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min1 Value</em>'.
	 * @see congaAnnotation.IntentIntentValue#getMin1Value()
	 * @see #getIntentIntentValue()
	 * @generated
	 */
	EAttribute getIntentIntentValue_Min1Value();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.IntentIntentValue#getMax1Value <em>Max1 Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max1 Value</em>'.
	 * @see congaAnnotation.IntentIntentValue#getMax1Value()
	 * @see #getIntentIntentValue()
	 * @generated
	 */
	EAttribute getIntentIntentValue_Max1Value();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentIntentValue#getMin2 <em>Min2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Min2</em>'.
	 * @see congaAnnotation.IntentIntentValue#getMin2()
	 * @see #getIntentIntentValue()
	 * @generated
	 */
	EReference getIntentIntentValue_Min2();

	/**
	 * Returns the meta object for the reference '{@link congaAnnotation.IntentIntentValue#getMax2 <em>Max2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Max2</em>'.
	 * @see congaAnnotation.IntentIntentValue#getMax2()
	 * @see #getIntentIntentValue()
	 * @generated
	 */
	EReference getIntentIntentValue_Max2();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.IntentIntentValue#getMin2Value <em>Min2 Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min2 Value</em>'.
	 * @see congaAnnotation.IntentIntentValue#getMin2Value()
	 * @see #getIntentIntentValue()
	 * @generated
	 */
	EAttribute getIntentIntentValue_Min2Value();

	/**
	 * Returns the meta object for the attribute '{@link congaAnnotation.IntentIntentValue#getMax2Value <em>Max2 Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max2 Value</em>'.
	 * @see congaAnnotation.IntentIntentValue#getMax2Value()
	 * @see #getIntentIntentValue()
	 * @generated
	 */
	EAttribute getIntentIntentValue_Max2Value();

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
		 * The meta object literal for the '<em><b>Tp Avg Sims</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__TP_AVG_SIMS = eINSTANCE.getAnnotation_TpAvgSims();

		/**
		 * The meta object literal for the '<em><b>Tp Intent Avg Sims</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__TP_INTENT_AVG_SIMS = eINSTANCE.getAnnotation_TpIntentAvgSims();

		/**
		 * The meta object literal for the '<em><b>Intent Intent Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__INTENT_INTENT_VALUES = eINSTANCE.getAnnotation_IntentIntentValues();

		/**
		 * The meta object literal for the '<em><b>Intent Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__INTENT_VALUES = eINSTANCE.getAnnotation_IntentValues();

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
		 * The meta object literal for the '{@link congaAnnotation.impl.TPAvgImpl <em>TP Avg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congaAnnotation.impl.TPAvgImpl
		 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getTPAvg()
		 * @generated
		 */
		EClass TP_AVG = eINSTANCE.getTPAvg();

		/**
		 * The meta object literal for the '<em><b>Training Phrase</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TP_AVG__TRAINING_PHRASE = eINSTANCE.getTPAvg_TrainingPhrase();

		/**
		 * The meta object literal for the '<em><b>Avg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TP_AVG__AVG = eINSTANCE.getTPAvg_Avg();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TP_AVG__MIN = eINSTANCE.getTPAvg_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TP_AVG__MAX = eINSTANCE.getTPAvg_Max();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TP_AVG__MIN_VALUE = eINSTANCE.getTPAvg_MinValue();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TP_AVG__MAX_VALUE = eINSTANCE.getTPAvg_MaxValue();

		/**
		 * The meta object literal for the '{@link congaAnnotation.impl.TPIntentAvgSimImpl <em>TP Intent Avg Sim</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congaAnnotation.impl.TPIntentAvgSimImpl
		 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getTPIntentAvgSim()
		 * @generated
		 */
		EClass TP_INTENT_AVG_SIM = eINSTANCE.getTPIntentAvgSim();

		/**
		 * The meta object literal for the '<em><b>Training Phrase</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TP_INTENT_AVG_SIM__TRAINING_PHRASE = eINSTANCE.getTPIntentAvgSim_TrainingPhrase();

		/**
		 * The meta object literal for the '<em><b>Intent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TP_INTENT_AVG_SIM__INTENT = eINSTANCE.getTPIntentAvgSim_Intent();

		/**
		 * The meta object literal for the '<em><b>Avg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TP_INTENT_AVG_SIM__AVG = eINSTANCE.getTPIntentAvgSim_Avg();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TP_INTENT_AVG_SIM__MIN = eINSTANCE.getTPIntentAvgSim_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TP_INTENT_AVG_SIM__MAX = eINSTANCE.getTPIntentAvgSim_Max();

		/**
		 * The meta object literal for the '<em><b>Min Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TP_INTENT_AVG_SIM__MIN_VALUE = eINSTANCE.getTPIntentAvgSim_MinValue();

		/**
		 * The meta object literal for the '<em><b>Max Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TP_INTENT_AVG_SIM__MAX_VALUE = eINSTANCE.getTPIntentAvgSim_MaxValue();

		/**
		 * The meta object literal for the '{@link congaAnnotation.impl.IntentValueImpl <em>Intent Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congaAnnotation.impl.IntentValueImpl
		 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getIntentValue()
		 * @generated
		 */
		EClass INTENT_VALUE = eINSTANCE.getIntentValue();

		/**
		 * The meta object literal for the '<em><b>Intent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_VALUE__INTENT = eINSTANCE.getIntentValue_Intent();

		/**
		 * The meta object literal for the '<em><b>Min1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_VALUE__MIN1 = eINSTANCE.getIntentValue_Min1();

		/**
		 * The meta object literal for the '<em><b>Max1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_VALUE__MAX1 = eINSTANCE.getIntentValue_Max1();

		/**
		 * The meta object literal for the '<em><b>Min1 Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENT_VALUE__MIN1_VALUE = eINSTANCE.getIntentValue_Min1Value();

		/**
		 * The meta object literal for the '<em><b>Max1 Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENT_VALUE__MAX1_VALUE = eINSTANCE.getIntentValue_Max1Value();

		/**
		 * The meta object literal for the '<em><b>Min2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_VALUE__MIN2 = eINSTANCE.getIntentValue_Min2();

		/**
		 * The meta object literal for the '<em><b>Max2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_VALUE__MAX2 = eINSTANCE.getIntentValue_Max2();

		/**
		 * The meta object literal for the '<em><b>Min2 Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENT_VALUE__MIN2_VALUE = eINSTANCE.getIntentValue_Min2Value();

		/**
		 * The meta object literal for the '<em><b>Max2 Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENT_VALUE__MAX2_VALUE = eINSTANCE.getIntentValue_Max2Value();

		/**
		 * The meta object literal for the '{@link congaAnnotation.impl.IntentIntentValueImpl <em>Intent Intent Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congaAnnotation.impl.IntentIntentValueImpl
		 * @see congaAnnotation.impl.CongaAnnotationPackageImpl#getIntentIntentValue()
		 * @generated
		 */
		EClass INTENT_INTENT_VALUE = eINSTANCE.getIntentIntentValue();

		/**
		 * The meta object literal for the '<em><b>Intent1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_INTENT_VALUE__INTENT1 = eINSTANCE.getIntentIntentValue_Intent1();

		/**
		 * The meta object literal for the '<em><b>Intent2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_INTENT_VALUE__INTENT2 = eINSTANCE.getIntentIntentValue_Intent2();

		/**
		 * The meta object literal for the '<em><b>Min1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_INTENT_VALUE__MIN1 = eINSTANCE.getIntentIntentValue_Min1();

		/**
		 * The meta object literal for the '<em><b>Max1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_INTENT_VALUE__MAX1 = eINSTANCE.getIntentIntentValue_Max1();

		/**
		 * The meta object literal for the '<em><b>Min1 Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENT_INTENT_VALUE__MIN1_VALUE = eINSTANCE.getIntentIntentValue_Min1Value();

		/**
		 * The meta object literal for the '<em><b>Max1 Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENT_INTENT_VALUE__MAX1_VALUE = eINSTANCE.getIntentIntentValue_Max1Value();

		/**
		 * The meta object literal for the '<em><b>Min2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_INTENT_VALUE__MIN2 = eINSTANCE.getIntentIntentValue_Min2();

		/**
		 * The meta object literal for the '<em><b>Max2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT_INTENT_VALUE__MAX2 = eINSTANCE.getIntentIntentValue_Max2();

		/**
		 * The meta object literal for the '<em><b>Min2 Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENT_INTENT_VALUE__MIN2_VALUE = eINSTANCE.getIntentIntentValue_Min2Value();

		/**
		 * The meta object literal for the '<em><b>Max2 Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENT_INTENT_VALUE__MAX2_VALUE = eINSTANCE.getIntentIntentValue_Max2Value();

	}

} //CongaAnnotationPackage

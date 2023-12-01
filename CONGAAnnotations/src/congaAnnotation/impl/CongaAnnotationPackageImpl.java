/**
 */
package congaAnnotation.impl;

import congaAnnotation.Annotation;
import congaAnnotation.CongaAnnotationFactory;
import congaAnnotation.CongaAnnotationPackage;
import congaAnnotation.IntentIntentValue;
import congaAnnotation.IntentValue;
import congaAnnotation.SemanticSimilarity;
import congaAnnotation.TPAvg;
import congaAnnotation.TPIntentAvgSim;

import generator.GeneratorPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CongaAnnotationPackageImpl extends EPackageImpl implements CongaAnnotationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass semanticSimilarityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tpAvgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tpIntentAvgSimEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intentValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intentIntentValueEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see congaAnnotation.CongaAnnotationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CongaAnnotationPackageImpl() {
		super(eNS_URI, CongaAnnotationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link CongaAnnotationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CongaAnnotationPackage init() {
		if (isInited) return (CongaAnnotationPackage)EPackage.Registry.INSTANCE.getEPackage(CongaAnnotationPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCongaAnnotationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CongaAnnotationPackageImpl theCongaAnnotationPackage = registeredCongaAnnotationPackage instanceof CongaAnnotationPackageImpl ? (CongaAnnotationPackageImpl)registeredCongaAnnotationPackage : new CongaAnnotationPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		GeneratorPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCongaAnnotationPackage.createPackageContents();

		// Initialize created meta-data
		theCongaAnnotationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCongaAnnotationPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CongaAnnotationPackage.eNS_URI, theCongaAnnotationPackage);
		return theCongaAnnotationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_SemanticSimilarities() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_TpAvgSims() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_TpIntentAvgSims() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_IntentIntentValues() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_IntentValues() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSemanticSimilarity() {
		return semanticSimilarityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSemanticSimilarity_TrainingPhrase1() {
		return (EReference)semanticSimilarityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSemanticSimilarity_TrainingPhrase2() {
		return (EReference)semanticSimilarityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSemanticSimilarity_Similarity() {
		return (EAttribute)semanticSimilarityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPAvg() {
		return tpAvgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPAvg_TrainingPhrase() {
		return (EReference)tpAvgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPAvg_Avg() {
		return (EAttribute)tpAvgEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPAvg_Min() {
		return (EReference)tpAvgEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPAvg_Max() {
		return (EReference)tpAvgEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPAvg_MinValue() {
		return (EAttribute)tpAvgEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPAvg_MaxValue() {
		return (EAttribute)tpAvgEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPIntentAvgSim() {
		return tpIntentAvgSimEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPIntentAvgSim_TrainingPhrase() {
		return (EReference)tpIntentAvgSimEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPIntentAvgSim_Intent() {
		return (EReference)tpIntentAvgSimEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPIntentAvgSim_Avg() {
		return (EAttribute)tpIntentAvgSimEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPIntentAvgSim_Min() {
		return (EReference)tpIntentAvgSimEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPIntentAvgSim_Max() {
		return (EReference)tpIntentAvgSimEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPIntentAvgSim_MinValue() {
		return (EAttribute)tpIntentAvgSimEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPIntentAvgSim_MaxValue() {
		return (EAttribute)tpIntentAvgSimEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntentValue() {
		return intentValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentValue_Intent() {
		return (EReference)intentValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentValue_Min1() {
		return (EReference)intentValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentValue_Max1() {
		return (EReference)intentValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentValue_Min1Value() {
		return (EAttribute)intentValueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentValue_Max1Value() {
		return (EAttribute)intentValueEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentValue_Min2() {
		return (EReference)intentValueEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentValue_Max2() {
		return (EReference)intentValueEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentValue_Min2Value() {
		return (EAttribute)intentValueEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentValue_Max2Value() {
		return (EAttribute)intentValueEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntentIntentValue() {
		return intentIntentValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentIntentValue_Intent1() {
		return (EReference)intentIntentValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentIntentValue_Intent2() {
		return (EReference)intentIntentValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentIntentValue_Min1() {
		return (EReference)intentIntentValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentIntentValue_Max1() {
		return (EReference)intentIntentValueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentIntentValue_Min1Value() {
		return (EAttribute)intentIntentValueEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentIntentValue_Max1Value() {
		return (EAttribute)intentIntentValueEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentIntentValue_Min2() {
		return (EReference)intentIntentValueEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentIntentValue_Max2() {
		return (EReference)intentIntentValueEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentIntentValue_Min2Value() {
		return (EAttribute)intentIntentValueEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentIntentValue_Max2Value() {
		return (EAttribute)intentIntentValueEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CongaAnnotationFactory getCongaAnnotationFactory() {
		return (CongaAnnotationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		annotationEClass = createEClass(ANNOTATION);
		createEReference(annotationEClass, ANNOTATION__SEMANTIC_SIMILARITIES);
		createEReference(annotationEClass, ANNOTATION__TP_AVG_SIMS);
		createEReference(annotationEClass, ANNOTATION__TP_INTENT_AVG_SIMS);
		createEReference(annotationEClass, ANNOTATION__INTENT_INTENT_VALUES);
		createEReference(annotationEClass, ANNOTATION__INTENT_VALUES);

		semanticSimilarityEClass = createEClass(SEMANTIC_SIMILARITY);
		createEReference(semanticSimilarityEClass, SEMANTIC_SIMILARITY__TRAINING_PHRASE1);
		createEReference(semanticSimilarityEClass, SEMANTIC_SIMILARITY__TRAINING_PHRASE2);
		createEAttribute(semanticSimilarityEClass, SEMANTIC_SIMILARITY__SIMILARITY);

		tpAvgEClass = createEClass(TP_AVG);
		createEReference(tpAvgEClass, TP_AVG__TRAINING_PHRASE);
		createEAttribute(tpAvgEClass, TP_AVG__AVG);
		createEReference(tpAvgEClass, TP_AVG__MIN);
		createEReference(tpAvgEClass, TP_AVG__MAX);
		createEAttribute(tpAvgEClass, TP_AVG__MIN_VALUE);
		createEAttribute(tpAvgEClass, TP_AVG__MAX_VALUE);

		tpIntentAvgSimEClass = createEClass(TP_INTENT_AVG_SIM);
		createEReference(tpIntentAvgSimEClass, TP_INTENT_AVG_SIM__TRAINING_PHRASE);
		createEReference(tpIntentAvgSimEClass, TP_INTENT_AVG_SIM__INTENT);
		createEAttribute(tpIntentAvgSimEClass, TP_INTENT_AVG_SIM__AVG);
		createEReference(tpIntentAvgSimEClass, TP_INTENT_AVG_SIM__MIN);
		createEReference(tpIntentAvgSimEClass, TP_INTENT_AVG_SIM__MAX);
		createEAttribute(tpIntentAvgSimEClass, TP_INTENT_AVG_SIM__MIN_VALUE);
		createEAttribute(tpIntentAvgSimEClass, TP_INTENT_AVG_SIM__MAX_VALUE);

		intentValueEClass = createEClass(INTENT_VALUE);
		createEReference(intentValueEClass, INTENT_VALUE__INTENT);
		createEReference(intentValueEClass, INTENT_VALUE__MIN1);
		createEReference(intentValueEClass, INTENT_VALUE__MAX1);
		createEAttribute(intentValueEClass, INTENT_VALUE__MIN1_VALUE);
		createEAttribute(intentValueEClass, INTENT_VALUE__MAX1_VALUE);
		createEReference(intentValueEClass, INTENT_VALUE__MIN2);
		createEReference(intentValueEClass, INTENT_VALUE__MAX2);
		createEAttribute(intentValueEClass, INTENT_VALUE__MIN2_VALUE);
		createEAttribute(intentValueEClass, INTENT_VALUE__MAX2_VALUE);

		intentIntentValueEClass = createEClass(INTENT_INTENT_VALUE);
		createEReference(intentIntentValueEClass, INTENT_INTENT_VALUE__INTENT1);
		createEReference(intentIntentValueEClass, INTENT_INTENT_VALUE__INTENT2);
		createEReference(intentIntentValueEClass, INTENT_INTENT_VALUE__MIN1);
		createEReference(intentIntentValueEClass, INTENT_INTENT_VALUE__MAX1);
		createEAttribute(intentIntentValueEClass, INTENT_INTENT_VALUE__MIN1_VALUE);
		createEAttribute(intentIntentValueEClass, INTENT_INTENT_VALUE__MAX1_VALUE);
		createEReference(intentIntentValueEClass, INTENT_INTENT_VALUE__MIN2);
		createEReference(intentIntentValueEClass, INTENT_INTENT_VALUE__MAX2);
		createEAttribute(intentIntentValueEClass, INTENT_INTENT_VALUE__MIN2_VALUE);
		createEAttribute(intentIntentValueEClass, INTENT_INTENT_VALUE__MAX2_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		GeneratorPackage theGeneratorPackage = (GeneratorPackage)EPackage.Registry.INSTANCE.getEPackage(GeneratorPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(annotationEClass, Annotation.class, "Annotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotation_SemanticSimilarities(), this.getSemanticSimilarity(), null, "semanticSimilarities", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_TpAvgSims(), this.getTPAvg(), null, "tpAvgSims", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_TpIntentAvgSims(), this.getTPIntentAvgSim(), null, "tpIntentAvgSims", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_IntentIntentValues(), this.getIntentIntentValue(), null, "intentIntentValues", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_IntentValues(), this.getIntentValue(), null, "intentValues", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(semanticSimilarityEClass, SemanticSimilarity.class, "SemanticSimilarity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSemanticSimilarity_TrainingPhrase1(), theGeneratorPackage.getTrainingPhrase(), null, "trainingPhrase1", null, 1, 1, SemanticSimilarity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSemanticSimilarity_TrainingPhrase2(), theGeneratorPackage.getTrainingPhrase(), null, "trainingPhrase2", null, 1, 1, SemanticSimilarity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticSimilarity_Similarity(), ecorePackage.getEFloat(), "similarity", null, 1, 1, SemanticSimilarity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tpAvgEClass, TPAvg.class, "TPAvg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTPAvg_TrainingPhrase(), theGeneratorPackage.getTrainingPhrase(), null, "trainingPhrase", null, 1, 1, TPAvg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPAvg_Avg(), ecorePackage.getEFloat(), "avg", null, 1, 1, TPAvg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTPAvg_Min(), theGeneratorPackage.getTrainingPhrase(), null, "min", null, 1, 1, TPAvg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTPAvg_Max(), theGeneratorPackage.getTrainingPhrase(), null, "max", null, 1, 1, TPAvg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPAvg_MinValue(), ecorePackage.getEFloat(), "minValue", null, 1, 1, TPAvg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPAvg_MaxValue(), ecorePackage.getEFloat(), "maxValue", null, 1, 1, TPAvg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tpIntentAvgSimEClass, TPIntentAvgSim.class, "TPIntentAvgSim", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTPIntentAvgSim_TrainingPhrase(), theGeneratorPackage.getTrainingPhrase(), null, "trainingPhrase", null, 1, 1, TPIntentAvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTPIntentAvgSim_Intent(), theGeneratorPackage.getIntent(), null, "intent", null, 1, 1, TPIntentAvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPIntentAvgSim_Avg(), ecorePackage.getEFloat(), "avg", null, 1, 1, TPIntentAvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTPIntentAvgSim_Min(), theGeneratorPackage.getTrainingPhrase(), null, "min", null, 1, 1, TPIntentAvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTPIntentAvgSim_Max(), theGeneratorPackage.getTrainingPhrase(), null, "max", null, 1, 1, TPIntentAvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPIntentAvgSim_MinValue(), ecorePackage.getEFloat(), "minValue", null, 1, 1, TPIntentAvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPIntentAvgSim_MaxValue(), ecorePackage.getEFloat(), "maxValue", null, 1, 1, TPIntentAvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intentValueEClass, IntentValue.class, "IntentValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntentValue_Intent(), theGeneratorPackage.getIntent(), null, "intent", null, 1, 1, IntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentValue_Min1(), theGeneratorPackage.getTrainingPhrase(), null, "min1", null, 1, 1, IntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentValue_Max1(), theGeneratorPackage.getTrainingPhrase(), null, "max1", null, 1, 1, IntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentValue_Min1Value(), ecorePackage.getEFloat(), "min1Value", null, 1, 1, IntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentValue_Max1Value(), ecorePackage.getEFloat(), "max1Value", null, 1, 1, IntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentValue_Min2(), theGeneratorPackage.getTrainingPhrase(), null, "min2", null, 1, 1, IntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentValue_Max2(), theGeneratorPackage.getTrainingPhrase(), null, "max2", null, 1, 1, IntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentValue_Min2Value(), ecorePackage.getEFloat(), "min2Value", null, 1, 1, IntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentValue_Max2Value(), ecorePackage.getEFloat(), "max2Value", null, 1, 1, IntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intentIntentValueEClass, IntentIntentValue.class, "IntentIntentValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntentIntentValue_Intent1(), theGeneratorPackage.getIntent(), null, "intent1", null, 1, 1, IntentIntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentIntentValue_Intent2(), theGeneratorPackage.getIntent(), null, "intent2", null, 1, 1, IntentIntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentIntentValue_Min1(), theGeneratorPackage.getTrainingPhrase(), null, "min1", null, 1, 1, IntentIntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentIntentValue_Max1(), theGeneratorPackage.getTrainingPhrase(), null, "max1", null, 1, 1, IntentIntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentIntentValue_Min1Value(), ecorePackage.getEFloat(), "min1Value", null, 1, 1, IntentIntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentIntentValue_Max1Value(), ecorePackage.getEFloat(), "max1Value", null, 1, 1, IntentIntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentIntentValue_Min2(), theGeneratorPackage.getTrainingPhrase(), null, "min2", null, 1, 1, IntentIntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentIntentValue_Max2(), theGeneratorPackage.getTrainingPhrase(), null, "max2", null, 1, 1, IntentIntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentIntentValue_Min2Value(), ecorePackage.getEFloat(), "min2Value", null, 1, 1, IntentIntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentIntentValue_Max2Value(), ecorePackage.getEFloat(), "max2Value", null, 1, 1, IntentIntentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CongaAnnotationPackageImpl

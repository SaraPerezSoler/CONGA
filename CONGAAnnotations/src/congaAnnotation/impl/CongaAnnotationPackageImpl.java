/**
 */
package congaAnnotation.impl;

import congaAnnotation.Annotation;
import congaAnnotation.AvgSim;
import congaAnnotation.CongaAnnotationFactory;
import congaAnnotation.CongaAnnotationPackage;
import congaAnnotation.IntentAvgSim;
import congaAnnotation.SemanticSimilarity;

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
	private EClass avgSimEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intentAvgSimEClass = null;

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
	public EReference getAnnotation_AvgSims() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotation_IntentAvgSims() {
		return (EReference)annotationEClass.getEStructuralFeatures().get(2);
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
	public EClass getAvgSim() {
		return avgSimEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAvgSim_TrainingPhrase() {
		return (EReference)avgSimEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAvgSim_Avg() {
		return (EAttribute)avgSimEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAvgSim_Min() {
		return (EReference)avgSimEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAvgSim_Max() {
		return (EReference)avgSimEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAvgSim_MinValue() {
		return (EAttribute)avgSimEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAvgSim_MaxValue() {
		return (EAttribute)avgSimEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntentAvgSim() {
		return intentAvgSimEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentAvgSim_TrainingPhrase() {
		return (EReference)intentAvgSimEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentAvgSim_Intent() {
		return (EReference)intentAvgSimEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentAvgSim_Avg() {
		return (EAttribute)intentAvgSimEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentAvgSim_Min() {
		return (EReference)intentAvgSimEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentAvgSim_Max() {
		return (EReference)intentAvgSimEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentAvgSim_MinValue() {
		return (EAttribute)intentAvgSimEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentAvgSim_MaxValue() {
		return (EAttribute)intentAvgSimEClass.getEStructuralFeatures().get(6);
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
		createEReference(annotationEClass, ANNOTATION__AVG_SIMS);
		createEReference(annotationEClass, ANNOTATION__INTENT_AVG_SIMS);

		semanticSimilarityEClass = createEClass(SEMANTIC_SIMILARITY);
		createEReference(semanticSimilarityEClass, SEMANTIC_SIMILARITY__TRAINING_PHRASE1);
		createEReference(semanticSimilarityEClass, SEMANTIC_SIMILARITY__TRAINING_PHRASE2);
		createEAttribute(semanticSimilarityEClass, SEMANTIC_SIMILARITY__SIMILARITY);

		avgSimEClass = createEClass(AVG_SIM);
		createEReference(avgSimEClass, AVG_SIM__TRAINING_PHRASE);
		createEAttribute(avgSimEClass, AVG_SIM__AVG);
		createEReference(avgSimEClass, AVG_SIM__MIN);
		createEReference(avgSimEClass, AVG_SIM__MAX);
		createEAttribute(avgSimEClass, AVG_SIM__MIN_VALUE);
		createEAttribute(avgSimEClass, AVG_SIM__MAX_VALUE);

		intentAvgSimEClass = createEClass(INTENT_AVG_SIM);
		createEReference(intentAvgSimEClass, INTENT_AVG_SIM__TRAINING_PHRASE);
		createEReference(intentAvgSimEClass, INTENT_AVG_SIM__INTENT);
		createEAttribute(intentAvgSimEClass, INTENT_AVG_SIM__AVG);
		createEReference(intentAvgSimEClass, INTENT_AVG_SIM__MIN);
		createEReference(intentAvgSimEClass, INTENT_AVG_SIM__MAX);
		createEAttribute(intentAvgSimEClass, INTENT_AVG_SIM__MIN_VALUE);
		createEAttribute(intentAvgSimEClass, INTENT_AVG_SIM__MAX_VALUE);
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
		initEReference(getAnnotation_AvgSims(), this.getAvgSim(), null, "avgSims", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotation_IntentAvgSims(), this.getIntentAvgSim(), null, "intentAvgSims", null, 0, -1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(semanticSimilarityEClass, SemanticSimilarity.class, "SemanticSimilarity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSemanticSimilarity_TrainingPhrase1(), theGeneratorPackage.getTrainingPhrase(), null, "trainingPhrase1", null, 1, 1, SemanticSimilarity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSemanticSimilarity_TrainingPhrase2(), theGeneratorPackage.getTrainingPhrase(), null, "trainingPhrase2", null, 1, 1, SemanticSimilarity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSemanticSimilarity_Similarity(), ecorePackage.getEDouble(), "similarity", null, 1, 1, SemanticSimilarity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(avgSimEClass, AvgSim.class, "AvgSim", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAvgSim_TrainingPhrase(), theGeneratorPackage.getTrainingPhrase(), null, "trainingPhrase", null, 1, 1, AvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAvgSim_Avg(), ecorePackage.getEDouble(), "avg", null, 1, 1, AvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAvgSim_Min(), theGeneratorPackage.getTrainingPhrase(), null, "min", null, 1, 1, AvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAvgSim_Max(), theGeneratorPackage.getTrainingPhrase(), null, "max", null, 1, 1, AvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAvgSim_MinValue(), ecorePackage.getEDouble(), "minValue", null, 1, 1, AvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAvgSim_MaxValue(), ecorePackage.getEDouble(), "maxValue", null, 1, 1, AvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intentAvgSimEClass, IntentAvgSim.class, "IntentAvgSim", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntentAvgSim_TrainingPhrase(), theGeneratorPackage.getTrainingPhrase(), null, "trainingPhrase", null, 1, 1, IntentAvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentAvgSim_Intent(), theGeneratorPackage.getIntent(), null, "intent", null, 1, 1, IntentAvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentAvgSim_Avg(), ecorePackage.getEDouble(), "avg", null, 1, 1, IntentAvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentAvgSim_Min(), theGeneratorPackage.getTrainingPhrase(), null, "min", null, 1, 1, IntentAvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentAvgSim_Max(), theGeneratorPackage.getTrainingPhrase(), null, "max", null, 1, 1, IntentAvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentAvgSim_MinValue(), ecorePackage.getEDouble(), "minValue", null, 1, 1, IntentAvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentAvgSim_MaxValue(), ecorePackage.getEDouble(), "maxValue", null, 1, 1, IntentAvgSim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CongaAnnotationPackageImpl

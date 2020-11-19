/**
 */
package congabase.impl;

import congabase.AQuestion;
import congabase.CongaSystem;
import congabase.CongabaseFactory;
import congabase.CongabasePackage;
import congabase.Project;
import congabase.RelevanceLevel;
import congabase.User;
import congabase.UserAnswer;

import java.util.Map;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import recommenderQuestionnaire.RecommenderQuestionnairePackage;
import recommenderQuestionnaire.impl.RecommenderQuestionnairePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CongabasePackageImpl extends EPackageImpl implements CongabasePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass congaSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userAnswerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aQuestionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toolToDoubleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum relevanceLevelEEnum = null;

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
	 * @see congabase.CongabasePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CongabasePackageImpl() {
		super(eNS_URI, CongabaseFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CongabasePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CongabasePackage init() {
		if (isInited) return (CongabasePackage)EPackage.Registry.INSTANCE.getEPackage(CongabasePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCongabasePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CongabasePackageImpl theCongabasePackage = registeredCongabasePackage instanceof CongabasePackageImpl ? (CongabasePackageImpl)registeredCongabasePackage : new CongabasePackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RecommenderQuestionnairePackage.eNS_URI);
		RecommenderQuestionnairePackageImpl theRecommenderQuestionnairePackage = (RecommenderQuestionnairePackageImpl)(registeredPackage instanceof RecommenderQuestionnairePackageImpl ? registeredPackage : RecommenderQuestionnairePackage.eINSTANCE);

		// Create package meta-data objects
		theCongabasePackage.createPackageContents();
		theRecommenderQuestionnairePackage.createPackageContents();

		// Initialize created meta-data
		theCongabasePackage.initializePackageContents();
		theRecommenderQuestionnairePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCongabasePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CongabasePackage.eNS_URI, theCongabasePackage);
		return theCongabasePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCongaSystem() {
		return congaSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCongaSystem_Users() {
		return (EReference)congaSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCongaSystem_Projects() {
		return (EReference)congaSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCongaSystem_Questionnaire() {
		return (EReference)congaSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUser() {
		return userEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Nick() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Password() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_Projects() {
		return (EReference)userEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProject() {
		return projectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Name() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Owner() {
		return (EReference)projectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Questionnaire() {
		return (EReference)projectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_CreationDate() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_ModificationDate() {
		return (EAttribute)projectEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserAnswer() {
		return userAnswerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserAnswer_Answers() {
		return (EReference)userAnswerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserAnswer_Ranking() {
		return (EReference)userAnswerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserAnswer_Date() {
		return (EAttribute)userAnswerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAQuestion() {
		return aQuestionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAQuestion_Question() {
		return (EReference)aQuestionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAQuestion_Selecteds() {
		return (EReference)aQuestionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAQuestion_Relevance() {
		return (EAttribute)aQuestionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToolToDouble() {
		return toolToDoubleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToolToDouble_Key() {
		return (EReference)toolToDoubleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getToolToDouble_Value() {
		return (EAttribute)toolToDoubleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRelevanceLevel() {
		return relevanceLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CongabaseFactory getCongabaseFactory() {
		return (CongabaseFactory)getEFactoryInstance();
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
		congaSystemEClass = createEClass(CONGA_SYSTEM);
		createEReference(congaSystemEClass, CONGA_SYSTEM__USERS);
		createEReference(congaSystemEClass, CONGA_SYSTEM__PROJECTS);
		createEReference(congaSystemEClass, CONGA_SYSTEM__QUESTIONNAIRE);

		userEClass = createEClass(USER);
		createEAttribute(userEClass, USER__NICK);
		createEAttribute(userEClass, USER__PASSWORD);
		createEReference(userEClass, USER__PROJECTS);

		projectEClass = createEClass(PROJECT);
		createEAttribute(projectEClass, PROJECT__NAME);
		createEReference(projectEClass, PROJECT__OWNER);
		createEReference(projectEClass, PROJECT__QUESTIONNAIRE);
		createEAttribute(projectEClass, PROJECT__CREATION_DATE);
		createEAttribute(projectEClass, PROJECT__MODIFICATION_DATE);

		userAnswerEClass = createEClass(USER_ANSWER);
		createEReference(userAnswerEClass, USER_ANSWER__ANSWERS);
		createEReference(userAnswerEClass, USER_ANSWER__RANKING);
		createEAttribute(userAnswerEClass, USER_ANSWER__DATE);

		aQuestionEClass = createEClass(AQUESTION);
		createEReference(aQuestionEClass, AQUESTION__QUESTION);
		createEReference(aQuestionEClass, AQUESTION__SELECTEDS);
		createEAttribute(aQuestionEClass, AQUESTION__RELEVANCE);

		toolToDoubleEClass = createEClass(TOOL_TO_DOUBLE);
		createEReference(toolToDoubleEClass, TOOL_TO_DOUBLE__KEY);
		createEAttribute(toolToDoubleEClass, TOOL_TO_DOUBLE__VALUE);

		// Create enums
		relevanceLevelEEnum = createEEnum(RELEVANCE_LEVEL);
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
		RecommenderQuestionnairePackage theRecommenderQuestionnairePackage = (RecommenderQuestionnairePackage)EPackage.Registry.INSTANCE.getEPackage(RecommenderQuestionnairePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(congaSystemEClass, CongaSystem.class, "CongaSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCongaSystem_Users(), this.getUser(), null, "users", null, 0, -1, CongaSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCongaSystem_Projects(), this.getProject(), null, "projects", null, 0, -1, CongaSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCongaSystem_Questionnaire(), theRecommenderQuestionnairePackage.getQuestionnaire(), null, "questionnaire", null, 1, 1, CongaSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userEClass, User.class, "User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUser_Nick(), ecorePackage.getEString(), "nick", null, 1, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Password(), ecorePackage.getEString(), "password", null, 1, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUser_Projects(), this.getProject(), this.getProject_Owner(), "projects", null, 0, -1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectEClass, Project.class, "Project", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProject_Name(), ecorePackage.getEString(), "name", null, 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Owner(), this.getUser(), this.getUser_Projects(), "owner", null, 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Questionnaire(), this.getUserAnswer(), null, "questionnaire", null, 0, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_CreationDate(), ecorePackage.getEDate(), "creationDate", null, 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProject_ModificationDate(), ecorePackage.getEDate(), "modificationDate", null, 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userAnswerEClass, UserAnswer.class, "UserAnswer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserAnswer_Answers(), this.getAQuestion(), null, "answers", null, 0, -1, UserAnswer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserAnswer_Ranking(), this.getToolToDouble(), null, "ranking", null, 0, -1, UserAnswer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUserAnswer_Date(), ecorePackage.getEDate(), "date", null, 0, 1, UserAnswer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aQuestionEClass, AQuestion.class, "AQuestion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAQuestion_Question(), theRecommenderQuestionnairePackage.getQuestion(), null, "question", null, 1, 1, AQuestion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAQuestion_Selecteds(), theRecommenderQuestionnairePackage.getOption(), null, "selecteds", null, 0, -1, AQuestion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAQuestion_Relevance(), this.getRelevanceLevel(), "relevance", "Relevant", 1, 1, AQuestion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toolToDoubleEClass, Map.Entry.class, "ToolToDouble", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getToolToDouble_Key(), theRecommenderQuestionnairePackage.getTool(), null, "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getToolToDouble_Value(), ecorePackage.getEDoubleObject(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(relevanceLevelEEnum, RelevanceLevel.class, "RelevanceLevel");
		addEEnumLiteral(relevanceLevelEEnum, RelevanceLevel.IRRELEVANT);
		addEEnumLiteral(relevanceLevelEEnum, RelevanceLevel.RELEVANT);
		addEEnumLiteral(relevanceLevelEEnum, RelevanceLevel.DOBLE);
		addEEnumLiteral(relevanceLevelEEnum, RelevanceLevel.CRITICAL_ONE);
		addEEnumLiteral(relevanceLevelEEnum, RelevanceLevel.CRITICAL_ALL);
		addEEnumLiteral(relevanceLevelEEnum, RelevanceLevel.CRITICAL);

		// Create resource
		createResource(eNS_URI);
	}

} //CongabasePackageImpl

/**
 */
package congabase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see congabase.CongabaseFactory
 * @model kind="package"
 * @generated
 */
public interface CongabasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "congabase";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "congabase";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "congabase";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CongabasePackage eINSTANCE = congabase.impl.CongabasePackageImpl.init();

	/**
	 * The meta object id for the '{@link congabase.impl.CongaSystemImpl <em>Conga System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.impl.CongaSystemImpl
	 * @see congabase.impl.CongabasePackageImpl#getCongaSystem()
	 * @generated
	 */
	int CONGA_SYSTEM = 0;

	/**
	 * The feature id for the '<em><b>Users</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGA_SYSTEM__USERS = 0;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGA_SYSTEM__PROJECTS = 1;

	/**
	 * The feature id for the '<em><b>Questionnaire</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGA_SYSTEM__QUESTIONNAIRE = 2;

	/**
	 * The number of structural features of the '<em>Conga System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGA_SYSTEM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Conga System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGA_SYSTEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congabase.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.impl.UserImpl
	 * @see congabase.impl.CongabasePackageImpl#getUser()
	 * @generated
	 */
	int USER = 1;

	/**
	 * The feature id for the '<em><b>Nick</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NICK = 0;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PASSWORD = 1;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PROJECTS = 2;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congabase.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.impl.ProjectImpl
	 * @see congabase.impl.CongabasePackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__OWNER = 1;

	/**
	 * The feature id for the '<em><b>Questionnaire</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__QUESTIONNAIRE = 2;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__CREATION_DATE = 3;

	/**
	 * The feature id for the '<em><b>Modification Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__MODIFICATION_DATE = 4;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congabase.impl.UserAnswerImpl <em>User Answer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.impl.UserAnswerImpl
	 * @see congabase.impl.CongabasePackageImpl#getUserAnswer()
	 * @generated
	 */
	int USER_ANSWER = 3;

	/**
	 * The feature id for the '<em><b>Answers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ANSWER__ANSWERS = 0;

	/**
	 * The feature id for the '<em><b>Ranking</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ANSWER__RANKING = 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ANSWER__DATE = 2;

	/**
	 * The number of structural features of the '<em>User Answer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ANSWER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>User Answer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ANSWER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congabase.impl.AQuestionImpl <em>AQuestion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.impl.AQuestionImpl
	 * @see congabase.impl.CongabasePackageImpl#getAQuestion()
	 * @generated
	 */
	int AQUESTION = 4;

	/**
	 * The feature id for the '<em><b>Question</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUESTION__QUESTION = 0;

	/**
	 * The feature id for the '<em><b>Selecteds</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUESTION__SELECTEDS = 1;

	/**
	 * The feature id for the '<em><b>Relevance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUESTION__RELEVANCE = 2;

	/**
	 * The number of structural features of the '<em>AQuestion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUESTION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>AQuestion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AQUESTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congabase.impl.ToolToDoubleImpl <em>Tool To Double</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.impl.ToolToDoubleImpl
	 * @see congabase.impl.CongabasePackageImpl#getToolToDouble()
	 * @generated
	 */
	int TOOL_TO_DOUBLE = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_TO_DOUBLE__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_TO_DOUBLE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Tool To Double</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_TO_DOUBLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Tool To Double</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_TO_DOUBLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congabase.RelevanceLevel <em>Relevance Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.RelevanceLevel
	 * @see congabase.impl.CongabasePackageImpl#getRelevanceLevel()
	 * @generated
	 */
	int RELEVANCE_LEVEL = 6;


	/**
	 * Returns the meta object for class '{@link congabase.CongaSystem <em>Conga System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conga System</em>'.
	 * @see congabase.CongaSystem
	 * @generated
	 */
	EClass getCongaSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link congabase.CongaSystem#getUsers <em>Users</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Users</em>'.
	 * @see congabase.CongaSystem#getUsers()
	 * @see #getCongaSystem()
	 * @generated
	 */
	EReference getCongaSystem_Users();

	/**
	 * Returns the meta object for the containment reference list '{@link congabase.CongaSystem#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Projects</em>'.
	 * @see congabase.CongaSystem#getProjects()
	 * @see #getCongaSystem()
	 * @generated
	 */
	EReference getCongaSystem_Projects();

	/**
	 * Returns the meta object for the containment reference '{@link congabase.CongaSystem#getQuestionnaire <em>Questionnaire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Questionnaire</em>'.
	 * @see congabase.CongaSystem#getQuestionnaire()
	 * @see #getCongaSystem()
	 * @generated
	 */
	EReference getCongaSystem_Questionnaire();

	/**
	 * Returns the meta object for class '{@link congabase.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see congabase.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link congabase.User#getNick <em>Nick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nick</em>'.
	 * @see congabase.User#getNick()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Nick();

	/**
	 * Returns the meta object for the attribute '{@link congabase.User#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see congabase.User#getPassword()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Password();

	/**
	 * Returns the meta object for the reference list '{@link congabase.User#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Projects</em>'.
	 * @see congabase.User#getProjects()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_Projects();

	/**
	 * Returns the meta object for class '{@link congabase.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see congabase.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute '{@link congabase.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see congabase.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the reference '{@link congabase.Project#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see congabase.Project#getOwner()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Owner();

	/**
	 * Returns the meta object for the containment reference '{@link congabase.Project#getQuestionnaire <em>Questionnaire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Questionnaire</em>'.
	 * @see congabase.Project#getQuestionnaire()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Questionnaire();

	/**
	 * Returns the meta object for the attribute '{@link congabase.Project#getCreationDate <em>Creation Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Date</em>'.
	 * @see congabase.Project#getCreationDate()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_CreationDate();

	/**
	 * Returns the meta object for the attribute '{@link congabase.Project#getModificationDate <em>Modification Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modification Date</em>'.
	 * @see congabase.Project#getModificationDate()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_ModificationDate();

	/**
	 * Returns the meta object for class '{@link congabase.UserAnswer <em>User Answer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Answer</em>'.
	 * @see congabase.UserAnswer
	 * @generated
	 */
	EClass getUserAnswer();

	/**
	 * Returns the meta object for the containment reference list '{@link congabase.UserAnswer#getAnswers <em>Answers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Answers</em>'.
	 * @see congabase.UserAnswer#getAnswers()
	 * @see #getUserAnswer()
	 * @generated
	 */
	EReference getUserAnswer_Answers();

	/**
	 * Returns the meta object for the map '{@link congabase.UserAnswer#getRanking <em>Ranking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Ranking</em>'.
	 * @see congabase.UserAnswer#getRanking()
	 * @see #getUserAnswer()
	 * @generated
	 */
	EReference getUserAnswer_Ranking();

	/**
	 * Returns the meta object for the attribute '{@link congabase.UserAnswer#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see congabase.UserAnswer#getDate()
	 * @see #getUserAnswer()
	 * @generated
	 */
	EAttribute getUserAnswer_Date();

	/**
	 * Returns the meta object for class '{@link congabase.AQuestion <em>AQuestion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AQuestion</em>'.
	 * @see congabase.AQuestion
	 * @generated
	 */
	EClass getAQuestion();

	/**
	 * Returns the meta object for the reference '{@link congabase.AQuestion#getQuestion <em>Question</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Question</em>'.
	 * @see congabase.AQuestion#getQuestion()
	 * @see #getAQuestion()
	 * @generated
	 */
	EReference getAQuestion_Question();

	/**
	 * Returns the meta object for the reference list '{@link congabase.AQuestion#getSelecteds <em>Selecteds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Selecteds</em>'.
	 * @see congabase.AQuestion#getSelecteds()
	 * @see #getAQuestion()
	 * @generated
	 */
	EReference getAQuestion_Selecteds();

	/**
	 * Returns the meta object for the attribute '{@link congabase.AQuestion#getRelevance <em>Relevance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relevance</em>'.
	 * @see congabase.AQuestion#getRelevance()
	 * @see #getAQuestion()
	 * @generated
	 */
	EAttribute getAQuestion_Relevance();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Tool To Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool To Double</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="recommenderQuestionnaire.Tool" keyRequired="true"
	 *        valueDataType="org.eclipse.emf.ecore.EDoubleObject" valueRequired="true"
	 * @generated
	 */
	EClass getToolToDouble();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getToolToDouble()
	 * @generated
	 */
	EReference getToolToDouble_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getToolToDouble()
	 * @generated
	 */
	EAttribute getToolToDouble_Value();

	/**
	 * Returns the meta object for enum '{@link congabase.RelevanceLevel <em>Relevance Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Relevance Level</em>'.
	 * @see congabase.RelevanceLevel
	 * @generated
	 */
	EEnum getRelevanceLevel();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CongabaseFactory getCongabaseFactory();

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
		 * The meta object literal for the '{@link congabase.impl.CongaSystemImpl <em>Conga System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.impl.CongaSystemImpl
		 * @see congabase.impl.CongabasePackageImpl#getCongaSystem()
		 * @generated
		 */
		EClass CONGA_SYSTEM = eINSTANCE.getCongaSystem();

		/**
		 * The meta object literal for the '<em><b>Users</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONGA_SYSTEM__USERS = eINSTANCE.getCongaSystem_Users();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONGA_SYSTEM__PROJECTS = eINSTANCE.getCongaSystem_Projects();

		/**
		 * The meta object literal for the '<em><b>Questionnaire</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONGA_SYSTEM__QUESTIONNAIRE = eINSTANCE.getCongaSystem_Questionnaire();

		/**
		 * The meta object literal for the '{@link congabase.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.impl.UserImpl
		 * @see congabase.impl.CongabasePackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>Nick</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__NICK = eINSTANCE.getUser_Nick();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__PASSWORD = eINSTANCE.getUser_Password();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__PROJECTS = eINSTANCE.getUser_Projects();

		/**
		 * The meta object literal for the '{@link congabase.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.impl.ProjectImpl
		 * @see congabase.impl.CongabasePackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__OWNER = eINSTANCE.getProject_Owner();

		/**
		 * The meta object literal for the '<em><b>Questionnaire</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__QUESTIONNAIRE = eINSTANCE.getProject_Questionnaire();

		/**
		 * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__CREATION_DATE = eINSTANCE.getProject_CreationDate();

		/**
		 * The meta object literal for the '<em><b>Modification Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__MODIFICATION_DATE = eINSTANCE.getProject_ModificationDate();

		/**
		 * The meta object literal for the '{@link congabase.impl.UserAnswerImpl <em>User Answer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.impl.UserAnswerImpl
		 * @see congabase.impl.CongabasePackageImpl#getUserAnswer()
		 * @generated
		 */
		EClass USER_ANSWER = eINSTANCE.getUserAnswer();

		/**
		 * The meta object literal for the '<em><b>Answers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ANSWER__ANSWERS = eINSTANCE.getUserAnswer_Answers();

		/**
		 * The meta object literal for the '<em><b>Ranking</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ANSWER__RANKING = eINSTANCE.getUserAnswer_Ranking();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_ANSWER__DATE = eINSTANCE.getUserAnswer_Date();

		/**
		 * The meta object literal for the '{@link congabase.impl.AQuestionImpl <em>AQuestion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.impl.AQuestionImpl
		 * @see congabase.impl.CongabasePackageImpl#getAQuestion()
		 * @generated
		 */
		EClass AQUESTION = eINSTANCE.getAQuestion();

		/**
		 * The meta object literal for the '<em><b>Question</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AQUESTION__QUESTION = eINSTANCE.getAQuestion_Question();

		/**
		 * The meta object literal for the '<em><b>Selecteds</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AQUESTION__SELECTEDS = eINSTANCE.getAQuestion_Selecteds();

		/**
		 * The meta object literal for the '<em><b>Relevance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AQUESTION__RELEVANCE = eINSTANCE.getAQuestion_Relevance();

		/**
		 * The meta object literal for the '{@link congabase.impl.ToolToDoubleImpl <em>Tool To Double</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.impl.ToolToDoubleImpl
		 * @see congabase.impl.CongabasePackageImpl#getToolToDouble()
		 * @generated
		 */
		EClass TOOL_TO_DOUBLE = eINSTANCE.getToolToDouble();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOOL_TO_DOUBLE__KEY = eINSTANCE.getToolToDouble_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL_TO_DOUBLE__VALUE = eINSTANCE.getToolToDouble_Value();

		/**
		 * The meta object literal for the '{@link congabase.RelevanceLevel <em>Relevance Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.RelevanceLevel
		 * @see congabase.impl.CongabasePackageImpl#getRelevanceLevel()
		 * @generated
		 */
		EEnum RELEVANCE_LEVEL = eINSTANCE.getRelevanceLevel();

	}

} //CongabasePackage

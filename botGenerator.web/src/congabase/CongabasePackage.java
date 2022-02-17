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
	 * The feature id for the '<em><b>Generators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGA_SYSTEM__GENERATORS = 3;

	/**
	 * The feature id for the '<em><b>Converters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGA_SYSTEM__CONVERTERS = 4;

	/**
	 * The feature id for the '<em><b>Validators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGA_SYSTEM__VALIDATORS = 5;

	/**
	 * The feature id for the '<em><b>QOptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGA_SYSTEM__QOPTIONS = 6;

	/**
	 * The number of structural features of the '<em>Conga System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONGA_SYSTEM_FEATURE_COUNT = 7;

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
	 * The feature id for the '<em><b>Utilities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__UTILITIES = 3;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 4;

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
	 * The meta object id for the '{@link congabase.impl.ROptionToDoubleImpl <em>ROption To Double</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.impl.ROptionToDoubleImpl
	 * @see congabase.impl.CongabasePackageImpl#getROptionToDouble()
	 * @generated
	 */
	int ROPTION_TO_DOUBLE = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROPTION_TO_DOUBLE__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROPTION_TO_DOUBLE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>ROption To Double</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROPTION_TO_DOUBLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>ROption To Double</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROPTION_TO_DOUBLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congabase.impl.UtilityImpl <em>Utility</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.impl.UtilityImpl
	 * @see congabase.impl.CongabasePackageImpl#getUtility()
	 * @generated
	 */
	int UTILITY = 6;

	/**
	 * The feature id for the '<em><b>Service Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILITY__SERVICE_ID = 0;

	/**
	 * The feature id for the '<em><b>Tool</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILITY__TOOL = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILITY__VERSION = 2;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILITY__USER = 3;

	/**
	 * The number of structural features of the '<em>Utility</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILITY_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Utility</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UTILITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congabase.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.impl.ServiceImpl
	 * @see congabase.impl.CongabasePackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 7;

	/**
	 * The feature id for the '<em><b>Service Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SERVICE_ID = UTILITY__SERVICE_ID;

	/**
	 * The feature id for the '<em><b>Tool</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__TOOL = UTILITY__TOOL;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__VERSION = UTILITY__VERSION;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__USER = UTILITY__USER;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__URL = UTILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__TYPE = UTILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__STATUS = UTILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Basic Auth</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__BASIC_AUTH = UTILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Headers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__HEADERS = UTILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Last Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__LAST_ACCESS = UTILITY_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = UTILITY_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OPERATION_COUNT = UTILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link congabase.impl.RecommenderOptionImpl <em>Recommender Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.impl.RecommenderOptionImpl
	 * @see congabase.impl.CongabasePackageImpl#getRecommenderOption()
	 * @generated
	 */
	int RECOMMENDER_OPTION = 8;

	/**
	 * The feature id for the '<em><b>Service Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDER_OPTION__SERVICE_ID = UTILITY__SERVICE_ID;

	/**
	 * The feature id for the '<em><b>Tool</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDER_OPTION__TOOL = UTILITY__TOOL;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDER_OPTION__VERSION = UTILITY__VERSION;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDER_OPTION__USER = UTILITY__USER;

	/**
	 * The feature id for the '<em><b>Available</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDER_OPTION__AVAILABLE = UTILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unavailable</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDER_OPTION__UNAVAILABLE = UTILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDER_OPTION__UNKNOWN = UTILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Possible</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDER_OPTION__POSSIBLE = UTILITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Recommender Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDER_OPTION_FEATURE_COUNT = UTILITY_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Recommender Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMENDER_OPTION_OPERATION_COUNT = UTILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link congabase.impl.KeyValueImpl <em>Key Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.impl.KeyValueImpl
	 * @see congabase.impl.CongabasePackageImpl#getKeyValue()
	 * @generated
	 */
	int KEY_VALUE = 9;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Key Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Key Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link congabase.RelevanceLevel <em>Relevance Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.RelevanceLevel
	 * @see congabase.impl.CongabasePackageImpl#getRelevanceLevel()
	 * @generated
	 */
	int RELEVANCE_LEVEL = 10;


	/**
	 * The meta object id for the '{@link congabase.ServiceStatus <em>Service Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.ServiceStatus
	 * @see congabase.impl.CongabasePackageImpl#getServiceStatus()
	 * @generated
	 */
	int SERVICE_STATUS = 11;

	/**
	 * The meta object id for the '{@link congabase.ServiceType <em>Service Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see congabase.ServiceType
	 * @see congabase.impl.CongabasePackageImpl#getServiceType()
	 * @generated
	 */
	int SERVICE_TYPE = 12;


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
	 * Returns the meta object for the containment reference list '{@link congabase.CongaSystem#getGenerators <em>Generators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Generators</em>'.
	 * @see congabase.CongaSystem#getGenerators()
	 * @see #getCongaSystem()
	 * @generated
	 */
	EReference getCongaSystem_Generators();

	/**
	 * Returns the meta object for the containment reference list '{@link congabase.CongaSystem#getConverters <em>Converters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Converters</em>'.
	 * @see congabase.CongaSystem#getConverters()
	 * @see #getCongaSystem()
	 * @generated
	 */
	EReference getCongaSystem_Converters();

	/**
	 * Returns the meta object for the containment reference list '{@link congabase.CongaSystem#getValidators <em>Validators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Validators</em>'.
	 * @see congabase.CongaSystem#getValidators()
	 * @see #getCongaSystem()
	 * @generated
	 */
	EReference getCongaSystem_Validators();

	/**
	 * Returns the meta object for the containment reference list '{@link congabase.CongaSystem#getQOptions <em>QOptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>QOptions</em>'.
	 * @see congabase.CongaSystem#getQOptions()
	 * @see #getCongaSystem()
	 * @generated
	 */
	EReference getCongaSystem_QOptions();

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
	 * Returns the meta object for the reference list '{@link congabase.User#getUtilities <em>Utilities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Utilities</em>'.
	 * @see congabase.User#getUtilities()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_Utilities();

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
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>ROption To Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ROption To Double</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="congabase.RecommenderOption" keyRequired="true"
	 *        valueDataType="org.eclipse.emf.ecore.EDoubleObject" valueRequired="true"
	 * @generated
	 */
	EClass getROptionToDouble();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getROptionToDouble()
	 * @generated
	 */
	EReference getROptionToDouble_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getROptionToDouble()
	 * @generated
	 */
	EAttribute getROptionToDouble_Value();

	/**
	 * Returns the meta object for class '{@link congabase.Utility <em>Utility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Utility</em>'.
	 * @see congabase.Utility
	 * @generated
	 */
	EClass getUtility();

	/**
	 * Returns the meta object for the attribute '{@link congabase.Utility#getServiceId <em>Service Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Id</em>'.
	 * @see congabase.Utility#getServiceId()
	 * @see #getUtility()
	 * @generated
	 */
	EAttribute getUtility_ServiceId();

	/**
	 * Returns the meta object for the reference '{@link congabase.Utility#getTool <em>Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tool</em>'.
	 * @see congabase.Utility#getTool()
	 * @see #getUtility()
	 * @generated
	 */
	EReference getUtility_Tool();

	/**
	 * Returns the meta object for the attribute '{@link congabase.Utility#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see congabase.Utility#getVersion()
	 * @see #getUtility()
	 * @generated
	 */
	EAttribute getUtility_Version();

	/**
	 * Returns the meta object for the reference '{@link congabase.Utility#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see congabase.Utility#getUser()
	 * @see #getUtility()
	 * @generated
	 */
	EReference getUtility_User();

	/**
	 * Returns the meta object for class '{@link congabase.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see congabase.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the attribute '{@link congabase.Service#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see congabase.Service#getUrl()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Url();

	/**
	 * Returns the meta object for the attribute '{@link congabase.Service#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see congabase.Service#getType()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Type();

	/**
	 * Returns the meta object for the attribute '{@link congabase.Service#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see congabase.Service#getStatus()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Status();

	/**
	 * Returns the meta object for the containment reference '{@link congabase.Service#getBasicAuth <em>Basic Auth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Basic Auth</em>'.
	 * @see congabase.Service#getBasicAuth()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_BasicAuth();

	/**
	 * Returns the meta object for the containment reference list '{@link congabase.Service#getHeaders <em>Headers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Headers</em>'.
	 * @see congabase.Service#getHeaders()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Headers();

	/**
	 * Returns the meta object for the attribute '{@link congabase.Service#getLastAccess <em>Last Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Access</em>'.
	 * @see congabase.Service#getLastAccess()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_LastAccess();

	/**
	 * Returns the meta object for class '{@link congabase.RecommenderOption <em>Recommender Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recommender Option</em>'.
	 * @see congabase.RecommenderOption
	 * @generated
	 */
	EClass getRecommenderOption();

	/**
	 * Returns the meta object for the reference list '{@link congabase.RecommenderOption#getAvailable <em>Available</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Available</em>'.
	 * @see congabase.RecommenderOption#getAvailable()
	 * @see #getRecommenderOption()
	 * @generated
	 */
	EReference getRecommenderOption_Available();

	/**
	 * Returns the meta object for the reference list '{@link congabase.RecommenderOption#getUnavailable <em>Unavailable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unavailable</em>'.
	 * @see congabase.RecommenderOption#getUnavailable()
	 * @see #getRecommenderOption()
	 * @generated
	 */
	EReference getRecommenderOption_Unavailable();

	/**
	 * Returns the meta object for the reference list '{@link congabase.RecommenderOption#getUnknown <em>Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unknown</em>'.
	 * @see congabase.RecommenderOption#getUnknown()
	 * @see #getRecommenderOption()
	 * @generated
	 */
	EReference getRecommenderOption_Unknown();

	/**
	 * Returns the meta object for the reference list '{@link congabase.RecommenderOption#getPossible <em>Possible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Possible</em>'.
	 * @see congabase.RecommenderOption#getPossible()
	 * @see #getRecommenderOption()
	 * @generated
	 */
	EReference getRecommenderOption_Possible();

	/**
	 * Returns the meta object for class '{@link congabase.KeyValue <em>Key Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Value</em>'.
	 * @see congabase.KeyValue
	 * @generated
	 */
	EClass getKeyValue();

	/**
	 * Returns the meta object for the attribute '{@link congabase.KeyValue#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see congabase.KeyValue#getKey()
	 * @see #getKeyValue()
	 * @generated
	 */
	EAttribute getKeyValue_Key();

	/**
	 * Returns the meta object for the attribute '{@link congabase.KeyValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see congabase.KeyValue#getValue()
	 * @see #getKeyValue()
	 * @generated
	 */
	EAttribute getKeyValue_Value();

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
	 * Returns the meta object for enum '{@link congabase.ServiceStatus <em>Service Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Service Status</em>'.
	 * @see congabase.ServiceStatus
	 * @generated
	 */
	EEnum getServiceStatus();

	/**
	 * Returns the meta object for enum '{@link congabase.ServiceType <em>Service Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Service Type</em>'.
	 * @see congabase.ServiceType
	 * @generated
	 */
	EEnum getServiceType();

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
		 * The meta object literal for the '<em><b>Generators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONGA_SYSTEM__GENERATORS = eINSTANCE.getCongaSystem_Generators();

		/**
		 * The meta object literal for the '<em><b>Converters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONGA_SYSTEM__CONVERTERS = eINSTANCE.getCongaSystem_Converters();

		/**
		 * The meta object literal for the '<em><b>Validators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONGA_SYSTEM__VALIDATORS = eINSTANCE.getCongaSystem_Validators();

		/**
		 * The meta object literal for the '<em><b>QOptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONGA_SYSTEM__QOPTIONS = eINSTANCE.getCongaSystem_QOptions();

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
		 * The meta object literal for the '<em><b>Utilities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__UTILITIES = eINSTANCE.getUser_Utilities();

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
		 * The meta object literal for the '{@link congabase.impl.ROptionToDoubleImpl <em>ROption To Double</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.impl.ROptionToDoubleImpl
		 * @see congabase.impl.CongabasePackageImpl#getROptionToDouble()
		 * @generated
		 */
		EClass ROPTION_TO_DOUBLE = eINSTANCE.getROptionToDouble();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROPTION_TO_DOUBLE__KEY = eINSTANCE.getROptionToDouble_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROPTION_TO_DOUBLE__VALUE = eINSTANCE.getROptionToDouble_Value();

		/**
		 * The meta object literal for the '{@link congabase.impl.UtilityImpl <em>Utility</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.impl.UtilityImpl
		 * @see congabase.impl.CongabasePackageImpl#getUtility()
		 * @generated
		 */
		EClass UTILITY = eINSTANCE.getUtility();

		/**
		 * The meta object literal for the '<em><b>Service Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UTILITY__SERVICE_ID = eINSTANCE.getUtility_ServiceId();

		/**
		 * The meta object literal for the '<em><b>Tool</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UTILITY__TOOL = eINSTANCE.getUtility_Tool();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UTILITY__VERSION = eINSTANCE.getUtility_Version();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UTILITY__USER = eINSTANCE.getUtility_User();

		/**
		 * The meta object literal for the '{@link congabase.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.impl.ServiceImpl
		 * @see congabase.impl.CongabasePackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__URL = eINSTANCE.getService_Url();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__TYPE = eINSTANCE.getService_Type();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__STATUS = eINSTANCE.getService_Status();

		/**
		 * The meta object literal for the '<em><b>Basic Auth</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__BASIC_AUTH = eINSTANCE.getService_BasicAuth();

		/**
		 * The meta object literal for the '<em><b>Headers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__HEADERS = eINSTANCE.getService_Headers();

		/**
		 * The meta object literal for the '<em><b>Last Access</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__LAST_ACCESS = eINSTANCE.getService_LastAccess();

		/**
		 * The meta object literal for the '{@link congabase.impl.RecommenderOptionImpl <em>Recommender Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.impl.RecommenderOptionImpl
		 * @see congabase.impl.CongabasePackageImpl#getRecommenderOption()
		 * @generated
		 */
		EClass RECOMMENDER_OPTION = eINSTANCE.getRecommenderOption();

		/**
		 * The meta object literal for the '<em><b>Available</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDER_OPTION__AVAILABLE = eINSTANCE.getRecommenderOption_Available();

		/**
		 * The meta object literal for the '<em><b>Unavailable</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDER_OPTION__UNAVAILABLE = eINSTANCE.getRecommenderOption_Unavailable();

		/**
		 * The meta object literal for the '<em><b>Unknown</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDER_OPTION__UNKNOWN = eINSTANCE.getRecommenderOption_Unknown();

		/**
		 * The meta object literal for the '<em><b>Possible</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECOMMENDER_OPTION__POSSIBLE = eINSTANCE.getRecommenderOption_Possible();

		/**
		 * The meta object literal for the '{@link congabase.impl.KeyValueImpl <em>Key Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.impl.KeyValueImpl
		 * @see congabase.impl.CongabasePackageImpl#getKeyValue()
		 * @generated
		 */
		EClass KEY_VALUE = eINSTANCE.getKeyValue();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_VALUE__KEY = eINSTANCE.getKeyValue_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_VALUE__VALUE = eINSTANCE.getKeyValue_Value();

		/**
		 * The meta object literal for the '{@link congabase.RelevanceLevel <em>Relevance Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.RelevanceLevel
		 * @see congabase.impl.CongabasePackageImpl#getRelevanceLevel()
		 * @generated
		 */
		EEnum RELEVANCE_LEVEL = eINSTANCE.getRelevanceLevel();

		/**
		 * The meta object literal for the '{@link congabase.ServiceStatus <em>Service Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.ServiceStatus
		 * @see congabase.impl.CongabasePackageImpl#getServiceStatus()
		 * @generated
		 */
		EEnum SERVICE_STATUS = eINSTANCE.getServiceStatus();

		/**
		 * The meta object literal for the '{@link congabase.ServiceType <em>Service Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see congabase.ServiceType
		 * @see congabase.impl.CongabasePackageImpl#getServiceType()
		 * @generated
		 */
		EEnum SERVICE_TYPE = eINSTANCE.getServiceType();

	}

} //CongabasePackage

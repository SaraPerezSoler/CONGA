/**
 */
package generator;

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
 * @see generator.GeneratorFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface GeneratorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "generator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://generator";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "generator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneratorPackage eINSTANCE = generator.impl.GeneratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link generator.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.ElementImpl
	 * @see generator.impl.GeneratorPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link generator.impl.BotImpl <em>Bot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.BotImpl
	 * @see generator.impl.GeneratorPackageImpl#getBot()
	 * @generated
	 */
	int BOT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Intents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT__INTENTS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT__ENTITIES = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT__ACTIONS = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Flows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT__FLOWS = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Languages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT__LANGUAGES = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Bot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Bot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.InteractionImpl <em>Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.InteractionImpl
	 * @see generator.impl.GeneratorPackageImpl#getInteraction()
	 * @generated
	 */
	int INTERACTION = 1;

	/**
	 * The number of structural features of the '<em>Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link generator.impl.BotInteractionImpl <em>Bot Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.BotInteractionImpl
	 * @see generator.impl.GeneratorPackageImpl#getBotInteraction()
	 * @generated
	 */
	int BOT_INTERACTION = 2;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INTERACTION__ACTIONS = INTERACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INTERACTION__INCOMING = INTERACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outcoming</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INTERACTION__OUTCOMING = INTERACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Back To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INTERACTION__BACK_TO = INTERACTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INTERACTION__NAME = INTERACTION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Bot Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INTERACTION_FEATURE_COUNT = INTERACTION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Bot Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOT_INTERACTION_OPERATION_COUNT = INTERACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.UserInteractionImpl <em>User Interaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.UserInteractionImpl
	 * @see generator.impl.GeneratorPackageImpl#getUserInteraction()
	 * @generated
	 */
	int USER_INTERACTION = 3;

	/**
	 * The feature id for the '<em><b>Intent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__INTENT = INTERACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__SRC = INTERACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__TARGET = INTERACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__NAME = INTERACTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Back To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION__BACK_TO = INTERACTION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>User Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION_FEATURE_COUNT = INTERACTION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>User Interaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERACTION_OPERATION_COUNT = INTERACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.BackToBotImpl <em>Back To Bot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.BackToBotImpl
	 * @see generator.impl.GeneratorPackageImpl#getBackToBot()
	 * @generated
	 */
	int BACK_TO_BOT = 4;

	/**
	 * The feature id for the '<em><b>Previous</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACK_TO_BOT__PREVIOUS = 0;

	/**
	 * The feature id for the '<em><b>Back To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACK_TO_BOT__BACK_TO = 1;

	/**
	 * The number of structural features of the '<em>Back To Bot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACK_TO_BOT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Back To Bot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACK_TO_BOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link generator.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.EntityImpl
	 * @see generator.impl.GeneratorPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 7;

	/**
	 * The meta object id for the '{@link generator.impl.LanguageEntityImpl <em>Language Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.LanguageEntityImpl
	 * @see generator.impl.GeneratorPackageImpl#getLanguageEntity()
	 * @generated
	 */
	int LANGUAGE_ENTITY = 8;

	/**
	 * The meta object id for the '{@link generator.impl.LanguageInputImpl <em>Language Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.LanguageInputImpl
	 * @see generator.impl.GeneratorPackageImpl#getLanguageInput()
	 * @generated
	 */
	int LANGUAGE_INPUT = 6;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_INPUT__LANGUAGE = 0;

	/**
	 * The number of structural features of the '<em>Language Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_INPUT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Language Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_INPUT_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__INPUTS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_ENTITY__LANGUAGE = LANGUAGE_INPUT__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_ENTITY__INPUTS = LANGUAGE_INPUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Language Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_ENTITY_FEATURE_COUNT = LANGUAGE_INPUT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Language Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_ENTITY_OPERATION_COUNT = LANGUAGE_INPUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.InputImpl <em>Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.InputImpl
	 * @see generator.impl.GeneratorPackageImpl#getInput()
	 * @generated
	 */
	int INPUT = 13;

	/**
	 * The meta object id for the '{@link generator.impl.SimpleInputImpl <em>Simple Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.SimpleInputImpl
	 * @see generator.impl.GeneratorPackageImpl#getSimpleInput()
	 * @generated
	 */
	int SIMPLE_INPUT = 10;

	/**
	 * The meta object id for the '{@link generator.impl.CompositeInputImpl <em>Composite Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.CompositeInputImpl
	 * @see generator.impl.GeneratorPackageImpl#getCompositeInput()
	 * @generated
	 */
	int COMPOSITE_INPUT = 11;

	/**
	 * The number of structural features of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link generator.impl.EntityInputImpl <em>Entity Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.EntityInputImpl
	 * @see generator.impl.GeneratorPackageImpl#getEntityInput()
	 * @generated
	 */
	int ENTITY_INPUT = 9;

	/**
	 * The number of structural features of the '<em>Entity Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_INPUT_FEATURE_COUNT = INPUT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Entity Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_INPUT_OPERATION_COUNT = INPUT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_INPUT__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_INPUT__VALUES = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_INPUT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Simple Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_INPUT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expresion</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INPUT__EXPRESION = ENTITY_INPUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INPUT_FEATURE_COUNT = ENTITY_INPUT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composite Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_INPUT_OPERATION_COUNT = ENTITY_INPUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.RegexInputImpl <em>Regex Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.RegexInputImpl
	 * @see generator.impl.GeneratorPackageImpl#getRegexInput()
	 * @generated
	 */
	int REGEX_INPUT = 12;

	/**
	 * The meta object id for the '{@link generator.impl.TokenImpl <em>Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.TokenImpl
	 * @see generator.impl.GeneratorPackageImpl#getToken()
	 * @generated
	 */
	int TOKEN = 14;

	/**
	 * The meta object id for the '{@link generator.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.LiteralImpl
	 * @see generator.impl.GeneratorPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 15;

	/**
	 * The meta object id for the '{@link generator.impl.EntityTokenImpl <em>Entity Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.EntityTokenImpl
	 * @see generator.impl.GeneratorPackageImpl#getEntityToken()
	 * @generated
	 */
	int ENTITY_TOKEN = 16;

	/**
	 * The meta object id for the '{@link generator.impl.ParameterTokenImpl <em>Parameter Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.ParameterTokenImpl
	 * @see generator.impl.GeneratorPackageImpl#getParameterToken()
	 * @generated
	 */
	int PARAMETER_TOKEN = 17;

	/**
	 * The meta object id for the '{@link generator.impl.ParameterReferenceTokenImpl <em>Parameter Reference Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.ParameterReferenceTokenImpl
	 * @see generator.impl.GeneratorPackageImpl#getParameterReferenceToken()
	 * @generated
	 */
	int PARAMETER_REFERENCE_TOKEN = 18;

	/**
	 * The meta object id for the '{@link generator.impl.HTTPRequestTokeImpl <em>HTTP Request Toke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.HTTPRequestTokeImpl
	 * @see generator.impl.GeneratorPackageImpl#getHTTPRequestToke()
	 * @generated
	 */
	int HTTP_REQUEST_TOKE = 19;

	/**
	 * The meta object id for the '{@link generator.impl.IntentImpl <em>Intent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.IntentImpl
	 * @see generator.impl.GeneratorPackageImpl#getIntent()
	 * @generated
	 */
	int INTENT = 20;

	/**
	 * The feature id for the '<em><b>Expresion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_INPUT__EXPRESION = ENTITY_INPUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Regex Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_INPUT_FEATURE_COUNT = ENTITY_INPUT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Regex Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_INPUT_OPERATION_COUNT = ENTITY_INPUT_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__TEXT = TOKEN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = TOKEN_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OPERATION_COUNT = TOKEN_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_TOKEN__ENTITY = TOKEN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_TOKEN_FEATURE_COUNT = TOKEN_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Entity Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_TOKEN_OPERATION_COUNT = TOKEN_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TOKEN__PARAMETER = TOKEN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TOKEN__INFO = TOKEN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TOKEN_FEATURE_COUNT = TOKEN_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Parameter Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_TOKEN_OPERATION_COUNT = TOKEN_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_REFERENCE_TOKEN__PARAMETER = TOKEN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_REFERENCE_TOKEN__TEXT_REFERENCE = TOKEN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter Reference Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_REFERENCE_TOKEN_FEATURE_COUNT = TOKEN_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Parameter Reference Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_REFERENCE_TOKEN_OPERATION_COUNT = TOKEN_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST_TOKE__TYPE = TOKEN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST_TOKE__DATA_KEY = TOKEN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>HTTP Request Toke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST_TOKE_FEATURE_COUNT = TOKEN_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>HTTP Request Toke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST_TOKE_OPERATION_COUNT = TOKEN_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT__INPUTS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT__PARAMETERS = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fallback Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT__FALLBACK_INTENT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Intent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Intent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.LanguageIntentImpl <em>Language Intent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.LanguageIntentImpl
	 * @see generator.impl.GeneratorPackageImpl#getLanguageIntent()
	 * @generated
	 */
	int LANGUAGE_INTENT = 21;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_INTENT__LANGUAGE = LANGUAGE_INPUT__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_INTENT__INPUTS = LANGUAGE_INPUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Language Intent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_INTENT_FEATURE_COUNT = LANGUAGE_INPUT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Language Intent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_INTENT_OPERATION_COUNT = LANGUAGE_INPUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.TrainingPhraseImpl <em>Training Phrase</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.TrainingPhraseImpl
	 * @see generator.impl.GeneratorPackageImpl#getTrainingPhrase()
	 * @generated
	 */
	int TRAINING_PHRASE = 22;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAINING_PHRASE__TOKENS = 0;

	/**
	 * The number of structural features of the '<em>Training Phrase</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAINING_PHRASE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Training Phrase</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAINING_PHRASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link generator.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.ParameterImpl
	 * @see generator.impl.GeneratorPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__ENTITY = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Entity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DEFAULT_ENTITY = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__REQUIRED = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__IS_LIST = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Prompts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__PROMPTS = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.LanguagePromptImpl <em>Language Prompt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.LanguagePromptImpl
	 * @see generator.impl.GeneratorPackageImpl#getLanguagePrompt()
	 * @generated
	 */
	int LANGUAGE_PROMPT = 24;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_PROMPT__LANGUAGE = LANGUAGE_INPUT__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Prompts</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_PROMPT__PROMPTS = LANGUAGE_INPUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Language Prompt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_PROMPT_FEATURE_COUNT = LANGUAGE_INPUT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Language Prompt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_PROMPT_OPERATION_COUNT = LANGUAGE_INPUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.ActionImpl
	 * @see generator.impl.GeneratorPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.ImageImpl <em>Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.ImageImpl
	 * @see generator.impl.GeneratorPackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__URL = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__CAPTION = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.EmptyImpl <em>Empty</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.EmptyImpl
	 * @see generator.impl.GeneratorPackageImpl#getEmpty()
	 * @generated
	 */
	int EMPTY = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY__DESCRIPTION = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Empty</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Empty</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.TextImpl
	 * @see generator.impl.GeneratorPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__INPUTS = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.ButtonActionImpl <em>Button Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.ButtonActionImpl
	 * @see generator.impl.GeneratorPackageImpl#getButtonAction()
	 * @generated
	 */
	int BUTTON_ACTION = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON_ACTION__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON_ACTION__INPUTS = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Button Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Button Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON_ACTION_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.LanguageTextImpl <em>Language Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.LanguageTextImpl
	 * @see generator.impl.GeneratorPackageImpl#getLanguageText()
	 * @generated
	 */
	int LANGUAGE_TEXT = 32;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_TEXT__LANGUAGE = LANGUAGE_INPUT__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_TEXT__INPUTS = LANGUAGE_INPUT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Language Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_TEXT_FEATURE_COUNT = LANGUAGE_INPUT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Language Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_TEXT_OPERATION_COUNT = LANGUAGE_INPUT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.LanguageButtonImpl <em>Language Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.LanguageButtonImpl
	 * @see generator.impl.GeneratorPackageImpl#getLanguageButton()
	 * @generated
	 */
	int LANGUAGE_BUTTON = 30;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_BUTTON__LANGUAGE = LANGUAGE_TEXT__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_BUTTON__INPUTS = LANGUAGE_TEXT__INPUTS;

	/**
	 * The feature id for the '<em><b>Buttons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_BUTTON__BUTTONS = LANGUAGE_TEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Language Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_BUTTON_FEATURE_COUNT = LANGUAGE_TEXT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Language Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_BUTTON_OPERATION_COUNT = LANGUAGE_TEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.ButtonImpl <em>Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.ButtonImpl
	 * @see generator.impl.GeneratorPackageImpl#getButton()
	 * @generated
	 */
	int BUTTON = 31;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__ACTION = 1;

	/**
	 * The number of structural features of the '<em>Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link generator.impl.TextInputImpl <em>Text Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.TextInputImpl
	 * @see generator.impl.GeneratorPackageImpl#getTextInput()
	 * @generated
	 */
	int TEXT_INPUT = 33;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_INPUT__TOKENS = 0;

	/**
	 * The number of structural features of the '<em>Text Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_INPUT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Text Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_INPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link generator.impl.HTTPRequestImpl <em>HTTP Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.HTTPRequestImpl
	 * @see generator.impl.GeneratorPackageImpl#getHTTPRequest()
	 * @generated
	 */
	int HTTP_REQUEST = 34;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST__URL = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Basic Auth</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST__BASIC_AUTH = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Headers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST__HEADERS = ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST__DATA = ACTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST__DATA_TYPE = ACTION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST__METHOD = ACTION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>HTTP Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST_FEATURE_COUNT = ACTION_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>HTTP Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_REQUEST_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.HTTPResponseImpl <em>HTTP Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.HTTPResponseImpl
	 * @see generator.impl.GeneratorPackageImpl#getHTTPResponse()
	 * @generated
	 */
	int HTTP_RESPONSE = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_RESPONSE__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_RESPONSE__INPUTS = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>HTTP Request</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_RESPONSE__HTTP_REQUEST = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>HTTP Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_RESPONSE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>HTTP Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTTP_RESPONSE_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link generator.impl.KeyValueImpl <em>Key Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.impl.KeyValueImpl
	 * @see generator.impl.GeneratorPackageImpl#getKeyValue()
	 * @generated
	 */
	int KEY_VALUE = 36;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
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
	 * The meta object id for the '{@link generator.DataType <em>Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.DataType
	 * @see generator.impl.GeneratorPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 37;

	/**
	 * The meta object id for the '{@link generator.Method <em>Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.Method
	 * @see generator.impl.GeneratorPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 38;

	/**
	 * The meta object id for the '{@link generator.Language <em>Language</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.Language
	 * @see generator.impl.GeneratorPackageImpl#getLanguage()
	 * @generated
	 */
	int LANGUAGE = 39;

	/**
	 * The meta object id for the '{@link generator.HTTPReturnType <em>HTTP Return Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.HTTPReturnType
	 * @see generator.impl.GeneratorPackageImpl#getHTTPReturnType()
	 * @generated
	 */
	int HTTP_RETURN_TYPE = 40;

	/**
	 * The meta object id for the '{@link generator.DefaultEntity <em>Default Entity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see generator.DefaultEntity
	 * @see generator.impl.GeneratorPackageImpl#getDefaultEntity()
	 * @generated
	 */
	int DEFAULT_ENTITY = 41;


	/**
	 * Returns the meta object for class '{@link generator.Bot <em>Bot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bot</em>'.
	 * @see generator.Bot
	 * @generated
	 */
	EClass getBot();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Bot#getIntents <em>Intents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Intents</em>'.
	 * @see generator.Bot#getIntents()
	 * @see #getBot()
	 * @generated
	 */
	EReference getBot_Intents();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Bot#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entities</em>'.
	 * @see generator.Bot#getEntities()
	 * @see #getBot()
	 * @generated
	 */
	EReference getBot_Entities();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Bot#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see generator.Bot#getActions()
	 * @see #getBot()
	 * @generated
	 */
	EReference getBot_Actions();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Bot#getFlows <em>Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Flows</em>'.
	 * @see generator.Bot#getFlows()
	 * @see #getBot()
	 * @generated
	 */
	EReference getBot_Flows();

	/**
	 * Returns the meta object for the attribute list '{@link generator.Bot#getLanguages <em>Languages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Languages</em>'.
	 * @see generator.Bot#getLanguages()
	 * @see #getBot()
	 * @generated
	 */
	EAttribute getBot_Languages();

	/**
	 * Returns the meta object for class '{@link generator.Interaction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction</em>'.
	 * @see generator.Interaction
	 * @generated
	 */
	EClass getInteraction();

	/**
	 * Returns the meta object for class '{@link generator.BotInteraction <em>Bot Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bot Interaction</em>'.
	 * @see generator.BotInteraction
	 * @generated
	 */
	EClass getBotInteraction();

	/**
	 * Returns the meta object for the reference list '{@link generator.BotInteraction#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actions</em>'.
	 * @see generator.BotInteraction#getActions()
	 * @see #getBotInteraction()
	 * @generated
	 */
	EReference getBotInteraction_Actions();

	/**
	 * Returns the meta object for the container reference '{@link generator.BotInteraction#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Incoming</em>'.
	 * @see generator.BotInteraction#getIncoming()
	 * @see #getBotInteraction()
	 * @generated
	 */
	EReference getBotInteraction_Incoming();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.BotInteraction#getOutcoming <em>Outcoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outcoming</em>'.
	 * @see generator.BotInteraction#getOutcoming()
	 * @see #getBotInteraction()
	 * @generated
	 */
	EReference getBotInteraction_Outcoming();

	/**
	 * Returns the meta object for the reference list '{@link generator.BotInteraction#getBackTo <em>Back To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Back To</em>'.
	 * @see generator.BotInteraction#getBackTo()
	 * @see #getBotInteraction()
	 * @generated
	 */
	EReference getBotInteraction_BackTo();

	/**
	 * Returns the meta object for the attribute '{@link generator.BotInteraction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see generator.BotInteraction#getName()
	 * @see #getBotInteraction()
	 * @generated
	 */
	EAttribute getBotInteraction_Name();

	/**
	 * Returns the meta object for class '{@link generator.UserInteraction <em>User Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Interaction</em>'.
	 * @see generator.UserInteraction
	 * @generated
	 */
	EClass getUserInteraction();

	/**
	 * Returns the meta object for the reference '{@link generator.UserInteraction#getIntent <em>Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intent</em>'.
	 * @see generator.UserInteraction#getIntent()
	 * @see #getUserInteraction()
	 * @generated
	 */
	EReference getUserInteraction_Intent();

	/**
	 * Returns the meta object for the container reference '{@link generator.UserInteraction#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Src</em>'.
	 * @see generator.UserInteraction#getSrc()
	 * @see #getUserInteraction()
	 * @generated
	 */
	EReference getUserInteraction_Src();

	/**
	 * Returns the meta object for the containment reference '{@link generator.UserInteraction#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see generator.UserInteraction#getTarget()
	 * @see #getUserInteraction()
	 * @generated
	 */
	EReference getUserInteraction_Target();

	/**
	 * Returns the meta object for the attribute '{@link generator.UserInteraction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see generator.UserInteraction#getName()
	 * @see #getUserInteraction()
	 * @generated
	 */
	EAttribute getUserInteraction_Name();

	/**
	 * Returns the meta object for the containment reference '{@link generator.UserInteraction#getBackTo <em>Back To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Back To</em>'.
	 * @see generator.UserInteraction#getBackTo()
	 * @see #getUserInteraction()
	 * @generated
	 */
	EReference getUserInteraction_BackTo();

	/**
	 * Returns the meta object for class '{@link generator.BackToBot <em>Back To Bot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Back To Bot</em>'.
	 * @see generator.BackToBot
	 * @generated
	 */
	EClass getBackToBot();

	/**
	 * Returns the meta object for the reference list '{@link generator.BackToBot#getPrevious <em>Previous</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Previous</em>'.
	 * @see generator.BackToBot#getPrevious()
	 * @see #getBackToBot()
	 * @generated
	 */
	EReference getBackToBot_Previous();

	/**
	 * Returns the meta object for the reference '{@link generator.BackToBot#getBackTo <em>Back To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Back To</em>'.
	 * @see generator.BackToBot#getBackTo()
	 * @see #getBackToBot()
	 * @generated
	 */
	EReference getBackToBot_BackTo();

	/**
	 * Returns the meta object for class '{@link generator.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see generator.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link generator.Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see generator.Element#getName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the meta object for class '{@link generator.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see generator.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Entity#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see generator.Entity#getInputs()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Inputs();

	/**
	 * Returns the meta object for class '{@link generator.LanguageEntity <em>Language Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Entity</em>'.
	 * @see generator.LanguageEntity
	 * @generated
	 */
	EClass getLanguageEntity();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.LanguageEntity#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see generator.LanguageEntity#getInputs()
	 * @see #getLanguageEntity()
	 * @generated
	 */
	EReference getLanguageEntity_Inputs();

	/**
	 * Returns the meta object for class '{@link generator.LanguageInput <em>Language Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Input</em>'.
	 * @see generator.LanguageInput
	 * @generated
	 */
	EClass getLanguageInput();

	/**
	 * Returns the meta object for the attribute '{@link generator.LanguageInput#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see generator.LanguageInput#getLanguage()
	 * @see #getLanguageInput()
	 * @generated
	 */
	EAttribute getLanguageInput_Language();

	/**
	 * Returns the meta object for class '{@link generator.EntityInput <em>Entity Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Input</em>'.
	 * @see generator.EntityInput
	 * @generated
	 */
	EClass getEntityInput();

	/**
	 * Returns the meta object for class '{@link generator.SimpleInput <em>Simple Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Input</em>'.
	 * @see generator.SimpleInput
	 * @generated
	 */
	EClass getSimpleInput();

	/**
	 * Returns the meta object for the attribute list '{@link generator.SimpleInput#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see generator.SimpleInput#getValues()
	 * @see #getSimpleInput()
	 * @generated
	 */
	EAttribute getSimpleInput_Values();

	/**
	 * Returns the meta object for class '{@link generator.CompositeInput <em>Composite Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Input</em>'.
	 * @see generator.CompositeInput
	 * @generated
	 */
	EClass getCompositeInput();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.CompositeInput#getExpresion <em>Expresion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expresion</em>'.
	 * @see generator.CompositeInput#getExpresion()
	 * @see #getCompositeInput()
	 * @generated
	 */
	EReference getCompositeInput_Expresion();

	/**
	 * Returns the meta object for class '{@link generator.RegexInput <em>Regex Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regex Input</em>'.
	 * @see generator.RegexInput
	 * @generated
	 */
	EClass getRegexInput();

	/**
	 * Returns the meta object for the attribute '{@link generator.RegexInput#getExpresion <em>Expresion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expresion</em>'.
	 * @see generator.RegexInput#getExpresion()
	 * @see #getRegexInput()
	 * @generated
	 */
	EAttribute getRegexInput_Expresion();

	/**
	 * Returns the meta object for class '{@link generator.Input <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input</em>'.
	 * @see generator.Input
	 * @generated
	 */
	EClass getInput();

	/**
	 * Returns the meta object for class '{@link generator.Token <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token</em>'.
	 * @see generator.Token
	 * @generated
	 */
	EClass getToken();

	/**
	 * Returns the meta object for class '{@link generator.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see generator.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for the attribute '{@link generator.Literal#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see generator.Literal#getText()
	 * @see #getLiteral()
	 * @generated
	 */
	EAttribute getLiteral_Text();

	/**
	 * Returns the meta object for class '{@link generator.EntityToken <em>Entity Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Token</em>'.
	 * @see generator.EntityToken
	 * @generated
	 */
	EClass getEntityToken();

	/**
	 * Returns the meta object for the reference '{@link generator.EntityToken#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entity</em>'.
	 * @see generator.EntityToken#getEntity()
	 * @see #getEntityToken()
	 * @generated
	 */
	EReference getEntityToken_Entity();

	/**
	 * Returns the meta object for class '{@link generator.ParameterToken <em>Parameter Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Token</em>'.
	 * @see generator.ParameterToken
	 * @generated
	 */
	EClass getParameterToken();

	/**
	 * Returns the meta object for the reference '{@link generator.ParameterToken#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see generator.ParameterToken#getParameter()
	 * @see #getParameterToken()
	 * @generated
	 */
	EReference getParameterToken_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link generator.ParameterToken#getInfo <em>Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Info</em>'.
	 * @see generator.ParameterToken#getInfo()
	 * @see #getParameterToken()
	 * @generated
	 */
	EAttribute getParameterToken_Info();

	/**
	 * Returns the meta object for class '{@link generator.ParameterReferenceToken <em>Parameter Reference Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Reference Token</em>'.
	 * @see generator.ParameterReferenceToken
	 * @generated
	 */
	EClass getParameterReferenceToken();

	/**
	 * Returns the meta object for the reference '{@link generator.ParameterReferenceToken#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see generator.ParameterReferenceToken#getParameter()
	 * @see #getParameterReferenceToken()
	 * @generated
	 */
	EReference getParameterReferenceToken_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link generator.ParameterReferenceToken#getTextReference <em>Text Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Reference</em>'.
	 * @see generator.ParameterReferenceToken#getTextReference()
	 * @see #getParameterReferenceToken()
	 * @generated
	 */
	EAttribute getParameterReferenceToken_TextReference();

	/**
	 * Returns the meta object for class '{@link generator.HTTPRequestToke <em>HTTP Request Toke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HTTP Request Toke</em>'.
	 * @see generator.HTTPRequestToke
	 * @generated
	 */
	EClass getHTTPRequestToke();

	/**
	 * Returns the meta object for the attribute '{@link generator.HTTPRequestToke#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see generator.HTTPRequestToke#getType()
	 * @see #getHTTPRequestToke()
	 * @generated
	 */
	EAttribute getHTTPRequestToke_Type();

	/**
	 * Returns the meta object for the attribute '{@link generator.HTTPRequestToke#getDataKey <em>Data Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Key</em>'.
	 * @see generator.HTTPRequestToke#getDataKey()
	 * @see #getHTTPRequestToke()
	 * @generated
	 */
	EAttribute getHTTPRequestToke_DataKey();

	/**
	 * Returns the meta object for class '{@link generator.Intent <em>Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intent</em>'.
	 * @see generator.Intent
	 * @generated
	 */
	EClass getIntent();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Intent#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see generator.Intent#getInputs()
	 * @see #getIntent()
	 * @generated
	 */
	EReference getIntent_Inputs();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Intent#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see generator.Intent#getParameters()
	 * @see #getIntent()
	 * @generated
	 */
	EReference getIntent_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link generator.Intent#isFallbackIntent <em>Fallback Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fallback Intent</em>'.
	 * @see generator.Intent#isFallbackIntent()
	 * @see #getIntent()
	 * @generated
	 */
	EAttribute getIntent_FallbackIntent();

	/**
	 * Returns the meta object for class '{@link generator.LanguageIntent <em>Language Intent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Intent</em>'.
	 * @see generator.LanguageIntent
	 * @generated
	 */
	EClass getLanguageIntent();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.LanguageIntent#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see generator.LanguageIntent#getInputs()
	 * @see #getLanguageIntent()
	 * @generated
	 */
	EReference getLanguageIntent_Inputs();

	/**
	 * Returns the meta object for class '{@link generator.TrainingPhrase <em>Training Phrase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Training Phrase</em>'.
	 * @see generator.TrainingPhrase
	 * @generated
	 */
	EClass getTrainingPhrase();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.TrainingPhrase#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tokens</em>'.
	 * @see generator.TrainingPhrase#getTokens()
	 * @see #getTrainingPhrase()
	 * @generated
	 */
	EReference getTrainingPhrase_Tokens();

	/**
	 * Returns the meta object for class '{@link generator.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see generator.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '{@link generator.Parameter#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entity</em>'.
	 * @see generator.Parameter#getEntity()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Entity();

	/**
	 * Returns the meta object for the attribute '{@link generator.Parameter#getDefaultEntity <em>Default Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Entity</em>'.
	 * @see generator.Parameter#getDefaultEntity()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_DefaultEntity();

	/**
	 * Returns the meta object for the attribute '{@link generator.Parameter#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see generator.Parameter#isRequired()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Required();

	/**
	 * Returns the meta object for the attribute '{@link generator.Parameter#isIsList <em>Is List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is List</em>'.
	 * @see generator.Parameter#isIsList()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_IsList();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Parameter#getPrompts <em>Prompts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Prompts</em>'.
	 * @see generator.Parameter#getPrompts()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Prompts();

	/**
	 * Returns the meta object for class '{@link generator.LanguagePrompt <em>Language Prompt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Prompt</em>'.
	 * @see generator.LanguagePrompt
	 * @generated
	 */
	EClass getLanguagePrompt();

	/**
	 * Returns the meta object for the attribute list '{@link generator.LanguagePrompt#getPrompts <em>Prompts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Prompts</em>'.
	 * @see generator.LanguagePrompt#getPrompts()
	 * @see #getLanguagePrompt()
	 * @generated
	 */
	EAttribute getLanguagePrompt_Prompts();

	/**
	 * Returns the meta object for class '{@link generator.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see generator.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link generator.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see generator.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for the attribute '{@link generator.Image#getURL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URL</em>'.
	 * @see generator.Image#getURL()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_URL();

	/**
	 * Returns the meta object for the attribute '{@link generator.Image#getCaption <em>Caption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caption</em>'.
	 * @see generator.Image#getCaption()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Caption();

	/**
	 * Returns the meta object for class '{@link generator.Empty <em>Empty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Empty</em>'.
	 * @see generator.Empty
	 * @generated
	 */
	EClass getEmpty();

	/**
	 * Returns the meta object for the attribute '{@link generator.Empty#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see generator.Empty#getDescription()
	 * @see #getEmpty()
	 * @generated
	 */
	EAttribute getEmpty_Description();

	/**
	 * Returns the meta object for class '{@link generator.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see generator.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.Text#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see generator.Text#getInputs()
	 * @see #getText()
	 * @generated
	 */
	EReference getText_Inputs();

	/**
	 * Returns the meta object for class '{@link generator.ButtonAction <em>Button Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Button Action</em>'.
	 * @see generator.ButtonAction
	 * @generated
	 */
	EClass getButtonAction();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.ButtonAction#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see generator.ButtonAction#getInputs()
	 * @see #getButtonAction()
	 * @generated
	 */
	EReference getButtonAction_Inputs();

	/**
	 * Returns the meta object for class '{@link generator.LanguageButton <em>Language Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Button</em>'.
	 * @see generator.LanguageButton
	 * @generated
	 */
	EClass getLanguageButton();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.LanguageButton#getButtons <em>Buttons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Buttons</em>'.
	 * @see generator.LanguageButton#getButtons()
	 * @see #getLanguageButton()
	 * @generated
	 */
	EReference getLanguageButton_Buttons();

	/**
	 * Returns the meta object for class '{@link generator.Button <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Button</em>'.
	 * @see generator.Button
	 * @generated
	 */
	EClass getButton();

	/**
	 * Returns the meta object for the attribute '{@link generator.Button#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see generator.Button#getValue()
	 * @see #getButton()
	 * @generated
	 */
	EAttribute getButton_Value();

	/**
	 * Returns the meta object for the attribute '{@link generator.Button#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see generator.Button#getAction()
	 * @see #getButton()
	 * @generated
	 */
	EAttribute getButton_Action();

	/**
	 * Returns the meta object for class '{@link generator.LanguageText <em>Language Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Text</em>'.
	 * @see generator.LanguageText
	 * @generated
	 */
	EClass getLanguageText();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.LanguageText#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see generator.LanguageText#getInputs()
	 * @see #getLanguageText()
	 * @generated
	 */
	EReference getLanguageText_Inputs();

	/**
	 * Returns the meta object for class '{@link generator.TextInput <em>Text Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Input</em>'.
	 * @see generator.TextInput
	 * @generated
	 */
	EClass getTextInput();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.TextInput#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tokens</em>'.
	 * @see generator.TextInput#getTokens()
	 * @see #getTextInput()
	 * @generated
	 */
	EReference getTextInput_Tokens();

	/**
	 * Returns the meta object for class '{@link generator.HTTPRequest <em>HTTP Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HTTP Request</em>'.
	 * @see generator.HTTPRequest
	 * @generated
	 */
	EClass getHTTPRequest();

	/**
	 * Returns the meta object for the attribute '{@link generator.HTTPRequest#getURL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URL</em>'.
	 * @see generator.HTTPRequest#getURL()
	 * @see #getHTTPRequest()
	 * @generated
	 */
	EAttribute getHTTPRequest_URL();

	/**
	 * Returns the meta object for the containment reference '{@link generator.HTTPRequest#getBasicAuth <em>Basic Auth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Basic Auth</em>'.
	 * @see generator.HTTPRequest#getBasicAuth()
	 * @see #getHTTPRequest()
	 * @generated
	 */
	EReference getHTTPRequest_BasicAuth();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.HTTPRequest#getHeaders <em>Headers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Headers</em>'.
	 * @see generator.HTTPRequest#getHeaders()
	 * @see #getHTTPRequest()
	 * @generated
	 */
	EReference getHTTPRequest_Headers();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.HTTPRequest#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data</em>'.
	 * @see generator.HTTPRequest#getData()
	 * @see #getHTTPRequest()
	 * @generated
	 */
	EReference getHTTPRequest_Data();

	/**
	 * Returns the meta object for the attribute '{@link generator.HTTPRequest#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see generator.HTTPRequest#getDataType()
	 * @see #getHTTPRequest()
	 * @generated
	 */
	EAttribute getHTTPRequest_DataType();

	/**
	 * Returns the meta object for the attribute '{@link generator.HTTPRequest#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method</em>'.
	 * @see generator.HTTPRequest#getMethod()
	 * @see #getHTTPRequest()
	 * @generated
	 */
	EAttribute getHTTPRequest_Method();

	/**
	 * Returns the meta object for class '{@link generator.HTTPResponse <em>HTTP Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HTTP Response</em>'.
	 * @see generator.HTTPResponse
	 * @generated
	 */
	EClass getHTTPResponse();

	/**
	 * Returns the meta object for the containment reference list '{@link generator.HTTPResponse#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see generator.HTTPResponse#getInputs()
	 * @see #getHTTPResponse()
	 * @generated
	 */
	EReference getHTTPResponse_Inputs();

	/**
	 * Returns the meta object for the reference '{@link generator.HTTPResponse#getHTTPRequest <em>HTTP Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>HTTP Request</em>'.
	 * @see generator.HTTPResponse#getHTTPRequest()
	 * @see #getHTTPResponse()
	 * @generated
	 */
	EReference getHTTPResponse_HTTPRequest();

	/**
	 * Returns the meta object for class '{@link generator.KeyValue <em>Key Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Value</em>'.
	 * @see generator.KeyValue
	 * @generated
	 */
	EClass getKeyValue();

	/**
	 * Returns the meta object for the attribute '{@link generator.KeyValue#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see generator.KeyValue#getKey()
	 * @see #getKeyValue()
	 * @generated
	 */
	EAttribute getKeyValue_Key();

	/**
	 * Returns the meta object for the containment reference '{@link generator.KeyValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see generator.KeyValue#getValue()
	 * @see #getKeyValue()
	 * @generated
	 */
	EReference getKeyValue_Value();

	/**
	 * Returns the meta object for enum '{@link generator.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Type</em>'.
	 * @see generator.DataType
	 * @generated
	 */
	EEnum getDataType();

	/**
	 * Returns the meta object for enum '{@link generator.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Method</em>'.
	 * @see generator.Method
	 * @generated
	 */
	EEnum getMethod();

	/**
	 * Returns the meta object for enum '{@link generator.Language <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Language</em>'.
	 * @see generator.Language
	 * @generated
	 */
	EEnum getLanguage();

	/**
	 * Returns the meta object for enum '{@link generator.HTTPReturnType <em>HTTP Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>HTTP Return Type</em>'.
	 * @see generator.HTTPReturnType
	 * @generated
	 */
	EEnum getHTTPReturnType();

	/**
	 * Returns the meta object for enum '{@link generator.DefaultEntity <em>Default Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Default Entity</em>'.
	 * @see generator.DefaultEntity
	 * @generated
	 */
	EEnum getDefaultEntity();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeneratorFactory getGeneratorFactory();

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
		 * The meta object literal for the '{@link generator.impl.BotImpl <em>Bot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.BotImpl
		 * @see generator.impl.GeneratorPackageImpl#getBot()
		 * @generated
		 */
		EClass BOT = eINSTANCE.getBot();

		/**
		 * The meta object literal for the '<em><b>Intents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT__INTENTS = eINSTANCE.getBot_Intents();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT__ENTITIES = eINSTANCE.getBot_Entities();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT__ACTIONS = eINSTANCE.getBot_Actions();

		/**
		 * The meta object literal for the '<em><b>Flows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT__FLOWS = eINSTANCE.getBot_Flows();

		/**
		 * The meta object literal for the '<em><b>Languages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOT__LANGUAGES = eINSTANCE.getBot_Languages();

		/**
		 * The meta object literal for the '{@link generator.impl.InteractionImpl <em>Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.InteractionImpl
		 * @see generator.impl.GeneratorPackageImpl#getInteraction()
		 * @generated
		 */
		EClass INTERACTION = eINSTANCE.getInteraction();

		/**
		 * The meta object literal for the '{@link generator.impl.BotInteractionImpl <em>Bot Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.BotInteractionImpl
		 * @see generator.impl.GeneratorPackageImpl#getBotInteraction()
		 * @generated
		 */
		EClass BOT_INTERACTION = eINSTANCE.getBotInteraction();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT_INTERACTION__ACTIONS = eINSTANCE.getBotInteraction_Actions();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT_INTERACTION__INCOMING = eINSTANCE.getBotInteraction_Incoming();

		/**
		 * The meta object literal for the '<em><b>Outcoming</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT_INTERACTION__OUTCOMING = eINSTANCE.getBotInteraction_Outcoming();

		/**
		 * The meta object literal for the '<em><b>Back To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOT_INTERACTION__BACK_TO = eINSTANCE.getBotInteraction_BackTo();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOT_INTERACTION__NAME = eINSTANCE.getBotInteraction_Name();

		/**
		 * The meta object literal for the '{@link generator.impl.UserInteractionImpl <em>User Interaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.UserInteractionImpl
		 * @see generator.impl.GeneratorPackageImpl#getUserInteraction()
		 * @generated
		 */
		EClass USER_INTERACTION = eINSTANCE.getUserInteraction();

		/**
		 * The meta object literal for the '<em><b>Intent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERACTION__INTENT = eINSTANCE.getUserInteraction_Intent();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERACTION__SRC = eINSTANCE.getUserInteraction_Src();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERACTION__TARGET = eINSTANCE.getUserInteraction_Target();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_INTERACTION__NAME = eINSTANCE.getUserInteraction_Name();

		/**
		 * The meta object literal for the '<em><b>Back To</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERACTION__BACK_TO = eINSTANCE.getUserInteraction_BackTo();

		/**
		 * The meta object literal for the '{@link generator.impl.BackToBotImpl <em>Back To Bot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.BackToBotImpl
		 * @see generator.impl.GeneratorPackageImpl#getBackToBot()
		 * @generated
		 */
		EClass BACK_TO_BOT = eINSTANCE.getBackToBot();

		/**
		 * The meta object literal for the '<em><b>Previous</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BACK_TO_BOT__PREVIOUS = eINSTANCE.getBackToBot_Previous();

		/**
		 * The meta object literal for the '<em><b>Back To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BACK_TO_BOT__BACK_TO = eINSTANCE.getBackToBot_BackTo();

		/**
		 * The meta object literal for the '{@link generator.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.ElementImpl
		 * @see generator.impl.GeneratorPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

		/**
		 * The meta object literal for the '{@link generator.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.EntityImpl
		 * @see generator.impl.GeneratorPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__INPUTS = eINSTANCE.getEntity_Inputs();

		/**
		 * The meta object literal for the '{@link generator.impl.LanguageEntityImpl <em>Language Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.LanguageEntityImpl
		 * @see generator.impl.GeneratorPackageImpl#getLanguageEntity()
		 * @generated
		 */
		EClass LANGUAGE_ENTITY = eINSTANCE.getLanguageEntity();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_ENTITY__INPUTS = eINSTANCE.getLanguageEntity_Inputs();

		/**
		 * The meta object literal for the '{@link generator.impl.LanguageInputImpl <em>Language Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.LanguageInputImpl
		 * @see generator.impl.GeneratorPackageImpl#getLanguageInput()
		 * @generated
		 */
		EClass LANGUAGE_INPUT = eINSTANCE.getLanguageInput();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LANGUAGE_INPUT__LANGUAGE = eINSTANCE.getLanguageInput_Language();

		/**
		 * The meta object literal for the '{@link generator.impl.EntityInputImpl <em>Entity Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.EntityInputImpl
		 * @see generator.impl.GeneratorPackageImpl#getEntityInput()
		 * @generated
		 */
		EClass ENTITY_INPUT = eINSTANCE.getEntityInput();

		/**
		 * The meta object literal for the '{@link generator.impl.SimpleInputImpl <em>Simple Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.SimpleInputImpl
		 * @see generator.impl.GeneratorPackageImpl#getSimpleInput()
		 * @generated
		 */
		EClass SIMPLE_INPUT = eINSTANCE.getSimpleInput();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_INPUT__VALUES = eINSTANCE.getSimpleInput_Values();

		/**
		 * The meta object literal for the '{@link generator.impl.CompositeInputImpl <em>Composite Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.CompositeInputImpl
		 * @see generator.impl.GeneratorPackageImpl#getCompositeInput()
		 * @generated
		 */
		EClass COMPOSITE_INPUT = eINSTANCE.getCompositeInput();

		/**
		 * The meta object literal for the '<em><b>Expresion</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_INPUT__EXPRESION = eINSTANCE.getCompositeInput_Expresion();

		/**
		 * The meta object literal for the '{@link generator.impl.RegexInputImpl <em>Regex Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.RegexInputImpl
		 * @see generator.impl.GeneratorPackageImpl#getRegexInput()
		 * @generated
		 */
		EClass REGEX_INPUT = eINSTANCE.getRegexInput();

		/**
		 * The meta object literal for the '<em><b>Expresion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGEX_INPUT__EXPRESION = eINSTANCE.getRegexInput_Expresion();

		/**
		 * The meta object literal for the '{@link generator.impl.InputImpl <em>Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.InputImpl
		 * @see generator.impl.GeneratorPackageImpl#getInput()
		 * @generated
		 */
		EClass INPUT = eINSTANCE.getInput();

		/**
		 * The meta object literal for the '{@link generator.impl.TokenImpl <em>Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.TokenImpl
		 * @see generator.impl.GeneratorPackageImpl#getToken()
		 * @generated
		 */
		EClass TOKEN = eINSTANCE.getToken();

		/**
		 * The meta object literal for the '{@link generator.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.LiteralImpl
		 * @see generator.impl.GeneratorPackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL__TEXT = eINSTANCE.getLiteral_Text();

		/**
		 * The meta object literal for the '{@link generator.impl.EntityTokenImpl <em>Entity Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.EntityTokenImpl
		 * @see generator.impl.GeneratorPackageImpl#getEntityToken()
		 * @generated
		 */
		EClass ENTITY_TOKEN = eINSTANCE.getEntityToken();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_TOKEN__ENTITY = eINSTANCE.getEntityToken_Entity();

		/**
		 * The meta object literal for the '{@link generator.impl.ParameterTokenImpl <em>Parameter Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.ParameterTokenImpl
		 * @see generator.impl.GeneratorPackageImpl#getParameterToken()
		 * @generated
		 */
		EClass PARAMETER_TOKEN = eINSTANCE.getParameterToken();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_TOKEN__PARAMETER = eINSTANCE.getParameterToken_Parameter();

		/**
		 * The meta object literal for the '<em><b>Info</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_TOKEN__INFO = eINSTANCE.getParameterToken_Info();

		/**
		 * The meta object literal for the '{@link generator.impl.ParameterReferenceTokenImpl <em>Parameter Reference Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.ParameterReferenceTokenImpl
		 * @see generator.impl.GeneratorPackageImpl#getParameterReferenceToken()
		 * @generated
		 */
		EClass PARAMETER_REFERENCE_TOKEN = eINSTANCE.getParameterReferenceToken();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_REFERENCE_TOKEN__PARAMETER = eINSTANCE.getParameterReferenceToken_Parameter();

		/**
		 * The meta object literal for the '<em><b>Text Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_REFERENCE_TOKEN__TEXT_REFERENCE = eINSTANCE.getParameterReferenceToken_TextReference();

		/**
		 * The meta object literal for the '{@link generator.impl.HTTPRequestTokeImpl <em>HTTP Request Toke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.HTTPRequestTokeImpl
		 * @see generator.impl.GeneratorPackageImpl#getHTTPRequestToke()
		 * @generated
		 */
		EClass HTTP_REQUEST_TOKE = eINSTANCE.getHTTPRequestToke();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HTTP_REQUEST_TOKE__TYPE = eINSTANCE.getHTTPRequestToke_Type();

		/**
		 * The meta object literal for the '<em><b>Data Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HTTP_REQUEST_TOKE__DATA_KEY = eINSTANCE.getHTTPRequestToke_DataKey();

		/**
		 * The meta object literal for the '{@link generator.impl.IntentImpl <em>Intent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.IntentImpl
		 * @see generator.impl.GeneratorPackageImpl#getIntent()
		 * @generated
		 */
		EClass INTENT = eINSTANCE.getIntent();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT__INPUTS = eINSTANCE.getIntent_Inputs();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTENT__PARAMETERS = eINSTANCE.getIntent_Parameters();

		/**
		 * The meta object literal for the '<em><b>Fallback Intent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTENT__FALLBACK_INTENT = eINSTANCE.getIntent_FallbackIntent();

		/**
		 * The meta object literal for the '{@link generator.impl.LanguageIntentImpl <em>Language Intent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.LanguageIntentImpl
		 * @see generator.impl.GeneratorPackageImpl#getLanguageIntent()
		 * @generated
		 */
		EClass LANGUAGE_INTENT = eINSTANCE.getLanguageIntent();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_INTENT__INPUTS = eINSTANCE.getLanguageIntent_Inputs();

		/**
		 * The meta object literal for the '{@link generator.impl.TrainingPhraseImpl <em>Training Phrase</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.TrainingPhraseImpl
		 * @see generator.impl.GeneratorPackageImpl#getTrainingPhrase()
		 * @generated
		 */
		EClass TRAINING_PHRASE = eINSTANCE.getTrainingPhrase();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRAINING_PHRASE__TOKENS = eINSTANCE.getTrainingPhrase_Tokens();

		/**
		 * The meta object literal for the '{@link generator.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.ParameterImpl
		 * @see generator.impl.GeneratorPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__ENTITY = eINSTANCE.getParameter_Entity();

		/**
		 * The meta object literal for the '<em><b>Default Entity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__DEFAULT_ENTITY = eINSTANCE.getParameter_DefaultEntity();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__REQUIRED = eINSTANCE.getParameter_Required();

		/**
		 * The meta object literal for the '<em><b>Is List</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__IS_LIST = eINSTANCE.getParameter_IsList();

		/**
		 * The meta object literal for the '<em><b>Prompts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__PROMPTS = eINSTANCE.getParameter_Prompts();

		/**
		 * The meta object literal for the '{@link generator.impl.LanguagePromptImpl <em>Language Prompt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.LanguagePromptImpl
		 * @see generator.impl.GeneratorPackageImpl#getLanguagePrompt()
		 * @generated
		 */
		EClass LANGUAGE_PROMPT = eINSTANCE.getLanguagePrompt();

		/**
		 * The meta object literal for the '<em><b>Prompts</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LANGUAGE_PROMPT__PROMPTS = eINSTANCE.getLanguagePrompt_Prompts();

		/**
		 * The meta object literal for the '{@link generator.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.ActionImpl
		 * @see generator.impl.GeneratorPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link generator.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.ImageImpl
		 * @see generator.impl.GeneratorPackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__URL = eINSTANCE.getImage_URL();

		/**
		 * The meta object literal for the '<em><b>Caption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__CAPTION = eINSTANCE.getImage_Caption();

		/**
		 * The meta object literal for the '{@link generator.impl.EmptyImpl <em>Empty</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.EmptyImpl
		 * @see generator.impl.GeneratorPackageImpl#getEmpty()
		 * @generated
		 */
		EClass EMPTY = eINSTANCE.getEmpty();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPTY__DESCRIPTION = eINSTANCE.getEmpty_Description();

		/**
		 * The meta object literal for the '{@link generator.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.TextImpl
		 * @see generator.impl.GeneratorPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT__INPUTS = eINSTANCE.getText_Inputs();

		/**
		 * The meta object literal for the '{@link generator.impl.ButtonActionImpl <em>Button Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.ButtonActionImpl
		 * @see generator.impl.GeneratorPackageImpl#getButtonAction()
		 * @generated
		 */
		EClass BUTTON_ACTION = eINSTANCE.getButtonAction();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUTTON_ACTION__INPUTS = eINSTANCE.getButtonAction_Inputs();

		/**
		 * The meta object literal for the '{@link generator.impl.LanguageButtonImpl <em>Language Button</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.LanguageButtonImpl
		 * @see generator.impl.GeneratorPackageImpl#getLanguageButton()
		 * @generated
		 */
		EClass LANGUAGE_BUTTON = eINSTANCE.getLanguageButton();

		/**
		 * The meta object literal for the '<em><b>Buttons</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_BUTTON__BUTTONS = eINSTANCE.getLanguageButton_Buttons();

		/**
		 * The meta object literal for the '{@link generator.impl.ButtonImpl <em>Button</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.ButtonImpl
		 * @see generator.impl.GeneratorPackageImpl#getButton()
		 * @generated
		 */
		EClass BUTTON = eINSTANCE.getButton();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUTTON__VALUE = eINSTANCE.getButton_Value();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUTTON__ACTION = eINSTANCE.getButton_Action();

		/**
		 * The meta object literal for the '{@link generator.impl.LanguageTextImpl <em>Language Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.LanguageTextImpl
		 * @see generator.impl.GeneratorPackageImpl#getLanguageText()
		 * @generated
		 */
		EClass LANGUAGE_TEXT = eINSTANCE.getLanguageText();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_TEXT__INPUTS = eINSTANCE.getLanguageText_Inputs();

		/**
		 * The meta object literal for the '{@link generator.impl.TextInputImpl <em>Text Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.TextInputImpl
		 * @see generator.impl.GeneratorPackageImpl#getTextInput()
		 * @generated
		 */
		EClass TEXT_INPUT = eINSTANCE.getTextInput();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT_INPUT__TOKENS = eINSTANCE.getTextInput_Tokens();

		/**
		 * The meta object literal for the '{@link generator.impl.HTTPRequestImpl <em>HTTP Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.HTTPRequestImpl
		 * @see generator.impl.GeneratorPackageImpl#getHTTPRequest()
		 * @generated
		 */
		EClass HTTP_REQUEST = eINSTANCE.getHTTPRequest();

		/**
		 * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HTTP_REQUEST__URL = eINSTANCE.getHTTPRequest_URL();

		/**
		 * The meta object literal for the '<em><b>Basic Auth</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HTTP_REQUEST__BASIC_AUTH = eINSTANCE.getHTTPRequest_BasicAuth();

		/**
		 * The meta object literal for the '<em><b>Headers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HTTP_REQUEST__HEADERS = eINSTANCE.getHTTPRequest_Headers();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HTTP_REQUEST__DATA = eINSTANCE.getHTTPRequest_Data();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HTTP_REQUEST__DATA_TYPE = eINSTANCE.getHTTPRequest_DataType();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HTTP_REQUEST__METHOD = eINSTANCE.getHTTPRequest_Method();

		/**
		 * The meta object literal for the '{@link generator.impl.HTTPResponseImpl <em>HTTP Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.HTTPResponseImpl
		 * @see generator.impl.GeneratorPackageImpl#getHTTPResponse()
		 * @generated
		 */
		EClass HTTP_RESPONSE = eINSTANCE.getHTTPResponse();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HTTP_RESPONSE__INPUTS = eINSTANCE.getHTTPResponse_Inputs();

		/**
		 * The meta object literal for the '<em><b>HTTP Request</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HTTP_RESPONSE__HTTP_REQUEST = eINSTANCE.getHTTPResponse_HTTPRequest();

		/**
		 * The meta object literal for the '{@link generator.impl.KeyValueImpl <em>Key Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.impl.KeyValueImpl
		 * @see generator.impl.GeneratorPackageImpl#getKeyValue()
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
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_VALUE__VALUE = eINSTANCE.getKeyValue_Value();

		/**
		 * The meta object literal for the '{@link generator.DataType <em>Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.DataType
		 * @see generator.impl.GeneratorPackageImpl#getDataType()
		 * @generated
		 */
		EEnum DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link generator.Method <em>Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.Method
		 * @see generator.impl.GeneratorPackageImpl#getMethod()
		 * @generated
		 */
		EEnum METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '{@link generator.Language <em>Language</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.Language
		 * @see generator.impl.GeneratorPackageImpl#getLanguage()
		 * @generated
		 */
		EEnum LANGUAGE = eINSTANCE.getLanguage();

		/**
		 * The meta object literal for the '{@link generator.HTTPReturnType <em>HTTP Return Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.HTTPReturnType
		 * @see generator.impl.GeneratorPackageImpl#getHTTPReturnType()
		 * @generated
		 */
		EEnum HTTP_RETURN_TYPE = eINSTANCE.getHTTPReturnType();

		/**
		 * The meta object literal for the '{@link generator.DefaultEntity <em>Default Entity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see generator.DefaultEntity
		 * @see generator.impl.GeneratorPackageImpl#getDefaultEntity()
		 * @generated
		 */
		EEnum DEFAULT_ENTITY = eINSTANCE.getDefaultEntity();

	}

} //GeneratorPackage

/**
 */
package recommenderQuestionnaire.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import recommenderQuestionnaire.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage
 * @generated
 */
public class RecommenderQuestionnaireValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final RecommenderQuestionnaireValidator INSTANCE = new RecommenderQuestionnaireValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "recommenderQuestionnaire";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommenderQuestionnaireValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return RecommenderQuestionnairePackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case RecommenderQuestionnairePackage.QUESTIONNAIRE:
				return validateQuestionnaire((Questionnaire)value, diagnostics, context);
			case RecommenderQuestionnairePackage.TOOL:
				return validateTool((Tool)value, diagnostics, context);
			case RecommenderQuestionnairePackage.QUESTION:
				return validateQuestion((Question)value, diagnostics, context);
			case RecommenderQuestionnairePackage.EVALUATION:
				return validateEvaluation((Evaluation)value, diagnostics, context);
			case RecommenderQuestionnairePackage.OPTION:
				return validateOption((Option)value, diagnostics, context);
			case RecommenderQuestionnairePackage.WITH_NAME:
				return validateWithName((WithName)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQuestionnaire(Questionnaire questionnaire, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(questionnaire, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTool(Tool tool, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tool, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQuestion(Question question, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(question, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEvaluation(Evaluation evaluation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(evaluation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOption(Option option, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(option, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(option, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(option, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(option, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(option, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(option, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(option, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(option, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(option, diagnostics, context);
		if (result || diagnostics != null) result &= validateOption_allToolsRegister(option, diagnostics, context);
		if (result || diagnostics != null) result &= validateOption_toolInAvailableAndUnavailable(option, diagnostics, context);
		if (result || diagnostics != null) result &= validateOption_toolInAvailableAndPossible(option, diagnostics, context);
		if (result || diagnostics != null) result &= validateOption_toolInAvailableAndUnkown(option, diagnostics, context);
		if (result || diagnostics != null) result &= validateOption_toolInUnavailableAndUnknown(option, diagnostics, context);
		if (result || diagnostics != null) result &= validateOption_toolInUnavailableAndPossible(option, diagnostics, context);
		if (result || diagnostics != null) result &= validateOption_toolInPossibleAndUnknown(option, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the allToolsRegister constraint of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String OPTION__ALL_TOOLS_REGISTER__EEXPRESSION = "Tool.allInstances()->forAll(t |\n" +
		"\t\t\t\tself.available->includes(t) or self.unavailable->includes(t) or self.unknown->includes(t) or self.possible->includes(t))";

	/**
	 * Validates the allToolsRegister constraint of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOption_allToolsRegister(Option option, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RecommenderQuestionnairePackage.Literals.OPTION,
				 option,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "allToolsRegister",
				 OPTION__ALL_TOOLS_REGISTER__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the toolInAvailableAndUnavailable constraint of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String OPTION__TOOL_IN_AVAILABLE_AND_UNAVAILABLE__EEXPRESSION = "Tool.allInstances()->forAll(t | self.available->includes(t) implies not\n" +
		"\t\t\t\tself.unavailable->includes(t))";

	/**
	 * Validates the toolInAvailableAndUnavailable constraint of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOption_toolInAvailableAndUnavailable(Option option, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RecommenderQuestionnairePackage.Literals.OPTION,
				 option,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "toolInAvailableAndUnavailable",
				 OPTION__TOOL_IN_AVAILABLE_AND_UNAVAILABLE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the toolInAvailableAndPossible constraint of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String OPTION__TOOL_IN_AVAILABLE_AND_POSSIBLE__EEXPRESSION = "Tool.allInstances()->forAll(t | self.available->includes(t) implies not\n" +
		"\t\t\t\tself.possible->includes(t))";

	/**
	 * Validates the toolInAvailableAndPossible constraint of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOption_toolInAvailableAndPossible(Option option, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RecommenderQuestionnairePackage.Literals.OPTION,
				 option,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "toolInAvailableAndPossible",
				 OPTION__TOOL_IN_AVAILABLE_AND_POSSIBLE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the toolInAvailableAndUnkown constraint of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String OPTION__TOOL_IN_AVAILABLE_AND_UNKOWN__EEXPRESSION = "Tool.allInstances()->forAll(t | self.available->includes(t) implies not\n" +
		"\t\t\t\tself.unknown->includes(t))";

	/**
	 * Validates the toolInAvailableAndUnkown constraint of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOption_toolInAvailableAndUnkown(Option option, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RecommenderQuestionnairePackage.Literals.OPTION,
				 option,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "toolInAvailableAndUnkown",
				 OPTION__TOOL_IN_AVAILABLE_AND_UNKOWN__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the toolInUnavailableAndUnknown constraint of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String OPTION__TOOL_IN_UNAVAILABLE_AND_UNKNOWN__EEXPRESSION = "Tool.allInstances()->forAll(t | self.unavailable->includes(t) implies not\n" +
		"\t\t\t\tself.unknown->includes(t))";

	/**
	 * Validates the toolInUnavailableAndUnknown constraint of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOption_toolInUnavailableAndUnknown(Option option, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RecommenderQuestionnairePackage.Literals.OPTION,
				 option,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "toolInUnavailableAndUnknown",
				 OPTION__TOOL_IN_UNAVAILABLE_AND_UNKNOWN__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the toolInUnavailableAndPossible constraint of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String OPTION__TOOL_IN_UNAVAILABLE_AND_POSSIBLE__EEXPRESSION = "Tool.allInstances()->forAll(t | self.unavailable->includes(t) implies not\n" +
		"\t\t\t\tself.possible->includes(t))";

	/**
	 * Validates the toolInUnavailableAndPossible constraint of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOption_toolInUnavailableAndPossible(Option option, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RecommenderQuestionnairePackage.Literals.OPTION,
				 option,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "toolInUnavailableAndPossible",
				 OPTION__TOOL_IN_UNAVAILABLE_AND_POSSIBLE__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the toolInPossibleAndUnknown constraint of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String OPTION__TOOL_IN_POSSIBLE_AND_UNKNOWN__EEXPRESSION = "Tool.allInstances()->forAll(t | self.possible->includes(t) implies not\n" +
		"\t\t\t\tself.unknown->includes(t))";

	/**
	 * Validates the toolInPossibleAndUnknown constraint of '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOption_toolInPossibleAndUnknown(Option option, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(RecommenderQuestionnairePackage.Literals.OPTION,
				 option,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "toolInPossibleAndUnknown",
				 OPTION__TOOL_IN_POSSIBLE_AND_UNKNOWN__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWithName(WithName withName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(withName, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //RecommenderQuestionnaireValidator

/**
 */
package recommenderQuestionnaire;

import java.util.List;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import recommenderQuestionnaire.evaluations.Evaluator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Questionnaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.Questionnaire#getTools <em>Tools</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Questionnaire#getQuestions <em>Questions</em>}</li>
 * </ul>
 *
 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getQuestionnaire()
 * @model
 * @generated
 */
public interface Questionnaire extends EObject {
	/**
	 * Returns the value of the '<em><b>Tools</b></em>' containment reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Tool}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tools</em>' containment reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getQuestionnaire_Tools()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Tool> getTools();

	/**
	 * Returns the value of the '<em><b>Questions</b></em>' containment reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Question}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Questions</em>' containment reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getQuestionnaire_Questions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Question> getQuestions();

	Question getQuestion(String questionName);

	Evaluation getEvaluation(String name);

	Tool createTool(String tool);

	Evaluation createEvaluation(String name, String text, boolean multiresponse, List<String> options,
			//Map<String, List<String>> accepted, Map<String, List<String>> refused,Map<String, List<String>> opt_tools_possible, 
			Evaluator ev);

	List<Evaluation> getEvaluations();
	List<Question> getNOTEvaluations();

	Tool getTool(String string);

} // Questionnaire

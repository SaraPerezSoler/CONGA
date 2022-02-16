/**
 */
package recommenderQuestionnaire;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.Tool#getAvailableOptions <em>Available Options</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Tool#getUnknownOptions <em>Unknown Options</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Tool#getUnavailableOptions <em>Unavailable Options</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Tool#getPossibleOptions <em>Possible Options</em>}</li>
 * </ul>
 *
 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getTool()
 * @model
 * @generated
 */
public interface Tool extends WithName {
	/**
	 * Returns the value of the '<em><b>Available Options</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Option}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Option#getAvailable <em>Available</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Options</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getTool_AvailableOptions()
	 * @see recommenderQuestionnaire.Option#getAvailable
	 * @model opposite="available" required="true"
	 * @generated
	 */
	EList<Option> getAvailableOptions();

	/**
	 * Returns the value of the '<em><b>Unknown Options</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Option}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Option#getUnknown <em>Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unknown Options</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getTool_UnknownOptions()
	 * @see recommenderQuestionnaire.Option#getUnknown
	 * @model opposite="unknown"
	 * @generated
	 */
	EList<Option> getUnknownOptions();

	/**
	 * Returns the value of the '<em><b>Unavailable Options</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Option}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Option#getUnavailable <em>Unavailable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unavailable Options</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getTool_UnavailableOptions()
	 * @see recommenderQuestionnaire.Option#getUnavailable
	 * @model opposite="unavailable"
	 * @generated
	 */
	EList<Option> getUnavailableOptions();

	/**
	 * Returns the value of the '<em><b>Possible Options</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Option}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Option#getPossible <em>Possible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possible Options</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getTool_PossibleOptions()
	 * @see recommenderQuestionnaire.Option#getPossible
	 * @model opposite="possible"
	 * @generated
	 */
	EList<Option> getPossibleOptions();

} // Tool

/**
 */
package recommenderQuestionnaire;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.Option#getText <em>Text</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Option#getAvailable <em>Available</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Option#getUnavailable <em>Unavailable</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Option#getUnknown <em>Unknown</em>}</li>
 *   <li>{@link recommenderQuestionnaire.Option#getPossible <em>Possible</em>}</li>
 * </ul>
 *
 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getOption()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='allToolsRegister toolInAvailableAndUnavailable toolInAvailableAndPossible toolInAvailableAndUnkown toolInUnavailableAndUnknown toolInUnavailableAndPossible toolInPossibleAndUnknown'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot allToolsRegister='Tool.allInstances()-&gt;forAll(t |\n\t\t\t\tself.available-&gt;includes(t) or self.unavailable-&gt;includes(t) or self.unknown-&gt;includes(t) or self.possible-&gt;includes(t))' toolInAvailableAndUnavailable='Tool.allInstances()-&gt;forAll(t | self.available-&gt;includes(t) implies not\n\t\t\t\tself.unavailable-&gt;includes(t))' toolInAvailableAndPossible='Tool.allInstances()-&gt;forAll(t | self.available-&gt;includes(t) implies not\n\t\t\t\tself.possible-&gt;includes(t))' toolInAvailableAndUnkown='Tool.allInstances()-&gt;forAll(t | self.available-&gt;includes(t) implies not\n\t\t\t\tself.unknown-&gt;includes(t))' toolInUnavailableAndUnknown='Tool.allInstances()-&gt;forAll(t | self.unavailable-&gt;includes(t) implies not\n\t\t\t\tself.unknown-&gt;includes(t))' toolInUnavailableAndPossible='Tool.allInstances()-&gt;forAll(t | self.unavailable-&gt;includes(t) implies not\n\t\t\t\tself.possible-&gt;includes(t))' toolInPossibleAndUnknown='Tool.allInstances()-&gt;forAll(t | self.possible-&gt;includes(t) implies not\n\t\t\t\tself.unknown-&gt;includes(t))'"
 * @generated
 */
public interface Option extends EObject {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getOption_Text()
	 * @model required="true"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link recommenderQuestionnaire.Option#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Available</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Tool}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Tool#getAvailableOptions <em>Available Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getOption_Available()
	 * @see recommenderQuestionnaire.Tool#getAvailableOptions
	 * @model opposite="availableOptions" required="true"
	 * @generated
	 */
	EList<Tool> getAvailable();

	/**
	 * Returns the value of the '<em><b>Unavailable</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Tool}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Tool#getUnavailableOptions <em>Unavailable Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unavailable</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getOption_Unavailable()
	 * @see recommenderQuestionnaire.Tool#getUnavailableOptions
	 * @model opposite="unavailableOptions"
	 * @generated
	 */
	EList<Tool> getUnavailable();

	/**
	 * Returns the value of the '<em><b>Unknown</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Tool}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Tool#getUnknownOptions <em>Unknown Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unknown</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getOption_Unknown()
	 * @see recommenderQuestionnaire.Tool#getUnknownOptions
	 * @model opposite="unknownOptions"
	 * @generated
	 */
	EList<Tool> getUnknown();
	
	/**
	 * Returns the value of the '<em><b>Possible</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Tool}.
	 * It is bidirectional and its opposite is '{@link recommenderQuestionnaire.Tool#getPossibleOptions <em>Possible Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possible</em>' reference list.
	 * @see recommenderQuestionnaire.RecommenderQuestionnairePackage#getOption_Possible()
	 * @see recommenderQuestionnaire.Tool#getPossibleOptions
	 * @model opposite="possibleOptions"
	 * @generated
	 */
	EList<Tool> getPossible();

	boolean isAvailable(String tool);
	boolean isUnavailable(String tool);
	boolean isUnknow(String tool);
	boolean isPossible(String tool);

} // Option

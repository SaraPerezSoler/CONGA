/**
 */
package congabase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import recommenderQuestionnaire.Option;
import recommenderQuestionnaire.Question;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AQuestion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congabase.AQuestion#getQuestion <em>Question</em>}</li>
 *   <li>{@link congabase.AQuestion#getSelecteds <em>Selecteds</em>}</li>
 *   <li>{@link congabase.AQuestion#getRelevance <em>Relevance</em>}</li>
 * </ul>
 *
 * @see congabase.CongabasePackage#getAQuestion()
 * @model
 * @generated
 */
public interface AQuestion extends EObject {
	/**
	 * Returns the value of the '<em><b>Question</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Question</em>' reference.
	 * @see #setQuestion(Question)
	 * @see congabase.CongabasePackage#getAQuestion_Question()
	 * @model required="true"
	 * @generated
	 */
	Question getQuestion();

	/**
	 * Sets the value of the '{@link congabase.AQuestion#getQuestion <em>Question</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Question</em>' reference.
	 * @see #getQuestion()
	 * @generated
	 */
	void setQuestion(Question value);

	/**
	 * Returns the value of the '<em><b>Selecteds</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Option}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selecteds</em>' reference list.
	 * @see congabase.CongabasePackage#getAQuestion_Selecteds()
	 * @model
	 * @generated
	 */
	EList<Option> getSelecteds();

	/**
	 * Returns the value of the '<em><b>Relevance</b></em>' attribute.
	 * The default value is <code>"Relevant"</code>.
	 * The literals are from the enumeration {@link congabase.RelevanceLevel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relevance</em>' attribute.
	 * @see congabase.RelevanceLevel
	 * @see #setRelevance(RelevanceLevel)
	 * @see congabase.CongabasePackage#getAQuestion_Relevance()
	 * @model default="Relevant" required="true"
	 * @generated
	 */
	RelevanceLevel getRelevance();

	/**
	 * Sets the value of the '{@link congabase.AQuestion#getRelevance <em>Relevance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relevance</em>' attribute.
	 * @see congabase.RelevanceLevel
	 * @see #getRelevance()
	 * @generated
	 */
	void setRelevance(RelevanceLevel value);

	double getScore(RecommenderOption ro);
	//double getScore(String tool);

} // AQuestion

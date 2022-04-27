/**
 */
package congabase;

import java.util.Date;
import java.util.List;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

import recommenderQuestionnaire.Question;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Answer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congabase.UserAnswer#getAnswers <em>Answers</em>}</li>
 *   <li>{@link congabase.UserAnswer#getRanking <em>Ranking</em>}</li>
 *   <li>{@link congabase.UserAnswer#getDate <em>Date</em>}</li>
 * </ul>
 *
 * @see congabase.CongabasePackage#getUserAnswer()
 * @model
 * @generated
 */
public interface UserAnswer extends EObject {
	/**
	 * Returns the value of the '<em><b>Answers</b></em>' containment reference list.
	 * The list contents are of type {@link congabase.AQuestion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Answers</em>' containment reference list.
	 * @see congabase.CongabasePackage#getUserAnswer_Answers()
	 * @model containment="true"
	 * @generated
	 */
	EList<AQuestion> getAnswers();


	/**
	 * Returns the value of the '<em><b>Ranking</b></em>' map.
	 * The key is of type {@link congabase.RecommenderOption},
	 * and the value is of type {@link java.lang.Double},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ranking</em>' map.
	 * @see congabase.CongabasePackage#getUserAnswer_Ranking()
	 * @model mapType="congabase.ROptionToDouble&lt;congabase.RecommenderOption, org.eclipse.emf.ecore.EDoubleObject&gt;"
	 * @generated
	 */
	EMap<RecommenderOption, Double> getRanking();


	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see congabase.CongabasePackage#getUserAnswer_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link congabase.UserAnswer#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);


	AQuestion getAnswer(Question question);


	void calculateRanking(List<RecommenderOption> allTools);

} // UserAnswer

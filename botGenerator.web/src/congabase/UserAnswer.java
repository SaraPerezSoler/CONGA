/**
 */
package congabase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

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
 * </ul>
 *
 * @see congabase.CongabasePackage#getUserAnswer()
 * @model
 * @generated
 */
public interface UserAnswer extends EObject {
	/**
	 * Returns the value of the '<em><b>Answers</b></em>' reference list.
	 * The list contents are of type {@link congabase.AQuestion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Answers</em>' reference list.
	 * @see congabase.CongabasePackage#getUserAnswer_Answers()
	 * @model
	 * @generated
	 */
	EList<AQuestion> getAnswers();

} // UserAnswer

/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Back To Bot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.BackToBot#getPrevious <em>Previous</em>}</li>
 *   <li>{@link generator.BackToBot#getBackTo <em>Back To</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getBackToBot()
 * @model
 * @generated
 */
public interface BackToBot extends EObject {
	/**
	 * Returns the value of the '<em><b>Previous</b></em>' reference list.
	 * The list contents are of type {@link generator.Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous</em>' reference list.
	 * @see generator.GeneratorPackage#getBackToBot_Previous()
	 * @model
	 * @generated
	 */
	EList<Action> getPrevious();

	/**
	 * Returns the value of the '<em><b>Back To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Back To</em>' reference.
	 * @see #setBackTo(BotInteraction)
	 * @see generator.GeneratorPackage#getBackToBot_BackTo()
	 * @model required="true"
	 * @generated
	 */
	BotInteraction getBackTo();

	/**
	 * Sets the value of the '{@link generator.BackToBot#getBackTo <em>Back To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Back To</em>' reference.
	 * @see #getBackTo()
	 * @generated
	 */
	void setBackTo(BotInteraction value);

} // BackToBot

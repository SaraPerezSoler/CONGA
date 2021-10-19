/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buttons Language Inputs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.ButtonsLanguageInputs#getText <em>Text</em>}</li>
 *   <li>{@link generator.ButtonsLanguageInputs#getButtons <em>Buttons</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getButtonsLanguageInputs()
 * @model
 * @generated
 */
public interface ButtonsLanguageInputs extends WithLanguage {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' containment reference.
	 * @see #setText(TextInput)
	 * @see generator.GeneratorPackage#getButtonsLanguageInputs_Text()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TextInput getText();

	/**
	 * Sets the value of the '{@link generator.ButtonsLanguageInputs#getText <em>Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' containment reference.
	 * @see #getText()
	 * @generated
	 */
	void setText(TextInput value);

	/**
	 * Returns the value of the '<em><b>Buttons</b></em>' containment reference list.
	 * The list contents are of type {@link generator.Button}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buttons</em>' containment reference list.
	 * @see generator.GeneratorPackage#getButtonsLanguageInputs_Buttons()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Button> getButtons();

} // ButtonsLanguageInputs

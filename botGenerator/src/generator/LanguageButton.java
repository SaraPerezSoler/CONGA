/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language Button</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.LanguageButton#getButtons <em>Buttons</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getLanguageButton()
 * @model
 * @generated
 */
public interface LanguageButton extends LanguageText {
	/**
	 * Returns the value of the '<em><b>Buttons</b></em>' containment reference list.
	 * The list contents are of type {@link generator.Button}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buttons</em>' containment reference list.
	 * @see generator.GeneratorPackage#getLanguageButton_Buttons()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Button> getButtons();

} // LanguageButton

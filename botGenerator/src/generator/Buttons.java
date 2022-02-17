/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buttons</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.Buttons#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getButtons()
 * @model
 * @generated
 */
public interface Buttons extends Action {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link generator.ButtonsLanguageInputs}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see generator.GeneratorPackage#getButtons_Inputs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ButtonsLanguageInputs> getInputs();

} // Buttons

/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.LanguageInput#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getLanguageInput()
 * @model
 * @generated
 */
public interface LanguageInput extends WithLanguage {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link generator.EntityInput}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see generator.GeneratorPackage#getLanguageInput_Inputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<EntityInput> getInputs();

	EntityInput getInput(String name);

} // LanguageInput

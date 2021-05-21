/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Intent Language Inputs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.IntentLanguageInputs#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getIntentLanguageInputs()
 * @model
 * @generated NOT
 */
public interface IntentLanguageInputs extends WithLanguage, Comparable {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link generator.IntentInput}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see generator.GeneratorPackage#getIntentLanguageInputs_Inputs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<IntentInput> getInputs();

} // IntentLanguageInputs

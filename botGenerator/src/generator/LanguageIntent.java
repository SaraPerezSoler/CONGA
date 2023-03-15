/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language Intent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.LanguageIntent#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getLanguageIntent()
 * @model
 * @generated NOT
 */
public interface LanguageIntent extends LanguageInput, Comparable {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link generator.IntentInput}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see generator.GeneratorPackage#getLanguageIntent_Inputs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TrainingPhrase> getInputs();

	boolean contains(TrainingPhrase tp);

} // LanguageIntent

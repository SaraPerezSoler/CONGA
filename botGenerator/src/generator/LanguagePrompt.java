/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language Prompt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.LanguagePrompt#getPrompts <em>Prompts</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getLanguagePrompt()
 * @model
 * @generated NOT
 */
public interface LanguagePrompt extends LanguageInput, Comparable {
	/**
	 * Returns the value of the '<em><b>Prompts</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prompts</em>' attribute list.
	 * @see generator.GeneratorPackage#getLanguagePrompt_Prompts()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getPrompts();

} // LanguagePrompt

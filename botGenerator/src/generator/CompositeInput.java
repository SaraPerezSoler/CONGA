/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.CompositeInput#getExpresion <em>Expresion</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getCompositeInput()
 * @model
 * @generated
 */
public interface CompositeInput extends EntityInput {
	/**
	 * Returns the value of the '<em><b>Expresion</b></em>' containment reference list.
	 * The list contents are of type {@link generator.Token}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expresion</em>' containment reference list.
	 * @see generator.GeneratorPackage#getCompositeInput_Expresion()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Token> getExpresion();

} // CompositeInput

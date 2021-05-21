/**
 */
package generator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regex Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.RegexInput#getExpresion <em>Expresion</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getRegexInput()
 * @model
 * @generated NOT
 */
public interface RegexInput extends EntityInput, IntentInput, Comparable {
	/**
	 * Returns the value of the '<em><b>Expresion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expresion</em>' attribute.
	 * @see #setExpresion(String)
	 * @see generator.GeneratorPackage#getRegexInput_Expresion()
	 * @model required="true"
	 * @generated
	 */
	String getExpresion();

	/**
	 * Sets the value of the '{@link generator.RegexInput#getExpresion <em>Expresion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expresion</em>' attribute.
	 * @see #getExpresion()
	 * @generated
	 */
	void setExpresion(String value);

} // RegexInput

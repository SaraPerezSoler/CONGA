/**
 */
package generator.impl;

import generator.Comparable;
import generator.GeneratorPackage;
import generator.LanguagePrompt;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language Prompt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.LanguagePromptImpl#getPrompts <em>Prompts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LanguagePromptImpl extends LanguageInputImpl implements LanguagePrompt {
	/**
	 * The cached value of the '{@link #getPrompts() <em>Prompts</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrompts()
	 * @generated
	 * @ordered
	 */
	protected EList<String> prompts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguagePromptImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.LANGUAGE_PROMPT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getPrompts() {
		if (prompts == null) {
			prompts = new EDataTypeUniqueEList<String>(String.class, this, GeneratorPackage.LANGUAGE_PROMPT__PROMPTS);
		}
		return prompts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorPackage.LANGUAGE_PROMPT__PROMPTS:
				return getPrompts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneratorPackage.LANGUAGE_PROMPT__PROMPTS:
				getPrompts().clear();
				getPrompts().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeneratorPackage.LANGUAGE_PROMPT__PROMPTS:
				getPrompts().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeneratorPackage.LANGUAGE_PROMPT__PROMPTS:
				return prompts != null && !prompts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (prompts: ");
		result.append(prompts);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public boolean isSimilarTo(Comparable obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LanguagePrompt other = (LanguagePrompt) obj;
		if (getLanguage() != other.getLanguage()) {
			return false;
		}
		if (getPrompts() == null) {
			if (other.getPrompts() != null)
				return false;
		} else if (!prompts.equals(other.getPrompts()))
			return false;
		return true;
	}

} //LanguagePromptImpl

/**
 */
package generator.impl;

import generator.Comparable;
import generator.GeneratorPackage;
import generator.RegexInput;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Regex Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.RegexInputImpl#getExpresion <em>Expresion</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RegexInputImpl extends EntityInputImpl implements RegexInput {
	/**
	 * The default value of the '{@link #getExpresion() <em>Expresion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpresion()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getExpresion() <em>Expresion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpresion()
	 * @generated
	 * @ordered
	 */
	protected String expresion = EXPRESION_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegexInputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.REGEX_INPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExpresion() {
		return expresion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpresion(String newExpresion) {
		String oldExpresion = expresion;
		expresion = newExpresion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.REGEX_INPUT__EXPRESION, oldExpresion, expresion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorPackage.REGEX_INPUT__EXPRESION:
				return getExpresion();
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
			case GeneratorPackage.REGEX_INPUT__EXPRESION:
				setExpresion((String)newValue);
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
			case GeneratorPackage.REGEX_INPUT__EXPRESION:
				setExpresion(EXPRESION_EDEFAULT);
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
			case GeneratorPackage.REGEX_INPUT__EXPRESION:
				return EXPRESION_EDEFAULT == null ? expresion != null : !EXPRESION_EDEFAULT.equals(expresion);
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
		result.append(" (expresion: ");
		result.append(expresion);
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
		RegexInput other = (RegexInput) obj;
		if (getExpresion() == null) {
			if (other.getExpresion() != null)
				return false;
		} else if (!getExpresion().equals(other.getExpresion()))
			return false;
		return true;
	}
} //RegexInputImpl

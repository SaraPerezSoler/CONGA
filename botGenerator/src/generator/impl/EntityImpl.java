/**
 */
package generator.impl;

import generator.CompositeInput;
import generator.Entity;
import generator.GeneratorPackage;
import generator.LanguageInput;
import generator.RegexInput;
import generator.SimpleInput;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.EntityImpl#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityImpl extends ElementImpl implements Entity {
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<LanguageInput> inputs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LanguageInput> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList<LanguageInput>(LanguageInput.class, this, GeneratorPackage.ENTITY__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.ENTITY__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorPackage.ENTITY__INPUTS:
				return getInputs();
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
			case GeneratorPackage.ENTITY__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends LanguageInput>)newValue);
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
			case GeneratorPackage.ENTITY__INPUTS:
				getInputs().clear();
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
			case GeneratorPackage.ENTITY__INPUTS:
				return inputs != null && !inputs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean isRegex() {
		if (getInputs().isEmpty())
			return false;
		if (getInputs().get(0).getInputs().isEmpty())
			return false;
		if (!(getInputs().get(0).getInputs().get(0) instanceof RegexInput))
			return false;
		return true;
	}

	@Override
	public boolean isComposite() {
		if (getInputs().isEmpty())
			return false;
		if (getInputs().get(0).getInputs().isEmpty())
			return false;
		if (!(getInputs().get(0).getInputs().get(0) instanceof CompositeInput))
			return false;
		return true;
	}

	@Override
	public boolean isSimple() {
		if (getInputs().isEmpty())
			return false;
		if (getInputs().get(0).getInputs().isEmpty())
			return false;
		if (!(getInputs().get(0).getInputs().get(0) instanceof SimpleInput))
			return false;
		return true;
	}

} //EntityImpl

/**
 */
package generator.impl;

import generator.Button;
import generator.ButtonsLanguageInputs;
import generator.Comparable;
import generator.GeneratorPackage;
import generator.TextInput;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buttons Language Inputs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.ButtonsLanguageInputsImpl#getText <em>Text</em>}</li>
 *   <li>{@link generator.impl.ButtonsLanguageInputsImpl#getButtons <em>Buttons</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ButtonsLanguageInputsImpl extends WithLanguageImpl implements ButtonsLanguageInputs {
	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected TextInput text;

	/**
	 * The cached value of the '{@link #getButtons() <em>Buttons</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getButtons()
	 * @generated
	 * @ordered
	 */
	protected EList<Button> buttons;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ButtonsLanguageInputsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.BUTTONS_LANGUAGE_INPUTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TextInput getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetText(TextInput newText, NotificationChain msgs) {
		TextInput oldText = text;
		text = newText;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__TEXT, oldText, newText);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setText(TextInput newText) {
		if (newText != text) {
			NotificationChain msgs = null;
			if (text != null)
				msgs = ((InternalEObject)text).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__TEXT, null, msgs);
			if (newText != null)
				msgs = ((InternalEObject)newText).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__TEXT, null, msgs);
			msgs = basicSetText(newText, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__TEXT, newText, newText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Button> getButtons() {
		if (buttons == null) {
			buttons = new EObjectContainmentEList<Button>(Button.class, this, GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__BUTTONS);
		}
		return buttons;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__TEXT:
				return basicSetText(null, msgs);
			case GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__BUTTONS:
				return ((InternalEList<?>)getButtons()).basicRemove(otherEnd, msgs);
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
			case GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__TEXT:
				return getText();
			case GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__BUTTONS:
				return getButtons();
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
			case GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__TEXT:
				setText((TextInput)newValue);
				return;
			case GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__BUTTONS:
				getButtons().clear();
				getButtons().addAll((Collection<? extends Button>)newValue);
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
			case GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__TEXT:
				setText((TextInput)null);
				return;
			case GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__BUTTONS:
				getButtons().clear();
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
			case GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__TEXT:
				return text != null;
			case GeneratorPackage.BUTTONS_LANGUAGE_INPUTS__BUTTONS:
				return buttons != null && !buttons.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean isSimilarTo(Comparable obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ButtonsLanguageInputsImpl other = (ButtonsLanguageInputsImpl) obj;
		if (buttons == null) {
			if (other.buttons != null)
				return false;
		} else if (!isSimilar(getButtons(), other.getButtons()))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.isSimilarTo(other.text))
			return false;
		return true;
	}
	
	

} //ButtonsLanguageInputsImpl

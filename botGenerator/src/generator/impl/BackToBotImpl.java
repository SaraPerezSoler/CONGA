/**
 */
package generator.impl;

import generator.Action;
import generator.BackToBot;
import generator.BotInteraction;
import generator.GeneratorPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Back To Bot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.BackToBotImpl#getPrevious <em>Previous</em>}</li>
 *   <li>{@link generator.impl.BackToBotImpl#getBackTo <em>Back To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BackToBotImpl extends MinimalEObjectImpl.Container implements BackToBot {
	/**
	 * The cached value of the '{@link #getPrevious() <em>Previous</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrevious()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> previous;

	/**
	 * The cached value of the '{@link #getBackTo() <em>Back To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackTo()
	 * @generated
	 * @ordered
	 */
	protected BotInteraction backTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BackToBotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.BACK_TO_BOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Action> getPrevious() {
		if (previous == null) {
			previous = new EObjectResolvingEList<Action>(Action.class, this, GeneratorPackage.BACK_TO_BOT__PREVIOUS);
		}
		return previous;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BotInteraction getBackTo() {
		if (backTo != null && backTo.eIsProxy()) {
			InternalEObject oldBackTo = (InternalEObject)backTo;
			backTo = (BotInteraction)eResolveProxy(oldBackTo);
			if (backTo != oldBackTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratorPackage.BACK_TO_BOT__BACK_TO, oldBackTo, backTo));
			}
		}
		return backTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BotInteraction basicGetBackTo() {
		return backTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBackTo(BotInteraction newBackTo) {
		BotInteraction oldBackTo = backTo;
		backTo = newBackTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.BACK_TO_BOT__BACK_TO, oldBackTo, backTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorPackage.BACK_TO_BOT__PREVIOUS:
				return getPrevious();
			case GeneratorPackage.BACK_TO_BOT__BACK_TO:
				if (resolve) return getBackTo();
				return basicGetBackTo();
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
			case GeneratorPackage.BACK_TO_BOT__PREVIOUS:
				getPrevious().clear();
				getPrevious().addAll((Collection<? extends Action>)newValue);
				return;
			case GeneratorPackage.BACK_TO_BOT__BACK_TO:
				setBackTo((BotInteraction)newValue);
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
			case GeneratorPackage.BACK_TO_BOT__PREVIOUS:
				getPrevious().clear();
				return;
			case GeneratorPackage.BACK_TO_BOT__BACK_TO:
				setBackTo((BotInteraction)null);
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
			case GeneratorPackage.BACK_TO_BOT__PREVIOUS:
				return previous != null && !previous.isEmpty();
			case GeneratorPackage.BACK_TO_BOT__BACK_TO:
				return backTo != null;
		}
		return super.eIsSet(featureID);
	}

} //BackToBotImpl

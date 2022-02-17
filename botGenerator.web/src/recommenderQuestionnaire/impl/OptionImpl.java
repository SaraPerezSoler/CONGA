/**
 */
package recommenderQuestionnaire.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import recommenderQuestionnaire.Option;
import recommenderQuestionnaire.RecommenderQuestionnairePackage;
import recommenderQuestionnaire.Tool;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.impl.OptionImpl#getText <em>Text</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.OptionImpl#getAvailable <em>Available</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.OptionImpl#getUnavailable <em>Unavailable</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.OptionImpl#getUnknown <em>Unknown</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.OptionImpl#getPossible <em>Possible</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OptionImpl extends MinimalEObjectImpl.Container implements Option {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAvailable() <em>Available</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailable()
	 * @generated
	 * @ordered
	 */
	protected EList<Tool> available;

	/**
	 * The cached value of the '{@link #getUnavailable() <em>Unavailable</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnavailable()
	 * @generated
	 * @ordered
	 */
	protected EList<Tool> unavailable;

	/**
	 * The cached value of the '{@link #getUnknown() <em>Unknown</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknown()
	 * @generated
	 * @ordered
	 */
	protected EList<Tool> unknown;

	/**
	 * The cached value of the '{@link #getPossible() <em>Possible</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPossible()
	 * @generated
	 * @ordered
	 */
	protected EList<Tool> possible;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommenderQuestionnairePackage.Literals.OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RecommenderQuestionnairePackage.OPTION__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tool> getAvailable() {
		if (available == null) {
			available = new EObjectWithInverseResolvingEList.ManyInverse<Tool>(Tool.class, this, RecommenderQuestionnairePackage.OPTION__AVAILABLE, RecommenderQuestionnairePackage.TOOL__AVAILABLE_OPTIONS);
		}
		return available;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tool> getUnavailable() {
		if (unavailable == null) {
			unavailable = new EObjectWithInverseResolvingEList.ManyInverse<Tool>(Tool.class, this, RecommenderQuestionnairePackage.OPTION__UNAVAILABLE, RecommenderQuestionnairePackage.TOOL__UNAVAILABLE_OPTIONS);
		}
		return unavailable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tool> getUnknown() {
		if (unknown == null) {
			unknown = new EObjectWithInverseResolvingEList.ManyInverse<Tool>(Tool.class, this, RecommenderQuestionnairePackage.OPTION__UNKNOWN, RecommenderQuestionnairePackage.TOOL__UNKNOWN_OPTIONS);
		}
		return unknown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tool> getPossible() {
		if (possible == null) {
			possible = new EObjectWithInverseResolvingEList.ManyInverse<Tool>(Tool.class, this, RecommenderQuestionnairePackage.OPTION__POSSIBLE, RecommenderQuestionnairePackage.TOOL__POSSIBLE_OPTIONS);
		}
		return possible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RecommenderQuestionnairePackage.OPTION__AVAILABLE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAvailable()).basicAdd(otherEnd, msgs);
			case RecommenderQuestionnairePackage.OPTION__UNAVAILABLE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUnavailable()).basicAdd(otherEnd, msgs);
			case RecommenderQuestionnairePackage.OPTION__UNKNOWN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUnknown()).basicAdd(otherEnd, msgs);
			case RecommenderQuestionnairePackage.OPTION__POSSIBLE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPossible()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RecommenderQuestionnairePackage.OPTION__AVAILABLE:
				return ((InternalEList<?>)getAvailable()).basicRemove(otherEnd, msgs);
			case RecommenderQuestionnairePackage.OPTION__UNAVAILABLE:
				return ((InternalEList<?>)getUnavailable()).basicRemove(otherEnd, msgs);
			case RecommenderQuestionnairePackage.OPTION__UNKNOWN:
				return ((InternalEList<?>)getUnknown()).basicRemove(otherEnd, msgs);
			case RecommenderQuestionnairePackage.OPTION__POSSIBLE:
				return ((InternalEList<?>)getPossible()).basicRemove(otherEnd, msgs);
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
			case RecommenderQuestionnairePackage.OPTION__TEXT:
				return getText();
			case RecommenderQuestionnairePackage.OPTION__AVAILABLE:
				return getAvailable();
			case RecommenderQuestionnairePackage.OPTION__UNAVAILABLE:
				return getUnavailable();
			case RecommenderQuestionnairePackage.OPTION__UNKNOWN:
				return getUnknown();
			case RecommenderQuestionnairePackage.OPTION__POSSIBLE:
				return getPossible();
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
			case RecommenderQuestionnairePackage.OPTION__TEXT:
				setText((String)newValue);
				return;
			case RecommenderQuestionnairePackage.OPTION__AVAILABLE:
				getAvailable().clear();
				getAvailable().addAll((Collection<? extends Tool>)newValue);
				return;
			case RecommenderQuestionnairePackage.OPTION__UNAVAILABLE:
				getUnavailable().clear();
				getUnavailable().addAll((Collection<? extends Tool>)newValue);
				return;
			case RecommenderQuestionnairePackage.OPTION__UNKNOWN:
				getUnknown().clear();
				getUnknown().addAll((Collection<? extends Tool>)newValue);
				return;
			case RecommenderQuestionnairePackage.OPTION__POSSIBLE:
				getPossible().clear();
				getPossible().addAll((Collection<? extends Tool>)newValue);
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
			case RecommenderQuestionnairePackage.OPTION__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case RecommenderQuestionnairePackage.OPTION__AVAILABLE:
				getAvailable().clear();
				return;
			case RecommenderQuestionnairePackage.OPTION__UNAVAILABLE:
				getUnavailable().clear();
				return;
			case RecommenderQuestionnairePackage.OPTION__UNKNOWN:
				getUnknown().clear();
				return;
			case RecommenderQuestionnairePackage.OPTION__POSSIBLE:
				getPossible().clear();
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
			case RecommenderQuestionnairePackage.OPTION__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case RecommenderQuestionnairePackage.OPTION__AVAILABLE:
				return available != null && !available.isEmpty();
			case RecommenderQuestionnairePackage.OPTION__UNAVAILABLE:
				return unavailable != null && !unavailable.isEmpty();
			case RecommenderQuestionnairePackage.OPTION__UNKNOWN:
				return unknown != null && !unknown.isEmpty();
			case RecommenderQuestionnairePackage.OPTION__POSSIBLE:
				return possible != null && !possible.isEmpty();
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
		result.append(" (text: ");
		result.append(text);
		result.append(')');
		return result.toString();
	}

	@Override
	public boolean isAvailable(String tool) {
		for (Tool t: getAvailable()) {
			if (t.getName().equals(tool)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isUnavailable(String tool) {
		for (Tool t: getUnavailable()) {
			if (t.getName().equals(tool)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isUnknow(String tool) {
		for (Tool t: getUnknown()) {
			if (t.getName().equals(tool)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean isPossible(String tool) {
		for (Tool t: getPossible()) {
			if (t.getName().equals(tool)) {
				return true;
			}
		}
		return false;
	}

} //OptionImpl

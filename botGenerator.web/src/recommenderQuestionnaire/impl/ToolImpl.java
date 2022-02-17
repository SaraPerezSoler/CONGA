/**
 */
package recommenderQuestionnaire.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import recommenderQuestionnaire.Option;
import recommenderQuestionnaire.RecommenderQuestionnairePackage;
import recommenderQuestionnaire.Tool;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link recommenderQuestionnaire.impl.ToolImpl#getAvailableOptions <em>Available Options</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.ToolImpl#getUnknownOptions <em>Unknown Options</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.ToolImpl#getUnavailableOptions <em>Unavailable Options</em>}</li>
 *   <li>{@link recommenderQuestionnaire.impl.ToolImpl#getPossibleOptions <em>Possible Options</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ToolImpl extends WithNameImpl implements Tool {
	/**
	 * The cached value of the '{@link #getAvailableOptions() <em>Available Options</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> availableOptions;

	/**
	 * The cached value of the '{@link #getUnknownOptions() <em>Unknown Options</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknownOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> unknownOptions;

	/**
	 * The cached value of the '{@link #getUnavailableOptions() <em>Unavailable Options</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnavailableOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> unavailableOptions;

	/**
	 * The cached value of the '{@link #getPossibleOptions() <em>Possible Options</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPossibleOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> possibleOptions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RecommenderQuestionnairePackage.Literals.TOOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getAvailableOptions() {
		if (availableOptions == null) {
			availableOptions = new EObjectWithInverseResolvingEList.ManyInverse<Option>(Option.class, this, RecommenderQuestionnairePackage.TOOL__AVAILABLE_OPTIONS, RecommenderQuestionnairePackage.OPTION__AVAILABLE);
		}
		return availableOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getUnknownOptions() {
		if (unknownOptions == null) {
			unknownOptions = new EObjectWithInverseResolvingEList.ManyInverse<Option>(Option.class, this, RecommenderQuestionnairePackage.TOOL__UNKNOWN_OPTIONS, RecommenderQuestionnairePackage.OPTION__UNKNOWN);
		}
		return unknownOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getUnavailableOptions() {
		if (unavailableOptions == null) {
			unavailableOptions = new EObjectWithInverseResolvingEList.ManyInverse<Option>(Option.class, this, RecommenderQuestionnairePackage.TOOL__UNAVAILABLE_OPTIONS, RecommenderQuestionnairePackage.OPTION__UNAVAILABLE);
		}
		return unavailableOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getPossibleOptions() {
		if (possibleOptions == null) {
			possibleOptions = new EObjectWithInverseResolvingEList.ManyInverse<Option>(Option.class, this, RecommenderQuestionnairePackage.TOOL__POSSIBLE_OPTIONS, RecommenderQuestionnairePackage.OPTION__POSSIBLE);
		}
		return possibleOptions;
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
			case RecommenderQuestionnairePackage.TOOL__AVAILABLE_OPTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAvailableOptions()).basicAdd(otherEnd, msgs);
			case RecommenderQuestionnairePackage.TOOL__UNKNOWN_OPTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUnknownOptions()).basicAdd(otherEnd, msgs);
			case RecommenderQuestionnairePackage.TOOL__UNAVAILABLE_OPTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUnavailableOptions()).basicAdd(otherEnd, msgs);
			case RecommenderQuestionnairePackage.TOOL__POSSIBLE_OPTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPossibleOptions()).basicAdd(otherEnd, msgs);
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
			case RecommenderQuestionnairePackage.TOOL__AVAILABLE_OPTIONS:
				return ((InternalEList<?>)getAvailableOptions()).basicRemove(otherEnd, msgs);
			case RecommenderQuestionnairePackage.TOOL__UNKNOWN_OPTIONS:
				return ((InternalEList<?>)getUnknownOptions()).basicRemove(otherEnd, msgs);
			case RecommenderQuestionnairePackage.TOOL__UNAVAILABLE_OPTIONS:
				return ((InternalEList<?>)getUnavailableOptions()).basicRemove(otherEnd, msgs);
			case RecommenderQuestionnairePackage.TOOL__POSSIBLE_OPTIONS:
				return ((InternalEList<?>)getPossibleOptions()).basicRemove(otherEnd, msgs);
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
			case RecommenderQuestionnairePackage.TOOL__AVAILABLE_OPTIONS:
				return getAvailableOptions();
			case RecommenderQuestionnairePackage.TOOL__UNKNOWN_OPTIONS:
				return getUnknownOptions();
			case RecommenderQuestionnairePackage.TOOL__UNAVAILABLE_OPTIONS:
				return getUnavailableOptions();
			case RecommenderQuestionnairePackage.TOOL__POSSIBLE_OPTIONS:
				return getPossibleOptions();
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
			case RecommenderQuestionnairePackage.TOOL__AVAILABLE_OPTIONS:
				getAvailableOptions().clear();
				getAvailableOptions().addAll((Collection<? extends Option>)newValue);
				return;
			case RecommenderQuestionnairePackage.TOOL__UNKNOWN_OPTIONS:
				getUnknownOptions().clear();
				getUnknownOptions().addAll((Collection<? extends Option>)newValue);
				return;
			case RecommenderQuestionnairePackage.TOOL__UNAVAILABLE_OPTIONS:
				getUnavailableOptions().clear();
				getUnavailableOptions().addAll((Collection<? extends Option>)newValue);
				return;
			case RecommenderQuestionnairePackage.TOOL__POSSIBLE_OPTIONS:
				getPossibleOptions().clear();
				getPossibleOptions().addAll((Collection<? extends Option>)newValue);
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
			case RecommenderQuestionnairePackage.TOOL__AVAILABLE_OPTIONS:
				getAvailableOptions().clear();
				return;
			case RecommenderQuestionnairePackage.TOOL__UNKNOWN_OPTIONS:
				getUnknownOptions().clear();
				return;
			case RecommenderQuestionnairePackage.TOOL__UNAVAILABLE_OPTIONS:
				getUnavailableOptions().clear();
				return;
			case RecommenderQuestionnairePackage.TOOL__POSSIBLE_OPTIONS:
				getPossibleOptions().clear();
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
			case RecommenderQuestionnairePackage.TOOL__AVAILABLE_OPTIONS:
				return availableOptions != null && !availableOptions.isEmpty();
			case RecommenderQuestionnairePackage.TOOL__UNKNOWN_OPTIONS:
				return unknownOptions != null && !unknownOptions.isEmpty();
			case RecommenderQuestionnairePackage.TOOL__UNAVAILABLE_OPTIONS:
				return unavailableOptions != null && !unavailableOptions.isEmpty();
			case RecommenderQuestionnairePackage.TOOL__POSSIBLE_OPTIONS:
				return possibleOptions != null && !possibleOptions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ToolImpl

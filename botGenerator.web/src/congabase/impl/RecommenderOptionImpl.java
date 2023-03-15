/**
 */
package congabase.impl;

import congabase.CongabasePackage;
import congabase.RecommenderOption;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import recommenderQuestionnaire.Option;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recommender Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link congabase.impl.RecommenderOptionImpl#getAvailable <em>Available</em>}</li>
 *   <li>{@link congabase.impl.RecommenderOptionImpl#getUnavailable <em>Unavailable</em>}</li>
 *   <li>{@link congabase.impl.RecommenderOptionImpl#getUnknown <em>Unknown</em>}</li>
 *   <li>{@link congabase.impl.RecommenderOptionImpl#getPossible <em>Possible</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecommenderOptionImpl extends UtilityImpl implements RecommenderOption {
	/**
	 * The cached value of the '{@link #getAvailable() <em>Available</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailable()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> available;

	/**
	 * The cached value of the '{@link #getUnavailable() <em>Unavailable</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnavailable()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> unavailable;

	/**
	 * The cached value of the '{@link #getUnknown() <em>Unknown</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnknown()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> unknown;

	/**
	 * The cached value of the '{@link #getPossible() <em>Possible</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPossible()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> possible;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecommenderOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CongabasePackage.Literals.RECOMMENDER_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getAvailable() {
		if (available == null) {
			available = new EObjectResolvingEList<Option>(Option.class, this, CongabasePackage.RECOMMENDER_OPTION__AVAILABLE);
		}
		return available;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getUnavailable() {
		if (unavailable == null) {
			unavailable = new EObjectResolvingEList<Option>(Option.class, this, CongabasePackage.RECOMMENDER_OPTION__UNAVAILABLE);
		}
		return unavailable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getUnknown() {
		if (unknown == null) {
			unknown = new EObjectResolvingEList<Option>(Option.class, this, CongabasePackage.RECOMMENDER_OPTION__UNKNOWN);
		}
		return unknown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getPossible() {
		if (possible == null) {
			possible = new EObjectResolvingEList<Option>(Option.class, this, CongabasePackage.RECOMMENDER_OPTION__POSSIBLE);
		}
		return possible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CongabasePackage.RECOMMENDER_OPTION__AVAILABLE:
				return getAvailable();
			case CongabasePackage.RECOMMENDER_OPTION__UNAVAILABLE:
				return getUnavailable();
			case CongabasePackage.RECOMMENDER_OPTION__UNKNOWN:
				return getUnknown();
			case CongabasePackage.RECOMMENDER_OPTION__POSSIBLE:
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
			case CongabasePackage.RECOMMENDER_OPTION__AVAILABLE:
				getAvailable().clear();
				getAvailable().addAll((Collection<? extends Option>)newValue);
				return;
			case CongabasePackage.RECOMMENDER_OPTION__UNAVAILABLE:
				getUnavailable().clear();
				getUnavailable().addAll((Collection<? extends Option>)newValue);
				return;
			case CongabasePackage.RECOMMENDER_OPTION__UNKNOWN:
				getUnknown().clear();
				getUnknown().addAll((Collection<? extends Option>)newValue);
				return;
			case CongabasePackage.RECOMMENDER_OPTION__POSSIBLE:
				getPossible().clear();
				getPossible().addAll((Collection<? extends Option>)newValue);
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
			case CongabasePackage.RECOMMENDER_OPTION__AVAILABLE:
				getAvailable().clear();
				return;
			case CongabasePackage.RECOMMENDER_OPTION__UNAVAILABLE:
				getUnavailable().clear();
				return;
			case CongabasePackage.RECOMMENDER_OPTION__UNKNOWN:
				getUnknown().clear();
				return;
			case CongabasePackage.RECOMMENDER_OPTION__POSSIBLE:
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
			case CongabasePackage.RECOMMENDER_OPTION__AVAILABLE:
				return available != null && !available.isEmpty();
			case CongabasePackage.RECOMMENDER_OPTION__UNAVAILABLE:
				return unavailable != null && !unavailable.isEmpty();
			case CongabasePackage.RECOMMENDER_OPTION__UNKNOWN:
				return unknown != null && !unknown.isEmpty();
			case CongabasePackage.RECOMMENDER_OPTION__POSSIBLE:
				return possible != null && !possible.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean isAvailable(Option op) {
		if (getAvailable().contains(op)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isUnavailable(Option op) {
		if (getUnavailable().contains(op)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isPossible(Option op) {
		if (getPossible().contains(op)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isUnknown(Option op) {
		if (getUnknown().contains(op)) {
			return true;
		}
		return false;
	}
	
	public String getTypeString() {
		return "recommender";
	}
	
	public String getSortURL() {
		return "-";
	}
	
	public String getLastAccessString() {
		return "-";
	}
	public String getStatusString() {
		return "-";
	}

} //RecommenderOptionImpl

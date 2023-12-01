/**
 */
package congaAnnotation.impl;

import congaAnnotation.CongaAnnotationPackage;
import congaAnnotation.IntentValue;

import generator.Intent;
import generator.TrainingPhrase;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Intent Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link congaAnnotation.impl.IntentValueImpl#getIntent <em>Intent</em>}</li>
 *   <li>{@link congaAnnotation.impl.IntentValueImpl#getMin1 <em>Min1</em>}</li>
 *   <li>{@link congaAnnotation.impl.IntentValueImpl#getMax1 <em>Max1</em>}</li>
 *   <li>{@link congaAnnotation.impl.IntentValueImpl#getMin1Value <em>Min1 Value</em>}</li>
 *   <li>{@link congaAnnotation.impl.IntentValueImpl#getMax1Value <em>Max1 Value</em>}</li>
 *   <li>{@link congaAnnotation.impl.IntentValueImpl#getMin2 <em>Min2</em>}</li>
 *   <li>{@link congaAnnotation.impl.IntentValueImpl#getMax2 <em>Max2</em>}</li>
 *   <li>{@link congaAnnotation.impl.IntentValueImpl#getMin2Value <em>Min2 Value</em>}</li>
 *   <li>{@link congaAnnotation.impl.IntentValueImpl#getMax2Value <em>Max2 Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntentValueImpl extends MinimalEObjectImpl.Container implements IntentValue {
	/**
	 * The cached value of the '{@link #getIntent() <em>Intent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntent()
	 * @generated
	 * @ordered
	 */
	protected Intent intent;

	/**
	 * The cached value of the '{@link #getMin1() <em>Min1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin1()
	 * @generated
	 * @ordered
	 */
	protected TrainingPhrase min1;

	/**
	 * The cached value of the '{@link #getMax1() <em>Max1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax1()
	 * @generated
	 * @ordered
	 */
	protected TrainingPhrase max1;

	/**
	 * The default value of the '{@link #getMin1Value() <em>Min1 Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin1Value()
	 * @generated
	 * @ordered
	 */
	protected static final float MIN1_VALUE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMin1Value() <em>Min1 Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin1Value()
	 * @generated
	 * @ordered
	 */
	protected float min1Value = MIN1_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMax1Value() <em>Max1 Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax1Value()
	 * @generated
	 * @ordered
	 */
	protected static final float MAX1_VALUE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMax1Value() <em>Max1 Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax1Value()
	 * @generated
	 * @ordered
	 */
	protected float max1Value = MAX1_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMin2() <em>Min2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin2()
	 * @generated
	 * @ordered
	 */
	protected TrainingPhrase min2;

	/**
	 * The cached value of the '{@link #getMax2() <em>Max2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax2()
	 * @generated
	 * @ordered
	 */
	protected TrainingPhrase max2;

	/**
	 * The default value of the '{@link #getMin2Value() <em>Min2 Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin2Value()
	 * @generated
	 * @ordered
	 */
	protected static final float MIN2_VALUE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMin2Value() <em>Min2 Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin2Value()
	 * @generated
	 * @ordered
	 */
	protected float min2Value = MIN2_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMax2Value() <em>Max2 Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax2Value()
	 * @generated
	 * @ordered
	 */
	protected static final float MAX2_VALUE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMax2Value() <em>Max2 Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax2Value()
	 * @generated
	 * @ordered
	 */
	protected float max2Value = MAX2_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntentValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CongaAnnotationPackage.Literals.INTENT_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Intent getIntent() {
		if (intent != null && intent.eIsProxy()) {
			InternalEObject oldIntent = (InternalEObject)intent;
			intent = (Intent)eResolveProxy(oldIntent);
			if (intent != oldIntent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CongaAnnotationPackage.INTENT_VALUE__INTENT, oldIntent, intent));
			}
		}
		return intent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Intent basicGetIntent() {
		return intent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntent(Intent newIntent) {
		Intent oldIntent = intent;
		intent = newIntent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.INTENT_VALUE__INTENT, oldIntent, intent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase getMin1() {
		if (min1 != null && min1.eIsProxy()) {
			InternalEObject oldMin1 = (InternalEObject)min1;
			min1 = (TrainingPhrase)eResolveProxy(oldMin1);
			if (min1 != oldMin1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CongaAnnotationPackage.INTENT_VALUE__MIN1, oldMin1, min1));
			}
		}
		return min1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase basicGetMin1() {
		return min1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMin1(TrainingPhrase newMin1) {
		TrainingPhrase oldMin1 = min1;
		min1 = newMin1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.INTENT_VALUE__MIN1, oldMin1, min1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase getMax1() {
		if (max1 != null && max1.eIsProxy()) {
			InternalEObject oldMax1 = (InternalEObject)max1;
			max1 = (TrainingPhrase)eResolveProxy(oldMax1);
			if (max1 != oldMax1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CongaAnnotationPackage.INTENT_VALUE__MAX1, oldMax1, max1));
			}
		}
		return max1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase basicGetMax1() {
		return max1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMax1(TrainingPhrase newMax1) {
		TrainingPhrase oldMax1 = max1;
		max1 = newMax1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.INTENT_VALUE__MAX1, oldMax1, max1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMin1Value() {
		return min1Value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMin1Value(float newMin1Value) {
		float oldMin1Value = min1Value;
		min1Value = newMin1Value;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.INTENT_VALUE__MIN1_VALUE, oldMin1Value, min1Value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMax1Value() {
		return max1Value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMax1Value(float newMax1Value) {
		float oldMax1Value = max1Value;
		max1Value = newMax1Value;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.INTENT_VALUE__MAX1_VALUE, oldMax1Value, max1Value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase getMin2() {
		if (min2 != null && min2.eIsProxy()) {
			InternalEObject oldMin2 = (InternalEObject)min2;
			min2 = (TrainingPhrase)eResolveProxy(oldMin2);
			if (min2 != oldMin2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CongaAnnotationPackage.INTENT_VALUE__MIN2, oldMin2, min2));
			}
		}
		return min2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase basicGetMin2() {
		return min2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMin2(TrainingPhrase newMin2) {
		TrainingPhrase oldMin2 = min2;
		min2 = newMin2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.INTENT_VALUE__MIN2, oldMin2, min2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase getMax2() {
		if (max2 != null && max2.eIsProxy()) {
			InternalEObject oldMax2 = (InternalEObject)max2;
			max2 = (TrainingPhrase)eResolveProxy(oldMax2);
			if (max2 != oldMax2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CongaAnnotationPackage.INTENT_VALUE__MAX2, oldMax2, max2));
			}
		}
		return max2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase basicGetMax2() {
		return max2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMax2(TrainingPhrase newMax2) {
		TrainingPhrase oldMax2 = max2;
		max2 = newMax2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.INTENT_VALUE__MAX2, oldMax2, max2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMin2Value() {
		return min2Value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMin2Value(float newMin2Value) {
		float oldMin2Value = min2Value;
		min2Value = newMin2Value;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.INTENT_VALUE__MIN2_VALUE, oldMin2Value, min2Value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMax2Value() {
		return max2Value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMax2Value(float newMax2Value) {
		float oldMax2Value = max2Value;
		max2Value = newMax2Value;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.INTENT_VALUE__MAX2_VALUE, oldMax2Value, max2Value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CongaAnnotationPackage.INTENT_VALUE__INTENT:
				if (resolve) return getIntent();
				return basicGetIntent();
			case CongaAnnotationPackage.INTENT_VALUE__MIN1:
				if (resolve) return getMin1();
				return basicGetMin1();
			case CongaAnnotationPackage.INTENT_VALUE__MAX1:
				if (resolve) return getMax1();
				return basicGetMax1();
			case CongaAnnotationPackage.INTENT_VALUE__MIN1_VALUE:
				return getMin1Value();
			case CongaAnnotationPackage.INTENT_VALUE__MAX1_VALUE:
				return getMax1Value();
			case CongaAnnotationPackage.INTENT_VALUE__MIN2:
				if (resolve) return getMin2();
				return basicGetMin2();
			case CongaAnnotationPackage.INTENT_VALUE__MAX2:
				if (resolve) return getMax2();
				return basicGetMax2();
			case CongaAnnotationPackage.INTENT_VALUE__MIN2_VALUE:
				return getMin2Value();
			case CongaAnnotationPackage.INTENT_VALUE__MAX2_VALUE:
				return getMax2Value();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CongaAnnotationPackage.INTENT_VALUE__INTENT:
				setIntent((Intent)newValue);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MIN1:
				setMin1((TrainingPhrase)newValue);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MAX1:
				setMax1((TrainingPhrase)newValue);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MIN1_VALUE:
				setMin1Value((Float)newValue);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MAX1_VALUE:
				setMax1Value((Float)newValue);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MIN2:
				setMin2((TrainingPhrase)newValue);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MAX2:
				setMax2((TrainingPhrase)newValue);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MIN2_VALUE:
				setMin2Value((Float)newValue);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MAX2_VALUE:
				setMax2Value((Float)newValue);
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
			case CongaAnnotationPackage.INTENT_VALUE__INTENT:
				setIntent((Intent)null);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MIN1:
				setMin1((TrainingPhrase)null);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MAX1:
				setMax1((TrainingPhrase)null);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MIN1_VALUE:
				setMin1Value(MIN1_VALUE_EDEFAULT);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MAX1_VALUE:
				setMax1Value(MAX1_VALUE_EDEFAULT);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MIN2:
				setMin2((TrainingPhrase)null);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MAX2:
				setMax2((TrainingPhrase)null);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MIN2_VALUE:
				setMin2Value(MIN2_VALUE_EDEFAULT);
				return;
			case CongaAnnotationPackage.INTENT_VALUE__MAX2_VALUE:
				setMax2Value(MAX2_VALUE_EDEFAULT);
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
			case CongaAnnotationPackage.INTENT_VALUE__INTENT:
				return intent != null;
			case CongaAnnotationPackage.INTENT_VALUE__MIN1:
				return min1 != null;
			case CongaAnnotationPackage.INTENT_VALUE__MAX1:
				return max1 != null;
			case CongaAnnotationPackage.INTENT_VALUE__MIN1_VALUE:
				return min1Value != MIN1_VALUE_EDEFAULT;
			case CongaAnnotationPackage.INTENT_VALUE__MAX1_VALUE:
				return max1Value != MAX1_VALUE_EDEFAULT;
			case CongaAnnotationPackage.INTENT_VALUE__MIN2:
				return min2 != null;
			case CongaAnnotationPackage.INTENT_VALUE__MAX2:
				return max2 != null;
			case CongaAnnotationPackage.INTENT_VALUE__MIN2_VALUE:
				return min2Value != MIN2_VALUE_EDEFAULT;
			case CongaAnnotationPackage.INTENT_VALUE__MAX2_VALUE:
				return max2Value != MAX2_VALUE_EDEFAULT;
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
		result.append(" (min1Value: ");
		result.append(min1Value);
		result.append(", max1Value: ");
		result.append(max1Value);
		result.append(", min2Value: ");
		result.append(min2Value);
		result.append(", max2Value: ");
		result.append(max2Value);
		result.append(')');
		return result.toString();
	}

} //IntentValueImpl

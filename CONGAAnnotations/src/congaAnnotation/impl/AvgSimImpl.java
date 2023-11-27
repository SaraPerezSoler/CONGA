/**
 */
package congaAnnotation.impl;

import congaAnnotation.AvgSim;
import congaAnnotation.CongaAnnotationPackage;

import generator.TrainingPhrase;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Avg Sim</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link congaAnnotation.impl.AvgSimImpl#getTrainingPhrase <em>Training Phrase</em>}</li>
 *   <li>{@link congaAnnotation.impl.AvgSimImpl#getAvg <em>Avg</em>}</li>
 *   <li>{@link congaAnnotation.impl.AvgSimImpl#getMin <em>Min</em>}</li>
 *   <li>{@link congaAnnotation.impl.AvgSimImpl#getMax <em>Max</em>}</li>
 *   <li>{@link congaAnnotation.impl.AvgSimImpl#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link congaAnnotation.impl.AvgSimImpl#getMaxValue <em>Max Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AvgSimImpl extends MinimalEObjectImpl.Container implements AvgSim {
	/**
	 * The cached value of the '{@link #getTrainingPhrase() <em>Training Phrase</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrainingPhrase()
	 * @generated
	 * @ordered
	 */
	protected TrainingPhrase trainingPhrase;

	/**
	 * The default value of the '{@link #getAvg() <em>Avg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvg()
	 * @generated
	 * @ordered
	 */
	protected static final double AVG_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAvg() <em>Avg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvg()
	 * @generated
	 * @ordered
	 */
	protected double avg = AVG_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMin() <em>Min</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected TrainingPhrase min;

	/**
	 * The cached value of the '{@link #getMax() <em>Max</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected TrainingPhrase max;

	/**
	 * The default value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected static final double MIN_VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMinValue() <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected double minValue = MIN_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected static final double MAX_VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaxValue() <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected double maxValue = MAX_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AvgSimImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CongaAnnotationPackage.Literals.AVG_SIM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase getTrainingPhrase() {
		if (trainingPhrase != null && trainingPhrase.eIsProxy()) {
			InternalEObject oldTrainingPhrase = (InternalEObject)trainingPhrase;
			trainingPhrase = (TrainingPhrase)eResolveProxy(oldTrainingPhrase);
			if (trainingPhrase != oldTrainingPhrase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CongaAnnotationPackage.AVG_SIM__TRAINING_PHRASE, oldTrainingPhrase, trainingPhrase));
			}
		}
		return trainingPhrase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase basicGetTrainingPhrase() {
		return trainingPhrase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrainingPhrase(TrainingPhrase newTrainingPhrase) {
		TrainingPhrase oldTrainingPhrase = trainingPhrase;
		trainingPhrase = newTrainingPhrase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.AVG_SIM__TRAINING_PHRASE, oldTrainingPhrase, trainingPhrase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAvg() {
		return avg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvg(double newAvg) {
		double oldAvg = avg;
		avg = newAvg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.AVG_SIM__AVG, oldAvg, avg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase getMin() {
		if (min != null && min.eIsProxy()) {
			InternalEObject oldMin = (InternalEObject)min;
			min = (TrainingPhrase)eResolveProxy(oldMin);
			if (min != oldMin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CongaAnnotationPackage.AVG_SIM__MIN, oldMin, min));
			}
		}
		return min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase basicGetMin() {
		return min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMin(TrainingPhrase newMin) {
		TrainingPhrase oldMin = min;
		min = newMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.AVG_SIM__MIN, oldMin, min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase getMax() {
		if (max != null && max.eIsProxy()) {
			InternalEObject oldMax = (InternalEObject)max;
			max = (TrainingPhrase)eResolveProxy(oldMax);
			if (max != oldMax) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CongaAnnotationPackage.AVG_SIM__MAX, oldMax, max));
			}
		}
		return max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase basicGetMax() {
		return max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMax(TrainingPhrase newMax) {
		TrainingPhrase oldMax = max;
		max = newMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.AVG_SIM__MAX, oldMax, max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMinValue() {
		return minValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinValue(double newMinValue) {
		double oldMinValue = minValue;
		minValue = newMinValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.AVG_SIM__MIN_VALUE, oldMinValue, minValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaxValue() {
		return maxValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxValue(double newMaxValue) {
		double oldMaxValue = maxValue;
		maxValue = newMaxValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.AVG_SIM__MAX_VALUE, oldMaxValue, maxValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CongaAnnotationPackage.AVG_SIM__TRAINING_PHRASE:
				if (resolve) return getTrainingPhrase();
				return basicGetTrainingPhrase();
			case CongaAnnotationPackage.AVG_SIM__AVG:
				return getAvg();
			case CongaAnnotationPackage.AVG_SIM__MIN:
				if (resolve) return getMin();
				return basicGetMin();
			case CongaAnnotationPackage.AVG_SIM__MAX:
				if (resolve) return getMax();
				return basicGetMax();
			case CongaAnnotationPackage.AVG_SIM__MIN_VALUE:
				return getMinValue();
			case CongaAnnotationPackage.AVG_SIM__MAX_VALUE:
				return getMaxValue();
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
			case CongaAnnotationPackage.AVG_SIM__TRAINING_PHRASE:
				setTrainingPhrase((TrainingPhrase)newValue);
				return;
			case CongaAnnotationPackage.AVG_SIM__AVG:
				setAvg((Double)newValue);
				return;
			case CongaAnnotationPackage.AVG_SIM__MIN:
				setMin((TrainingPhrase)newValue);
				return;
			case CongaAnnotationPackage.AVG_SIM__MAX:
				setMax((TrainingPhrase)newValue);
				return;
			case CongaAnnotationPackage.AVG_SIM__MIN_VALUE:
				setMinValue((Double)newValue);
				return;
			case CongaAnnotationPackage.AVG_SIM__MAX_VALUE:
				setMaxValue((Double)newValue);
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
			case CongaAnnotationPackage.AVG_SIM__TRAINING_PHRASE:
				setTrainingPhrase((TrainingPhrase)null);
				return;
			case CongaAnnotationPackage.AVG_SIM__AVG:
				setAvg(AVG_EDEFAULT);
				return;
			case CongaAnnotationPackage.AVG_SIM__MIN:
				setMin((TrainingPhrase)null);
				return;
			case CongaAnnotationPackage.AVG_SIM__MAX:
				setMax((TrainingPhrase)null);
				return;
			case CongaAnnotationPackage.AVG_SIM__MIN_VALUE:
				setMinValue(MIN_VALUE_EDEFAULT);
				return;
			case CongaAnnotationPackage.AVG_SIM__MAX_VALUE:
				setMaxValue(MAX_VALUE_EDEFAULT);
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
			case CongaAnnotationPackage.AVG_SIM__TRAINING_PHRASE:
				return trainingPhrase != null;
			case CongaAnnotationPackage.AVG_SIM__AVG:
				return avg != AVG_EDEFAULT;
			case CongaAnnotationPackage.AVG_SIM__MIN:
				return min != null;
			case CongaAnnotationPackage.AVG_SIM__MAX:
				return max != null;
			case CongaAnnotationPackage.AVG_SIM__MIN_VALUE:
				return minValue != MIN_VALUE_EDEFAULT;
			case CongaAnnotationPackage.AVG_SIM__MAX_VALUE:
				return maxValue != MAX_VALUE_EDEFAULT;
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
		result.append(" (avg: ");
		result.append(avg);
		result.append(", minValue: ");
		result.append(minValue);
		result.append(", maxValue: ");
		result.append(maxValue);
		result.append(')');
		return result.toString();
	}

} //AvgSimImpl

/**
 */
package congaAnnotation.impl;

import congaAnnotation.CongaAnnotationPackage;
import congaAnnotation.SemanticSimilarity;

import generator.TrainingPhrase;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semantic Similarity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link congaAnnotation.impl.SemanticSimilarityImpl#getTrainingPhrase1 <em>Training Phrase1</em>}</li>
 *   <li>{@link congaAnnotation.impl.SemanticSimilarityImpl#getTrainingPhrase2 <em>Training Phrase2</em>}</li>
 *   <li>{@link congaAnnotation.impl.SemanticSimilarityImpl#getSimilarity <em>Similarity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemanticSimilarityImpl extends MinimalEObjectImpl.Container implements SemanticSimilarity {
	/**
	 * The cached value of the '{@link #getTrainingPhrase1() <em>Training Phrase1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrainingPhrase1()
	 * @generated
	 * @ordered
	 */
	protected TrainingPhrase trainingPhrase1;

	/**
	 * The cached value of the '{@link #getTrainingPhrase2() <em>Training Phrase2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrainingPhrase2()
	 * @generated
	 * @ordered
	 */
	protected TrainingPhrase trainingPhrase2;

	/**
	 * The default value of the '{@link #getSimilarity() <em>Similarity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimilarity()
	 * @generated
	 * @ordered
	 */
	protected static final double SIMILARITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSimilarity() <em>Similarity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimilarity()
	 * @generated
	 * @ordered
	 */
	protected double similarity = SIMILARITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SemanticSimilarityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CongaAnnotationPackage.Literals.SEMANTIC_SIMILARITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase getTrainingPhrase1() {
		if (trainingPhrase1 != null && trainingPhrase1.eIsProxy()) {
			InternalEObject oldTrainingPhrase1 = (InternalEObject)trainingPhrase1;
			trainingPhrase1 = (TrainingPhrase)eResolveProxy(oldTrainingPhrase1);
			if (trainingPhrase1 != oldTrainingPhrase1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CongaAnnotationPackage.SEMANTIC_SIMILARITY__TRAINING_PHRASE1, oldTrainingPhrase1, trainingPhrase1));
			}
		}
		return trainingPhrase1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase basicGetTrainingPhrase1() {
		return trainingPhrase1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrainingPhrase1(TrainingPhrase newTrainingPhrase1) {
		TrainingPhrase oldTrainingPhrase1 = trainingPhrase1;
		trainingPhrase1 = newTrainingPhrase1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.SEMANTIC_SIMILARITY__TRAINING_PHRASE1, oldTrainingPhrase1, trainingPhrase1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase getTrainingPhrase2() {
		if (trainingPhrase2 != null && trainingPhrase2.eIsProxy()) {
			InternalEObject oldTrainingPhrase2 = (InternalEObject)trainingPhrase2;
			trainingPhrase2 = (TrainingPhrase)eResolveProxy(oldTrainingPhrase2);
			if (trainingPhrase2 != oldTrainingPhrase2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CongaAnnotationPackage.SEMANTIC_SIMILARITY__TRAINING_PHRASE2, oldTrainingPhrase2, trainingPhrase2));
			}
		}
		return trainingPhrase2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrainingPhrase basicGetTrainingPhrase2() {
		return trainingPhrase2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrainingPhrase2(TrainingPhrase newTrainingPhrase2) {
		TrainingPhrase oldTrainingPhrase2 = trainingPhrase2;
		trainingPhrase2 = newTrainingPhrase2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.SEMANTIC_SIMILARITY__TRAINING_PHRASE2, oldTrainingPhrase2, trainingPhrase2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSimilarity() {
		return similarity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimilarity(double newSimilarity) {
		double oldSimilarity = similarity;
		similarity = newSimilarity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongaAnnotationPackage.SEMANTIC_SIMILARITY__SIMILARITY, oldSimilarity, similarity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CongaAnnotationPackage.SEMANTIC_SIMILARITY__TRAINING_PHRASE1:
				if (resolve) return getTrainingPhrase1();
				return basicGetTrainingPhrase1();
			case CongaAnnotationPackage.SEMANTIC_SIMILARITY__TRAINING_PHRASE2:
				if (resolve) return getTrainingPhrase2();
				return basicGetTrainingPhrase2();
			case CongaAnnotationPackage.SEMANTIC_SIMILARITY__SIMILARITY:
				return getSimilarity();
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
			case CongaAnnotationPackage.SEMANTIC_SIMILARITY__TRAINING_PHRASE1:
				setTrainingPhrase1((TrainingPhrase)newValue);
				return;
			case CongaAnnotationPackage.SEMANTIC_SIMILARITY__TRAINING_PHRASE2:
				setTrainingPhrase2((TrainingPhrase)newValue);
				return;
			case CongaAnnotationPackage.SEMANTIC_SIMILARITY__SIMILARITY:
				setSimilarity((Double)newValue);
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
			case CongaAnnotationPackage.SEMANTIC_SIMILARITY__TRAINING_PHRASE1:
				setTrainingPhrase1((TrainingPhrase)null);
				return;
			case CongaAnnotationPackage.SEMANTIC_SIMILARITY__TRAINING_PHRASE2:
				setTrainingPhrase2((TrainingPhrase)null);
				return;
			case CongaAnnotationPackage.SEMANTIC_SIMILARITY__SIMILARITY:
				setSimilarity(SIMILARITY_EDEFAULT);
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
			case CongaAnnotationPackage.SEMANTIC_SIMILARITY__TRAINING_PHRASE1:
				return trainingPhrase1 != null;
			case CongaAnnotationPackage.SEMANTIC_SIMILARITY__TRAINING_PHRASE2:
				return trainingPhrase2 != null;
			case CongaAnnotationPackage.SEMANTIC_SIMILARITY__SIMILARITY:
				return similarity != SIMILARITY_EDEFAULT;
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
		result.append(" (similarity: ");
		result.append(similarity);
		result.append(')');
		return result.toString();
	}

} //SemanticSimilarityImpl

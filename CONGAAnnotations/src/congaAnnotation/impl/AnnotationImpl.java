/**
 */
package congaAnnotation.impl;

import congaAnnotation.Annotation;
import congaAnnotation.CongaAnnotationPackage;
import congaAnnotation.IntentIntentValue;
import congaAnnotation.IntentValue;
import congaAnnotation.SemanticSimilarity;
import congaAnnotation.TPAvg;
import congaAnnotation.TPIntentAvgSim;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link congaAnnotation.impl.AnnotationImpl#getSemanticSimilarities <em>Semantic Similarities</em>}</li>
 *   <li>{@link congaAnnotation.impl.AnnotationImpl#getTpAvgSims <em>Tp Avg Sims</em>}</li>
 *   <li>{@link congaAnnotation.impl.AnnotationImpl#getTpIntentAvgSims <em>Tp Intent Avg Sims</em>}</li>
 *   <li>{@link congaAnnotation.impl.AnnotationImpl#getIntentIntentValues <em>Intent Intent Values</em>}</li>
 *   <li>{@link congaAnnotation.impl.AnnotationImpl#getIntentValues <em>Intent Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnnotationImpl extends MinimalEObjectImpl.Container implements Annotation {
	/**
	 * The cached value of the '{@link #getSemanticSimilarities() <em>Semantic Similarities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemanticSimilarities()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticSimilarity> semanticSimilarities;

	/**
	 * The cached value of the '{@link #getTpAvgSims() <em>Tp Avg Sims</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTpAvgSims()
	 * @generated
	 * @ordered
	 */
	protected EList<TPAvg> tpAvgSims;

	/**
	 * The cached value of the '{@link #getTpIntentAvgSims() <em>Tp Intent Avg Sims</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTpIntentAvgSims()
	 * @generated
	 * @ordered
	 */
	protected EList<TPIntentAvgSim> tpIntentAvgSims;

	/**
	 * The cached value of the '{@link #getIntentIntentValues() <em>Intent Intent Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntentIntentValues()
	 * @generated
	 * @ordered
	 */
	protected EList<IntentIntentValue> intentIntentValues;

	/**
	 * The cached value of the '{@link #getIntentValues() <em>Intent Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntentValues()
	 * @generated
	 * @ordered
	 */
	protected EList<IntentValue> intentValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CongaAnnotationPackage.Literals.ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SemanticSimilarity> getSemanticSimilarities() {
		if (semanticSimilarities == null) {
			semanticSimilarities = new EObjectContainmentEList<SemanticSimilarity>(SemanticSimilarity.class, this, CongaAnnotationPackage.ANNOTATION__SEMANTIC_SIMILARITIES);
		}
		return semanticSimilarities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TPAvg> getTpAvgSims() {
		if (tpAvgSims == null) {
			tpAvgSims = new EObjectContainmentEList<TPAvg>(TPAvg.class, this, CongaAnnotationPackage.ANNOTATION__TP_AVG_SIMS);
		}
		return tpAvgSims;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TPIntentAvgSim> getTpIntentAvgSims() {
		if (tpIntentAvgSims == null) {
			tpIntentAvgSims = new EObjectContainmentEList<TPIntentAvgSim>(TPIntentAvgSim.class, this, CongaAnnotationPackage.ANNOTATION__TP_INTENT_AVG_SIMS);
		}
		return tpIntentAvgSims;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntentIntentValue> getIntentIntentValues() {
		if (intentIntentValues == null) {
			intentIntentValues = new EObjectContainmentEList<IntentIntentValue>(IntentIntentValue.class, this, CongaAnnotationPackage.ANNOTATION__INTENT_INTENT_VALUES);
		}
		return intentIntentValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntentValue> getIntentValues() {
		if (intentValues == null) {
			intentValues = new EObjectContainmentEList<IntentValue>(IntentValue.class, this, CongaAnnotationPackage.ANNOTATION__INTENT_VALUES);
		}
		return intentValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CongaAnnotationPackage.ANNOTATION__SEMANTIC_SIMILARITIES:
				return ((InternalEList<?>)getSemanticSimilarities()).basicRemove(otherEnd, msgs);
			case CongaAnnotationPackage.ANNOTATION__TP_AVG_SIMS:
				return ((InternalEList<?>)getTpAvgSims()).basicRemove(otherEnd, msgs);
			case CongaAnnotationPackage.ANNOTATION__TP_INTENT_AVG_SIMS:
				return ((InternalEList<?>)getTpIntentAvgSims()).basicRemove(otherEnd, msgs);
			case CongaAnnotationPackage.ANNOTATION__INTENT_INTENT_VALUES:
				return ((InternalEList<?>)getIntentIntentValues()).basicRemove(otherEnd, msgs);
			case CongaAnnotationPackage.ANNOTATION__INTENT_VALUES:
				return ((InternalEList<?>)getIntentValues()).basicRemove(otherEnd, msgs);
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
			case CongaAnnotationPackage.ANNOTATION__SEMANTIC_SIMILARITIES:
				return getSemanticSimilarities();
			case CongaAnnotationPackage.ANNOTATION__TP_AVG_SIMS:
				return getTpAvgSims();
			case CongaAnnotationPackage.ANNOTATION__TP_INTENT_AVG_SIMS:
				return getTpIntentAvgSims();
			case CongaAnnotationPackage.ANNOTATION__INTENT_INTENT_VALUES:
				return getIntentIntentValues();
			case CongaAnnotationPackage.ANNOTATION__INTENT_VALUES:
				return getIntentValues();
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
			case CongaAnnotationPackage.ANNOTATION__SEMANTIC_SIMILARITIES:
				getSemanticSimilarities().clear();
				getSemanticSimilarities().addAll((Collection<? extends SemanticSimilarity>)newValue);
				return;
			case CongaAnnotationPackage.ANNOTATION__TP_AVG_SIMS:
				getTpAvgSims().clear();
				getTpAvgSims().addAll((Collection<? extends TPAvg>)newValue);
				return;
			case CongaAnnotationPackage.ANNOTATION__TP_INTENT_AVG_SIMS:
				getTpIntentAvgSims().clear();
				getTpIntentAvgSims().addAll((Collection<? extends TPIntentAvgSim>)newValue);
				return;
			case CongaAnnotationPackage.ANNOTATION__INTENT_INTENT_VALUES:
				getIntentIntentValues().clear();
				getIntentIntentValues().addAll((Collection<? extends IntentIntentValue>)newValue);
				return;
			case CongaAnnotationPackage.ANNOTATION__INTENT_VALUES:
				getIntentValues().clear();
				getIntentValues().addAll((Collection<? extends IntentValue>)newValue);
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
			case CongaAnnotationPackage.ANNOTATION__SEMANTIC_SIMILARITIES:
				getSemanticSimilarities().clear();
				return;
			case CongaAnnotationPackage.ANNOTATION__TP_AVG_SIMS:
				getTpAvgSims().clear();
				return;
			case CongaAnnotationPackage.ANNOTATION__TP_INTENT_AVG_SIMS:
				getTpIntentAvgSims().clear();
				return;
			case CongaAnnotationPackage.ANNOTATION__INTENT_INTENT_VALUES:
				getIntentIntentValues().clear();
				return;
			case CongaAnnotationPackage.ANNOTATION__INTENT_VALUES:
				getIntentValues().clear();
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
			case CongaAnnotationPackage.ANNOTATION__SEMANTIC_SIMILARITIES:
				return semanticSimilarities != null && !semanticSimilarities.isEmpty();
			case CongaAnnotationPackage.ANNOTATION__TP_AVG_SIMS:
				return tpAvgSims != null && !tpAvgSims.isEmpty();
			case CongaAnnotationPackage.ANNOTATION__TP_INTENT_AVG_SIMS:
				return tpIntentAvgSims != null && !tpIntentAvgSims.isEmpty();
			case CongaAnnotationPackage.ANNOTATION__INTENT_INTENT_VALUES:
				return intentIntentValues != null && !intentIntentValues.isEmpty();
			case CongaAnnotationPackage.ANNOTATION__INTENT_VALUES:
				return intentValues != null && !intentValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AnnotationImpl

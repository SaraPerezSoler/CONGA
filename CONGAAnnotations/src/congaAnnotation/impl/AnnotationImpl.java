/**
 */
package congaAnnotation.impl;

import congaAnnotation.Annotation;
import congaAnnotation.AvgSim;
import congaAnnotation.CongaAnnotationPackage;
import congaAnnotation.IntentAvgSim;
import congaAnnotation.SemanticSimilarity;

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
 *   <li>{@link congaAnnotation.impl.AnnotationImpl#getAvgSims <em>Avg Sims</em>}</li>
 *   <li>{@link congaAnnotation.impl.AnnotationImpl#getIntentAvgSims <em>Intent Avg Sims</em>}</li>
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
	 * The cached value of the '{@link #getAvgSims() <em>Avg Sims</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvgSims()
	 * @generated
	 * @ordered
	 */
	protected EList<AvgSim> avgSims;

	/**
	 * The cached value of the '{@link #getIntentAvgSims() <em>Intent Avg Sims</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntentAvgSims()
	 * @generated
	 * @ordered
	 */
	protected EList<IntentAvgSim> intentAvgSims;

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
	public EList<AvgSim> getAvgSims() {
		if (avgSims == null) {
			avgSims = new EObjectContainmentEList<AvgSim>(AvgSim.class, this, CongaAnnotationPackage.ANNOTATION__AVG_SIMS);
		}
		return avgSims;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntentAvgSim> getIntentAvgSims() {
		if (intentAvgSims == null) {
			intentAvgSims = new EObjectContainmentEList<IntentAvgSim>(IntentAvgSim.class, this, CongaAnnotationPackage.ANNOTATION__INTENT_AVG_SIMS);
		}
		return intentAvgSims;
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
			case CongaAnnotationPackage.ANNOTATION__AVG_SIMS:
				return ((InternalEList<?>)getAvgSims()).basicRemove(otherEnd, msgs);
			case CongaAnnotationPackage.ANNOTATION__INTENT_AVG_SIMS:
				return ((InternalEList<?>)getIntentAvgSims()).basicRemove(otherEnd, msgs);
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
			case CongaAnnotationPackage.ANNOTATION__AVG_SIMS:
				return getAvgSims();
			case CongaAnnotationPackage.ANNOTATION__INTENT_AVG_SIMS:
				return getIntentAvgSims();
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
			case CongaAnnotationPackage.ANNOTATION__AVG_SIMS:
				getAvgSims().clear();
				getAvgSims().addAll((Collection<? extends AvgSim>)newValue);
				return;
			case CongaAnnotationPackage.ANNOTATION__INTENT_AVG_SIMS:
				getIntentAvgSims().clear();
				getIntentAvgSims().addAll((Collection<? extends IntentAvgSim>)newValue);
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
			case CongaAnnotationPackage.ANNOTATION__AVG_SIMS:
				getAvgSims().clear();
				return;
			case CongaAnnotationPackage.ANNOTATION__INTENT_AVG_SIMS:
				getIntentAvgSims().clear();
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
			case CongaAnnotationPackage.ANNOTATION__AVG_SIMS:
				return avgSims != null && !avgSims.isEmpty();
			case CongaAnnotationPackage.ANNOTATION__INTENT_AVG_SIMS:
				return intentAvgSims != null && !intentAvgSims.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AnnotationImpl

/**
 */
package congaAnnotation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congaAnnotation.Annotation#getSemanticSimilarities <em>Semantic Similarities</em>}</li>
 *   <li>{@link congaAnnotation.Annotation#getTpAvgSims <em>Tp Avg Sims</em>}</li>
 *   <li>{@link congaAnnotation.Annotation#getTpIntentAvgSims <em>Tp Intent Avg Sims</em>}</li>
 *   <li>{@link congaAnnotation.Annotation#getIntentIntentValues <em>Intent Intent Values</em>}</li>
 *   <li>{@link congaAnnotation.Annotation#getIntentValues <em>Intent Values</em>}</li>
 * </ul>
 *
 * @see congaAnnotation.CongaAnnotationPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends EObject {
	/**
	 * Returns the value of the '<em><b>Semantic Similarities</b></em>' containment reference list.
	 * The list contents are of type {@link congaAnnotation.SemanticSimilarity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Semantic Similarities</em>' containment reference list.
	 * @see congaAnnotation.CongaAnnotationPackage#getAnnotation_SemanticSimilarities()
	 * @model containment="true"
	 * @generated
	 */
	EList<SemanticSimilarity> getSemanticSimilarities();

	/**
	 * Returns the value of the '<em><b>Tp Avg Sims</b></em>' containment reference list.
	 * The list contents are of type {@link congaAnnotation.TPAvg}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tp Avg Sims</em>' containment reference list.
	 * @see congaAnnotation.CongaAnnotationPackage#getAnnotation_TpAvgSims()
	 * @model containment="true"
	 * @generated
	 */
	EList<TPAvg> getTpAvgSims();

	/**
	 * Returns the value of the '<em><b>Tp Intent Avg Sims</b></em>' containment reference list.
	 * The list contents are of type {@link congaAnnotation.TPIntentAvgSim}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tp Intent Avg Sims</em>' containment reference list.
	 * @see congaAnnotation.CongaAnnotationPackage#getAnnotation_TpIntentAvgSims()
	 * @model containment="true"
	 * @generated
	 */
	EList<TPIntentAvgSim> getTpIntentAvgSims();

	/**
	 * Returns the value of the '<em><b>Intent Intent Values</b></em>' containment reference list.
	 * The list contents are of type {@link congaAnnotation.IntentIntentValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intent Intent Values</em>' containment reference list.
	 * @see congaAnnotation.CongaAnnotationPackage#getAnnotation_IntentIntentValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntentIntentValue> getIntentIntentValues();

	/**
	 * Returns the value of the '<em><b>Intent Values</b></em>' containment reference list.
	 * The list contents are of type {@link congaAnnotation.IntentValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intent Values</em>' containment reference list.
	 * @see congaAnnotation.CongaAnnotationPackage#getAnnotation_IntentValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntentValue> getIntentValues();

} // Annotation

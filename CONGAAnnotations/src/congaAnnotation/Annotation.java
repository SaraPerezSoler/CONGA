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
 *   <li>{@link congaAnnotation.Annotation#getAvgSims <em>Avg Sims</em>}</li>
 *   <li>{@link congaAnnotation.Annotation#getIntentAvgSims <em>Intent Avg Sims</em>}</li>
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
	 * Returns the value of the '<em><b>Avg Sims</b></em>' containment reference list.
	 * The list contents are of type {@link congaAnnotation.AvgSim}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Avg Sims</em>' containment reference list.
	 * @see congaAnnotation.CongaAnnotationPackage#getAnnotation_AvgSims()
	 * @model containment="true"
	 * @generated
	 */
	EList<AvgSim> getAvgSims();

	/**
	 * Returns the value of the '<em><b>Intent Avg Sims</b></em>' containment reference list.
	 * The list contents are of type {@link congaAnnotation.IntentAvgSim}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intent Avg Sims</em>' containment reference list.
	 * @see congaAnnotation.CongaAnnotationPackage#getAnnotation_IntentAvgSims()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntentAvgSim> getIntentAvgSims();

} // Annotation

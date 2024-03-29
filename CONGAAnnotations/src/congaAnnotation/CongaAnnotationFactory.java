/**
 */
package congaAnnotation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see congaAnnotation.CongaAnnotationPackage
 * @generated
 */
public interface CongaAnnotationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CongaAnnotationFactory eINSTANCE = congaAnnotation.impl.CongaAnnotationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation</em>'.
	 * @generated
	 */
	Annotation createAnnotation();

	/**
	 * Returns a new object of class '<em>Semantic Similarity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Semantic Similarity</em>'.
	 * @generated
	 */
	SemanticSimilarity createSemanticSimilarity();

	/**
	 * Returns a new object of class '<em>TP Avg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TP Avg</em>'.
	 * @generated
	 */
	TPAvg createTPAvg();

	/**
	 * Returns a new object of class '<em>TP Intent Avg Sim</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TP Intent Avg Sim</em>'.
	 * @generated
	 */
	TPIntentAvgSim createTPIntentAvgSim();

	/**
	 * Returns a new object of class '<em>Intent Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Intent Value</em>'.
	 * @generated
	 */
	IntentValue createIntentValue();

	/**
	 * Returns a new object of class '<em>Intent Intent Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Intent Intent Value</em>'.
	 * @generated
	 */
	IntentIntentValue createIntentIntentValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CongaAnnotationPackage getCongaAnnotationPackage();

} //CongaAnnotationFactory

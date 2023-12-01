/**
 */
package congaAnnotation;

import generator.TrainingPhrase;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Semantic Similarity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congaAnnotation.SemanticSimilarity#getTrainingPhrase1 <em>Training Phrase1</em>}</li>
 *   <li>{@link congaAnnotation.SemanticSimilarity#getTrainingPhrase2 <em>Training Phrase2</em>}</li>
 *   <li>{@link congaAnnotation.SemanticSimilarity#getSimilarity <em>Similarity</em>}</li>
 * </ul>
 *
 * @see congaAnnotation.CongaAnnotationPackage#getSemanticSimilarity()
 * @model
 * @generated
 */
public interface SemanticSimilarity extends EObject {
	/**
	 * Returns the value of the '<em><b>Training Phrase1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Training Phrase1</em>' reference.
	 * @see #setTrainingPhrase1(TrainingPhrase)
	 * @see congaAnnotation.CongaAnnotationPackage#getSemanticSimilarity_TrainingPhrase1()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getTrainingPhrase1();

	/**
	 * Sets the value of the '{@link congaAnnotation.SemanticSimilarity#getTrainingPhrase1 <em>Training Phrase1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Training Phrase1</em>' reference.
	 * @see #getTrainingPhrase1()
	 * @generated
	 */
	void setTrainingPhrase1(TrainingPhrase value);

	/**
	 * Returns the value of the '<em><b>Training Phrase2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Training Phrase2</em>' reference.
	 * @see #setTrainingPhrase2(TrainingPhrase)
	 * @see congaAnnotation.CongaAnnotationPackage#getSemanticSimilarity_TrainingPhrase2()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getTrainingPhrase2();

	/**
	 * Sets the value of the '{@link congaAnnotation.SemanticSimilarity#getTrainingPhrase2 <em>Training Phrase2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Training Phrase2</em>' reference.
	 * @see #getTrainingPhrase2()
	 * @generated
	 */
	void setTrainingPhrase2(TrainingPhrase value);

	/**
	 * Returns the value of the '<em><b>Similarity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Similarity</em>' attribute.
	 * @see #setSimilarity(float)
	 * @see congaAnnotation.CongaAnnotationPackage#getSemanticSimilarity_Similarity()
	 * @model required="true"
	 * @generated
	 */
	float getSimilarity();

	/**
	 * Sets the value of the '{@link congaAnnotation.SemanticSimilarity#getSimilarity <em>Similarity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Similarity</em>' attribute.
	 * @see #getSimilarity()
	 * @generated
	 */
	void setSimilarity(float value);

} // SemanticSimilarity

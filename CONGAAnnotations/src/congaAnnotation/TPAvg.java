/**
 */
package congaAnnotation;

import generator.TrainingPhrase;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TP Avg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congaAnnotation.TPAvg#getTrainingPhrase <em>Training Phrase</em>}</li>
 *   <li>{@link congaAnnotation.TPAvg#getAvg <em>Avg</em>}</li>
 *   <li>{@link congaAnnotation.TPAvg#getMin <em>Min</em>}</li>
 *   <li>{@link congaAnnotation.TPAvg#getMax <em>Max</em>}</li>
 *   <li>{@link congaAnnotation.TPAvg#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link congaAnnotation.TPAvg#getMaxValue <em>Max Value</em>}</li>
 * </ul>
 *
 * @see congaAnnotation.CongaAnnotationPackage#getTPAvg()
 * @model
 * @generated
 */
public interface TPAvg extends EObject {
	/**
	 * Returns the value of the '<em><b>Training Phrase</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Training Phrase</em>' reference.
	 * @see #setTrainingPhrase(TrainingPhrase)
	 * @see congaAnnotation.CongaAnnotationPackage#getTPAvg_TrainingPhrase()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getTrainingPhrase();

	/**
	 * Sets the value of the '{@link congaAnnotation.TPAvg#getTrainingPhrase <em>Training Phrase</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Training Phrase</em>' reference.
	 * @see #getTrainingPhrase()
	 * @generated
	 */
	void setTrainingPhrase(TrainingPhrase value);

	/**
	 * Returns the value of the '<em><b>Avg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Avg</em>' attribute.
	 * @see #setAvg(float)
	 * @see congaAnnotation.CongaAnnotationPackage#getTPAvg_Avg()
	 * @model required="true"
	 * @generated
	 */
	float getAvg();

	/**
	 * Sets the value of the '{@link congaAnnotation.TPAvg#getAvg <em>Avg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Avg</em>' attribute.
	 * @see #getAvg()
	 * @generated
	 */
	void setAvg(float value);

	/**
	 * Returns the value of the '<em><b>Min</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min</em>' reference.
	 * @see #setMin(TrainingPhrase)
	 * @see congaAnnotation.CongaAnnotationPackage#getTPAvg_Min()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getMin();

	/**
	 * Sets the value of the '{@link congaAnnotation.TPAvg#getMin <em>Min</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min</em>' reference.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(TrainingPhrase value);

	/**
	 * Returns the value of the '<em><b>Max</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max</em>' reference.
	 * @see #setMax(TrainingPhrase)
	 * @see congaAnnotation.CongaAnnotationPackage#getTPAvg_Max()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getMax();

	/**
	 * Sets the value of the '{@link congaAnnotation.TPAvg#getMax <em>Max</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max</em>' reference.
	 * @see #getMax()
	 * @generated
	 */
	void setMax(TrainingPhrase value);

	/**
	 * Returns the value of the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Value</em>' attribute.
	 * @see #setMinValue(float)
	 * @see congaAnnotation.CongaAnnotationPackage#getTPAvg_MinValue()
	 * @model required="true"
	 * @generated
	 */
	float getMinValue();

	/**
	 * Sets the value of the '{@link congaAnnotation.TPAvg#getMinValue <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Value</em>' attribute.
	 * @see #getMinValue()
	 * @generated
	 */
	void setMinValue(float value);

	/**
	 * Returns the value of the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Value</em>' attribute.
	 * @see #setMaxValue(float)
	 * @see congaAnnotation.CongaAnnotationPackage#getTPAvg_MaxValue()
	 * @model required="true"
	 * @generated
	 */
	float getMaxValue();

	/**
	 * Sets the value of the '{@link congaAnnotation.TPAvg#getMaxValue <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Value</em>' attribute.
	 * @see #getMaxValue()
	 * @generated
	 */
	void setMaxValue(float value);

} // TPAvg

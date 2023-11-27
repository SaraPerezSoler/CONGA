/**
 */
package congaAnnotation;

import generator.TrainingPhrase;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Avg Sim</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congaAnnotation.AvgSim#getTrainingPhrase <em>Training Phrase</em>}</li>
 *   <li>{@link congaAnnotation.AvgSim#getAvg <em>Avg</em>}</li>
 *   <li>{@link congaAnnotation.AvgSim#getMin <em>Min</em>}</li>
 *   <li>{@link congaAnnotation.AvgSim#getMax <em>Max</em>}</li>
 *   <li>{@link congaAnnotation.AvgSim#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link congaAnnotation.AvgSim#getMaxValue <em>Max Value</em>}</li>
 * </ul>
 *
 * @see congaAnnotation.CongaAnnotationPackage#getAvgSim()
 * @model
 * @generated
 */
public interface AvgSim extends EObject {
	/**
	 * Returns the value of the '<em><b>Training Phrase</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Training Phrase</em>' reference.
	 * @see #setTrainingPhrase(TrainingPhrase)
	 * @see congaAnnotation.CongaAnnotationPackage#getAvgSim_TrainingPhrase()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getTrainingPhrase();

	/**
	 * Sets the value of the '{@link congaAnnotation.AvgSim#getTrainingPhrase <em>Training Phrase</em>}' reference.
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
	 * @see #setAvg(double)
	 * @see congaAnnotation.CongaAnnotationPackage#getAvgSim_Avg()
	 * @model required="true"
	 * @generated
	 */
	double getAvg();

	/**
	 * Sets the value of the '{@link congaAnnotation.AvgSim#getAvg <em>Avg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Avg</em>' attribute.
	 * @see #getAvg()
	 * @generated
	 */
	void setAvg(double value);

	/**
	 * Returns the value of the '<em><b>Min</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min</em>' reference.
	 * @see #setMin(TrainingPhrase)
	 * @see congaAnnotation.CongaAnnotationPackage#getAvgSim_Min()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getMin();

	/**
	 * Sets the value of the '{@link congaAnnotation.AvgSim#getMin <em>Min</em>}' reference.
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
	 * @see congaAnnotation.CongaAnnotationPackage#getAvgSim_Max()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getMax();

	/**
	 * Sets the value of the '{@link congaAnnotation.AvgSim#getMax <em>Max</em>}' reference.
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
	 * @see #setMinValue(double)
	 * @see congaAnnotation.CongaAnnotationPackage#getAvgSim_MinValue()
	 * @model required="true"
	 * @generated
	 */
	double getMinValue();

	/**
	 * Sets the value of the '{@link congaAnnotation.AvgSim#getMinValue <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Value</em>' attribute.
	 * @see #getMinValue()
	 * @generated
	 */
	void setMinValue(double value);

	/**
	 * Returns the value of the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Value</em>' attribute.
	 * @see #setMaxValue(double)
	 * @see congaAnnotation.CongaAnnotationPackage#getAvgSim_MaxValue()
	 * @model required="true"
	 * @generated
	 */
	double getMaxValue();

	/**
	 * Sets the value of the '{@link congaAnnotation.AvgSim#getMaxValue <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Value</em>' attribute.
	 * @see #getMaxValue()
	 * @generated
	 */
	void setMaxValue(double value);

} // AvgSim

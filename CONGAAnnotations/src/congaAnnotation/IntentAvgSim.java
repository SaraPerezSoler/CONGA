/**
 */
package congaAnnotation;

import generator.Intent;
import generator.TrainingPhrase;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Intent Avg Sim</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congaAnnotation.IntentAvgSim#getTrainingPhrase <em>Training Phrase</em>}</li>
 *   <li>{@link congaAnnotation.IntentAvgSim#getIntent <em>Intent</em>}</li>
 *   <li>{@link congaAnnotation.IntentAvgSim#getAvg <em>Avg</em>}</li>
 *   <li>{@link congaAnnotation.IntentAvgSim#getMin <em>Min</em>}</li>
 *   <li>{@link congaAnnotation.IntentAvgSim#getMax <em>Max</em>}</li>
 *   <li>{@link congaAnnotation.IntentAvgSim#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link congaAnnotation.IntentAvgSim#getMaxValue <em>Max Value</em>}</li>
 * </ul>
 *
 * @see congaAnnotation.CongaAnnotationPackage#getIntentAvgSim()
 * @model
 * @generated
 */
public interface IntentAvgSim extends EObject {
	/**
	 * Returns the value of the '<em><b>Training Phrase</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Training Phrase</em>' reference.
	 * @see #setTrainingPhrase(TrainingPhrase)
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentAvgSim_TrainingPhrase()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getTrainingPhrase();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentAvgSim#getTrainingPhrase <em>Training Phrase</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Training Phrase</em>' reference.
	 * @see #getTrainingPhrase()
	 * @generated
	 */
	void setTrainingPhrase(TrainingPhrase value);

	/**
	 * Returns the value of the '<em><b>Intent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intent</em>' reference.
	 * @see #setIntent(Intent)
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentAvgSim_Intent()
	 * @model required="true"
	 * @generated
	 */
	Intent getIntent();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentAvgSim#getIntent <em>Intent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intent</em>' reference.
	 * @see #getIntent()
	 * @generated
	 */
	void setIntent(Intent value);

	/**
	 * Returns the value of the '<em><b>Avg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Avg</em>' attribute.
	 * @see #setAvg(double)
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentAvgSim_Avg()
	 * @model required="true"
	 * @generated
	 */
	double getAvg();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentAvgSim#getAvg <em>Avg</em>}' attribute.
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
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentAvgSim_Min()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getMin();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentAvgSim#getMin <em>Min</em>}' reference.
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
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentAvgSim_Max()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getMax();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentAvgSim#getMax <em>Max</em>}' reference.
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
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentAvgSim_MinValue()
	 * @model required="true"
	 * @generated
	 */
	double getMinValue();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentAvgSim#getMinValue <em>Min Value</em>}' attribute.
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
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentAvgSim_MaxValue()
	 * @model required="true"
	 * @generated
	 */
	double getMaxValue();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentAvgSim#getMaxValue <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Value</em>' attribute.
	 * @see #getMaxValue()
	 * @generated
	 */
	void setMaxValue(double value);

} // IntentAvgSim

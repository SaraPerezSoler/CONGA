/**
 */
package congaAnnotation;

import generator.Intent;
import generator.TrainingPhrase;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TP Intent Avg Sim</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congaAnnotation.TPIntentAvgSim#getTrainingPhrase <em>Training Phrase</em>}</li>
 *   <li>{@link congaAnnotation.TPIntentAvgSim#getIntent <em>Intent</em>}</li>
 *   <li>{@link congaAnnotation.TPIntentAvgSim#getAvg <em>Avg</em>}</li>
 *   <li>{@link congaAnnotation.TPIntentAvgSim#getMin <em>Min</em>}</li>
 *   <li>{@link congaAnnotation.TPIntentAvgSim#getMax <em>Max</em>}</li>
 *   <li>{@link congaAnnotation.TPIntentAvgSim#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link congaAnnotation.TPIntentAvgSim#getMaxValue <em>Max Value</em>}</li>
 * </ul>
 *
 * @see congaAnnotation.CongaAnnotationPackage#getTPIntentAvgSim()
 * @model
 * @generated
 */
public interface TPIntentAvgSim extends EObject {
	/**
	 * Returns the value of the '<em><b>Training Phrase</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Training Phrase</em>' reference.
	 * @see #setTrainingPhrase(TrainingPhrase)
	 * @see congaAnnotation.CongaAnnotationPackage#getTPIntentAvgSim_TrainingPhrase()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getTrainingPhrase();

	/**
	 * Sets the value of the '{@link congaAnnotation.TPIntentAvgSim#getTrainingPhrase <em>Training Phrase</em>}' reference.
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
	 * @see congaAnnotation.CongaAnnotationPackage#getTPIntentAvgSim_Intent()
	 * @model required="true"
	 * @generated
	 */
	Intent getIntent();

	/**
	 * Sets the value of the '{@link congaAnnotation.TPIntentAvgSim#getIntent <em>Intent</em>}' reference.
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
	 * @see #setAvg(float)
	 * @see congaAnnotation.CongaAnnotationPackage#getTPIntentAvgSim_Avg()
	 * @model required="true"
	 * @generated
	 */
	float getAvg();

	/**
	 * Sets the value of the '{@link congaAnnotation.TPIntentAvgSim#getAvg <em>Avg</em>}' attribute.
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
	 * @see congaAnnotation.CongaAnnotationPackage#getTPIntentAvgSim_Min()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getMin();

	/**
	 * Sets the value of the '{@link congaAnnotation.TPIntentAvgSim#getMin <em>Min</em>}' reference.
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
	 * @see congaAnnotation.CongaAnnotationPackage#getTPIntentAvgSim_Max()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getMax();

	/**
	 * Sets the value of the '{@link congaAnnotation.TPIntentAvgSim#getMax <em>Max</em>}' reference.
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
	 * @see congaAnnotation.CongaAnnotationPackage#getTPIntentAvgSim_MinValue()
	 * @model required="true"
	 * @generated
	 */
	float getMinValue();

	/**
	 * Sets the value of the '{@link congaAnnotation.TPIntentAvgSim#getMinValue <em>Min Value</em>}' attribute.
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
	 * @see congaAnnotation.CongaAnnotationPackage#getTPIntentAvgSim_MaxValue()
	 * @model required="true"
	 * @generated
	 */
	float getMaxValue();

	/**
	 * Sets the value of the '{@link congaAnnotation.TPIntentAvgSim#getMaxValue <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Value</em>' attribute.
	 * @see #getMaxValue()
	 * @generated
	 */
	void setMaxValue(float value);

} // TPIntentAvgSim

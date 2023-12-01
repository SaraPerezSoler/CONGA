/**
 */
package congaAnnotation;

import generator.Intent;
import generator.TrainingPhrase;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Intent Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congaAnnotation.IntentValue#getIntent <em>Intent</em>}</li>
 *   <li>{@link congaAnnotation.IntentValue#getMin1 <em>Min1</em>}</li>
 *   <li>{@link congaAnnotation.IntentValue#getMax1 <em>Max1</em>}</li>
 *   <li>{@link congaAnnotation.IntentValue#getMin1Value <em>Min1 Value</em>}</li>
 *   <li>{@link congaAnnotation.IntentValue#getMax1Value <em>Max1 Value</em>}</li>
 *   <li>{@link congaAnnotation.IntentValue#getMin2 <em>Min2</em>}</li>
 *   <li>{@link congaAnnotation.IntentValue#getMax2 <em>Max2</em>}</li>
 *   <li>{@link congaAnnotation.IntentValue#getMin2Value <em>Min2 Value</em>}</li>
 *   <li>{@link congaAnnotation.IntentValue#getMax2Value <em>Max2 Value</em>}</li>
 * </ul>
 *
 * @see congaAnnotation.CongaAnnotationPackage#getIntentValue()
 * @model
 * @generated
 */
public interface IntentValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Intent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intent</em>' reference.
	 * @see #setIntent(Intent)
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentValue_Intent()
	 * @model required="true"
	 * @generated
	 */
	Intent getIntent();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentValue#getIntent <em>Intent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intent</em>' reference.
	 * @see #getIntent()
	 * @generated
	 */
	void setIntent(Intent value);

	/**
	 * Returns the value of the '<em><b>Min1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min1</em>' reference.
	 * @see #setMin1(TrainingPhrase)
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentValue_Min1()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getMin1();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentValue#getMin1 <em>Min1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min1</em>' reference.
	 * @see #getMin1()
	 * @generated
	 */
	void setMin1(TrainingPhrase value);

	/**
	 * Returns the value of the '<em><b>Max1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max1</em>' reference.
	 * @see #setMax1(TrainingPhrase)
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentValue_Max1()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getMax1();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentValue#getMax1 <em>Max1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max1</em>' reference.
	 * @see #getMax1()
	 * @generated
	 */
	void setMax1(TrainingPhrase value);

	/**
	 * Returns the value of the '<em><b>Min1 Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min1 Value</em>' attribute.
	 * @see #setMin1Value(float)
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentValue_Min1Value()
	 * @model required="true"
	 * @generated
	 */
	float getMin1Value();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentValue#getMin1Value <em>Min1 Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min1 Value</em>' attribute.
	 * @see #getMin1Value()
	 * @generated
	 */
	void setMin1Value(float value);

	/**
	 * Returns the value of the '<em><b>Max1 Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max1 Value</em>' attribute.
	 * @see #setMax1Value(float)
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentValue_Max1Value()
	 * @model required="true"
	 * @generated
	 */
	float getMax1Value();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentValue#getMax1Value <em>Max1 Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max1 Value</em>' attribute.
	 * @see #getMax1Value()
	 * @generated
	 */
	void setMax1Value(float value);

	/**
	 * Returns the value of the '<em><b>Min2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min2</em>' reference.
	 * @see #setMin2(TrainingPhrase)
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentValue_Min2()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getMin2();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentValue#getMin2 <em>Min2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min2</em>' reference.
	 * @see #getMin2()
	 * @generated
	 */
	void setMin2(TrainingPhrase value);

	/**
	 * Returns the value of the '<em><b>Max2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max2</em>' reference.
	 * @see #setMax2(TrainingPhrase)
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentValue_Max2()
	 * @model required="true"
	 * @generated
	 */
	TrainingPhrase getMax2();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentValue#getMax2 <em>Max2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max2</em>' reference.
	 * @see #getMax2()
	 * @generated
	 */
	void setMax2(TrainingPhrase value);

	/**
	 * Returns the value of the '<em><b>Min2 Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min2 Value</em>' attribute.
	 * @see #setMin2Value(float)
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentValue_Min2Value()
	 * @model required="true"
	 * @generated
	 */
	float getMin2Value();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentValue#getMin2Value <em>Min2 Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min2 Value</em>' attribute.
	 * @see #getMin2Value()
	 * @generated
	 */
	void setMin2Value(float value);

	/**
	 * Returns the value of the '<em><b>Max2 Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max2 Value</em>' attribute.
	 * @see #setMax2Value(float)
	 * @see congaAnnotation.CongaAnnotationPackage#getIntentValue_Max2Value()
	 * @model required="true"
	 * @generated
	 */
	float getMax2Value();

	/**
	 * Sets the value of the '{@link congaAnnotation.IntentValue#getMax2Value <em>Max2 Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max2 Value</em>' attribute.
	 * @see #getMax2Value()
	 * @generated
	 */
	void setMax2Value(float value);

} // IntentValue

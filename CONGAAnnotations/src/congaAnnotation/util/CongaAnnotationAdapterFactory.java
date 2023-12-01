/**
 */
package congaAnnotation.util;

import congaAnnotation.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see congaAnnotation.CongaAnnotationPackage
 * @generated
 */
public class CongaAnnotationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CongaAnnotationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CongaAnnotationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CongaAnnotationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CongaAnnotationSwitch<Adapter> modelSwitch =
		new CongaAnnotationSwitch<Adapter>() {
			@Override
			public Adapter caseAnnotation(Annotation object) {
				return createAnnotationAdapter();
			}
			@Override
			public Adapter caseSemanticSimilarity(SemanticSimilarity object) {
				return createSemanticSimilarityAdapter();
			}
			@Override
			public Adapter caseTPAvg(TPAvg object) {
				return createTPAvgAdapter();
			}
			@Override
			public Adapter caseTPIntentAvgSim(TPIntentAvgSim object) {
				return createTPIntentAvgSimAdapter();
			}
			@Override
			public Adapter caseIntentValue(IntentValue object) {
				return createIntentValueAdapter();
			}
			@Override
			public Adapter caseIntentIntentValue(IntentIntentValue object) {
				return createIntentIntentValueAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link congaAnnotation.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see congaAnnotation.Annotation
	 * @generated
	 */
	public Adapter createAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link congaAnnotation.SemanticSimilarity <em>Semantic Similarity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see congaAnnotation.SemanticSimilarity
	 * @generated
	 */
	public Adapter createSemanticSimilarityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link congaAnnotation.TPAvg <em>TP Avg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see congaAnnotation.TPAvg
	 * @generated
	 */
	public Adapter createTPAvgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link congaAnnotation.TPIntentAvgSim <em>TP Intent Avg Sim</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see congaAnnotation.TPIntentAvgSim
	 * @generated
	 */
	public Adapter createTPIntentAvgSimAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link congaAnnotation.IntentValue <em>Intent Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see congaAnnotation.IntentValue
	 * @generated
	 */
	public Adapter createIntentValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link congaAnnotation.IntentIntentValue <em>Intent Intent Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see congaAnnotation.IntentIntentValue
	 * @generated
	 */
	public Adapter createIntentIntentValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CongaAnnotationAdapterFactory

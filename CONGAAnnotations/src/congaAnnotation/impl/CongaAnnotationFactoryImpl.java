/**
 */
package congaAnnotation.impl;

import congaAnnotation.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CongaAnnotationFactoryImpl extends EFactoryImpl implements CongaAnnotationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CongaAnnotationFactory init() {
		try {
			CongaAnnotationFactory theCongaAnnotationFactory = (CongaAnnotationFactory)EPackage.Registry.INSTANCE.getEFactory(CongaAnnotationPackage.eNS_URI);
			if (theCongaAnnotationFactory != null) {
				return theCongaAnnotationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CongaAnnotationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CongaAnnotationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CongaAnnotationPackage.ANNOTATION: return createAnnotation();
			case CongaAnnotationPackage.SEMANTIC_SIMILARITY: return createSemanticSimilarity();
			case CongaAnnotationPackage.TP_AVG: return createTPAvg();
			case CongaAnnotationPackage.TP_INTENT_AVG_SIM: return createTPIntentAvgSim();
			case CongaAnnotationPackage.INTENT_VALUE: return createIntentValue();
			case CongaAnnotationPackage.INTENT_INTENT_VALUE: return createIntentIntentValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation createAnnotation() {
		AnnotationImpl annotation = new AnnotationImpl();
		return annotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticSimilarity createSemanticSimilarity() {
		SemanticSimilarityImpl semanticSimilarity = new SemanticSimilarityImpl();
		return semanticSimilarity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPAvg createTPAvg() {
		TPAvgImpl tpAvg = new TPAvgImpl();
		return tpAvg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPIntentAvgSim createTPIntentAvgSim() {
		TPIntentAvgSimImpl tpIntentAvgSim = new TPIntentAvgSimImpl();
		return tpIntentAvgSim;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntentValue createIntentValue() {
		IntentValueImpl intentValue = new IntentValueImpl();
		return intentValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntentIntentValue createIntentIntentValue() {
		IntentIntentValueImpl intentIntentValue = new IntentIntentValueImpl();
		return intentIntentValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CongaAnnotationPackage getCongaAnnotationPackage() {
		return (CongaAnnotationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CongaAnnotationPackage getPackage() {
		return CongaAnnotationPackage.eINSTANCE;
	}

} //CongaAnnotationFactoryImpl

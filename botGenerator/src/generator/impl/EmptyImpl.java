/**
 */
package generator.impl;

import generator.Comparable;
import generator.Empty;
import generator.GeneratorPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Empty</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class EmptyImpl extends ActionImpl implements Empty {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmptyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.EMPTY;
	}

	@Override
	public boolean isSimilarTo(Comparable obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EmptyImpl))
			return false;
		EmptyImpl other = (EmptyImpl) obj;
		if (getName() != other.getName()) {
			return false;
		}
		return true;
	}
	
	
	

} //EmptyImpl

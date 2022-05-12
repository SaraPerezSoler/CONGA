/**
 */
package generator.impl;

import generator.Comparable;
import generator.GeneratorPackage;
import generator.HTTPRequest;
import generator.HTTPResponse;
import generator.LanguageText;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HTTP Response</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.HTTPResponseImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link generator.impl.HTTPResponseImpl#getHTTPRequest <em>HTTP Request</em>}</li>
 * </ul>
 *
 * @generated NOT
 */
public class HTTPResponseImpl extends ActionImpl implements HTTPResponse, Comparable{
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<LanguageText> inputs;

	/**
	 * The cached value of the '{@link #getHTTPRequest() <em>HTTP Request</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHTTPRequest()
	 * @generated
	 * @ordered
	 */
	protected HTTPRequest httpRequest;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HTTPResponseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.HTTP_RESPONSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LanguageText> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList<LanguageText>(LanguageText.class, this, GeneratorPackage.HTTP_RESPONSE__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HTTPRequest getHTTPRequest() {
		if (httpRequest != null && httpRequest.eIsProxy()) {
			InternalEObject oldHTTPRequest = (InternalEObject)httpRequest;
			httpRequest = (HTTPRequest)eResolveProxy(oldHTTPRequest);
			if (httpRequest != oldHTTPRequest) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratorPackage.HTTP_RESPONSE__HTTP_REQUEST, oldHTTPRequest, httpRequest));
			}
		}
		return httpRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HTTPRequest basicGetHTTPRequest() {
		return httpRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHTTPRequest(HTTPRequest newHTTPRequest) {
		HTTPRequest oldHTTPRequest = httpRequest;
		httpRequest = newHTTPRequest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.HTTP_RESPONSE__HTTP_REQUEST, oldHTTPRequest, httpRequest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.HTTP_RESPONSE__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorPackage.HTTP_RESPONSE__INPUTS:
				return getInputs();
			case GeneratorPackage.HTTP_RESPONSE__HTTP_REQUEST:
				if (resolve) return getHTTPRequest();
				return basicGetHTTPRequest();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneratorPackage.HTTP_RESPONSE__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends LanguageText>)newValue);
				return;
			case GeneratorPackage.HTTP_RESPONSE__HTTP_REQUEST:
				setHTTPRequest((HTTPRequest)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeneratorPackage.HTTP_RESPONSE__INPUTS:
				getInputs().clear();
				return;
			case GeneratorPackage.HTTP_RESPONSE__HTTP_REQUEST:
				setHTTPRequest((HTTPRequest)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeneratorPackage.HTTP_RESPONSE__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case GeneratorPackage.HTTP_RESPONSE__HTTP_REQUEST:
				return httpRequest != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean isSimilarTo(Comparable obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HTTPResponse other = (HTTPResponseImpl) obj;
		if (getHTTPRequest() == null) {
			if (other.getHTTPRequest() != null)
				return false;
		} else if (!getHTTPRequest().isSimilarTo(other.getHTTPRequest()))
			return false;
		if (getInputs() == null) {
			if (other.getInputs() != null)
				return false;
		} else if (!isSimilar(getInputs(), other.getInputs()))
			return false;
		return true;
	}

} //HTTPResponseImpl

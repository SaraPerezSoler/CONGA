/**
 */
package congabase.impl;

import congabase.CongabasePackage;
import congabase.KeyValue;
import congabase.Service;
import congabase.ServiceStatus;
import congabase.ServiceType;

import congabase.User;
import java.util.Collection;
import java.util.Date;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import recommenderQuestionnaire.Tool;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link congabase.impl.ServiceImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link congabase.impl.ServiceImpl#getTool <em>Tool</em>}</li>
 *   <li>{@link congabase.impl.ServiceImpl#getType <em>Type</em>}</li>
 *   <li>{@link congabase.impl.ServiceImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link congabase.impl.ServiceImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link congabase.impl.ServiceImpl#getUser <em>User</em>}</li>
 *   <li>{@link congabase.impl.ServiceImpl#getBasicAuth <em>Basic Auth</em>}</li>
 *   <li>{@link congabase.impl.ServiceImpl#getHeaders <em>Headers</em>}</li>
 *   <li>{@link congabase.impl.ServiceImpl#getLastAccess <em>Last Access</em>}</li>
 *   <li>{@link congabase.impl.ServiceImpl#getServiceId <em>Service Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceImpl extends MinimalEObjectImpl.Container implements Service {
	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTool() <em>Tool</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTool()
	 * @generated
	 * @ordered
	 */
	protected Tool tool;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ServiceType TYPE_EDEFAULT = ServiceType.GENERATOR;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ServiceType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ServiceStatus STATUS_EDEFAULT = ServiceStatus.ON;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected ServiceStatus status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated NOT
	 * @ordered 
	 */
	protected static final String VERSION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUser() <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
	protected User user;

	/**
	 * The cached value of the '{@link #getBasicAuth() <em>Basic Auth</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasicAuth()
	 * @generated
	 * @ordered
	 */
	protected KeyValue basicAuth;

	/**
	 * The cached value of the '{@link #getHeaders() <em>Headers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaders()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyValue> headers;

	/**
	 * The default value of the '{@link #getLastAccess() <em>Last Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastAccess()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_ACCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastAccess() <em>Last Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastAccess()
	 * @generated
	 * @ordered
	 */
	protected Date lastAccess = LAST_ACCESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceId() <em>Service Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceId()
	 * @generated
	 * @ordered
	 */
	protected static final long SERVICE_ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getServiceId() <em>Service Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceId()
	 * @generated
	 * @ordered
	 */
	protected long serviceId = SERVICE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CongabasePackage.Literals.SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tool getTool() {
		if (tool != null && tool.eIsProxy()) {
			InternalEObject oldTool = (InternalEObject)tool;
			tool = (Tool)eResolveProxy(oldTool);
			if (tool != oldTool) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CongabasePackage.SERVICE__TOOL, oldTool, tool));
			}
		}
		return tool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tool basicGetTool() {
		return tool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTool(Tool newTool) {
		Tool oldTool = tool;
		tool = newTool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__TOOL, oldTool, tool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ServiceType newType) {
		ServiceType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(ServiceStatus newStatus) {
		ServiceStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getUser() {
		if (user != null && user.eIsProxy()) {
			InternalEObject oldUser = (InternalEObject)user;
			user = (User)eResolveProxy(oldUser);
			if (user != oldUser) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CongabasePackage.SERVICE__USER, oldUser, user));
			}
		}
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetUser() {
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUser(User newUser, NotificationChain msgs) {
		User oldUser = user;
		user = newUser;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__USER, oldUser, newUser);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(User newUser) {
		if (newUser != user) {
			NotificationChain msgs = null;
			if (user != null)
				msgs = ((InternalEObject)user).eInverseRemove(this, CongabasePackage.USER__SERVICES, User.class, msgs);
			if (newUser != null)
				msgs = ((InternalEObject)newUser).eInverseAdd(this, CongabasePackage.USER__SERVICES, User.class, msgs);
			msgs = basicSetUser(newUser, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__USER, newUser, newUser));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyValue getBasicAuth() {
		return basicAuth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBasicAuth(KeyValue newBasicAuth, NotificationChain msgs) {
		KeyValue oldBasicAuth = basicAuth;
		basicAuth = newBasicAuth;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__BASIC_AUTH, oldBasicAuth, newBasicAuth);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasicAuth(KeyValue newBasicAuth) {
		if (newBasicAuth != basicAuth) {
			NotificationChain msgs = null;
			if (basicAuth != null)
				msgs = ((InternalEObject)basicAuth).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CongabasePackage.SERVICE__BASIC_AUTH, null, msgs);
			if (newBasicAuth != null)
				msgs = ((InternalEObject)newBasicAuth).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CongabasePackage.SERVICE__BASIC_AUTH, null, msgs);
			msgs = basicSetBasicAuth(newBasicAuth, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__BASIC_AUTH, newBasicAuth, newBasicAuth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<KeyValue> getHeaders() {
		if (headers == null) {
			headers = new EObjectContainmentEList<KeyValue>(KeyValue.class, this, CongabasePackage.SERVICE__HEADERS);
		}
		return headers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getLastAccess() {
		return lastAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastAccess(Date newLastAccess) {
		Date oldLastAccess = lastAccess;
		lastAccess = newLastAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__LAST_ACCESS, oldLastAccess, lastAccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getServiceId() {
		return serviceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceId(long newServiceId) {
		long oldServiceId = serviceId;
		serviceId = newServiceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__SERVICE_ID, oldServiceId, serviceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CongabasePackage.SERVICE__USER:
				if (user != null)
					msgs = ((InternalEObject)user).eInverseRemove(this, CongabasePackage.USER__SERVICES, User.class, msgs);
				return basicSetUser((User)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CongabasePackage.SERVICE__USER:
				return basicSetUser(null, msgs);
			case CongabasePackage.SERVICE__BASIC_AUTH:
				return basicSetBasicAuth(null, msgs);
			case CongabasePackage.SERVICE__HEADERS:
				return ((InternalEList<?>)getHeaders()).basicRemove(otherEnd, msgs);
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
			case CongabasePackage.SERVICE__URL:
				return getUrl();
			case CongabasePackage.SERVICE__TOOL:
				if (resolve) return getTool();
				return basicGetTool();
			case CongabasePackage.SERVICE__TYPE:
				return getType();
			case CongabasePackage.SERVICE__STATUS:
				return getStatus();
			case CongabasePackage.SERVICE__VERSION:
				return getVersion();
			case CongabasePackage.SERVICE__USER:
				if (resolve) return getUser();
				return basicGetUser();
			case CongabasePackage.SERVICE__BASIC_AUTH:
				return getBasicAuth();
			case CongabasePackage.SERVICE__HEADERS:
				return getHeaders();
			case CongabasePackage.SERVICE__LAST_ACCESS:
				return getLastAccess();
			case CongabasePackage.SERVICE__SERVICE_ID:
				return getServiceId();
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
			case CongabasePackage.SERVICE__URL:
				setUrl((String)newValue);
				return;
			case CongabasePackage.SERVICE__TOOL:
				setTool((Tool)newValue);
				return;
			case CongabasePackage.SERVICE__TYPE:
				setType((ServiceType)newValue);
				return;
			case CongabasePackage.SERVICE__STATUS:
				setStatus((ServiceStatus)newValue);
				return;
			case CongabasePackage.SERVICE__VERSION:
				setVersion((String)newValue);
				return;
			case CongabasePackage.SERVICE__USER:
				setUser((User)newValue);
				return;
			case CongabasePackage.SERVICE__BASIC_AUTH:
				setBasicAuth((KeyValue)newValue);
				return;
			case CongabasePackage.SERVICE__HEADERS:
				getHeaders().clear();
				getHeaders().addAll((Collection<? extends KeyValue>)newValue);
				return;
			case CongabasePackage.SERVICE__LAST_ACCESS:
				setLastAccess((Date)newValue);
				return;
			case CongabasePackage.SERVICE__SERVICE_ID:
				setServiceId((Long)newValue);
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
			case CongabasePackage.SERVICE__URL:
				setUrl(URL_EDEFAULT);
				return;
			case CongabasePackage.SERVICE__TOOL:
				setTool((Tool)null);
				return;
			case CongabasePackage.SERVICE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case CongabasePackage.SERVICE__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case CongabasePackage.SERVICE__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CongabasePackage.SERVICE__USER:
				setUser((User)null);
				return;
			case CongabasePackage.SERVICE__BASIC_AUTH:
				setBasicAuth((KeyValue)null);
				return;
			case CongabasePackage.SERVICE__HEADERS:
				getHeaders().clear();
				return;
			case CongabasePackage.SERVICE__LAST_ACCESS:
				setLastAccess(LAST_ACCESS_EDEFAULT);
				return;
			case CongabasePackage.SERVICE__SERVICE_ID:
				setServiceId(SERVICE_ID_EDEFAULT);
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
			case CongabasePackage.SERVICE__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
			case CongabasePackage.SERVICE__TOOL:
				return tool != null;
			case CongabasePackage.SERVICE__TYPE:
				return type != TYPE_EDEFAULT;
			case CongabasePackage.SERVICE__STATUS:
				return status != STATUS_EDEFAULT;
			case CongabasePackage.SERVICE__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CongabasePackage.SERVICE__USER:
				return user != null;
			case CongabasePackage.SERVICE__BASIC_AUTH:
				return basicAuth != null;
			case CongabasePackage.SERVICE__HEADERS:
				return headers != null && !headers.isEmpty();
			case CongabasePackage.SERVICE__LAST_ACCESS:
				return LAST_ACCESS_EDEFAULT == null ? lastAccess != null : !LAST_ACCESS_EDEFAULT.equals(lastAccess);
			case CongabasePackage.SERVICE__SERVICE_ID:
				return serviceId != SERVICE_ID_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (url: ");
		result.append(url);
		result.append(", type: ");
		result.append(type);
		result.append(", status: ");
		result.append(status);
		result.append(", version: ");
		result.append(version);
		result.append(", lastAccess: ");
		result.append(lastAccess);
		result.append(", serviceId: ");
		result.append(serviceId);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getSortURL() {
		if (getUrl().length()>50) {
			String ret = getUrl().substring(0, 47)+"...";
			return ret;
		}
		return getUrl();
	}

} //ServiceImpl

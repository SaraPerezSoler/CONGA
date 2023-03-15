/**
 */
package congabase.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import congabase.CongabasePackage;
import congabase.KeyValue;
import congabase.Service;
import congabase.ServiceStatus;
import congabase.ServiceType;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Service</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link congabase.impl.ServiceImpl#getUrl <em>Url</em>}</li>
 * <li>{@link congabase.impl.ServiceImpl#getType <em>Type</em>}</li>
 * <li>{@link congabase.impl.ServiceImpl#getStatus <em>Status</em>}</li>
 * <li>{@link congabase.impl.ServiceImpl#getBasicAuth <em>Basic Auth</em>}</li>
 * <li>{@link congabase.impl.ServiceImpl#getHeaders <em>Headers</em>}</li>
 * <li>{@link congabase.impl.ServiceImpl#getLastAccess <em>Last
 * Access</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceImpl extends UtilityImpl implements Service {
	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ServiceType TYPE_EDEFAULT = ServiceType.GENERATOR;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ServiceType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ServiceStatus STATUS_EDEFAULT = ServiceStatus.ON;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected ServiceStatus status = STATUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVersion()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getBasicAuth() <em>Basic Auth</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBasicAuth()
	 * @generated
	 * @ordered
	 */
	protected KeyValue basicAuth;

	/**
	 * The cached value of the '{@link #getHeaders() <em>Headers</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHeaders()
	 * @generated
	 * @ordered
	 */
	protected EList<KeyValue> headers;

	/**
	 * The default value of the '{@link #getLastAccess() <em>Last Access</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLastAccess()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_ACCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastAccess() <em>Last Access</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLastAccess()
	 * @generated
	 * @ordered
	 */
	protected Date lastAccess = LAST_ACCESS_EDEFAULT;

	private static String pattern = "dd/MM/yyyy hh:mm:ss";
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CongabasePackage.Literals.SERVICE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ServiceType getType() {
		return type;
	}

	public String getTypeString() {
		return getType().getLiteral().toLowerCase();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setType(ServiceType newType) {
		ServiceType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ServiceStatus getStatus() {
		return status;
	}

	public String getStatusString() {
		return getStatus().getLiteral();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStatus(ServiceStatus newStatus) {
		ServiceStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public KeyValue getBasicAuth() {
		return basicAuth;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetBasicAuth(KeyValue newBasicAuth, NotificationChain msgs) {
		KeyValue oldBasicAuth = basicAuth;
		basicAuth = newBasicAuth;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					CongabasePackage.SERVICE__BASIC_AUTH, oldBasicAuth, newBasicAuth);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBasicAuth(KeyValue newBasicAuth) {
		if (newBasicAuth != basicAuth) {
			NotificationChain msgs = null;
			if (basicAuth != null)
				msgs = ((InternalEObject) basicAuth).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - CongabasePackage.SERVICE__BASIC_AUTH, null, msgs);
			if (newBasicAuth != null)
				msgs = ((InternalEObject) newBasicAuth).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - CongabasePackage.SERVICE__BASIC_AUTH, null, msgs);
			msgs = basicSetBasicAuth(newBasicAuth, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__BASIC_AUTH, newBasicAuth,
					newBasicAuth));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<KeyValue> getHeaders() {
		if (headers == null) {
			headers = new EObjectContainmentEList<KeyValue>(KeyValue.class, this, CongabasePackage.SERVICE__HEADERS);
		}
		return headers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Date getLastAccess() {
		return lastAccess;
	}

	public String getLastAccessString() {
		if (getLastAccess() != null) {
			return simpleDateFormat.format(getLastAccess());
		} else {
			return "-";
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private void setLastAccess(Date newLastAccess) {
		Date oldLastAccess = lastAccess;
		lastAccess = newLastAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.SERVICE__LAST_ACCESS, oldLastAccess,
					lastAccess));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CongabasePackage.SERVICE__BASIC_AUTH:
			return basicSetBasicAuth(null, msgs);
		case CongabasePackage.SERVICE__HEADERS:
			return ((InternalEList<?>) getHeaders()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CongabasePackage.SERVICE__URL:
			return getUrl();
		case CongabasePackage.SERVICE__TYPE:
			return getType();
		case CongabasePackage.SERVICE__STATUS:
			return getStatus();
		case CongabasePackage.SERVICE__BASIC_AUTH:
			return getBasicAuth();
		case CongabasePackage.SERVICE__HEADERS:
			return getHeaders();
		case CongabasePackage.SERVICE__LAST_ACCESS:
			return getLastAccess();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CongabasePackage.SERVICE__URL:
			setUrl((String) newValue);
			return;
		case CongabasePackage.SERVICE__TYPE:
			setType((ServiceType) newValue);
			return;
		case CongabasePackage.SERVICE__STATUS:
			setStatus((ServiceStatus) newValue);
			return;
		case CongabasePackage.SERVICE__BASIC_AUTH:
			setBasicAuth((KeyValue) newValue);
			return;
		case CongabasePackage.SERVICE__HEADERS:
			getHeaders().clear();
			getHeaders().addAll((Collection<? extends KeyValue>) newValue);
			return;
		case CongabasePackage.SERVICE__LAST_ACCESS:
			setLastAccess((Date) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case CongabasePackage.SERVICE__URL:
			setUrl(URL_EDEFAULT);
			return;
		case CongabasePackage.SERVICE__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case CongabasePackage.SERVICE__STATUS:
			setStatus(STATUS_EDEFAULT);
			return;
		case CongabasePackage.SERVICE__BASIC_AUTH:
			setBasicAuth((KeyValue) null);
			return;
		case CongabasePackage.SERVICE__HEADERS:
			getHeaders().clear();
			return;
		case CongabasePackage.SERVICE__LAST_ACCESS:
			setLastAccess(LAST_ACCESS_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CongabasePackage.SERVICE__URL:
			return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
		case CongabasePackage.SERVICE__TYPE:
			return type != TYPE_EDEFAULT;
		case CongabasePackage.SERVICE__STATUS:
			return status != STATUS_EDEFAULT;
		case CongabasePackage.SERVICE__BASIC_AUTH:
			return basicAuth != null;
		case CongabasePackage.SERVICE__HEADERS:
			return headers != null && !headers.isEmpty();
		case CongabasePackage.SERVICE__LAST_ACCESS:
			return LAST_ACCESS_EDEFAULT == null ? lastAccess != null : !LAST_ACCESS_EDEFAULT.equals(lastAccess);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (url: ");
		result.append(url);
		result.append(", type: ");
		result.append(type);
		result.append(", status: ");
		result.append(status);
		result.append(", lastAccess: ");
		result.append(lastAccess);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getSortURL() {
		if (getUrl().length() > 50) {
			String ret = getUrl().substring(0, 47) + "...";
			return ret;
		}
		return getUrl();
	}

	public File sendAndGetFile(File file, String name) {
		Response response = senService(file, name, MediaType.APPLICATION_OCTET_STREAM);

		MultivaluedMap<String, String> header = response.getStringHeaders();
		List<String> contentType = header.get("Content-type");
		if (response.getStatus() >= 200 && response.getStatus() < 300) {
			if (contentType.contains(MediaType.APPLICATION_OCTET_STREAM)) {
				File output = response.readEntity(File.class);
				String fname = null;
				List<String> contentDisposition = header.get("Content-Disposition");
				if (contentDisposition != null) {
					for (String s : contentDisposition) {
						if (s.contains("filename=")) {
							fname = s.substring(s.indexOf("filename=") + "filename=".length());
							fname = fname.split("\"")[1];
							// System.out.println(name);
						}
					}
				}
				File f = null;
				if (fname != null) {
					f = new File(output.getParent() + "/" + fname);
					if (f.exists()) {
						f.delete();
					}
					output.renameTo(f);

				}
				return f;
			}
		}
		return null;
	}

	public JSONObject sendAndGetJSON(File file, String name) {

		Response response = senService(file, name, MediaType.APPLICATION_JSON);

		MultivaluedMap<String, String> header = response.getStringHeaders();
		List<String> contentType = header.get("Content-type");
		if (response.getStatus() >= 200 && response.getStatus() < 300) {
			if (contentType.contains(MediaType.APPLICATION_JSON)) {
				String output = response.readEntity(String.class);
				try {
					return new JSONObject(output);
				} catch (JSONException e) {
					JSONObject ret = new JSONObject();
					ret.put("problems", new JSONArray(output));
					return ret;
				}
			}
		}
		return null;
	}

	private Response senService(File file, String name, String consumes) {
		@SuppressWarnings("resource")
		final MultiPart multiPart = new FormDataMultiPart().field("file", file, MediaType.APPLICATION_OCTET_STREAM_TYPE)
				.field("name", name, MediaType.TEXT_PLAIN_TYPE);
		multiPart.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(this.getUrl()).register(MultiPartFeature.class);
		if (this.getBasicAuth() != null) {
			if (!this.getBasicAuth().getKey().isEmpty() && !this.getBasicAuth().getKey().isBlank()) {
				HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(this.getBasicAuth().getKey(),
						this.getBasicAuth().getValue().toString().getBytes());
				target = target.register(feature);
			}
		}
		javax.ws.rs.client.Invocation.Builder builder = target.request(consumes);
		for (KeyValue keyValue : this.getHeaders()) {
			builder = builder.header(keyValue.getKey(), keyValue.getValue().toString());
		}
		Response response = builder.post(Entity.entity(multiPart, MediaType.MULTIPART_FORM_DATA_TYPE));
		setLastAccess(new Date());
		return response;
	}

} // ServiceImpl

/**
 */
package congabase;

import java.io.File;
import java.util.Date;
import org.eclipse.emf.common.util.EList;
import org.json.JSONObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congabase.Service#getUrl <em>Url</em>}</li>
 *   <li>{@link congabase.Service#getType <em>Type</em>}</li>
 *   <li>{@link congabase.Service#getStatus <em>Status</em>}</li>
 *   <li>{@link congabase.Service#getBasicAuth <em>Basic Auth</em>}</li>
 *   <li>{@link congabase.Service#getHeaders <em>Headers</em>}</li>
 *   <li>{@link congabase.Service#getLastAccess <em>Last Access</em>}</li>
 * </ul>
 *
 * @see congabase.CongabasePackage#getService()
 * @model
 * @generated
 */
public interface Service extends Utility {
	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see congabase.CongabasePackage#getService_Url()
	 * @model required="true"
	 * @generated
	 */
	String getUrl();
	String getSortURL();

	/**
	 * Sets the value of the '{@link congabase.Service#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link congabase.ServiceType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see congabase.ServiceType
	 * @see #setType(ServiceType)
	 * @see congabase.CongabasePackage#getService_Type()
	 * @model required="true"
	 * @generated
	 */
	ServiceType getType();

	/**
	 * Sets the value of the '{@link congabase.Service#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see congabase.ServiceType
	 * @see #getType()
	 * @generated
	 */
	void setType(ServiceType value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link congabase.ServiceStatus}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see congabase.ServiceStatus
	 * @see #setStatus(ServiceStatus)
	 * @see congabase.CongabasePackage#getService_Status()
	 * @model required="true"
	 * @generated
	 */
	ServiceStatus getStatus();

	/**
	 * Sets the value of the '{@link congabase.Service#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see congabase.ServiceStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(ServiceStatus value);

	/**
	 * Returns the value of the '<em><b>Basic Auth</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basic Auth</em>' containment reference.
	 * @see #setBasicAuth(KeyValue)
	 * @see congabase.CongabasePackage#getService_BasicAuth()
	 * @model containment="true"
	 * @generated
	 */
	KeyValue getBasicAuth();

	/**
	 * Sets the value of the '{@link congabase.Service#getBasicAuth <em>Basic Auth</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basic Auth</em>' containment reference.
	 * @see #getBasicAuth()
	 * @generated
	 */
	void setBasicAuth(KeyValue value);

	/**
	 * Returns the value of the '<em><b>Headers</b></em>' containment reference list.
	 * The list contents are of type {@link congabase.KeyValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Headers</em>' containment reference list.
	 * @see congabase.CongabasePackage#getService_Headers()
	 * @model containment="true"
	 * @generated
	 */
	EList<KeyValue> getHeaders();

	/**
	 * Returns the value of the '<em><b>Last Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Access</em>' attribute.
	 * @see #setLastAccess(Date)
	 * @see congabase.CongabasePackage#getService_LastAccess()
	 * @model
	 * @generated
	 */
	Date getLastAccess();

	/**
	 * Sets the value of the '{@link congabase.Service#getLastAccess <em>Last Access</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Access</em>' attribute.
	 * @see #getLastAccess()
	 * @generated
	 */
	//void setLastAccess(Date value);

	File sendAndGetFile(File f, String botName);
	JSONObject sendAndGetJSON(File file, String name);

} // Service

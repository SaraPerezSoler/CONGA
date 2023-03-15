/**
 */
package congabase;

import org.eclipse.emf.ecore.EObject;

import recommenderQuestionnaire.Tool;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Utility</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congabase.Utility#getServiceId <em>Service Id</em>}</li>
 *   <li>{@link congabase.Utility#getTool <em>Tool</em>}</li>
 *   <li>{@link congabase.Utility#getVersion <em>Version</em>}</li>
 *   <li>{@link congabase.Utility#getUser <em>User</em>}</li>
 * </ul>
 *
 * @see congabase.CongabasePackage#getUtility()
 * @model abstract="true"
 * @generated
 */
public interface Utility extends EObject {
	/**
	 * Returns the value of the '<em><b>Service Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Id</em>' attribute.
	 * @see #setServiceId(long)
	 * @see congabase.CongabasePackage#getUtility_ServiceId()
	 * @model required="true"
	 * @generated
	 */
	long getServiceId();

	/**
	 * Sets the value of the '{@link congabase.Utility#getServiceId <em>Service Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Id</em>' attribute.
	 * @see #getServiceId()
	 * @generated
	 */
	void setServiceId(long value);

	/**
	 * Returns the value of the '<em><b>Tool</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tool</em>' reference.
	 * @see #setTool(Tool)
	 * @see congabase.CongabasePackage#getUtility_Tool()
	 * @model required="true"
	 * @generated
	 */
	Tool getTool();

	/**
	 * Sets the value of the '{@link congabase.Utility#getTool <em>Tool</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tool</em>' reference.
	 * @see #getTool()
	 * @generated
	 */
	void setTool(Tool value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see congabase.CongabasePackage#getUtility_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link congabase.Utility#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>User</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link congabase.User#getUtilities <em>Utilities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' reference.
	 * @see #setUser(User)
	 * @see congabase.CongabasePackage#getUtility_User()
	 * @see congabase.User#getUtilities
	 * @model opposite="utilities" required="true"
	 * @generated
	 */
	User getUser();

	/**
	 * Sets the value of the '{@link congabase.Utility#getUser <em>User</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' reference.
	 * @see #getUser()
	 * @generated
	 */
	void setUser(User value);
	
	String getTypeString();
	String getSortURL();
	String getLastAccessString();
	String getStatusString();


} // Utility

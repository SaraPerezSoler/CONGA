/**
 */
package congabase;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congabase.User#getNick <em>Nick</em>}</li>
 *   <li>{@link congabase.User#getPassword <em>Password</em>}</li>
 *   <li>{@link congabase.User#getProjects <em>Projects</em>}</li>
 *   <li>{@link congabase.User#getUtilities <em>Utilities</em>}</li>
 * </ul>
 *
 * @see congabase.CongabasePackage#getUser()
 * @model
 * @generated
 */
public interface User extends EObject {
	/**
	 * Returns the value of the '<em><b>Nick</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nick</em>' attribute.
	 * @see #setNick(String)
	 * @see congabase.CongabasePackage#getUser_Nick()
	 * @model required="true"
	 * @generated
	 */
	String getNick();

	/**
	 * Sets the value of the '{@link congabase.User#getNick <em>Nick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nick</em>' attribute.
	 * @see #getNick()
	 * @generated
	 */
	void setNick(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see congabase.CongabasePackage#getUser_Password()
	 * @model required="true"
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link congabase.User#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' reference list.
	 * The list contents are of type {@link congabase.Project}.
	 * It is bidirectional and its opposite is '{@link congabase.Project#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' reference list.
	 * @see congabase.CongabasePackage#getUser_Projects()
	 * @see congabase.Project#getOwner
	 * @model opposite="owner"
	 * @generated
	 */
	EList<Project> getProjects();

	List<RecommenderOption> getRecommenderOptions();
	EList<Utility> getUtilities();
	List<Service> getServices();

	Project get(String project);

	boolean containService(String tool, String version, String type);

} // User

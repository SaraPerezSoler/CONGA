/**
 */
package congabase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import recommenderQuestionnaire.Questionnaire;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conga System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congabase.CongaSystem#getUsers <em>Users</em>}</li>
 *   <li>{@link congabase.CongaSystem#getProjects <em>Projects</em>}</li>
 *   <li>{@link congabase.CongaSystem#getQuestionnaire <em>Questionnaire</em>}</li>
 *   <li>{@link congabase.CongaSystem#getGenerators <em>Generators</em>}</li>
 *   <li>{@link congabase.CongaSystem#getConverters <em>Converters</em>}</li>
 *   <li>{@link congabase.CongaSystem#getValidators <em>Validators</em>}</li>
 *   <li>{@link congabase.CongaSystem#getQOptions <em>QOptions</em>}</li>
 * </ul>
 *
 * @see congabase.CongabasePackage#getCongaSystem()
 * @model
 * @generated
 */
public interface CongaSystem extends EObject {
	/**
	 * Returns the value of the '<em><b>Users</b></em>' containment reference list.
	 * The list contents are of type {@link congabase.User}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Users</em>' containment reference list.
	 * @see congabase.CongabasePackage#getCongaSystem_Users()
	 * @model containment="true"
	 * @generated
	 */
	EList<User> getUsers();

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list.
	 * The list contents are of type {@link congabase.Project}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see congabase.CongabasePackage#getCongaSystem_Projects()
	 * @model containment="true"
	 * @generated
	 */
	EList<Project> getProjects();

	/**
	 * Returns the value of the '<em><b>Questionnaire</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Questionnaire</em>' containment reference.
	 * @see #setQuestionnaire(Questionnaire)
	 * @see congabase.CongabasePackage#getCongaSystem_Questionnaire()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Questionnaire getQuestionnaire();

	/**
	 * Sets the value of the '{@link congabase.CongaSystem#getQuestionnaire <em>Questionnaire</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Questionnaire</em>' containment reference.
	 * @see #getQuestionnaire()
	 * @generated
	 */
	void setQuestionnaire(Questionnaire value);

	/**
	 * Returns the value of the '<em><b>Generators</b></em>' containment reference list.
	 * The list contents are of type {@link congabase.Service}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generators</em>' containment reference list.
	 * @see congabase.CongabasePackage#getCongaSystem_Generators()
	 * @model containment="true"
	 * @generated
	 */
	EList<Service> getGenerators();

	/**
	 * Returns the value of the '<em><b>Converters</b></em>' containment reference list.
	 * The list contents are of type {@link congabase.Service}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Converters</em>' containment reference list.
	 * @see congabase.CongabasePackage#getCongaSystem_Converters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Service> getConverters();

	/**
	 * Returns the value of the '<em><b>Validators</b></em>' containment reference list.
	 * The list contents are of type {@link congabase.Service}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validators</em>' containment reference list.
	 * @see congabase.CongabasePackage#getCongaSystem_Validators()
	 * @model containment="true"
	 * @generated
	 */
	EList<Service> getValidators();

	/**
	 * Returns the value of the '<em><b>QOptions</b></em>' containment reference list.
	 * The list contents are of type {@link congabase.RecommenderOption}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>QOptions</em>' containment reference list.
	 * @see congabase.CongabasePackage#getCongaSystem_QOptions()
	 * @model containment="true"
	 * @generated
	 */
	EList<RecommenderOption> getQOptions();

	User getUser(String user);


} // CongaSystem

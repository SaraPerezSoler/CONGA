/**
 */
package congabase;

import java.io.File;
import java.util.Date;
import org.eclipse.emf.ecore.EObject;


import validation.problems.ProblemSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congabase.Project#getName <em>Name</em>}</li>
 *   <li>{@link congabase.Project#getOwner <em>Owner</em>}</li>
 *   <li>{@link congabase.Project#getQuestionnaire <em>Questionnaire</em>}</li>
 *   <li>{@link congabase.Project#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link congabase.Project#getModificationDate <em>Modification Date</em>}</li>
 * </ul>
 *
 * @see congabase.CongabasePackage#getProject()
 * @model
 * @generated
 */
public interface Project extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see congabase.CongabasePackage#getProject_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link congabase.Project#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link congabase.User#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(User)
	 * @see congabase.CongabasePackage#getProject_Owner()
	 * @see congabase.User#getProjects
	 * @model opposite="projects" required="true"
	 * @generated
	 */
	User getOwner();

	/**
	 * Sets the value of the '{@link congabase.Project#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(User value);

	/**
	 * Returns the value of the '<em><b>Questionnaire</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Questionnaire</em>' containment reference.
	 * @see #setQuestionnaire(UserAnswer)
	 * @see congabase.CongabasePackage#getProject_Questionnaire()
	 * @model containment="true"
	 * @generated
	 */
	UserAnswer getQuestionnaire();

	String getQuestionnaireDateString();
	/**
	 * Sets the value of the '{@link congabase.Project#getQuestionnaire <em>Questionnaire</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Questionnaire</em>' containment reference.
	 * @see #getQuestionnaire()
	 * @generated
	 */
	void setQuestionnaire(UserAnswer value);

	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(Date)
	 * @see congabase.CongabasePackage#getProject_CreationDate()
	 * @model required="true"
	 * @generated
	 */
	Date getCreationDate();
	
	String getCreationDateString();

	/**
	 * Sets the value of the '{@link congabase.Project#getCreationDate <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(Date value);

	/**
	 * Returns the value of the '<em><b>Modification Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modification Date</em>' attribute.
	 * @see #setModificationDate(Date)
	 * @see congabase.CongabasePackage#getProject_ModificationDate()
	 * @model required="true"
	 * @generated
	 */
	Date getModificationDate();
	String getModificationDateString();

	/**
	 * Sets the value of the '{@link congabase.Project#getModificationDate <em>Modification Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modification Date</em>' attribute.
	 * @see #getModificationDate()
	 * @generated
	 */
	void setModificationDate(Date value);
	
	Service getCurrentValidator();

	void setCurrentValidator(Service currentValidator);
	void validate(File f) throws Exception;
	ProblemSet getProblemSet();
} // Project

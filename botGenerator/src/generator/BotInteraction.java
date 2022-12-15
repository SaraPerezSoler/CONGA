/**
 */
package generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bot Interaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link generator.BotInteraction#getActions <em>Actions</em>}</li>
 *   <li>{@link generator.BotInteraction#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link generator.BotInteraction#getOutcoming <em>Outcoming</em>}</li>
 *   <li>{@link generator.BotInteraction#getBackTo <em>Back To</em>}</li>
 *   <li>{@link generator.BotInteraction#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see generator.GeneratorPackage#getBotInteraction()
 * @model
 * @generated
 */
public interface BotInteraction extends Interaction {
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' reference list.
	 * The list contents are of type {@link generator.Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' reference list.
	 * @see generator.GeneratorPackage#getBotInteraction_Actions()
	 * @model
	 * @generated
	 */
	EList<Action> getActions();

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link generator.UserInteraction#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' container reference.
	 * @see #setIncoming(UserInteraction)
	 * @see generator.GeneratorPackage#getBotInteraction_Incoming()
	 * @see generator.UserInteraction#getTarget
	 * @model opposite="target" required="true" transient="false"
	 * @generated
	 */
	UserInteraction getIncoming();

	/**
	 * Sets the value of the '{@link generator.BotInteraction#getIncoming <em>Incoming</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming</em>' container reference.
	 * @see #getIncoming()
	 * @generated
	 */
	void setIncoming(UserInteraction value);

	/**
	 * Returns the value of the '<em><b>Outcoming</b></em>' containment reference list.
	 * The list contents are of type {@link generator.UserInteraction}.
	 * It is bidirectional and its opposite is '{@link generator.UserInteraction#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outcoming</em>' containment reference list.
	 * @see generator.GeneratorPackage#getBotInteraction_Outcoming()
	 * @see generator.UserInteraction#getSrc
	 * @model opposite="src" containment="true"
	 * @generated
	 */
	EList<UserInteraction> getOutcoming();

	/**
	 * Returns the value of the '<em><b>Back To</b></em>' reference list.
	 * The list contents are of type {@link generator.UserInteraction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Back To</em>' reference list.
	 * @see generator.GeneratorPackage#getBotInteraction_BackTo()
	 * @model
	 * @generated
	 */
	EList<UserInteraction> getBackTo();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see generator.GeneratorPackage#getBotInteraction_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link generator.BotInteraction#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	boolean flowHasAction(Action action);

} // BotInteraction

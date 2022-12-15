/**
 */
package generator.impl;

import generator.Action;
import generator.BotInteraction;
import generator.GeneratorPackage;
import generator.UserInteraction;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bot Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link generator.impl.BotInteractionImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link generator.impl.BotInteractionImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link generator.impl.BotInteractionImpl#getOutcoming <em>Outcoming</em>}</li>
 *   <li>{@link generator.impl.BotInteractionImpl#getBackTo <em>Back To</em>}</li>
 *   <li>{@link generator.impl.BotInteractionImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BotInteractionImpl extends InteractionImpl implements BotInteraction {
	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * The cached value of the '{@link #getOutcoming() <em>Outcoming</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutcoming()
	 * @generated
	 * @ordered
	 */
	protected EList<UserInteraction> outcoming;
	

	/**
	 * The cached value of the '{@link #getBackTo() <em>Back To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackTo()
	 * @generated
	 * @ordered
	 */
	protected EList<UserInteraction> backTo;


	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BotInteractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.BOT_INTERACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Action> getActions() {
		if (actions == null) {
			actions = new EObjectResolvingEList<Action>(Action.class, this, GeneratorPackage.BOT_INTERACTION__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UserInteraction getIncoming() {
		if (eContainerFeatureID() != GeneratorPackage.BOT_INTERACTION__INCOMING) return null;
		return (UserInteraction)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncoming(UserInteraction newIncoming, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newIncoming, GeneratorPackage.BOT_INTERACTION__INCOMING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIncoming(UserInteraction newIncoming) {
		if (newIncoming != eInternalContainer() || (eContainerFeatureID() != GeneratorPackage.BOT_INTERACTION__INCOMING && newIncoming != null)) {
			if (EcoreUtil.isAncestor(this, newIncoming))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newIncoming != null)
				msgs = ((InternalEObject)newIncoming).eInverseAdd(this, GeneratorPackage.USER_INTERACTION__TARGET, UserInteraction.class, msgs);
			msgs = basicSetIncoming(newIncoming, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.BOT_INTERACTION__INCOMING, newIncoming, newIncoming));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UserInteraction> getOutcoming() {
		if (outcoming == null) {
			outcoming = new EObjectContainmentWithInverseEList<UserInteraction>(UserInteraction.class, this, GeneratorPackage.BOT_INTERACTION__OUTCOMING, GeneratorPackage.USER_INTERACTION__SRC);
		}
		return outcoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UserInteraction> getBackTo() {
		if (backTo == null) {
			backTo = new EObjectResolvingEList<UserInteraction>(UserInteraction.class, this, GeneratorPackage.BOT_INTERACTION__BACK_TO);
		}
		return backTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.BOT_INTERACTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.BOT_INTERACTION__INCOMING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetIncoming((UserInteraction)otherEnd, msgs);
			case GeneratorPackage.BOT_INTERACTION__OUTCOMING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutcoming()).basicAdd(otherEnd, msgs);
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
			case GeneratorPackage.BOT_INTERACTION__INCOMING:
				return basicSetIncoming(null, msgs);
			case GeneratorPackage.BOT_INTERACTION__OUTCOMING:
				return ((InternalEList<?>)getOutcoming()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GeneratorPackage.BOT_INTERACTION__INCOMING:
				return eInternalContainer().eInverseRemove(this, GeneratorPackage.USER_INTERACTION__TARGET, UserInteraction.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorPackage.BOT_INTERACTION__ACTIONS:
				return getActions();
			case GeneratorPackage.BOT_INTERACTION__INCOMING:
				return getIncoming();
			case GeneratorPackage.BOT_INTERACTION__OUTCOMING:
				return getOutcoming();
			case GeneratorPackage.BOT_INTERACTION__BACK_TO:
				return getBackTo();
			case GeneratorPackage.BOT_INTERACTION__NAME:
				return getName();
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
			case GeneratorPackage.BOT_INTERACTION__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case GeneratorPackage.BOT_INTERACTION__INCOMING:
				setIncoming((UserInteraction)newValue);
				return;
			case GeneratorPackage.BOT_INTERACTION__OUTCOMING:
				getOutcoming().clear();
				getOutcoming().addAll((Collection<? extends UserInteraction>)newValue);
				return;
			case GeneratorPackage.BOT_INTERACTION__BACK_TO:
				getBackTo().clear();
				getBackTo().addAll((Collection<? extends UserInteraction>)newValue);
				return;
			case GeneratorPackage.BOT_INTERACTION__NAME:
				setName((String)newValue);
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
			case GeneratorPackage.BOT_INTERACTION__ACTIONS:
				getActions().clear();
				return;
			case GeneratorPackage.BOT_INTERACTION__INCOMING:
				setIncoming((UserInteraction)null);
				return;
			case GeneratorPackage.BOT_INTERACTION__OUTCOMING:
				getOutcoming().clear();
				return;
			case GeneratorPackage.BOT_INTERACTION__BACK_TO:
				getBackTo().clear();
				return;
			case GeneratorPackage.BOT_INTERACTION__NAME:
				setName(NAME_EDEFAULT);
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
			case GeneratorPackage.BOT_INTERACTION__ACTIONS:
				return actions != null && !actions.isEmpty();
			case GeneratorPackage.BOT_INTERACTION__INCOMING:
				return getIncoming() != null;
			case GeneratorPackage.BOT_INTERACTION__OUTCOMING:
				return outcoming != null && !outcoming.isEmpty();
			case GeneratorPackage.BOT_INTERACTION__BACK_TO:
				return backTo != null && !backTo.isEmpty();
			case GeneratorPackage.BOT_INTERACTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getActions() == null) ? 0 : getActions().hashCode());
		result = prime * result + ((getOutcoming() == null) ? 0 : getOutcoming().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BotInteractionImpl other = (BotInteractionImpl) obj;
		if (getActions() == null) {
			if (other.getActions() != null)
				return false;
		} else if (!getActions().equals(other.getActions()))
			return false;
		if (getOutcoming() == null) {
			if (other.getOutcoming() != null)
				return false;
		} else if (!getOutcoming().equals(other.getOutcoming()))
			return false;
		return true;
	}

	@Override
	public boolean flowHasAction(Action action) {
		if (this.getActions().contains(action)) {
			return true;
		}
		for (UserInteraction ui: this.getOutcoming()) {
			if (ui.flowHasAction(action)) {
				return true;
			}
		}
		return false;
	}
	
	

} //BotInteractionImpl

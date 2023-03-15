/**
 */
package congabase.impl;

import congabase.CongabasePackage;
import congabase.Project;
import congabase.RecommenderOption;
import congabase.Service;
import congabase.ServiceType;
import congabase.User;


import congabase.Utility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link congabase.impl.UserImpl#getNick <em>Nick</em>}</li>
 *   <li>{@link congabase.impl.UserImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link congabase.impl.UserImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link congabase.impl.UserImpl#getUtilities <em>Utilities</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UserImpl extends MinimalEObjectImpl.Container implements User {
	/**
	 * The default value of the '{@link #getNick() <em>Nick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNick()
	 * @generated
	 * @ordered
	 */
	protected static final String NICK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNick() <em>Nick</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNick()
	 * @generated
	 * @ordered
	 */
	protected String nick = NICK_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<Project> projects;

	/**
	 * The cached value of the '{@link #getUtilities() <em>Utilities</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilities()
	 * @generated
	 * @ordered
	 */
	protected EList<Utility> utilities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CongabasePackage.Literals.USER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNick(String newNick) {
		String oldNick = nick;
		nick = newNick;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.USER__NICK, oldNick, nick));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.USER__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Project> getProjects() {
		if (projects == null) {
			projects = new EObjectWithInverseResolvingEList<Project>(Project.class, this, CongabasePackage.USER__PROJECTS, CongabasePackage.PROJECT__OWNER);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Utility> getUtilities() {
		if (utilities == null) {
			utilities = new EObjectWithInverseResolvingEList<Utility>(Utility.class, this, CongabasePackage.USER__UTILITIES, CongabasePackage.UTILITY__USER);
		}
		return utilities;
	}

	public List<RecommenderOption> getRecommenderOptions() {
		List<RecommenderOption> ret = new ArrayList<RecommenderOption>();
		for (Utility u: getUtilities()) {
			if (u instanceof RecommenderOption) {
				ret.add((RecommenderOption)u);
			}
		}
		return ret;
	}
	
	public List<Service> getServices() {
		List<Service> ret = new ArrayList<Service>();
		for (Utility u: getUtilities()) {
			if (u instanceof Service) {
				ret.add((Service)u);
			}
		}
		return ret;
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
			case CongabasePackage.USER__PROJECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProjects()).basicAdd(otherEnd, msgs);
			case CongabasePackage.USER__UTILITIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUtilities()).basicAdd(otherEnd, msgs);
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
			case CongabasePackage.USER__PROJECTS:
				return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
			case CongabasePackage.USER__UTILITIES:
				return ((InternalEList<?>)getUtilities()).basicRemove(otherEnd, msgs);
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
			case CongabasePackage.USER__NICK:
				return getNick();
			case CongabasePackage.USER__PASSWORD:
				return getPassword();
			case CongabasePackage.USER__PROJECTS:
				return getProjects();
			case CongabasePackage.USER__UTILITIES:
				return getUtilities();
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
			case CongabasePackage.USER__NICK:
				setNick((String)newValue);
				return;
			case CongabasePackage.USER__PASSWORD:
				setPassword((String)newValue);
				return;
			case CongabasePackage.USER__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends Project>)newValue);
				return;
			case CongabasePackage.USER__UTILITIES:
				getUtilities().clear();
				getUtilities().addAll((Collection<? extends Utility>)newValue);
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
			case CongabasePackage.USER__NICK:
				setNick(NICK_EDEFAULT);
				return;
			case CongabasePackage.USER__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case CongabasePackage.USER__PROJECTS:
				getProjects().clear();
				return;
			case CongabasePackage.USER__UTILITIES:
				getUtilities().clear();
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
			case CongabasePackage.USER__NICK:
				return NICK_EDEFAULT == null ? nick != null : !NICK_EDEFAULT.equals(nick);
			case CongabasePackage.USER__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case CongabasePackage.USER__PROJECTS:
				return projects != null && !projects.isEmpty();
			case CongabasePackage.USER__UTILITIES:
				return utilities != null && !utilities.isEmpty();
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
		result.append(" (nick: ");
		result.append(nick);
		result.append(", password: ");
		result.append(password);
		result.append(')');
		return result.toString();
	}

	@Override
	public Project get(String project) {
		for (Project prjt: getProjects()) {
			if (prjt.getName().equalsIgnoreCase(project)) {
				return prjt;
			}
		}
		return null;
	}

	@Override
	public boolean containService(String tool, String version, String type) {
		ServiceType sType = ServiceType.valueOf(type.toUpperCase());
		
		for (Service s: getServices()) {
			if (s.getTool().getName().equals(tool) && s.getVersion().equals(version) && s.getType().equals(sType)) {
				return true;
			}
		}
		return false;
	}

} //UserImpl

/**
 */
package congabase.impl;

import congabase.CongaSystem;
import congabase.CongabasePackage;
import congabase.Project;
import congabase.RecommenderOption;
import congabase.Service;
import congabase.User;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import recommenderQuestionnaire.Questionnaire;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conga System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link congabase.impl.CongaSystemImpl#getUsers <em>Users</em>}</li>
 *   <li>{@link congabase.impl.CongaSystemImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link congabase.impl.CongaSystemImpl#getQuestionnaire <em>Questionnaire</em>}</li>
 *   <li>{@link congabase.impl.CongaSystemImpl#getGenerators <em>Generators</em>}</li>
 *   <li>{@link congabase.impl.CongaSystemImpl#getConverters <em>Converters</em>}</li>
 *   <li>{@link congabase.impl.CongaSystemImpl#getValidators <em>Validators</em>}</li>
 *   <li>{@link congabase.impl.CongaSystemImpl#getQOptions <em>QOptions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CongaSystemImpl extends MinimalEObjectImpl.Container implements CongaSystem {
	/**
	 * The cached value of the '{@link #getUsers() <em>Users</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsers()
	 * @generated
	 * @ordered
	 */
	protected EList<User> users;

	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<Project> projects;

	/**
	 * The cached value of the '{@link #getQuestionnaire() <em>Questionnaire</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuestionnaire()
	 * @generated
	 * @ordered
	 */
	protected Questionnaire questionnaire;

	/**
	 * The cached value of the '{@link #getGenerators() <em>Generators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerators()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> generators;

	/**
	 * The cached value of the '{@link #getConverters() <em>Converters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConverters()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> converters;

	/**
	 * The cached value of the '{@link #getValidators() <em>Validators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidators()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> validators;

	/**
	 * The cached value of the '{@link #getQOptions() <em>QOptions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<RecommenderOption> qOptions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CongaSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CongabasePackage.Literals.CONGA_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<User> getUsers() {
		if (users == null) {
			users = new EObjectContainmentEList<User>(User.class, this, CongabasePackage.CONGA_SYSTEM__USERS);
		}
		return users;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Project> getProjects() {
		if (projects == null) {
			projects = new EObjectContainmentEList<Project>(Project.class, this, CongabasePackage.CONGA_SYSTEM__PROJECTS);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQuestionnaire(Questionnaire newQuestionnaire, NotificationChain msgs) {
		Questionnaire oldQuestionnaire = questionnaire;
		questionnaire = newQuestionnaire;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CongabasePackage.CONGA_SYSTEM__QUESTIONNAIRE, oldQuestionnaire, newQuestionnaire);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuestionnaire(Questionnaire newQuestionnaire) {
		if (newQuestionnaire != questionnaire) {
			NotificationChain msgs = null;
			if (questionnaire != null)
				msgs = ((InternalEObject)questionnaire).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CongabasePackage.CONGA_SYSTEM__QUESTIONNAIRE, null, msgs);
			if (newQuestionnaire != null)
				msgs = ((InternalEObject)newQuestionnaire).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CongabasePackage.CONGA_SYSTEM__QUESTIONNAIRE, null, msgs);
			msgs = basicSetQuestionnaire(newQuestionnaire, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.CONGA_SYSTEM__QUESTIONNAIRE, newQuestionnaire, newQuestionnaire));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getGenerators() {
		if (generators == null) {
			generators = new EObjectContainmentEList<Service>(Service.class, this, CongabasePackage.CONGA_SYSTEM__GENERATORS);
		}
		return generators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getConverters() {
		if (converters == null) {
			converters = new EObjectContainmentEList<Service>(Service.class, this, CongabasePackage.CONGA_SYSTEM__CONVERTERS);
		}
		return converters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getValidators() {
		if (validators == null) {
			validators = new EObjectContainmentEList<Service>(Service.class, this, CongabasePackage.CONGA_SYSTEM__VALIDATORS);
		}
		return validators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RecommenderOption> getQOptions() {
		if (qOptions == null) {
			qOptions = new EObjectContainmentEList<RecommenderOption>(RecommenderOption.class, this, CongabasePackage.CONGA_SYSTEM__QOPTIONS);
		}
		return qOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CongabasePackage.CONGA_SYSTEM__USERS:
				return ((InternalEList<?>)getUsers()).basicRemove(otherEnd, msgs);
			case CongabasePackage.CONGA_SYSTEM__PROJECTS:
				return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
			case CongabasePackage.CONGA_SYSTEM__QUESTIONNAIRE:
				return basicSetQuestionnaire(null, msgs);
			case CongabasePackage.CONGA_SYSTEM__GENERATORS:
				return ((InternalEList<?>)getGenerators()).basicRemove(otherEnd, msgs);
			case CongabasePackage.CONGA_SYSTEM__CONVERTERS:
				return ((InternalEList<?>)getConverters()).basicRemove(otherEnd, msgs);
			case CongabasePackage.CONGA_SYSTEM__VALIDATORS:
				return ((InternalEList<?>)getValidators()).basicRemove(otherEnd, msgs);
			case CongabasePackage.CONGA_SYSTEM__QOPTIONS:
				return ((InternalEList<?>)getQOptions()).basicRemove(otherEnd, msgs);
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
			case CongabasePackage.CONGA_SYSTEM__USERS:
				return getUsers();
			case CongabasePackage.CONGA_SYSTEM__PROJECTS:
				return getProjects();
			case CongabasePackage.CONGA_SYSTEM__QUESTIONNAIRE:
				return getQuestionnaire();
			case CongabasePackage.CONGA_SYSTEM__GENERATORS:
				return getGenerators();
			case CongabasePackage.CONGA_SYSTEM__CONVERTERS:
				return getConverters();
			case CongabasePackage.CONGA_SYSTEM__VALIDATORS:
				return getValidators();
			case CongabasePackage.CONGA_SYSTEM__QOPTIONS:
				return getQOptions();
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
			case CongabasePackage.CONGA_SYSTEM__USERS:
				getUsers().clear();
				getUsers().addAll((Collection<? extends User>)newValue);
				return;
			case CongabasePackage.CONGA_SYSTEM__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends Project>)newValue);
				return;
			case CongabasePackage.CONGA_SYSTEM__QUESTIONNAIRE:
				setQuestionnaire((Questionnaire)newValue);
				return;
			case CongabasePackage.CONGA_SYSTEM__GENERATORS:
				getGenerators().clear();
				getGenerators().addAll((Collection<? extends Service>)newValue);
				return;
			case CongabasePackage.CONGA_SYSTEM__CONVERTERS:
				getConverters().clear();
				getConverters().addAll((Collection<? extends Service>)newValue);
				return;
			case CongabasePackage.CONGA_SYSTEM__VALIDATORS:
				getValidators().clear();
				getValidators().addAll((Collection<? extends Service>)newValue);
				return;
			case CongabasePackage.CONGA_SYSTEM__QOPTIONS:
				getQOptions().clear();
				getQOptions().addAll((Collection<? extends RecommenderOption>)newValue);
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
			case CongabasePackage.CONGA_SYSTEM__USERS:
				getUsers().clear();
				return;
			case CongabasePackage.CONGA_SYSTEM__PROJECTS:
				getProjects().clear();
				return;
			case CongabasePackage.CONGA_SYSTEM__QUESTIONNAIRE:
				setQuestionnaire((Questionnaire)null);
				return;
			case CongabasePackage.CONGA_SYSTEM__GENERATORS:
				getGenerators().clear();
				return;
			case CongabasePackage.CONGA_SYSTEM__CONVERTERS:
				getConverters().clear();
				return;
			case CongabasePackage.CONGA_SYSTEM__VALIDATORS:
				getValidators().clear();
				return;
			case CongabasePackage.CONGA_SYSTEM__QOPTIONS:
				getQOptions().clear();
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
			case CongabasePackage.CONGA_SYSTEM__USERS:
				return users != null && !users.isEmpty();
			case CongabasePackage.CONGA_SYSTEM__PROJECTS:
				return projects != null && !projects.isEmpty();
			case CongabasePackage.CONGA_SYSTEM__QUESTIONNAIRE:
				return questionnaire != null;
			case CongabasePackage.CONGA_SYSTEM__GENERATORS:
				return generators != null && !generators.isEmpty();
			case CongabasePackage.CONGA_SYSTEM__CONVERTERS:
				return converters != null && !converters.isEmpty();
			case CongabasePackage.CONGA_SYSTEM__VALIDATORS:
				return validators != null && !validators.isEmpty();
			case CongabasePackage.CONGA_SYSTEM__QOPTIONS:
				return qOptions != null && !qOptions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public User getUser(String user) {
		for (User u: getUsers()) {
			if (u.getNick().equalsIgnoreCase(user)) {
				return u;
			}
		}
		return null;
	}

} //CongaSystemImpl

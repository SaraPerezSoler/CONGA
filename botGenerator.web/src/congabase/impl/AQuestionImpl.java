/**
 */
package congabase.impl;

import congabase.AQuestion;
import congabase.CongabasePackage;
import congabase.RecommenderOption;
import congabase.RelevanceLevel;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import recommenderQuestionnaire.Option;
import recommenderQuestionnaire.Question;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>AQuestion</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link congabase.impl.AQuestionImpl#getQuestion <em>Question</em>}</li>
 *   <li>{@link congabase.impl.AQuestionImpl#getSelecteds <em>Selecteds</em>}</li>
 *   <li>{@link congabase.impl.AQuestionImpl#getRelevance <em>Relevance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AQuestionImpl extends MinimalEObjectImpl.Container implements AQuestion {
	/**
	 * The cached value of the '{@link #getQuestion() <em>Question</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getQuestion()
	 * @generated
	 * @ordered
	 */
	protected Question question;

	/**
	 * The cached value of the '{@link #getSelecteds() <em>Selecteds</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSelecteds()
	 * @generated
	 * @ordered
	 */
	protected EList<Option> selecteds;

	/**
	 * The default value of the '{@link #getRelevance() <em>Relevance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRelevance()
	 * @generated
	 * @ordered
	 */
	protected static final RelevanceLevel RELEVANCE_EDEFAULT = RelevanceLevel.RELEVANT;

	/**
	 * The cached value of the '{@link #getRelevance() <em>Relevance</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRelevance()
	 * @generated
	 * @ordered
	 */
	protected RelevanceLevel relevance = RELEVANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AQuestionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CongabasePackage.Literals.AQUESTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Question getQuestion() {
		if (question != null && question.eIsProxy()) {
			InternalEObject oldQuestion = (InternalEObject)question;
			question = (Question)eResolveProxy(oldQuestion);
			if (question != oldQuestion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CongabasePackage.AQUESTION__QUESTION, oldQuestion, question));
			}
		}
		return question;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Question basicGetQuestion() {
		return question;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuestion(Question newQuestion) {
		Question oldQuestion = question;
		question = newQuestion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.AQUESTION__QUESTION, oldQuestion, question));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Option> getSelecteds() {
		if (selecteds == null) {
			selecteds = new EObjectResolvingEList<Option>(Option.class, this, CongabasePackage.AQUESTION__SELECTEDS);
		}
		return selecteds;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RelevanceLevel getRelevance() {
		return relevance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelevance(RelevanceLevel newRelevance) {
		RelevanceLevel oldRelevance = relevance;
		relevance = newRelevance == null ? RELEVANCE_EDEFAULT : newRelevance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.AQUESTION__RELEVANCE, oldRelevance, relevance));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CongabasePackage.AQUESTION__QUESTION:
				if (resolve) return getQuestion();
				return basicGetQuestion();
			case CongabasePackage.AQUESTION__SELECTEDS:
				return getSelecteds();
			case CongabasePackage.AQUESTION__RELEVANCE:
				return getRelevance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CongabasePackage.AQUESTION__QUESTION:
				setQuestion((Question)newValue);
				return;
			case CongabasePackage.AQUESTION__SELECTEDS:
				getSelecteds().clear();
				getSelecteds().addAll((Collection<? extends Option>)newValue);
				return;
			case CongabasePackage.AQUESTION__RELEVANCE:
				setRelevance((RelevanceLevel)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CongabasePackage.AQUESTION__QUESTION:
				setQuestion((Question)null);
				return;
			case CongabasePackage.AQUESTION__SELECTEDS:
				getSelecteds().clear();
				return;
			case CongabasePackage.AQUESTION__RELEVANCE:
				setRelevance(RELEVANCE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CongabasePackage.AQUESTION__QUESTION:
				return question != null;
			case CongabasePackage.AQUESTION__SELECTEDS:
				return selecteds != null && !selecteds.isEmpty();
			case CongabasePackage.AQUESTION__RELEVANCE:
				return relevance != RELEVANCE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (relevance: ");
		result.append(relevance);
		result.append(')');
		return result.toString();
	}

	@Override
	public double getScore(RecommenderOption ro) {
		double value = 0;
		for (Option opt : getSelecteds()) {
			if (ro.getAvailable().contains(opt)) {
				value += 1;
			} else if (ro.getPossible().contains(opt)) {
				value += 0.75;
			} else if (ro.getUnknown().contains(opt)) {
				value += 0.5;
			}
		}
		if (this.getRelevance().equals(RelevanceLevel.IRRELEVANT)) {
			return -1;
		}
		return value / getSelecteds().size();
	}

	/*@Override
	public double getScore(String tool, String user, String version) {
		if (this.getQuestion().eContainer() instanceof Questionnaire) {

			List<Tool> tools = ((Questionnaire)this.getQuestion().eContainer()).getTools();

			for (Tool t : tools) {
				if (t.getName().equals(tool)) {
					return getScore(t);
				}
			}
		}
		return 0;
	}*/

} // AQuestionImpl

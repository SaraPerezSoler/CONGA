/**
 */
package congabase.impl;

import congabase.AQuestion;
import congabase.CongabasePackage;
import congabase.RecommenderOption;
import congabase.RelevanceLevel;
import congabase.UserAnswer;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import recommenderQuestionnaire.Question;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Answer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link congabase.impl.UserAnswerImpl#getAnswers <em>Answers</em>}</li>
 *   <li>{@link congabase.impl.UserAnswerImpl#getRanking <em>Ranking</em>}</li>
 *   <li>{@link congabase.impl.UserAnswerImpl#getDate <em>Date</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UserAnswerImpl extends MinimalEObjectImpl.Container implements UserAnswer {
	/**
	 * The cached value of the '{@link #getAnswers() <em>Answers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnswers()
	 * @generated
	 * @ordered
	 */
	protected EList<AQuestion> answers;

	/**
	 * The cached value of the '{@link #getRanking() <em>Ranking</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRanking()
	 * @generated
	 * @ordered
	 */
	protected EMap<RecommenderOption, Double> ranking;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserAnswerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CongabasePackage.Literals.USER_ANSWER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AQuestion> getAnswers() {
		if (answers == null) {
			answers = new EObjectContainmentEList<AQuestion>(AQuestion.class, this, CongabasePackage.USER_ANSWER__ANSWERS);
		}
		return answers;
	}

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<RecommenderOption, Double> getRanking() {
		if (ranking == null) {
			ranking = new EcoreEMap<RecommenderOption,Double>(CongabasePackage.Literals.ROPTION_TO_DOUBLE, ROptionToDoubleImpl.class, this, CongabasePackage.USER_ANSWER__RANKING);
		}
		return ranking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CongabasePackage.USER_ANSWER__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CongabasePackage.USER_ANSWER__ANSWERS:
				return ((InternalEList<?>)getAnswers()).basicRemove(otherEnd, msgs);
			case CongabasePackage.USER_ANSWER__RANKING:
				return ((InternalEList<?>)getRanking()).basicRemove(otherEnd, msgs);
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
			case CongabasePackage.USER_ANSWER__ANSWERS:
				return getAnswers();
			case CongabasePackage.USER_ANSWER__RANKING:
				if (coreType) return getRanking();
				else return getRanking().map();
			case CongabasePackage.USER_ANSWER__DATE:
				return getDate();
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
			case CongabasePackage.USER_ANSWER__ANSWERS:
				getAnswers().clear();
				getAnswers().addAll((Collection<? extends AQuestion>)newValue);
				return;
			case CongabasePackage.USER_ANSWER__RANKING:
				((EStructuralFeature.Setting)getRanking()).set(newValue);
				return;
			case CongabasePackage.USER_ANSWER__DATE:
				setDate((Date)newValue);
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
			case CongabasePackage.USER_ANSWER__ANSWERS:
				getAnswers().clear();
				return;
			case CongabasePackage.USER_ANSWER__RANKING:
				getRanking().clear();
				return;
			case CongabasePackage.USER_ANSWER__DATE:
				setDate(DATE_EDEFAULT);
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
			case CongabasePackage.USER_ANSWER__ANSWERS:
				return answers != null && !answers.isEmpty();
			case CongabasePackage.USER_ANSWER__RANKING:
				return ranking != null && !ranking.isEmpty();
			case CongabasePackage.USER_ANSWER__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
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
		result.append(" (date: ");
		result.append(date);
		result.append(')');
		return result.toString();
	}

	@Override
	public AQuestion getAnswer(Question question) {
		for (AQuestion aquestion: getAnswers()) {
			if (aquestion.getQuestion().equals(question)) {
				return aquestion;
			}
		}
		return null;
	}

	@Override
	public void calculateRanking(List<RecommenderOption> allTools) {
	
		for (RecommenderOption t : allTools) {
			double raiting = 0;
			int totalQuestions = getAnswers().size();
			for (AQuestion ans : getAnswers()) {
				double ansRaiting = ans.getScore(t);
				if (ans.getRelevance() == RelevanceLevel.IRRELEVANT) {
					totalQuestions--;
					continue;
				} else if (ans.getRelevance() == RelevanceLevel.CRITICAL_ALL
						|| ans.getRelevance() == RelevanceLevel.CRITICAL) {
					if (ansRaiting != 1) {
						raiting = 0;
						break;
					}
				} else if (ans.getRelevance() == RelevanceLevel.CRITICAL_ONE) {
					if (ansRaiting <= 0.5) {
						raiting = 0;
						break;
					}
				} else if (ans.getRelevance() == RelevanceLevel.DOBLE) {
					ansRaiting = ansRaiting * 2;
					totalQuestions++;
				}
				raiting += ansRaiting;
			}
			if (totalQuestions == 0) {
				this.getRanking().put(t, 1.0);
			} else {
				this.getRanking().put(t, raiting / totalQuestions);
			}
		}
	}


} //UserAnswerImpl

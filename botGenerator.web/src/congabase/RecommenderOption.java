/**
 */
package congabase;

import org.eclipse.emf.common.util.EList;

import recommenderQuestionnaire.Option;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recommender Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link congabase.RecommenderOption#getAvailable <em>Available</em>}</li>
 *   <li>{@link congabase.RecommenderOption#getUnavailable <em>Unavailable</em>}</li>
 *   <li>{@link congabase.RecommenderOption#getUnknown <em>Unknown</em>}</li>
 *   <li>{@link congabase.RecommenderOption#getPossible <em>Possible</em>}</li>
 * </ul>
 *
 * @see congabase.CongabasePackage#getRecommenderOption()
 * @model
 * @generated
 */
public interface RecommenderOption extends Utility {
	/**
	 * Returns the value of the '<em><b>Available</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Option}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available</em>' reference list.
	 * @see congabase.CongabasePackage#getRecommenderOption_Available()
	 * @model
	 * @generated
	 */
	EList<Option> getAvailable();

	/**
	 * Returns the value of the '<em><b>Unavailable</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Option}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unavailable</em>' reference list.
	 * @see congabase.CongabasePackage#getRecommenderOption_Unavailable()
	 * @model
	 * @generated
	 */
	EList<Option> getUnavailable();

	/**
	 * Returns the value of the '<em><b>Unknown</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Option}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unknown</em>' reference list.
	 * @see congabase.CongabasePackage#getRecommenderOption_Unknown()
	 * @model
	 * @generated
	 */
	EList<Option> getUnknown();

	/**
	 * Returns the value of the '<em><b>Possible</b></em>' reference list.
	 * The list contents are of type {@link recommenderQuestionnaire.Option}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possible</em>' reference list.
	 * @see congabase.CongabasePackage#getRecommenderOption_Possible()
	 * @model
	 * @generated
	 */
	EList<Option> getPossible();
	
	boolean isAvailable(Option op);
	boolean isUnavailable(Option op);
	boolean isPossible(Option op);
	boolean isUnknown(Option op);

} // RecommenderOption

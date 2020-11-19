/**
 */
package congabase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Relevance Level</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see congabase.CongabasePackage#getRelevanceLevel()
 * @model
 * @generated
 */
public enum RelevanceLevel implements Enumerator {
	/**
	 * The '<em><b>IRRELEVANT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IRRELEVANT_VALUE
	 * @generated
	 * @ordered
	 */
	IRRELEVANT(0, "IRRELEVANT", "Irrelevant"), /**
	 * The '<em><b>RELEVANT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELEVANT_VALUE
	 * @generated
	 * @ordered
	 */
	RELEVANT(1, "RELEVANT", "Relevant"),

	/**
	 * The '<em><b>DOBLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOBLE_VALUE
	 * @generated
	 * @ordered
	 */
	DOBLE(2, "DOBLE", "Double relevant"),

	/**
	 * The '<em><b>CRITICAL ONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CRITICAL_ONE_VALUE
	 * @generated
	 * @ordered
	 */
	CRITICAL_ONE(3, "CRITICAL_ONE", "Critical (at least one option)"),

	/**
	 * The '<em><b>CRITICAL ALL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CRITICAL_ALL_VALUE
	 * @generated
	 * @ordered
	 */
	CRITICAL_ALL(4, "CRITICAL_ALL", "Critical (all options)"),

	/**
	 * The '<em><b>CRITICAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CRITICAL_VALUE
	 * @generated
	 * @ordered
	 */
	CRITICAL(5, "CRITICAL", "Critical");

	/**
	 * The '<em><b>IRRELEVANT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IRRELEVANT
	 * @model literal="Irrelevant"
	 * @generated
	 * @ordered
	 */
	public static final int IRRELEVANT_VALUE = 0;

	/**
	 * The '<em><b>RELEVANT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELEVANT
	 * @model literal="Relevant"
	 * @generated
	 * @ordered
	 */
	public static final int RELEVANT_VALUE = 1;

	/**
	 * The '<em><b>DOBLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOBLE
	 * @model literal="Double relevant"
	 * @generated
	 * @ordered
	 */
	public static final int DOBLE_VALUE = 2;

	/**
	 * The '<em><b>CRITICAL ONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CRITICAL_ONE
	 * @model literal="Critical (at least one option)"
	 * @generated
	 * @ordered
	 */
	public static final int CRITICAL_ONE_VALUE = 3;

	/**
	 * The '<em><b>CRITICAL ALL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CRITICAL_ALL
	 * @model literal="Critical (all options)"
	 * @generated
	 * @ordered
	 */
	public static final int CRITICAL_ALL_VALUE = 4;

	/**
	 * The '<em><b>CRITICAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CRITICAL
	 * @model literal="Critical"
	 * @generated
	 * @ordered
	 */
	public static final int CRITICAL_VALUE = 5;
	
	private static final String[] MULTI_LEVEL = { RELEVANT.getLiteral(), IRRELEVANT.getLiteral(), DOBLE.getLiteral(),
			CRITICAL_ONE.getLiteral(), CRITICAL_ALL.getLiteral() };
	private static final String[] NOT_MULTI_LEVEL = { RELEVANT.getLiteral(), IRRELEVANT.getLiteral(), DOBLE.getLiteral(), CRITICAL.getLiteral() };
	
	public static String[] getLevelsString(boolean multi) {
		if (multi) {
			return MULTI_LEVEL;
		}
		return NOT_MULTI_LEVEL;
	}

	/**
	 * An array of all the '<em><b>Relevance Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RelevanceLevel[] VALUES_ARRAY =
		new RelevanceLevel[] {
			IRRELEVANT,
			RELEVANT,
			DOBLE,
			CRITICAL_ONE,
			CRITICAL_ALL,
			CRITICAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Relevance Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RelevanceLevel> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Relevance Level</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RelevanceLevel get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RelevanceLevel result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Relevance Level</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RelevanceLevel getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RelevanceLevel result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Relevance Level</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RelevanceLevel get(int value) {
		switch (value) {
			case IRRELEVANT_VALUE: return IRRELEVANT;
			case RELEVANT_VALUE: return RELEVANT;
			case DOBLE_VALUE: return DOBLE;
			case CRITICAL_ONE_VALUE: return CRITICAL_ONE;
			case CRITICAL_ALL_VALUE: return CRITICAL_ALL;
			case CRITICAL_VALUE: return CRITICAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private RelevanceLevel(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //RelevanceLevel

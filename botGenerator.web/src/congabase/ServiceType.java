/**
 */
package congabase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Service Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see congabase.CongabasePackage#getServiceType()
 * @model
 * @generated
 */
public enum ServiceType implements Enumerator {
	/**
	 * The '<em><b>GENERATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERATOR_VALUE
	 * @generated
	 * @ordered
	 */
	GENERATOR(0, "GENERATOR", "GENERATOR"),

	/**
	 * The '<em><b>CONVERTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONVERTER_VALUE
	 * @generated
	 * @ordered
	 */
	CONVERTER(1, "CONVERTER", "CONVERTER"),

	/**
	 * The '<em><b>VALIDATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALIDATOR_VALUE
	 * @generated
	 * @ordered
	 */
	VALIDATOR(2, "VALIDATOR", "VALIDATOR");

	/**
	 * The '<em><b>GENERATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERATOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GENERATOR_VALUE = 0;

	/**
	 * The '<em><b>CONVERTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONVERTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONVERTER_VALUE = 1;

	/**
	 * The '<em><b>VALIDATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALIDATOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VALIDATOR_VALUE = 2;

	/**
	 * An array of all the '<em><b>Service Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ServiceType[] VALUES_ARRAY =
		new ServiceType[] {
			GENERATOR,
			CONVERTER,
			VALIDATOR,
		};

	/**
	 * A public read-only list of all the '<em><b>Service Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ServiceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Service Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ServiceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServiceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Service Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ServiceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServiceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Service Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ServiceType get(int value) {
		switch (value) {
			case GENERATOR_VALUE: return GENERATOR;
			case CONVERTER_VALUE: return CONVERTER;
			case VALIDATOR_VALUE: return VALIDATOR;
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
	private ServiceType(int value, String name, String literal) {
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
	
} //ServiceType

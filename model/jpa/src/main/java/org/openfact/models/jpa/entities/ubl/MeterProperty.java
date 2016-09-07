package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * The name of this meter property.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:08 a. m.
 */
public class MeterProperty {

	/**
	 * The name of this meter property, expressed as a code.
	 */
	private String name;
	/**
	 * The value of this meter property, expressed as text.
	 */
	private String nameCode;
	/**
	 * The value of this meter property, expressed as a quantity.
	 */
	private String value;
	/**
	 * An additional value to qualify the value of the meter
	 */
	private String valueQualifier;
	/**
	 * The value of this meter property, expressed as a quantity.
	 */
	private BigDecimal valueQuantity;

	public MeterProperty() {

	}

	public void finalize() throws Throwable {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameCode() {
		return nameCode;
	}

	public void setNameCode(String nameCode) {
		this.nameCode = nameCode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValueQualifier() {
		return valueQualifier;
	}

	public void setValueQualifier(String valueQualifier) {
		this.valueQualifier = valueQualifier;
	}

	public BigDecimal getValueQuantity() {
		return valueQuantity;
	}

	public void setValueQuantity(BigDecimal valueQuantity) {
		this.valueQuantity = valueQuantity;
	}
}// end Meter Property
package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a measurable condition of an object.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:42 a. m.
 */
public class Condition {

	/**
	 * An identifier for the attribute that applies to the condition.
	 */
	private String AttributeID;
	/**
	 * Text describing the attribute that applies to the condition.
	 */
	private String Description;
	/**
	 * The maximum value in a range of measurement for this condition.
	 */
	private BigDecimal MaximumMeasure;
	/**
	 * The measurement value.
	 */
	private BigDecimal Measure;
	/**
	 * The minimum value in a range of measurement for this condition.
	 */
	private BigDecimal MinimumMeasure;

	public Condition() {

	}

	public void finalize() throws Throwable {

	}

	public String getAttributeID() {
		return AttributeID;
	}

	public String getDescription() {
		return Description;
	}

	public BigDecimal getMaximumMeasure() {
		return MaximumMeasure;
	}

	public BigDecimal getMeasure() {
		return Measure;
	}

	public BigDecimal getMinimumMeasure() {
		return MinimumMeasure;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAttributeID(String newVal) {
		AttributeID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal) {
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumMeasure(BigDecimal newVal) {
		MaximumMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMeasure(BigDecimal newVal) {
		Measure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumMeasure(BigDecimal newVal) {
		MinimumMeasure = newVal;
	}
}// end Condition
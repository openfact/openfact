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
	private String attributeID;
	/**
	 * Text describing the attribute that applies to the condition.
	 */
	private String description;
	/**
	 * The maximum value in a range of measurement for this condition.
	 */
	private BigDecimal maximumMeasure;
	/**
	 * The measurement value.
	 */
	private BigDecimal measure;
	/**
	 * The minimum value in a range of measurement for this condition.
	 */
	private BigDecimal minimumMeasure;

	public Condition() {

	}

	public void finalize() throws Throwable {

	}

	public String getAttributeID() {
		return attributeID;
	}

	public void setAttributeID(String attributeID) {
		this.attributeID = attributeID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getMaximumMeasure() {
		return maximumMeasure;
	}

	public void setMaximumMeasure(BigDecimal maximumMeasure) {
		this.maximumMeasure = maximumMeasure;
	}

	public BigDecimal getMeasure() {
		return measure;
	}

	public void setMeasure(BigDecimal measure) {
		this.measure = measure;
	}

	public BigDecimal getMinimumMeasure() {
		return minimumMeasure;
	}

	public void setMinimumMeasure(BigDecimal minimumMeasure) {
		this.minimumMeasure = minimumMeasure;
	}
}// end Condition
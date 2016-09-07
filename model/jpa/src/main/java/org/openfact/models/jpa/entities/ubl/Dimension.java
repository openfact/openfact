package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a measurable dimension (length, mass, weight, volume, or
 * area) of an item.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:30 a. m.
 */
public class Dimension {

	/**
	 * An identifier for the attribute to which the measure applies.
	 */
	private String attributeID;
	/**
	 * Text describing the measurement attribute.
	 */
	private String description;
	/**
	 * The maximum value in a range of measurement of this dimension.
	 */
	private BigDecimal maximumMeasure;
	/**
	 * The measurement value.
	 */
	private BigDecimal measure;
	/**
	 * The minimum value in a range of measurement of this dimension.
	 */
	private BigDecimal minimumMeasure;

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
}
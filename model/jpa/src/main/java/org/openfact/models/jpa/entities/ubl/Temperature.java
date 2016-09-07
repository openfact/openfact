package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a measurement of temperature.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:18:13 a. m.
 */
public class Temperature {

	/**
	 * An identifier for this temperature measurement.
	 */
	private String AttributeID;
	/**
	 * Text describing this temperature measurement.
	 */
	private String Description;
	/**
	 * The value of this temperature measurement.
	 */
	private BigDecimal Measure;

	/**
	 * @return the attributeID
	 */
	public String getAttributeID() {
		return AttributeID;
	}

	/**
	 * @param attributeID
	 *            the attributeID to set
	 */
	public void setAttributeID(String attributeID) {
		AttributeID = attributeID;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the measure
	 */
	public BigDecimal getMeasure() {
		return Measure;
	}

	/**
	 * @param measure
	 *            the measure to set
	 */
	public void setMeasure(BigDecimal measure) {
		Measure = measure;
	}

}// end Temperature
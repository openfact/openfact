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
	private String attributeID;
	/**
	 * Text describing this temperature measurement.
	 */
	private String sescription;
	/**
	 * The value of this temperature measurement.
	 */
	private BigDecimal measure;

	public String getAttributeID() {
		return attributeID;
	}

	public void setAttributeID(String attributeID) {
		this.attributeID = attributeID;
	}

	public String getSescription() {
		return sescription;
	}

	public void setSescription(String sescription) {
		this.sescription = sescription;
	}

	public BigDecimal getMeasure() {
		return measure;
	}

	public void setMeasure(BigDecimal measure) {
		this.measure = measure;
	}
}// end Temperature
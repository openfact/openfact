package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a range of values for an item property.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:53 a. m.
 */
public class ItemPropertyRange {

	/**
	 * The maximum value in this range of values.
	 */
	private String maximumValue;
	/**
	 * The minimum value in this range of values.
	 */
	private String minimumValue;

	public String getMaximumValue() {
		return maximumValue;
	}

	public void setMaximumValue(String maximumValue) {
		this.maximumValue = maximumValue;
	}

	public String getMinimumValue() {
		return minimumValue;
	}

	public void setMinimumValue(String minimumValue) {
		this.minimumValue = minimumValue;
	}
}//end Item Property Range
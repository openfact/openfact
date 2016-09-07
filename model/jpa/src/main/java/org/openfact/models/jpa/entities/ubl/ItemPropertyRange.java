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
	private Text. Type MaximumValue;
	/**
	 * The minimum value in this range of values.
	 */
	private Text. Type MinimumValue;

	public Item Property Range(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getMaximumValue(){
		return MaximumValue;
	}

	public Text. Type getMinimumValue(){
		return MinimumValue;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumValue(Text. Type newVal){
		MaximumValue = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumValue(Text. Type newVal){
		MinimumValue = newVal;
	}
}//end Item Property Range
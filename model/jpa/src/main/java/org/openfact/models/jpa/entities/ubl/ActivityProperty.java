package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ubl2.Activity;

/**
 * A class to define a name/value pair for a property of an inventory planning
 * activity.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:36 a. m.
 */
public class ActivityProperty {

	/**
	 * The name of this activity property.
	 */
	private String Name;
	/**
	 * The value of this activity property.
	 */
	private String Value;

	public Activity Property(){

	}

	public void finalize() throws Throwable {

	}
	public String getName(){
		return Name;
	}

	public String getValue(){
		return Value;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal){
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValue(String newVal){
		Value = newVal;
	}
}//end Activity Property
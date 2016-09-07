package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ubl2.Physical;

/**
 * A class to describe a physical attribute.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:48 a. m.
 */
public class PhysicalAttribute {

	/**
	 * An identifier for this physical attribute.
	 */
	private String AttributeID;
	/**
	 * A description of the physical attribute, expressed as text.
	 */
	private String Description;
	/**
	 * A description of the physical attribute, expressed as a code.
	 */
	private String DescriptionCode;
	/**
	 * A code signifying the position of this physical attribute.
	 */
	private String PositionCode;

	public Physical Attribute(){

	}

	public void finalize() throws Throwable {

	}
	public String getAttributeID(){
		return AttributeID;
	}

	public String getDescription(){
		return Description;
	}

	public String getDescriptionCode(){
		return DescriptionCode;
	}

	public String getPositionCode(){
		return PositionCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAttributeID(String newVal){
		AttributeID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescriptionCode(String newVal){
		DescriptionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPositionCode(String newVal){
		PositionCode = newVal;
	}
}//end Physical Attribute
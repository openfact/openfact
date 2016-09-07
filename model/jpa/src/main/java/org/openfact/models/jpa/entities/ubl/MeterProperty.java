package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * The name of this meter property.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:08 a. m.
 */
public class MeterProperty {

	/**
	 * The name of this meter property, expressed as a code.
	 */
	private String Name;
	/**
	 * The value of this meter property, expressed as text.
	 */
	private String NameCode;
	/**
	 * The value of this meter property, expressed as a quantity.
	 */
	private String Value;
	/**
	 * An additional value to qualify the value of the meter
	 */
	private String ValueQualifier;
	/**
	 * The value of this meter property, expressed as a quantity.
	 */
	private BigDecimal ValueQuantity;

	public Meter Property(){

	}

	public void finalize() throws Throwable {

	}
	public String getName(){
		return Name;
	}

	public String getNameCode(){
		return NameCode;
	}

	public String getValue(){
		return Value;
	}

	public String getValueQualifier(){
		return ValueQualifier;
	}

	public BigDecimal getValueQuantity(){
		return ValueQuantity;
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
	public void setNameCode(String newVal){
		NameCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValue(String newVal){
		Value = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValueQualifier(String newVal){
		ValueQualifier = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValueQuantity(BigDecimal newVal){
		ValueQuantity = newVal;
	}
}//end Meter Property
package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a reference to an earlier consumption report (e.g., last
 * year's consumption).
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:56 a. m.
 */
public class ConsumptionReportReference {

	/**
	 * An identifier for the referenced consumption report.
	 */
	private Identifier. Type ConsumptionReportID;
	/**
	 * The reported consumption type, expressed as text.
	 */
	private Text. Type ConsumptionType;
	/**
	 * The reported consumption type, expressed as a code.
	 */
	private Code. Type ConsumptionTypeCode;
	/**
	 * The total quantity consumed during the period of the referenced report.
	 */
	private Quantity. Type TotalConsumedQuantity;
	private Period m_Period;

	public Consumption Report Reference(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getConsumptionReportID(){
		return ConsumptionReportID;
	}

	public Text. Type getConsumptionType(){
		return ConsumptionType;
	}

	public Code. Type getConsumptionTypeCode(){
		return ConsumptionTypeCode;
	}

	public Period getPeriod(){
		return m_Period;
	}

	public Quantity. Type getTotalConsumedQuantity(){
		return TotalConsumedQuantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionReportID(Identifier. Type newVal){
		ConsumptionReportID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionType(Text. Type newVal){
		ConsumptionType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionTypeCode(Code. Type newVal){
		ConsumptionTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPeriod(Period newVal){
		m_Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalConsumedQuantity(Quantity. Type newVal){
		TotalConsumedQuantity = newVal;
	}
}//end Consumption Report Reference
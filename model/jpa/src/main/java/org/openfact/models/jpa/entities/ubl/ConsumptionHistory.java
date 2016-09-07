package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe the measurement of a type of consumption during a
 * particular period, used for the subscriber to get an overview of his
 * consumption
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:50 a. m.
 */
public class ConsumptionHistory {

	/**
	 * The monetary amount to be charged for the quantity consumed.
	 */
	private Amount. Type Amount;
	/**
	 * The consumption level, expressed as text, used explain the consumption quantity,
	 * e.g.. diversion from the normal.
	 */
	private Text. Type ConsumptionLevel;
	/**
	 * The consumption level, expressed as a code used explain the consumption
	 * quantity, e.g.. diversion from the normal.
	 */
	private Code. Type ConsumptionLevelCode;
	/**
	 * Text describing the consumption itself.
	 */
	private Text. Type Description;
	/**
	 * A text identifier for the meter measuring the consumption.
	 */
	private Text. Type MeterNumber;
	/**
	 * The quantity consumed.
	 */
	private Quantity. Type Quantity;
	private Period m_Period;

	public Consumption History(){

	}

	public void finalize() throws Throwable {

	}
	public Amount. Type getAmount(){
		return Amount;
	}

	public Text. Type getConsumptionLevel(){
		return ConsumptionLevel;
	}

	public Code. Type getConsumptionLevelCode(){
		return ConsumptionLevelCode;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Text. Type getMeterNumber(){
		return MeterNumber;
	}

	public Period getPeriod(){
		return m_Period;
	}

	public Quantity. Type getQuantity(){
		return Quantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmount(Amount. Type newVal){
		Amount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionLevel(Text. Type newVal){
		ConsumptionLevel = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionLevelCode(Code. Type newVal){
		ConsumptionLevelCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(Text. Type newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMeterNumber(Text. Type newVal){
		MeterNumber = newVal;
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
	public void setQuantity(Quantity. Type newVal){
		Quantity = newVal;
	}
}//end Consumption History
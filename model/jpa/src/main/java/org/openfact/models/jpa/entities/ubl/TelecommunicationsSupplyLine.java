package org.openfact.models.jpa.entities.ubl;


/**
 * A class that outlines the telecommunication supply in details
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:11 a. m.
 */
public class TelecommunicationsSupplyLine {

	/**
	 * The description of the telecommunication supply line
	 */
	private Text. Type Description;
	/**
	 * An identifier for this telecommunications supply line.
	 */
	private Identifier. Type ID;
	/**
	 * An amount specifying the cost of this telecommunication line
	 */
	private Amount. Type LineExtensionAmount;
	/**
	 * The phone number used for this telecommunication supply line
	 */
	private Text. Type PhoneNumber;
	private Allowance Charge m_Allowance Charge;
	private Exchange Rate m_Exchange Rate;
	private Tax Total m_Tax Total;
	private Telecommunications Service m_Telecommunications Service;

	public Telecommunications Supply Line(){

	}

	public void finalize() throws Throwable {

	}
	public Allowance Charge getAllowance Charge(){
		return m_Allowance Charge;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Exchange Rate getExchange Rate(){
		return m_Exchange Rate;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Amount. Type getLineExtensionAmount(){
		return LineExtensionAmount;
	}

	public Text. Type getPhoneNumber(){
		return PhoneNumber;
	}

	public Tax Total getTax Total(){
		return m_Tax Total;
	}

	public Telecommunications Service getTelecommunications Service(){
		return m_Telecommunications Service;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAllowance Charge(Allowance Charge newVal){
		m_Allowance Charge = newVal;
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
	public void setExchange Rate(Exchange Rate newVal){
		m_Exchange Rate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineExtensionAmount(Amount. Type newVal){
		LineExtensionAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPhoneNumber(Text. Type newVal){
		PhoneNumber = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Total(Tax Total newVal){
		m_Tax Total = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTelecommunications Service(Telecommunications Service newVal){
		m_Telecommunications Service = newVal;
	}
}//end Telecommunications Supply Line
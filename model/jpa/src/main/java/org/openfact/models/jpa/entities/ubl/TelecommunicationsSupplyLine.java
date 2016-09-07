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
	private String Description;
	/**
	 * An identifier for this telecommunications supply line.
	 */
	private String ID;
	/**
	 * An amount specifying the cost of this telecommunication line
	 */
	private BigDecimal LineExtensionAmount;
	/**
	 * The phone number used for this telecommunication supply line
	 */
	private String PhoneNumber;
	private Allowance Charge m_Allowance Charge;
	private ExchangeRate m_ExchangeRate;
	private Tax Total m_Tax Total;
	private Telecommunications Service m_Telecommunications Service;

	public Telecommunications Supply Line(){

	}

	public void finalize() throws Throwable {

	}
	public Allowance Charge getAllowance Charge(){
		return m_Allowance Charge;
	}

	public String getDescription(){
		return Description;
	}

	public ExchangeRate getExchangeRate(){
		return m_ExchangeRate;
	}

	public String getID(){
		return ID;
	}

	public BigDecimal getLineExtensionAmount(){
		return LineExtensionAmount;
	}

	public String getPhoneNumber(){
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
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExchangeRate(ExchangeRate newVal){
		m_ExchangeRate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineExtensionAmount(BigDecimal newVal){
		LineExtensionAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPhoneNumber(String newVal){
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
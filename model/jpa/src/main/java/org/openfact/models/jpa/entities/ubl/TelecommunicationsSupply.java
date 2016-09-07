package org.openfact.models.jpa.entities.ubl;


/**
 * A class describing the supply of a telecommunication service, e.g., providing
 * telephone calls.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:10 a. m.
 */
public class TelecommunicationsSupply {

	/**
	 * Text describing the telecommunications supply.
	 */
	private String Description;
	/**
	 * A code signifying the level of confidentiality of this information for this
	 * telecommunication supply.
	 */
	private String PrivacyCode;
	/**
	 * The type of telecommunications supply, expressed as text.
	 */
	private String TelecommunicationsSupplyType;
	/**
	 * The type of telecommunications supply, expressed as a code.
	 */
	private String TelecommunicationsSupplyTypeCode;
	/**
	 * The total amount associated with this telecommunications supply.
	 */
	private BigDecimal TotalAmount;
	private Telecommunications Supply Line m_Telecommunications Supply Line;

	public Telecommunications Supply(){

	}

	public void finalize() throws Throwable {

	}
	public String getDescription(){
		return Description;
	}

	public String getPrivacyCode(){
		return PrivacyCode;
	}

	public Telecommunications Supply Line getTelecommunications Supply Line(){
		return m_Telecommunications Supply Line;
	}

	public String getTelecommunicationsSupplyType(){
		return TelecommunicationsSupplyType;
	}

	public String getTelecommunicationsSupplyTypeCode(){
		return TelecommunicationsSupplyTypeCode;
	}

	public BigDecimal getTotalAmount(){
		return TotalAmount;
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
	public void setPrivacyCode(String newVal){
		PrivacyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTelecommunications Supply Line(Telecommunications Supply Line newVal){
		m_Telecommunications Supply Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTelecommunicationsSupplyType(String newVal){
		TelecommunicationsSupplyType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTelecommunicationsSupplyTypeCode(String newVal){
		TelecommunicationsSupplyTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalAmount(BigDecimal newVal){
		TotalAmount = newVal;
	}
}//end Telecommunications Supply
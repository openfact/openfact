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
	private Text. Type Description;
	/**
	 * A code signifying the level of confidentiality of this information for this
	 * telecommunication supply.
	 */
	private Code. Type PrivacyCode;
	/**
	 * The type of telecommunications supply, expressed as text.
	 */
	private Text. Type TelecommunicationsSupplyType;
	/**
	 * The type of telecommunications supply, expressed as a code.
	 */
	private Code. Type TelecommunicationsSupplyTypeCode;
	/**
	 * The total amount associated with this telecommunications supply.
	 */
	private Amount. Type TotalAmount;
	private Telecommunications Supply Line m_Telecommunications Supply Line;

	public Telecommunications Supply(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getDescription(){
		return Description;
	}

	public Code. Type getPrivacyCode(){
		return PrivacyCode;
	}

	public Telecommunications Supply Line getTelecommunications Supply Line(){
		return m_Telecommunications Supply Line;
	}

	public Text. Type getTelecommunicationsSupplyType(){
		return TelecommunicationsSupplyType;
	}

	public Code. Type getTelecommunicationsSupplyTypeCode(){
		return TelecommunicationsSupplyTypeCode;
	}

	public Amount. Type getTotalAmount(){
		return TotalAmount;
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
	public void setPrivacyCode(Code. Type newVal){
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
	public void setTelecommunicationsSupplyType(Text. Type newVal){
		TelecommunicationsSupplyType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTelecommunicationsSupplyTypeCode(Code. Type newVal){
		TelecommunicationsSupplyTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalAmount(Amount. Type newVal){
		TotalAmount = newVal;
	}
}//end Telecommunications Supply
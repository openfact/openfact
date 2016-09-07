package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a device (a transport equipment seal) for securing the
 * doors of a shipping container.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:39 a. m.
 */
public class TransportEquipmentSeal {

	/**
	 * The condition of this transport equipment seal.
	 */
	private String Condition;
	/**
	 * An identifier for this transport equipment seal.
	 */
	private String ID;
	/**
	 * The role of the sealing party.
	 */
	private String SealingPartyType;
	/**
	 * A code signifying the type of party that issues and is responsible for this
	 * transport equipment seal.
	 */
	private String SealIssuerTypeCode;
	/**
	 * A code signifying the condition of this transport equipment seal.
	 */
	private String SealStatusCode;

	public TransportEquipment Seal(){

	}

	public void finalize() throws Throwable {

	}
	public String getCondition(){
		return Condition;
	}

	public String getID(){
		return ID;
	}

	public String getSealingPartyType(){
		return SealingPartyType;
	}

	public String getSealIssuerTypeCode(){
		return SealIssuerTypeCode;
	}

	public String getSealStatusCode(){
		return SealStatusCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCondition(String newVal){
		Condition = newVal;
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
	public void setSealingPartyType(String newVal){
		SealingPartyType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSealIssuerTypeCode(String newVal){
		SealIssuerTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSealStatusCode(String newVal){
		SealStatusCode = newVal;
	}
}//end TransportEquipment Seal
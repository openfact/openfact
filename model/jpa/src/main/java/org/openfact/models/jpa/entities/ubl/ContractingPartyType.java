package org.openfact.models.jpa.entities.ubl;


/**
 * The type of contracting party that is independent of its role.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:08 a. m.
 */
public class ContractingPartyType {

	/**
	 * The type of party that is independent of its role, expressed as text.
	 */
	private Text. Type PartyType;
	/**
	 * A code specifying the type of party that is independent of its role.
	 */
	private Code. Type PartyTypeCode;

	public Contracting Party Type(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getPartyType(){
		return PartyType;
	}

	public Code. Type getPartyTypeCode(){
		return PartyTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPartyType(Text. Type newVal){
		PartyType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPartyTypeCode(Code. Type newVal){
		PartyTypeCode = newVal;
	}
}//end Contracting Party Type
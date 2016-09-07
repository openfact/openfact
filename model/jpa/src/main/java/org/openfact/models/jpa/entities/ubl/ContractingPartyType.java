package org.openfact.models.jpa.entities.ubl;

/**
 * The type of contracting party that is independent of its role.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:08 a. m.
 */
public class ContractingPartyType {

	/**
	 * The type of party that is independent of its role, expressed as text.
	 */
	private String PartyType;
	/**
	 * A code specifying the type of party that is independent of its role.
	 */
	private String PartyTypeCode;

	public ContractingPartyType() {

	}

	public void finalize() throws Throwable {

	}

	public String getPartyType() {
		return PartyType;
	}

	public String getPartyTypeCode() {
		return PartyTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPartyType(String newVal) {
		PartyType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPartyTypeCode(String newVal) {
		PartyTypeCode = newVal;
	}
}// end Contracting Party Type
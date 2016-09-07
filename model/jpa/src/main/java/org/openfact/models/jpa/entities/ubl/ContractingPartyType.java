package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
	private String partyType;
	/**
	 * A code specifying the type of party that is independent of its role.
	 */
	private String partyTypeCode;

	public ContractingPartyType() {

	}

	public void finalize() throws Throwable {

	}

	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	public String getPartyTypeCode() {
		return partyTypeCode;
	}

	public void setPartyTypeCode(String partyTypeCode) {
		this.partyTypeCode = partyTypeCode;
	}
}// end ContractingParty Type
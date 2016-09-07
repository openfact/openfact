package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe an individual, a group, or a body having a procurement
 * role in a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:06 a. m.
 */
public class ContractingParty {

	/**
	 * The buyer profile is typically located on a web site where the
	 * contracting party publishes its procurement opportunities
	 */
	private String buyerProfileURIID;
	private List<ContractingActivity> contractingActivities= new ArrayList<>();
	private List<ContractingPartyType> contractingPartyTypes= new ArrayList<>();
	private List<Party> parties= new ArrayList<>();

	public ContractingParty() {

	}

	public void finalize() throws Throwable {

	}

	public String getBuyerProfileURIID() {
		return buyerProfileURIID;
	}

	public void setBuyerProfileURIID(String buyerProfileURIID) {
		this.buyerProfileURIID = buyerProfileURIID;
	}

	public List<ContractingActivity> getContractingActivities() {
		return contractingActivities;
	}

	public void setContractingActivities(List<ContractingActivity> contractingActivities) {
		this.contractingActivities = contractingActivities;
	}

	public List<ContractingPartyType> getContractingPartyTypes() {
		return contractingPartyTypes;
	}

	public void setContractingPartyTypes(List<ContractingPartyType> contractingPartyTypes) {
		this.contractingPartyTypes = contractingPartyTypes;
	}

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}
}// end ContractingParty
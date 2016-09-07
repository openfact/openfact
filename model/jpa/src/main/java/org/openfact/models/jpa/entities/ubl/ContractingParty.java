package org.openfact.models.jpa.entities.ubl;

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
	private String BuyerProfileURIID;
	private ContractingActivity m_ContractingActivity;
	private ContractingPartyType m_ContractingPartyType;
	private Party m_Party;

	public ContractingParty() {

	}

	public void finalize() throws Throwable {

	}

	public String getBuyerProfileURIID() {
		return BuyerProfileURIID;
	}

	public ContractingActivity getContractingActivity() {
		return m_ContractingActivity;
	}

	public ContractingPartyType getContractingPartyType() {
		return m_ContractingPartyType;
	}

	public Party getParty() {
		return m_Party;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBuyerProfileURIID(String newVal) {
		BuyerProfileURIID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractingActivity(ContractingActivity newVal) {
		m_ContractingActivity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractingPartyType(ContractingPartyType newVal) {
		m_ContractingPartyType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParty(Party newVal) {
		m_Party = newVal;
	}
}// end ContractingParty
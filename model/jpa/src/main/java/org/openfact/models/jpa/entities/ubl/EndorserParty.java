package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe the party endorsing a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:46 a. m.
 */
public class EndorserParty {

	/**
	 * A code specifying the role of the party providing the endorsement (e.g., issuer,
	 * embassy, insurance, etc.).
	 */
	private String RoleCode;
	/**
	 * A number indicating the order of the endorsement provided by this party in the
	 * sequence in which endorsements are to be applied.
	 */
	private BigDecimal SequenceNumeric;
	private Contact Signatory Contact;
	private Party m_Party;

	public Endorser Party(){

	}

	public void finalize() throws Throwable {

	}
	public Party getParty(){
		return m_Party;
	}

	public String getRoleCode(){
		return RoleCode;
	}

	public BigDecimal getSequenceNumeric(){
		return SequenceNumeric;
	}

	public Contact getSignatory Contact(){
		return Signatory Contact;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParty(Party newVal){
		m_Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRoleCode(String newVal){
		RoleCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSequenceNumeric(BigDecimal newVal){
		SequenceNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignatory Contact(Contact newVal){
		Signatory Contact = newVal;
	}
}//end Endorser Party
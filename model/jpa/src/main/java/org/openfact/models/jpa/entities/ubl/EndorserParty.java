package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe the party endorsing a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:46 a. m.
 */
public class EndorserParty {

	/**
	 * A code specifying the role of the party providing the endorsement (e.g.,
	 * issuer, embassy, insurance, etc.).
	 */
	private String roleCode;
	/**
	 * A number indicating the order of the endorsement provided by this party
	 * in the sequence in which endorsements are to be applied.
	 */
	private BigDecimal sequenceNumeric;
	private Contact signatoryContact;
	private List<Party> partyes=new ArrayList<>();

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public BigDecimal getSequenceNumeric() {
		return sequenceNumeric;
	}

	public void setSequenceNumeric(BigDecimal sequenceNumeric) {
		this.sequenceNumeric = sequenceNumeric;
	}

	public Contact getSignatoryContact() {
		return signatoryContact;
	}

	public void setSignatoryContact(Contact signatoryContact) {
		this.signatoryContact = signatoryContact;
	}

	public List<Party> getPartyes() {
		return partyes;
	}

	public void setPartyes(List<Party> partyes) {
		this.partyes = partyes;
	}
}// end Endorser Party
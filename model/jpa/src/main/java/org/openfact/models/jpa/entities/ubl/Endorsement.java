package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe an endorsement of a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:45 a. m.
 */
public class Endorsement {

	/**
	 * The status of this endorsement.
	 */
	private String ApprovalStatus;
	/**
	 * An identifier for this endorsement.
	 */
	private String DocumentID;
	/**
	 * Remarks provided by the endorsing party.
	 */
	private String Remarks;
	private EndorserParty m_EndorserParty;
	private List<Signature> signatures = new ArrayList<>();

	public String getApprovalStatus() {
		return ApprovalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		ApprovalStatus = approvalStatus;
	}

	public String getDocumentID() {
		return DocumentID;
	}

	public void setDocumentID(String documentID) {
		DocumentID = documentID;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public EndorserParty getM_EndorserParty() {
		return m_EndorserParty;
	}

	public void setM_EndorserParty(EndorserParty m_EndorserParty) {
		this.m_EndorserParty = m_EndorserParty;
	}

	public Signature getM_Signature() {
		return m_Signature;
	}

	public void setM_Signature(Signature m_Signature) {
		this.m_Signature = m_Signature;
	}
}// end Endorsement
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
	private String approvalStatus;
	/**
	 * An identifier for this endorsement.
	 */
	private String documentID;
	/**
	 * Remarks provided by the endorsing party.
	 */
	private String remarks;
	private List<EndorserParty> endorserPartyes=new ArrayList<>();
	private List<Signature> signatures = new ArrayList<>();

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getDocumentID() {
		return documentID;
	}

	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<EndorserParty> getEndorserPartyes() {
		return endorserPartyes;
	}

	public void setEndorserPartyes(List<EndorserParty> endorserPartyes) {
		this.endorserPartyes = endorserPartyes;
	}

	public List<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<Signature> signatures) {
		this.signatures = signatures;
	}
}// end Endorsement
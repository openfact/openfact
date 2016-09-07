package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe an application-level response to a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:37 a. m.
 */
public class DocumentResponse {

	private List<DocumentReference> documentReferences=new ArrayList<>();
	private List<LineResponse> lineResponses=new ArrayList<>();
	private Party recipientParty;
	private Party issuerParty;
	private List<Response> responses=new ArrayList<>();

	public List<DocumentReference> getDocumentReferences() {
		return documentReferences;
	}

	public void setDocumentReferences(List<DocumentReference> documentReferences) {
		this.documentReferences = documentReferences;
	}

	public List<LineResponse> getLineResponses() {
		return lineResponses;
	}

	public void setLineResponses(List<LineResponse> lineResponses) {
		this.lineResponses = lineResponses;
	}

	public Party getRecipientParty() {
		return recipientParty;
	}

	public void setRecipientParty(Party recipientParty) {
		this.recipientParty = recipientParty;
	}

	public Party getIssuerParty() {
		return issuerParty;
	}

	public void setIssuerParty(Party issuerParty) {
		this.issuerParty = issuerParty;
	}

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}
}// end DocumentResponse
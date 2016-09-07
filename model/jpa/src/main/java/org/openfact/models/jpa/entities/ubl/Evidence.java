package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe an item of evidentiary support for representations of
 * capabilities or the ability to meet tendering requirements, which an economic
 * operator must provide for acceptance into a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:01 a. m.
 */
public class Evidence {

	/**
	 * Information about a candidate statement that the contracting authority
	 * accepts as a sufficient response.
	 */
	private String candidateStatement;
	/**
	 * The textual description for this Evidence.
	 */
	private String description;
	/**
	 * A code signifying the type of evidence.
	 */
	private String evidenceTypeCode;
	/**
	 * An identifier for this item of evidentiary support.
	 */
	private String ID;
	private List<DocumentReference> documentReferences=new ArrayList<>();
	private List<Language> languages=new ArrayList<>();
	private Party evidenceIssuingParty;

	public String getCandidateStatement() {
		return candidateStatement;
	}

	public void setCandidateStatement(String candidateStatement) {
		this.candidateStatement = candidateStatement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEvidenceTypeCode() {
		return evidenceTypeCode;
	}

	public void setEvidenceTypeCode(String evidenceTypeCode) {
		this.evidenceTypeCode = evidenceTypeCode;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public List<DocumentReference> getDocumentReferences() {
		return documentReferences;
	}

	public void setDocumentReferences(List<DocumentReference> documentReferences) {
		this.documentReferences = documentReferences;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public Party getEvidenceIssuingParty() {
		return evidenceIssuingParty;
	}

	public void setEvidenceIssuingParty(Party evidenceIssuingParty) {
		this.evidenceIssuingParty = evidenceIssuingParty;
	}
}// end Evidence
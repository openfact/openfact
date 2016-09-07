package org.openfact.models.jpa.entities.ubl;

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
    private String CandidateStatement;
    /**
     * The textual description for this Evidence.
     */
    private String Description;
    /**
     * A code signifying the type of evidence.
     */
    private String EvidenceTypeCode;
    /**
     * An identifier for this item of evidentiary support.
     */
    private String ID;
    private DocumentReference
    m_DocumentReference;
    private Language m_Language;
    private Party Evidence
    Issuing Party;

    public Evidence() {

    }

    public void finalize() throws Throwable {

    }

    public String getCandidateStatement() {
        return CandidateStatement;
    }

    public String getDescription() {
        return Description;
    }

    public DocumentReference

    getDocumentReference(){
		return m_DocumentReference;
	}

    public Party getEvidence

    Issuing Party(){
		return Evidence Issuing Party;
	}

    public String getEvidenceTypeCode() {
        return EvidenceTypeCode;
    }

    public String getID() {
        return ID;
    }

    public Language getLanguage() {
        return m_Language;
    }

    /**
     * 
     * @param newVal
     */
    public void setCandidateStatement(String newVal) {
        CandidateStatement = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(String newVal) {
        Description = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setDocument

    Reference(DocumentReference newVal){
		m_DocumentReference = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setEvidence

    Issuing Party(Party newVal){
		Evidence Issuing Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setEvidenceTypeCode(String newVal) {
        EvidenceTypeCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setID(String newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setLanguage(Language newVal) {
        m_Language = newVal;
    }
}// end Evidence
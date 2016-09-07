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
    private Text.Type CandidateStatement;
    /**
     * The textual description for this Evidence.
     */
    private Text.Type Description;
    /**
     * A code signifying the type of evidence.
     */
    private Code.Type EvidenceTypeCode;
    /**
     * An identifier for this item of evidentiary support.
     */
    private Identifier.Type ID;
    private Document Reference
    m_Document Reference;
    private Language m_Language;
    private Party Evidence
    Issuing Party;

    public Evidence() {

    }

    public void finalize() throws Throwable {

    }

    public Text.Type getCandidateStatement() {
        return CandidateStatement;
    }

    public Text.Type getDescription() {
        return Description;
    }

    public Document Reference

    getDocument Reference(){
		return m_Document Reference;
	}

    public Party getEvidence

    Issuing Party(){
		return Evidence Issuing Party;
	}

    public Code.Type getEvidenceTypeCode() {
        return EvidenceTypeCode;
    }

    public Identifier.Type getID() {
        return ID;
    }

    public Language getLanguage() {
        return m_Language;
    }

    /**
     * 
     * @param newVal
     */
    public void setCandidateStatement(Text.Type newVal) {
        CandidateStatement = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(Text.Type newVal) {
        Description = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setDocument

    Reference(Document Reference newVal){
		m_Document Reference = newVal;
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
    public void setEvidenceTypeCode(Code.Type newVal) {
        EvidenceTypeCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setID(Identifier.Type newVal) {
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
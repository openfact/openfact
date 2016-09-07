package org.openfact.models.jpa.entities.ubl;

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
    private Endorser Party
    m_Endorser Party;
    private Signature m_Signature;

    public Endorsement() {

    }

    public void finalize() throws Throwable {

    }

    public String getApprovalStatus() {
        return ApprovalStatus;
    }

    public String getDocumentID() {
        return DocumentID;
    }

    public Endorser Party

    getEndorser Party(){
		return m_Endorser Party;
	}

    public String getRemarks() {
        return Remarks;
    }

    public Signature getSignature() {
        return m_Signature;
    }

    /**
     * 
     * @param newVal
     */
    public void setApprovalStatus(String newVal) {
        ApprovalStatus = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDocumentID(String newVal) {
        DocumentID = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setEndorser

    Party(Endorser Party newVal){
		m_Endorser Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setRemarks(String newVal) {
        Remarks = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSignature(Signature newVal) {
        m_Signature = newVal;
    }
}// end Endorsement
package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe an application-level response to a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:37 a. m.
 */
public class DocumentResponse {

    private DocumentReference m_DocumentReference;
    private LineResponse m_LineResponse;
    private Party RecipientParty;
    private Party IssuerParty;
    private Response m_Response;

    /**
     * @return the m_DocumentReference
     */
    public DocumentReference getM_DocumentReference() {
        return m_DocumentReference;
    }

    /**
     * @param m_DocumentReference
     *            the m_DocumentReference to set
     */
    public void setM_DocumentReference(DocumentReference m_DocumentReference) {
        this.m_DocumentReference = m_DocumentReference;
    }

    /**
     * @return the m_LineResponse
     */
    public LineResponse getM_LineResponse() {
        return m_LineResponse;
    }

    /**
     * @param m_LineResponse
     *            the m_LineResponse to set
     */
    public void setM_LineResponse(LineResponse m_LineResponse) {
        this.m_LineResponse = m_LineResponse;
    }

    /**
     * @return the recipientParty
     */
    public Party getRecipientParty() {
        return RecipientParty;
    }

    /**
     * @param recipientParty
     *            the recipientParty to set
     */
    public void setRecipientParty(Party recipientParty) {
        RecipientParty = recipientParty;
    }

    /**
     * @return the issuerParty
     */
    public Party getIssuerParty() {
        return IssuerParty;
    }

    /**
     * @param issuerParty
     *            the issuerParty to set
     */
    public void setIssuerParty(Party issuerParty) {
        IssuerParty = issuerParty;
    }

    /**
     * @return the m_Response
     */
    public Response getM_Response() {
        return m_Response;
    }

    /**
     * @param m_Response
     *            the m_Response to set
     */
    public void setM_Response(Response m_Response) {
        this.m_Response = m_Response;
    }

}// end DocumentResponse
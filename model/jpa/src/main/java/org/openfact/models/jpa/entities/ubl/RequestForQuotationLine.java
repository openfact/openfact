package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a line in a Request for Quotation.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:28 a. m.
 */
public class RequestForQuotationLine {

    /**
     * An identifier for this line in the request for quotation.
     */
    private String ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String Note;
    /**
     * An indication whether this line is optional (true) or not (false) for
     * purposes of this request for quotation.
     */
    private boolean OptionalLineItemIndicator;
    /**
     * A code signifying the level of confidentiality of this request for
     * quotation line.
     */
    private String PrivacyCode;
    /**
     * A code signifying the security classification of this request for
     * quotation line.
     */
    private String SecurityClassificationCode;
    /**
     * A universally unique identifier for this line in the request for
     * quotation.
     */
    private String UUID;
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private List<LineItem> lineItems = new ArrayList<>();

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        Note = note;
    }

    /**
     * @return the optionalLineItemIndicator
     */
    public boolean isOptionalLineItemIndicator() {
        return OptionalLineItemIndicator;
    }

    /**
     * @param optionalLineItemIndicator
     *            the optionalLineItemIndicator to set
     */
    public void setOptionalLineItemIndicator(boolean optionalLineItemIndicator) {
        OptionalLineItemIndicator = optionalLineItemIndicator;
    }

    /**
     * @return the privacyCode
     */
    public String getPrivacyCode() {
        return PrivacyCode;
    }

    /**
     * @param privacyCode
     *            the privacyCode to set
     */
    public void setPrivacyCode(String privacyCode) {
        PrivacyCode = privacyCode;
    }

    /**
     * @return the securityClassificationCode
     */
    public String getSecurityClassificationCode() {
        return SecurityClassificationCode;
    }

    /**
     * @param securityClassificationCode
     *            the securityClassificationCode to set
     */
    public void setSecurityClassificationCode(String securityClassificationCode) {
        SecurityClassificationCode = securityClassificationCode;
    }

    /**
     * @return the uUID
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * @param uUID
     *            the uUID to set
     */
    public void setUUID(String uUID) {
        UUID = uUID;
    }

    /**
     * @return the documentReferences
     */
    public List<DocumentReference> getDocumentReferences() {
        return documentReferences;
    }

    /**
     * @param documentReferences
     *            the documentReferences to set
     */
    public void setDocumentReferences(List<DocumentReference> documentReferences) {
        this.documentReferences = documentReferences;
    }

    /**
     * @return the lineItems
     */
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    /**
     * @param lineItems
     *            the lineItems to set
     */
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

}// end Request For Quotation Line
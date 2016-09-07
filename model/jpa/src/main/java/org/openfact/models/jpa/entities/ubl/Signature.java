package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to define a signature.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:47 a. m.
 */
public class Signature {

    /**
     * The method used to perform XML canonicalization of this signature.
     */
    private String canonicalizationMethod;
    /**
     * An identifier for this signature.
     */
    private String ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures; in particular, information regarding the circumstances
     * in which the signature is being used.
     */
    private String note;
    /**
     * Text describing the method of signature.
     */
    private String signatureMethod;
    /**
     * The date upon which this signature was verified.
     */
    private LocalDate validationDate;
    /**
     * The time at which this signature was verified.
     */
    private LocalTime validationTime;
    /**
     * An identifier for the organization, person, service, or server that
     * verified this signature.
     */
    private String validatorID;
    private Attachment digitalSignatureAttachment;
    private DocumentReference originalDocumentReference;
    private Party signatoryParty;

    /**
     * @return the canonicalizationMethod
     */
    public String getCanonicalizationMethod() {
        return canonicalizationMethod;
    }

    /**
     * @param canonicalizationMethod
     *            the canonicalizationMethod to set
     */
    public void setCanonicalizationMethod(String canonicalizationMethod) {
        this.canonicalizationMethod = canonicalizationMethod;
    }

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
        return note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the signatureMethod
     */
    public String getSignatureMethod() {
        return signatureMethod;
    }

    /**
     * @param signatureMethod
     *            the signatureMethod to set
     */
    public void setSignatureMethod(String signatureMethod) {
        this.signatureMethod = signatureMethod;
    }

    /**
     * @return the validationDate
     */
    public LocalDate getValidationDate() {
        return validationDate;
    }

    /**
     * @param validationDate
     *            the validationDate to set
     */
    public void setValidationDate(LocalDate validationDate) {
        this.validationDate = validationDate;
    }

    /**
     * @return the validationTime
     */
    public LocalTime getValidationTime() {
        return validationTime;
    }

    /**
     * @param validationTime
     *            the validationTime to set
     */
    public void setValidationTime(LocalTime validationTime) {
        this.validationTime = validationTime;
    }

    /**
     * @return the validatorID
     */
    public String getValidatorID() {
        return validatorID;
    }

    /**
     * @param validatorID
     *            the validatorID to set
     */
    public void setValidatorID(String validatorID) {
        this.validatorID = validatorID;
    }

    /**
     * @return the digitalSignatureAttachment
     */
    public Attachment getDigitalSignatureAttachment() {
        return digitalSignatureAttachment;
    }

    /**
     * @param digitalSignatureAttachment
     *            the digitalSignatureAttachment to set
     */
    public void setDigitalSignatureAttachment(Attachment digitalSignatureAttachment) {
        this.digitalSignatureAttachment = digitalSignatureAttachment;
    }

    /**
     * @return the originalDocumentReference
     */
    public DocumentReference getOriginalDocumentReference() {
        return originalDocumentReference;
    }

    /**
     * @param originalDocumentReference
     *            the originalDocumentReference to set
     */
    public void setOriginalDocumentReference(DocumentReference originalDocumentReference) {
        this.originalDocumentReference = originalDocumentReference;
    }

    /**
     * @return the signatoryParty
     */
    public Party getSignatoryParty() {
        return signatoryParty;
    }

    /**
     * @param signatoryParty
     *            the signatoryParty to set
     */
    public void setSignatoryParty(Party signatoryParty) {
        this.signatoryParty = signatoryParty;
    }

}
package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class SignatureRepresentation {
    private String ID;
    private String note;
    private LocalDate validationDate;
    private LocalTime validationTime;
    private String validatorID;
    private String canonicalizationMethod;
    private String signatureMethod;
    private PartyRepresentation signatoryParty;
    private AttachmentRepresentation digitalSignatureAttachment;
    private DocumentReferenceRepresentation originalDocumentReference;
    private String id;

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValidatorID() {
        return this.validatorID;
    }

    public void setValidatorID(String validatorID) {
        this.validatorID = validatorID;
    }

    public PartyRepresentation getSignatoryParty() {
        return this.signatoryParty;
    }

    public void setSignatoryParty(PartyRepresentation signatoryParty) {
        this.signatoryParty = signatoryParty;
    }

    public LocalTime getValidationTime() {
        return this.validationTime;
    }

    public void setValidationTime(LocalTime validationTime) {
        this.validationTime = validationTime;
    }

    public DocumentReferenceRepresentation getOriginalDocumentReference() {
        return this.originalDocumentReference;
    }

    public void setOriginalDocumentReference(DocumentReferenceRepresentation originalDocumentReference) {
        this.originalDocumentReference = originalDocumentReference;
    }

    public LocalDate getValidationDate() {
        return this.validationDate;
    }

    public void setValidationDate(LocalDate validationDate) {
        this.validationDate = validationDate;
    }

    public AttachmentRepresentation getDigitalSignatureAttachment() {
        return this.digitalSignatureAttachment;
    }

    public void setDigitalSignatureAttachment(AttachmentRepresentation digitalSignatureAttachment) {
        this.digitalSignatureAttachment = digitalSignatureAttachment;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSignatureMethod() {
        return this.signatureMethod;
    }

    public void setSignatureMethod(String signatureMethod) {
        this.signatureMethod = signatureMethod;
    }

    public String getCanonicalizationMethod() {
        return this.canonicalizationMethod;
    }

    public void setCanonicalizationMethod(String canonicalizationMethod) {
        this.canonicalizationMethod = canonicalizationMethod;
    }
}
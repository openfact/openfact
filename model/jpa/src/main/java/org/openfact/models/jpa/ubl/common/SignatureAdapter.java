package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class SignatureAdapter implements SignatureModel, JpaModel<SignatureEntity> {

    protected static final Logger logger = Logger.getLogger(SignatureAdapter.class);
    protected SignatureEntity signature;
    protected EntityManager em;
    protected OpenfactSession session;

    public SignatureAdapter(OpenfactSession session, EntityManager em, SignatureEntity signature) {
        this.session = session;
        this.em = em;
        this.signature = signature;
    }

    String getID() {
        return this.signature.getID();
    }

    void setID(String value) {
        this.signature.setID(value);
    }

    String getNote() {
        return this.signature.getNote();
    }

    void setNote(String value) {
        this.signature.setNote(value);
    }

    LocalDate getValidationDate() {
        return this.signature.getValidationDate();
    }

    void setValidationDate(LocalDate value) {
        this.signature.setValidationDate(value);
    }

    LocalTime getValidationTime() {
        return this.signature.getValidationTime();
    }

    void setValidationTime(LocalTime value) {
        this.signature.setValidationTime(value);
    }

    String getValidatorID() {
        return this.signature.getValidatorID();
    }

    void setValidatorID(String value) {
        this.signature.setValidatorID(value);
    }

    String getCanonicalizationMethod() {
        return this.signature.getCanonicalizationMethod();
    }

    void setCanonicalizationMethod(String value) {
        this.signature.setCanonicalizationMethod(value);
    }

    String getSignatureMethod() {
        return this.signature.getSignatureMethod();
    }

    void setSignatureMethod(String value) {
        this.signature.setSignatureMethod(value);
    }

    PartyAdapter getSignatoryParty() {
        return this.signature.getSignatoryParty();
    }

    void setSignatoryParty(PartyAdapter value) {
        this.signature.setSignatoryParty(value);
    }

    AttachmentAdapter getDigitalSignatureAttachment() {
        return this.signature.getDigitalSignatureAttachment();
    }

    void setDigitalSignatureAttachment(AttachmentAdapter value) {
        this.signature.setDigitalSignatureAttachment(value);
    }

    DocumentReferenceAdapter getOriginalDocumentReference() {
        return this.signature.getOriginalDocumentReference();
    }

    void setOriginalDocumentReference(DocumentReferenceAdapter value) {
        this.signature.setOriginalDocumentReference(value);
    }

    String getId() {
        return this.signature.getId();
    }

    void setId(String value) {
        this.signature.setId(value);
    }

}

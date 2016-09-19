package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.AttachmentModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.SignatureModel;

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

    @Override
    public String getID() {
        return this.signature.getID();
    }

    @Override
    public void setID(String value) {
        this.signature.setID(value);
    }

    @Override
    public String getNote() {
        return this.signature.getNote();
    }

    @Override
    public void setNote(String value) {
        this.signature.setNote(value);
    }

    @Override
    public LocalDate getValidationDate() {
        return this.signature.getValidationDate();
    }

    @Override
    public void setValidationDate(LocalDate value) {
        this.signature.setValidationDate(value);
    }

    @Override
    public LocalTime getValidationTime() {
        return this.signature.getValidationTime();
    }

    @Override
    public void setValidationTime(LocalTime value) {
        this.signature.setValidationTime(value);
    }

    @Override
    public String getValidatorID() {
        return this.signature.getValidatorID();
    }

    @Override
    public void setValidatorID(String value) {
        this.signature.setValidatorID(value);
    }

    @Override
    public String getCanonicalizationMethod() {
        return this.signature.getCanonicalizationMethod();
    }

    @Override
    public void setCanonicalizationMethod(String value) {
        this.signature.setCanonicalizationMethod(value);
    }

    @Override
    public String getSignatureMethod() {
        return this.signature.getSignatureMethod();
    }

    @Override
    public void setSignatureMethod(String value) {
        this.signature.setSignatureMethod(value);
    }

    @Override
    public PartyModel getSignatoryParty() {
        return this.signature.getSignatoryParty();
    }

    @Override
    public void setSignatoryParty(PartyAdapter value) {
        this.signature.setSignatoryParty(value);
    }

    @Override
    public AttachmentModel getDigitalSignatureAttachment() {
        return this.signature.getDigitalSignatureAttachment();
    }

    @Override
    public void setDigitalSignatureAttachment(AttachmentAdapter value) {
        this.signature.setDigitalSignatureAttachment(value);
    }

    @Override
    public DocumentReferenceModel getOriginalDocumentReference() {
        return this.signature.getOriginalDocumentReference();
    }

    @Override
    public void setOriginalDocumentReference(DocumentReferenceAdapter value) {
        this.signature.setOriginalDocumentReference(value);
    }

    @Override
    public String getId() {
        return this.signature.getId();
    }

    @Override
    public void setId(String value) {
        this.signature.setId(value);
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "SIGNATURE")
public class SignatureEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "ID_UBL")
    protected String ID;

    @Column(name = "NOTE")
    protected String note;

    @Column(name = "VALIDATION_DATE")
    @Type(type = "org.hibernate.type.LocalDateType")
    protected LocalDate validationDate;

    @Column(name = "VALIDATION_TIME")
    @Type(type = "org.hibernate.type.LocalTimeType")
    protected LocalTime validationTime;

    @Column(name = "VALIDATOR_ID")
    protected String validatorID;

    @Column(name = "CANONICALIZATION_METHOD")
    protected String canonicalizationMethod;

    @Column(name = "SIGNATURE_METHOD")
    protected String signatureMethod;

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SIGNATORYPARTY_SIGNATURE_ID")
    protected PartyEntity signatoryParty = new PartyEntity();

    @ManyToOne(targetEntity = AttachmentEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DIGITALSIGNATUREATTACHMENT_SIGNATURE_ID")
    protected AttachmentEntity digitalSignatureAttachment = new AttachmentEntity();

    @ManyToOne(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORIGINALDOCUMENTREFERENCE_SIGNATURE_ID")
    protected DocumentReferenceEntity originalDocumentReference = new DocumentReferenceEntity();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
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
     * @return the signatoryParty
     */
    public PartyEntity getSignatoryParty() {
        return signatoryParty;
    }

    /**
     * @param signatoryParty
     *            the signatoryParty to set
     */
    public void setSignatoryParty(PartyEntity signatoryParty) {
        this.signatoryParty = signatoryParty;
    }

    /**
     * @return the digitalSignatureAttachment
     */
    public AttachmentEntity getDigitalSignatureAttachment() {
        return digitalSignatureAttachment;
    }

    /**
     * @param digitalSignatureAttachment
     *            the digitalSignatureAttachment to set
     */
    public void setDigitalSignatureAttachment(AttachmentEntity digitalSignatureAttachment) {
        this.digitalSignatureAttachment = digitalSignatureAttachment;
    }

    /**
     * @return the originalDocumentReference
     */
    public DocumentReferenceEntity getOriginalDocumentReference() {
        return originalDocumentReference;
    }

    /**
     * @param originalDocumentReference
     *            the originalDocumentReference to set
     */
    public void setOriginalDocumentReference(DocumentReferenceEntity originalDocumentReference) {
        this.originalDocumentReference = originalDocumentReference;
    }

}
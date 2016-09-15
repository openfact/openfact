package org.openfact.models.ubl.common;

public interface SignatureType {

    IDType getID();

    void setID(IDType value);

    NoteType getNote();

    void setNote(NoteType value);

    ValidationDateType getValidationDate();

    void setValidationDate(ValidationDateType value);

    ValidationTimeType getValidationTime();

    void setValidationTime(ValidationTimeType value);

    ValidatorIDType getValidatorID();

    void setValidatorID(ValidatorIDType value);

    CanonicalizationMethodType getCanonicalizationMethod();

    void setCanonicalizationMethod(CanonicalizationMethodType value);

    SignatureMethodType getSignatureMethod();

    void setSignatureMethod(SignatureMethodType value);

    PartyType getSignatoryParty();

    void setSignatoryParty(PartyType value);

    AttachmentType getDigitalSignatureAttachment();

    void setDigitalSignatureAttachment(AttachmentType value);

    DocumentReferenceType getOriginalDocumentReference();

    void setOriginalDocumentReference(DocumentReferenceType value);

    String getId();

    void setId(String value);

}

package org.openfact.models.ubl.common;

public interface SignatureModel {

    IDModel getID();

    void setID(IDModel value);

    NoteModel getNote();

    void setNote(NoteModel value);

    ValidationDateModel getValidationDate();

    void setValidationDate(ValidationDateModel value);

    ValidationTimeModel getValidationTime();

    void setValidationTime(ValidationTimeModel value);

    ValidatorIDModel getValidatorID();

    void setValidatorID(ValidatorIDModel value);

    CanonicalizationMethodModel getCanonicalizationMethod();

    void setCanonicalizationMethod(CanonicalizationMethodModel value);

    SignatureMethodModel getSignatureMethod();

    void setSignatureMethod(SignatureMethodModel value);

    PartyModel getSignatoryParty();

    void setSignatoryParty(PartyModel value);

    AttachmentModel getDigitalSignatureAttachment();

    void setDigitalSignatureAttachment(AttachmentModel value);

    DocumentReferenceModel getOriginalDocumentReference();

    void setOriginalDocumentReference(DocumentReferenceModel value);

    String getId();

    void setId(String value);

}

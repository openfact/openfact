package org.openfact.representations.idm.ubl.common;

public interface SignatureModel {

    String getID();

    void setID(String value);

    String getNote();

    void setNote(String value);

    ValidationDateModel getValidationDate();

    void setValidationDate(ValidationDateModel value);

    ValidationTimeModel getValidationTime();

    void setValidationTime(ValidationTimeModel value);

    String getValidatorID();

    void setValidatorID(String value);

    String getCanonicalizationMethod();

    void setCanonicalizationMethod(String value);

    String getSignatureMethod();

    void setSignatureMethod(String value);

    PartyModel getSignatoryParty();

    void setSignatoryParty(PartyModel value);

    AttachmentModel getDigitalSignatureAttachment();

    void setDigitalSignatureAttachment(AttachmentModel value);

    DocumentReferenceModel getOriginalDocumentReference();

    void setOriginalDocumentReference(DocumentReferenceModel value);

    String getId();

    void setId(String value);

}

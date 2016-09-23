package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public interface SignatureModel {

    String getID();

    void setID(String value);

    String getNote();

    void setNote(String value);

    LocalDate getValidationDate();

    void setValidationDate(LocalDate value);

    LocalTime getValidationTime();

    void setValidationTime(LocalTime value);

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

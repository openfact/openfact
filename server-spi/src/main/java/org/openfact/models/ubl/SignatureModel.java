package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.models.ubl.type.*;

public interface SignatureModel {

    TextModel getCanonicalizationMethod();;

    void setCanonicalizationMethod(TextModel canonicalizationMethod);;

    IdentifierModel getID();;

    void setID(IdentifierModel ID);;

    TextModel getNote();;

    void setNote(TextModel note);;

    TextModel getSignatureMethod();;

    void setSignatureMethod(TextModel signatureMethod);;

    LocalDate getValidationDate();

    void setValidationDate(LocalDate validationDate);

    LocalTime getValidationTime();

    void setValidationTime(LocalTime validationTime);

    IdentifierModel getValidatorID();

    void setValidatorID(IdentifierModel validatorID);

    AttachmentModel getDigitalSignatureAttachment();

    void setDigitalSignatureAttachment(AttachmentModel digitalSignatureAttachment);

    DocumentReferenceModel getOriginalDocumentReference();

    void setOriginalDocumentReference(DocumentReferenceModel originalDocumentReference);

    PartyModel getSignatoryParty();

    void setSignatoryParty(PartyModel signatoryParty);

}

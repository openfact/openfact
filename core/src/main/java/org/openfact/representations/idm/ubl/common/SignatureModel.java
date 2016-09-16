package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class SignatureModel {
    protected String ID;
    protected String Note;
    protected LocalDate ValidationDate;
    protected LocalTime ValidationTime;
    protected String ValidatorID;
    protected String CanonicalizationMethod;
    protected String SignatureMethod;
    protected PartyModel SignatoryParty;
    protected AttachmentModel DigitalSignatureAttachment;
    protected DocumentReferenceModel OriginalDocumentReference;
    protected String Id;
}
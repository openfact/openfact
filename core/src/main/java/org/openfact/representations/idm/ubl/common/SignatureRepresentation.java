package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class SignatureRepresentation {
    private String ID;
    private String Note;
    private LocalDate ValidationDate;
    private LocalTime ValidationTime;
    private String ValidatorID;
    private String CanonicalizationMethod;
    private String SignatureMethod;
    private PartyRepresentation SignatoryParty;
    private AttachmentRepresentation DigitalSignatureAttachment;
    private DocumentReferenceRepresentation OriginalDocumentReference;
    private String Id;
}
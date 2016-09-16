package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class SignatureRepresentation {
    private String ID;
    private String note;
    private LocalDate validationDate;
    private LocalTime validationTime;
    private String validatorID;
    private String canonicalizationMethod;
    private String signatureMethod;
    private PartyRepresentation signatoryParty;
    private AttachmentRepresentation digitalSignatureAttachment;
    private DocumentReferenceRepresentation originalDocumentReference;
    private String id;
}

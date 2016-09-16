package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class BillingReferenceRepresentation {
    private DocumentReferenceRepresentation InvoiceDocumentReference;
    private DocumentReferenceRepresentation SelfBilledInvoiceDocumentReference;
    private DocumentReferenceRepresentation CreditNoteDocumentReference;
    private DocumentReferenceRepresentation SelfBilledCreditNoteDocumentReference;
    private DocumentReferenceRepresentation DebitNoteDocumentReference;
    private DocumentReferenceRepresentation ReminderDocumentReference;
    private DocumentReferenceRepresentation AdditionalDocumentReference;
    private List<BillingReferenceLineRepresentation> BillingReferenceLine;
    private String Id;
}
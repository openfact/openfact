package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class BillingReferenceRepresentation {
    private DocumentReferenceRepresentation invoiceDocumentReference;
    private DocumentReferenceRepresentation selfBilledInvoiceDocumentReference;
    private DocumentReferenceRepresentation creditNoteDocumentReference;
    private DocumentReferenceRepresentation selfBilledCreditNoteDocumentReference;
    private DocumentReferenceRepresentation debitNoteDocumentReference;
    private DocumentReferenceRepresentation reminderDocumentReference;
    private DocumentReferenceRepresentation additionalDocumentReference;
    private List<BillingReferenceLineRepresentation> billingReferenceLine;
    private String id;
}

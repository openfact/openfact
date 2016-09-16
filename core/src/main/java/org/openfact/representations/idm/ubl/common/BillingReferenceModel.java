package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class BillingReferenceModel {
    protected DocumentReferenceModel InvoiceDocumentReference;
    protected DocumentReferenceModel SelfBilledInvoiceDocumentReference;
    protected DocumentReferenceModel CreditNoteDocumentReference;
    protected DocumentReferenceModel SelfBilledCreditNoteDocumentReference;
    protected DocumentReferenceModel DebitNoteDocumentReference;
    protected DocumentReferenceModel ReminderDocumentReference;
    protected DocumentReferenceModel AdditionalDocumentReference;
    protected List<BillingReferenceLineModel> BillingReferenceLine;
    protected String Id;
}
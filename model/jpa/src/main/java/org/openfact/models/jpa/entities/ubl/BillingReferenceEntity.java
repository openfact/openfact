package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a reference to a billing document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:07 a. m.
 */
public class BillingReferenceEntity {

    private List<BillingReferenceLineEntity> BillingReferenceLines = new ArrayList<>();
    private DocumentReferenceEntity SelfBilledInvoiceDocumentReference;
    private DocumentReferenceEntity SelfBilledCreditNoteDocumentReference;
    private DocumentReferenceEntity ReminderDocumentReference;
    private DocumentReferenceEntity CreditNoteDocumentReference;
    private DocumentReferenceEntity DebitNoteDocumentReference;
    private DocumentReferenceEntity InvoiceDocumentReference;
    private DocumentReferenceEntity AdditionalDocumentReference;

}

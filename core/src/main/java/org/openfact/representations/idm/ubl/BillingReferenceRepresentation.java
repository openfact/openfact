package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a reference to a billing document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:07 a. m.
 */
public class BillingReferenceRepresentation {

    private List<BillingReferenceLineRepresentation> billingReferenceLines = new ArrayList<>();
    private DocumentReferenceRepresentation selfBilledInvoiceDocumentReference;
    private DocumentReferenceRepresentation selfBilledCreditNoteDocumentReference;
    private DocumentReferenceRepresentation reminderDocumentReference;
    private DocumentReferenceRepresentation creditNoteDocumentReference;
    private DocumentReferenceRepresentation debitNoteDocumentReference;
    private DocumentReferenceRepresentation invoiceDocumentReference;
    private DocumentReferenceRepresentation additionalDocumentReference;

}

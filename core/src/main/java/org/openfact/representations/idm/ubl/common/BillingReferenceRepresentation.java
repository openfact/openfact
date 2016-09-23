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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DocumentReferenceRepresentation getInvoiceDocumentReference() {
        return this.invoiceDocumentReference;
    }

    public void setInvoiceDocumentReference(DocumentReferenceRepresentation invoiceDocumentReference) {
        this.invoiceDocumentReference = invoiceDocumentReference;
    }

    public List<BillingReferenceLineRepresentation> getBillingReferenceLine() {
        return this.billingReferenceLine;
    }

    public void setBillingReferenceLine(List<BillingReferenceLineRepresentation> billingReferenceLine) {
        this.billingReferenceLine = billingReferenceLine;
    }

    public DocumentReferenceRepresentation getCreditNoteDocumentReference() {
        return this.creditNoteDocumentReference;
    }

    public void setCreditNoteDocumentReference(DocumentReferenceRepresentation creditNoteDocumentReference) {
        this.creditNoteDocumentReference = creditNoteDocumentReference;
    }

    public DocumentReferenceRepresentation getAdditionalDocumentReference() {
        return this.additionalDocumentReference;
    }

    public void setAdditionalDocumentReference(DocumentReferenceRepresentation additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

    public DocumentReferenceRepresentation getSelfBilledCreditNoteDocumentReference() {
        return this.selfBilledCreditNoteDocumentReference;
    }

    public void setSelfBilledCreditNoteDocumentReference(
            DocumentReferenceRepresentation selfBilledCreditNoteDocumentReference) {
        this.selfBilledCreditNoteDocumentReference = selfBilledCreditNoteDocumentReference;
    }

    public DocumentReferenceRepresentation getDebitNoteDocumentReference() {
        return this.debitNoteDocumentReference;
    }

    public void setDebitNoteDocumentReference(DocumentReferenceRepresentation debitNoteDocumentReference) {
        this.debitNoteDocumentReference = debitNoteDocumentReference;
    }

    public DocumentReferenceRepresentation getSelfBilledInvoiceDocumentReference() {
        return this.selfBilledInvoiceDocumentReference;
    }

    public void setSelfBilledInvoiceDocumentReference(
            DocumentReferenceRepresentation selfBilledInvoiceDocumentReference) {
        this.selfBilledInvoiceDocumentReference = selfBilledInvoiceDocumentReference;
    }

    public DocumentReferenceRepresentation getReminderDocumentReference() {
        return this.reminderDocumentReference;
    }

    public void setReminderDocumentReference(DocumentReferenceRepresentation reminderDocumentReference) {
        this.reminderDocumentReference = reminderDocumentReference;
    }
}
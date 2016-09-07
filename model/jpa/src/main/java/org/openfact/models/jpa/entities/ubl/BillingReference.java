package org.openfact.models.jpa.entities.ubl;

/**
 * A class to define a reference to a billing document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:07 a. m.
 */
public class BillingReference {

    private BillingReference linem_BillingReferenceLine;
    private DocumentReference selfBilledInvoiceDocumentReference;
    private DocumentReference selfBilledCreditNoteDocumentReference;
    private DocumentReference ReminderDocumentReference;
    private DocumentReference creditNoteDocumentReference;
    private DocumentReference debitNoteDocumentReference;
    private DocumentReference invoiceDocumentReference;
    private DocumentReference additionalDocumentReference;

    /**
     * @return the linem_BillingReferenceLine
     */
    public BillingReference getLinem_BillingReferenceLine() {
        return linem_BillingReferenceLine;
    }

    /**
     * @param linem_BillingReferenceLine
     *            the linem_BillingReferenceLine to set
     */
    public void setLinem_BillingReferenceLine(BillingReference linem_BillingReferenceLine) {
        this.linem_BillingReferenceLine = linem_BillingReferenceLine;
    }

    /**
     * @return the selfBilledInvoiceDocumentReference
     */
    public DocumentReference getSelfBilledInvoiceDocumentReference() {
        return selfBilledInvoiceDocumentReference;
    }

    /**
     * @param selfBilledInvoiceDocumentReference
     *            the selfBilledInvoiceDocumentReference to set
     */
    public void setSelfBilledInvoiceDocumentReference(DocumentReference selfBilledInvoiceDocumentReference) {
        this.selfBilledInvoiceDocumentReference = selfBilledInvoiceDocumentReference;
    }

    /**
     * @return the selfBilledCreditNoteDocumentReference
     */
    public DocumentReference getSelfBilledCreditNoteDocumentReference() {
        return selfBilledCreditNoteDocumentReference;
    }

    /**
     * @param selfBilledCreditNoteDocumentReference
     *            the selfBilledCreditNoteDocumentReference to set
     */
    public void setSelfBilledCreditNoteDocumentReference(
            DocumentReference selfBilledCreditNoteDocumentReference) {
        this.selfBilledCreditNoteDocumentReference = selfBilledCreditNoteDocumentReference;
    }

    /**
     * @return the reminderDocumentReference
     */
    public DocumentReference getReminderDocumentReference() {
        return ReminderDocumentReference;
    }

    /**
     * @param reminderDocumentReference
     *            the reminderDocumentReference to set
     */
    public void setReminderDocumentReference(DocumentReference reminderDocumentReference) {
        ReminderDocumentReference = reminderDocumentReference;
    }

    /**
     * @return the creditNoteDocumentReference
     */
    public DocumentReference getCreditNoteDocumentReference() {
        return creditNoteDocumentReference;
    }

    /**
     * @param creditNoteDocumentReference
     *            the creditNoteDocumentReference to set
     */
    public void setCreditNoteDocumentReference(DocumentReference creditNoteDocumentReference) {
        this.creditNoteDocumentReference = creditNoteDocumentReference;
    }

    /**
     * @return the debitNoteDocumentReference
     */
    public DocumentReference getDebitNoteDocumentReference() {
        return debitNoteDocumentReference;
    }

    /**
     * @param debitNoteDocumentReference
     *            the debitNoteDocumentReference to set
     */
    public void setDebitNoteDocumentReference(DocumentReference debitNoteDocumentReference) {
        this.debitNoteDocumentReference = debitNoteDocumentReference;
    }

    /**
     * @return the invoiceDocumentReference
     */
    public DocumentReference getInvoiceDocumentReference() {
        return invoiceDocumentReference;
    }

    /**
     * @param invoiceDocumentReference
     *            the invoiceDocumentReference to set
     */
    public void setInvoiceDocumentReference(DocumentReference invoiceDocumentReference) {
        this.invoiceDocumentReference = invoiceDocumentReference;
    }

    /**
     * @return the additionalDocumentReference
     */
    public DocumentReference getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }

    /**
     * @param additionalDocumentReference
     *            the additionalDocumentReference to set
     */
    public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

}// end BillingReference
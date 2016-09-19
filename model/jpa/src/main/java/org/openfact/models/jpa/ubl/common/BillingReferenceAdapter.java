package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class BillingReferenceAdapter implements BillingReferenceModel, JpaModel<BillingReferenceEntity> {

    protected static final Logger logger = Logger.getLogger(BillingReferenceAdapter.class);
    protected BillingReferenceEntity billingReference;
    protected EntityManager em;
    protected OpenfactSession session;

    public BillingReferenceAdapter(OpenfactSession session, EntityManager em,
            BillingReferenceEntity billingReference) {
        this.session = session;
        this.em = em;
        this.billingReference = billingReference;
    }

    DocumentReferenceAdapter getInvoiceDocumentReference() {
        return this.billingReference.getInvoiceDocumentReference();
    }

    void setInvoiceDocumentReference(DocumentReferenceAdapter value) {
        this.billingReference.setInvoiceDocumentReference(value);
    }

    DocumentReferenceAdapter getSelfBilledInvoiceDocumentReference() {
        return this.billingReference.getSelfBilledInvoiceDocumentReference();
    }

    void setSelfBilledInvoiceDocumentReference(DocumentReferenceAdapter value) {
        this.billingReference.setSelfBilledInvoiceDocumentReference(value);
    }

    DocumentReferenceAdapter getCreditNoteDocumentReference() {
        return this.billingReference.getCreditNoteDocumentReference();
    }

    void setCreditNoteDocumentReference(DocumentReferenceAdapter value) {
        this.billingReference.setCreditNoteDocumentReference(value);
    }

    DocumentReferenceAdapter getSelfBilledCreditNoteDocumentReference() {
        return this.billingReference.getSelfBilledCreditNoteDocumentReference();
    }

    void setSelfBilledCreditNoteDocumentReference(DocumentReferenceAdapter value) {
        this.billingReference.setSelfBilledCreditNoteDocumentReference(value);
    }

    DocumentReferenceAdapter getDebitNoteDocumentReference() {
        return this.billingReference.getDebitNoteDocumentReference();
    }

    void setDebitNoteDocumentReference(DocumentReferenceAdapter value) {
        this.billingReference.setDebitNoteDocumentReference(value);
    }

    DocumentReferenceAdapter getReminderDocumentReference() {
        return this.billingReference.getReminderDocumentReference();
    }

    void setReminderDocumentReference(DocumentReferenceAdapter value) {
        this.billingReference.setReminderDocumentReference(value);
    }

    DocumentReferenceAdapter getAdditionalDocumentReference() {
        return this.billingReference.getAdditionalDocumentReference();
    }

    void setAdditionalDocumentReference(DocumentReferenceAdapter value) {
        this.billingReference.setAdditionalDocumentReference(value);
    }

    List<BillingReferenceLineAdapter> getBillingReferenceLine() {
        return this.billingReference.getBillingReferenceLine();
    }

    void setBillingReferenceLine(List<BillingReferenceLineAdapter> billingReferenceLine) {
        this.billingReference.setBillingReferenceLine(billingReferenceLine);
    }

    String getId() {
        return this.billingReference.getId();
    }

    void setId(String value) {
        this.billingReference.setId(value);
    }

}

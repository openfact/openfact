package org.openfact.models.ubl.common;

import java.util.List;

public interface BillingReferenceType {

    DocumentReferenceType getInvoiceDocumentReference();

    void setInvoiceDocumentReference(DocumentReferenceType value);

    DocumentReferenceType getSelfBilledInvoiceDocumentReference();

    void setSelfBilledInvoiceDocumentReference(DocumentReferenceType value);

    DocumentReferenceType getCreditNoteDocumentReference();

    void setCreditNoteDocumentReference(DocumentReferenceType value);

    DocumentReferenceType getSelfBilledCreditNoteDocumentReference();

    void setSelfBilledCreditNoteDocumentReference(DocumentReferenceType value);

    DocumentReferenceType getDebitNoteDocumentReference();

    void setDebitNoteDocumentReference(DocumentReferenceType value);

    DocumentReferenceType getReminderDocumentReference();

    void setReminderDocumentReference(DocumentReferenceType value);

    DocumentReferenceType getAdditionalDocumentReference();

    void setAdditionalDocumentReference(DocumentReferenceType value);

    List<BillingReferenceLineType> getBillingReferenceLine();

    void setBillingReferenceLine(List<BillingReferenceLineType> billingReferenceLine);

    String getId();

    void setId(String value);

}

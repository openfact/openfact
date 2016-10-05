package org.openfact.models.ubl.common;

import java.util.List;

public interface BillingReferenceModel {

    DocumentReferenceModel getInvoiceDocumentReference();

    void setInvoiceDocumentReference(DocumentReferenceModel value);

    DocumentReferenceModel getSelfBilledInvoiceDocumentReference();

    void setSelfBilledInvoiceDocumentReference(DocumentReferenceModel value);

    DocumentReferenceModel getCreditNoteDocumentReference();

    void setCreditNoteDocumentReference(DocumentReferenceModel value);

    DocumentReferenceModel getSelfBilledCreditNoteDocumentReference();

    void setSelfBilledCreditNoteDocumentReference(DocumentReferenceModel value);

    DocumentReferenceModel getDebitNoteDocumentReference();

    void setDebitNoteDocumentReference(DocumentReferenceModel value);

    DocumentReferenceModel getReminderDocumentReference();

    void setReminderDocumentReference(DocumentReferenceModel value);

    DocumentReferenceModel getAdditionalDocumentReference();

    void setAdditionalDocumentReference(DocumentReferenceModel value);

    List<BillingReferenceLineModel> getBillingReferenceLine();

    void setBillingReferenceLine(List<BillingReferenceLineModel> billingReferenceLine);

    String getId();

    

}

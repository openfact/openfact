package org.openfact.models.ubl.common;

import java.util.List;

public interface QuotationLineType {

    IDType getID();

    void setID(IDType value);

    NoteType getNote();

    void setNote(NoteType value);

    QuantityTypeCommBas getQuantity();

    void setQuantity(QuantityTypeCommBas value);

    LineExtensionAmountType getLineExtensionAmount();

    void setLineExtensionAmount(LineExtensionAmountType value);

    TotalTaxAmountType getTotalTaxAmount();

    void setTotalTaxAmount(TotalTaxAmountType value);

    List<DocumentReferenceType> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceType> documentReference);

    LineItemType getLineItem();

    void setLineItem(LineItemType value);

    List<LineItemType> getSellerProposedSubstituteLineItem();

    void setSellerProposedSubstituteLineItem(List<LineItemType> sellerProposedSubstituteLineItem);

    String getId();

    void setId(String value);

}

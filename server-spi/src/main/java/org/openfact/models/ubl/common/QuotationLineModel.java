package org.openfact.models.ubl.common;

import java.util.List;

public interface QuotationLineModel {

    IDModel getID();

    void setID(IDModel value);

    NoteModel getNote();

    void setNote(NoteModel value);

    QuantityModelCommBas getQuantity();

    void setQuantity(QuantityModelCommBas value);

    LineExtensionAmountModel getLineExtensionAmount();

    void setLineExtensionAmount(LineExtensionAmountModel value);

    TotalTaxAmountModel getTotalTaxAmount();

    void setTotalTaxAmount(TotalTaxAmountModel value);

    List<DocumentReferenceModel> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceModel> documentReference);

    LineItemModel getLineItem();

    void setLineItem(LineItemModel value);

    List<LineItemModel> getSellerProposedSubstituteLineItem();

    void setSellerProposedSubstituteLineItem(List<LineItemModel> sellerProposedSubstituteLineItem);

    String getId();

    void setId(String value);

}

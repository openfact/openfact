package org.openfact.models.ubl.common;

import java.util.List;

public interface OrderLineModel {

    String getSubstitutionStatusCode();

    void setSubstitutionStatusCode(String value);

    String getNote();

    void setNote(String value);

    LineItemModel getLineItem();

    void setLineItem(LineItemModel value);

    List<LineItemModel> getSellerProposedSubstituteLineItem();

    void setSellerProposedSubstituteLineItem(List<LineItemModel> sellerProposedSubstituteLineItem);

    List<LineItemModel> getSellerSubstitutedLineItem();

    void setSellerSubstitutedLineItem(List<LineItemModel> sellerSubstitutedLineItem);

    List<LineItemModel> getBuyerProposedSubstituteLineItem();

    void setBuyerProposedSubstituteLineItem(List<LineItemModel> buyerProposedSubstituteLineItem);

    LineReferenceModel getCatalogueLineReference();

    void setCatalogueLineReference(LineReferenceModel value);

    LineReferenceModel getQuotationLineReference();

    void setQuotationLineReference(LineReferenceModel value);

    List<DocumentReferenceModel> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceModel> documentReference);

    String getId();

    void setId(String value);

}

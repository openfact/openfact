package org.openfact.models.ubl.common;

import java.util.List;

public interface OrderLineType {

    SubstitutionStatusCodeTypeCommBas getSubstitutionStatusCode();

    void setSubstitutionStatusCode(SubstitutionStatusCodeTypeCommBas value);

    NoteType getNote();

    void setNote(NoteType value);

    LineItemType getLineItem();

    void setLineItem(LineItemType value);

    List<LineItemType> getSellerProposedSubstituteLineItem();

    void setSellerProposedSubstituteLineItem(List<LineItemType> sellerProposedSubstituteLineItem);

    List<LineItemType> getSellerSubstitutedLineItem();

    void setSellerSubstitutedLineItem(List<LineItemType> sellerSubstitutedLineItem);

    List<LineItemType> getBuyerProposedSubstituteLineItem();

    void setBuyerProposedSubstituteLineItem(List<LineItemType> buyerProposedSubstituteLineItem);

    LineReferenceType getCatalogueLineReference();

    void setCatalogueLineReference(LineReferenceType value);

    LineReferenceType getQuotationLineReference();

    void setQuotationLineReference(LineReferenceType value);

    List<DocumentReferenceType> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceType> documentReference);

    String getId();

    void setId(String value);

}

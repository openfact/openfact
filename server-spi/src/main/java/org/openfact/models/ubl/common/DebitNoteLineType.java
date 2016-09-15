package org.openfact.models.ubl.common;

import java.util.List;

public interface DebitNoteLineType {

    IDType getID();

    void setID(IDType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    NoteType getNote();

    void setNote(NoteType value);

    DebitedQuantityType getDebitedQuantity();

    void setDebitedQuantity(DebitedQuantityType value);

    LineExtensionAmountType getLineExtensionAmount();

    void setLineExtensionAmount(LineExtensionAmountType value);

    TaxPointDateType getTaxPointDate();

    void setTaxPointDate(TaxPointDateType value);

    AccountingCostCodeType getAccountingCostCode();

    void setAccountingCostCode(AccountingCostCodeType value);

    AccountingCostType getAccountingCost();

    void setAccountingCost(AccountingCostType value);

    List<ResponseType> getDiscrepancyResponse();

    void setDiscrepancyResponse(List<ResponseType> discrepancyResponse);

    List<LineReferenceType> getDespatchLineReference();

    void setDespatchLineReference(List<LineReferenceType> despatchLineReference);

    List<LineReferenceType> getReceiptLineReference();

    void setReceiptLineReference(List<LineReferenceType> receiptLineReference);

    List<BillingReferenceType> getBillingReference();

    void setBillingReference(List<BillingReferenceType> billingReference);

    List<DocumentReferenceType> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceType> documentReference);

    PricingReferenceType getPricingReference();

    void setPricingReference(PricingReferenceType value);

    List<DeliveryType> getDelivery();

    void setDelivery(List<DeliveryType> delivery);

    List<TaxTotalType> getTaxTotal();

    void setTaxTotal(List<TaxTotalType> taxTotal);

    ItemType getItem();

    void setItem(ItemType value);

    PriceType getPrice();

    void setPrice(PriceType value);

    String getId();

    void setId(String value);

}

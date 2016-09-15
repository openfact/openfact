package org.openfact.models.ubl.common;

import java.util.List;

public interface InvoiceLineType {

    IDType getID();

    void setID(IDType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    NoteType getNote();

    void setNote(NoteType value);

    InvoicedQuantityType getInvoicedQuantity();

    void setInvoicedQuantity(InvoicedQuantityType value);

    LineExtensionAmountType getLineExtensionAmount();

    void setLineExtensionAmount(LineExtensionAmountType value);

    TaxPointDateType getTaxPointDate();

    void setTaxPointDate(TaxPointDateType value);

    AccountingCostCodeType getAccountingCostCode();

    void setAccountingCostCode(AccountingCostCodeType value);

    AccountingCostType getAccountingCost();

    void setAccountingCost(AccountingCostType value);

    FreeOfChargeIndicatorType getFreeOfChargeIndicator();

    void setFreeOfChargeIndicator(FreeOfChargeIndicatorType value);

    List<OrderLineReferenceType> getOrderLineReference();

    void setOrderLineReference(List<OrderLineReferenceType> orderLineReference);

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

    PartyType getOriginatorParty();

    void setOriginatorParty(PartyType value);

    List<DeliveryType> getDelivery();

    void setDelivery(List<DeliveryType> delivery);

    List<PaymentTermsType> getPaymentTerms();

    void setPaymentTerms(List<PaymentTermsType> paymentTerms);

    List<AllowanceChargeType> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeType> allowanceCharge);

    List<TaxTotalType> getTaxTotal();

    void setTaxTotal(List<TaxTotalType> taxTotal);

    ItemType getItem();

    void setItem(ItemType value);

    PriceType getPrice();

    void setPrice(PriceType value);

    DeliveryTermsType getDeliveryTerms();

    void setDeliveryTerms(DeliveryTermsType value);

    String getId();

    void setId(String value);

}

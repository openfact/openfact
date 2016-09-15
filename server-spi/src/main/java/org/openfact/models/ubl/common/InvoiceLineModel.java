package org.openfact.models.ubl.common;

import java.util.List;

public interface InvoiceLineModel {

    String getID();

    void setID(String value);

    String getUUID();

    void setUUID(String value);

    String getNote();

    void setNote(String value);

    InvoicedQuantityModel getInvoicedQuantity();

    void setInvoicedQuantity(InvoicedQuantityModel value);

    LineExtensionAmountModel getLineExtensionAmount();

    void setLineExtensionAmount(LineExtensionAmountModel value);

    TaxPointDateModel getTaxPointDate();

    void setTaxPointDate(TaxPointDateModel value);

    String getAccountingCostCode();

    void setAccountingCostCode(String value);

    String getAccountingCost();

    void setAccountingCost(String value);

    FreeOfChargeIndicatorModel getFreeOfChargeIndicator();

    void setFreeOfChargeIndicator(FreeOfChargeIndicatorModel value);

    List<OrderLineReferenceModel> getOrderLineReference();

    void setOrderLineReference(List<OrderLineReferenceModel> orderLineReference);

    List<LineReferenceModel> getDespatchLineReference();

    void setDespatchLineReference(List<LineReferenceModel> despatchLineReference);

    List<LineReferenceModel> getReceiptLineReference();

    void setReceiptLineReference(List<LineReferenceModel> receiptLineReference);

    List<BillingReferenceModel> getBillingReference();

    void setBillingReference(List<BillingReferenceModel> billingReference);

    List<DocumentReferenceModel> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceModel> documentReference);

    PricingReferenceModel getPricingReference();

    void setPricingReference(PricingReferenceModel value);

    PartyModel getOriginatorParty();

    void setOriginatorParty(PartyModel value);

    List<DeliveryModel> getDelivery();

    void setDelivery(List<DeliveryModel> delivery);

    List<PaymentTermsModel> getPaymentTerms();

    void setPaymentTerms(List<PaymentTermsModel> paymentTerms);

    List<AllowanceChargeModel> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge);

    List<TaxTotalModel> getTaxTotal();

    void setTaxTotal(List<TaxTotalModel> taxTotal);

    ItemModel getItem();

    void setItem(ItemModel value);

    PriceModel getPrice();

    void setPrice(PriceModel value);

    DeliveryTermsModel getDeliveryTerms();

    void setDeliveryTerms(DeliveryTermsModel value);

    String getId();

    void setId(String value);

}

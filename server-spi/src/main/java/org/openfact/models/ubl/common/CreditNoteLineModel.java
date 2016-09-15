package org.openfact.models.ubl.common;

import java.util.List;

public interface CreditNoteLineModel {

    IDModel getID();

    void setID(IDModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    NoteModel getNote();

    void setNote(NoteModel value);

    CreditedQuantityModel getCreditedQuantity();

    void setCreditedQuantity(CreditedQuantityModel value);

    LineExtensionAmountModel getLineExtensionAmount();

    void setLineExtensionAmount(LineExtensionAmountModel value);

    TaxPointDateModel getTaxPointDate();

    void setTaxPointDate(TaxPointDateModel value);

    String getAccountingCostCode();

    void setAccountingCostCode(String value);

    AccountingCostModel getAccountingCost();

    void setAccountingCost(AccountingCostModel value);

    List<ResponseModel> getDiscrepancyResponse();

    void setDiscrepancyResponse(List<ResponseModel> discrepancyResponse);

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

    List<DeliveryModel> getDelivery();

    void setDelivery(List<DeliveryModel> delivery);

    List<TaxTotalModel> getTaxTotal();

    void setTaxTotal(List<TaxTotalModel> taxTotal);

    ItemModel getItem();

    void setItem(ItemModel value);

    PriceModel getPrice();

    void setPrice(PriceModel value);

    String getId();

    void setId(String value);

}

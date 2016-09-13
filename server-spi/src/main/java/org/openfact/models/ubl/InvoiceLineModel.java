package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.openfact.models.ubl.type.*;

public interface InvoiceLineModel {

    TextModel getAccountingCost();

    void setAccountingCost(TextModel accountingCost);

    CodeModel getAccountingCostCode();

    void setAccountingCostCode(CodeModel accountingCostCode);

    boolean isFreeOfChargeIndicator();

    void setFreeOfChargeIndicator(boolean freeOfChargeIndicator);

    IdentifierModel getID();

    void setID(IdentifierModel iD);

    QuantityModel getInvoicedQuantity();

    void setInvoicedQuantity(BigDecimal valueParam);

    void setInvoicedQuantity(QuantityModel invoicedQuantity);

    BigDecimal getLineExtensionAmount();

    void setLineExtensionAmount(BigDecimal lineExtensionAmount);

    TextModel getNote();

    void setNote(TextModel note);

    CodeModel getPaymentPurposeCode();

    void setPaymentPurposeCode(CodeModel paymentPurposeCode);

    LocalDate getTaxPointDate();

    void setTaxPointDate(LocalDate taxPointDate);

    IdentifierModel getUUID();

    void setUUID(IdentifierModel uUID);

    List<AllowanceChargeModel> getAllowanceCharges();

    void setAllowanceCharges(List<AllowanceChargeModel> allowanceCharges);

    List<BillingReferenceModel> getBillingReferences();

    void setBillingReferences(List<BillingReferenceModel> billingReferences);

    List<DeliveryModel> getDeliveries();

    void setDeliveries(List<DeliveryModel> deliveries);

    List<DeliveryTermsModel> getDeliveriesTerms();

    void setDeliveriesTerms(List<DeliveryTermsModel> deliveriesTerms);

    List<DocumentReferenceModel> getDocumentReferences();

    void setDocumentReferences(List<DocumentReferenceModel> documentReferences);

    ItemModel getItem();

    void setItems(List<ItemModel> items);

    LineReferenceModel getDespatchLineReference();

    void setDespatchLineReference(LineReferenceModel despatchLineReference);

    LineReferenceModel getReceiptLineReference();

    void setReceiptLineReference(LineReferenceModel receiptLineReference);

    List<OrderLineReferenceModel> getOrderLineReferences();

    void setOrderLineReferences(List<OrderLineReferenceModel> orderLineReferences);

    PartyModel getOriginatorParty();

    void setOriginatorParty(PartyModel originatorParty);

    List<PaymentTermsModel> getPaymentTermses();

    void setPaymentTermses(List<PaymentTermsModel> paymentTermses);

    PeriodModel getInvoicePeriod();

    void setInvoicePeriod(PeriodModel invoicePeriod);

    InvoiceLineModel getSubInvoiceLine();

    void setSubInvoiceLine(InvoiceLineModel subInvoiceLine);

    PriceModel getPrice();

    void setPrices(List<PriceModel> prices);

    PriceExtensionModel getItemPriceExtension();

    void setItemPriceExtension(PriceExtensionModel itemPriceExtension);

    PricingReferenceModel getPricingReference();

    void setPricingReference(PricingReferenceModel pricingReference);

    List<TaxTotalModel> getWithholdingTaxTotal();

    void setWithholdingTaxTotal(List<TaxTotalModel> withholdingTaxTotal);

    List<TaxTotalModel> getTaxTotals();

    void setTaxTotals(List<TaxTotalModel> taxTotals);

    TaxTotalModel addTaxTotal();

}

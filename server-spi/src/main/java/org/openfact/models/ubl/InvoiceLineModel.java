package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.openfact.models.ubl.type.*;

public interface InvoiceLineModel {

    TextType getAccountingCost();

    void setAccountingCost(TextType accountingCost);

    CodeType getAccountingCostCode();

    void setAccountingCostCode(CodeType accountingCostCode);

    boolean isFreeOfChargeIndicator();

    void setFreeOfChargeIndicator(boolean freeOfChargeIndicator);

    IdentifierType getID();

    void setID(IdentifierType iD);

    QuantityType getInvoicedQuantity();

    void setInvoicedQuantity(BigDecimal valueParam);

    void setInvoicedQuantity(QuantityType invoicedQuantity);

    BigDecimal getLineExtensionAmount();

    void setLineExtensionAmount(BigDecimal lineExtensionAmount);

    TextType getNote();

    void setNote(TextType note);

    CodeType getPaymentPurposeCode();

    void setPaymentPurposeCode(CodeType paymentPurposeCode);

    LocalDate getTaxPointDate();

    void setTaxPointDate(LocalDate taxPointDate);

    IdentifierType getUUID();

    void setUUID(IdentifierType uUID);

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

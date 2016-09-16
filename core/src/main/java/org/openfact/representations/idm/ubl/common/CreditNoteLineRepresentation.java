package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CreditNoteLineRepresentation {
    private String ID;
    private String UUID;
    private String note;
    private QuantityRepresentation creditedQuantity;
    private BigDecimal lineExtensionAmount;
    private LocalDate taxPointDate;
    private String accountingCostCode;
    private String accountingCost;
    private List<ResponseRepresentation> discrepancyResponse;
    private List<LineReferenceRepresentation> despatchLineReference;
    private List<LineReferenceRepresentation> receiptLineReference;
    private List<BillingReferenceRepresentation> billingReference;
    private List<DocumentReferenceRepresentation> documentReference;
    private PricingReferenceRepresentation pricingReference;
    private List<DeliveryRepresentation> delivery;
    private List<TaxTotalRepresentation> taxTotal;
    private ItemRepresentation item;
    private PriceRepresentation price;
    private String id;

    public LocalDate getTaxPointDate() {
        return this.taxPointDate;
    }

    public void setTaxPointDate(LocalDate taxPointDate) {
        this.taxPointDate = taxPointDate;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DocumentReferenceRepresentation> getDocumentReference() {
        return this.documentReference;
    }

    public void setDocumentReference(List<DocumentReferenceRepresentation> documentReference) {
        this.documentReference = documentReference;
    }

    public PriceRepresentation getPrice() {
        return this.price;
    }

    public void setPrice(PriceRepresentation price) {
        this.price = price;
    }

    public BigDecimal getLineExtensionAmount() {
        return this.lineExtensionAmount;
    }

    public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
    }

    public PricingReferenceRepresentation getPricingReference() {
        return this.pricingReference;
    }

    public void setPricingReference(PricingReferenceRepresentation pricingReference) {
        this.pricingReference = pricingReference;
    }

    public List<LineReferenceRepresentation> getReceiptLineReference() {
        return this.receiptLineReference;
    }

    public void setReceiptLineReference(List<LineReferenceRepresentation> receiptLineReference) {
        this.receiptLineReference = receiptLineReference;
    }

    public List<DeliveryRepresentation> getDelivery() {
        return this.delivery;
    }

    public void setDelivery(List<DeliveryRepresentation> delivery) {
        this.delivery = delivery;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<TaxTotalRepresentation> getTaxTotal() {
        return this.taxTotal;
    }

    public void setTaxTotal(List<TaxTotalRepresentation> taxTotal) {
        this.taxTotal = taxTotal;
    }

    public QuantityRepresentation getCreditedQuantity() {
        return this.creditedQuantity;
    }

    public void setCreditedQuantity(QuantityRepresentation creditedQuantity) {
        this.creditedQuantity = creditedQuantity;
    }

    public List<ResponseRepresentation> getDiscrepancyResponse() {
        return this.discrepancyResponse;
    }

    public void setDiscrepancyResponse(List<ResponseRepresentation> discrepancyResponse) {
        this.discrepancyResponse = discrepancyResponse;
    }

    public String getUUID() {
        return this.UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getAccountingCostCode() {
        return this.accountingCostCode;
    }

    public void setAccountingCostCode(String accountingCostCode) {
        this.accountingCostCode = accountingCostCode;
    }

    public ItemRepresentation getItem() {
        return this.item;
    }

    public void setItem(ItemRepresentation item) {
        this.item = item;
    }

    public String getAccountingCost() {
        return this.accountingCost;
    }

    public void setAccountingCost(String accountingCost) {
        this.accountingCost = accountingCost;
    }

    public List<LineReferenceRepresentation> getDespatchLineReference() {
        return this.despatchLineReference;
    }

    public void setDespatchLineReference(List<LineReferenceRepresentation> despatchLineReference) {
        this.despatchLineReference = despatchLineReference;
    }

    public List<BillingReferenceRepresentation> getBillingReference() {
        return this.billingReference;
    }

    public void setBillingReference(List<BillingReferenceRepresentation> billingReference) {
        this.billingReference = billingReference;
    }
}
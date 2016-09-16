package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvoiceLineRepresentation {
    private String ID;
    private String UUID;
    private String note;
    private QuantityRepresentation invoicedQuantity;
    private BigDecimal lineExtensionAmount;
    private LocalDate taxPointDate;
    private String accountingCostCode;
    private String accountingCost;
    private boolean freeOfChargeIndicator;
    private List<OrderLineReferenceRepresentation> orderLineReference;
    private List<LineReferenceRepresentation> despatchLineReference;
    private List<LineReferenceRepresentation> receiptLineReference;
    private List<BillingReferenceRepresentation> billingReference;
    private List<DocumentReferenceRepresentation> documentReference;
    private PricingReferenceRepresentation pricingReference;
    private PartyRepresentation originatorParty;
    private List<DeliveryRepresentation> delivery;
    private List<PaymentTermsRepresentation> paymentTerms;
    private List<AllowanceChargeRepresentation> allowanceCharge;
    private List<TaxTotalRepresentation> taxTotal;
    private ItemRepresentation item;
    private PriceRepresentation price;
    private DeliveryTermsRepresentation deliveryTerms;
    private String id;

    /**/
    public void addOrderLineReference(OrderLineReferenceRepresentation representation){
        if(orderLineReference==null){
            orderLineReference=new ArrayList<>();
        }
        orderLineReference.add(representation);
    }
    public void addDespatchLineReference(LineReferenceRepresentation representation){
        if(despatchLineReference==null){
            despatchLineReference=new ArrayList<>();
        }
        despatchLineReference.add(representation);
    }
    public void addReceiptLineReference(LineReferenceRepresentation representation){
        if(receiptLineReference==null){
            receiptLineReference=new ArrayList<>();
        }
        receiptLineReference.add(representation);
    }
    public void addBillingReference(BillingReferenceRepresentation representation){
        if(billingReference==null){
            billingReference=new ArrayList<>();
        }
        billingReference.add(representation);
    }
    public void addDocumentReference(DocumentReferenceRepresentation representation){
        if(documentReference==null){
            documentReference=new ArrayList<>();
        }
        documentReference.add(representation);
    }
    public void addDelivery(DeliveryRepresentation representation){
        if(delivery==null){
            delivery=new ArrayList<>();
        }
        delivery.add(representation);
    }
    public void addPaymentTerms(PaymentTermsRepresentation representation){
        if(paymentTerms==null){
            paymentTerms=new ArrayList<>();
        }
        paymentTerms.add(representation);
    }
    public void addTaxTotal(TaxTotalRepresentation representation){
        if(taxTotal==null){
            taxTotal=new ArrayList<>();
        }
        taxTotal.add(representation);
    }
    public void addAllowanceCharge(AllowanceChargeRepresentation representation){
        if(allowanceCharge==null){
            allowanceCharge=new ArrayList<>();
        }
        allowanceCharge.add(representation);
    }
    /**/

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

    public QuantityRepresentation getInvoicedQuantity() {
        return this.invoicedQuantity;
    }

    public void setInvoicedQuantity(QuantityRepresentation invoicedQuantity) {
        this.invoicedQuantity = invoicedQuantity;
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

    public List<OrderLineReferenceRepresentation> getOrderLineReference() {
        return this.orderLineReference;
    }

    public void setOrderLineReference(List<OrderLineReferenceRepresentation> orderLineReference) {
        this.orderLineReference = orderLineReference;
    }

    public PartyRepresentation getOriginatorParty() {
        return this.originatorParty;
    }

    public void setOriginatorParty(PartyRepresentation originatorParty) {
        this.originatorParty = originatorParty;
    }

    public BigDecimal getLineExtensionAmount() {
        return this.lineExtensionAmount;
    }

    public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
    }

    public boolean getFreeOfChargeIndicator() {
        return this.freeOfChargeIndicator;
    }

    public void setFreeOfChargeIndicator(boolean freeOfChargeIndicator) {
        this.freeOfChargeIndicator = freeOfChargeIndicator;
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

    public DeliveryTermsRepresentation getDeliveryTerms() {
        return this.deliveryTerms;
    }

    public void setDeliveryTerms(DeliveryTermsRepresentation deliveryTerms) {
        this.deliveryTerms = deliveryTerms;
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

    public List<PaymentTermsRepresentation> getPaymentTerms() {
        return this.paymentTerms;
    }

    public void setPaymentTerms(List<PaymentTermsRepresentation> paymentTerms) {
        this.paymentTerms = paymentTerms;
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

    public List<AllowanceChargeRepresentation> getAllowanceCharge() {
        return this.allowanceCharge;
    }

    public void setAllowanceCharge(List<AllowanceChargeRepresentation> allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }
}
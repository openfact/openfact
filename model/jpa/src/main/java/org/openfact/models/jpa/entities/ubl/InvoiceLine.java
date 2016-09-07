package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to define a line in an Invoice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:37 a. m.
 */
public class InvoiceLine {

    /**
     * The buyer's accounting cost centre for this invoice line, expressed as
     * text.
     */
    private String accountingCost;
    /**
     * The buyer's accounting cost centre for this invoice line, expressed as a
     * code.
     */
    private String accountingCostCode;
    /**
     * An indicator that this invoice line is free of charge (true) or not
     * (false). The default is false.
     */
    private boolean freeOfChargeIndicator;
    /**
     * An identifier for this invoice line.
     */
    private String ID;
    /**
     * The quantity (of items) on this invoice line.
     */
    private BigDecimal invoicedQuantity;
    /**
     * The total amount for this invoice line, including allowance charges but
     * net of taxes.
     */
    private BigDecimal lineExtensionAmount;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String note;
    /**
     * A code signifying the business purpose for this payment.
     */
    private String paymentPurposeCode;
    /**
     * The date of this invoice line, used to indicate the point at which tax
     * becomes applicable.
     */
    private LocalDate taxPointDate;
    /**
     * A universally unique identifier for this invoice line.
     */
    private String UUID;
    private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
    private List<BillingReference> billingReferences = new ArrayList<>();
    private List<Delivery> deliveries = new ArrayList<>();
    private List<DeliveryTerms> deliveryTerms = new ArrayList<>();
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private LineReference despatchLineReference;
    private LineReference receiptLineReference;
    private List<OrderLineReference> orderLineReferences = new ArrayList<>();
    private Party originatorParty;
    private List<PaymentTerms> paymentTerms = new ArrayList<>();
    private Period invoicePeriod;
    private InvoiceLine subInvoiceLine;
    private List<Price> prices = new ArrayList<>();
    private PriceExtension ItemPriceExtension;
    private List<PricingReference> pricingReferences = new ArrayList<>();
    private TaxTotal withholdingTaxTotal;
    private List<TaxTotal> taxTotals = new ArrayList<>();

    /**
     * @return the accountingCost
     */
    public String getAccountingCost() {
        return accountingCost;
    }

    /**
     * @param accountingCost
     *            the accountingCost to set
     */
    public void setAccountingCost(String accountingCost) {
        this.accountingCost = accountingCost;
    }

    /**
     * @return the accountingCostCode
     */
    public String getAccountingCostCode() {
        return accountingCostCode;
    }

    /**
     * @param accountingCostCode
     *            the accountingCostCode to set
     */
    public void setAccountingCostCode(String accountingCostCode) {
        this.accountingCostCode = accountingCostCode;
    }

    /**
     * @return the freeOfChargeIndicator
     */
    public boolean isFreeOfChargeIndicator() {
        return freeOfChargeIndicator;
    }

    /**
     * @param freeOfChargeIndicator
     *            the freeOfChargeIndicator to set
     */
    public void setFreeOfChargeIndicator(boolean freeOfChargeIndicator) {
        this.freeOfChargeIndicator = freeOfChargeIndicator;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the invoicedQuantity
     */
    public BigDecimal getInvoicedQuantity() {
        return invoicedQuantity;
    }

    /**
     * @param invoicedQuantity
     *            the invoicedQuantity to set
     */
    public void setInvoicedQuantity(BigDecimal invoicedQuantity) {
        this.invoicedQuantity = invoicedQuantity;
    }

    /**
     * @return the lineExtensionAmount
     */
    public BigDecimal getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    /**
     * @param lineExtensionAmount
     *            the lineExtensionAmount to set
     */
    public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the paymentPurposeCode
     */
    public String getPaymentPurposeCode() {
        return paymentPurposeCode;
    }

    /**
     * @param paymentPurposeCode
     *            the paymentPurposeCode to set
     */
    public void setPaymentPurposeCode(String paymentPurposeCode) {
        this.paymentPurposeCode = paymentPurposeCode;
    }

    /**
     * @return the taxPointDate
     */
    public LocalDate getTaxPointDate() {
        return taxPointDate;
    }

    /**
     * @param taxPointDate
     *            the taxPointDate to set
     */
    public void setTaxPointDate(LocalDate taxPointDate) {
        this.taxPointDate = taxPointDate;
    }

    /**
     * @return the uUID
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * @param uUID
     *            the uUID to set
     */
    public void setUUID(String uUID) {
        UUID = uUID;
    }

    /**
     * @return the allowanceCharges
     */
    public List<AllowanceCharge> getAllowanceCharges() {
        return allowanceCharges;
    }

    /**
     * @param allowanceCharges
     *            the allowanceCharges to set
     */
    public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
        this.allowanceCharges = allowanceCharges;
    }

    /**
     * @return the billingReferences
     */
    public List<BillingReference> getBillingReferences() {
        return billingReferences;
    }

    /**
     * @param billingReferences
     *            the billingReferences to set
     */
    public void setBillingReferences(List<BillingReference> billingReferences) {
        this.billingReferences = billingReferences;
    }

    /**
     * @return the deliveries
     */
    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    /**
     * @param deliveries
     *            the deliveries to set
     */
    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    /**
     * @return the deliveryTerms
     */
    public List<DeliveryTerms> getDeliveryTerms() {
        return deliveryTerms;
    }

    /**
     * @param deliveryTerms
     *            the deliveryTerms to set
     */
    public void setDeliveryTerms(List<DeliveryTerms> deliveryTerms) {
        this.deliveryTerms = deliveryTerms;
    }

    /**
     * @return the documentReferences
     */
    public List<DocumentReference> getDocumentReferences() {
        return documentReferences;
    }

    /**
     * @param documentReferences
     *            the documentReferences to set
     */
    public void setDocumentReferences(List<DocumentReference> documentReferences) {
        this.documentReferences = documentReferences;
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items
     *            the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * @return the despatchLineReference
     */
    public LineReference getDespatchLineReference() {
        return despatchLineReference;
    }

    /**
     * @param despatchLineReference
     *            the despatchLineReference to set
     */
    public void setDespatchLineReference(LineReference despatchLineReference) {
        this.despatchLineReference = despatchLineReference;
    }

    /**
     * @return the receiptLineReference
     */
    public LineReference getReceiptLineReference() {
        return receiptLineReference;
    }

    /**
     * @param receiptLineReference
     *            the receiptLineReference to set
     */
    public void setReceiptLineReference(LineReference receiptLineReference) {
        this.receiptLineReference = receiptLineReference;
    }

    /**
     * @return the m_OrderLineReference
     */
    public OrderLineReference getM_OrderLineReference() {
        return m_OrderLineReference;
    }

    /**
     * @param m_OrderLineReference
     *            the m_OrderLineReference to set
     */
    public void setM_OrderLineReference(OrderLineReference m_OrderLineReference) {
        this.m_OrderLineReference = m_OrderLineReference;
    }

    /**
     * @return the originatorParty
     */
    public Party getOriginatorParty() {
        return originatorParty;
    }

    /**
     * @param originatorParty
     *            the originatorParty to set
     */
    public void setOriginatorParty(Party originatorParty) {
        this.originatorParty = originatorParty;
    }

    /**
     * @return the paymentTerms
     */
    public List<PaymentTerms> getPaymentTerms() {
        return paymentTerms;
    }

    /**
     * @param paymentTerms
     *            the paymentTerms to set
     */
    public void setPaymentTerms(List<PaymentTerms> paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    /**
     * @return the invoicePeriod
     */
    public Period getInvoicePeriod() {
        return invoicePeriod;
    }

    /**
     * @param invoicePeriod
     *            the invoicePeriod to set
     */
    public void setInvoicePeriod(Period invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    /**
     * @return the subInvoiceLine
     */
    public InvoiceLine getSubInvoiceLine() {
        return subInvoiceLine;
    }

    /**
     * @param subInvoiceLine
     *            the subInvoiceLine to set
     */
    public void setSubInvoiceLine(InvoiceLine subInvoiceLine) {
        this.subInvoiceLine = subInvoiceLine;
    }

    /**
     * @return the prices
     */
    public List<Price> getPrices() {
        return prices;
    }

    /**
     * @param prices
     *            the prices to set
     */
    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    /**
     * @return the itemPriceExtension
     */
    public PriceExtension getItemPriceExtension() {
        return ItemPriceExtension;
    }

    /**
     * @param itemPriceExtension
     *            the itemPriceExtension to set
     */
    public void setItemPriceExtension(PriceExtension itemPriceExtension) {
        ItemPriceExtension = itemPriceExtension;
    }

    /**
     * @return the pricingReferences
     */
    public List<PricingReference> getPricingReferences() {
        return pricingReferences;
    }

    /**
     * @param pricingReferences
     *            the pricingReferences to set
     */
    public void setPricingReferences(List<PricingReference> pricingReferences) {
        this.pricingReferences = pricingReferences;
    }

    /**
     * @return the withholdingTaxTotal
     */
    public TaxTotal getWithholdingTaxTotal() {
        return withholdingTaxTotal;
    }

    /**
     * @param withholdingTaxTotal
     *            the withholdingTaxTotal to set
     */
    public void setWithholdingTaxTotal(TaxTotal withholdingTaxTotal) {
        this.withholdingTaxTotal = withholdingTaxTotal;
    }

    /**
     * @return the taxTotals
     */
    public List<TaxTotal> getTaxTotals() {
        return taxTotals;
    }

    /**
     * @param taxTotals
     *            the taxTotals to set
     */
    public void setTaxTotals(List<TaxTotal> taxTotals) {
        this.taxTotals = taxTotals;
    }

}
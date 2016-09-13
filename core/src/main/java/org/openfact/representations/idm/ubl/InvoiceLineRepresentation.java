package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;

/**
 * A class to define a line in an Invoice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:37 a. m.
 */
public class InvoiceLineRepresentation {

    /**
     * The buyer's accounting cost centre for this invoice line, expressed as
     * text.
     */
    private String accountingCost;
    /**
     * The buyer's accounting cost centre for this invoice line, expressed as a
     * code.
     */
    private CodeRepresentation accountingCostCode;
    /**
     * An indicator that this invoice line is free of charge (true) or not
     * (false). The default is false.
     */
    private Boolean freeOfChargeIndicator;
    /**
     * An identifier for this invoice line.
     */
    private IdentifierRepresentation ID;
    /**
     * The quantity (of items) on this invoice line.
     */
    private QuantityRepresentation invoicedQuantity;
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
    private CodeRepresentation paymentPurposeCode;
    /**
     * The date of this invoice line, used to indicate the point at which tax
     * becomes applicable.
     */
    private LocalDate taxPointDate;
    /**
     * A universally unique identifier for this invoice line.
     */
    private IdentifierRepresentation UUID;
    private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>();
    private List<BillingReferenceRepresentation> billingReferences = new ArrayList<>();
    private List<DeliveryRepresentation> deliveries = new ArrayList<>();
    private List<DeliveryTermsRepresentation> deliveriesTerms = new ArrayList<>();
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private ItemRepresentation item;
    private LineReferenceRepresentation despatchLineReference;
    private LineReferenceRepresentation receiptLineReference;
    private List<OrderLineReferenceRepresentation> orderLineReferences = new ArrayList<>();
    private PartyRepresentation originatorParty;
    private List<PaymentTermsRepresentation> paymentTermses = new ArrayList<>();
    private PeriodRepresentation invoicePeriod;
    private InvoiceLineRepresentation subInvoiceLine;
    private PriceRepresentation price;
    private PriceExtensionRepresentation itemPriceExtension;
    private PricingReferenceRepresentation pricingReference;
    private List<TaxTotalRepresentation> withholdingTaxTotal = new ArrayList<>();
    private List<TaxTotalRepresentation> taxTotals = new ArrayList<>();

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
    public CodeRepresentation getAccountingCostCode() {
        return accountingCostCode;
    }

    /**
     * @param accountingCostCode
     *            the accountingCostCode to set
     */
    public void setAccountingCostCode(CodeRepresentation accountingCostCode) {
        this.accountingCostCode = accountingCostCode;
    }

    /**
     * @return the freeOfChargeIndicator
     */
    public Boolean getFreeOfChargeIndicator() {
        return freeOfChargeIndicator;
    }

    /**
     * @param freeOfChargeIndicator
     *            the freeOfChargeIndicator to set
     */
    public void setFreeOfChargeIndicator(Boolean freeOfChargeIndicator) {
        this.freeOfChargeIndicator = freeOfChargeIndicator;
    }

    /**
     * @return the iD
     */
    public IdentifierRepresentation getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(IdentifierRepresentation iD) {
        ID = iD;
    }

    /**
     * @return the invoicedQuantity
     */
    public QuantityRepresentation getInvoicedQuantity() {
        return invoicedQuantity;
    }

    /**
     * @param invoicedQuantity
     *            the invoicedQuantity to set
     */
    public void setInvoicedQuantity(QuantityRepresentation invoicedQuantity) {
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
    public CodeRepresentation getPaymentPurposeCode() {
        return paymentPurposeCode;
    }

    /**
     * @param paymentPurposeCode
     *            the paymentPurposeCode to set
     */
    public void setPaymentPurposeCode(CodeRepresentation paymentPurposeCode) {
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
    public IdentifierRepresentation getUUID() {
        return UUID;
    }

    /**
     * @param uUID
     *            the uUID to set
     */
    public void setUUID(IdentifierRepresentation uUID) {
        UUID = uUID;
    }

    /**
     * @return the allowanceCharges
     */
    public List<AllowanceChargeRepresentation> getAllowanceCharges() {
        return allowanceCharges;
    }

    /**
     * @param allowanceCharges
     *            the allowanceCharges to set
     */
    public void setAllowanceCharges(List<AllowanceChargeRepresentation> allowanceCharges) {
        this.allowanceCharges = allowanceCharges;
    }

    /**
     * @return the billingReferences
     */
    public List<BillingReferenceRepresentation> getBillingReferences() {
        return billingReferences;
    }

    /**
     * @param billingReferences
     *            the billingReferences to set
     */
    public void setBillingReferences(List<BillingReferenceRepresentation> billingReferences) {
        this.billingReferences = billingReferences;
    }

    /**
     * @return the deliveries
     */
    public List<DeliveryRepresentation> getDeliveries() {
        return deliveries;
    }

    /**
     * @param deliveries
     *            the deliveries to set
     */
    public void setDeliveries(List<DeliveryRepresentation> deliveries) {
        this.deliveries = deliveries;
    }

    /**
     * @return the deliveriesTerms
     */
    public List<DeliveryTermsRepresentation> getDeliveriesTerms() {
        return deliveriesTerms;
    }

    /**
     * @param deliveriesTerms
     *            the deliveriesTerms to set
     */
    public void setDeliveriesTerms(List<DeliveryTermsRepresentation> deliveriesTerms) {
        this.deliveriesTerms = deliveriesTerms;
    }

    /**
     * @return the documentReferences
     */
    public List<DocumentReferenceRepresentation> getDocumentReferences() {
        return documentReferences;
    }

    /**
     * @param documentReferences
     *            the documentReferences to set
     */
    public void setDocumentReferences(List<DocumentReferenceRepresentation> documentReferences) {
        this.documentReferences = documentReferences;
    }

    /**
     * @return the item
     */
    public ItemRepresentation getItem() {
        return item;
    }

    /**
     * @param item
     *            the item to set
     */
    public void setItem(ItemRepresentation item) {
        this.item = item;
    }

    /**
     * @return the despatchLineReference
     */
    public LineReferenceRepresentation getDespatchLineReference() {
        return despatchLineReference;
    }

    /**
     * @param despatchLineReference
     *            the despatchLineReference to set
     */
    public void setDespatchLineReference(LineReferenceRepresentation despatchLineReference) {
        this.despatchLineReference = despatchLineReference;
    }

    /**
     * @return the receiptLineReference
     */
    public LineReferenceRepresentation getReceiptLineReference() {
        return receiptLineReference;
    }

    /**
     * @param receiptLineReference
     *            the receiptLineReference to set
     */
    public void setReceiptLineReference(LineReferenceRepresentation receiptLineReference) {
        this.receiptLineReference = receiptLineReference;
    }

    /**
     * @return the orderLineReferences
     */
    public List<OrderLineReferenceRepresentation> getOrderLineReferences() {
        return orderLineReferences;
    }

    /**
     * @param orderLineReferences
     *            the orderLineReferences to set
     */
    public void setOrderLineReferences(List<OrderLineReferenceRepresentation> orderLineReferences) {
        this.orderLineReferences = orderLineReferences;
    }

    /**
     * @return the originatorParty
     */
    public PartyRepresentation getOriginatorParty() {
        return originatorParty;
    }

    /**
     * @param originatorParty
     *            the originatorParty to set
     */
    public void setOriginatorParty(PartyRepresentation originatorParty) {
        this.originatorParty = originatorParty;
    }

    /**
     * @return the paymentTermses
     */
    public List<PaymentTermsRepresentation> getPaymentTermses() {
        return paymentTermses;
    }

    /**
     * @param paymentTermses
     *            the paymentTermses to set
     */
    public void setPaymentTermses(List<PaymentTermsRepresentation> paymentTermses) {
        this.paymentTermses = paymentTermses;
    }

    /**
     * @return the invoicePeriod
     */
    public PeriodRepresentation getInvoicePeriod() {
        return invoicePeriod;
    }

    /**
     * @param invoicePeriod
     *            the invoicePeriod to set
     */
    public void setInvoicePeriod(PeriodRepresentation invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    /**
     * @return the subInvoiceLine
     */
    public InvoiceLineRepresentation getSubInvoiceLine() {
        return subInvoiceLine;
    }

    /**
     * @param subInvoiceLine
     *            the subInvoiceLine to set
     */
    public void setSubInvoiceLine(InvoiceLineRepresentation subInvoiceLine) {
        this.subInvoiceLine = subInvoiceLine;
    }

    /**
     * @return the price
     */
    public PriceRepresentation getPrice() {
        return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(PriceRepresentation price) {
        this.price = price;
    }

    /**
     * @return the itemPriceExtension
     */
    public PriceExtensionRepresentation getItemPriceExtension() {
        return itemPriceExtension;
    }

    /**
     * @param itemPriceExtension
     *            the itemPriceExtension to set
     */
    public void setItemPriceExtension(PriceExtensionRepresentation itemPriceExtension) {
        this.itemPriceExtension = itemPriceExtension;
    }

    /**
     * @return the pricingReference
     */
    public PricingReferenceRepresentation getPricingReference() {
        return pricingReference;
    }

    /**
     * @param pricingReference
     *            the pricingReference to set
     */
    public void setPricingReference(PricingReferenceRepresentation pricingReference) {
        this.pricingReference = pricingReference;
    }

    /**
     * @return the withholdingTaxTotal
     */
    public List<TaxTotalRepresentation> getWithholdingTaxTotal() {
        return withholdingTaxTotal;
    }

    /**
     * @param withholdingTaxTotal
     *            the withholdingTaxTotal to set
     */
    public void setWithholdingTaxTotal(List<TaxTotalRepresentation> withholdingTaxTotal) {
        this.withholdingTaxTotal = withholdingTaxTotal;
    }

    /**
     * @return the taxTotals
     */
    public List<TaxTotalRepresentation> getTaxTotals() {
        return taxTotals;
    }

    /**
     * @param taxTotals
     *            the taxTotals to set
     */
    public void setTaxTotals(List<TaxTotalRepresentation> taxTotals) {
        this.taxTotals = taxTotals;
    }

}

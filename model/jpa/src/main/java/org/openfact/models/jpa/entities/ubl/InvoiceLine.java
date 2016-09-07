package org.openfact.models.jpa.entities.ubl;

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
    private AllowanceCharge m_AllowanceCharge;
    private BillingReference m_BillingReference;
    private Delivery m_Delivery;
    private DeliveryTerms m_DeliveryTerms;
    private DocumentReference m_DocumentReference;
    private Item m_Item;
    private LineReference despatchLineReference;
    private LineReference receiptLineReference;
    private OrderLineReference m_OrderLineReference;
    private Party originatorParty;
    private PaymentTerms m_PaymentTerms;
    private Period invoicePeriod;
    private Invoice lineSubInvoiceLine;
    private Price m_Price;
    private Price extensionItemPriceExtension;
    private PricingReference m_PricingReference;
    private TaxTotal withholdingTaxTotal;
    private TaxTotal m_TaxTotal;

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
     * @return the m_AllowanceCharge
     */
    public AllowanceCharge getM_AllowanceCharge() {
        return m_AllowanceCharge;
    }

    /**
     * @param m_AllowanceCharge
     *            the m_AllowanceCharge to set
     */
    public void setM_AllowanceCharge(AllowanceCharge m_AllowanceCharge) {
        this.m_AllowanceCharge = m_AllowanceCharge;
    }

    /**
     * @return the m_BillingReference
     */
    public BillingReference getM_BillingReference() {
        return m_BillingReference;
    }

    /**
     * @param m_BillingReference
     *            the m_BillingReference to set
     */
    public void setM_BillingReference(BillingReference m_BillingReference) {
        this.m_BillingReference = m_BillingReference;
    }

    /**
     * @return the m_Delivery
     */
    public Delivery getM_Delivery() {
        return m_Delivery;
    }

    /**
     * @param m_Delivery
     *            the m_Delivery to set
     */
    public void setM_Delivery(Delivery m_Delivery) {
        this.m_Delivery = m_Delivery;
    }

    /**
     * @return the m_DeliveryTerms
     */
    public DeliveryTerms getM_DeliveryTerms() {
        return m_DeliveryTerms;
    }

    /**
     * @param m_DeliveryTerms
     *            the m_DeliveryTerms to set
     */
    public void setM_DeliveryTerms(DeliveryTerms m_DeliveryTerms) {
        this.m_DeliveryTerms = m_DeliveryTerms;
    }

    /**
     * @return the m_DocumentReference
     */
    public DocumentReference getM_DocumentReference() {
        return m_DocumentReference;
    }

    /**
     * @param m_DocumentReference
     *            the m_DocumentReference to set
     */
    public void setM_DocumentReference(DocumentReference m_DocumentReference) {
        this.m_DocumentReference = m_DocumentReference;
    }

    /**
     * @return the m_Item
     */
    public Item getM_Item() {
        return m_Item;
    }

    /**
     * @param m_Item
     *            the m_Item to set
     */
    public void setM_Item(Item m_Item) {
        this.m_Item = m_Item;
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
     * @return the m_PaymentTerms
     */
    public PaymentTerms getM_PaymentTerms() {
        return m_PaymentTerms;
    }

    /**
     * @param m_PaymentTerms
     *            the m_PaymentTerms to set
     */
    public void setM_PaymentTerms(PaymentTerms m_PaymentTerms) {
        this.m_PaymentTerms = m_PaymentTerms;
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
     * @return the lineSubInvoiceLine
     */
    public Invoice getLineSubInvoiceLine() {
        return lineSubInvoiceLine;
    }

    /**
     * @param lineSubInvoiceLine
     *            the lineSubInvoiceLine to set
     */
    public void setLineSubInvoiceLine(Invoice lineSubInvoiceLine) {
        this.lineSubInvoiceLine = lineSubInvoiceLine;
    }

    /**
     * @return the m_Price
     */
    public Price getM_Price() {
        return m_Price;
    }

    /**
     * @param m_Price
     *            the m_Price to set
     */
    public void setM_Price(Price m_Price) {
        this.m_Price = m_Price;
    }

    /**
     * @return the extensionItemPriceExtension
     */
    public Price getExtensionItemPriceExtension() {
        return extensionItemPriceExtension;
    }

    /**
     * @param extensionItemPriceExtension
     *            the extensionItemPriceExtension to set
     */
    public void setExtensionItemPriceExtension(Price extensionItemPriceExtension) {
        this.extensionItemPriceExtension = extensionItemPriceExtension;
    }

    /**
     * @return the m_PricingReference
     */
    public PricingReference getM_PricingReference() {
        return m_PricingReference;
    }

    /**
     * @param m_PricingReference
     *            the m_PricingReference to set
     */
    public void setM_PricingReference(PricingReference m_PricingReference) {
        this.m_PricingReference = m_PricingReference;
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
     * @return the m_TaxTotal
     */
    public TaxTotal getM_TaxTotal() {
        return m_TaxTotal;
    }

    /**
     * @param m_TaxTotal
     *            the m_TaxTotal to set
     */
    public void setM_TaxTotal(TaxTotal m_TaxTotal) {
        this.m_TaxTotal = m_TaxTotal;
    }

}
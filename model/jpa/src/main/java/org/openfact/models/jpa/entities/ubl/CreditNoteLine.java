package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to define a line in a Credit Note or Self Billed Credit Note.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:14 a. m.
 */
public class CreditNoteLine {

    /**
     * The buyer's accounting cost centre for this credit note line, expressed
     * as text.
     */
    private String AccountingCost;
    /**
     * The buyer's accounting cost centre for this credit note line, expressed
     * as a code.
     */
    private String AccountingCostCode;
    /**
     * The quantity of items credited in this credit note line.
     */
    private BigDecimal CreditedQuantity;
    /**
     * An indicator that this credit note line is free of charge (true) or not
     * (false). The default is false.
     */
    private boolean FreeOfChargeIndicator;
    /**
     * An identifier for this credit note line.
     */
    private String ID;
    /**
     * The total amount for this credit note line, including allowance charges
     * but exclusive of taxes.
     */
    private BigDecimal LineExtensionAmount;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String Note;
    /**
     * A code signifying the business purpose for this payment.
     */
    private String PaymentPurposeCode;
    /**
     * The date of this credit note line, used to indicate the point at which
     * tax becomes applicable.
     */
    private LocalDate TaxPointDate;
    /**
     * A universally unique identifier for this credit note line.
     */
    private String UUID;
    private AllowanceCharge m_AllowanceCharge;
    private BillingReference m_BillingReference;
    private CreditNoteLine SubCreditNoteLine;
    private Delivery m_Delivery;
    private DeliveryTerms m_DeliveryTerms;
    private DocumentReference m_DocumentReference;
    private Item m_Item;
    private LineReference ReceiptLineReference;
    private LineReference DespatchLineReference;
    private OrderLineReference m_OrderLineReference;
    private Party OriginatorParty;
    private PaymentTerms m_PaymentTerms;
    private Period InvoicePeriod;
    private Price m_Price;
    private PriceExtension ItemPriceExtension;
    private PricingReference m_PricingReference;
    private Response DiscrepancyResponse;
    private TaxTotal m_TaxTotal;

    public CreditNoteLine() {

    }

    public void finalize() throws Throwable {

    }

    /**
     * @return the accountingCost
     */
    public String getAccountingCost() {
        return AccountingCost;
    }

    /**
     * @param accountingCost
     *            the accountingCost to set
     */
    public void setAccountingCost(String accountingCost) {
        AccountingCost = accountingCost;
    }

    /**
     * @return the accountingCostCode
     */
    public String getAccountingCostCode() {
        return AccountingCostCode;
    }

    /**
     * @param accountingCostCode
     *            the accountingCostCode to set
     */
    public void setAccountingCostCode(String accountingCostCode) {
        AccountingCostCode = accountingCostCode;
    }

    /**
     * @return the creditedQuantity
     */
    public BigDecimal getCreditedQuantity() {
        return CreditedQuantity;
    }

    /**
     * @param creditedQuantity
     *            the creditedQuantity to set
     */
    public void setCreditedQuantity(BigDecimal creditedQuantity) {
        CreditedQuantity = creditedQuantity;
    }

    /**
     * @return the freeOfChargeIndicator
     */
    public boolean isFreeOfChargeIndicator() {
        return FreeOfChargeIndicator;
    }

    /**
     * @param freeOfChargeIndicator
     *            the freeOfChargeIndicator to set
     */
    public void setFreeOfChargeIndicator(boolean freeOfChargeIndicator) {
        FreeOfChargeIndicator = freeOfChargeIndicator;
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
     * @return the lineExtensionAmount
     */
    public BigDecimal getLineExtensionAmount() {
        return LineExtensionAmount;
    }

    /**
     * @param lineExtensionAmount
     *            the lineExtensionAmount to set
     */
    public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
        LineExtensionAmount = lineExtensionAmount;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        Note = note;
    }

    /**
     * @return the paymentPurposeCode
     */
    public String getPaymentPurposeCode() {
        return PaymentPurposeCode;
    }

    /**
     * @param paymentPurposeCode
     *            the paymentPurposeCode to set
     */
    public void setPaymentPurposeCode(String paymentPurposeCode) {
        PaymentPurposeCode = paymentPurposeCode;
    }

    /**
     * @return the taxPointDate
     */
    public LocalDate getTaxPointDate() {
        return TaxPointDate;
    }

    /**
     * @param taxPointDate
     *            the taxPointDate to set
     */
    public void setTaxPointDate(LocalDate taxPointDate) {
        TaxPointDate = taxPointDate;
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
     * @return the subCreditNoteLine
     */
    public CreditNoteLine getSubCreditNoteLine() {
        return SubCreditNoteLine;
    }

    /**
     * @param subCreditNoteLine
     *            the subCreditNoteLine to set
     */
    public void setSubCreditNoteLine(CreditNoteLine subCreditNoteLine) {
        SubCreditNoteLine = subCreditNoteLine;
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
     * @return the receiptLineReference
     */
    public LineReference getReceiptLineReference() {
        return ReceiptLineReference;
    }

    /**
     * @param receiptLineReference
     *            the receiptLineReference to set
     */
    public void setReceiptLineReference(LineReference receiptLineReference) {
        ReceiptLineReference = receiptLineReference;
    }

    /**
     * @return the despatchLineReference
     */
    public LineReference getDespatchLineReference() {
        return DespatchLineReference;
    }

    /**
     * @param despatchLineReference
     *            the despatchLineReference to set
     */
    public void setDespatchLineReference(LineReference despatchLineReference) {
        DespatchLineReference = despatchLineReference;
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
        return OriginatorParty;
    }

    /**
     * @param originatorParty
     *            the originatorParty to set
     */
    public void setOriginatorParty(Party originatorParty) {
        OriginatorParty = originatorParty;
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
        return InvoicePeriod;
    }

    /**
     * @param invoicePeriod
     *            the invoicePeriod to set
     */
    public void setInvoicePeriod(Period invoicePeriod) {
        InvoicePeriod = invoicePeriod;
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
     * @return the discrepancyResponse
     */
    public Response getDiscrepancyResponse() {
        return DiscrepancyResponse;
    }

    /**
     * @param discrepancyResponse
     *            the discrepancyResponse to set
     */
    public void setDiscrepancyResponse(Response discrepancyResponse) {
        DiscrepancyResponse = discrepancyResponse;
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

}// end Credit Note Line
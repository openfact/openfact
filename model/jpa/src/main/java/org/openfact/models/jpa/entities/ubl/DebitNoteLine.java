package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to define a line in a Debit Note.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:19 a. m.
 */
public class DebitNoteLine {

    /**
     * The buyer's accounting cost centre for this debit note line, expressed as
     * text.
     */
    private String AccountingCost;
    /**
     * The buyer's accounting cost centre for this debit note line, expressed as
     * a code.
     */
    private String AccountingCostCode;
    /**
     * The quantity of Items debited in this debit note line.
     */
    private BigDecimal DebitedQuantity;
    /**
     * An identifier for this debit note line.
     */
    private String ID;
    /**
     * The total amount for this debit note line, including allowance charges
     * but net of taxes.
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
     * The date of this debit note line, used to indicate the point at which tax
     * becomes applicable.
     */
    private LocalDate TaxPointDate;
    /**
     * A universally unique identifier for this debit note line.
     */
    private String UUID;
    private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
    private List<BillingReference> billingReferences = new ArrayList<>();
    private DebitNoteLine subDebitNoteLine;
    private List<Delivery> deliveries = new ArrayList<>();
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

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
     * @return the debitedQuantity
     */
    public BigDecimal getDebitedQuantity() {
        return DebitedQuantity;
    }

    /**
     * @param debitedQuantity
     *            the debitedQuantity to set
     */
    public void setDebitedQuantity(BigDecimal debitedQuantity) {
        DebitedQuantity = debitedQuantity;
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
     * @return the subDebitNoteLine
     */
    public DebitNoteLine getSubDebitNoteLine() {
        return subDebitNoteLine;
    }

    /**
     * @param subDebitNoteLine
     *            the subDebitNoteLine to set
     */
    public void setSubDebitNoteLine(DebitNoteLine subDebitNoteLine) {
        this.subDebitNoteLine = subDebitNoteLine;
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

}
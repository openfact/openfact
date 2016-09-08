package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a line in a Reminder document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:24 a. m.
 */
public class ReminderLine {

    /**
     * The buyer's accounting cost centre for this reminder line, expressed as
     * text.
     */
    private String AccountingCost;
    /**
     * The buyer's accounting cost centre for this reminder line, expressed as a
     * code.
     */
    private String AccountingCostCode;
    /**
     * The amount on this reminder line.
     */
    private BigDecimal Amount;
    /**
     * An indication that this reminder line contains a balance brought forward
     * (true) or does not (false).
     */
    private boolean BalanceBroughtForwardIndicator;
    /**
     * The amount credited on this reminder line.
     */
    private BigDecimal CreditLineAmount;
    /**
     * The amount debited on this reminder line.
     */
    private BigDecimal DebitLineAmount;
    /**
     * An identifier for this reminder line.
     */
    private String ID;
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
     * The penalty for late payment, expressed as a percentage.
     */
    private BigDecimal PenaltySurchargePercent;
    /**
     * A universally unique identifier for this reminder line.
     */
    private String UUID;
    private List<BillingReference> billingReferences = new ArrayList<>();
    private List<ExchangeRate> exchangeRates = new ArrayList<>();
    private Period ReminderPeriod;

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
     * @return the amount
     */
    public BigDecimal getAmount() {
        return Amount;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    /**
     * @return the balanceBroughtForwardIndicator
     */
    public boolean isBalanceBroughtForwardIndicator() {
        return BalanceBroughtForwardIndicator;
    }

    /**
     * @param balanceBroughtForwardIndicator
     *            the balanceBroughtForwardIndicator to set
     */
    public void setBalanceBroughtForwardIndicator(boolean balanceBroughtForwardIndicator) {
        BalanceBroughtForwardIndicator = balanceBroughtForwardIndicator;
    }

    /**
     * @return the creditLineAmount
     */
    public BigDecimal getCreditLineAmount() {
        return CreditLineAmount;
    }

    /**
     * @param creditLineAmount
     *            the creditLineAmount to set
     */
    public void setCreditLineAmount(BigDecimal creditLineAmount) {
        CreditLineAmount = creditLineAmount;
    }

    /**
     * @return the debitLineAmount
     */
    public BigDecimal getDebitLineAmount() {
        return DebitLineAmount;
    }

    /**
     * @param debitLineAmount
     *            the debitLineAmount to set
     */
    public void setDebitLineAmount(BigDecimal debitLineAmount) {
        DebitLineAmount = debitLineAmount;
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
     * @return the penaltySurchargePercent
     */
    public BigDecimal getPenaltySurchargePercent() {
        return PenaltySurchargePercent;
    }

    /**
     * @param penaltySurchargePercent
     *            the penaltySurchargePercent to set
     */
    public void setPenaltySurchargePercent(BigDecimal penaltySurchargePercent) {
        PenaltySurchargePercent = penaltySurchargePercent;
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
     * @return the exchangeRates
     */
    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    /**
     * @param exchangeRates
     *            the exchangeRates to set
     */
    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    /**
     * @return the reminderPeriod
     */
    public Period getReminderPeriod() {
        return ReminderPeriod;
    }

    /**
     * @param reminderPeriod
     *            the reminderPeriod to set
     */
    public void setReminderPeriod(Period reminderPeriod) {
        ReminderPeriod = reminderPeriod;
    }

}// end ReminderLine
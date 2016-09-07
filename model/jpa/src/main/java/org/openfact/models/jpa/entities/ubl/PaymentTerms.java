package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to describe a set of payment terms.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:41 a. m.
 */
public class PaymentTerms {

    /**
     * The monetary amount covered by these payment terms.
     */
    private BigDecimal amount;
    /**
     * An identifier for this set of payment terms.
     */
    private String ID;
    /**
     * The due date for an installment payment for these payment terms.
     */
    private LocalDate installmentDueDate;
    /**
     * A reference to the payment terms used by the invoicing party. This may
     * have been requested of the payer by the payee to accompany its
     * remittance.
     */
    private String invoicingPartyReference;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String note;
    /**
     * The due date for these payment terms.
     */
    private LocalDate paymentDueDate;
    /**
     * An identifier for a means of payment associated with these payment terms.
     */
    private String paymentMeansID;
    /**
     * The part of a payment, expressed as a percent, relevant for these payment
     * terms.
     */
    private BigDecimal paymentPercent;
    /**
     * The Uniform Resource Identifier (URI) of a document providing additional
     * details regarding these payment terms.
     */
    private String paymentTermsDetailsURIID;
    /**
     * The monetary amount of the penalty for payment after the settlement
     * period.
     */
    private BigDecimal penaltyAmount;
    /**
     * The penalty for payment after the settlement period, expressed as a
     * percentage of the payment.
     */
    private BigDecimal penaltySurchargePercent;
    /**
     * An identifier for a reference to a prepaid payment.
     */
    private String prepaidPaymentReferenceID;
    /**
     * A code signifying the event during which these terms are offered.
     */
    private String seferenceEventCode;
    /**
     * The amount of a settlement discount offered for payment under these
     * payment terms.
     */
    private BigDecimal settlementDiscountAmount;
    /**
     * The percentage for the settlement discount that is offered for payment
     * under these payment terms.
     */
    private BigDecimal settlementDiscountPercent;
    private ExchangeRate m_ExchangeRate;
    private Period settlementPeriod;
    private Period penaltyPeriod;
    private Period validityPeriod;

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
     * @return the installmentDueDate
     */
    public LocalDate getInstallmentDueDate() {
        return installmentDueDate;
    }

    /**
     * @param installmentDueDate
     *            the installmentDueDate to set
     */
    public void setInstallmentDueDate(LocalDate installmentDueDate) {
        this.installmentDueDate = installmentDueDate;
    }

    /**
     * @return the invoicingPartyReference
     */
    public String getInvoicingPartyReference() {
        return invoicingPartyReference;
    }

    /**
     * @param invoicingPartyReference
     *            the invoicingPartyReference to set
     */
    public void setInvoicingPartyReference(String invoicingPartyReference) {
        this.invoicingPartyReference = invoicingPartyReference;
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
     * @return the paymentDueDate
     */
    public LocalDate getPaymentDueDate() {
        return paymentDueDate;
    }

    /**
     * @param paymentDueDate
     *            the paymentDueDate to set
     */
    public void setPaymentDueDate(LocalDate paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    /**
     * @return the paymentMeansID
     */
    public String getPaymentMeansID() {
        return paymentMeansID;
    }

    /**
     * @param paymentMeansID
     *            the paymentMeansID to set
     */
    public void setPaymentMeansID(String paymentMeansID) {
        this.paymentMeansID = paymentMeansID;
    }

    /**
     * @return the paymentPercent
     */
    public BigDecimal getPaymentPercent() {
        return paymentPercent;
    }

    /**
     * @param paymentPercent
     *            the paymentPercent to set
     */
    public void setPaymentPercent(BigDecimal paymentPercent) {
        this.paymentPercent = paymentPercent;
    }

    /**
     * @return the paymentTermsDetailsURIID
     */
    public String getPaymentTermsDetailsURIID() {
        return paymentTermsDetailsURIID;
    }

    /**
     * @param paymentTermsDetailsURIID
     *            the paymentTermsDetailsURIID to set
     */
    public void setPaymentTermsDetailsURIID(String paymentTermsDetailsURIID) {
        this.paymentTermsDetailsURIID = paymentTermsDetailsURIID;
    }

    /**
     * @return the penaltyAmount
     */
    public BigDecimal getPenaltyAmount() {
        return penaltyAmount;
    }

    /**
     * @param penaltyAmount
     *            the penaltyAmount to set
     */
    public void setPenaltyAmount(BigDecimal penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    /**
     * @return the penaltySurchargePercent
     */
    public BigDecimal getPenaltySurchargePercent() {
        return penaltySurchargePercent;
    }

    /**
     * @param penaltySurchargePercent
     *            the penaltySurchargePercent to set
     */
    public void setPenaltySurchargePercent(BigDecimal penaltySurchargePercent) {
        this.penaltySurchargePercent = penaltySurchargePercent;
    }

    /**
     * @return the prepaidPaymentReferenceID
     */
    public String getPrepaidPaymentReferenceID() {
        return prepaidPaymentReferenceID;
    }

    /**
     * @param prepaidPaymentReferenceID
     *            the prepaidPaymentReferenceID to set
     */
    public void setPrepaidPaymentReferenceID(String prepaidPaymentReferenceID) {
        this.prepaidPaymentReferenceID = prepaidPaymentReferenceID;
    }

    /**
     * @return the seferenceEventCode
     */
    public String getSeferenceEventCode() {
        return seferenceEventCode;
    }

    /**
     * @param seferenceEventCode
     *            the seferenceEventCode to set
     */
    public void setSeferenceEventCode(String seferenceEventCode) {
        this.seferenceEventCode = seferenceEventCode;
    }

    /**
     * @return the settlementDiscountAmount
     */
    public BigDecimal getSettlementDiscountAmount() {
        return settlementDiscountAmount;
    }

    /**
     * @param settlementDiscountAmount
     *            the settlementDiscountAmount to set
     */
    public void setSettlementDiscountAmount(BigDecimal settlementDiscountAmount) {
        this.settlementDiscountAmount = settlementDiscountAmount;
    }

    /**
     * @return the settlementDiscountPercent
     */
    public BigDecimal getSettlementDiscountPercent() {
        return settlementDiscountPercent;
    }

    /**
     * @param settlementDiscountPercent
     *            the settlementDiscountPercent to set
     */
    public void setSettlementDiscountPercent(BigDecimal settlementDiscountPercent) {
        this.settlementDiscountPercent = settlementDiscountPercent;
    }

    /**
     * @return the m_ExchangeRate
     */
    public ExchangeRate getM_ExchangeRate() {
        return m_ExchangeRate;
    }

    /**
     * @param m_ExchangeRate
     *            the m_ExchangeRate to set
     */
    public void setM_ExchangeRate(ExchangeRate m_ExchangeRate) {
        this.m_ExchangeRate = m_ExchangeRate;
    }

    /**
     * @return the settlementPeriod
     */
    public Period getSettlementPeriod() {
        return settlementPeriod;
    }

    /**
     * @param settlementPeriod
     *            the settlementPeriod to set
     */
    public void setSettlementPeriod(Period settlementPeriod) {
        this.settlementPeriod = settlementPeriod;
    }

    /**
     * @return the penaltyPeriod
     */
    public Period getPenaltyPeriod() {
        return penaltyPeriod;
    }

    /**
     * @param penaltyPeriod
     *            the penaltyPeriod to set
     */
    public void setPenaltyPeriod(Period penaltyPeriod) {
        this.penaltyPeriod = penaltyPeriod;
    }

    /**
     * @return the validityPeriod
     */
    public Period getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * @param validityPeriod
     *            the validityPeriod to set
     */
    public void setValidityPeriod(Period validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

}
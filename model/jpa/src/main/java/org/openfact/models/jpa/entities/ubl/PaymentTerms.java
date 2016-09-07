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
    private BigDecimal Amount;
    /**
     * An identifier for this set of payment terms.
     */
    private String ID;
    /**
     * The due date for an installment payment for these payment terms.
     */
    private LocalDate InstallmentDueDate;
    /**
     * A reference to the payment terms used by the invoicing party. This may
     * have been requested of the payer by the payee to accompany its
     * remittance.
     */
    private String InvoicingPartyReference;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String Note;
    /**
     * The due date for these payment terms.
     */
    private LocalDate PaymentDueDate;
    /**
     * An identifier for a means of payment associated with these payment terms.
     */
    private String PaymentMeansID;
    /**
     * The part of a payment, expressed as a percent, relevant for these payment
     * terms.
     */
    private BigDecimal PaymentPercent;
    /**
     * The Uniform Resource Identifier (URI) of a document providing additional
     * details regarding these payment terms.
     */
    private String PaymentTermsDetailsURIID;
    /**
     * The monetary amount of the penalty for payment after the settlement
     * period.
     */
    private BigDecimal PenaltyAmount;
    /**
     * The penalty for payment after the settlement period, expressed as a
     * percentage of the payment.
     */
    private BigDecimal PenaltySurchargePercent;
    /**
     * An identifier for a reference to a prepaid payment.
     */
    private String PrepaidPaymentReferenceID;
    /**
     * A code signifying the event during which these terms are offered.
     */
    private String ReferenceEventCode;
    /**
     * The amount of a settlement discount offered for payment under these
     * payment terms.
     */
    private BigDecimal SettlementDiscountAmount;
    /**
     * The percentage for the settlement discount that is offered for payment
     * under these payment terms.
     */
    private BigDecimal SettlementDiscountPercent;
    private ExchangeRate m_ExchangeRate;
    private Period SettlementPeriod;
    private Period PenaltyPeriod;
    private Period ValidityPeriod;

    public PaymentTerms() {

    }

    public void finalize() throws Throwable {

    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public ExchangeRate getExchangeRate() {
        return m_ExchangeRate;
    }

    public String getID() {
        return ID;
    }

    public LocalDate getInstallmentDueDate() {
        return InstallmentDueDate;
    }

    public String getInvoicingPartyReference() {
        return InvoicingPartyReference;
    }

    public String getNote() {
        return Note;
    }

    public LocalDate getPaymentDueDate() {
        return PaymentDueDate;
    }

    public String getPaymentMeansID() {
        return PaymentMeansID;
    }

    public BigDecimal getPaymentPercent() {
        return PaymentPercent;
    }

    public String getPaymentTermsDetailsURIID() {
        return PaymentTermsDetailsURIID;
    }

    public Period getPenaltyPeriod() {
        return PenaltyPeriod;
    }

    public BigDecimal getPenaltyAmount() {
        return PenaltyAmount;
    }

    public BigDecimal getPenaltySurchargePercent() {
        return PenaltySurchargePercent;
    }

    public String getPrepaidPaymentReferenceID() {
        return PrepaidPaymentReferenceID;
    }

    public String getReferenceEventCode() {
        return ReferenceEventCode;
    }

    public Period getSettlementPeriod() {
        return SettlementPeriod;
    }

    public BigDecimal getSettlementDiscountAmount() {
        return SettlementDiscountAmount;
    }

    public BigDecimal getSettlementDiscountPercent() {
        return SettlementDiscountPercent;
    }

    public Period getValidityPeriod() {
        return ValidityPeriod;
    }

    /**
     * 
     * @param newVal
     */
    public void setAmount(BigDecimal newVal) {
        Amount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setExchangeRate(ExchangeRate newVal) {
        m_ExchangeRate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setID(String newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setInstallmentDueDate(LocalDate newVal) {
        InstallmentDueDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setInvoicingPartyReference(String newVal) {
        InvoicingPartyReference = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNote(String newVal) {
        Note = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPaymentDueDate(LocalDate newVal) {
        PaymentDueDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPaymentMeansID(String newVal) {
        PaymentMeansID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPaymentPercent(BigDecimal newVal) {
        PaymentPercent = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPaymentTermsDetailsURIID(String newVal) {
        PaymentTermsDetailsURIID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPenaltyPeriod(Period newVal) {
        PenaltyPeriod = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPenaltyAmount(BigDecimal newVal) {
        PenaltyAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPenaltySurchargePercent(BigDecimal newVal) {
        PenaltySurchargePercent = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPrepaidPaymentReferenceID(String newVal) {
        PrepaidPaymentReferenceID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setReferenceEventCode(String newVal) {
        ReferenceEventCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSettlementPeriod(Period newVal) {
        SettlementPeriod = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSettlementDiscountAmount(BigDecimal newVal) {
        SettlementDiscountAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSettlementDiscountPercent(BigDecimal newVal) {
        SettlementDiscountPercent = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setValidityPeriod(Period newVal) {
        ValidityPeriod = newVal;
    }
}// end PaymentTerms
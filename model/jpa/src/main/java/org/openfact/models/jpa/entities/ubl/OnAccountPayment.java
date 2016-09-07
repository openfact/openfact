package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A scheduled prepayment (on-account payment) for a estimated utility
 * consumption
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:14 a. m.
 */
public class OnAccountPayment {

    /**
     * The estimated consumed quantity covered by the payment.
     */
    private BigDecimal estimatedConsumedQuantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String note;
    private PaymentTerms m_PaymentTerms;

    public OnAccountPayment() {

    }

    public void finalize() throws Throwable {

    }

    public BigDecimal getEstimatedConsumedQuantity() {
        return estimatedConsumedQuantity;
    }

    public void setEstimatedConsumedQuantity(BigDecimal estimatedConsumedQuantity) {
        this.estimatedConsumedQuantity = estimatedConsumedQuantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public PaymentTerms getM_PaymentTerms() {
        return m_PaymentTerms;
    }

    public void setM_PaymentTerms(PaymentTerms m_PaymentTerms) {
        this.m_PaymentTerms = m_PaymentTerms;
    }
}// end OnAccountPayment
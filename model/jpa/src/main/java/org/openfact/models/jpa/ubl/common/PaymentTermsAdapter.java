package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class PaymentTermsAdapter implements PaymentTermsModel, JpaModel<PaymentTermsEntity> {

    protected static final Logger logger = Logger.getLogger(PaymentTermsAdapter.class);
    protected PaymentTermsEntity paymentTerms;
    protected EntityManager em;
    protected OpenfactSession session;

    public PaymentTermsAdapter(OpenfactSession session, EntityManager em, PaymentTermsEntity paymentTerms) {
        this.session = session;
        this.em = em;
        this.paymentTerms = paymentTerms;
    }

    String getID() {
        return this.paymentTerms.getID();
    }

    void setID(String value) {
        this.paymentTerms.setID(value);
    }

    String getPaymentMeansID() {
        return this.paymentTerms.getPaymentMeansID();
    }

    void setPaymentMeansID(String value) {
        this.paymentTerms.setPaymentMeansID(value);
    }

    String getPrepaidPaymentReferenceID() {
        return this.paymentTerms.getPrepaidPaymentReferenceID();
    }

    void setPrepaidPaymentReferenceID(String value) {
        this.paymentTerms.setPrepaidPaymentReferenceID(value);
    }

    List<String> getNote() {
        return this.paymentTerms.getNote();
    }

    void setNote(List<String> note) {
        this.paymentTerms.setNote(note);
    }

    String getReferenceEventCode() {
        return this.paymentTerms.getReferenceEventCode();
    }

    void setReferenceEventCode(String value) {
        this.paymentTerms.setReferenceEventCode(value);
    }

    BigDecimal getSettlementDiscountPercent() {
        return this.paymentTerms.getSettlementDiscountPercent();
    }

    void setSettlementDiscountPercent(BigDecimal value) {
        this.paymentTerms.setSettlementDiscountPercent(value);
    }

    BigDecimal getPenaltySurchargePercent() {
        return this.paymentTerms.getPenaltySurchargePercent();
    }

    void setPenaltySurchargePercent(BigDecimal value) {
        this.paymentTerms.setPenaltySurchargePercent(value);
    }

    BigDecimal getAmount() {
        return this.paymentTerms.getAmount();
    }

    void setAmount(BigDecimal value) {
        this.paymentTerms.setAmount(value);
    }

    PeriodAdapter getSettlementPeriod() {
        return this.paymentTerms.getSettlementPeriod();
    }

    void setSettlementPeriod(PeriodAdapter value) {
        this.paymentTerms.setSettlementPeriod(value);
    }

    PeriodAdapter getPenaltyPeriod() {
        return this.paymentTerms.getPenaltyPeriod();
    }

    void setPenaltyPeriod(PeriodAdapter value) {
        this.paymentTerms.setPenaltyPeriod(value);
    }

    String getId() {
        return this.paymentTerms.getId();
    }

    void setId(String value) {
        this.paymentTerms.setId(value);
    }

}

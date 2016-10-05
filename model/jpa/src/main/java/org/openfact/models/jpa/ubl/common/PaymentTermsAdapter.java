package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.PaymentTermsEntity;
import org.openfact.models.ubl.common.PaymentTermsModel;
import org.openfact.models.ubl.common.PeriodModel;

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

    @Override
    public String getID() {
        return this.paymentTerms.getID();
    }

    @Override
    public void setID(String value) {
        this.paymentTerms.setID(value);
    }

    @Override
    public String getPaymentMeansID() {
        return this.paymentTerms.getPaymentMeansID();
    }

    @Override
    public void setPaymentMeansID(String value) {
        this.paymentTerms.setPaymentMeansID(value);
    }

    @Override
    public String getPrepaidPaymentReferenceID() {
        return this.paymentTerms.getPrepaidPaymentReferenceID();
    }

    @Override
    public void setPrepaidPaymentReferenceID(String value) {
        this.paymentTerms.setPrepaidPaymentReferenceID(value);
    }

    @Override
    public List<String> getNote() {
        return this.paymentTerms.getNote();
    }

    @Override
    public void setNote(List<String> note) {
        this.paymentTerms.setNote(note);
    }

    @Override
    public String getReferenceEventCode() {
        return this.paymentTerms.getReferenceEventCode();
    }

    @Override
    public void setReferenceEventCode(String value) {
        this.paymentTerms.setReferenceEventCode(value);
    }

    @Override
    public BigDecimal getSettlementDiscountPercent() {
        return this.paymentTerms.getSettlementDiscountPercent();
    }

    @Override
    public void setSettlementDiscountPercent(BigDecimal value) {
        this.paymentTerms.setSettlementDiscountPercent(value);
    }

    @Override
    public BigDecimal getPenaltySurchargePercent() {
        return this.paymentTerms.getPenaltySurchargePercent();
    }

    @Override
    public void setPenaltySurchargePercent(BigDecimal value) {
        this.paymentTerms.setPenaltySurchargePercent(value);
    }

    @Override
    public BigDecimal getAmount() {
        return this.paymentTerms.getAmount();
    }

    @Override
    public void setAmount(BigDecimal value) {
        this.paymentTerms.setAmount(value);
    }

    @Override
    public PeriodModel getSettlementPeriod() {
        return new PeriodAdapter(session, em, this.paymentTerms.getSettlementPeriod());
    }

    @Override
    public void setSettlementPeriod(PeriodModel value) {
        this.paymentTerms.setSettlementPeriod(PeriodAdapter.toEntity(value, em));
    }

    @Override
    public PeriodModel getPenaltyPeriod() {
        return new PeriodAdapter(session, em, this.paymentTerms.getPenaltyPeriod());
    }

    @Override
    public void setPenaltyPeriod(PeriodModel value) {
        this.paymentTerms.setPenaltyPeriod(PeriodAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.paymentTerms.getId();
    }

    @Override
    public PaymentTermsEntity getEntity() {

        return paymentTerms;
    }

    public static PaymentTermsEntity toEntity(PaymentTermsModel model, EntityManager em) {
        if (model instanceof PaymentTermsAdapter) {
            return ((PaymentTermsAdapter) model).getEntity();
        }
        return em.getReference(PaymentTermsEntity.class, model.getId());
    }

}

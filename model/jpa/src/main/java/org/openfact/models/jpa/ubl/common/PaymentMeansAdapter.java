package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.PaymentMeansEntity;
import org.openfact.models.ubl.common.CardAccountModel;
import org.openfact.models.ubl.common.CreditAccountModel;
import org.openfact.models.ubl.common.FinancialAccountModel;
import org.openfact.models.ubl.common.PaymentMeansModel;

public class PaymentMeansAdapter implements PaymentMeansModel, JpaModel<PaymentMeansEntity> {

    protected static final Logger logger = Logger.getLogger(PaymentMeansAdapter.class);
    protected PaymentMeansEntity paymentMeans;
    protected EntityManager em;
    protected OpenfactSession session;

    public PaymentMeansAdapter(OpenfactSession session, EntityManager em, PaymentMeansEntity paymentMeans) {
        this.session = session;
        this.em = em;
        this.paymentMeans = paymentMeans;
    }

    @Override
    public String getID() {
        return this.paymentMeans.getID();
    }

    @Override
    public void setID(String value) {
        this.paymentMeans.setID(value);
    }

    @Override
    public String getPaymentMeansCode() {
        return this.paymentMeans.getPaymentMeansCode();
    }

    @Override
    public void setPaymentMeansCode(String value) {
        this.paymentMeans.setPaymentMeansCode(value);
    }

    @Override
    public LocalDate getPaymentDueDate() {
        return this.paymentMeans.getPaymentDueDate();
    }

    @Override
    public void setPaymentDueDate(LocalDate value) {
        this.paymentMeans.setPaymentDueDate(value);
    }

    @Override
    public String getPaymentChannelCode() {
        return this.paymentMeans.getPaymentChannelCode();
    }

    @Override
    public void setPaymentChannelCode(String value) {
        this.paymentMeans.setPaymentChannelCode(value);
    }

    @Override
    public String getInstructionID() {
        return this.paymentMeans.getInstructionID();
    }

    @Override
    public void setInstructionID(String value) {
        this.paymentMeans.setInstructionID(value);
    }

    @Override
    public List<String> getInstructionNote() {
        return this.paymentMeans.getInstructionNote();
    }

    @Override
    public void setInstructionNote(List<String> instructionNote) {
        this.paymentMeans.setInstructionNote(instructionNote);
    }

    @Override
    public List<String> getPaymentID() {
        return this.paymentMeans.getPaymentID();
    }

    @Override
    public void setPaymentID(List<String> paymentID) {
        this.paymentMeans.setPaymentID(paymentID);
    }

    @Override
    public CardAccountModel getCardAccount() {
        return new CardAccountAdapter(session, em, paymentMeans.getCardAccount());
    }

    @Override
    public void setCardAccount(CardAccountModel value) {
        this.paymentMeans.setCardAccount(CardAccountAdapter.toEntity(value, em));
    }

    @Override
    public FinancialAccountModel getPayerFinancialAccount() {
        return new FinancialAccountAdapter(session, em, paymentMeans.getPayerFinancialAccount());
    }

    @Override
    public void setPayerFinancialAccount(FinancialAccountModel value) {
        this.paymentMeans.setPayerFinancialAccount(FinancialAccountAdapter.toEntity(value, em));
    }

    @Override
    public FinancialAccountModel getPayeeFinancialAccount() {
        return new FinancialAccountAdapter(session, em, paymentMeans.getPayeeFinancialAccount());
    }

    @Override
    public void setPayeeFinancialAccount(FinancialAccountModel value) {
        this.paymentMeans.setPayeeFinancialAccount(FinancialAccountAdapter.toEntity(value, em));
    }

    @Override
    public CreditAccountModel getCreditAccount() {
        return new CreditAccountAdapter(session, em, paymentMeans.getCreditAccount());
    }

    @Override
    public void setCreditAccount(CreditAccountModel value) {
        this.paymentMeans.setCreditAccount(CreditAccountAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.paymentMeans.getId();
    }

    @Override
    public void setId(String value) {
        this.paymentMeans.setId(value);
    }

    public static PaymentMeansEntity toEntity(PaymentMeansModel model, EntityManager em) {
        if (model instanceof PaymentMeansModel) {
            return ((PaymentMeansAdapter) model).getEntity();
        }
        return em.getReference(PaymentMeansEntity.class, model.getId());
    }

    @Override
    public PaymentMeansEntity getEntity() {
        // TODO Auto-generated method stub
        return paymentMeans;
    }

}

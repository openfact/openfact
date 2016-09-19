package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
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
        return this.paymentMeans.getCardAccount();
    }

    @Override
    public void setCardAccount(CardAccountAdapter value) {
        this.paymentMeans.setCardAccount(value);
    }

    @Override
    public FinancialAccountModel getPayerFinancialAccount() {
        return this.paymentMeans.getPayerFinancialAccount();
    }

    @Override
    public void setPayerFinancialAccount(FinancialAccountAdapter value) {
        this.paymentMeans.setPayerFinancialAccount(value);
    }

    @Override
    public FinancialAccountModel getPayeeFinancialAccount() {
        return this.paymentMeans.getPayeeFinancialAccount();
    }

    @Override
    public void setPayeeFinancialAccount(FinancialAccountAdapter value) {
        this.paymentMeans.setPayeeFinancialAccount(value);
    }

    @Override
    public CreditAccountModel getCreditAccount() {
        return this.paymentMeans.getCreditAccount();
    }

    @Override
    public void setCreditAccount(CreditAccountAdapter value) {
        this.paymentMeans.setCreditAccount(value);
    }

    @Override
    public String getId() {
        return this.paymentMeans.getId();
    }

    @Override
    public void setId(String value) {
        this.paymentMeans.setId(value);
    }

    public static PaymentMeansEntity toEntity(PaymentMeansModel f) {
        // TODO Auto-generated method stub
        return null;
    }

}

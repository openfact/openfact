package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.util.List;

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

    String getID() {
        return this.paymentMeans.getID();
    }

    void setID(String value) {
        this.paymentMeans.setID(value);
    }

    String getPaymentMeansCode() {
        return this.paymentMeans.getPaymentMeansCode();
    }

    void setPaymentMeansCode(String value) {
        this.paymentMeans.setPaymentMeansCode(value);
    }

    LocalDate getPaymentDueDate() {
        return this.paymentMeans.getPaymentDueDate();
    }

    void setPaymentDueDate(LocalDate value) {
        this.paymentMeans.setPaymentDueDate(value);
    }

    String getPaymentChannelCode() {
        return this.paymentMeans.getPaymentChannelCode();
    }

    void setPaymentChannelCode(String value) {
        this.paymentMeans.setPaymentChannelCode(value);
    }

    String getInstructionID() {
        return this.paymentMeans.getInstructionID();
    }

    void setInstructionID(String value) {
        this.paymentMeans.setInstructionID(value);
    }

    List<String> getInstructionNote() {
        return this.paymentMeans.getInstructionNote();
    }

    void setInstructionNote(List<String> instructionNote) {
        this.paymentMeans.setInstructionNote(instructionNote);
    }

    List<String> getPaymentID() {
        return this.paymentMeans.getPaymentID();
    }

    void setPaymentID(List<String> paymentID) {
        this.paymentMeans.setPaymentID(paymentID);
    }

    CardAccountAdapter getCardAccount() {
        return this.paymentMeans.getCardAccount();
    }

    void setCardAccount(CardAccountAdapter value) {
        this.paymentMeans.setCardAccount(value);
    }

    FinancialAccountAdapter getPayerFinancialAccount() {
        return this.paymentMeans.getPayerFinancialAccount();
    }

    void setPayerFinancialAccount(FinancialAccountAdapter value) {
        this.paymentMeans.setPayerFinancialAccount(value);
    }

    FinancialAccountAdapter getPayeeFinancialAccount() {
        return this.paymentMeans.getPayeeFinancialAccount();
    }

    void setPayeeFinancialAccount(FinancialAccountAdapter value) {
        this.paymentMeans.setPayeeFinancialAccount(value);
    }

    CreditAccountAdapter getCreditAccount() {
        return this.paymentMeans.getCreditAccount();
    }

    void setCreditAccount(CreditAccountAdapter value) {
        this.paymentMeans.setCreditAccount(value);
    }

    String getId() {
        return this.paymentMeans.getId();
    }

    void setId(String value) {
        this.paymentMeans.setId(value);
    }

}

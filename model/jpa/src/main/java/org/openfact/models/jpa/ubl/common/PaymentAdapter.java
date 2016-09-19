package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class PaymentAdapter implements PaymentModel, JpaModel<PaymentEntity> {

    protected static final Logger logger = Logger.getLogger(PaymentAdapter.class);
    protected PaymentEntity payment;
    protected EntityManager em;
    protected OpenfactSession session;

    public PaymentAdapter(OpenfactSession session, EntityManager em, PaymentEntity payment) {
        this.session = session;
        this.em = em;
        this.payment = payment;
    }

    String getID() {
        return this.payment.getID();
    }

    void setID(String value) {
        this.payment.setID(value);
    }

    BigDecimal getPaidAmount() {
        return this.payment.getPaidAmount();
    }

    void setPaidAmount(BigDecimal value) {
        this.payment.setPaidAmount(value);
    }

    LocalDate getReceivedDate() {
        return this.payment.getReceivedDate();
    }

    void setReceivedDate(LocalDate value) {
        this.payment.setReceivedDate(value);
    }

    LocalDate getPaidDate() {
        return this.payment.getPaidDate();
    }

    void setPaidDate(LocalDate value) {
        this.payment.setPaidDate(value);
    }

    LocalTime getPaidTime() {
        return this.payment.getPaidTime();
    }

    void setPaidTime(LocalTime value) {
        this.payment.setPaidTime(value);
    }

    String getInstructionID() {
        return this.payment.getInstructionID();
    }

    void setInstructionID(String value) {
        this.payment.setInstructionID(value);
    }

    String getId() {
        return this.payment.getId();
    }

    void setId(String value) {
        this.payment.setId(value);
    }

}

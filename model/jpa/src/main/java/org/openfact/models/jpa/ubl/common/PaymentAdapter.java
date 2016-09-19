package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.PaymentEntity;
import org.openfact.models.ubl.common.PaymentModel;

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

    @Override
    public String getID() {
        return this.payment.getID();
    }

    @Override
    public void setID(String value) {
        this.payment.setID(value);
    }

    @Override
    public BigDecimal getPaidAmount() {
        return this.payment.getPaidAmount();
    }

    @Override
    public void setPaidAmount(BigDecimal value) {
        this.payment.setPaidAmount(value);
    }

    @Override
    public LocalDate getReceivedDate() {
        return this.payment.getReceivedDate();
    }

    @Override
    public void setReceivedDate(LocalDate value) {
        this.payment.setReceivedDate(value);
    }

    @Override
    public LocalDate getPaidDate() {
        return this.payment.getPaidDate();
    }

    @Override
    public void setPaidDate(LocalDate value) {
        this.payment.setPaidDate(value);
    }

    @Override
    public LocalTime getPaidTime() {
        return this.payment.getPaidTime();
    }

    @Override
    public void setPaidTime(LocalTime value) {
        this.payment.setPaidTime(value);
    }

    @Override
    public String getInstructionID() {
        return this.payment.getInstructionID();
    }

    @Override
    public void setInstructionID(String value) {
        this.payment.setInstructionID(value);
    }

    @Override
    public String getId() {
        return this.payment.getId();
    }

    @Override
    public void setId(String value) {
        this.payment.setId(value);
    }

	@Override
	public PaymentEntity getEntity() {
		// TODO Auto-generated method stub
		return payment;
	}

}

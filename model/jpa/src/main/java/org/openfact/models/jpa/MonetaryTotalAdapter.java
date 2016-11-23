package org.openfact.models.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.MonetaryTotalModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.MonetaryTotalEntity;

public class MonetaryTotalAdapter implements MonetaryTotalModel, JpaModel<MonetaryTotalEntity> {

    protected static final Logger logger = Logger.getLogger(MonetaryTotalAdapter.class);
    protected MonetaryTotalEntity monetaryTotal;
    protected EntityManager em;
    protected OpenfactSession session;

    public MonetaryTotalAdapter(OpenfactSession session, EntityManager em,
            MonetaryTotalEntity supplierParty) {
        this.session = session;
        this.em = em;
        this.monetaryTotal = supplierParty;
    }

    @Override
    public MonetaryTotalEntity getEntity() {
        return monetaryTotal;
    }

    @Override
    public String getId() {
        return monetaryTotal.getId();
    }

    @Override
    public BigDecimal getAllowanceTotalAmount() {
        return monetaryTotal.getAllowanceTotalAmount();
    }

    @Override
    public void setAllowanceTotalAmount(BigDecimal value) {
        monetaryTotal.setAllowanceTotalAmount(value);
    }

    @Override
    public BigDecimal getChargeTotalAmount() {
        return monetaryTotal.getChargeTotalAmount();
    }

    @Override
    public void setChargeTotalAmount(BigDecimal value) {
        monetaryTotal.setChargeTotalAmount(value);
    }

    @Override
    public BigDecimal getPayableAmount() {
        return monetaryTotal.getPayableAmount();
    }

    @Override
    public void setPayableAmount(BigDecimal value) {
        monetaryTotal.setPayableAmount(value);
    }

}

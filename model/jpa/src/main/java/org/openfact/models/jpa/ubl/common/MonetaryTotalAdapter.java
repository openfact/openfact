package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.MonetaryTotalEntity;
import org.openfact.models.ubl.common.MonetaryTotalModel;

public class MonetaryTotalAdapter implements MonetaryTotalModel, JpaModel<MonetaryTotalEntity> {

    protected static final Logger logger = Logger.getLogger(MonetaryTotalAdapter.class);
    protected MonetaryTotalEntity monetaryTotal;
    protected EntityManager em;
    protected OpenfactSession session;

    public MonetaryTotalAdapter(OpenfactSession session, EntityManager em,
            MonetaryTotalEntity monetaryTotal) {
        this.session = session;
        this.em = em;
        this.monetaryTotal = monetaryTotal;
    }

    @Override
    public BigDecimal getLineExtensionAmount() {
        return this.monetaryTotal.getLineExtensionAmount();
    }

    @Override
    public void setLineExtensionAmount(BigDecimal value) {
        this.monetaryTotal.setLineExtensionAmount(value);
    }

    @Override
    public BigDecimal getTaxExclusiveAmount() {
        return this.monetaryTotal.getTaxExclusiveAmount();
    }

    @Override
    public void setTaxExclusiveAmount(BigDecimal value) {
        this.monetaryTotal.setTaxExclusiveAmount(value);
    }

    @Override
    public BigDecimal getTaxInclusiveAmount() {
        return this.monetaryTotal.getTaxInclusiveAmount();
    }

    @Override
    public void setTaxInclusiveAmount(BigDecimal value) {
        this.monetaryTotal.setTaxInclusiveAmount(value);
    }

    @Override
    public BigDecimal getAllowanceTotalAmount() {
        return this.monetaryTotal.getAllowanceTotalAmount();
    }

    @Override
    public void setAllowanceTotalAmount(BigDecimal value) {
        this.monetaryTotal.setAllowanceTotalAmount(value);
    }

    @Override
    public BigDecimal getChargeTotalAmount() {
        return this.monetaryTotal.getChargeTotalAmount();
    }

    @Override
    public void setChargeTotalAmount(BigDecimal value) {
        this.monetaryTotal.setChargeTotalAmount(value);
    }

    @Override
    public BigDecimal getPrepaidAmount() {
        return this.monetaryTotal.getPrepaidAmount();
    }

    @Override
    public void setPrepaidAmount(BigDecimal value) {
        this.monetaryTotal.setPrepaidAmount(value);
    }

    @Override
    public BigDecimal getPayableRoundingAmount() {
        return this.monetaryTotal.getPayableRoundingAmount();
    }

    @Override
    public void setPayableRoundingAmount(BigDecimal value) {
        this.monetaryTotal.setPayableRoundingAmount(value);
    }

    @Override
    public BigDecimal getPayableAmount() {
        return this.monetaryTotal.getPayableAmount();
    }

    @Override
    public void setPayableAmount(BigDecimal value) {
        this.monetaryTotal.setPayableAmount(value);
    }

    @Override
    public String getId() {
        return this.monetaryTotal.getId();
    }

    @Override
    public MonetaryTotalEntity getEntity() {
        return monetaryTotal;
    }

    public static MonetaryTotalEntity toEntity(MonetaryTotalModel model, EntityManager em) {
        if (model instanceof MonetaryTotalAdapter) {
            return ((MonetaryTotalAdapter) model).getEntity();
        }
        return em.getReference(MonetaryTotalEntity.class, model.getId());
    }

}

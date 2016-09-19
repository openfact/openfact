package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;

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

    BigDecimal getLineExtensionAmount() {
        return this.monetaryTotal.getLineExtensionAmount();
    }

    void setLineExtensionAmount(BigDecimal value) {
        this.monetaryTotal.setLineExtensionAmount(value);
    }

    BigDecimal getTaxExclusiveAmount() {
        return this.monetaryTotal.getTaxExclusiveAmount();
    }

    void setTaxExclusiveAmount(BigDecimal value) {
        this.monetaryTotal.setTaxExclusiveAmount(value);
    }

    BigDecimal getTaxInclusiveAmount() {
        return this.monetaryTotal.getTaxInclusiveAmount();
    }

    void setTaxInclusiveAmount(BigDecimal value) {
        this.monetaryTotal.setTaxInclusiveAmount(value);
    }

    BigDecimal getAllowanceTotalAmount() {
        return this.monetaryTotal.getAllowanceTotalAmount();
    }

    void setAllowanceTotalAmount(BigDecimal value) {
        this.monetaryTotal.setAllowanceTotalAmount(value);
    }

    BigDecimal getChargeTotalAmount() {
        return this.monetaryTotal.getChargeTotalAmount();
    }

    void setChargeTotalAmount(BigDecimal value) {
        this.monetaryTotal.setChargeTotalAmount(value);
    }

    BigDecimal getPrepaidAmount() {
        return this.monetaryTotal.getPrepaidAmount();
    }

    void setPrepaidAmount(BigDecimal value) {
        this.monetaryTotal.setPrepaidAmount(value);
    }

    BigDecimal getPayableRoundingAmount() {
        return this.monetaryTotal.getPayableRoundingAmount();
    }

    void setPayableRoundingAmount(BigDecimal value) {
        this.monetaryTotal.setPayableRoundingAmount(value);
    }

    BigDecimal getPayableAmount() {
        return this.monetaryTotal.getPayableAmount();
    }

    void setPayableAmount(BigDecimal value) {
        this.monetaryTotal.setPayableAmount(value);
    }

    String getId() {
        return this.monetaryTotal.getId();
    }

    void setId(String value) {
        this.monetaryTotal.setId(value);
    }

}

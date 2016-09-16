package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;

public class MonetaryTotalRepresentation {
    private BigDecimal lineExtensionAmount;
    private BigDecimal taxExclusiveAmount;
    private BigDecimal taxInclusiveAmount;
    private BigDecimal allowanceTotalAmount;
    private BigDecimal chargeTotalAmount;
    private BigDecimal prepaidAmount;
    private BigDecimal payableRoundingAmount;
    private BigDecimal payableAmount;
    private String id;

    public BigDecimal getAllowanceTotalAmount() {
        return this.allowanceTotalAmount;
    }

    public void setAllowanceTotalAmount(BigDecimal allowanceTotalAmount) {
        this.allowanceTotalAmount = allowanceTotalAmount;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getLineExtensionAmount() {
        return this.lineExtensionAmount;
    }

    public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
    }

    public BigDecimal getChargeTotalAmount() {
        return this.chargeTotalAmount;
    }

    public void setChargeTotalAmount(BigDecimal chargeTotalAmount) {
        this.chargeTotalAmount = chargeTotalAmount;
    }

    public BigDecimal getPayableAmount() {
        return this.payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public BigDecimal getTaxExclusiveAmount() {
        return this.taxExclusiveAmount;
    }

    public void setTaxExclusiveAmount(BigDecimal taxExclusiveAmount) {
        this.taxExclusiveAmount = taxExclusiveAmount;
    }

    public BigDecimal getPayableRoundingAmount() {
        return this.payableRoundingAmount;
    }

    public void setPayableRoundingAmount(BigDecimal payableRoundingAmount) {
        this.payableRoundingAmount = payableRoundingAmount;
    }

    public BigDecimal getPrepaidAmount() {
        return this.prepaidAmount;
    }

    public void setPrepaidAmount(BigDecimal prepaidAmount) {
        this.prepaidAmount = prepaidAmount;
    }

    public BigDecimal getTaxInclusiveAmount() {
        return this.taxInclusiveAmount;
    }

    public void setTaxInclusiveAmount(BigDecimal taxInclusiveAmount) {
        this.taxInclusiveAmount = taxInclusiveAmount;
    }
}
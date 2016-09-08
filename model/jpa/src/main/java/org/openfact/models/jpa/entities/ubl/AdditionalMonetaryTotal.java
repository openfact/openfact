package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * Created by lxpary on 08/09/16.
 */
public class AdditionalMonetaryTotal {
    /**
     * An identifier for this document.
     */
    private String id;
    /**
     * The payable amount for a additional monetary total.
     */
    private BigDecimal payableAmount;

    private BigDecimal percentAmount;
    private BigDecimal totalAmount;

    public AdditionalMonetaryTotal() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public BigDecimal getPercentAmount() {
        return percentAmount;
    }

    public void setPercentAmount(BigDecimal percentAmount) {
        this.percentAmount = percentAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}

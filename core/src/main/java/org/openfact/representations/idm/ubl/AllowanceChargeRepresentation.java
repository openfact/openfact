package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe information about a charge or discount as applied to a
 * price component.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:43 a. m.
 */
public class AllowanceChargeRepresentation {

    /**
     * The reason for this allowance or charge.
     */
    private String allowanceChargeReason;

    /**
     * A mutually agreed code signifying the reason for this allowance or
     * charge.
     */
    private AllowanceChargeRepresentation allowanceChargeReasonCode;

    /**
     * The monetary amount of this allowance or charge to be applied.
     */
    private BigDecimal amount;

    /**
     * The monetary amount to which the multiplier factor is applied in
     * calculating the amount of this allowance or charge.
     */
    private BigDecimal baseAmount;

    private List<TaxTotalRepresentation> taxTotals;

    /**
     * @return the allowanceChargeReason
     */
    public String getAllowanceChargeReason() {
        return allowanceChargeReason;
    }

    /**
     * @param allowanceChargeReason
     *            the allowanceChargeReason to set
     */
    public void setAllowanceChargeReason(String allowanceChargeReason) {
        this.allowanceChargeReason = allowanceChargeReason;
    }

    /**
     * @return the allowanceChargeReasonCode
     */
    public AllowanceChargeRepresentation getAllowanceChargeReasonCode() {
        return allowanceChargeReasonCode;
    }

    /**
     * @param allowanceChargeReasonCode
     *            the allowanceChargeReasonCode to set
     */
    public void setAllowanceChargeReasonCode(AllowanceChargeRepresentation allowanceChargeReasonCode) {
        this.allowanceChargeReasonCode = allowanceChargeReasonCode;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return the baseAmount
     */
    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    /**
     * @param baseAmount
     *            the baseAmount to set
     */
    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    /**
     * @return the taxTotals
     */
    public List<TaxTotalRepresentation> getTaxTotals() {
        return taxTotals;
    }

    /**
     * @param taxTotals
     *            the taxTotals to set
     */
    public void setTaxTotals(List<TaxTotalRepresentation> taxTotals) {
        this.taxTotals = taxTotals;
    }

}

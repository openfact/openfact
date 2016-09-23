package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class AllowanceChargeRepresentation {
    private String idUbl;
    private Boolean chargeIndicator;
    private String allowanceChargeReasonCode;
    private String allowanceChargeReason;
    private BigDecimal multiplierFactorNumeric;
    private Boolean prepaidIndicator;
    private BigDecimal sequenceNumeric;
    private BigDecimal amount;
    private BigDecimal baseAmount;
    private String accountingCostCode;
    private String accountingCost;
    private List<TaxCategoryRepresentation> taxCategory;
    private TaxTotalRepresentation taxTotal;
    private List<PaymentMeansRepresentation> paymentMeans;
    private String id;

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getMultiplierFactorNumeric() {
        return this.multiplierFactorNumeric;
    }

    public void setMultiplierFactorNumeric(BigDecimal multiplierFactorNumeric) {
        this.multiplierFactorNumeric = multiplierFactorNumeric;
    }

    public List<PaymentMeansRepresentation> getPaymentMeans() {
        return this.paymentMeans;
    }

    public void setPaymentMeans(List<PaymentMeansRepresentation> paymentMeans) {
        this.paymentMeans = paymentMeans;
    }

    public List<TaxCategoryRepresentation> getTaxCategory() {
        return this.taxCategory;
    }

    public void setTaxCategory(List<TaxCategoryRepresentation> taxCategory) {
        this.taxCategory = taxCategory;
    }

    public Boolean getPrepaidIndicator() {
        return this.prepaidIndicator;
    }

    public void setPrepaidIndicator(Boolean prepaidIndicator) {
        this.prepaidIndicator = prepaidIndicator;
    }

    public TaxTotalRepresentation getTaxTotal() {
        return this.taxTotal;
    }

    public void setTaxTotal(TaxTotalRepresentation taxTotal) {
        this.taxTotal = taxTotal;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAllowanceChargeReason() {
        return this.allowanceChargeReason;
    }

    public void setAllowanceChargeReason(String allowanceChargeReason) {
        this.allowanceChargeReason = allowanceChargeReason;
    }

    public BigDecimal getBaseAmount() {
        return this.baseAmount;
    }

    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    public BigDecimal getSequenceNumeric() {
        return this.sequenceNumeric;
    }

    public void setSequenceNumeric(BigDecimal sequenceNumeric) {
        this.sequenceNumeric = sequenceNumeric;
    }

    public String getAccountingCostCode() {
        return this.accountingCostCode;
    }

    public void setAccountingCostCode(String accountingCostCode) {
        this.accountingCostCode = accountingCostCode;
    }

    public String getAllowanceChargeReasonCode() {
        return this.allowanceChargeReasonCode;
    }

    public void setAllowanceChargeReasonCode(String allowanceChargeReasonCode) {
        this.allowanceChargeReasonCode = allowanceChargeReasonCode;
    }

    public String getAccountingCost() {
        return this.accountingCost;
    }

    public void setAccountingCost(String accountingCost) {
        this.accountingCost = accountingCost;
    }

    public Boolean getChargeIndicator() {
        return this.chargeIndicator;
    }

    public void setChargeIndicator(Boolean chargeIndicator) {
        this.chargeIndicator = chargeIndicator;
    }
}
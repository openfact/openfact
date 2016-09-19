package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class AllowanceChargeAdapter implements AllowanceChargeModel, JpaModel<AllowanceChargeEntity> {

    protected static final Logger logger = Logger.getLogger(AllowanceChargeAdapter.class);
    protected AllowanceChargeEntity allowanceCharge;
    protected EntityManager em;
    protected OpenfactSession session;

    public AllowanceChargeAdapter(OpenfactSession session, EntityManager em,
            AllowanceChargeEntity allowanceCharge) {
        this.session = session;
        this.em = em;
        this.allowanceCharge = allowanceCharge;
    }

    String getID() {
        return this.allowanceCharge.getID();
    }

    void setID(String value) {
        this.allowanceCharge.setID(value);
    }

    boolean getChargeIndicator() {
        return this.allowanceCharge.getChargeIndicator();
    }

    void setChargeIndicator(boolean value) {
        this.allowanceCharge.setChargeIndicator(value);
    }

    String getAllowanceChargeReasonCode() {
        return this.allowanceCharge.getAllowanceChargeReasonCode();
    }

    void setAllowanceChargeReasonCode(String value) {
        this.allowanceCharge.setAllowanceChargeReasonCode(value);
    }

    String getAllowanceChargeReason() {
        return this.allowanceCharge.getAllowanceChargeReason();
    }

    void setAllowanceChargeReason(String value) {
        this.allowanceCharge.setAllowanceChargeReason(value);
    }

    BigDecimal getMultiplierFactorNumeric() {
        return this.allowanceCharge.getMultiplierFactorNumeric();
    }

    void setMultiplierFactorNumeric(BigDecimal value) {
        this.allowanceCharge.setMultiplierFactorNumeric(value);
    }

    boolean getPrepaidIndicator() {
        return this.allowanceCharge.getPrepaidIndicator();
    }

    void setPrepaidIndicator(boolean value) {
        this.allowanceCharge.setPrepaidIndicator(value);
    }

    BigDecimal getSequenceNumeric() {
        return this.allowanceCharge.getSequenceNumeric();
    }

    void setSequenceNumeric(BigDecimal value) {
        this.allowanceCharge.setSequenceNumeric(value);
    }

    BigDecimal getAmount() {
        return this.allowanceCharge.getAmount();
    }

    void setAmount(BigDecimal value) {
        this.allowanceCharge.setAmount(value);
    }

    BigDecimal getBaseAmount() {
        return this.allowanceCharge.getBaseAmount();
    }

    void setBaseAmount(BigDecimal value) {
        this.allowanceCharge.setBaseAmount(value);
    }

    String getAccountingCostCode() {
        return this.allowanceCharge.getAccountingCostCode();
    }

    void setAccountingCostCode(String value) {
        this.allowanceCharge.setAccountingCostCode(value);
    }

    String getAccountingCost() {
        return this.allowanceCharge.getAccountingCost();
    }

    void setAccountingCost(String value) {
        this.allowanceCharge.setAccountingCost(value);
    }

    List<TaxCategoryAdapter> getTaxCategory() {
        return this.allowanceCharge.getTaxCategory();
    }

    void setTaxCategory(List<TaxCategoryAdapter> taxCategory) {
        this.allowanceCharge.setTaxCategory(taxCategory);
    }

    TaxTotalAdapter getTaxTotal() {
        return this.allowanceCharge.getTaxTotal();
    }

    void setTaxTotal(TaxTotalAdapter value) {
        this.allowanceCharge.setTaxTotal(value);
    }

    List<PaymentMeansAdapter> getPaymentMeans() {
        return this.allowanceCharge.getPaymentMeans();
    }

    void setPaymentMeans(List<PaymentMeansAdapter> paymentMeans) {
        this.allowanceCharge.setPaymentMeans(paymentMeans);
    }

    String getId() {
        return this.allowanceCharge.getId();
    }

    void setId(String value) {
        this.allowanceCharge.setId(value);
    }

}

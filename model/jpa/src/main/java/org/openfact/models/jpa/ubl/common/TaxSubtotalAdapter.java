package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;

public class TaxSubtotalAdapter implements TaxSubtotalModel, JpaModel<TaxSubtotalEntity> {

    protected static final Logger logger = Logger.getLogger(TaxSubtotalAdapter.class);
    protected TaxSubtotalEntity taxSubtotal;
    protected EntityManager em;
    protected OpenfactSession session;

    public TaxSubtotalAdapter(OpenfactSession session, EntityManager em, TaxSubtotalEntity taxSubtotal) {
        this.session = session;
        this.em = em;
        this.taxSubtotal = taxSubtotal;
    }

    BigDecimal getTaxableAmount() {
        return this.taxSubtotal.getTaxableAmount();
    }

    void setTaxableAmount(BigDecimal value) {
        this.taxSubtotal.setTaxableAmount(value);
    }

    BigDecimal getTaxAmount() {
        return this.taxSubtotal.getTaxAmount();
    }

    void setTaxAmount(BigDecimal value) {
        this.taxSubtotal.setTaxAmount(value);
    }

    BigDecimal getCalculationSequenceNumeric() {
        return this.taxSubtotal.getCalculationSequenceNumeric();
    }

    void setCalculationSequenceNumeric(BigDecimal value) {
        this.taxSubtotal.setCalculationSequenceNumeric(value);
    }

    BigDecimal getTransactionCurrencyTaxAmount() {
        return this.taxSubtotal.getTransactionCurrencyTaxAmount();
    }

    void setTransactionCurrencyTaxAmount(BigDecimal value) {
        this.taxSubtotal.setTransactionCurrencyTaxAmount(value);
    }

    BigDecimal getPercent() {
        return this.taxSubtotal.getPercent();
    }

    void setPercent(BigDecimal value) {
        this.taxSubtotal.setPercent(value);
    }

    MeasureAdapter getBaseUnitMeasure() {
        return this.taxSubtotal.getBaseUnitMeasure();
    }

    void setBaseUnitMeasure(MeasureAdapter value) {
        this.taxSubtotal.setBaseUnitMeasure(value);
    }

    BigDecimal getPerUnitAmount() {
        return this.taxSubtotal.getPerUnitAmount();
    }

    void setPerUnitAmount(BigDecimal value) {
        this.taxSubtotal.setPerUnitAmount(value);
    }

    String getTierRange() {
        return this.taxSubtotal.getTierRange();
    }

    void setTierRange(String value) {
        this.taxSubtotal.setTierRange(value);
    }

    BigDecimal getTierRatePercent() {
        return this.taxSubtotal.getTierRatePercent();
    }

    void setTierRatePercent(BigDecimal value) {
        this.taxSubtotal.setTierRatePercent(value);
    }

    TaxCategoryAdapter getTaxCategory() {
        return this.taxSubtotal.getTaxCategory();
    }

    void setTaxCategory(TaxCategoryAdapter value) {
        this.taxSubtotal.setTaxCategory(value);
    }

    String getId() {
        return this.taxSubtotal.getId();
    }

    void setId(String value) {
        this.taxSubtotal.setId(value);
    }

}

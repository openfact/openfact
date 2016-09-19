package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;

public class TaxCategoryAdapter implements TaxCategoryModel, JpaModel<TaxCategoryEntity> {

    protected static final Logger logger = Logger.getLogger(TaxCategoryAdapter.class);
    protected TaxCategoryEntity taxCategory;
    protected EntityManager em;
    protected OpenfactSession session;

    public TaxCategoryAdapter(OpenfactSession session, EntityManager em, TaxCategoryEntity taxCategory) {
        this.session = session;
        this.em = em;
        this.taxCategory = taxCategory;
    }

    String getID() {
        return this.taxCategory.getID();
    }

    void setID(String value) {
        this.taxCategory.setID(value);
    }

    String getName() {
        return this.taxCategory.getName();
    }

    void setName(String value) {
        this.taxCategory.setName(value);
    }

    BigDecimal getPercent() {
        return this.taxCategory.getPercent();
    }

    void setPercent(BigDecimal value) {
        this.taxCategory.setPercent(value);
    }

    MeasureAdapter getBaseUnitMeasure() {
        return this.taxCategory.getBaseUnitMeasure();
    }

    void setBaseUnitMeasure(MeasureAdapter value) {
        this.taxCategory.setBaseUnitMeasure(value);
    }

    BigDecimal getPerUnitAmount() {
        return this.taxCategory.getPerUnitAmount();
    }

    void setPerUnitAmount(BigDecimal value) {
        this.taxCategory.setPerUnitAmount(value);
    }

    String getTaxExemptionReasonCode() {
        return this.taxCategory.getTaxExemptionReasonCode();
    }

    void setTaxExemptionReasonCode(String value) {
        this.taxCategory.setTaxExemptionReasonCode(value);
    }

    String getTaxExemptionReason() {
        return this.taxCategory.getTaxExemptionReason();
    }

    void setTaxExemptionReason(String value) {
        this.taxCategory.setTaxExemptionReason(value);
    }

    String getTierRange() {
        return this.taxCategory.getTierRange();
    }

    void setTierRange(String value) {
        this.taxCategory.setTierRange(value);
    }

    BigDecimal getTierRatePercent() {
        return this.taxCategory.getTierRatePercent();
    }

    void setTierRatePercent(BigDecimal value) {
        this.taxCategory.setTierRatePercent(value);
    }

    TaxSchemeAdapter getTaxScheme() {
        return this.taxCategory.getTaxScheme();
    }

    void setTaxScheme(TaxSchemeAdapter value) {
        this.taxCategory.setTaxScheme(value);
    }

    String getId() {
        return this.taxCategory.getId();
    }

    void setId(String value) {
        this.taxCategory.setId(value);
    }

}

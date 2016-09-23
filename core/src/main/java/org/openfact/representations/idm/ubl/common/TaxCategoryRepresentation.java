package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;

public class TaxCategoryRepresentation {
    private String idUbl;
    private String name;
    private BigDecimal percent;
    private MeasureRepresentation baseUnitMeasure;
    private BigDecimal perUnitAmount;
    private String taxExemptionReasonCode;
    private String taxExemptionReason;
    private String tierRange;
    private BigDecimal tierRatePercent;
    private TaxSchemeRepresentation taxScheme;
    private String id;

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public String getTaxExemptionReasonCode() {
        return this.taxExemptionReasonCode;
    }

    public void setTaxExemptionReasonCode(String taxExemptionReasonCode) {
        this.taxExemptionReasonCode = taxExemptionReasonCode;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPercent() {
        return this.percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public String getTaxExemptionReason() {
        return this.taxExemptionReason;
    }

    public void setTaxExemptionReason(String taxExemptionReason) {
        this.taxExemptionReason = taxExemptionReason;
    }

    public MeasureRepresentation getBaseUnitMeasure() {
        return this.baseUnitMeasure;
    }

    public void setBaseUnitMeasure(MeasureRepresentation baseUnitMeasure) {
        this.baseUnitMeasure = baseUnitMeasure;
    }

    public BigDecimal getPerUnitAmount() {
        return this.perUnitAmount;
    }

    public void setPerUnitAmount(BigDecimal perUnitAmount) {
        this.perUnitAmount = perUnitAmount;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaxSchemeRepresentation getTaxScheme() {
        return this.taxScheme;
    }

    public void setTaxScheme(TaxSchemeRepresentation taxScheme) {
        this.taxScheme = taxScheme;
    }

    public BigDecimal getTierRatePercent() {
        return this.tierRatePercent;
    }

    public void setTierRatePercent(BigDecimal tierRatePercent) {
        this.tierRatePercent = tierRatePercent;
    }

    public String getTierRange() {
        return this.tierRange;
    }

    public void setTierRange(String tierRange) {
        this.tierRange = tierRange;
    }
}
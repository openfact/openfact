package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe one of the tax categories within a taxation scheme (e.g.,
 * High Rate VAT, Low Rate VAT).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:02 a. m.
 */
public class TaxCategory {

    /**
     * A Unit of Measures used as the basic for the tax calculation applied at a
     * certain rate per unit.
     */
    private BigDecimal baseUnitMeasure;
    /**
     * An identifier for this tax category.
     */
    private String id;
    /**
     * The name of this tax category.
     */
    private String name;
    /**
     * The tax rate for this category, expressed as a percentage.
     */
    private BigDecimal percent;
    /**
     * Where a tax is applied at a certain rate per unit, the rate per unit
     * applied.
     */
    private BigDecimal perUnitAmount;
    /**
     * The reason for tax being exempted, expressed as text.
     */
    private String taxExemptionReason;
    /**
     * The reason for tax being exempted, expressed as a code.
     */
    private String taxExemptionReasonCode;
    /**
     * Where a tax is tiered, the range of taxable amounts that determines the
     * rate of tax applicable to this tax category.
     */
    private String tierRange;
    /**
     * Where a tax is tiered, the tax rate that applies within the specified
     * range of taxable amounts for this tax category.
     */
    private BigDecimal tierRatePercent;
    private List<TaxScheme> taxSchemes = new ArrayList<>();

    public BigDecimal getBaseUnitMeasure() {
        return baseUnitMeasure;
    }

    public void setBaseUnitMeasure(BigDecimal baseUnitMeasure) {
        this.baseUnitMeasure = baseUnitMeasure;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public BigDecimal getPerUnitAmount() {
        return perUnitAmount;
    }

    public void setPerUnitAmount(BigDecimal perUnitAmount) {
        this.perUnitAmount = perUnitAmount;
    }

    public String getTaxExemptionReason() {
        return taxExemptionReason;
    }

    public void setTaxExemptionReason(String taxExemptionReason) {
        this.taxExemptionReason = taxExemptionReason;
    }

    public String getTaxExemptionReasonCode() {
        return taxExemptionReasonCode;
    }

    public void setTaxExemptionReasonCode(String taxExemptionReasonCode) {
        this.taxExemptionReasonCode = taxExemptionReasonCode;
    }

    public String getTierRange() {
        return tierRange;
    }

    public void setTierRange(String tierRange) {
        this.tierRange = tierRange;
    }

    public BigDecimal getTierRatePercent() {
        return tierRatePercent;
    }

    public void setTierRatePercent(BigDecimal tierRatePercent) {
        this.tierRatePercent = tierRatePercent;
    }

    public List<TaxScheme> getTaxSchemes() {
        return taxSchemes;
    }

    public void setTaxSchemes(List<TaxScheme> taxSchemes) {
        this.taxSchemes = taxSchemes;
    }
}
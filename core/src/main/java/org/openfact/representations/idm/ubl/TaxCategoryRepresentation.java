package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.MeasureRepresentation;

/**
 * A class to describe one of the tax categories within a taxation scheme (e.g.,
 * High Rate VAT, Low Rate VAT).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:02 a. m.
 */
public class TaxCategoryRepresentation {

    /**
     * A Unit of Measures used as the basic for the tax calculation applied at a
     * certain rate per unit.
     */
    private MeasureRepresentation baseUnitMeasure;
    /**
     * An identifier for this tax category.
     */
    private IdentifierRepresentation ID;
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
    private CodeRepresentation taxExemptionReasonCode;
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
    private TaxSchemeRepresentation taxScheme;

    /**
     * @return the baseUnitMeasure
     */
    public MeasureRepresentation getBaseUnitMeasure() {
        return baseUnitMeasure;
    }

    /**
     * @param baseUnitMeasure
     *            the baseUnitMeasure to set
     */
    public void setBaseUnitMeasure(MeasureRepresentation baseUnitMeasure) {
        this.baseUnitMeasure = baseUnitMeasure;
    }

    /**
     * @return the iD
     */
    public IdentifierRepresentation getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(IdentifierRepresentation iD) {
        ID = iD;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the percent
     */
    public BigDecimal getPercent() {
        return percent;
    }

    /**
     * @param percent
     *            the percent to set
     */
    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    /**
     * @return the perUnitAmount
     */
    public BigDecimal getPerUnitAmount() {
        return perUnitAmount;
    }

    /**
     * @param perUnitAmount
     *            the perUnitAmount to set
     */
    public void setPerUnitAmount(BigDecimal perUnitAmount) {
        this.perUnitAmount = perUnitAmount;
    }

    /**
     * @return the taxExemptionReason
     */
    public String getTaxExemptionReason() {
        return taxExemptionReason;
    }

    /**
     * @param taxExemptionReason
     *            the taxExemptionReason to set
     */
    public void setTaxExemptionReason(String taxExemptionReason) {
        this.taxExemptionReason = taxExemptionReason;
    }

    /**
     * @return the taxExemptionReasonCode
     */
    public CodeRepresentation getTaxExemptionReasonCode() {
        return taxExemptionReasonCode;
    }

    /**
     * @param taxExemptionReasonCode
     *            the taxExemptionReasonCode to set
     */
    public void setTaxExemptionReasonCode(CodeRepresentation taxExemptionReasonCode) {
        this.taxExemptionReasonCode = taxExemptionReasonCode;
    }

    /**
     * @return the tierRange
     */
    public String getTierRange() {
        return tierRange;
    }

    /**
     * @param tierRange
     *            the tierRange to set
     */
    public void setTierRange(String tierRange) {
        this.tierRange = tierRange;
    }

    /**
     * @return the tierRatePercent
     */
    public BigDecimal getTierRatePercent() {
        return tierRatePercent;
    }

    /**
     * @param tierRatePercent
     *            the tierRatePercent to set
     */
    public void setTierRatePercent(BigDecimal tierRatePercent) {
        this.tierRatePercent = tierRatePercent;
    }

    /**
     * @return the taxScheme
     */
    public TaxSchemeRepresentation getTaxScheme() {
        return taxScheme;
    }

    /**
     * @param taxScheme
     *            the taxScheme to set
     */
    public void setTaxScheme(TaxSchemeRepresentation taxScheme) {
        this.taxScheme = taxScheme;
    }

}

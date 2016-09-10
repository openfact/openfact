package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to define the subtotal for a particular tax category within a
 * particular taxation scheme, such as standard rate within VAT.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:05 a. m.
 */
@Entity
@Table(name = "TAX_SUB_TOTAL")
public class TaxSubtotalEntity {

    @Id
    @Column(name = "ID_OP", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    /**
     * The unit of measure on which the tax calculation is based
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "BASEUNITMEASURE_VALUE")),
            @AttributeOverride(name = "unitCode", column = @Column(name = "BASEUNITMEASURE_UNITCODE")) })
    private MeasureType baseUnitMeasure;

    /**
     * The number of this tax subtotal in the sequence of subtotals
     * corresponding to the order in which multiple taxes are applied. If all
     * taxes are applied to the same taxable amount (i.e., their order of
     * application is inconsequential), then CalculationSequenc
     */
    @Column(name = "CALCULATION_SEQUENCE_NUMERIC")
    private BigDecimal calculationSequenceNumeric;

    /**
     * The tax rate of the tax category applied to this tax subtotal, expressed
     * as a percentage.
     */
    @Column(name = "PERCENT")
    private BigDecimal percent;

    /**
     * Where a tax is applied at a certain rate per unit, the rate per unit
     * applied.
     */
    @Column(name = "PER_UNIT_AMOUNT")
    private BigDecimal perUnitAmount;

    /**
     * The net amount to which the tax percent (rate) is applied to calculate
     * the tax amount.
     */
    @Column(name = "TAXABLE_AMOUNT")
    private BigDecimal taxableAmount;

    /**
     * The amount of this tax subtotal.
     */
    @Column(name = "TAX_AMOUNT")
    private BigDecimal taxAmount;

    /**
     * Where a tax is tiered, the range of taxable amounts that determines the
     * rate of tax applicable to this tax subtotal.
     */
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "TIERRANGE_VALUE")),
            @AttributeOverride(name = "languageID", column = @Column(name = "TIERRANGE_LANGUAGE")) })
    private TextType tierRange;

    /**
     * Where a tax is tiered, the tax rate that applies within a specified range
     * of taxable amounts for this tax subtotal.
     */
    @Column(name = "TIER_RANGE_PERCENT")
    private BigDecimal tierRatePercent;

    /**
     * The amount of this tax subtotal, expressed in the currency used for
     * invoicing.
     */
    @Column(name = "TRANSACTION_CURRENCY_TAX_AMOUNT")
    private BigDecimal transactionCurrencyTaxAmount;

    @OneToMany(mappedBy = "taxSubtotal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<TaxCategoryEntity> taxCategories = new ArrayList<>();

    /**
     * ForeignKey
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "TAX_TOTAL_ID")
    private TaxTotalEntity taxTotal;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the baseUnitMeasure
     */
    public MeasureType getBaseUnitMeasure() {
        return baseUnitMeasure;
    }

    /**
     * @param baseUnitMeasure
     *            the baseUnitMeasure to set
     */
    public void setBaseUnitMeasure(MeasureType baseUnitMeasure) {
        this.baseUnitMeasure = baseUnitMeasure;
    }

    /**
     * @return the calculationSequenceNumeric
     */
    public BigDecimal getCalculationSequenceNumeric() {
        return calculationSequenceNumeric;
    }

    /**
     * @param calculationSequenceNumeric
     *            the calculationSequenceNumeric to set
     */
    public void setCalculationSequenceNumeric(BigDecimal calculationSequenceNumeric) {
        this.calculationSequenceNumeric = calculationSequenceNumeric;
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
     * @return the taxableAmount
     */
    public BigDecimal getTaxableAmount() {
        return taxableAmount;
    }

    /**
     * @param taxableAmount
     *            the taxableAmount to set
     */
    public void setTaxableAmount(BigDecimal taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    /**
     * @return the taxAmount
     */
    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    /**
     * @param taxAmount
     *            the taxAmount to set
     */
    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * @return the tierRange
     */
    public TextType getTierRange() {
        return tierRange;
    }

    /**
     * @param tierRange
     *            the tierRange to set
     */
    public void setTierRange(TextType tierRange) {
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
     * @return the transactionCurrencyTaxAmount
     */
    public BigDecimal getTransactionCurrencyTaxAmount() {
        return transactionCurrencyTaxAmount;
    }

    /**
     * @param transactionCurrencyTaxAmount
     *            the transactionCurrencyTaxAmount to set
     */
    public void setTransactionCurrencyTaxAmount(BigDecimal transactionCurrencyTaxAmount) {
        this.transactionCurrencyTaxAmount = transactionCurrencyTaxAmount;
    }

    /**
     * @return the taxCategories
     */
    public List<TaxCategoryEntity> getTaxCategories() {
        return taxCategories;
    }

    /**
     * @param taxCategories
     *            the taxCategories to set
     */
    public void setTaxCategories(List<TaxCategoryEntity> taxCategories) {
        this.taxCategories = taxCategories;
    }

    /**
     * @return the taxTotal
     */
    public TaxTotalEntity getTaxTotal() {
        return taxTotal;
    }

    /**
     * @param taxTotal
     *            the taxTotal to set
     */
    public void setTaxTotal(TaxTotalEntity taxTotal) {
        this.taxTotal = taxTotal;
    }
}

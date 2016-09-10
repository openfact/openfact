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
 * A class to describe one of the tax categories within a taxation scheme (e.g.,
 * High Rate VAT, Low Rate VAT).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:02 a. m.
 */
@Entity
@Table(name = "TAX_CATEGORY")
public class TaxCategoryEntity {

    @Id
    @Column(name = "ID_OP", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    /**
     * A Unit of Measures used as the basic for the tax calculation applied at a
     * certain rate per unit.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "BASEUNITMEASURE_VALUE")),
            @AttributeOverride(name = "unitCode", column = @Column(name = "BASEUNITMEASURE_UNITCODE")) })
    private MeasureType baseUnitMeasure;

    /**
     * An identifier for this tax category.
     */
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ID_VALUE")),
            @AttributeOverride(name = "schemeID", column = @Column(name = "ID_SCHEMEID")),
            @AttributeOverride(name = "schemeName", column = @Column(name = "ID_SCHEMENAME")),
            @AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ID_SCHEMEAGENCYID")),
            @AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ID_SCHEMEAGENCYNAME")),
            @AttributeOverride(name = "schemeVersionID", column = @Column(name = "ID_SCHEMEVERSIONID")),
            @AttributeOverride(name = "schemeDataURI", column = @Column(name = "ID_SCHEMEDATEURI")),
            @AttributeOverride(name = "schemeURI", column = @Column(name = "ID_SCHEMEURI")) })
    private IdentifierType ID;

    /**
     * The name of this tax category.
     */
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "NAME_VALUE")),
            @AttributeOverride(name = "languageID", column = @Column(name = "NAME_LANGUAGEID")) })
    private NameType name;

    /**
     * The tax rate for this category, expressed as a percentage.
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
     * The reason for tax being exempted, expressed as text.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "TAXEXEMPTIONREASON_VALUE")),
            @AttributeOverride(name = "languageID", column = @Column(name = "TAXEXEMPTIONREASON_LANGUAGE")) })
    private TextType taxExemptionReason;

    /**
     * The reason for tax being exempted, expressed as a code.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "TAXEXEMPTIONREASONCODE_VALUE")),
            @AttributeOverride(name = "listID", column = @Column(name = "TAXEXEMPTIONREASONCODE_LISTID")),
            @AttributeOverride(name = "listAgencyID", column = @Column(name = "TAXEXEMPTIONREASONCODE_AGENCYID")),
            @AttributeOverride(name = "listAgencyName", column = @Column(name = "TAXEXEMPTIONREASONCODE_AGENCYNAME")),
            @AttributeOverride(name = "listName", column = @Column(name = "TAXEXEMPTIONREASONCODE_LISTNAME")),
            @AttributeOverride(name = "listVersionID", column = @Column(name = "TAXEXEMPTIONREASONCODE_LISTVERSIONID")),
            @AttributeOverride(name = "name", column = @Column(name = "TAXEXEMPTIONREASONCODE_NAME")),
            @AttributeOverride(name = "languageID", column = @Column(name = "TAXEXEMPTIONREASONCODE_LANGUAGEID")),
            @AttributeOverride(name = "listURI", column = @Column(name = "TAXEXEMPTIONREASONCODE_LISTURI")),
            @AttributeOverride(name = "listSchemeURI", column = @Column(name = "TAXEXEMPTIONREASONCODE_SCHEMEURI")) })
    private CodeType taxExemptionReasonCode;

    /**
     * Where a tax is tiered, the range of taxable amounts that determines the
     * rate of tax applicable to this tax category.
     */
    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "TIERRANGE_VALUE")),
            @AttributeOverride(name = "languageID", column = @Column(name = "TIERRANGE_LANGUAGE")) })
    private TextType tierRange;

    /**
     * Where a tax is tiered, the tax rate that applies within the specified
     * range of taxable amounts for this tax category.
     */
    @Column(name = "TIER_RATE_PERCENT")
    private BigDecimal tierRatePercent;

    @OneToMany(mappedBy = "taxCategory", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<TaxSchemeEntity> taxSchemes = new ArrayList<>();

    /**
     * ForeignKey
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "TAX_SUBTOTAL_ID")
    private TaxSubtotalEntity taxSubtotal;

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
     * @return the iD
     */
    public IdentifierType getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(IdentifierType iD) {
        ID = iD;
    }

    /**
     * @return the name
     */
    public NameType getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(NameType name) {
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
    public TextType getTaxExemptionReason() {
        return taxExemptionReason;
    }

    /**
     * @param taxExemptionReason
     *            the taxExemptionReason to set
     */
    public void setTaxExemptionReason(TextType taxExemptionReason) {
        this.taxExemptionReason = taxExemptionReason;
    }

    /**
     * @return the taxExemptionReasonCode
     */
    public CodeType getTaxExemptionReasonCode() {
        return taxExemptionReasonCode;
    }

    /**
     * @param taxExemptionReasonCode
     *            the taxExemptionReasonCode to set
     */
    public void setTaxExemptionReasonCode(CodeType taxExemptionReasonCode) {
        this.taxExemptionReasonCode = taxExemptionReasonCode;
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
     * @return the taxSchemes
     */
    public List<TaxSchemeEntity> getTaxSchemes() {
        return taxSchemes;
    }

    /**
     * @param taxSchemes
     *            the taxSchemes to set
     */
    public void setTaxSchemes(List<TaxSchemeEntity> taxSchemes) {
        this.taxSchemes = taxSchemes;
    }

    /**
     * @return the taxSubtotal
     */
    public TaxSubtotalEntity getTaxSubtotal() {
        return taxSubtotal;
    }

    /**
     * @param taxSubtotal
     *            the taxSubtotal to set
     */
    public void setTaxSubtotal(TaxSubtotalEntity taxSubtotal) {
        this.taxSubtotal = taxSubtotal;
    }
}

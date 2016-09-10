package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * A class to describe the total tax for a particular taxation scheme.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:07 a. m.
 */

@Entity
@Table(name = "TAX_TOTAL")
public class TaxTotalEntity {

    @Id
    @Column(name = "ID_OP", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    /**
     * The rounding amount (positive or negative) added to the calculated tax
     * total to produce the rounded TaxAmount.
     */
    @Column(name = "ROUNDING_AMOUNT")
    private BigDecimal roundingAmount;

    /**
     * The total tax amount for a particular taxation scheme, e.g., VAT; the sum
     * of the tax subtotals for each tax category within the taxation scheme.
     */
    @Column(name = "TAX_AMOUNT")
    private BigDecimal taxAmount;

    /**
     * An indicator that this total is recognized as legal evidence for taxation
     * purposes (true) or not (false).
     */
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "TAX_EVIDENCE_INDICATOR")
    private boolean taxEvidenceIndicator;

    /**
     * An indicator that tax is included in the calculation (true) or not
     * (false).
     */
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "TAX_INCLUDE_INDICATOR")
    private boolean taxIncludedIndicator;

    @OneToMany(mappedBy = "taxTotal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<TaxSubtotalEntity> taxSubtotals = new ArrayList<>();

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
     * @return the roundingAmount
     */
    public BigDecimal getRoundingAmount() {
        return roundingAmount;
    }

    /**
     * @param roundingAmount
     *            the roundingAmount to set
     */
    public void setRoundingAmount(BigDecimal roundingAmount) {
        this.roundingAmount = roundingAmount;
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
     * @return the taxEvidenceIndicator
     */
    public boolean isTaxEvidenceIndicator() {
        return taxEvidenceIndicator;
    }

    /**
     * @param taxEvidenceIndicator
     *            the taxEvidenceIndicator to set
     */
    public void setTaxEvidenceIndicator(boolean taxEvidenceIndicator) {
        this.taxEvidenceIndicator = taxEvidenceIndicator;
    }

    /**
     * @return the taxIncludedIndicator
     */
    public boolean isTaxIncludedIndicator() {
        return taxIncludedIndicator;
    }

    /**
     * @param taxIncludedIndicator
     *            the taxIncludedIndicator to set
     */
    public void setTaxIncludedIndicator(boolean taxIncludedIndicator) {
        this.taxIncludedIndicator = taxIncludedIndicator;
    }

    /**
     * @return the taxSubtotals
     */
    public List<TaxSubtotalEntity> getTaxSubtotals() {
        return taxSubtotals;
    }

    /**
     * @param taxSubtotals
     *            the taxSubtotals to set
     */
    public void setTaxSubtotals(List<TaxSubtotalEntity> taxSubtotals) {
        this.taxSubtotals = taxSubtotals;
    }

}

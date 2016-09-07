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
	private BigDecimal BaseUnitMeasure;
	/**
	 * An identifier for this tax category.
	 */
	private String ID;
	/**
	 * The name of this tax category.
	 */
	private String Name;
	/**
	 * The tax rate for this category, expressed as a percentage.
	 */
	private BigDecimal Percent;
	/**
	 * Where a tax is applied at a certain rate per unit, the rate per unit
	 * applied.
	 */
	private BigDecimal PerUnitAmount;
	/**
	 * The reason for tax being exempted, expressed as text.
	 */
	private String TaxExemptionReason;
	/**
	 * The reason for tax being exempted, expressed as a code.
	 */
	private String TaxExemptionReasonCode;
	/**
	 * Where a tax is tiered, the range of taxable amounts that determines the
	 * rate of tax applicable to this tax category.
	 */
	private String TierRange;
	/**
	 * Where a tax is tiered, the tax rate that applies within the specified
	 * range of taxable amounts for this tax category.
	 */
	private BigDecimal TierRatePercent;
	private TaxScheme m_TaxScheme;

	/**
	 * @return the baseUnitMeasure
	 */
	public BigDecimal getBaseUnitMeasure() {
		return BaseUnitMeasure;
	}

	/**
	 * @param baseUnitMeasure
	 *            the baseUnitMeasure to set
	 */
	public void setBaseUnitMeasure(BigDecimal baseUnitMeasure) {
		BaseUnitMeasure = baseUnitMeasure;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the percent
	 */
	public BigDecimal getPercent() {
		return Percent;
	}

	/**
	 * @param percent
	 *            the percent to set
	 */
	public void setPercent(BigDecimal percent) {
		Percent = percent;
	}

	/**
	 * @return the perUnitAmount
	 */
	public BigDecimal getPerUnitAmount() {
		return PerUnitAmount;
	}

	/**
	 * @param perUnitAmount
	 *            the perUnitAmount to set
	 */
	public void setPerUnitAmount(BigDecimal perUnitAmount) {
		PerUnitAmount = perUnitAmount;
	}

	/**
	 * @return the taxExemptionReason
	 */
	public String getTaxExemptionReason() {
		return TaxExemptionReason;
	}

	/**
	 * @param taxExemptionReason
	 *            the taxExemptionReason to set
	 */
	public void setTaxExemptionReason(String taxExemptionReason) {
		TaxExemptionReason = taxExemptionReason;
	}

	/**
	 * @return the taxExemptionReasonCode
	 */
	public String getTaxExemptionReasonCode() {
		return TaxExemptionReasonCode;
	}

	/**
	 * @param taxExemptionReasonCode
	 *            the taxExemptionReasonCode to set
	 */
	public void setTaxExemptionReasonCode(String taxExemptionReasonCode) {
		TaxExemptionReasonCode = taxExemptionReasonCode;
	}

	/**
	 * @return the tierRange
	 */
	public String getTierRange() {
		return TierRange;
	}

	/**
	 * @param tierRange
	 *            the tierRange to set
	 */
	public void setTierRange(String tierRange) {
		TierRange = tierRange;
	}

	/**
	 * @return the tierRatePercent
	 */
	public BigDecimal getTierRatePercent() {
		return TierRatePercent;
	}

	/**
	 * @param tierRatePercent
	 *            the tierRatePercent to set
	 */
	public void setTierRatePercent(BigDecimal tierRatePercent) {
		TierRatePercent = tierRatePercent;
	}

	/**
	 * @return the m_TaxScheme
	 */
	public TaxScheme getM_TaxScheme() {
		return m_TaxScheme;
	}

	/**
	 * @param m_TaxScheme
	 *            the m_TaxScheme to set
	 */
	public void setM_TaxScheme(TaxScheme m_TaxScheme) {
		this.m_TaxScheme = m_TaxScheme;
	}

}// end TaxCategory
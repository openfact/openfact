package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class for information about pricing structure, lead time, and location
 * associated with an item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:47 a. m.
 */
public class ItemLocationQuantity {

	/**
	 * An indication that the transported item, as delivered, in the stated
	 * quantity to the stated location, is subject to an international
	 * regulation concerning the carriage of dangerous goods (true) or not
	 * (false).
	 */
	private boolean hazardousRiskIndicator;
	/**
	 * The lead time, i.e., the time taken from the time at which an item is
	 * ordered to the time of its delivery.
	 */
	private BigDecimal leadTimeMeasure;
	/**
	 * The maximum quantity that can be ordered to qualify for a specific price.
	 */
	private BigDecimal maximumQuantity;
	/**
	 * The minimum quantity that can be ordered to qualify for a specific price.
	 */
	private BigDecimal minimumQuantity;
	/**
	 * Text describing trade restrictions on the quantity of this item or on the
	 * item itself.
	 */
	private String tradingRestrictions;
	private Address applicableTerritoryAddress;
	private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
	private DeliveryUnit m_DeliveryUnit;
	private DependentPriceReference m_DependentPriceReference;
	private Package m_Package;
	private List<Price> prices = new ArrayList<>();
	private TaxCategory applicableTaxCategory;

	public boolean isHazardousRiskIndicator() {
		return hazardousRiskIndicator;
	}

	public void setHazardousRiskIndicator(boolean hazardousRiskIndicator) {
		this.hazardousRiskIndicator = hazardousRiskIndicator;
	}

	public BigDecimal getLeadTimeMeasure() {
		return leadTimeMeasure;
	}

	public void setLeadTimeMeasure(BigDecimal leadTimeMeasure) {
		this.leadTimeMeasure = leadTimeMeasure;
	}

	public BigDecimal getMaximumQuantity() {
		return maximumQuantity;
	}

	public void setMaximumQuantity(BigDecimal maximumQuantity) {
		this.maximumQuantity = maximumQuantity;
	}

	public BigDecimal getMinimumQuantity() {
		return minimumQuantity;
	}

	public void setMinimumQuantity(BigDecimal minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}

	public String getTradingRestrictions() {
		return tradingRestrictions;
	}

	public void setTradingRestrictions(String tradingRestrictions) {
		this.tradingRestrictions = tradingRestrictions;
	}

	public Address getApplicableTerritoryAddress() {
		return applicableTerritoryAddress;
	}

	public void setApplicableTerritoryAddress(Address applicableTerritoryAddress) {
		this.applicableTerritoryAddress = applicableTerritoryAddress;
	}

	public AllowanceCharge getM_AllowanceCharge() {
		return m_AllowanceCharge;
	}

	public void setM_AllowanceCharge(AllowanceCharge m_AllowanceCharge) {
		this.m_AllowanceCharge = m_AllowanceCharge;
	}

	public DeliveryUnit getM_DeliveryUnit() {
		return m_DeliveryUnit;
	}

	public void setM_DeliveryUnit(DeliveryUnit m_DeliveryUnit) {
		this.m_DeliveryUnit = m_DeliveryUnit;
	}

	public DependentPriceReference getM_DependentPriceReference() {
		return m_DependentPriceReference;
	}

	public void setM_DependentPriceReference(DependentPriceReference m_DependentPriceReference) {
		this.m_DependentPriceReference = m_DependentPriceReference;
	}

	public Package getM_Package() {
		return m_Package;
	}

	public void setM_Package(Package m_Package) {
		this.m_Package = m_Package;
	}

	public Price getM_Price() {
		return m_Price;
	}

	public void setM_Price(Price m_Price) {
		this.m_Price = m_Price;
	}

	public TaxCategory getApplicableTaxCategory() {
		return applicableTaxCategory;
	}

	public void setApplicableTaxCategory(TaxCategory applicableTaxCategory) {
		this.applicableTaxCategory = applicableTaxCategory;
	}
}// end ItemLocationQuantity
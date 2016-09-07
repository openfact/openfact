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
	private List<DeliveryUnit> deliveryUnits=new ArrayList<>();
	private List<DependentPriceReference> dependentPriceReferences=new ArrayList<>();
	private List<Package> packages=new ArrayList<>();
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

	public List<AllowanceCharge> getAllowanceCharges() {
		return allowanceCharges;
	}

	public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
		this.allowanceCharges = allowanceCharges;
	}

	public List<DeliveryUnit> getDeliveryUnits() {
		return deliveryUnits;
	}

	public void setDeliveryUnits(List<DeliveryUnit> deliveryUnits) {
		this.deliveryUnits = deliveryUnits;
	}

	public List<DependentPriceReference> getDependentPriceReferences() {
		return dependentPriceReferences;
	}

	public void setDependentPriceReferences(List<DependentPriceReference> dependentPriceReferences) {
		this.dependentPriceReferences = dependentPriceReferences;
	}

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	public List<Price> getPrices() {
		return prices;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public TaxCategory getApplicableTaxCategory() {
		return applicableTaxCategory;
	}

	public void setApplicableTaxCategory(TaxCategory applicableTaxCategory) {
		this.applicableTaxCategory = applicableTaxCategory;
	}
}// end ItemLocationQuantity
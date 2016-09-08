package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a price, expressed in a data structure containing
 * multiple properties (compare with UnstructuredPrice).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:52 a. m.
 */
public class Price {

	/**
	 * The quantity at which this price applies.
	 */
	private BigDecimal baseQuantity;
	/**
	 * The factor by which the base price unit can be converted to the orderable
	 * unit.
	 */
	private BigDecimal orderableUnitFactorRate;
	/**
	 * The amount of the price.
	 */
	private BigDecimal priceAmount;
	/**
	 * A reason for a price change.
	 */
	private String priceChangeReason;
	/**
	 * The type of price, expressed as text.
	 */
	private String priceType;
	/**
	 * The type of price, expressed as a code.
	 */
	private String priceTypeCode;
	private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
	private ExchangeRate pricingExchangeRate;
	private Period validityPeriod;
	private List<PriceList> priceLists=new ArrayList<>();

	public Price() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getBaseQuantity() {
		return baseQuantity;
	}

	public void setBaseQuantity(BigDecimal baseQuantity) {
		this.baseQuantity = baseQuantity;
	}

	public BigDecimal getOrderableUnitFactorRate() {
		return orderableUnitFactorRate;
	}

	public void setOrderableUnitFactorRate(BigDecimal orderableUnitFactorRate) {
		this.orderableUnitFactorRate = orderableUnitFactorRate;
	}

	public BigDecimal getPriceAmount() {
		return priceAmount;
	}

	public void setPriceAmount(BigDecimal priceAmount) {
		this.priceAmount = priceAmount;
	}

	public String getPriceChangeReason() {
		return priceChangeReason;
	}

	public void setPriceChangeReason(String priceChangeReason) {
		this.priceChangeReason = priceChangeReason;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getPriceTypeCode() {
		return priceTypeCode;
	}

	public void setPriceTypeCode(String priceTypeCode) {
		this.priceTypeCode = priceTypeCode;
	}

	public List<AllowanceCharge> getAllowanceCharges() {
		return allowanceCharges;
	}

	public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
		this.allowanceCharges = allowanceCharges;
	}

	public ExchangeRate getPricingExchangeRate() {
		return pricingExchangeRate;
	}

	public void setPricingExchangeRate(ExchangeRate pricingExchangeRate) {
		this.pricingExchangeRate = pricingExchangeRate;
	}

	public Period getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Period validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public List<PriceList> getPriceLists() {
		return priceLists;
	}

	public void setPriceLists(List<PriceList> priceLists) {
		this.priceLists = priceLists;
	}
}// end Price
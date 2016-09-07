package org.openfact.models.jpa.entities.ubl;

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
    private BigDecimal BaseQuantity;
    /**
     * The factor by which the base price unit can be converted to the orderable
     * unit.
     */
    private BigDecimal OrderableUnitFactorRate;
    /**
     * The amount of the price.
     */
    private BigDecimal PriceAmount;
    /**
     * A reason for a price change.
     */
    private String PriceChangeReason;
    /**
     * The type of price, expressed as text.
     */
    private String PriceType;
    /**
     * The type of price, expressed as a code.
     */
    private String PriceTypeCode;
    private AllowanceCharge m_AllowanceCharge;
    private ExchangeRate PricingExchangeRate;
    private Period ValidityPeriod;
    private PriceList m_PriceList;

    public Price() {

    }

    public void finalize() throws Throwable {

    }

    public AllowanceCharge getAllowanceCharge() {
        return m_AllowanceCharge;
    }

    public BigDecimal getBaseQuantity() {
        return BaseQuantity;
    }

    public BigDecimal getOrderableUnitFactorRate() {
        return OrderableUnitFactorRate;
    }

    public PriceList getPriceList() {
        return m_PriceList;
    }

    public BigDecimal getPriceAmount() {
        return PriceAmount;
    }

    public String getPriceChangeReason() {
        return PriceChangeReason;
    }

    public String getPriceType() {
        return PriceType;
    }

    public String getPriceTypeCode() {
        return PriceTypeCode;
    }

    public ExchangeRate getPricingExchangeRate() {
        return PricingExchangeRate;
    }

    public Period getValidityPeriod() {
        return ValidityPeriod;
    }

    /**
     * 
     * @param newVal
     */
    public void setAllowanceCharge(AllowanceCharge newVal) {
        m_AllowanceCharge = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setBaseQuantity(BigDecimal newVal) {
        BaseQuantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setOrderableUnitFactorRate(BigDecimal newVal) {
        OrderableUnitFactorRate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPriceList(PriceList newVal) {
        m_PriceList = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPriceAmount(BigDecimal newVal) {
        PriceAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPriceChangeReason(String newVal) {
        PriceChangeReason = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPriceType(String newVal) {
        PriceType = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPriceTypeCode(String newVal) {
        PriceTypeCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPricingExchangeRate(ExchangeRate newVal) {
        PricingExchangeRate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setValidityPeriod(Period newVal) {
        ValidityPeriod = newVal;
    }
}// end Price
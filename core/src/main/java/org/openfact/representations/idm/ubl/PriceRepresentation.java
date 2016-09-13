package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.RateRepresentation;

/**
 * A class to describe a price, expressed in a data structure containing
 * multiple properties (compare with UnstructuredPrice).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:52 a. m.
 */
public class PriceRepresentation {

    /**
     * The quantity at which this price applies.
     */
    private QuantityRepresentation baseQuantity;
    /**
     * The factor by which the base price unit can be converted to the orderable
     * unit.
     */
    private RateRepresentation orderableUnitFactorRate;
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
    private CodeRepresentation priceTypeCode;
    private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>();
    private ExchangeRateRepresentation pricingExchangeRate;
    private PeriodRepresentation validityPeriod;
    private List<PriceListRepresentation> priceLists = new ArrayList<>();

    /**
     * @return the baseQuantity
     */
    public QuantityRepresentation getBaseQuantity() {
        return baseQuantity;
    }

    /**
     * @param baseQuantity
     *            the baseQuantity to set
     */
    public void setBaseQuantity(QuantityRepresentation baseQuantity) {
        this.baseQuantity = baseQuantity;
    }

    /**
     * @return the orderableUnitFactorRate
     */
    public RateRepresentation getOrderableUnitFactorRate() {
        return orderableUnitFactorRate;
    }

    /**
     * @param orderableUnitFactorRate
     *            the orderableUnitFactorRate to set
     */
    public void setOrderableUnitFactorRate(RateRepresentation orderableUnitFactorRate) {
        this.orderableUnitFactorRate = orderableUnitFactorRate;
    }

    /**
     * @return the priceAmount
     */
    public BigDecimal getPriceAmount() {
        return priceAmount;
    }

    /**
     * @param priceAmount
     *            the priceAmount to set
     */
    public void setPriceAmount(BigDecimal priceAmount) {
        this.priceAmount = priceAmount;
    }

    /**
     * @return the priceChangeReason
     */
    public String getPriceChangeReason() {
        return priceChangeReason;
    }

    /**
     * @param priceChangeReason
     *            the priceChangeReason to set
     */
    public void setPriceChangeReason(String priceChangeReason) {
        this.priceChangeReason = priceChangeReason;
    }

    /**
     * @return the priceType
     */
    public String getPriceType() {
        return priceType;
    }

    /**
     * @param priceType
     *            the priceType to set
     */
    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    /**
     * @return the priceTypeCode
     */
    public CodeRepresentation getPriceTypeCode() {
        return priceTypeCode;
    }

    /**
     * @param priceTypeCode
     *            the priceTypeCode to set
     */
    public void setPriceTypeCode(CodeRepresentation priceTypeCode) {
        this.priceTypeCode = priceTypeCode;
    }

    /**
     * @return the allowanceCharges
     */
    public List<AllowanceChargeRepresentation> getAllowanceCharges() {
        return allowanceCharges;
    }

    /**
     * @param allowanceCharges
     *            the allowanceCharges to set
     */
    public void setAllowanceCharges(List<AllowanceChargeRepresentation> allowanceCharges) {
        this.allowanceCharges = allowanceCharges;
    }

    /**
     * @return the pricingExchangeRate
     */
    public ExchangeRateRepresentation getPricingExchangeRate() {
        return pricingExchangeRate;
    }

    /**
     * @param pricingExchangeRate
     *            the pricingExchangeRate to set
     */
    public void setPricingExchangeRate(ExchangeRateRepresentation pricingExchangeRate) {
        this.pricingExchangeRate = pricingExchangeRate;
    }

    /**
     * @return the validityPeriod
     */
    public PeriodRepresentation getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * @param validityPeriod
     *            the validityPeriod to set
     */
    public void setValidityPeriod(PeriodRepresentation validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    /**
     * @return the priceLists
     */
    public List<PriceListRepresentation> getPriceLists() {
        return priceLists;
    }

    /**
     * @param priceLists
     *            the priceLists to set
     */
    public void setPriceLists(List<PriceListRepresentation> priceLists) {
        this.priceLists = priceLists;
    }

}

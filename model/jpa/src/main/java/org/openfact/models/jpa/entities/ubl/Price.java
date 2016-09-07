package org.openfact.models.jpa.entities.ubl;

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
    private Quantity.Type BaseQuantity;
    /**
     * The factor by which the base price unit can be converted to the orderable
     * unit.
     */
    private Rate.Type OrderableUnitFactorRate;
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
    private AllowanceCharge
    m_AllowanceCharge;
    private ExchangeRate
    Pricing ExchangeRate;
    private Period Validity Period;
    private Price List
    m_Price List;

    public Price() {

    }

    public void finalize() throws Throwable {

    }

    public AllowanceCharge

    getAllowanceCharge(){
		return m_AllowanceCharge;
	}

    public Quantity.Type getBaseQuantity() {
        return BaseQuantity;
    }

    public Rate.Type getOrderableUnitFactorRate() {
        return OrderableUnitFactorRate;
    }

    public Price List

    getPrice List(){
		return m_Price List;
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

    public ExchangeRate
    getPricing Exchange

    Rate(){
		return Pricing ExchangeRate;
	}

    public Period getValidity

    Period(){
		return Validity Period;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setAllowance

    Charge(AllowanceCharge newVal){
		m_AllowanceCharge = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setBaseQuantity(Quantity.Type newVal) {
        BaseQuantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setOrderableUnitFactorRate(Rate.Type newVal) {
        OrderableUnitFactorRate = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setPrice

    List(Price List newVal){
		m_Price List = newVal;
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
	public void setPricing

    ExchangeRate(ExchangeRate newVal){
		Pricing ExchangeRate = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setValidity

    Period(Period newVal){
		Validity Period = newVal;
	}
}// end Price
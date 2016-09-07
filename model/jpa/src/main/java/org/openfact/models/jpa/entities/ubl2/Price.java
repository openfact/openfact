package org.openfact.models.jpa.entities.ubl2;


/**
 * A class to describe a price, expressed in a data structure containing multiple
 * properties (compare with UnstructuredPrice).
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:52 a. m.
 */
public class Price {

	/**
	 * The quantity at which this price applies.
	 */
	private Quantity. Type BaseQuantity;
	/**
	 * The factor by which the base price unit can be converted to the orderable unit.
	 */
	private Rate. Type OrderableUnitFactorRate;
	/**
	 * The amount of the price.
	 */
	private Amount. Type PriceAmount;
	/**
	 * A reason for a price change.
	 */
	private Text. Type PriceChangeReason;
	/**
	 * The type of price, expressed as text.
	 */
	private Text. Type PriceType;
	/**
	 * The type of price, expressed as a code.
	 */
	private Code. Type PriceTypeCode;
	private Allowance Charge m_Allowance Charge;
	private Exchange Rate Pricing Exchange Rate;
	private Period Validity Period;
	private Price List m_Price List;

	public Price(){

	}

	public void finalize() throws Throwable {

	}
	public Allowance Charge getAllowance Charge(){
		return m_Allowance Charge;
	}

	public Quantity. Type getBaseQuantity(){
		return BaseQuantity;
	}

	public Rate. Type getOrderableUnitFactorRate(){
		return OrderableUnitFactorRate;
	}

	public Price List getPrice List(){
		return m_Price List;
	}

	public Amount. Type getPriceAmount(){
		return PriceAmount;
	}

	public Text. Type getPriceChangeReason(){
		return PriceChangeReason;
	}

	public Text. Type getPriceType(){
		return PriceType;
	}

	public Code. Type getPriceTypeCode(){
		return PriceTypeCode;
	}

	public Exchange Rate getPricing Exchange Rate(){
		return Pricing Exchange Rate;
	}

	public Period getValidity Period(){
		return Validity Period;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAllowance Charge(Allowance Charge newVal){
		m_Allowance Charge = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBaseQuantity(Quantity. Type newVal){
		BaseQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrderableUnitFactorRate(Rate. Type newVal){
		OrderableUnitFactorRate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrice List(Price List newVal){
		m_Price List = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPriceAmount(Amount. Type newVal){
		PriceAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPriceChangeReason(Text. Type newVal){
		PriceChangeReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPriceType(Text. Type newVal){
		PriceType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPriceTypeCode(Code. Type newVal){
		PriceTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPricing Exchange Rate(Exchange Rate newVal){
		Pricing Exchange Rate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidity Period(Period newVal){
		Validity Period = newVal;
	}
}//end Price
package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a price extension, calculated by multiplying the price per
 * unit by the quantity of items.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:54 a. m.
 */
public class PriceExtension {

	/**
	 * The amount of this price extension.
	 */
	private BigDecimal Amount;
	private Tax Total m_Tax Total;

	public Price Extension(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getAmount(){
		return Amount;
	}

	public Tax Total getTax Total(){
		return m_Tax Total;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmount(BigDecimal newVal){
		Amount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Total(Tax Total newVal){
		m_Tax Total = newVal;
	}
}//end Price Extension
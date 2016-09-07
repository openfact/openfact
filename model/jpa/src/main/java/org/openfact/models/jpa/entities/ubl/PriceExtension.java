package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a price extension, calculated by multiplying the price
 * per unit by the quantity of items.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:54 a. m.
 */
public class PriceExtension {

	/**
	 * The amount of this price extension.
	 */
	private BigDecimal Amount;
	private TaxTotal m_TaxTotal;

	public PriceExtension() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getAmount() {
		return Amount;
	}

	public TaxTotal getTaxTotal() {
		return m_TaxTotal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmount(BigDecimal newVal) {
		Amount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxTotal(TaxTotal newVal) {
		m_TaxTotal = newVal;
	}
}// end Price Extension
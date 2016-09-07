package org.openfact.models.jpa.entities.ubl;


import java.math.BigDecimal;

/**
 * A class to describe energy taxes.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:47 a. m.
 */
public class EnergyTaxReport {

	/**
	 * The monetary amount of taxes (and duties).
	 */
	private BigDecimal taxEnergyAmount;
	/**
	 * The monetary amount of the balance of taxes owing.
	 */
	private BigDecimal taxEnergyBalanceAmount;
	/**
	 * The monetary amount of taxes (and duties) paid on account.
	 */
	private BigDecimal taxEnergyOnAccountAmount;
	private TaxScheme m_TaxScheme;

	public BigDecimal getTaxEnergyAmount() {
		return taxEnergyAmount;
	}

	public void setTaxEnergyAmount(BigDecimal taxEnergyAmount) {
		this.taxEnergyAmount = taxEnergyAmount;
	}

	public BigDecimal getTaxEnergyBalanceAmount() {
		return taxEnergyBalanceAmount;
	}

	public void setTaxEnergyBalanceAmount(BigDecimal taxEnergyBalanceAmount) {
		this.taxEnergyBalanceAmount = taxEnergyBalanceAmount;
	}

	public BigDecimal getTaxEnergyOnAccountAmount() {
		return taxEnergyOnAccountAmount;
	}

	public void setTaxEnergyOnAccountAmount(BigDecimal taxEnergyOnAccountAmount) {
		this.taxEnergyOnAccountAmount = taxEnergyOnAccountAmount;
	}

	public TaxScheme getM_TaxScheme() {
		return m_TaxScheme;
	}

	public void setM_TaxScheme(TaxScheme m_TaxScheme) {
		this.m_TaxScheme = m_TaxScheme;
	}
}//end Energy Tax Report
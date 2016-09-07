package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe energy taxes.
 * 
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
	private List<TaxScheme> TaxSchemes=new ArrayList<>();

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

	public List<TaxScheme> getTaxSchemes() {
		return TaxSchemes;
	}

	public void setTaxSchemes(List<TaxScheme> taxSchemes) {
		TaxSchemes = taxSchemes;
	}
}// end Energy Tax Report
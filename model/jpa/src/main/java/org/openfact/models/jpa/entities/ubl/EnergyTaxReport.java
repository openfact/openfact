package org.openfact.models.jpa.entities.ubl;


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
	private BigDecimal TaxEnergyAmount;
	/**
	 * The monetary amount of the balance of taxes owing.
	 */
	private BigDecimal TaxEnergyBalanceAmount;
	/**
	 * The monetary amount of taxes (and duties) paid on account.
	 */
	private BigDecimal TaxEnergyOnAccountAmount;
	private Tax Scheme m_Tax Scheme;

	public Energy Tax Report(){

	}

	public void finalize() throws Throwable {

	}
	public Tax Scheme getTax Scheme(){
		return m_Tax Scheme;
	}

	public BigDecimal getTaxEnergyAmount(){
		return TaxEnergyAmount;
	}

	public BigDecimal getTaxEnergyBalanceAmount(){
		return TaxEnergyBalanceAmount;
	}

	public BigDecimal getTaxEnergyOnAccountAmount(){
		return TaxEnergyOnAccountAmount;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Scheme(Tax Scheme newVal){
		m_Tax Scheme = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxEnergyAmount(BigDecimal newVal){
		TaxEnergyAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxEnergyBalanceAmount(BigDecimal newVal){
		TaxEnergyBalanceAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxEnergyOnAccountAmount(BigDecimal newVal){
		TaxEnergyOnAccountAmount = newVal;
	}
}//end Energy Tax Report
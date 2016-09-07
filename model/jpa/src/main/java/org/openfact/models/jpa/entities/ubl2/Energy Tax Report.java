

/**
 * A class to describe energy taxes.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:47 a. m.
 */
public class Energy Tax Report {

	/**
	 * The monetary amount of taxes (and duties).
	 */
	private Amount. Type TaxEnergyAmount;
	/**
	 * The monetary amount of the balance of taxes owing.
	 */
	private Amount. Type TaxEnergyBalanceAmount;
	/**
	 * The monetary amount of taxes (and duties) paid on account.
	 */
	private Amount. Type TaxEnergyOnAccountAmount;
	private Tax Scheme m_Tax Scheme;

	public Energy Tax Report(){

	}

	public void finalize() throws Throwable {

	}
	public Tax Scheme getTax Scheme(){
		return m_Tax Scheme;
	}

	public Amount. Type getTaxEnergyAmount(){
		return TaxEnergyAmount;
	}

	public Amount. Type getTaxEnergyBalanceAmount(){
		return TaxEnergyBalanceAmount;
	}

	public Amount. Type getTaxEnergyOnAccountAmount(){
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
	public void setTaxEnergyAmount(Amount. Type newVal){
		TaxEnergyAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxEnergyBalanceAmount(Amount. Type newVal){
		TaxEnergyBalanceAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxEnergyOnAccountAmount(Amount. Type newVal){
		TaxEnergyOnAccountAmount = newVal;
	}
}//end Energy Tax Report
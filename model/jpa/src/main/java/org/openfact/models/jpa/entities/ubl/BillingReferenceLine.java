package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a reference to a transaction line in a billing document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:09 a. m.
 */
public class BillingReferenceLine {

	/**
	 * The monetary amount of the transaction line, including any allowances and
	 * charges but excluding taxes.
	 */
	private BigDecimal Amount;
	/**
	 * An identifier for this transaction line in a billing document.
	 */
	private String ID;
	private Allowance Charge m_Allowance Charge;

	public Billing Reference Line(){

	}

	public void finalize() throws Throwable {

	}
	public Allowance Charge getAllowance Charge(){
		return m_Allowance Charge;
	}

	public BigDecimal getAmount(){
		return Amount;
	}

	public String getID(){
		return ID;
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
	public void setAmount(BigDecimal newVal){
		Amount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}
}//end Billing Reference Line
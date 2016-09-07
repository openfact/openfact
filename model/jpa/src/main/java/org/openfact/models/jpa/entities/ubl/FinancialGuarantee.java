package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe the bond guarantee of a tenderer or bid submitter's actual
 * entry into a contract in the event that it is the successful bidder.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:13 a. m.
 */
public class FinancialGuarantee {

	/**
	 * The rate used to calculate the amount of liability in this financial guarantee.
	 */
	private Rate. Type AmountRate;
	/**
	 * Text describing this financial guarantee.
	 */
	private String Description;
	/**
	 * A code signifying the type of financial guarantee. For instance "Provisional
	 * Guarantee" or "Final Guarantee"
	 */
	private String GuaranteeTypeCode;
	/**
	 * The amount of liability in this financial guarantee.
	 */
	private BigDecimal LiabilityAmount;
	private Period Constitution Period;

	public Financial Guarantee(){

	}

	public void finalize() throws Throwable {

	}
	public Rate. Type getAmountRate(){
		return AmountRate;
	}

	public Period getConstitution Period(){
		return Constitution Period;
	}

	public String getDescription(){
		return Description;
	}

	public String getGuaranteeTypeCode(){
		return GuaranteeTypeCode;
	}

	public BigDecimal getLiabilityAmount(){
		return LiabilityAmount;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmountRate(Rate. Type newVal){
		AmountRate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConstitution Period(Period newVal){
		Constitution Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGuaranteeTypeCode(String newVal){
		GuaranteeTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLiabilityAmount(BigDecimal newVal){
		LiabilityAmount = newVal;
	}
}//end Financial Guarantee
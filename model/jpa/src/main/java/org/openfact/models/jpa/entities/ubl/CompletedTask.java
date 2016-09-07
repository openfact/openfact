package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe the completion of a specific task in the tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:40 a. m.
 */
public class CompletedTask {

	/**
	 * The average monetary amount of a task such as this completed task.
	 */
	private BigDecimal AnnualAverageAmount;
	/**
	 * Text describing this completed task.
	 */
	private String Description;
	/**
	 * A monetary amount corresponding to the financial capacity of the party that
	 * carried out this completed task.
	 */
	private BigDecimal PartyCapacityAmount;
	/**
	 * The actual total monetary amount of this completed task.
	 */
	private BigDecimal TotalTaskAmount;
	private Customer Party Recipient Customer Party;
	private Evidence Supplied m_Evidence Supplied;
	private Period m_Period;

	public Completed Task(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getAnnualAverageAmount(){
		return AnnualAverageAmount;
	}

	public String getDescription(){
		return Description;
	}

	public Evidence Supplied getEvidence Supplied(){
		return m_Evidence Supplied;
	}

	public BigDecimal getPartyCapacityAmount(){
		return PartyCapacityAmount;
	}

	public Period getPeriod(){
		return m_Period;
	}

	public Customer Party getRecipient Customer Party(){
		return Recipient Customer Party;
	}

	public BigDecimal getTotalTaskAmount(){
		return TotalTaskAmount;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAnnualAverageAmount(BigDecimal newVal){
		AnnualAverageAmount = newVal;
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
	public void setEvidence Supplied(Evidence Supplied newVal){
		m_Evidence Supplied = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPartyCapacityAmount(BigDecimal newVal){
		PartyCapacityAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPeriod(Period newVal){
		m_Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRecipient Customer Party(Customer Party newVal){
		Recipient Customer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalTaskAmount(BigDecimal newVal){
		TotalTaskAmount = newVal;
	}
}//end Completed Task
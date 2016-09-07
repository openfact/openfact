

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
	private Amount. Type AnnualAverageAmount;
	/**
	 * Text describing this completed task.
	 */
	private Text. Type Description;
	/**
	 * A monetary amount corresponding to the financial capacity of the party that
	 * carried out this completed task.
	 */
	private Amount. Type PartyCapacityAmount;
	/**
	 * The actual total monetary amount of this completed task.
	 */
	private Amount. Type TotalTaskAmount;
	private Customer Party Recipient Customer Party;
	private Evidence Supplied m_Evidence Supplied;
	private Period m_Period;

	public Completed Task(){

	}

	public void finalize() throws Throwable {

	}
	public Amount. Type getAnnualAverageAmount(){
		return AnnualAverageAmount;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Evidence Supplied getEvidence Supplied(){
		return m_Evidence Supplied;
	}

	public Amount. Type getPartyCapacityAmount(){
		return PartyCapacityAmount;
	}

	public Period getPeriod(){
		return m_Period;
	}

	public Customer Party getRecipient Customer Party(){
		return Recipient Customer Party;
	}

	public Amount. Type getTotalTaskAmount(){
		return TotalTaskAmount;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAnnualAverageAmount(Amount. Type newVal){
		AnnualAverageAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(Text. Type newVal){
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
	public void setPartyCapacityAmount(Amount. Type newVal){
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
	public void setTotalTaskAmount(Amount. Type newVal){
		TotalTaskAmount = newVal;
	}
}//end Completed Task
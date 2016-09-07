package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a power of attorney.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:51 a. m.
 */
public class PowerOfAttorney {

	/**
	 * Text describing this power of attorney.
	 */
	private Text. Type Description;
	/**
	 * An identifier for this power of attorney.
	 */
	private Identifier. Type ID;
	/**
	 * The date on which this power of attorney was issued.
	 */
	private Date. Type IssueDate;
	/**
	 * The time at which this power of attorney was issued.
	 */
	private Time. Type IssueTime;
	private Document Reference Mandate Document Reference;
	private Party Agent Party;
	private Party Notary Party;
	private Party Witness Party;

	public Power Of Attorney(){

	}

	public void finalize() throws Throwable {

	}
	public Party getAgent Party(){
		return Agent Party;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Date. Type getIssueDate(){
		return IssueDate;
	}

	public Time. Type getIssueTime(){
		return IssueTime;
	}

	public Document Reference getMandate Document Reference(){
		return Mandate Document Reference;
	}

	public Party getNotary Party(){
		return Notary Party;
	}

	public Party getWitness Party(){
		return Witness Party;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAgent Party(Party newVal){
		Agent Party = newVal;
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
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(Date. Type newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(Time. Type newVal){
		IssueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMandate Document Reference(Document Reference newVal){
		Mandate Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNotary Party(Party newVal){
		Notary Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWitness Party(Party newVal){
		Witness Party = newVal;
	}
}//end Power Of Attorney
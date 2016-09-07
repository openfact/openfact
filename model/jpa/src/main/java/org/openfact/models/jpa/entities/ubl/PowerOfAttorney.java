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
	private String Description;
	/**
	 * An identifier for this power of attorney.
	 */
	private String ID;
	/**
	 * The date on which this power of attorney was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time at which this power of attorney was issued.
	 */
	private LocalTime IssueTime;
	private DocumentReference Mandate DocumentReference;
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

	public String getDescription(){
		return Description;
	}

	public String getID(){
		return ID;
	}

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public LocalTime getIssueTime(){
		return IssueTime;
	}

	public DocumentReference getMandate DocumentReference(){
		return Mandate DocumentReference;
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
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(LocalDate newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(LocalTime newVal){
		IssueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMandate DocumentReference(DocumentReference newVal){
		Mandate DocumentReference = newVal;
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
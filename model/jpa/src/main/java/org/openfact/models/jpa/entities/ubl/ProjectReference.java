package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a reference to a procurement project.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:07 a. m.
 */
public class ProjectReference {

	/**
	 * An identifier for the referenced project.
	 */
	private String ID;
	/**
	 * The date on which the referenced project was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * A universally unique identifier for the referenced project.
	 */
	private String UUID;
	private Work Phase Reference m_Work Phase Reference;

	public Project Reference(){

	}

	public void finalize() throws Throwable {

	}
	public String getID(){
		return ID;
	}

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public String getUUID(){
		return UUID;
	}

	public Work Phase Reference getWork Phase Reference(){
		return m_Work Phase Reference;
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
	public void setUUID(String newVal){
		UUID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWork Phase Reference(Work Phase Reference newVal){
		m_Work Phase Reference = newVal;
	}
}//end Project Reference
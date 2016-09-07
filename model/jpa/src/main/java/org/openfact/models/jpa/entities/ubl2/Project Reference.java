

/**
 * A class to define a reference to a procurement project.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:07 a. m.
 */
public class Project Reference {

	/**
	 * An identifier for the referenced project.
	 */
	private Identifier. Type ID;
	/**
	 * The date on which the referenced project was issued.
	 */
	private Date. Type IssueDate;
	/**
	 * A universally unique identifier for the referenced project.
	 */
	private Identifier. Type UUID;
	private Work Phase Reference m_Work Phase Reference;

	public Project Reference(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getID(){
		return ID;
	}

	public Date. Type getIssueDate(){
		return IssueDate;
	}

	public Identifier. Type getUUID(){
		return UUID;
	}

	public Work Phase Reference getWork Phase Reference(){
		return m_Work Phase Reference;
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
	public void setUUID(Identifier. Type newVal){
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
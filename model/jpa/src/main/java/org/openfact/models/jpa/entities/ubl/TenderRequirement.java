package org.openfact.models.jpa.entities.ubl;


/**
 * A template for a required document in a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:17 a. m.
 */
public class TenderRequirement {

	/**
	 * Text describing this tender requirement.
	 */
	private String Description;
	/**
	 * A name of this tender requirement.
	 */
	private String Name;
	private DocumentReference Template DocumentReference;

	public Tender Requirement(){

	}

	public void finalize() throws Throwable {

	}
	public String getDescription(){
		return Description;
	}

	public String getName(){
		return Name;
	}

	public DocumentReference getTemplate DocumentReference(){
		return Template DocumentReference;
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
	public void setName(String newVal){
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTemplate DocumentReference(DocumentReference newVal){
		Template DocumentReference = newVal;
	}
}//end Tender Requirement
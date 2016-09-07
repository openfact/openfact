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
	private Text. Type Description;
	/**
	 * A name of this tender requirement.
	 */
	private Name. Type Name;
	private Document Reference Template Document Reference;

	public Tender Requirement(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getDescription(){
		return Description;
	}

	public Name. Type getName(){
		return Name;
	}

	public Document Reference getTemplate Document Reference(){
		return Template Document Reference;
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
	public void setName(Name. Type newVal){
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTemplate Document Reference(Document Reference newVal){
		Template Document Reference = newVal;
	}
}//end Tender Requirement
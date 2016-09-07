package org.openfact.models.jpa.entities.ubl2;


/**
 * A class to define a clause (a distinct article or provision) in a contract,
 * treaty, will, or other formal or legal written document requiring compliance.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:35 a. m.
 */
public class Clause {

	/**
	 * The text of this clause.
	 */
	private Text. Type Content;
	/**
	 * An identifier for this clause.
	 */
	private Identifier. Type ID;

	public Clause(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getContent(){
		return Content;
	}

	public Identifier. Type getID(){
		return ID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContent(Text. Type newVal){
		Content = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}
}//end Clause
package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe purchasing, sales, or payment conditions.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:35 a. m.
 */
public class TransactionConditions {

	/**
	 * A code signifying a type of action relating to sales or payment conditions.
	 */
	private String ActionCode;
	/**
	 * Text describing the transaction conditions.
	 */
	private String Description;
	/**
	 * An identifier for conditions of the transaction, typically purchase/sales
	 * conditions.
	 */
	private String ID;
	private Document Reference m_Document Reference;

	public Transaction Conditions(){

	}

	public void finalize() throws Throwable {

	}
	public String getActionCode(){
		return ActionCode;
	}

	public String getDescription(){
		return Description;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public String getID(){
		return ID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActionCode(String newVal){
		ActionCode = newVal;
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
	public void setDocument Reference(Document Reference newVal){
		m_Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}
}//end Transaction Conditions
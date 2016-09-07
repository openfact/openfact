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
	private Code. Type ActionCode;
	/**
	 * Text describing the transaction conditions.
	 */
	private Text. Type Description;
	/**
	 * An identifier for conditions of the transaction, typically purchase/sales
	 * conditions.
	 */
	private Identifier. Type ID;
	private Document Reference m_Document Reference;

	public Transaction Conditions(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getActionCode(){
		return ActionCode;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public Identifier. Type getID(){
		return ID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActionCode(Code. Type newVal){
		ActionCode = newVal;
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
	public void setDocument Reference(Document Reference newVal){
		m_Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}
}//end Transaction Conditions
package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a trade financing instrument.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:31 a. m.
 */
public class TradeFinancing {

	/**
	 * A code signifying the type of this financing instrument.
	 */
	private String FinancingInstrumentCode;
	/**
	 * An identifier for this trade financing instrument.
	 */
	private String ID;
	private Clause m_Clause;
	private Document Reference Contract Document Reference;
	private Document Reference m_Document Reference;
	private Financial Account Financing Financial Account;
	private Party Financing Party;

	public Trade Financing(){

	}

	public void finalize() throws Throwable {

	}
	public Clause getClause(){
		return m_Clause;
	}

	public Document Reference getContract Document Reference(){
		return Contract Document Reference;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public Financial Account getFinancing Financial Account(){
		return Financing Financial Account;
	}

	public Party getFinancing Party(){
		return Financing Party;
	}

	public String getFinancingInstrumentCode(){
		return FinancingInstrumentCode;
	}

	public String getID(){
		return ID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setClause(Clause newVal){
		m_Clause = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContract Document Reference(Document Reference newVal){
		Contract Document Reference = newVal;
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
	public void setFinancing Financial Account(Financial Account newVal){
		Financing Financial Account = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFinancing Party(Party newVal){
		Financing Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFinancingInstrumentCode(String newVal){
		FinancingInstrumentCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}
}//end Trade Financing
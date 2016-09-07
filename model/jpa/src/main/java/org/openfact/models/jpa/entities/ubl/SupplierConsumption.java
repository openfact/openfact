package org.openfact.models.jpa.entities.ubl;


/**
 * The consumption in case the consumption is for one and only one supplier.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:58 a. m.
 */
public class SupplierConsumption {

	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Description;
	private Consumption m_Consumption;
	private Consumption Line m_Consumption Line;
	private Contract m_Contract;
	private Party Utility Customer Party;
	private Party Utility Supplier Party;

	public Supplier Consumption(){

	}

	public void finalize() throws Throwable {

	}
	public Consumption getConsumption(){
		return m_Consumption;
	}

	public Consumption Line getConsumption Line(){
		return m_Consumption Line;
	}

	public Contract getContract(){
		return m_Contract;
	}

	public String getDescription(){
		return Description;
	}

	public Party getUtility Customer Party(){
		return Utility Customer Party;
	}

	public Party getUtility Supplier Party(){
		return Utility Supplier Party;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumption(Consumption newVal){
		m_Consumption = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumption Line(Consumption Line newVal){
		m_Consumption Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContract(Contract newVal){
		m_Contract = newVal;
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
	public void setUtility Customer Party(Party newVal){
		Utility Customer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUtility Supplier Party(Party newVal){
		Utility Supplier Party = newVal;
	}
}//end Supplier Consumption
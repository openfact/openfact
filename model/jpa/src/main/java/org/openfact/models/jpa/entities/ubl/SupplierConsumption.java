package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * The consumption in case the consumption is for one and only one supplier.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:58 a. m.
 */
public class SupplierConsumption {

	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String Description;
	private Consumption m_Consumption;
	private ConsumptionLine m_ConsumptionLine;
	private List<Contract> contracts = new ArrayList<>();
	private Party UtilityCustomerParty;
	private Party UtilitySupplierParty;

	public SupplierConsumption() {

	}

	public void finalize() throws Throwable {

	}

	public Consumption getConsumption() {
		return m_Consumption;
	}

	public ConsumptionLine getConsumptionLine() {
		return m_ConsumptionLine;
	}

	public Contract getContract() {
		return m_Contract;
	}

	public String getDescription() {
		return Description;
	}

	public Party getUtilityCustomerParty() {
		return UtilityCustomerParty;
	}

	public Party getUtilitySupplierParty() {
		return UtilitySupplierParty;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumption(Consumption newVal) {
		m_Consumption = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionLine(ConsumptionLine newVal) {
		m_ConsumptionLine = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContract(Contract newVal) {
		m_Contract = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal) {
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUtilityCustomerParty(Party newVal) {
		UtilityCustomerParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUtilitySupplierParty(Party newVal) {
		UtilitySupplierParty = newVal;
	}
}// end Supplier Consumption
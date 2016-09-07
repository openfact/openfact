package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe the consumption of a utility.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:45 a. m.
 */
public class Consumption {

	/**
	 * A code identifying the type of the Utility Statement required for this
	 * consumption. Explains the kind of utility the statement is about, e.g..
	 * "gas", "electricity", "telephone"
	 */
	private String utilityStatementTypeCode;
	private List<AllowanceCharge> allowanceCharges= new ArrayList<>();
	private List<EnergyWaterSupply> energyWaterSupplies= new ArrayList<>();
	private MonetaryTotal legalMonetaryTotal;
	private Period mainPeriod;
	private List<TaxTotal> taxTotals= new ArrayList<>();
	private List<TelecommunicationsSupply> telecommunicationsSupplys= new ArrayList<>();

	public Consumption() {

	}

	public void finalize() throws Throwable {

	}

	public String getUtilityStatementTypeCode() {
		return utilityStatementTypeCode;
	}

	public void setUtilityStatementTypeCode(String utilityStatementTypeCode) {
		this.utilityStatementTypeCode = utilityStatementTypeCode;
	}

	public List<AllowanceCharge> getAllowanceCharges() {
		return allowanceCharges;
	}

	public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
		this.allowanceCharges = allowanceCharges;
	}

	public List<EnergyWaterSupply> getEnergyWaterSupplies() {
		return energyWaterSupplies;
	}

	public void setEnergyWaterSupplies(List<EnergyWaterSupply> energyWaterSupplies) {
		this.energyWaterSupplies = energyWaterSupplies;
	}

	public MonetaryTotal getLegalMonetaryTotal() {
		return legalMonetaryTotal;
	}

	public void setLegalMonetaryTotal(MonetaryTotal legalMonetaryTotal) {
		this.legalMonetaryTotal = legalMonetaryTotal;
	}

	public Period getMainPeriod() {
		return mainPeriod;
	}

	public void setMainPeriod(Period mainPeriod) {
		this.mainPeriod = mainPeriod;
	}

	public List<TaxTotal> getTaxTotals() {
		return taxTotals;
	}

	public void setTaxTotals(List<TaxTotal> taxTotals) {
		this.taxTotals = taxTotals;
	}

	public List<TelecommunicationsSupply> getTelecommunicationsSupplys() {
		return telecommunicationsSupplys;
	}

	public void setTelecommunicationsSupplys(List<TelecommunicationsSupply> telecommunicationsSupplys) {
		this.telecommunicationsSupplys = telecommunicationsSupplys;
	}
}// end Consumption
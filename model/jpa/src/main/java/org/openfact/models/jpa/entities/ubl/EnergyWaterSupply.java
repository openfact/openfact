package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe the supply (and therefore consumption) of an amount of
 * energy or water.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:49 a. m.
 */
public class EnergyWaterSupply {

	private List<ConsumptionAverage> consumptionAverages=new ArrayList<>();
	private ConsumptionCorrection energyWaterConsumptionCorrection;
	private List<ConsumptionReport> consumptionReports=new ArrayList<>();
	private List<EnergyTaxReport> energyTaxReports=new ArrayList<>();

	public List<ConsumptionAverage> getConsumptionAverages() {
		return consumptionAverages;
	}

	public void setConsumptionAverages(List<ConsumptionAverage> consumptionAverages) {
		this.consumptionAverages = consumptionAverages;
	}

	public ConsumptionCorrection getEnergyWaterConsumptionCorrection() {
		return energyWaterConsumptionCorrection;
	}

	public void setEnergyWaterConsumptionCorrection(ConsumptionCorrection energyWaterConsumptionCorrection) {
		this.energyWaterConsumptionCorrection = energyWaterConsumptionCorrection;
	}

	public List<ConsumptionReport> getConsumptionReports() {
		return consumptionReports;
	}

	public void setConsumptionReports(List<ConsumptionReport> consumptionReports) {
		this.consumptionReports = consumptionReports;
	}

	public List<EnergyTaxReport> getEnergyTaxReports() {
		return energyTaxReports;
	}

	public void setEnergyTaxReports(List<EnergyTaxReport> energyTaxReports) {
		this.energyTaxReports = energyTaxReports;
	}
}// end Energy Water Supply
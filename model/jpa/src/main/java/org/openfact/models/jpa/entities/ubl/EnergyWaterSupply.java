package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe the supply (and therefore consumption) of an amount of
 * energy or water.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:49 a. m.
 */
public class EnergyWaterSupply {

	private ConsumptionAverage m_ConsumptionAverage;
	private ConsumptionCorrection energyWaterConsumptionCorrection;
	private ConsumptionReport m_ConsumptionReport;

	public EnergyTaxReport getM_EnergyTaxReport() {
		return m_EnergyTaxReport;
	}

	public void setM_EnergyTaxReport(EnergyTaxReport m_EnergyTaxReport) {
		this.m_EnergyTaxReport = m_EnergyTaxReport;
	}

	public ConsumptionAverage getM_ConsumptionAverage() {
		return m_ConsumptionAverage;
	}

	public void setM_ConsumptionAverage(ConsumptionAverage m_ConsumptionAverage) {
		this.m_ConsumptionAverage = m_ConsumptionAverage;
	}

	public ConsumptionCorrection getEnergyWaterConsumptionCorrection() {
		return energyWaterConsumptionCorrection;
	}

	public void setEnergyWaterConsumptionCorrection(ConsumptionCorrection energyWaterConsumptionCorrection) {
		this.energyWaterConsumptionCorrection = energyWaterConsumptionCorrection;
	}

	public ConsumptionReport getM_ConsumptionReport() {
		return m_ConsumptionReport;
	}

	public void setM_ConsumptionReport(ConsumptionReport m_ConsumptionReport) {
		this.m_ConsumptionReport = m_ConsumptionReport;
	}

	private EnergyTaxReport m_EnergyTaxReport;


}//end Energy Water Supply
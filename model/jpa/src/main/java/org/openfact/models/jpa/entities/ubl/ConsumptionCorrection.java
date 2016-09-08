package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * The Statement of correction, for examples heating correction.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:48 a. m.
 */
public class ConsumptionCorrection {

	/**
	 * Statement for the actuel heating correction temperature.
	 */
	private BigDecimal actualTemperatureReductionQuantity;
	/**
	 * Your consumpt for district heating energy.
	 */
	private BigDecimal consumptionEnergyQuantity;
	/**
	 * Your consumpt for district heating water.
	 */
	private BigDecimal consumptionWaterQuantity;
	/**
	 * Your correction for heating correction.
	 */
	private BigDecimal correctionAmount;
	/**
	 * Statement for the correction type.
	 */
	private String correctionType;
	/**
	 * Statement at the code for the correction type.
	 */
	private String correctionTypeCode;
	/**
	 * Correction per MWH per degree C.
	 */
	private BigDecimal correctionUnitAmount;
	/**
	 * Description related to the corrections.
	 */
	private String description;
	/**
	 * Deviation from standard heating correction.
	 */
	private BigDecimal differenceTemperatureReductionQuantity;
	/**
	 * Correction of the gas pressure.
	 */
	private BigDecimal gasPressureQuantity;
	/**
	 * Statement for meter number.
	 */
	private String meterNumber;
	/**
	 * Statement for the standard for heating correction temperature.
	 */
	private BigDecimal normalTemperatureReductionQuantity;

	public ConsumptionCorrection() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getActualTemperatureReductionQuantity() {
		return actualTemperatureReductionQuantity;
	}

	public void setActualTemperatureReductionQuantity(BigDecimal actualTemperatureReductionQuantity) {
		this.actualTemperatureReductionQuantity = actualTemperatureReductionQuantity;
	}

	public BigDecimal getConsumptionEnergyQuantity() {
		return consumptionEnergyQuantity;
	}

	public void setConsumptionEnergyQuantity(BigDecimal consumptionEnergyQuantity) {
		this.consumptionEnergyQuantity = consumptionEnergyQuantity;
	}

	public BigDecimal getConsumptionWaterQuantity() {
		return consumptionWaterQuantity;
	}

	public void setConsumptionWaterQuantity(BigDecimal consumptionWaterQuantity) {
		this.consumptionWaterQuantity = consumptionWaterQuantity;
	}

	public BigDecimal getCorrectionAmount() {
		return correctionAmount;
	}

	public void setCorrectionAmount(BigDecimal correctionAmount) {
		this.correctionAmount = correctionAmount;
	}

	public String getCorrectionType() {
		return correctionType;
	}

	public void setCorrectionType(String correctionType) {
		this.correctionType = correctionType;
	}

	public String getCorrectionTypeCode() {
		return correctionTypeCode;
	}

	public void setCorrectionTypeCode(String correctionTypeCode) {
		this.correctionTypeCode = correctionTypeCode;
	}

	public BigDecimal getCorrectionUnitAmount() {
		return correctionUnitAmount;
	}

	public void setCorrectionUnitAmount(BigDecimal correctionUnitAmount) {
		this.correctionUnitAmount = correctionUnitAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDifferenceTemperatureReductionQuantity() {
		return differenceTemperatureReductionQuantity;
	}

	public void setDifferenceTemperatureReductionQuantity(BigDecimal differenceTemperatureReductionQuantity) {
		this.differenceTemperatureReductionQuantity = differenceTemperatureReductionQuantity;
	}

	public BigDecimal getGasPressureQuantity() {
		return gasPressureQuantity;
	}

	public void setGasPressureQuantity(BigDecimal gasPressureQuantity) {
		this.gasPressureQuantity = gasPressureQuantity;
	}

	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public BigDecimal getNormalTemperatureReductionQuantity() {
		return normalTemperatureReductionQuantity;
	}

	public void setNormalTemperatureReductionQuantity(BigDecimal normalTemperatureReductionQuantity) {
		this.normalTemperatureReductionQuantity = normalTemperatureReductionQuantity;
	}
}// end Consumption Correction
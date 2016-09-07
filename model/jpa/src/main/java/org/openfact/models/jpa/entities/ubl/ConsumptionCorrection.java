package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * The Statement of correction, for examples heating correction.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:48 a. m.
 */
public class ConsumptionCorrection {

	/**
	 * Statement for the actuel heating correction temperature.
	 */
	private BigDecimal ActualTemperatureReductionQuantity;
	/**
	 * Your consumpt for district heating energy.
	 */
	private BigDecimal ConsumptionEnergyQuantity;
	/**
	 * Your consumpt for district heating water.
	 */
	private BigDecimal ConsumptionWaterQuantity;
	/**
	 * Your correction for heating correction.
	 */
	private BigDecimal CorrectionAmount;
	/**
	 * Statement for the correction type.
	 */
	private String CorrectionType;
	/**
	 * Statement at the code for the correction type.
	 */
	private String CorrectionTypeCode;
	/**
	 * Correction per MWH per degree C.
	 */
	private BigDecimal CorrectionUnitAmount;
	/**
	 * Description related to the corrections.
	 */
	private String Description;
	/**
	 * Deviation from standard heating correction.
	 */
	private BigDecimal DifferenceTemperatureReductionQuantity;
	/**
	 * Correction of the gas pressure.
	 */
	private BigDecimal GasPressureQuantity;
	/**
	 * Statement for meter number.
	 */
	private String MeterNumber;
	/**
	 * Statement for the standard for heating correction temperature.
	 */
	private BigDecimal NormalTemperatureReductionQuantity;

	public ConsumptionCorrection(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getActualTemperatureReductionQuantity(){
		return ActualTemperatureReductionQuantity;
	}

	public BigDecimal getConsumptionEnergyQuantity(){
		return ConsumptionEnergyQuantity;
	}

	public BigDecimal getConsumptionWaterQuantity(){
		return ConsumptionWaterQuantity;
	}

	public BigDecimal getCorrectionAmount(){
		return CorrectionAmount;
	}

	public String getCorrectionType(){
		return CorrectionType;
	}

	public String getCorrectionTypeCode(){
		return CorrectionTypeCode;
	}

	public BigDecimal getCorrectionUnitAmount(){
		return CorrectionUnitAmount;
	}

	public String getDescription(){
		return Description;
	}

	public BigDecimal getDifferenceTemperatureReductionQuantity(){
		return DifferenceTemperatureReductionQuantity;
	}

	public BigDecimal getGasPressureQuantity(){
		return GasPressureQuantity;
	}

	public String getMeterNumber(){
		return MeterNumber;
	}

	public BigDecimal getNormalTemperatureReductionQuantity(){
		return NormalTemperatureReductionQuantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActualTemperatureReductionQuantity(BigDecimal newVal){
		ActualTemperatureReductionQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionEnergyQuantity(BigDecimal newVal){
		ConsumptionEnergyQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionWaterQuantity(BigDecimal newVal){
		ConsumptionWaterQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCorrectionAmount(BigDecimal newVal){
		CorrectionAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCorrectionType(String newVal){
		CorrectionType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCorrectionTypeCode(String newVal){
		CorrectionTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCorrectionUnitAmount(BigDecimal newVal){
		CorrectionUnitAmount = newVal;
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
	public void setDifferenceTemperatureReductionQuantity(BigDecimal newVal){
		DifferenceTemperatureReductionQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGasPressureQuantity(BigDecimal newVal){
		GasPressureQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMeterNumber(String newVal){
		MeterNumber = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNormalTemperatureReductionQuantity(BigDecimal newVal){
		NormalTemperatureReductionQuantity = newVal;
	}
}//end Consumption Correction


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
	private Quantity. Type ActualTemperatureReductionQuantity;
	/**
	 * Your consumpt for district heating energy.
	 */
	private Quantity. Type ConsumptionEnergyQuantity;
	/**
	 * Your consumpt for district heating water.
	 */
	private Quantity. Type ConsumptionWaterQuantity;
	/**
	 * Your correction for heating correction.
	 */
	private Amount. Type CorrectionAmount;
	/**
	 * Statement for the correction type.
	 */
	private Text. Type CorrectionType;
	/**
	 * Statement at the code for the correction type.
	 */
	private Code. Type CorrectionTypeCode;
	/**
	 * Correction per MWH per degree C.
	 */
	private Amount. Type CorrectionUnitAmount;
	/**
	 * Description related to the corrections.
	 */
	private Text. Type Description;
	/**
	 * Deviation from standard heating correction.
	 */
	private Quantity. Type DifferenceTemperatureReductionQuantity;
	/**
	 * Correction of the gas pressure.
	 */
	private Quantity. Type GasPressureQuantity;
	/**
	 * Statement for meter number.
	 */
	private Text. Type MeterNumber;
	/**
	 * Statement for the standard for heating correction temperature.
	 */
	private Quantity. Type NormalTemperatureReductionQuantity;

	public Consumption Correction(){

	}

	public void finalize() throws Throwable {

	}
	public Quantity. Type getActualTemperatureReductionQuantity(){
		return ActualTemperatureReductionQuantity;
	}

	public Quantity. Type getConsumptionEnergyQuantity(){
		return ConsumptionEnergyQuantity;
	}

	public Quantity. Type getConsumptionWaterQuantity(){
		return ConsumptionWaterQuantity;
	}

	public Amount. Type getCorrectionAmount(){
		return CorrectionAmount;
	}

	public Text. Type getCorrectionType(){
		return CorrectionType;
	}

	public Code. Type getCorrectionTypeCode(){
		return CorrectionTypeCode;
	}

	public Amount. Type getCorrectionUnitAmount(){
		return CorrectionUnitAmount;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Quantity. Type getDifferenceTemperatureReductionQuantity(){
		return DifferenceTemperatureReductionQuantity;
	}

	public Quantity. Type getGasPressureQuantity(){
		return GasPressureQuantity;
	}

	public Text. Type getMeterNumber(){
		return MeterNumber;
	}

	public Quantity. Type getNormalTemperatureReductionQuantity(){
		return NormalTemperatureReductionQuantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActualTemperatureReductionQuantity(Quantity. Type newVal){
		ActualTemperatureReductionQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionEnergyQuantity(Quantity. Type newVal){
		ConsumptionEnergyQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionWaterQuantity(Quantity. Type newVal){
		ConsumptionWaterQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCorrectionAmount(Amount. Type newVal){
		CorrectionAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCorrectionType(Text. Type newVal){
		CorrectionType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCorrectionTypeCode(Code. Type newVal){
		CorrectionTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCorrectionUnitAmount(Amount. Type newVal){
		CorrectionUnitAmount = newVal;
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
	public void setDifferenceTemperatureReductionQuantity(Quantity. Type newVal){
		DifferenceTemperatureReductionQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGasPressureQuantity(Quantity. Type newVal){
		GasPressureQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMeterNumber(Text. Type newVal){
		MeterNumber = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNormalTemperatureReductionQuantity(Quantity. Type newVal){
		NormalTemperatureReductionQuantity = newVal;
	}
}//end Consumption Correction
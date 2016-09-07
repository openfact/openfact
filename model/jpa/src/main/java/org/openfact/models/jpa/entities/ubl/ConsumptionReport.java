package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe utility consumption, including details of the environment
 * in which consumption takes place.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:55 a. m.
 */
public class ConsumptionReport {

	/**
	 * The basic quantity consumed, excluding additional consumption.
	 */
	private Quantity. Type BasicConsumedQuantity;
	/**
	 * The level of energy consumed, compared to the average for this residence type
	 * and the number of people living in the residence, expressed as text.
	 */
	private Text. Type ConsumersEnergyLevel;
	/**
	 * The level of energy consumed, compared to the average for this residence type
	 * and the number of people living in the residence, expressed as a code.
	 */
	private Code. Type ConsumersEnergyLevelCode;
	/**
	 * The type of consumption, expressed as text.
	 */
	private Text. Type ConsumptionType;
	/**
	 * The type of consumption, expressed as a code.
	 */
	private Code. Type ConsumptionTypeCode;
	/**
	 * Text reporting utility consumption.
	 */
	private Text. Type Description;
	/**
	 * The type of heating in the residence covered in this report, expressed as text.
	 */
	private Text. Type HeatingType;
	/**
	 * The type of heating in the residence covered in this report, expressed as a
	 * code.
	 */
	private Code. Type HeatingTypeCode;
	/**
	 * An identifier for this consumption report.
	 */
	private Identifier. Type ID;
	/**
	 * The type of residence (house, apartment, etc.) covered in this report,
	 * expressed as text.
	 */
	private Text. Type ResidenceType;
	/**
	 * The type of residence (house, apartment, etc.) covered in this report,
	 * expressed as a code.
	 */
	private Code. Type ResidenceTypeCode;
	/**
	 * The number of people occupying the residence covered by this report.
	 */
	private Numeric. Type ResidentOccupantsNumeric;
	/**
	 * The total quantity consumed.
	 */
	private Quantity. Type TotalConsumedQuantity;
	private Consumption History m_Consumption History;
	private Consumption Report Reference m_Consumption Report Reference;
	private Document Reference Guidance Document Reference;
	private Document Reference m_Document Reference;
	private Period m_Period;

	public Consumption Report(){

	}

	public void finalize() throws Throwable {

	}
	public Quantity. Type getBasicConsumedQuantity(){
		return BasicConsumedQuantity;
	}

	public Text. Type getConsumersEnergyLevel(){
		return ConsumersEnergyLevel;
	}

	public Code. Type getConsumersEnergyLevelCode(){
		return ConsumersEnergyLevelCode;
	}

	public Consumption History getConsumption History(){
		return m_Consumption History;
	}

	public Consumption Report Reference getConsumption Report Reference(){
		return m_Consumption Report Reference;
	}

	public Text. Type getConsumptionType(){
		return ConsumptionType;
	}

	public Code. Type getConsumptionTypeCode(){
		return ConsumptionTypeCode;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public Document Reference getGuidance Document Reference(){
		return Guidance Document Reference;
	}

	public Text. Type getHeatingType(){
		return HeatingType;
	}

	public Code. Type getHeatingTypeCode(){
		return HeatingTypeCode;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Period getPeriod(){
		return m_Period;
	}

	public Text. Type getResidenceType(){
		return ResidenceType;
	}

	public Code. Type getResidenceTypeCode(){
		return ResidenceTypeCode;
	}

	public Numeric. Type getResidentOccupantsNumeric(){
		return ResidentOccupantsNumeric;
	}

	public Quantity. Type getTotalConsumedQuantity(){
		return TotalConsumedQuantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBasicConsumedQuantity(Quantity. Type newVal){
		BasicConsumedQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumersEnergyLevel(Text. Type newVal){
		ConsumersEnergyLevel = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumersEnergyLevelCode(Code. Type newVal){
		ConsumersEnergyLevelCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumption History(Consumption History newVal){
		m_Consumption History = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumption Report Reference(Consumption Report Reference newVal){
		m_Consumption Report Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionType(Text. Type newVal){
		ConsumptionType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionTypeCode(Code. Type newVal){
		ConsumptionTypeCode = newVal;
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
	public void setGuidance Document Reference(Document Reference newVal){
		Guidance Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHeatingType(Text. Type newVal){
		HeatingType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHeatingTypeCode(Code. Type newVal){
		HeatingTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPeriod(Period newVal){
		m_Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResidenceType(Text. Type newVal){
		ResidenceType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResidenceTypeCode(Code. Type newVal){
		ResidenceTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResidentOccupantsNumeric(Numeric. Type newVal){
		ResidentOccupantsNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalConsumedQuantity(Quantity. Type newVal){
		TotalConsumedQuantity = newVal;
	}
}//end Consumption Report
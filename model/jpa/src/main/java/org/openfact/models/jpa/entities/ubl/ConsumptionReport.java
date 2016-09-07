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
	private BigDecimal BasicConsumedQuantity;
	/**
	 * The level of energy consumed, compared to the average for this residence type
	 * and the number of people living in the residence, expressed as text.
	 */
	private String ConsumersEnergyLevel;
	/**
	 * The level of energy consumed, compared to the average for this residence type
	 * and the number of people living in the residence, expressed as a code.
	 */
	private String ConsumersEnergyLevelCode;
	/**
	 * The type of consumption, expressed as text.
	 */
	private String ConsumptionType;
	/**
	 * The type of consumption, expressed as a code.
	 */
	private String ConsumptionTypeCode;
	/**
	 * Text reporting utility consumption.
	 */
	private String Description;
	/**
	 * The type of heating in the residence covered in this report, expressed as text.
	 */
	private String HeatingType;
	/**
	 * The type of heating in the residence covered in this report, expressed as a
	 * code.
	 */
	private String HeatingTypeCode;
	/**
	 * An identifier for this consumption report.
	 */
	private String ID;
	/**
	 * The type of residence (house, apartment, etc.) covered in this report,
	 * expressed as text.
	 */
	private String ResidenceType;
	/**
	 * The type of residence (house, apartment, etc.) covered in this report,
	 * expressed as a code.
	 */
	private String ResidenceTypeCode;
	/**
	 * The number of people occupying the residence covered by this report.
	 */
	private BigDecimal ResidentOccupantsNumeric;
	/**
	 * The total quantity consumed.
	 */
	private BigDecimal TotalConsumedQuantity;
	private Consumption History m_Consumption History;
	private Consumption Report Reference m_Consumption Report Reference;
	private DocumentReference Guidance DocumentReference;
	private DocumentReference m_DocumentReference;
	private Period m_Period;

	public Consumption Report(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getBasicConsumedQuantity(){
		return BasicConsumedQuantity;
	}

	public String getConsumersEnergyLevel(){
		return ConsumersEnergyLevel;
	}

	public String getConsumersEnergyLevelCode(){
		return ConsumersEnergyLevelCode;
	}

	public Consumption History getConsumption History(){
		return m_Consumption History;
	}

	public Consumption Report Reference getConsumption Report Reference(){
		return m_Consumption Report Reference;
	}

	public String getConsumptionType(){
		return ConsumptionType;
	}

	public String getConsumptionTypeCode(){
		return ConsumptionTypeCode;
	}

	public String getDescription(){
		return Description;
	}

	public DocumentReference getDocumentReference(){
		return m_DocumentReference;
	}

	public DocumentReference getGuidance DocumentReference(){
		return Guidance DocumentReference;
	}

	public String getHeatingType(){
		return HeatingType;
	}

	public String getHeatingTypeCode(){
		return HeatingTypeCode;
	}

	public String getID(){
		return ID;
	}

	public Period getPeriod(){
		return m_Period;
	}

	public String getResidenceType(){
		return ResidenceType;
	}

	public String getResidenceTypeCode(){
		return ResidenceTypeCode;
	}

	public BigDecimal getResidentOccupantsNumeric(){
		return ResidentOccupantsNumeric;
	}

	public BigDecimal getTotalConsumedQuantity(){
		return TotalConsumedQuantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBasicConsumedQuantity(BigDecimal newVal){
		BasicConsumedQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumersEnergyLevel(String newVal){
		ConsumersEnergyLevel = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumersEnergyLevelCode(String newVal){
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
	public void setConsumptionType(String newVal){
		ConsumptionType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionTypeCode(String newVal){
		ConsumptionTypeCode = newVal;
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
	public void setDocumentReference(DocumentReference newVal){
		m_DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGuidance DocumentReference(DocumentReference newVal){
		Guidance DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHeatingType(String newVal){
		HeatingType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHeatingTypeCode(String newVal){
		HeatingTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
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
	public void setResidenceType(String newVal){
		ResidenceType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResidenceTypeCode(String newVal){
		ResidenceTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResidentOccupantsNumeric(BigDecimal newVal){
		ResidentOccupantsNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalConsumedQuantity(BigDecimal newVal){
		TotalConsumedQuantity = newVal;
	}
}//end Consumption Report
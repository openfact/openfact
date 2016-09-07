package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a hazardous item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:29 a. m.
 */
public class HazardousItem {

	/**
	 * Text providing further information about the hazardous substance.
	 */
	private String AdditionalInformation;
	/**
	 * The name of the category of hazard that applies to the Item.
	 */
	private String CategoryName;
	/**
	 * A code signifying the emergency procedures for this hazardous item.
	 */
	private String EmergencyProceduresCode;
	/**
	 * An identifier for the hazard class applicable to this hazardous item as defined
	 * by the relevant regulation authority (e.g., the IMDG Class Number of the SOLAS
	 * Convention of IMO and the ADR/RID Class Number for the road/rail environment).
	 */
	private String HazardClassID;
	/**
	 * A code signifying a kind of hazard for a material.
	 */
	private String HazardousCategoryCode;
	/**
	 * An identifier for this hazardous item.
	 */
	private String ID;
	/**
	 * The number for the lower part of the orange hazard placard required on the
	 * means of transport.
	 */
	private String LowerOrangeHazardPlacardID;
	/**
	 * An identifier to the marking of the Hazardous Item
	 */
	private String MarkingID;
	/**
	 * A code signifying a medical first aid guide appropriate to this hazardous item.
	 */
	private String MedicalFirstAidGuideCode;
	/**
	 * The volume of this hazardous item, excluding packaging and transport equipment.
	 */
	private Measure. Type NetVolumeMeasure;
	/**
	 * The net weight of this hazardous item, excluding packaging.
	 */
	private Measure. Type NetWeightMeasure;
	/**
	 * Text of the placard endorsement that is to be shown on the shipping papers for
	 * this hazardous item. Can also be used for the number of the orange placard
	 * (lower part) required on the means of transport.
	 */
	private String PlacardEndorsement;
	/**
	 * Text of the placard notation corresponding to the hazard class of this
	 * hazardous item. Can also be the hazard identification number of the orange
	 * placard (upper part) required on the means of transport.
	 */
	private String PlacardNotation;
	/**
	 * The quantity of goods items in this hazardous item that are hazardous.
	 */
	private BigDecimal Quantity;
	/**
	 * The full technical name of a specific hazardous substance contained in this
	 * goods item.
	 */
	private String TechnicalName;
	/**
	 * The UN code for this kind of hazardous item.
	 */
	private String UNDGCode;
	/**
	 * The number for the upper part of the orange hazard placard required on the
	 * means of transport.
	 */
	private String UpperOrangeHazardPlacardID;
	private HazardousGoodsTransit m_HazardousGoodsTransit;
	private Party Contact Party;
	private Secondary Hazard m_Secondary Hazard;
	private Temperature Emergency Temperature;
	private Temperature Additional Temperature;
	private Temperature Flashpoint Temperature;

	public Hazardous Item(){

	}

	public void finalize() throws Throwable {

	}
	public Temperature getAdditional Temperature(){
		return Additional Temperature;
	}

	public String getAdditionalInformation(){
		return AdditionalInformation;
	}

	public String getCategoryName(){
		return CategoryName;
	}

	public Party getContact Party(){
		return Contact Party;
	}

	public Temperature getEmergency Temperature(){
		return Emergency Temperature;
	}

	public String getEmergencyProceduresCode(){
		return EmergencyProceduresCode;
	}

	public Temperature getFlashpoint Temperature(){
		return Flashpoint Temperature;
	}

	public String getHazardClassID(){
		return HazardClassID;
	}

	public HazardousGoodsTransit getHazardousGoodsTransit(){
		return m_HazardousGoodsTransit;
	}

	public String getHazardousCategoryCode(){
		return HazardousCategoryCode;
	}

	public String getID(){
		return ID;
	}

	public String getLowerOrangeHazardPlacardID(){
		return LowerOrangeHazardPlacardID;
	}

	public String getMarkingID(){
		return MarkingID;
	}

	public String getMedicalFirstAidGuideCode(){
		return MedicalFirstAidGuideCode;
	}

	public Measure. Type getNetVolumeMeasure(){
		return NetVolumeMeasure;
	}

	public Measure. Type getNetWeightMeasure(){
		return NetWeightMeasure;
	}

	public String getPlacardEndorsement(){
		return PlacardEndorsement;
	}

	public String getPlacardNotation(){
		return PlacardNotation;
	}

	public BigDecimal getQuantity(){
		return Quantity;
	}

	public Secondary Hazard getSecondary Hazard(){
		return m_Secondary Hazard;
	}

	public String getTechnicalName(){
		return TechnicalName;
	}

	public String getUNDGCode(){
		return UNDGCode;
	}

	public String getUpperOrangeHazardPlacardID(){
		return UpperOrangeHazardPlacardID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditional Temperature(Temperature newVal){
		Additional Temperature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditionalInformation(String newVal){
		AdditionalInformation = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCategoryName(String newVal){
		CategoryName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContact Party(Party newVal){
		Contact Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEmergency Temperature(Temperature newVal){
		Emergency Temperature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEmergencyProceduresCode(String newVal){
		EmergencyProceduresCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFlashpoint Temperature(Temperature newVal){
		Flashpoint Temperature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHazardClassID(String newVal){
		HazardClassID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHazardousGoodsTransit(HazardousGoodsTransit newVal){
		m_HazardousGoodsTransit = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHazardousCategoryCode(String newVal){
		HazardousCategoryCode = newVal;
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
	public void setLowerOrangeHazardPlacardID(String newVal){
		LowerOrangeHazardPlacardID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMarkingID(String newVal){
		MarkingID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMedicalFirstAidGuideCode(String newVal){
		MedicalFirstAidGuideCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNetVolumeMeasure(Measure. Type newVal){
		NetVolumeMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNetWeightMeasure(Measure. Type newVal){
		NetWeightMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlacardEndorsement(String newVal){
		PlacardEndorsement = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlacardNotation(String newVal){
		PlacardNotation = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(BigDecimal newVal){
		Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSecondary Hazard(Secondary Hazard newVal){
		m_Secondary Hazard = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTechnicalName(String newVal){
		TechnicalName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUNDGCode(String newVal){
		UNDGCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUpperOrangeHazardPlacardID(String newVal){
		UpperOrangeHazardPlacardID = newVal;
	}
}//end Hazardous Item
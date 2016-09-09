

/**
 * A class to describe a hazardous item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:29 a. m.
 */
public class Hazardous Item {

	/**
	 * Text providing further information about the hazardous substance.
	 */
	private Text. Type AdditionalInformation;
	/**
	 * The name of the category of hazard that applies to the Item.
	 */
	private Name. Type CategoryName;
	/**
	 * A code signifying the emergency procedures for this hazardous item.
	 */
	private Code. Type EmergencyProceduresCode;
	/**
	 * An identifier for the hazard class applicable to this hazardous item as defined
	 * by the relevant regulation authority (e.g., the IMDG Class Number of the SOLAS
	 * Convention of IMO and the ADR/RID Class Number for the road/rail environment).
	 */
	private Identifier. Type HazardClassID;
	/**
	 * A code signifying a kind of hazard for a material.
	 */
	private Code. Type HazardousCategoryCode;
	/**
	 * An identifier for this hazardous item.
	 */
	private Identifier. Type ID;
	/**
	 * The number for the lower part of the orange hazard placard required on the
	 * means of transport.
	 */
	private Identifier. Type LowerOrangeHazardPlacardID;
	/**
	 * An identifier to the marking of the Hazardous Item
	 */
	private Identifier. Type MarkingID;
	/**
	 * A code signifying a medical first aid guide appropriate to this hazardous item.
	 */
	private Code. Type MedicalFirstAidGuideCode;
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
	private Text. Type PlacardEndorsement;
	/**
	 * Text of the placard notation corresponding to the hazard class of this
	 * hazardous item. Can also be the hazard identification number of the orange
	 * placard (upper part) required on the means of transport.
	 */
	private Text. Type PlacardNotation;
	/**
	 * The quantity of goods items in this hazardous item that are hazardous.
	 */
	private Quantity. Type Quantity;
	/**
	 * The full technical name of a specific hazardous substance contained in this
	 * goods item.
	 */
	private Name. Type TechnicalName;
	/**
	 * The UN code for this kind of hazardous item.
	 */
	private Code. Type UNDGCode;
	/**
	 * The number for the upper part of the orange hazard placard required on the
	 * means of transport.
	 */
	private Identifier. Type UpperOrangeHazardPlacardID;
	private Hazardous Goods Transit m_Hazardous Goods Transit;
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

	public Text. Type getAdditionalInformation(){
		return AdditionalInformation;
	}

	public Name. Type getCategoryName(){
		return CategoryName;
	}

	public Party getContact Party(){
		return Contact Party;
	}

	public Temperature getEmergency Temperature(){
		return Emergency Temperature;
	}

	public Code. Type getEmergencyProceduresCode(){
		return EmergencyProceduresCode;
	}

	public Temperature getFlashpoint Temperature(){
		return Flashpoint Temperature;
	}

	public Identifier. Type getHazardClassID(){
		return HazardClassID;
	}

	public Hazardous Goods Transit getHazardous Goods Transit(){
		return m_Hazardous Goods Transit;
	}

	public Code. Type getHazardousCategoryCode(){
		return HazardousCategoryCode;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Identifier. Type getLowerOrangeHazardPlacardID(){
		return LowerOrangeHazardPlacardID;
	}

	public Identifier. Type getMarkingID(){
		return MarkingID;
	}

	public Code. Type getMedicalFirstAidGuideCode(){
		return MedicalFirstAidGuideCode;
	}

	public Measure. Type getNetVolumeMeasure(){
		return NetVolumeMeasure;
	}

	public Measure. Type getNetWeightMeasure(){
		return NetWeightMeasure;
	}

	public Text. Type getPlacardEndorsement(){
		return PlacardEndorsement;
	}

	public Text. Type getPlacardNotation(){
		return PlacardNotation;
	}

	public Quantity. Type getQuantity(){
		return Quantity;
	}

	public Secondary Hazard getSecondary Hazard(){
		return m_Secondary Hazard;
	}

	public Name. Type getTechnicalName(){
		return TechnicalName;
	}

	public Code. Type getUNDGCode(){
		return UNDGCode;
	}

	public Identifier. Type getUpperOrangeHazardPlacardID(){
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
	public void setAdditionalInformation(Text. Type newVal){
		AdditionalInformation = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCategoryName(Name. Type newVal){
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
	public void setEmergencyProceduresCode(Code. Type newVal){
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
	public void setHazardClassID(Identifier. Type newVal){
		HazardClassID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHazardous Goods Transit(Hazardous Goods Transit newVal){
		m_Hazardous Goods Transit = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHazardousCategoryCode(Code. Type newVal){
		HazardousCategoryCode = newVal;
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
	public void setLowerOrangeHazardPlacardID(Identifier. Type newVal){
		LowerOrangeHazardPlacardID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMarkingID(Identifier. Type newVal){
		MarkingID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMedicalFirstAidGuideCode(Code. Type newVal){
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
	public void setPlacardEndorsement(Text. Type newVal){
		PlacardEndorsement = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlacardNotation(Text. Type newVal){
		PlacardNotation = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(Quantity. Type newVal){
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
	public void setTechnicalName(Name. Type newVal){
		TechnicalName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUNDGCode(Code. Type newVal){
		UNDGCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUpperOrangeHazardPlacardID(Identifier. Type newVal){
		UpperOrangeHazardPlacardID = newVal;
	}
}//end Hazardous Item
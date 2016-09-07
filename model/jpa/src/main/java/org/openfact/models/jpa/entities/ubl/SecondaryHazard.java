package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a secondary hazard associated with a hazardous item.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:17:38 a. m.
 */
public class SecondaryHazard {

	/**
	 * A code signifying the emergency procedures for this secondary hazard.
	 */
	private Code. Type EmergencyProceduresCode;
	/**
	 * Additional information about the hazardous substance, which can be used (for
	 * example) to specify the type of regulatory requirements that apply to this
	 * secondary hazard.
	 */
	private Text. Type Extension;
	/**
	 * An identifier for this secondary hazard.
	 */
	private Identifier. Type ID;
	/**
	 * Text of the placard endorsement for this secondary hazard that is to be shown
	 * on the shipping papers for a hazardous item. Can also be used for the number of
	 * the orange placard (lower part) required on the means of transport.
	 */
	private Text. Type PlacardEndorsement;
	/**
	 * Text of the placard notation corresponding to the hazard class of this
	 * secondary hazard. Can also be the hazard identification number of the orange
	 * placard (upper part) required on the means of transport.
	 */
	private Text. Type PlacardNotation;

	public Secondary Hazard(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getEmergencyProceduresCode(){
		return EmergencyProceduresCode;
	}

	public Text. Type getExtension(){
		return Extension;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Text. Type getPlacardEndorsement(){
		return PlacardEndorsement;
	}

	public Text. Type getPlacardNotation(){
		return PlacardNotation;
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
	public void setExtension(Text. Type newVal){
		Extension = newVal;
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
}//end Secondary Hazard
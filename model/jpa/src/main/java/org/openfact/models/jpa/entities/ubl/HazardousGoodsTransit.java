package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe hazardous goods in transit.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:27 a. m.
 */
public class HazardousGoodsTransit {

	/**
	 * A code signifying the set of legal regulations governing the transportation of
	 * the hazardous goods.
	 */
	private Code. Type HazardousRegulationCode;
	/**
	 * A code signifying the Inhalation Toxicity Hazard Zone for the hazardous goods,
	 * as defined by the US Department of Transportation.
	 */
	private Code. Type InhalationToxicityZoneCode;
	/**
	 * A code signifying the packaging requirement for transportation of the hazardous
	 * goods as assigned by IATA, IMDB, ADR, RID etc.
	 */
	private Code. Type PackingCriteriaCode;
	/**
	 * A code signifying authorization for the transportation of hazardous cargo.
	 */
	private Code. Type TransportAuthorizationCode;
	/**
	 * An identifier for a transport emergency card describing the actions to be taken
	 * in an emergency in transporting the hazardous goods. It may be the identity
	 * number of a hazardous emergency response plan assigned by the appropriate
	 * authority.
	 */
	private Code. Type TransportEmergencyCardCode;
	private Temperature Minimum Temperature;
	private Temperature Maximum Temperature;

	public Hazardous Goods Transit(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getHazardousRegulationCode(){
		return HazardousRegulationCode;
	}

	public Code. Type getInhalationToxicityZoneCode(){
		return InhalationToxicityZoneCode;
	}

	public Temperature getMaximum Temperature(){
		return Maximum Temperature;
	}

	public Temperature getMinimum Temperature(){
		return Minimum Temperature;
	}

	public Code. Type getPackingCriteriaCode(){
		return PackingCriteriaCode;
	}

	public Code. Type getTransportAuthorizationCode(){
		return TransportAuthorizationCode;
	}

	public Code. Type getTransportEmergencyCardCode(){
		return TransportEmergencyCardCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHazardousRegulationCode(Code. Type newVal){
		HazardousRegulationCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInhalationToxicityZoneCode(Code. Type newVal){
		InhalationToxicityZoneCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximum Temperature(Temperature newVal){
		Maximum Temperature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimum Temperature(Temperature newVal){
		Minimum Temperature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPackingCriteriaCode(Code. Type newVal){
		PackingCriteriaCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportAuthorizationCode(Code. Type newVal){
		TransportAuthorizationCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportEmergencyCardCode(Code. Type newVal){
		TransportEmergencyCardCode = newVal;
	}
}//end Hazardous Goods Transit
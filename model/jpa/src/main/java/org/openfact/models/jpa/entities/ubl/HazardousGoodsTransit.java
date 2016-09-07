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
	private String HazardousRegulationCode;
	/**
	 * A code signifying the Inhalation Toxicity Hazard Zone for the hazardous goods,
	 * as defined by the US Department of Transportation.
	 */
	private String InhalationToxicityZoneCode;
	/**
	 * A code signifying the packaging requirement for transportation of the hazardous
	 * goods as assigned by IATA, IMDB, ADR, RID etc.
	 */
	private String PackingCriteriaCode;
	/**
	 * A code signifying authorization for the transportation of hazardous cargo.
	 */
	private String TransportAuthorizationCode;
	/**
	 * An identifier for a transport emergency card describing the actions to be taken
	 * in an emergency in transporting the hazardous goods. It may be the identity
	 * number of a hazardous emergency response plan assigned by the appropriate
	 * authority.
	 */
	private String TransportEmergencyCardCode;
	private Temperature Minimum Temperature;
	private Temperature Maximum Temperature;

	public HazardousGoodsTransit(){

	}

	public void finalize() throws Throwable {

	}
	public String getHazardousRegulationCode(){
		return HazardousRegulationCode;
	}

	public String getInhalationToxicityZoneCode(){
		return InhalationToxicityZoneCode;
	}

	public Temperature getMaximum Temperature(){
		return Maximum Temperature;
	}

	public Temperature getMinimum Temperature(){
		return Minimum Temperature;
	}

	public String getPackingCriteriaCode(){
		return PackingCriteriaCode;
	}

	public String getTransportAuthorizationCode(){
		return TransportAuthorizationCode;
	}

	public String getTransportEmergencyCardCode(){
		return TransportEmergencyCardCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHazardousRegulationCode(String newVal){
		HazardousRegulationCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInhalationToxicityZoneCode(String newVal){
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
	public void setPackingCriteriaCode(String newVal){
		PackingCriteriaCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportAuthorizationCode(String newVal){
		TransportAuthorizationCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportEmergencyCardCode(String newVal){
		TransportEmergencyCardCode = newVal;
	}
}//end HazardousGoodsTransit
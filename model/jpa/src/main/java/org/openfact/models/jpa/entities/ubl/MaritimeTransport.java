package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a vessel used for transport by water (including sea, river,
 * and canal).
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:05 a. m.
 */
public class MaritimeTransport {

	/**
	 * Gross tonnage is calculated by measuring a ship's volume (from keel to funnel,
	 * to the outside of the hull framing) and applying a mathematical formula and is
	 * used to determine things such as a ship's manning regulations, safety rules,
	 * registration fees an
	 */
	private Measure. Type GrossTonnageMeasure;
	/**
	 * Net tonnage is calculated by measuring a ship's internal volume and applying a
	 * mathematical formula and is used to calculate the port duties.
	 */
	private Measure. Type NetTonnageMeasure;
	/**
	 * The radio call sign of the vessel.
	 */
	private String RadioCallSignID;
	/**
	 * Information about what services a vessel will require when it arrives at a port,
	 * such as refueling, maintenance, waste disposal etc.
	 */
	private String ShipsRequirements;
	/**
	 * An identifier for a specific vessel.
	 */
	private String VesselID;
	/**
	 * The name of the vessel.
	 */
	private String VesselName;
	private DocumentReference Registry Certificate DocumentReference;
	private Location Registry Port Location;

	public Maritime Transport(){

	}

	public void finalize() throws Throwable {

	}
	public Measure. Type getGrossTonnageMeasure(){
		return GrossTonnageMeasure;
	}

	public Measure. Type getNetTonnageMeasure(){
		return NetTonnageMeasure;
	}

	public String getRadioCallSignID(){
		return RadioCallSignID;
	}

	public DocumentReference getRegistry Certificate DocumentReference(){
		return Registry Certificate DocumentReference;
	}

	public Location getRegistry Port Location(){
		return Registry Port Location;
	}

	public String getShipsRequirements(){
		return ShipsRequirements;
	}

	public String getVesselID(){
		return VesselID;
	}

	public String getVesselName(){
		return VesselName;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGrossTonnageMeasure(Measure. Type newVal){
		GrossTonnageMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNetTonnageMeasure(Measure. Type newVal){
		NetTonnageMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRadioCallSignID(String newVal){
		RadioCallSignID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegistry Certificate DocumentReference(DocumentReference newVal){
		Registry Certificate DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegistry Port Location(Location newVal){
		Registry Port Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShipsRequirements(String newVal){
		ShipsRequirements = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVesselID(String newVal){
		VesselID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVesselName(String newVal){
		VesselName = newVal;
	}
}//end Maritime Transport
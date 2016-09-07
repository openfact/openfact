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
	private Identifier. Type RadioCallSignID;
	/**
	 * Information about what services a vessel will require when it arrives at a port,
	 * such as refueling, maintenance, waste disposal etc.
	 */
	private Text. Type ShipsRequirements;
	/**
	 * An identifier for a specific vessel.
	 */
	private Identifier. Type VesselID;
	/**
	 * The name of the vessel.
	 */
	private Name. Type VesselName;
	private Document Reference Registry Certificate Document Reference;
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

	public Identifier. Type getRadioCallSignID(){
		return RadioCallSignID;
	}

	public Document Reference getRegistry Certificate Document Reference(){
		return Registry Certificate Document Reference;
	}

	public Location getRegistry Port Location(){
		return Registry Port Location;
	}

	public Text. Type getShipsRequirements(){
		return ShipsRequirements;
	}

	public Identifier. Type getVesselID(){
		return VesselID;
	}

	public Name. Type getVesselName(){
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
	public void setRadioCallSignID(Identifier. Type newVal){
		RadioCallSignID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegistry Certificate Document Reference(Document Reference newVal){
		Registry Certificate Document Reference = newVal;
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
	public void setShipsRequirements(Text. Type newVal){
		ShipsRequirements = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVesselID(Identifier. Type newVal){
		VesselID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVesselName(Name. Type newVal){
		VesselName = newVal;
	}
}//end Maritime Transport
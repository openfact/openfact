package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe a location on board a means of transport where specified
 * goods or transport equipment have been stowed or are to be stowed.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:54 a. m.
 */
public class Stowage {

    /**
     * Text describing the location.
     */
    private String Location;
    /**
     * An identifier for the location.
     */
    private String LocationID;
    private Dimension Measurement Dimension;

    public Stowage() {

    }

    public void finalize() throws Throwable {

    }

    public String getLocation() {
        return Location;
    }

    public String getLocationID() {
        return LocationID;
    }

    public Dimension getMeasurement

    Dimension(){
		return Measurement Dimension;
	}

    /**
     * 
     * @param newVal
     */
    public void setLocation(String newVal) {
        Location = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setLocationID(String newVal) {
        LocationID = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setMeasurement

    Dimension(Dimension newVal){
		Measurement Dimension = newVal;
	}
}// end Stowage
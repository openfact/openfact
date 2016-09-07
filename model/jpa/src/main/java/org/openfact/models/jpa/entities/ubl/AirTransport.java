package org.openfact.models.jpa.entities.ubl;

/**
 * A class to identify a specific aircraft used for transportation.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:41 a. m.
 */
public class AirTransport {

    /**
     * An identifer for a specific aircraft.
     */
    private String aircraftID;

    /**
     * @return the aircraftID
     */
    public String getAircraftID() {
        return aircraftID;
    }

    /**
     * @param aircraftID
     *            the aircraftID to set
     */
    public void setAircraftID(String aircraftID) {
        this.aircraftID = aircraftID;
    }

}
package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.IdentifierType;

import java.util.ArrayList;
import java.util.List;

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
	private IdentifierType aircraftID;

	public IdentifierType getAircraftID() {
		return aircraftID;
	}

	public void setAircraftID(IdentifierType aircraftID) {
		this.aircraftID = aircraftID;
	}
}
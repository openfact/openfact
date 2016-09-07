package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ubl2.Rail;

/**
 * A class defining details about a train wagon used as a means of transport.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:17 a. m.
 */
public class RailTransport {

	/**
	 * An identifier for the rail car on the train used as the means of transport.
	 */
	private String RailCarID;
	/**
	 * An identifier for the train used as the means of transport.
	 */
	private String TrainID;

	public RailTransport(){

	}

	public void finalize() throws Throwable {

	}
	public String getRailCarID(){
		return RailCarID;
	}

	public String getTrainID(){
		return TrainID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRailCarID(String newVal){
		RailCarID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTrainID(String newVal){
		TrainID = newVal;
	}
}//end RailTransport
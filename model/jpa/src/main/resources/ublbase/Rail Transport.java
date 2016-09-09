

/**
 * A class defining details about a train wagon used as a means of transport.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:17 a. m.
 */
public class Rail Transport {

	/**
	 * An identifier for the rail car on the train used as the means of transport.
	 */
	private Identifier. Type RailCarID;
	/**
	 * An identifier for the train used as the means of transport.
	 */
	private Identifier. Type TrainID;

	public Rail Transport(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getRailCarID(){
		return RailCarID;
	}

	public Identifier. Type getTrainID(){
		return TrainID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRailCarID(Identifier. Type newVal){
		RailCarID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTrainID(Identifier. Type newVal){
		TrainID = newVal;
	}
}//end Rail Transport
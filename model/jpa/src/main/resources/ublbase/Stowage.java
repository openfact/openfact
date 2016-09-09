

/**
 * A class to describe a location on board a means of transport where specified
 * goods or transport equipment have been stowed or are to be stowed.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:54 a. m.
 */
public class Stowage {

	/**
	 * Text describing the location.
	 */
	private Text. Type Location;
	/**
	 * An identifier for the location.
	 */
	private Identifier. Type LocationID;
	private Dimension Measurement Dimension;

	public Stowage(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getLocation(){
		return Location;
	}

	public Identifier. Type getLocationID(){
		return LocationID;
	}

	public Dimension getMeasurement Dimension(){
		return Measurement Dimension;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLocation(Text. Type newVal){
		Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLocationID(Identifier. Type newVal){
		LocationID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMeasurement Dimension(Dimension newVal){
		Measurement Dimension = newVal;
	}
}//end Stowage
package org.openfact.models.jpa.entities.ubl;


/**
 * A class for defining a set of geographical coordinates (apparently misnamed).
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:02 a. m.
 */
public class LocationCoordinate {

	/**
	 * The altitude of the location.
	 */
	private Measure. Type AltitudeMeasure;
	/**
	 * A code signifying the location system used.
	 */
	private Code. Type CoordinateSystemCode;
	/**
	 * The degree component of a latitude measured in degrees and minutes.
	 */
	private Measure. Type LatitudeDegreesMeasure;
	/**
	 * A code signifying the direction of latitude measurement from the equator (north
	 * or south).
	 */
	private Latitude Direction_ Code. Type LatitudeDirectionCode;
	/**
	 * The minutes component of a latitude measured in degrees and minutes (modulo 60).
	 */
	private Measure. Type LatitudeMinutesMeasure;
	/**
	 * The degree component of a longitude measured in degrees and minutes.
	 */
	private Measure. Type LongitudeDegreesMeasure;
	/**
	 * A code signifying the direction of longitude measurement from the prime
	 * meridian (east or west).
	 */
	private Longitude Direction_ Code. Type LongitudeDirectionCode;
	/**
	 * The minutes component of a longitude measured in degrees and minutes (modulo
	 * 60).
	 */
	private Measure. Type LongitudeMinutesMeasure;

	public Location Coordinate(){

	}

	public void finalize() throws Throwable {

	}
	public Measure. Type getAltitudeMeasure(){
		return AltitudeMeasure;
	}

	public Code. Type getCoordinateSystemCode(){
		return CoordinateSystemCode;
	}

	public Measure. Type getLatitudeDegreesMeasure(){
		return LatitudeDegreesMeasure;
	}

	public Latitude Direction_ Code. Type getLatitudeDirectionCode(){
		return LatitudeDirectionCode;
	}

	public Measure. Type getLatitudeMinutesMeasure(){
		return LatitudeMinutesMeasure;
	}

	public Measure. Type getLongitudeDegreesMeasure(){
		return LongitudeDegreesMeasure;
	}

	public Longitude Direction_ Code. Type getLongitudeDirectionCode(){
		return LongitudeDirectionCode;
	}

	public Measure. Type getLongitudeMinutesMeasure(){
		return LongitudeMinutesMeasure;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAltitudeMeasure(Measure. Type newVal){
		AltitudeMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCoordinateSystemCode(Code. Type newVal){
		CoordinateSystemCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLatitudeDegreesMeasure(Measure. Type newVal){
		LatitudeDegreesMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLatitudeDirectionCode(Latitude Direction_ Code. Type newVal){
		LatitudeDirectionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLatitudeMinutesMeasure(Measure. Type newVal){
		LatitudeMinutesMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLongitudeDegreesMeasure(Measure. Type newVal){
		LongitudeDegreesMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLongitudeDirectionCode(Longitude Direction_ Code. Type newVal){
		LongitudeDirectionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLongitudeMinutesMeasure(Measure. Type newVal){
		LongitudeMinutesMeasure = newVal;
	}
}//end Location Coordinate
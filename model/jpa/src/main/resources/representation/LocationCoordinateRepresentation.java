package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.LongitudeDirectionCodeType;


/**
 * A class for defining a set of geographical coordinates (apparently misnamed).
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:02 a. m.
 */
public class LocationCoordinateRepresentation{

	/**
	 * The altitude of the location.
	 */
	private MeasureType altitudeMeasure; 
	/**
	 * A code signifying the location system used.
	 */
	private CodeType coordinateSystemCode; 
	/**
	 * The degree component of a latitude measured in degrees and minutes.
	 */
	private MeasureType latitudeDegreesMeasure; 
	/**
	 * A code signifying the direction of latitude measurement from the equator (north
	 * or south).
	 */
	private LatitudeDirectionCodeType latitudeDirectionCode; 
	/**
	 * The minutes component of a latitude measured in degrees and minutes (modulo 60).
	 */
	private MeasureType latitudeMinutesMeasure; 
	/**
	 * The degree component of a longitude measured in degrees and minutes.
	 */
	private MeasureType longitudeDegreesMeasure; 
	/**
	 * A code signifying the direction of longitude measurement from the prime
	 * meridian (east or west).
	 */
	private LongitudeDirectionCodeType longitudeDirectionCode; 
	/**
	 * The minutes component of a longitude measured in degrees and minutes (modulo
	 * 60).
	 */
	private MeasureType longitudeMinutesMeasure; 

}

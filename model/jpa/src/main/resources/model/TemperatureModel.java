package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a measurement of temperature.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:18:13 a. m.
 */
public class TemperatureModel{

	/**
	 * An identifier for this temperature measurement.
	 */
	private IdentifierType attributeID; 
	/**
	 * Text describing this temperature measurement.
	 */
	private TextType description; 
	/**
	 * The value of this temperature measurement.
	 */
	private MeasureType measure; 

}

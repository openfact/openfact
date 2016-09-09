package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a location.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:00 a. m.
 */
public class LocationAdapter{

	/**
	 * Free-form text describing the physical conditions of the location.
	 */
	private TextType conditions; 
	/**
	 * A territorial division of a country, such as a county or state, expressed as
	 * text.
	 */
	private TextType countrySubentity; 
	/**
	 * A territorial division of a country, such as a county or state, expressed as a
	 * code.
	 */
	private CodeType countrySubentityCode; 
	/**
	 * Text describing this location.
	 */
	private TextType description; 
	/**
	 * An identifier for this location, e.g., the EAN LocationAdapter Number, GLN.
	 */
	private IdentifierType ID; 
	/**
	 * The Uniform Resource Identifier (URI) of a document providing information about
	 * this location.
	 */
	private IdentifierType informationURIID; 
	/**
	 * A code signifying the type of location.
	 */
	private CodeType locationTypeCode; 
	/**
	 * The name of this location.
	 */
	private NameType name; 
	private List<AddressAdapter> addresses = new ArrayList<>(); 
	private PeriodAdapter validityPeriod; 
	private List<LocationCoordinateAdapter> locationCoordinates = new ArrayList<>(); 
	private LocationAdapter subsidiaryLocation; 

}

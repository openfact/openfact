package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a location on board a means of transport where specified
 * goods or transport equipment have been stowed or are to be stowed.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:54 a. m.
 */
public class StowageRepresentation{

	/**
	 * Text describing the location.
	 */
	private TextType Location;
	/**
	 * An identifier for the location.
	 */
	private IdentifierType LocationID;
	private DimensionRepresentation MeasurementDimension;

}

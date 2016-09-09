package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a measurable dimension (length, mass, weight, volume, or
 * area) of an item.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:30 a. m.
 */
public class DimensionAdapter{

	/**
	 * An identifier for the attribute to which the measure applies.
	 */
	private IdentifierType attributeID;
	/**
	 * Text describing the measurement attribute.
	 */
	private TextType description;
	/**
	 * The maximum value in a range of measurement of this dimension.
	 */
	private measureType maximummeasure;
	/**
	 * The measurement value.
	 */
	private measureType measure;
	/**
	 * The minimum value in a range of measurement of this dimension.
	 */
	private measureType Minimummeasure;

}

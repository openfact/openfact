package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * The name of this meter property.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:08 a. m.
 */
public class MeterPropertyRepresentation{

	/**
	 * The name of this meter property, expressed as a code.
	 */
	private NameType Name;
	/**
	 * The value of this meter property, expressed as text.
	 */
	private CodeType NameCode;
	/**
	 * The value of this meter property, expressed as a quantity.
	 */
	private TextType Value;
	/**
	 * An additional value to qualify the value of the meter
	 */
	private TextType ValueQualifier;
	/**
	 * The value of this meter property, expressed as a quantity.
	 */
	private QuantityType ValueQuantity;

}

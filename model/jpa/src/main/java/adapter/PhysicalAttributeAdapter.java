package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a physical attribute.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:48 a. m.
 */
public class PhysicalAttributeAdapter{

	/**
	 * An identifier for this physical attribute.
	 */
	private IdentifierType AttributeID;
	/**
	 * A description of the physical attribute, expressed as text.
	 */
	private TextType Description;
	/**
	 * A description of the physical attribute, expressed as a code.
	 */
	private CodeType DescriptionCode;
	/**
	 * A code signifying the position of this physical attribute.
	 */
	private CodeType PositionCode;

}

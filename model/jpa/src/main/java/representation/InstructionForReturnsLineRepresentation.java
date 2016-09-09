package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in an Instruction for Returns.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:33 a. m.
 */
public class InstructionForReturnsLineRepresentation{

	/**
	 * An identifier for this instruction for returns line.
	 */
	private IdentifierType ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * The quantity of goods being returned.
	 */
	private QuantityType Quantity;
	private List<ItemRepresentation> Items = new ArrayList<>();
	private PartyRepresentation ManufacturerParty;

}

package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line describing a request for a catalogue line.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:25 a. m.
 */
public class CatalogueRequestLineRepresentation{

	/**
	 * A subdivision of a contract or tender covering the line being requested.
	 */
	private TextType ContractSubdivision;
	/**
	 * An identifier for the requested catalogue line.
	 */
	private IdentifierType ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	private List<ItemRepresentation> Items = new ArrayList<>();
	private ItemLocationQuantityRepresentation RequiredItemLocationQuantity;
	private PeriodRepresentation LineValidityPeriod;

}

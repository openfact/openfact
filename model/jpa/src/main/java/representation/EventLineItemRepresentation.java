package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line item describing the expected impacts associated with a
 * retail event involving a specific product at a specific location.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:56 a. m.
 */
public class EventLineItemRepresentation{

	/**
	 * The number of this event line item.
	 */
	private NumericType LineNumberNumeric;
	private ItemRepresentation SupplyItem;
	private LocationRepresentation ParticipatingLocationsLocation;
	private List<RetailPlannedImpactRepresentation> RetailPlannedImpacts = new ArrayList<>();

}

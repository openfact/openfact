package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe one segment or leg in a transportation service.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:51 a. m.
 */
public class TransportationSegmentRepresentation{

	/**
	 * A number indicating the order of this segment in the sequence of transportation
	 * segments making up a transportation service.
	 */
	private NumericType SequenceNumeric;
	/**
	 * An identifier for the transport execution plan governing this transportation
	 * segment.
	 */
	private IdentifierType TransportExecutionPlanReferenceID;
	private ConsignmentRepresentation ReferencedConsignment;
	private PartyRepresentation TransportServiceProviderParty;
	private List<ShipmentStageRepresentation> ShipmentStages = new ArrayList<>();
	private List<TransportationServiceRepresentation> TransportationServices = new ArrayList<>();

}

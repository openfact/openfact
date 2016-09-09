package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * Describes the location and schedule relating to a transport means.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:49 a. m.
 */
public class TransportScheduleAdapter{

	/**
	 * The reference date for the transport schedule status.
	 */
	private DateType referenceDate;
	/**
	 * The reference time for the transport schedule status.
	 */
	private TimeType referenceTime;
	/**
	 * The reliability of the transport schedule status, expressed as a percentage.
	 */
	private PercentType reliabilityPercent;
	/**
	 * remarks related to the transport schedule status.
	 */
	private TextType remarks;
	/**
	 * A number indicating the order of this status in the sequence in which statuses
	 * are to be presented.
	 */
	private NumericType sequenceNumeric;
	private LocationAdapter statusLocation;
	private TransportEventAdapter actualDepartureTransportEvent;
	private TransportEventAdapter estimatedDepartureTransportEvent;
	private TransportEventAdapter estimatedArrivalTransportEvent;
	private TransportEventAdapter plannedDepartureTransportEvent;
	private TransportEventAdapter actualArrivalTransportEvent;
	private TransportEventAdapter plannedArrivalTransportEvent;

}

package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * Describes the location and schedule relating to a transport means.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:49 a. m.
 */
public class TransportScheduleModel{

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
	private LocationModel statusLocation;
	private TransportEventModel actualDepartureTransportEvent;
	private TransportEventModel estimatedDepartureTransportEvent;
	private TransportEventModel estimatedArrivalTransportEvent;
	private TransportEventModel plannedDepartureTransportEvent;
	private TransportEventModel actualArrivalTransportEvent;
	private TransportEventModel plannedArrivalTransportEvent;

}

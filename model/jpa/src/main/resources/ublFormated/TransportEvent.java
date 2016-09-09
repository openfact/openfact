package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a significant occurrence or happening related to the
 * transportation of goods.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:42 a. m.
 */
public class TransportEvent{

	/**
	 * An indicator that this transport event has been completed (true) or not (false).
	 */
	private boolean CompletionIndicator;
	/**
	 * Text describing this transport event.
	 */
	private TextType Description;
	/**
	 * An identifier for this transport event within an agreed event identification
	 * scheme.
	 */
	private IdentifierType IdentificationID;
	/**
	 * The date of this transport event.
	 */
	private LocalDate OccurrenceDate;
	/**
	 * The time of this transport event.
	 */
	private LocalTime OccurrenceTime;
	/**
	 * A code signifying the type of this transport event.
	 */
	private CodeType TransportEventTypeCode;
	private List<Contact> Contacts = new ArrayList<>();
	private List<Location> Locations = new ArrayList<>();
	private List<Period> Periods = new ArrayList<>();
	private Shipment ReportedShipment;
	private Status CurrentStatus;
	private List<Signature> Signatures = new ArrayList<>();

}

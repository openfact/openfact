package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a significant occurrence relating to an object, process, or
 * person.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:53 a. m.
 */
public class Event{

	/**
	 * An indicator that this event has been completed (true) or not (false).
	 */
	private IndicatorType CompletionIndicator;
	/**
	 * Text describing this event.
	 */
	private TextType Description;
	/**
	 * An identifier for this event within an agreed event identification scheme.
	 */
	private IdentifierType IdentificationID;
	/**
	 * The date of this event.
	 */
	private DateType OccurrenceDate;
	/**
	 * The time of this event.
	 */
	private TimeType OccurrenceTime;
	/**
	 * A code signifying the type of this event.
	 */
	private CodeType TypeCode;
	private List<Contact> Contacts = new ArrayList<>();
	private Location OccurenceLocation;
	private Status CurrentStatus;

}

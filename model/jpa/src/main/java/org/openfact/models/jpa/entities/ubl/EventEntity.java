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
public class EventEntity{

	/**
	 * An indicator that this event has been completed (true) or not (false).
	 */
	private IndicatorType completionIndicator; 
	/**
	 * Text describing this event.
	 */
	private TextType description; 
	/**
	 * An identifier for this event within an agreed event identification scheme.
	 */
	private IdentifierType identificationID; 
	/**
	 * The date of this event.
	 */
	private DateType occurrenceDate; 
	/**
	 * The time of this event.
	 */
	private TimeType occurrenceTime; 
	/**
	 * A code signifying the type of this event.
	 */
	private CodeType typeCode; 
	private List<ContactEntity> contacts = new ArrayList<>(); 
	private LocationEntity occurenceLocation; 
	private StatusEntity currentStatus; 

}

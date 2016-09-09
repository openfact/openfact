package org.openfact.models.jpa.entities.ubl;
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
public class TransportEventModel{

	/**
	 * An indicator that this transport event has been completed (true) or not (false).
	 */
	private IndicatorType completionIndicator; 
	/**
	 * Text describing this transport event.
	 */
	private TextType description; 
	/**
	 * An identifier for this transport event within an agreed event identification
	 * scheme.
	 */
	private IdentifierType identificationID; 
	/**
	 * The date of this transport event.
	 */
	private DateType occurrenceDate; 
	/**
	 * The time of this transport event.
	 */
	private TimeType occurrenceTime; 
	/**
	 * A code signifying the type of this transport event.
	 */
	private CodeType transportEventTypeCode; 
	private List<ContactModel> contacts = new ArrayList<>(); 
	private List<LocationModel> locations = new ArrayList<>(); 
	private List<PeriodModel> periods = new ArrayList<>(); 
	private ShipmentModel reportedShipment; 
	private StatusModel currentStatus; 
	private List<SignatureModel> signatures = new ArrayList<>(); 

}

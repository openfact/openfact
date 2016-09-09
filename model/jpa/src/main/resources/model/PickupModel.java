package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a pickup for delivery.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:49 a. m.
 */
public class PickupModel{

	/**
	 * The actual pickup date.
	 */
	private LocalDate actualPickupDate; 
	/**
	 * The actual pickup time.
	 */
	private LocalTime actualPickupTime; 
	/**
	 * The earliest pickup date.
	 */
	private LocalDate earliestPickupDate; 
	/**
	 * The earliest pickup time.
	 */
	private LocalTime earliestPickupTime; 
	/**
	 * An identifier for this pickup.
	 */
	private IdentifierType ID; 
	/**
	 * The latest pickup date.
	 */
	private LocalDate latestPickupDate; 
	/**
	 * The latest pickup time.
	 */
	private LocalTime latestPickupTime; 
	private LocationModel pickupLocation; 
	private PartyModel pickupParty; 

}

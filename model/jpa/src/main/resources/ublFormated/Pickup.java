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
public class Pickup{

	/**
	 * The actual pickup date.
	 */
	private LocalDate ActualPickupDate;
	/**
	 * The actual pickup time.
	 */
	private LocalTime ActualPickupTime;
	/**
	 * The earliest pickup date.
	 */
	private LocalDate EarliestPickupDate;
	/**
	 * The earliest pickup time.
	 */
	private LocalTime EarliestPickupTime;
	/**
	 * An identifier for this pickup.
	 */
	private IdentifierType ID;
	/**
	 * The latest pickup date.
	 */
	private LocalDate LatestPickupDate;
	/**
	 * The latest pickup time.
	 */
	private LocalTime LatestPickupTime;
	private Location PickupLocation;
	private Party PickupParty;

}

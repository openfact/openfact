package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the despatching of goods (their pickup for delivery).
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:28 a. m.
 */
public class Despatch{

	/**
	 * The actual despatch (pickup) date.
	 */
	private LocalDate ActualDespatchDate;
	/**
	 * The actual despatch (pickup) time.
	 */
	private LocalTime ActualDespatchTime;
	/**
	 * The estimated despatch (pickup) date.
	 */
	private LocalDate EstimatedDespatchDate;
	/**
	 * The estimated despatch (pickup) time.
	 */
	private LocalTime EstimatedDespatchTime;
	/**
	 * The date guaranteed for the despatch (pickup).
	 */
	private LocalDate GuaranteedDespatchDate;
	/**
	 * The time guaranteed for the despatch (pickup).
	 */
	private LocalTime GuaranteedDespatchTime;
	/**
	 * An identifier for this despatch event.
	 */
	private IdentifierType ID;
	/**
	 * Text describing any special instructions applying to the despatch (pickup).
	 */
	private TextType Instructions;
	/**
	 * An identifier for the release of the despatch used as security control or cargo
	 * control (pick-up).
	 */
	private IdentifierType ReleaseID;
	/**
	 * The despatch (pickup) date requested, normally by the buyer.
	 */
	private LocalDate RequestedDespatchDate;
	/**
	 * The despatch (pickup) time requested, normally by the buyer.
	 */
	private LocalTime RequestedDespatchTime;
	private Address DespatchAddress;
	private List<Contact> Contacts = new ArrayList<>();
	private Location DespatchLocation;
	private Party NotifyParty;
	private Party CarrierParty;
	private Party DespatchParty;
	private Period RequestedDespatchPeriod;
	private Period EstimatedDespatchPeriod;

}

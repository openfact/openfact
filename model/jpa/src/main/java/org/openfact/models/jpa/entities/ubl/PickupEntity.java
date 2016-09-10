package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.models.ubl.type.IdentifierType;

/**
 * A class to describe a pickup for delivery.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:49 a. m.
 */
public class PickupEntity {

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
    private LocationEntity pickupLocation;
    private PartyEntity pickupParty;

}

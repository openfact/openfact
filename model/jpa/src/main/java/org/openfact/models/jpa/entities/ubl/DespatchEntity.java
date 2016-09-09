package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A class to describe the despatching of goods (their pickup for delivery).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:28 a. m.
 */
public class DespatchEntity {

    /**
     * The actual despatch (pickup) date.
     */
    private DateType actualDespatchDate;
    /**
     * The actual despatch (pickup) time.
     */
    private TimeType actualDespatchTime;
    /**
     * The estimated despatch (pickup) date.
     */
    private DateType estimatedDespatchDate;
    /**
     * The estimated despatch (pickup) time.
     */
    private TimeType estimatedDespatchTime;
    /**
     * The date guaranteed for the despatch (pickup).
     */
    private DateType guaranteedDespatchDate;
    /**
     * The time guaranteed for the despatch (pickup).
     */
    private TimeType guaranteedDespatchTime;
    /**
     * An identifier for this despatch event.
     */
    private IdentifierType ID;
    /**
     * Text describing any special instructions applying to the despatch
     * (pickup).
     */
    private TextType instructions;
    /**
     * An identifier for the release of the despatch used as security control or
     * cargo control (pick-up).
     */
    private IdentifierType releaseID;
    /**
     * The despatch (pickup) date requested, normally by the buyer.
     */
    private DateType requestedDespatchDate;
    /**
     * The despatch (pickup) time requested, normally by the buyer.
     */
    private TimeType requestedDespatchTime;
    private AddressEntity despatchAddress;
    private List<ContactEntity> contacts = new ArrayList<>();
    private LocationEntity despatchLocation;
    private PartyEntity notifyParty;
    private PartyEntity carrierParty;
    private PartyEntity despatchParty;
    private PeriodEntity requestedDespatchPeriod;
    private PeriodEntity estimatedDespatchPeriod;

}

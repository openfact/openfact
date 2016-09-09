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
    private DateType ActualDespatchDate;
    /**
     * The actual despatch (pickup) time.
     */
    private TimeType ActualDespatchTime;
    /**
     * The estimated despatch (pickup) date.
     */
    private DateType EstimatedDespatchDate;
    /**
     * The estimated despatch (pickup) time.
     */
    private TimeType EstimatedDespatchTime;
    /**
     * The date guaranteed for the despatch (pickup).
     */
    private DateType GuaranteedDespatchDate;
    /**
     * The time guaranteed for the despatch (pickup).
     */
    private TimeType GuaranteedDespatchTime;
    /**
     * An identifier for this despatch event.
     */
    private IdentifierType ID;
    /**
     * Text describing any special instructions applying to the despatch
     * (pickup).
     */
    private TextType Instructions;
    /**
     * An identifier for the release of the despatch used as security control or
     * cargo control (pick-up).
     */
    private IdentifierType ReleaseID;
    /**
     * The despatch (pickup) date requested, normally by the buyer.
     */
    private DateType RequestedDespatchDate;
    /**
     * The despatch (pickup) time requested, normally by the buyer.
     */
    private TimeType RequestedDespatchTime;
    private AddressEntity DespatchAddress;
    private List<ContactEntity> Contacts = new ArrayList<>();
    private LocationEntity DespatchLocation;
    private PartyEntity NotifyParty;
    private PartyEntity CarrierParty;
    private PartyEntity DespatchParty;
    private PeriodEntity RequestedDespatchPeriod;
    private PeriodEntity EstimatedDespatchPeriod;

}

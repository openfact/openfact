package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;

/**
 * A class to describe a specific, trackable instance of an item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:45 a. m.
 */
public class ItemInstanceRepresentation {

    /**
     * The date before which it is best to use this item instance.
     */
    private LocalDate bestBeforeDate;
    /**
     * The date on which this item instance was manufactured.
     */
    private LocalDate manufactureDate;
    /**
     * The time at which this item instance was manufactured.
     */
    private LocalTime manufactureTime;
    /**
     * An identifier used for tracing this item instance, such as the EPC number
     * used in RFID.
     */
    private IdentifierRepresentation productTraceID;
    /**
     * The registration identifier of this item instance.
     */
    private IdentifierRepresentation registrationID;
    /**
     * The serial number of this item instance.
     */
    private IdentifierRepresentation serialID;
    private ItemPropertyRepresentation additionalItemProperty;
    private List<LotIdentificationRepresentation> lotIdentifications = new ArrayList<>();

}

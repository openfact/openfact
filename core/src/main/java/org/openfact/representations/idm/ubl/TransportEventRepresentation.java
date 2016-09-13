package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a significant occurrence or happening related to the
 * transportation of goods.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:42 a. m.
 */
public class TransportEventRepresentation {

    /**
     * An indicator that this transport event has been completed (true) or not
     * (false).
     */
    private boolean completionIndicator;
    /**
     * Text describing this transport event.
     */
    private TextRepresentation description;
    /**
     * An identifier for this transport event within an agreed event
     * identification scheme.
     */
    private IdentifierRepresentation identificationID;
    /**
     * The date of this transport event.
     */
    private LocalDate occurrenceDate;
    /**
     * The time of this transport event.
     */
    private LocalTime occurrenceTime;
    /**
     * A code signifying the type of this transport event.
     */
    private CodeRepresentation transportEventTypeCode;
    private List<ContactRepresentation> contacts = new ArrayList<>();
    private List<LocationRepresentation> locations = new ArrayList<>();
    private List<PeriodRepresentation> periods = new ArrayList<>();
    private ShipmentRepresentation reportedShipment;
    private StatusRepresentation currentStatus;
    private List<SignatureRepresentation> signatures = new ArrayList<>();

}

package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a significant occurrence relating to an object, process,
 * or person.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:53 a. m.
 */
public class EventRepresentation {

    /**
     * An indicator that this event has been completed (true) or not (false).
     */
    private boolean completionIndicator;
    /**
     * Text describing this event.
     */
    private TextRepresentation description;
    /**
     * An identifier for this event within an agreed event identification
     * scheme.
     */
    private IdentifierRepresentation identificationID;
    /**
     * The date of this event.
     */
    private LocalDate occurrenceDate;
    /**
     * The time of this event.
     */
    private LocalTime occurrenceTime;
    /**
     * A code signifying the type of this event.
     */
    private CodeRepresentation typeCode;
    private List<ContactRepresentation> contacts = new ArrayList<>();
    private LocationRepresentation occurenceLocation;
    private StatusRepresentation currentStatus;

}

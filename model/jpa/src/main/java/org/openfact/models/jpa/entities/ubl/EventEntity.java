package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe a significant occurrence relating to an object, process,
 * or person.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:53 a. m.
 */
public class EventEntity {

    /**
     * An indicator that this event has been completed (true) or not (false).
     */
    private boolean completionIndicator;
    /**
     * Text describing this event.
     */
    private TextType description;
    /**
     * An identifier for this event within an agreed event identification
     * scheme.
     */
    private IdentifierType identificationID;
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
    private CodeType typeCode;
    private List<ContactEntity> contacts = new ArrayList<>();
    private LocationEntity occurenceLocation;
    private StatusEntity currentStatus;

}

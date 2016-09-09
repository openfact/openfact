package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

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
    private IndicatorType CompletionIndicator;
    /**
     * Text describing this event.
     */
    private TextType Description;
    /**
     * An identifier for this event within an agreed event identification
     * scheme.
     */
    private IdentifierType IdentificationID;
    /**
     * The date of this event.
     */
    private DateType OccurrenceDate;
    /**
     * The time of this event.
     */
    private TimeType OccurrenceTime;
    /**
     * A code signifying the type of this event.
     */
    private CodeType TypeCode;
    private List<ContactEntity> Contacts = new ArrayList<>();
    private LocationEntity OccurenceLocation;
    private StatusEntity CurrentStatus;

}

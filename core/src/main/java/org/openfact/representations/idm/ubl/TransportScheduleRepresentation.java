package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.representations.idm.ubl.type.TextType;

/**
 * Describes the location and schedule relating to a transport means.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:49 a. m.
 */
public class TransportScheduleRepresentation {

    /**
     * The reference date for the transport schedule status.
     */
    private LocalDate referenceDate;
    /**
     * The reference time for the transport schedule status.
     */
    private LocalTime referenceTime;
    /**
     * The reliability of the transport schedule status, expressed as a
     * percentage.
     */
    private BigDecimal reliabilityPercent;
    /**
     * remarks related to the transport schedule status.
     */
    private TextType remarks;
    /**
     * A number indicating the order of this status in the sequence in which
     * statuses are to be presented.
     */
    private BigDecimal sequenceNumeric;
    private LocationRepresentation statusLocation;
    private TransportEventRepresentation actualDepartureTransportEvent;
    private TransportEventRepresentation estimatedDepartureTransportEvent;
    private TransportEventRepresentation estimatedArrivalTransportEvent;
    private TransportEventRepresentation plannedDepartureTransportEvent;
    private TransportEventRepresentation actualArrivalTransportEvent;
    private TransportEventRepresentation plannedArrivalTransportEvent;

}

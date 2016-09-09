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
 * A class to describe a significant occurrence or happening related to the
 * transportation of goods.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:42 a. m.
 */
public class TransportEventEntity {

    /**
     * An indicator that this transport event has been completed (true) or not
     * (false).
     */
    private IndicatorType CompletionIndicator;
    /**
     * Text describing this transport event.
     */
    private TextType Description;
    /**
     * An identifier for this transport event within an agreed event
     * identification scheme.
     */
    private IdentifierType IdentificationID;
    /**
     * The date of this transport event.
     */
    private DateType OccurrenceDate;
    /**
     * The time of this transport event.
     */
    private TimeType OccurrenceTime;
    /**
     * A code signifying the type of this transport event.
     */
    private CodeType TransportEventTypeCode;
    private List<ContactEntity> Contacts = new ArrayList<>();
    private List<LocationEntity> Locations = new ArrayList<>();
    private List<PeriodEntity> Periods = new ArrayList<>();
    private ShipmentEntity ReportedShipment;
    private StatusEntity CurrentStatus;
    private List<SignatureEntity> Signatures = new ArrayList<>();

}

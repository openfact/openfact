package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

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
    private boolean completionIndicator;
    /**
     * Text describing this transport event.
     */
    private TextType description;
    /**
     * An identifier for this transport event within an agreed event
     * identification scheme.
     */
    private IdentifierType identificationID;
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
    private CodeType transportEventTypeCode;
    private List<ContactEntity> contacts = new ArrayList<>();
    private List<LocationEntity> locations = new ArrayList<>();
    private List<PeriodEntity> periods = new ArrayList<>();
    private ShipmentEntity reportedShipment;
    private StatusEntity currentStatus;
    private List<SignatureEntity> signatures = new ArrayList<>();

}

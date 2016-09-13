package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a significant occurrence or happening related to the
 * transportation of goods.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:42 a. m.
 */
public class TransportEventModel {

    /**
     * An indicator that this transport event has been completed (true) or not
     * (false).
     */
    private boolean completionIndicator;
    /**
     * Text describing this transport event.
     */
    private TextModel description;
    /**
     * An identifier for this transport event within an agreed event
     * identification scheme.
     */
    private IdentifierModel identificationID;
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
    private CodeModel transportEventTypeCode;
    private List<ContactModel> contacts = new ArrayList<>();
    private List<LocationModel> locations = new ArrayList<>();
    private List<PeriodModel> periods = new ArrayList<>();
    private ShipmentModel reportedShipment;
    private StatusModel currentStatus;
    private List<SignatureModel> signatures = new ArrayList<>();

}
package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a specific, trackable instance of an item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:45 a. m.
 */
public class ItemInstanceModel {

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
    private IdentifierModel productTraceID;
    /**
     * The registration identifier of this item instance.
     */
    private IdentifierModel registrationID;
    /**
     * The serial number of this item instance.
     */
    private IdentifierModel serialID;
    private ItemPropertyModel additionalItemProperty;
    private List<LotIdentificationModel> lotIdentifications = new ArrayList<>();

}

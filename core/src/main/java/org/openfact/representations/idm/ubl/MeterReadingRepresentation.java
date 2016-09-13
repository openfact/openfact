package org.openfact.representations.idm.ubl;

import java.time.LocalDate;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a meter reading.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:09 a. m.
 */
public class MeterReadingRepresentation {

    /**
     * ConsumptionRepresentation in the period from previousMeterReadingDate to
     * LatestMeterReadingDate.
     */
    private QuantityRepresentation deliveredQuantity;
    /**
     * An identifier for this meter reading.
     */
    private IdentifierRepresentation ID;
    /**
     * The quantity of the latest meter reading.
     */
    private QuantityRepresentation latestMeterQuantity;
    /**
     * The date of the latest meter reading.
     */
    private LocalDate latestMeterReadingDate;
    /**
     * The method used for the latest meter reading, expressed as text.
     */
    private TextRepresentation latestMeterReadingMethod;
    /**
     * The method used for the latest meter reading, expressed as a code.
     */
    private CodeRepresentation latestMeterReadingMethodCode;
    /**
     * Text containing comments on this meter reading.
     */
    private TextRepresentation meterReadingComments;
    /**
     * The type of this meter reading, expressed as text.
     */
    private TextRepresentation meterReadingType;
    /**
     * The type of this meter reading, expressed as a code.
     */
    private CodeRepresentation meterReadingTypeCode;
    /**
     * The quantity of the previous meter reading.
     */
    private QuantityRepresentation previousMeterQuantity;
    /**
     * The date of the previous meter reading.
     */
    private LocalDate previousMeterReadingDate;
    /**
     * The method used for the previous meter reading, expressed as text.
     */
    private TextRepresentation previousMeterReadingMethod;
    /**
     * The method used for the previous meter reading, expressed as a code.
     */
    private CodeRepresentation previousMeterReadingMethodCode;

}

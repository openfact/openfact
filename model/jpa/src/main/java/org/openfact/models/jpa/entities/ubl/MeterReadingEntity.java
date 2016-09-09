package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a meter reading.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:09 a. m.
 */
public class MeterReadingEntity {

    /**
     * ConsumptionEntity in the period from previousMeterReadingDate to
     * latestMeterReadingDate.
     */
    private QuantityType deliveredQuantity;
    /**
     * An identifier for this meter reading.
     */
    private IdentifierType ID;
    /**
     * The quantity of the latest meter reading.
     */
    private QuantityType latestMeterQuantity;
    /**
     * The date of the latest meter reading.
     */
    private DateType latestMeterReadingDate;
    /**
     * The method used for the latest meter reading, expressed as text.
     */
    private TextType latestMeterReadingMethod;
    /**
     * The method used for the latest meter reading, expressed as a code.
     */
    private CodeType latestMeterReadingMethodCode;
    /**
     * Text containing comments on this meter reading.
     */
    private TextType meterReadingComments;
    /**
     * The type of this meter reading, expressed as text.
     */
    private TextType meterReadingType;
    /**
     * The type of this meter reading, expressed as a code.
     */
    private CodeType meterReadingTypeCode;
    /**
     * The quantity of the previous meter reading.
     */
    private QuantityType previousMeterQuantity;
    /**
     * The date of the previous meter reading.
     */
    private DateType previousMeterReadingDate;
    /**
     * The method used for the previous meter reading, expressed as text.
     */
    private TextType previousMeterReadingMethod;
    /**
     * The method used for the previous meter reading, expressed as a code.
     */
    private CodeType previousMeterReadingMethodCode;

}

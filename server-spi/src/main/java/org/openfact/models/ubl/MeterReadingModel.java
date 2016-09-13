package org.openfact.models.ubl;

import java.time.LocalDate;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a meter reading.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:09 a. m.
 */
public class MeterReadingModel {

    /**
     * ConsumptionModel in the period from previousMeterReadingDate to
     * LatestMeterReadingDate.
     */
    private QuantityModel deliveredQuantity;
    /**
     * An identifier for this meter reading.
     */
    private IdentifierModel ID;
    /**
     * The quantity of the latest meter reading.
     */
    private QuantityModel latestMeterQuantity;
    /**
     * The date of the latest meter reading.
     */
    private LocalDate latestMeterReadingDate;
    /**
     * The method used for the latest meter reading, expressed as text.
     */
    private TextModel latestMeterReadingMethod;
    /**
     * The method used for the latest meter reading, expressed as a code.
     */
    private CodeModel latestMeterReadingMethodCode;
    /**
     * Text containing comments on this meter reading.
     */
    private TextModel meterReadingComments;
    /**
     * The type of this meter reading, expressed as text.
     */
    private TextModel meterReadingType;
    /**
     * The type of this meter reading, expressed as a code.
     */
    private CodeModel meterReadingTypeCode;
    /**
     * The quantity of the previous meter reading.
     */
    private QuantityModel previousMeterQuantity;
    /**
     * The date of the previous meter reading.
     */
    private LocalDate previousMeterReadingDate;
    /**
     * The method used for the previous meter reading, expressed as text.
     */
    private TextModel previousMeterReadingMethod;
    /**
     * The method used for the previous meter reading, expressed as a code.
     */
    private CodeModel previousMeterReadingMethodCode;

}

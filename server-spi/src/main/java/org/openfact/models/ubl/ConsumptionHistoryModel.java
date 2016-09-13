package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe the measurement of a type of consumption during a
 * particular period, used for the subscriber to get an overview of his
 * consumption
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:50 a. m.
 */
public class ConsumptionHistoryModel {

    /**
     * The monetary amount to be charged for the quantity consumed.
     */
    private BigDecimal amount;
    /**
     * The consumption level, expressed as text, used explain the consumption
     * quantity, e.g.. diversion from the normal.
     */
    private TextModel consumptionLevel;
    /**
     * The consumption level, expressed as a code used explain the consumption
     * quantity, e.g.. diversion from the normal.
     */
    private CodeModel consumptionLevelCode;
    /**
     * Text describing the consumption itself.
     */
    private TextModel description;
    /**
     * A text identifier for the meter measuring the consumption.
     */
    private TextModel meterNumber;
    /**
     * The quantity consumed.
     */
    private QuantityModel quantity;
    private List<PeriodModel> periods = new ArrayList<>();

}

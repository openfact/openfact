package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to describe the measurement of a type of consumption during a
 * particular period, used for the subscriber to get an overview of his
 * consumption
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:50 a. m.
 */
public class ConsumptionHistoryRepresentation {

    /**
     * The monetary amount to be charged for the quantity consumed.
     */
    private BigDecimal amount;
    /**
     * The consumption level, expressed as text, used explain the consumption
     * quantity, e.g.. diversion from the normal.
     */
    private TextType consumptionLevel;
    /**
     * The consumption level, expressed as a code used explain the consumption
     * quantity, e.g.. diversion from the normal.
     */
    private CodeType consumptionLevelCode;
    /**
     * Text describing the consumption itself.
     */
    private TextType description;
    /**
     * A text identifier for the meter measuring the consumption.
     */
    private TextType meterNumber;
    /**
     * The quantity consumed.
     */
    private QuantityType quantity;
    private List<PeriodRepresentation> periods = new ArrayList<>();

}

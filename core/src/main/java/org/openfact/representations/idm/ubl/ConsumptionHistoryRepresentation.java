package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

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
    private TextRepresentation consumptionLevel;
    /**
     * The consumption level, expressed as a code used explain the consumption
     * quantity, e.g.. diversion from the normal.
     */
    private CodeRepresentation consumptionLevelCode;
    /**
     * Text describing the consumption itself.
     */
    private TextRepresentation description;
    /**
     * A text identifier for the meter measuring the consumption.
     */
    private TextRepresentation meterNumber;
    /**
     * The quantity consumed.
     */
    private QuantityRepresentation quantity;
    private List<PeriodRepresentation> periods = new ArrayList<>();

}

package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.amountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.quantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe the measurement of a type of consumption during a
 * particular period, used for the subscriber to get an overview of his
 * consumption
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:50 a. m.
 */
public class ConsumptionHistoryEntity {

    /**
     * The monetary amount to be charged for the quantity consumed.
     */
    private amountType amount;
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
    private quantityType quantity;
    private List<PeriodEntity> periods = new ArrayList<>();

}

package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;

import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define an average consumption as a monetary amount.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:47 a. m.
 */
public class ConsumptionAverageRepresentation {

    /**
     * The average monetary amount of the consumption.
     */
    private BigDecimal averageAmount;
    /**
     * A description of the average consumed.
     */
    private TextRepresentation description;

}

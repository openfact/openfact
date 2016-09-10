package org.openfact.models.ubl;

import java.math.BigDecimal;

import org.openfact.models.ubl.type.*;

/**
 * A class to define an average consumption as a monetary amount.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:47 a. m.
 */
public class ConsumptionAverageModel {

    /**
     * The average monetary amount of the consumption.
     */
    private BigDecimal averageAmount;
    /**
     * A description of the average consumed.
     */
    private TextType description;

}

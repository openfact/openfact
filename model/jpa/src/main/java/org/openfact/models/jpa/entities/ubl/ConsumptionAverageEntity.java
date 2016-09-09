package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to define an average consumption as a monetary amount.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:47 a. m.
 */
public class ConsumptionAverageEntity {

    /**
     * The average monetary amount of the consumption.
     */
    private AmountType AverageAmount;
    /**
     * A description of the average consumed.
     */
    private TextType Description;

}

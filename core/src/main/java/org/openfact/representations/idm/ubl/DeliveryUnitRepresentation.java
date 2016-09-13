package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.QuantityRepresentation;

/**
 * A class to describe a delivery unit.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:25 a. m.
 */
public class DeliveryUnitRepresentation {

    /**
     * The quantity of ordered Items that constitutes a batch for delivery
     * purposes.
     */
    private QuantityRepresentation batchQuantity;
    /**
     * The quantity of units in the DeliveryUnitRepresentation expressed in the
     * units used by the consumer.
     */
    private QuantityRepresentation consumerUnitQuantity;
    /**
     * An indication that the transported goods are subject to an international
     * regulation concerning the carriage of dangerous goods (true) or not
     * (false).
     */
    private boolean hazardousRiskIndicator;

}

package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to describe a delivery unit.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:25 a. m.
 */
public class DeliveryUnit {

    /**
     * The quantity of ordered Items that constitutes a batch for delivery
     * purposes.
     */
    private BigDecimal batchQuantity;
    /**
     * The quantity of units in the Delivery Unit expressed in the units used by
     * the consumer.
     */
    private BigDecimal consumerUnitQuantity;
    /**
     * An indication that the transported goods are subject to an international
     * regulation concerning the carriage of dangerous goods (true) or not
     * (false).
     */
    private boolean hazardousRiskIndicator;

    public DeliveryUnit() {

    }

    public void finalize() throws Throwable {

    }

    public BigDecimal getBatchQuantity() {
        return batchQuantity;
    }

    public void setBatchQuantity(BigDecimal batchQuantity) {
        this.batchQuantity = batchQuantity;
    }

    public BigDecimal getConsumerUnitQuantity() {
        return consumerUnitQuantity;
    }

    public void setConsumerUnitQuantity(BigDecimal consumerUnitQuantity) {
        this.consumerUnitQuantity = consumerUnitQuantity;
    }

    public boolean isHazardousRiskIndicator() {
        return hazardousRiskIndicator;
    }

    public void setHazardousRiskIndicator(boolean hazardousRiskIndicator) {
        this.hazardousRiskIndicator = hazardousRiskIndicator;
    }
}// end Delivery Unit
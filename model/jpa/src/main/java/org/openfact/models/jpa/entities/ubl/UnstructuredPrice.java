package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A simplified version of the Price class intended for applications such as
 * telephone billing.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:54 a. m.
 */
public class UnstructuredPrice {

    /**
     * The price amount.
     */
    private BigDecimal priceAmount;
    /**
     * The usage time upon which the price is based.
     */
    private String timeAmount;

    /**
     * @return the priceAmount
     */
    public BigDecimal getPriceAmount() {
        return priceAmount;
    }

    /**
     * @param priceAmount
     *            the priceAmount to set
     */
    public void setPriceAmount(BigDecimal priceAmount) {
        this.priceAmount = priceAmount;
    }

    /**
     * @return the timeAmount
     */
    public String getTimeAmount() {
        return timeAmount;
    }

    /**
     * @param timeAmount
     *            the timeAmount to set
     */
    public void setTimeAmount(String timeAmount) {
        this.timeAmount = timeAmount;
    }

}// end Unstructured Price
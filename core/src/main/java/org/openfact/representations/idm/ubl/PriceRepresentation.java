package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;

/**
 * A class to describe a price, expressed in a data structure containing
 * multiple properties (compare with UnstructuredPrice).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:52 a. m.
 */
public class PriceRepresentation {

    /**
     * The amount of the price.
     */
    private BigDecimal priceAmount;

    /**
     * The type of price, expressed as a code.
     */
    private String priceTypeCode;

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
     * @return the priceTypeCode
     */
    public String getPriceTypeCode() {
        return priceTypeCode;
    }

    /**
     * @param priceTypeCode
     *            the priceTypeCode to set
     */
    public void setPriceTypeCode(String priceTypeCode) {
        this.priceTypeCode = priceTypeCode;
    }

}

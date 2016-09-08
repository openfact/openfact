package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe the renewal of a commercial arrangement, such as a
 * contract or licence fee.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:26 a. m.
 */
public class Renewal {

    /**
     * The monetary amount of this renewal.
     */
    private BigDecimal Amount;
    private List<Period> periods = new ArrayList<>();

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return Amount;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    /**
     * @return the periods
     */
    public List<Period> getPeriods() {
        return periods;
    }

    /**
     * @param periods
     *            the periods to set
     */
    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }

}// end Renewal
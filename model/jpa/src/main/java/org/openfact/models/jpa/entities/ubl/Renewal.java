package org.openfact.models.jpa.entities.ubl;

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
    private Amount.Type Amount;
    private Period m_Period;

    public Renewal() {

    }

    public void finalize() throws Throwable {

    }

    public Amount.Type getAmount() {
        return Amount;
    }

    public Period getPeriod() {
        return m_Period;
    }

    /**
     * 
     * @param newVal
     */
    public void setAmount(Amount.Type newVal) {
        Amount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPeriod(Period newVal) {
        m_Period = newVal;
    }
}// end Renewal
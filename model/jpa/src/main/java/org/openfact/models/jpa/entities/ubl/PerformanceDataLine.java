package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to define a line in a Performance History.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:42 a. m.
 */
public class PerformanceDataLine {

    /**
     * An identifier for this performance data line.
     */
    private String ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String Note;
    /**
     * A code signifying the measure of performance applicable to the reported
     * attribute.
     */
    private String PerformanceMetricTypeCode;
    /**
     * The value of the reported attribute.
     */
    private BigDecimal PerformanceValueQuantity;
    private Item m_Item;
    private Period m_Period;

    public PerformanceDataLine() {

    }

    public void finalize() throws Throwable {

    }

    public String getID() {
        return ID;
    }

    public Item getItem() {
        return m_Item;
    }

    public String getNote() {
        return Note;
    }

    public String getPerformanceMetricTypeCode() {
        return PerformanceMetricTypeCode;
    }

    public BigDecimal getPerformanceValueQuantity() {
        return PerformanceValueQuantity;
    }

    public Period getPeriod() {
        return m_Period;
    }

    /**
     * 
     * @param newVal
     */
    public void setID(String newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setItem(Item newVal) {
        m_Item = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNote(String newVal) {
        Note = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPerformanceMetricTypeCode(String newVal) {
        PerformanceMetricTypeCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPerformanceValueQuantity(BigDecimal newVal) {
        PerformanceValueQuantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPeriod(Period newVal) {
        m_Period = newVal;
    }
}// end Performance Data Line
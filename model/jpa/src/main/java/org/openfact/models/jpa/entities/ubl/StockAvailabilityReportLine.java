package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to define a line in a Stock Availability Report describing the
 * availability of an item of sale.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:52 a. m.
 */
public class StockAvailabilityReportLine {

    /**
     * The date from which the item will be available. A date identical to or
     * earlier than the IssueDate of the Stock Availability Report means that
     * the item is available now
     */
    private LocalDate AvailabilityDate;
    /**
     * A code signifying the level of availability of the item.
     */
    private String AvailabilityStatusCode;
    /**
     * An identifier for this stock availability line.
     */
    private String ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String Note;
    /**
     * The quantity of the item currently in stock.
     */
    private BigDecimal Quantity;
    /**
     * The monetary value of the quantity of the item currently in stock.
     */
    private BigDecimal ValueAmount;
    private Item m_Item;

    public StockAvailabilityReportLine() {

    }

    public void finalize() throws Throwable {

    }

    public LocalDate getAvailabilityDate() {
        return AvailabilityDate;
    }

    public String getAvailabilityStatusCode() {
        return AvailabilityStatusCode;
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

    public BigDecimal getQuantity() {
        return Quantity;
    }

    public BigDecimal getValueAmount() {
        return ValueAmount;
    }

    /**
     * 
     * @param newVal
     */
    public void setAvailabilityDate(LocalDate newVal) {
        AvailabilityDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setAvailabilityStatusCode(String newVal) {
        AvailabilityStatusCode = newVal;
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
    public void setQuantity(BigDecimal newVal) {
        Quantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setValueAmount(BigDecimal newVal) {
        ValueAmount = newVal;
    }
}// end Stock Availability Report Line
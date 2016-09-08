package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
    private List<Item> items = new ArrayList<>();

    /**
     * @return the availabilityDate
     */
    public LocalDate getAvailabilityDate() {
        return AvailabilityDate;
    }

    /**
     * @param availabilityDate
     *            the availabilityDate to set
     */
    public void setAvailabilityDate(LocalDate availabilityDate) {
        AvailabilityDate = availabilityDate;
    }

    /**
     * @return the availabilityStatusCode
     */
    public String getAvailabilityStatusCode() {
        return AvailabilityStatusCode;
    }

    /**
     * @param availabilityStatusCode
     *            the availabilityStatusCode to set
     */
    public void setAvailabilityStatusCode(String availabilityStatusCode) {
        AvailabilityStatusCode = availabilityStatusCode;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        Note = note;
    }

    /**
     * @return the quantity
     */
    public BigDecimal getQuantity() {
        return Quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(BigDecimal quantity) {
        Quantity = quantity;
    }

    /**
     * @return the valueAmount
     */
    public BigDecimal getValueAmount() {
        return ValueAmount;
    }

    /**
     * @param valueAmount
     *            the valueAmount to set
     */
    public void setValueAmount(BigDecimal valueAmount) {
        ValueAmount = valueAmount;
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items
     *            the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

}// end Stock Availability Report Line
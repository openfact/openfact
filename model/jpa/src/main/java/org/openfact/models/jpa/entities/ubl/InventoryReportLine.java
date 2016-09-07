package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to define a line in an Inventory Report.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:35 a. m.
 */
public class InventoryReportLine {

    /**
     * The date from which the goods will be available. If not present, the
     * goods are available now.
     */
    private LocalDate availabilityDate;
    /**
     * A code signifying the item's level of availability.
     */
    private String availabilityStatusCode;
    /**
     * An identifier for this inventory report line.
     */
    private String ID;
    /**
     * The value of the quantity of the item reported that is currently in
     * stock.
     */
    private BigDecimal inventoryValueAmount;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String note;

    /**
     * The quantity of the item reported that is currently in stock.
     */
    private BigDecimal quantity;
    private List<Item> items = new ArrayList<>();
    private Location inventoryLocation;

    /**
     * @return the availabilityDate
     */
    public LocalDate getAvailabilityDate() {
        return availabilityDate;
    }

    /**
     * @param availabilityDate
     *            the availabilityDate to set
     */
    public void setAvailabilityDate(LocalDate availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    /**
     * @return the availabilityStatusCode
     */
    public String getAvailabilityStatusCode() {
        return availabilityStatusCode;
    }

    /**
     * @param availabilityStatusCode
     *            the availabilityStatusCode to set
     */
    public void setAvailabilityStatusCode(String availabilityStatusCode) {
        this.availabilityStatusCode = availabilityStatusCode;
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
     * @return the inventoryValueAmount
     */
    public BigDecimal getInventoryValueAmount() {
        return inventoryValueAmount;
    }

    /**
     * @param inventoryValueAmount
     *            the inventoryValueAmount to set
     */
    public void setInventoryValueAmount(BigDecimal inventoryValueAmount) {
        this.inventoryValueAmount = inventoryValueAmount;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the quantity
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
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

    /**
     * @return the inventoryLocation
     */
    public Location getInventoryLocation() {
        return inventoryLocation;
    }

    /**
     * @param inventoryLocation
     *            the inventoryLocation to set
     */
    public void setInventoryLocation(Location inventoryLocation) {
        this.inventoryLocation = inventoryLocation;
    }

}// end Inventory Report Line
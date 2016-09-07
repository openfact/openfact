package org.openfact.models.jpa.entities.ubl;

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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public LocalDate getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(LocalDate availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    public String getAvailabilityStatusCode() {
        return availabilityStatusCode;
    }

    public void setAvailabilityStatusCode(String availabilityStatusCode) {
        this.availabilityStatusCode = availabilityStatusCode;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public BigDecimal getInventoryValueAmount() {
        return inventoryValueAmount;
    }

    public void setInventoryValueAmount(BigDecimal inventoryValueAmount) {
        this.inventoryValueAmount = inventoryValueAmount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Item getM_Item() {
        return m_Item;
    }

    public void setM_Item(Item m_Item) {
        this.m_Item = m_Item;
    }

    public Location getInventoryLocation() {
        return inventoryLocation;
    }

    public void setInventoryLocation(Location inventoryLocation) {
        this.inventoryLocation = inventoryLocation;
    }

    /**
     * The quantity of the item reported that is currently in stock.
     */
    private BigDecimal quantity;
    private Item m_Item;
    private Location inventoryLocation;

}// end Inventory Report Line
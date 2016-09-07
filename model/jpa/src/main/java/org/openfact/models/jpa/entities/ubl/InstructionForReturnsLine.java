package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a line in an Instruction for Returns.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:33 a. m.
 */
public class InstructionForReturnsLine {

    /**
     * An identifier for this instruction for returns line.
     */
    private String ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String note;
    /**
     * The quantity of goods being returned.
     */
    private BigDecimal quantity;
    private List<Item> items = new ArrayList<>();
    private Party manufacturerParty;

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
     * @return the manufacturerParty
     */
    public Party getManufacturerParty() {
        return manufacturerParty;
    }

    /**
     * @param manufacturerParty
     *            the manufacturerParty to set
     */
    public void setManufacturerParty(Party manufacturerParty) {
        this.manufacturerParty = manufacturerParty;
    }

}// end Instruction For Returns Line
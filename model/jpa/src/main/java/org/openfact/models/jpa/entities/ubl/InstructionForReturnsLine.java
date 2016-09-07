package org.openfact.models.jpa.entities.ubl;

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
    private Item m_Item;
    private Party manufacturerParty;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Item getM_Item() {
        return m_Item;
    }

    public void setM_Item(Item m_Item) {
        this.m_Item = m_Item;
    }

    public Party getManufacturerParty() {
        return manufacturerParty;
    }

    public void setManufacturerParty(Party manufacturerParty) {
        this.manufacturerParty = manufacturerParty;
    }
}// end Instruction For Returns Line
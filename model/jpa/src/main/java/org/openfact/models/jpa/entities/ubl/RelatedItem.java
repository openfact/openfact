package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to describe the relationship to an item different from the item
 * associated with the item line in which RelatedItem is used.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:22 a. m.
 */
public class RelatedItem {

    /**
     * Text describing the relationship.
     */
    private String description;
    /**
     * An identifier for the related item.
     */
    private String ID;
    /**
     * The quantity that applies to the relationship.
     */
    private BigDecimal quantity;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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

}// end Related Item
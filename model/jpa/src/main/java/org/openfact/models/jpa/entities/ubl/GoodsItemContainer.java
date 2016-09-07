package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class defining how goods items are split across transport equipment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:25 a. m.
 */
public class GoodsItemContainer {

    /**
     * An identifier for this goods item container.
     */
    private String ID;
    /**
     * The number of goods items loaded into or onto one piece of transport
     * equipment as a total consignment or part of a consignment.
     */
    private BigDecimal quantity;
    private TransportEquipment m_TransportEquipment;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public TransportEquipment getM_TransportEquipment() {
        return m_TransportEquipment;
    }

    public void setM_TransportEquipment(TransportEquipment m_TransportEquipment) {
        this.m_TransportEquipment = m_TransportEquipment;
    }
}// end Goods Item Container
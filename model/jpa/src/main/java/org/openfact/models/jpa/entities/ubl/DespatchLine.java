package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to define a line in a Despatch Advice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:29 a. m.
 */
public class DespatchLine {

    /**
     * The quantity on back order at the supplier.
     */
    private BigDecimal backorderQuantity;
    /**
     * The reason for the back order.
     */
    private String backorderReason;
    /**
     * The quantity despatched (picked up).
     */
    private BigDecimal deliveredQuantity;
    /**
     * An identifier for this despatch line.
     */
    private String ID;
    /**
     * A code signifying the status of this despatch line with respect to its
     * original state.
     */
    private String lineStatusCode;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String note;
    /**
     * The quantity outstanding (which will follow in a later despatch).
     */
    private BigDecimal outstandingQuantity;
    /**
     * The reason for the outstanding quantity.
     */
    private String outstandingReason;
    /**
     * The quantity over-supplied, i.e., the quantity over and above that
     * ordered.
     */
    private BigDecimal oversupplyQuantity;
    /**
     * A universally unique identifier for this despatch line.
     */
    private String UUID;
    private DocumentReference m_DocumentReference;
    private Item m_Item;
    private OrderLineReference m_OrderLineReference;
    private Shipment m_Shipment;

    public DespatchLine() {

    }

    public void finalize() throws Throwable {

    }

    public BigDecimal getBackorderQuantity() {
        return backorderQuantity;
    }

    public void setBackorderQuantity(BigDecimal backorderQuantity) {
        this.backorderQuantity = backorderQuantity;
    }

    public String getBackorderReason() {
        return backorderReason;
    }

    public void setBackorderReason(String backorderReason) {
        this.backorderReason = backorderReason;
    }

    public BigDecimal getDeliveredQuantity() {
        return deliveredQuantity;
    }

    public void setDeliveredQuantity(BigDecimal deliveredQuantity) {
        this.deliveredQuantity = deliveredQuantity;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLineStatusCode() {
        return lineStatusCode;
    }

    public void setLineStatusCode(String lineStatusCode) {
        this.lineStatusCode = lineStatusCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigDecimal getOutstandingQuantity() {
        return outstandingQuantity;
    }

    public void setOutstandingQuantity(BigDecimal outstandingQuantity) {
        this.outstandingQuantity = outstandingQuantity;
    }

    public String getOutstandingReason() {
        return outstandingReason;
    }

    public void setOutstandingReason(String outstandingReason) {
        this.outstandingReason = outstandingReason;
    }

    public BigDecimal getOversupplyQuantity() {
        return oversupplyQuantity;
    }

    public void setOversupplyQuantity(BigDecimal oversupplyQuantity) {
        this.oversupplyQuantity = oversupplyQuantity;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public DocumentReference getM_DocumentReference() {
        return m_DocumentReference;
    }

    public void setM_DocumentReference(DocumentReference m_DocumentReference) {
        this.m_DocumentReference = m_DocumentReference;
    }

    public Item getM_Item() {
        return m_Item;
    }

    public void setM_Item(Item m_Item) {
        this.m_Item = m_Item;
    }

    public OrderLineReference getM_OrderLineReference() {
        return m_OrderLineReference;
    }

    public void setM_OrderLineReference(OrderLineReference m_OrderLineReference) {
        this.m_OrderLineReference = m_OrderLineReference;
    }

    public Shipment getM_Shipment() {
        return m_Shipment;
    }

    public void setM_Shipment(Shipment m_Shipment) {
        this.m_Shipment = m_Shipment;
    }
}// end DespatchLine
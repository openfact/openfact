package org.openfact.representations.idm.ubl.common;

public class OrderLineReferenceRepresentation {
    private String lineID;
    private String salesOrderLineID;
    private String UUID;
    private String lineStatusCode;
    private OrderReferenceRepresentation orderReference;
    private String id;

    public String getLineStatusCode() {
        return this.lineStatusCode;
    }

    public void setLineStatusCode(String lineStatusCode) {
        this.lineStatusCode = lineStatusCode;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUUID() {
        return this.UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getLineID() {
        return this.lineID;
    }

    public void setLineID(String lineID) {
        this.lineID = lineID;
    }

    public String getSalesOrderLineID() {
        return this.salesOrderLineID;
    }

    public void setSalesOrderLineID(String salesOrderLineID) {
        this.salesOrderLineID = salesOrderLineID;
    }

    public OrderReferenceRepresentation getOrderReference() {
        return this.orderReference;
    }

    public void setOrderReference(OrderReferenceRepresentation orderReference) {
        this.orderReference = orderReference;
    }
}
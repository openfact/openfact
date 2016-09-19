package org.openfact.models.jpa.ubl.common;

public class OrderLineReferenceAdapter
        implements OrderLineReferenceModel, JpaModel<OrderLineReferenceEntity> {

    protected static final Logger logger = Logger.getLogger(OrderLineReferenceAdapter.class);
    protected OrderLineReferenceEntity orderLineReference;
    protected EntityManager em;
    protected OpenfactSession session;

    public OrderLineReferenceAdapter(OpenfactSession session, EntityManager em,
            OrderLineReferenceEntity orderLineReference) {
        this.session = session;
        this.em = em;
        this.orderLineReference = orderLineReference;
    }

    String getLineID() {
        return this.orderLineReference.getLineID();
    }

    void setLineID(String value) {
        this.orderLineReference.setLineID(value);
    }

    String getSalesOrderLineID() {
        return this.orderLineReference.getSalesOrderLineID();
    }

    void setSalesOrderLineID(String value) {
        this.orderLineReference.setSalesOrderLineID(value);
    }

    String getUUID() {
        return this.orderLineReference.getUUID();
    }

    void setUUID(String value) {
        this.orderLineReference.setUUID(value);
    }

    String getLineStatusCode() {
        return this.orderLineReference.getLineStatusCode();
    }

    void setLineStatusCode(String value) {
        this.orderLineReference.setLineStatusCode(value);
    }

    OrderReferenceAdapter getOrderReference() {
        return this.orderLineReference.getOrderReference();
    }

    void setOrderReference(OrderReferenceAdapter value) {
        this.orderLineReference.setOrderReference(value);
    }

    String getId() {
        return this.orderLineReference.getId();
    }

    void setId(String value) {
        this.orderLineReference.setId(value);
    }

}

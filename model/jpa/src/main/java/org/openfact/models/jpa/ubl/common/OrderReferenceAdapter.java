package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrderReferenceAdapter implements OrderReferenceModel, JpaModel<OrderReferenceEntity> {

    protected static final Logger logger = Logger.getLogger(OrderReferenceAdapter.class);
    protected OrderReferenceEntity orderReference;
    protected EntityManager em;
    protected OpenfactSession session;

    public OrderReferenceAdapter(OpenfactSession session, EntityManager em,
            OrderReferenceEntity orderReference) {
        this.session = session;
        this.em = em;
        this.orderReference = orderReference;
    }

    String getID() {
        return this.orderReference.getID();
    }

    void setID(String value) {
        this.orderReference.setID(value);
    }

    String getSalesOrderID() {
        return this.orderReference.getSalesOrderID();
    }

    void setSalesOrderID(String value) {
        this.orderReference.setSalesOrderID(value);
    }

    boolean getCopyIndicator() {
        return this.orderReference.getCopyIndicator();
    }

    void setCopyIndicator(boolean value) {
        this.orderReference.setCopyIndicator(value);
    }

    String getUUID() {
        return this.orderReference.getUUID();
    }

    void setUUID(String value) {
        this.orderReference.setUUID(value);
    }

    LocalDate getIssueDate() {
        return this.orderReference.getIssueDate();
    }

    void setIssueDate(LocalDate value) {
        this.orderReference.setIssueDate(value);
    }

    LocalTime getIssueTime() {
        return this.orderReference.getIssueTime();
    }

    void setIssueTime(LocalTime value) {
        this.orderReference.setIssueTime(value);
    }

    String getCustomerReference() {
        return this.orderReference.getCustomerReference();
    }

    void setCustomerReference(String value) {
        this.orderReference.setCustomerReference(value);
    }

    DocumentReferenceAdapter getDocumentReference() {
        return this.orderReference.getDocumentReference();
    }

    void setDocumentReference(DocumentReferenceAdapter value) {
        this.orderReference.setDocumentReference(value);
    }

    String getId() {
        return this.orderReference.getId();
    }

    void setId(String value) {
        this.orderReference.setId(value);
    }

}

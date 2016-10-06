package org.openfact.models.ubl.common;

public interface OrderLineReferenceModel {

    String getLineID();

    void setLineID(String value);

    String getSalesOrderLineID();

    void setSalesOrderLineID(String value);

    String getUUID();

    void setUUID(String value);

    String getLineStatusCode();

    void setLineStatusCode(String value);

    OrderReferenceModel getOrderReference();

    void setOrderReference(OrderReferenceModel value);

    String getId();

    

}

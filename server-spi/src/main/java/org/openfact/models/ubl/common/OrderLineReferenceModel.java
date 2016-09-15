package org.openfact.models.ubl.common;

public interface OrderLineReferenceModel {

    LineIDModel getLineID();

    void setLineID(LineIDModel value);

    SalesOrderLineIDModel getSalesOrderLineID();

    void setSalesOrderLineID(SalesOrderLineIDModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    LineStatusCodeModelCommBas getLineStatusCode();

    void setLineStatusCode(LineStatusCodeModelCommBas value);

    OrderReferenceModel getOrderReference();

    void setOrderReference(OrderReferenceModel value);

    String getId();

    void setId(String value);

}

package org.openfact.models.ubl.common;

public interface OrderLineReferenceType {

    LineIDType getLineID();

    void setLineID(LineIDType value);

    SalesOrderLineIDType getSalesOrderLineID();

    void setSalesOrderLineID(SalesOrderLineIDType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    LineStatusCodeTypeCommBas getLineStatusCode();

    void setLineStatusCode(LineStatusCodeTypeCommBas value);

    OrderReferenceType getOrderReference();

    void setOrderReference(OrderReferenceType value);

    String getId();

    void setId(String value);

}

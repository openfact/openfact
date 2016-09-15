package org.openfact.models.ubl.common;

public interface OrderReferenceType {

    IDType getID();

    void setID(IDType value);

    SalesOrderIDType getSalesOrderID();

    void setSalesOrderID(SalesOrderIDType value);

    CopyIndicatorType getCopyIndicator();

    void setCopyIndicator(CopyIndicatorType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    IssueDateType getIssueDate();

    void setIssueDate(IssueDateType value);

    IssueTimeType getIssueTime();

    void setIssueTime(IssueTimeType value);

    CustomerReferenceType getCustomerReference();

    void setCustomerReference(CustomerReferenceType value);

    DocumentReferenceType getDocumentReference();

    void setDocumentReference(DocumentReferenceType value);

    String getId();

    void setId(String value);

}

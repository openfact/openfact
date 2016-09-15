package org.openfact.models.ubl.common;

public interface OrderReferenceModel {

    IDModel getID();

    void setID(IDModel value);

    SalesOrderIDModel getSalesOrderID();

    void setSalesOrderID(SalesOrderIDModel value);

    CopyIndicatorModel getCopyIndicator();

    void setCopyIndicator(CopyIndicatorModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    IssueDateModel getIssueDate();

    void setIssueDate(IssueDateModel value);

    IssueTimeModel getIssueTime();

    void setIssueTime(IssueTimeModel value);

    CustomerReferenceModel getCustomerReference();

    void setCustomerReference(CustomerReferenceModel value);

    DocumentReferenceModel getDocumentReference();

    void setDocumentReference(DocumentReferenceModel value);

    String getId();

    void setId(String value);

}

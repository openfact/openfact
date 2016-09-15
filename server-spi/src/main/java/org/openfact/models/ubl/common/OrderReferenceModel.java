package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
public interface OrderReferenceModel {

    IDModel getID();

    void setID(IDModel value);

    SalesOrderIDModel getSalesOrderID();

    void setSalesOrderID(SalesOrderIDModel value);

    CopyIndicatorModel getCopyIndicator();

    void setCopyIndicator(CopyIndicatorModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate value);

    LocalTime getIssueTime();

    void setIssueTime(LocalTime value);

    CustomerReferenceModel getCustomerReference();

    void setCustomerReference(CustomerReferenceModel value);

    DocumentReferenceModel getDocumentReference();

    void setDocumentReference(DocumentReferenceModel value);

    String getId();

    void setId(String value);

}

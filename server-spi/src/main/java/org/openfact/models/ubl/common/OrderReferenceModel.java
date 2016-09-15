package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
public interface OrderReferenceModel {

    String getID();

    void setID(String value);

    String getSalesOrderID();

    void setSalesOrderID(String value);

    CopyIndicatorModel getCopyIndicator();

    void setCopyIndicator(CopyIndicatorModel value);

    String getUUID();

    void setUUID(String value);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate value);

    LocalTime getIssueTime();

    void setIssueTime(LocalTime value);

    String getCustomerReference();

    void setCustomerReference(String value);

    DocumentReferenceModel getDocumentReference();

    void setDocumentReference(DocumentReferenceModel value);

    String getId();

    void setId(String value);

}

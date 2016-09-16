package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrderReferenceRepresentation {
    private String ID;
    private String salesOrderID;
    private Boolean copyIndicator;
    private String UUID;
    private LocalDate issueDate;
    private LocalTime issueTime;
    private String customerReference;
    private DocumentReferenceRepresentation documentReference;
    private String id;

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DocumentReferenceRepresentation getDocumentReference() {
        return this.documentReference;
    }

    public void setDocumentReference(DocumentReferenceRepresentation documentReference) {
        this.documentReference = documentReference;
    }

    public String getSalesOrderID() {
        return this.salesOrderID;
    }

    public void setSalesOrderID(String salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    public String getUUID() {
        return this.UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public LocalDate getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalTime getIssueTime() {
        return this.issueTime;
    }

    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
    }

    public Boolean getCopyIndicator() {
        return this.copyIndicator;
    }

    public void setCopyIndicator(Boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    public String getCustomerReference() {
        return this.customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }
}
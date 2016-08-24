package org.openfact.models;

public interface CustomerModel {

    String getId();

    String getRegistrationName();

    String getAssignedIdentificationId();

    void setAssignedIdentificationId(String assignedIdentificationId);

    DocumentSnapshotModel getAdditionalAccountId();

    void setAdditionalAccountId(String documentName, String documentId);

    String getEmail();

    void setEmail(String email);

    InvoiceModel getInvoice();

}

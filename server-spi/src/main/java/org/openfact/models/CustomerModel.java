package org.openfact.models;

public interface CustomerModel {

    String getId();

    String getRegistrationName();

    void setRegistrationName(String registrationName);

    String getAssignedIdentificationId();

    void setAssignedIdentificationId(String assignedIdentificationId);

    String getEmail();

    void setEmail(String email);

    InvoiceModel getInvoice();

    /**
     * Additional account
     */
    String getAdditionalAccountIdName();

    void setAdditionalAccountIdName(String additionalAccountIdName);

    String getAdditionalAccountId_Id();

    void setAdditionalAccountId_Id(String additionalAccountId);
}

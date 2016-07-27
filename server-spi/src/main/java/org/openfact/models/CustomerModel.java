package org.openfact.models;

import org.openfact.models.enums.AdditionalAccountType;

public interface CustomerModel {

    String getId();

    String getRegistrationName();

    String getAssignedIdentificationId();

    void setAssignedIdentificationId(String assignedIdentificationId);

    AdditionalAccountType getAdditionalAccountId();

    void setAdditionalAccountId(AdditionalAccountType additionalAccountId);

    String getEmail();

    void setEmail(String email);

    InvoiceModel getInvoice();

}

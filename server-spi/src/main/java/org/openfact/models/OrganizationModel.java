package org.openfact.models;

import java.util.List;

import org.openfact.models.enums.AdditionalAccountType;

public interface OrganizationModel {

    String NAME = "name";
    
    String getId();

    String getName();

    void setName(String name);

    boolean isEnabled();

    void setEnabled(boolean enabled);

    String getAssignedIdentificationId();

    void setAssignedIdentificationId(String assignedIdentificationId);

    AdditionalAccountType getAdditionalAccountId();

    void setAdditionalAccountId(AdditionalAccountType additionalAccountId);

    String getSupplierName();

    void setSupplierName(String supplierName);

    String getRegistrationName();

    void setRegistrationName(String registrationName);

    PostalAddressModel getPostalAddress();

    void setPostalAddress(PostalAddressModel postalAddress);
    
    List<InvoiceModel> getInvoices();

}

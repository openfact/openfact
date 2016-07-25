package org.openfact.models;

import org.openfact.models.enums.AdditionalAccountType;

public interface OrganizationModel {

    public static final String NAME = "name";
    
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

}

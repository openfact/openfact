package org.openfact.models;

import org.openfact.models.enums.AdditionalAccountType;

public interface CustomerModel {

    String getId();

    String getRegistrationName();

    String getAssignedIdentificationId();

    AdditionalAccountType getAdditionalAccountId();

}

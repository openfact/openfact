package org.openfact.ubl;

import org.openfact.models.OrganizationModel;

public interface SendEventModel {

    String getId();

    boolean getResult();

    void setResult(boolean result);

    String getDescription();

    void setDescription(String description);

    OrganizationModel getOrganization();
}

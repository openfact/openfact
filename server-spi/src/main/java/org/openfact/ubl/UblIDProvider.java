package org.openfact.ubl;

import org.openfact.models.OrganizationModel;
import org.openfact.provider.Provider;

public interface UblIDProvider extends Provider {

    public String getDocument(OrganizationModel organization);

}
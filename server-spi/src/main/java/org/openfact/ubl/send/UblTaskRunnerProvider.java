package org.openfact.ubl.send;

import org.openfact.models.OrganizationModel;
import org.openfact.provider.Provider;

public interface UblTaskRunnerProvider extends Provider {

    void exececuteTask(OrganizationModel organization);

}

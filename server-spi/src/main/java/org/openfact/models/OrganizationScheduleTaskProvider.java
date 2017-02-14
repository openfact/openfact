package org.openfact.models;

import org.openfact.provider.Provider;

public interface OrganizationScheduleTaskProvider extends Provider {

    boolean isActive();

    void run(OpenfactSession session, OrganizationModel organization) throws JobException;

}

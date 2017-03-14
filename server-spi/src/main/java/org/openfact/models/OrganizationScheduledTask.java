package org.openfact.models;

public interface OrganizationScheduledTask {

    String isEnabled();

    String getName();

    String getDescription();

    void executeTask(OrganizationModel organization);
}

package org.openfact.models;

public interface OrganizationScheduledTask {

    boolean isEnabled();

    String getName();

    String getDescription();

    void executeTask(OrganizationModel organization);
}

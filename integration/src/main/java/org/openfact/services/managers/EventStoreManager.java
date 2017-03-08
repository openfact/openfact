package org.openfact.services.managers;

import org.openfact.events.EventStoreProvider;
import org.openfact.events.admin.AdminEvent;
import org.openfact.models.OrganizationModel;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EventStoreManager {

    @Inject
    private EventStoreProvider eventStoreProvider;

    public void send(OrganizationModel organization, AdminEvent adminEvent) {
        if (organization.isAdminEventsEnabled()) {
            eventStoreProvider.onEvent(adminEvent, organization.isAdminEventsDetailsEnabled());
        }
    }
}

package org.openfact.services.scheduled;

import org.openfact.events.EventStoreProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.timer.ScheduledTask;

public class ClearExpiredEvents implements ScheduledTask {

    @Override
    public void run(OpenfactSession session) {
        EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        if (eventStore != null) {
            for (OrganizationModel organization : session.organizations().getOrganizations()) {
                if (organization.isEventsEnabled() && organization.getEventsExpiration() > 0) {
                    long olderThan = System.currentTimeMillis() - organization.getEventsExpiration() * 1000;
                    eventStore.clear(organization.getId(), olderThan);
                }
            }
        }
    }

}

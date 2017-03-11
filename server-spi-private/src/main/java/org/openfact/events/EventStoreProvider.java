package org.openfact.events;

import org.openfact.events.admin.AdminEvent;
import org.openfact.events.admin.AdminEventQuery;

public interface EventStoreProvider {

    AdminEventQuery createQuery();

    void onEvent(AdminEvent event, boolean includeRepresentation);

    void clear();

    void clear(String organizationId);

    void clear(String organizationId, long olderThan);

    void clearAdmin();

    void clearAdmin(String organizationId);

    void clearAdmin(String organizationId, long olderThan);

}

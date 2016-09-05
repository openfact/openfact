package org.openfact.events;

import org.openfact.events.admin.AdminEventQuery;

public interface EventStoreProvider extends EventListenerProvider {

    public EventQuery createQuery();

    public AdminEventQuery createAdminQuery();

    public void clear();

    public void clear(String organizationId);

    public void clear(String organizationId, long olderThan);

    public void clearAdmin();

    public void clearAdmin(String organizationId);

    public void clearAdmin(String organizationId, long olderThan);

}

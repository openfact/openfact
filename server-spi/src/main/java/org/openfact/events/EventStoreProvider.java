package org.openfact.events;

import org.openfact.events.admin.AdminEventQuery;

public interface EventStoreProvider extends EventListenerProvider {

    public EventQuery createQuery();

    public AdminEventQuery createAdminQuery();

    public void clear();

    public void clear(String realmId);

    public void clear(String realmId, long olderThan);

    public void clearAdmin();

    public void clearAdmin(String realmId);

    public void clearAdmin(String realmId, long olderThan);

}

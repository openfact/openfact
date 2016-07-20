package org.openfact.services.scheduled;

import org.openfact.models.OpenfactSession;
import org.openfact.timer.ScheduledTask;

public class ClearExpiredEvents implements ScheduledTask {

    @Override
    public void run(OpenfactSession session) {
        /*EventStoreProvider eventStore = session.getProvider(EventStoreProvider.class);
        if (eventStore != null) {
            for (RealmModel realm : session.realms().getRealms()) {
                if (realm.isEventsEnabled() && realm.getEventsExpiration() > 0) {
                    long olderThan = System.currentTimeMillis() - realm.getEventsExpiration() * 1000;
                    eventStore.clear(realm.getId(), olderThan);
                }
            }
        }*/
    }

}

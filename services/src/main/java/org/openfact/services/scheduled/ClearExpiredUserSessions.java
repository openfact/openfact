package org.openfact.services.scheduled;

import org.openfact.models.OpenfactSession;
import org.openfact.timer.ScheduledTask;

public class ClearExpiredUserSessions implements ScheduledTask {

    @Override
    public void run(OpenfactSession session) {
        /*UserSessionProvider sessions = session.sessions();
        for (RealmModel realm : session.realms().getRealms()) {
            sessions.removeExpired(realm);
        }*/
    }

}

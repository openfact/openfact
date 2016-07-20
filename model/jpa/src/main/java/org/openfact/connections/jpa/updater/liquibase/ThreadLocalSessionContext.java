package org.openfact.connections.jpa.updater.liquibase;

import org.openfact.models.OpenfactSession;

public class ThreadLocalSessionContext {

    private static final ThreadLocal<OpenfactSession> currentSession = new ThreadLocal<OpenfactSession>();

    public static OpenfactSession getCurrentSession() {
        return currentSession.get();
    }

    public static void setCurrentSession(OpenfactSession session) {
        currentSession.set(session);
    }

    public static void removeCurrentSession() {
        currentSession.remove();
    }

}

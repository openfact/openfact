package org.openfact.connections.jpa.updater.liquibase;

import org.openfact.models.RepeidSession;

public class ThreadLocalSessionContext {

    private static final ThreadLocal<RepeidSession> currentSession = new ThreadLocal<RepeidSession>();

    public static RepeidSession getCurrentSession() {
        return currentSession.get();
    }

    public static void setCurrentSession(RepeidSession session) {
        currentSession.set(session);
    }

    public static void removeCurrentSession() {
        currentSession.remove();
    }

}

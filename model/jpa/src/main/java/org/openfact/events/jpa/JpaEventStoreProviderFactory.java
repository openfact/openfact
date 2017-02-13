package org.openfact.events.jpa;

import org.openfact.Config;
import org.openfact.connections.jpa.JpaConnectionProvider;
import org.openfact.events.EventStoreProvider;
import org.openfact.events.EventStoreProviderFactory;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

public class JpaEventStoreProviderFactory implements EventStoreProviderFactory {

    public static final String ID = "jpa";

    @Override
    public EventStoreProvider create(OpenfactSession session) {
        JpaConnectionProvider connection = session.getProvider(JpaConnectionProvider.class);
        return new JpaEventStoreProvider(connection.getEntityManager());
    }

    @Override
    public void init(Config.Scope config) {
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {

    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return ID;
    }

}

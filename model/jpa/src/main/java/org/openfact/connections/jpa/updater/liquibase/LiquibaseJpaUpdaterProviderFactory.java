package org.openfact.connections.jpa.updater.liquibase;

import org.openfact.Config;
import org.openfact.connections.jpa.updater.JpaUpdaterProvider;
import org.openfact.connections.jpa.updater.JpaUpdaterProviderFactory;
import org.openfact.models.OpenfactSession;
import org.openfact.models.RepeidSessionFactory;

public class LiquibaseJpaUpdaterProviderFactory implements JpaUpdaterProviderFactory {

    @Override
    public JpaUpdaterProvider create(OpenfactSession session) {
        return new LiquibaseJpaUpdaterProvider(session);
    }

    @Override
    public void init(Config.Scope config) {
    }

    @Override
    public void postInit(RepeidSessionFactory factory) {

    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return "liquibase";
    }

}

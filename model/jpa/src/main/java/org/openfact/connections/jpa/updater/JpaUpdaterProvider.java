package org.openfact.connections.jpa.updater;

import org.openfact.provider.Provider;

import java.sql.Connection;

public interface JpaUpdaterProvider extends Provider {

    public String FIRST_VERSION = "1.0.0.Final";

    public void update(Connection connection, String defaultSchema);

    public void validate(Connection connection, String defaultSchema);

}

package org.openfact.connections.jpa.updater;

import java.sql.Connection;

import org.openfact.provider.Provider;

public interface JpaUpdaterProvider extends Provider {

    public String FIRST_VERSION = "1.0.0.Beta1";

    public void update(Connection connection, String defaultSchema);

    public void validate(Connection connection, String defaultSchema);

}

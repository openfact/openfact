package org.openfact.connections.jpa;

import java.sql.Connection;

import org.openfact.provider.ProviderFactory;

public interface JpaConnectionProviderFactory extends ProviderFactory<JpaConnectionProvider> {

    // Caller is responsible for closing connection
    Connection getConnection();

    String getSchema();

}

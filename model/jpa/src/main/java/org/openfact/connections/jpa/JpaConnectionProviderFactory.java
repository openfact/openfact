package org.openfact.connections.jpa;

import org.openfact.provider.ProviderFactory;

import java.sql.Connection;

public interface JpaConnectionProviderFactory extends ProviderFactory<JpaConnectionProvider> {

    // Caller is responsible for closing connection
    Connection getConnection();

    String getSchema();

}

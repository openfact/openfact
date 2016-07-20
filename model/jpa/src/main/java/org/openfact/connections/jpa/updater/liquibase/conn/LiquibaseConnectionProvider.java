package org.openfact.connections.jpa.updater.liquibase.conn;

import liquibase.Liquibase;
import liquibase.exception.LiquibaseException;

import java.sql.Connection;

import org.openfact.provider.Provider;

public interface LiquibaseConnectionProvider extends Provider {

    Liquibase getLiquibase(Connection connection, String defaultSchema) throws LiquibaseException;

}

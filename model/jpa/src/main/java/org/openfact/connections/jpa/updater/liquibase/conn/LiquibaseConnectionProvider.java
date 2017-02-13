package org.openfact.connections.jpa.updater.liquibase.conn;

import liquibase.Liquibase;
import liquibase.exception.LiquibaseException;
import org.openfact.provider.Provider;

import java.sql.Connection;

public interface LiquibaseConnectionProvider extends Provider {

    Liquibase getLiquibase(Connection connection, String defaultSchema) throws LiquibaseException;

    Liquibase getLiquibaseForCustomUpdate(Connection connection, String defaultSchema, String changelogLocation, ClassLoader classloader, String changelogTableName) throws LiquibaseException;

}

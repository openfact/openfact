package org.openfact.connections.jpa.updater.liquibase.conn;

import java.sql.Connection;

import liquibase.Liquibase;
import liquibase.exception.LiquibaseException;
import org.openfact.provider.Provider;

public interface LiquibaseConnectionProvider extends Provider {

    Liquibase getLiquibase(Connection connection, String defaultSchema) throws LiquibaseException;

    Liquibase getLiquibaseForCustomUpdate(Connection connection, String defaultSchema, String changelogLocation, ClassLoader classloader, String changelogTableName) throws LiquibaseException;

}

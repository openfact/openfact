package org.openfact.connections.jpa.updater.liquibase.lock;

import liquibase.database.Database;
import liquibase.database.core.DB2Database;
import liquibase.database.core.H2Database;
import liquibase.database.core.MSSQLDatabase;
import liquibase.database.core.MySQLDatabase;
import liquibase.database.core.OracleDatabase;
import liquibase.database.core.PostgresDatabase;
import liquibase.sql.Sql;
import liquibase.sql.UnparsedSql;
import liquibase.sqlgenerator.SqlGeneratorChain;
import liquibase.sqlgenerator.core.LockDatabaseChangeLogGenerator;
import liquibase.statement.core.LockDatabaseChangeLogStatement;
import org.jboss.logging.Logger;

/**
 * We use "SELECT FOR UPDATE" pessimistic locking (Same algorithm like Hibernate LockMode.PESSIMISTIC_WRITE )
 *
 */
public class CustomLockDatabaseChangeLogGenerator extends LockDatabaseChangeLogGenerator {

    private static final Logger logger = Logger.getLogger(CustomLockDatabaseChangeLogGenerator.class);

    @Override
    public int getPriority() {
        return super.getPriority() + 1; // Ensure bigger priority than LockDatabaseChangeLogGenerator
    }

    @Override
    public Sql[] generateSql(LockDatabaseChangeLogStatement statement, Database database, SqlGeneratorChain sqlGeneratorChain) {

        Sql selectForUpdateSql = generateSelectForUpdate(database);

        return new Sql[] { selectForUpdateSql };
    }


    private Sql generateSelectForUpdate(Database database) {
        String catalog = database.getLiquibaseCatalogName();
        String schema = database.getLiquibaseSchemaName();
        String rawLockTableName = database.getDatabaseChangeLogLockTableName();

        String lockTableName = database.escapeTableName(catalog, schema, rawLockTableName);
        String idColumnName  = database.escapeColumnName(catalog, schema, rawLockTableName, "ID");

        String sqlBase = "SELECT " + idColumnName + " FROM " + lockTableName;
        String sqlWhere = " WHERE " + idColumnName + "=1";

        String sql;
        if (database instanceof MySQLDatabase || database instanceof PostgresDatabase || database instanceof H2Database ||
                database instanceof OracleDatabase) {
            sql = sqlBase + sqlWhere + " FOR UPDATE";
        } else if (database instanceof MSSQLDatabase) {
            sql = sqlBase + " WITH (UPDLOCK, ROWLOCK)" + sqlWhere;
        } else if (database instanceof DB2Database) {
            sql = sqlBase + sqlWhere +  " FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
        } else {
            sql = sqlBase + sqlWhere;
            logger.warnf("No direct support for database %s . Database lock may not work correctly", database.getClass().getName());
        }

        logger.debugf("SQL command for pessimistic lock: %s", sql);
        
        return new UnparsedSql(sql);
    }

}

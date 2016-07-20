package org.openfact.connections.jpa.updater.liquibase.custom;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import liquibase.change.custom.CustomSqlChange;
import liquibase.database.Database;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.CustomChangeException;
import liquibase.exception.SetupException;
import liquibase.exception.ValidationErrors;
import liquibase.resource.ResourceAccessor;
import liquibase.snapshot.SnapshotGeneratorFactory;
import liquibase.statement.SqlStatement;
import liquibase.structure.core.Table;
import org.jboss.logging.Logger;
import org.openfact.connections.jpa.updater.liquibase.LiquibaseJpaUpdaterProvider;
import org.openfact.connections.jpa.updater.liquibase.ThreadLocalSessionContext;
import org.openfact.models.OpenfactSession;
import org.openfact.services.DefaultOpenfactSessionFactory;

public abstract class CustomOpenfactTask implements CustomSqlChange {

    private final Logger logger = Logger.getLogger(getClass());

    protected OpenfactSession kcSession;

    protected Database database;
    protected JdbcConnection jdbcConnection;
    protected Connection connection;
    protected StringBuilder confirmationMessage = new StringBuilder();
    protected List<SqlStatement> statements = new ArrayList<SqlStatement>();

    @Override
    public ValidationErrors validate(Database database) {
        return null;
    }

    @Override
    public void setFileOpener(ResourceAccessor resourceAccessor) {

    }

    @Override
    public String getConfirmationMessage() {
        return confirmationMessage.toString();
    }

    @Override
    public void setUp() throws SetupException {
        this.kcSession = ThreadLocalSessionContext.getCurrentSession();

        if (this.kcSession == null) {
            // Probably running Liquibase from maven plugin. Try to create kcSession programmatically
            logger.info("No OpenfactSession provided in ThreadLocal. Initializing OpenfactSessionFactory");

            try {
                DefaultOpenfactSessionFactory factory = new DefaultOpenfactSessionFactory();
                factory.init();
                this.kcSession = factory.create();
            } catch (Exception e) {
                throw new SetupException("Exception when initializing factory", e);
            }
        }
    }

    @Override
    public SqlStatement[] generateStatements(Database database) throws CustomChangeException {
        this.database = database;
        jdbcConnection = (JdbcConnection) database.getConnection();
        connection = jdbcConnection.getWrappedConnection();

        if (isApplicable()) {
            confirmationMessage.append(getTaskId() + ": ");
            generateStatementsImpl();
        } else {
            confirmationMessage.append(getTaskId() + ": no update applicable for this task");
        }

        return statements.toArray(new SqlStatement[statements.size()]);
    }

    protected boolean isApplicable() throws CustomChangeException {
        try {
            String correctedTableName = database.correctObjectName("ORGANIZATION", Table.class);
            if (SnapshotGeneratorFactory.getInstance().has(new Table().setName(correctedTableName), database)) {
                ResultSet resultSet = connection.createStatement().executeQuery("SELECT ID FROM " + getTableName(correctedTableName));
                try {
                    return (resultSet.next());
                } finally {
                    resultSet.close();
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new CustomChangeException("Failed to check database availability", e);
        }
    }

    /**
     * It's supposed to fill SQL statements to the "statements" variable and fill "confirmationMessage"
     */
    protected abstract void generateStatementsImpl() throws CustomChangeException;

    protected abstract String getTaskId();

    // get Table name for sql selects
    protected String getTableName(String tableName) {
       return LiquibaseJpaUpdaterProvider.getTable(tableName, database.getDefaultSchemaName());
    }
}

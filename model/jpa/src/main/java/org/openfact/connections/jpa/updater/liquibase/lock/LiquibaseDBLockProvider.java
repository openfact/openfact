package org.openfact.connections.jpa.updater.liquibase.lock;

import liquibase.Liquibase;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import org.jboss.logging.Logger;
import org.openfact.connections.jpa.JpaConnectionProvider;
import org.openfact.connections.jpa.JpaConnectionProviderFactory;
import org.openfact.connections.jpa.updater.liquibase.conn.LiquibaseConnectionProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.dblock.DBLockProvider;

import java.sql.Connection;
import java.sql.SQLException;

public class LiquibaseDBLockProvider implements DBLockProvider {

    private static final Logger logger = Logger.getLogger(LiquibaseDBLockProvider.class);

    // 3 should be sufficient (Potentially one failure for createTable and one for insert record)
    private int DEFAULT_MAX_ATTEMPTS = 3;


    private final LiquibaseDBLockProviderFactory factory;
    private final OpenfactSession session;

    private CustomLockService lockService;
    private Connection dbConnection;

    private int maxAttempts = DEFAULT_MAX_ATTEMPTS;

    public LiquibaseDBLockProvider(LiquibaseDBLockProviderFactory factory, OpenfactSession session) {
        this.factory = factory;
        this.session = session;
        init();
    }

    private void init() {
        LiquibaseConnectionProvider liquibaseProvider = session.getProvider(LiquibaseConnectionProvider.class);
        JpaConnectionProviderFactory jpaProviderFactory = (JpaConnectionProviderFactory) session.getRepeidSessionFactory().getProviderFactory(JpaConnectionProvider.class);

        this.dbConnection = jpaProviderFactory.getConnection();
        String defaultSchema = jpaProviderFactory.getSchema();

        try {
            Liquibase liquibase = liquibaseProvider.getLiquibase(dbConnection, defaultSchema);

            this.lockService = new CustomLockService();
            lockService.setChangeLogLockWaitTime(factory.getLockWaitTimeoutMillis());
            lockService.setDatabase(liquibase.getDatabase());
        } catch (LiquibaseException exception) {
            safeRollbackConnection();
            safeCloseConnection();
            throw new IllegalStateException(exception);
        }
    }

    // Assumed transaction was rolled-back and we want to start with new DB connection
    private void restart() {
        safeCloseConnection();
        this.dbConnection = null;
        this.lockService = null;
        init();
    }


    @Override
    public void waitForLock() {
        while (maxAttempts > 0) {
            try {
                lockService.waitForLock();
                this.maxAttempts = DEFAULT_MAX_ATTEMPTS;
                return;
            } catch (LockRetryException le) {
                // Indicates we should try to acquire lock again in different transaction
                safeRollbackConnection();
                restart();
                maxAttempts--;
            } catch (RuntimeException re) {
                safeRollbackConnection();
                safeCloseConnection();
                throw re;
            }
        }
    }


    @Override
    public void releaseLock() {
        lockService.releaseLock();
        lockService.reset();
    }

    @Override
    public boolean supportsForcedUnlock() {
        // Implementation based on "SELECT FOR UPDATE" can't force unlock as it's locked by other transaction
        return false;
    }

    @Override
    public void destroyLockInfo() {
        try {
            this.lockService.destroy();
            dbConnection.commit();
            logger.debug("Destroyed lock table");
        } catch (DatabaseException | SQLException de) {
            logger.error("Failed to destroy lock table");
            safeRollbackConnection();
        }
    }

    @Override
    public void close() {
        safeCloseConnection();
    }

    private void safeRollbackConnection() {
        if (dbConnection != null) {
            try {
                this.dbConnection.rollback();
            } catch (SQLException se) {
                logger.warn("Failed to rollback connection after error", se);
            }
        }
    }

    private void safeCloseConnection() {
        // Close after creating EntityManagerFactory to prevent in-mem databases from closing
        if (dbConnection != null) {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                logger.warn("Failed to close connection", e);
            }
        }
    }
}

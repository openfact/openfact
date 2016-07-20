package org.openfact.connections.jpa.updater.liquibase;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.changelog.ChangeSet;
import liquibase.changelog.RanChangeSet;
import liquibase.exception.LiquibaseException;
import org.jboss.logging.Logger;
import org.openfact.connections.jpa.updater.JpaUpdaterProvider;
import org.openfact.connections.jpa.updater.liquibase.conn.LiquibaseConnectionProvider;
import org.openfact.models.RepeidSession;

import java.sql.Connection;
import java.util.List;

public class LiquibaseJpaUpdaterProvider implements JpaUpdaterProvider {

	private static final Logger logger = Logger.getLogger(LiquibaseJpaUpdaterProvider.class);

    public static final String CHANGELOG = "META-INF/jpa-changelog-master.xml";
    public static final String DB2_CHANGELOG = "META-INF/db2-jpa-changelog-master.xml";

    private final RepeidSession session;

    public LiquibaseJpaUpdaterProvider(RepeidSession session) {
        this.session = session;
    }

    @Override
    public void update(Connection connection, String defaultSchema) {
        logger.debug("Starting database update");

        // Need ThreadLocal as liquibase doesn't seem to have API to inject custom objects into tasks
        ThreadLocalSessionContext.setCurrentSession(session);

        try {
            Liquibase liquibase = getLiquibase(connection, defaultSchema);

            List<ChangeSet> changeSets = liquibase.listUnrunChangeSets((Contexts) null);
            if (!changeSets.isEmpty()) {
                if (changeSets.get(0).getId().equals(FIRST_VERSION)) {
                    logger.info("Initializing database schema");
                } else {
                    if (logger.isDebugEnabled()) {
                        List<RanChangeSet> ranChangeSets = liquibase.getDatabase().getRanChangeSetList();
                        logger.debugv("Updating database from {0} to {1}", ranChangeSets.get(ranChangeSets.size() - 1).getId(), changeSets.get(changeSets.size() - 1).getId());
                    } else {
                        logger.infov("Updating database");
                    }
                }

                liquibase.update((Contexts) null);
                logger.debug("Completed database update");
            } else {
                logger.debug("Database is up to date");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to update database", e);
        } finally {
            ThreadLocalSessionContext.removeCurrentSession();
        }
    }

    @Override
    public void validate(Connection connection, String defaultSchema) {
        logger.debug("Validating if database is updated");

        try {
            Liquibase liquibase = getLiquibase(connection, defaultSchema);

            List<ChangeSet> changeSets = liquibase.listUnrunChangeSets((Contexts) null);
            if (!changeSets.isEmpty()) {
                List<RanChangeSet> ranChangeSets = liquibase.getDatabase().getRanChangeSetList();
                String errorMessage = String.format("Failed to validate database schema. Schema needs updating database from %s to %s. Please change databaseSchema to 'update' or use other database",
                        ranChangeSets.get(ranChangeSets.size() - 1).getId(), changeSets.get(changeSets.size() - 1).getId());
                throw new RuntimeException(errorMessage);
            } else {
                logger.debug("Validation passed. Database is up-to-date");
            }

        } catch (LiquibaseException e) {
            throw new RuntimeException("Failed to validate database", e);
        }
    }

    private Liquibase getLiquibase(Connection connection, String defaultSchema) throws LiquibaseException {
        LiquibaseConnectionProvider liquibaseProvider = session.getProvider(LiquibaseConnectionProvider.class);
        return liquibaseProvider.getLiquibase(connection, defaultSchema);
    }

    @Override
    public void close() {
    }

    public static String getTable(String table, String defaultSchema) {
        return defaultSchema != null ? defaultSchema + "." + table : table;
    }

}

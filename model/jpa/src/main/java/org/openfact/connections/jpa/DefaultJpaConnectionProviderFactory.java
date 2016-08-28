package org.openfact.connections.jpa;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.ejb.AvailableSettings;
import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.connections.jpa.updater.JpaUpdaterProvider;
import org.openfact.connections.jpa.util.JpaUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.dblock.DBLockProvider;
import org.openfact.provider.ServerInfoAwareProviderFactory;
import org.openfact.models.dblock.DBLockManager;
import org.openfact.timer.TimerProvider;

public class DefaultJpaConnectionProviderFactory
        implements JpaConnectionProviderFactory, ServerInfoAwareProviderFactory {

    private static final Logger logger = Logger.getLogger(DefaultJpaConnectionProviderFactory.class);

    private volatile EntityManagerFactory emf;

    private Config.Scope config;

    private Map<String, String> operationalInfo;

    @Override
    public JpaConnectionProvider create(OpenfactSession session) {
        lazyInit(session);

        EntityManager em = emf.createEntityManager();
        em = PersistenceExceptionConverter.create(em);
        session.getTransactionManager().enlist(new JpaOpenfactTransaction(em));
        return new DefaultJpaConnectionProvider(em);
    }

    @Override
    public void close() {
        if (emf != null) {
            emf.close();
        }
    }

    @Override
    public String getId() {
        return "default";
    }

    @Override
    public void init(Config.Scope config) {
        this.config = config;
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {

    }

    private void lazyInit(OpenfactSession session) {
        if (emf == null) {
            synchronized (this) {
                if (emf == null) {
                    logger.debug("Initializing JPA connections");

                    Connection connection = null;

                    Map<String, Object> properties = new HashMap<String, Object>();

                    String unitName = "openfact-default";

                    String dataSource = config.get("dataSource");
                    if (dataSource != null) {
                        if (config.getBoolean("jta", false)) {
                            properties.put(AvailableSettings.JTA_DATASOURCE, dataSource);
                        } else {
                            properties.put(AvailableSettings.NON_JTA_DATASOURCE, dataSource);
                        }
                    } else {
                        properties.put(AvailableSettings.JDBC_URL, config.get("url"));
                        properties.put(AvailableSettings.JDBC_DRIVER, config.get("driver"));

                        String user = config.get("user");
                        if (user != null) {
                            properties.put(AvailableSettings.JDBC_USER, user);
                        }
                        String password = config.get("password");
                        if (password != null) {
                            properties.put(AvailableSettings.JDBC_PASSWORD, password);
                        }
                    }

                    String schema = getSchema();
                    if (schema != null) {
                        properties.put(JpaUtils.HIBERNATE_DEFAULT_SCHEMA, schema);
                    }

                    String databaseSchema = config.get("databaseSchema");
                    if (databaseSchema == null) {
                        throw new RuntimeException(
                                "Property 'databaseSchema' needs to be specified in the configuration");
                    }

                    if (databaseSchema.equals("development-update")) {
                        properties.put("hibernate.hbm2ddl.auto", "update");
                        databaseSchema = null;
                    } else if (databaseSchema.equals("development-validate")) {
                        properties.put("hibernate.hbm2ddl.auto", "validate");
                        databaseSchema = null;
                    }

                    properties.put("hibernate.show_sql", config.getBoolean("showSql", false));
                    properties.put("hibernate.format_sql", config.getBoolean("formatSql", true));

                    connection = getConnection();
                    try {
                        prepareOperationalInfo(connection);

                        String driverDialect = detectDialect(connection);
                        if (driverDialect != null) {
                            properties.put("hibernate.dialect", driverDialect);
                        }

                        if (databaseSchema != null) {
                            logger.trace("Updating database");

                            JpaUpdaterProvider updater = session.getProvider(JpaUpdaterProvider.class);
                            if (updater == null) {
                                throw new RuntimeException(
                                        "Can't update database: JPA updater provider not found");
                            }

                            // Check if having DBLock before trying to
                            // initialize hibernate
                            DBLockProvider dbLock = new DBLockManager(session).getDBLock();
                            if (!dbLock.hasLock()) {
                                throw new IllegalStateException(
                                        "Trying to update database, but don't have a DB lock acquired");
                            }

                            if (databaseSchema.equals("update")) {
                                updater.update(connection, schema);
                            } else if (databaseSchema.equals("validate")) {
                                updater.validate(connection, schema);
                            } else {
                                throw new RuntimeException(
                                        "Invalid value for databaseSchema: " + databaseSchema);
                            }

                            logger.trace("Database update completed");
                        }

                        int globalStatsInterval = config.getInt("globalStatsInterval", -1);
                        if (globalStatsInterval != -1) {
                            properties.put("hibernate.generate_statistics", true);
                        }

                        logger.trace("Creating EntityManagerFactory");
                        emf = JpaUtils.createEntityManagerFactory(session, unitName, properties,
                                getClass().getClassLoader());
                        logger.trace("EntityManagerFactory created");

                        if (globalStatsInterval != -1) {
                            startGlobalStats(session, globalStatsInterval);
                        }

                    } catch (Exception e) {
                        // Safe rollback
                        if (connection != null) {
                            try {
                                connection.rollback();
                            } catch (SQLException e2) {
                                logger.warn("Can't rollback connection", e2);
                            }
                        }

                        throw e;
                    } finally {
                        // Close after creating EntityManagerFactory to prevent
                        // in-mem databases from closing
                        if (connection != null) {
                            try {
                                connection.close();
                            } catch (SQLException e) {
                                logger.warn("Can't close connection", e);
                            }
                        }
                    }
                }
            }
        }
    }

    protected void prepareOperationalInfo(Connection connection) {
        try {
            operationalInfo = new LinkedHashMap<>();
            DatabaseMetaData md = connection.getMetaData();
            operationalInfo.put("databaseUrl", md.getURL());
            operationalInfo.put("databaseUser", md.getUserName());
            operationalInfo.put("databaseProduct",
                    md.getDatabaseProductName() + " " + md.getDatabaseProductVersion());
            operationalInfo.put("databaseDriver", md.getDriverName() + " " + md.getDriverVersion());

            logger.debugf("Database info: %s", operationalInfo.toString());
        } catch (SQLException e) {
            logger.warn("Unable to prepare operational info due database exception: " + e.getMessage());
        }
    }

    protected String detectDialect(Connection connection) {
        String driverDialect = config.get("driverDialect");
        if (driverDialect != null && driverDialect.length() > 0) {
            return driverDialect;
        } else {
            try {
                String dbProductName = connection.getMetaData().getDatabaseProductName();
                String dbProductVersion = connection.getMetaData().getDatabaseProductVersion();

                // For MSSQL2014, we may need to fix the autodetected dialect by
                // hibernate
                if (dbProductName.equals("Microsoft SQL Server")) {
                    String topVersionStr = dbProductVersion.split("\\.")[0];
                    boolean shouldSet2012Dialect = true;
                    try {
                        int topVersion = Integer.parseInt(topVersionStr);
                        if (topVersion < 12) {
                            shouldSet2012Dialect = false;
                        }
                    } catch (NumberFormatException nfe) {
                    }
                    if (shouldSet2012Dialect) {
                        String sql2012Dialect = "org.hibernate.dialect.SQLServer2012Dialect";
                        logger.debugf("Manually override hibernate dialect to %s", sql2012Dialect);
                        return sql2012Dialect;
                    }
                }
            } catch (SQLException e) {
                logger.warnf("Unable to detect hibernate dialect due database exception : %s",
                        e.getMessage());
            }

            return null;
        }
    }

    protected void startGlobalStats(OpenfactSession session, int globalStatsIntervalSecs) {
        logger.debugf("Started Hibernate statistics with the interval %s seconds", globalStatsIntervalSecs);
        TimerProvider timer = session.getProvider(TimerProvider.class);
        timer.scheduleTask(new HibernateStatsReporter(emf), globalStatsIntervalSecs * 1000,
                "ReportHibernateGlobalStats");
    }

    @Override
    public Connection getConnection() {
        try {
            String dataSourceLookup = config.get("dataSource");
            if (dataSourceLookup != null) {
                DataSource dataSource = (DataSource) new InitialContext().lookup(dataSourceLookup);
                return dataSource.getConnection();
            } else {
                Class.forName(config.get("driver"));
                return DriverManager.getConnection(config.get("url"), config.get("user"),
                        config.get("password"));
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }

    @Override
    public String getSchema() {
        return config.get("schema");
    }

    @Override
    public Map<String, String> getOperationalInfo() {
        return operationalInfo;
    }

}

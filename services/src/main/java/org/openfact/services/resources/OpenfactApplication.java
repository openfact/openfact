package org.openfact.services.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.Config;
import org.openfact.common.util.SystemEnvProperties;
import org.openfact.exportimport.ExportImportManager;
import org.openfact.migration.MigrationModelManager;
import org.openfact.models.OpenfactModelUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.models.dblock.DBLockManager;
import org.openfact.models.dblock.DBLockProvider;
import org.openfact.models.utils.PostMigrationEvent;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.DefaultOpenfactSessionFactory;
import org.openfact.services.filters.OpenfactTransactionCommitter;
import org.openfact.services.managers.ApplianceBootstrap;
import org.openfact.services.resources.admin.AdminRootImpl;
import org.openfact.services.util.JsonConfigProvider;
import org.openfact.services.util.ObjectMapperResolver;
import org.openfact.util.JsonSerialization;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OpenfactApplication extends Application {

    private static final Logger logger = Logger.getLogger(OpenfactApplication.class);

    protected Set<Object> singletons = new HashSet<>();
    protected Set<Class<?>> classes = new HashSet<>();

    protected OpenfactSessionFactory sessionFactory;
    protected String contextPath;

    public OpenfactApplication(@Context ServletContext context, @Context Dispatcher dispatcher) {
        loadConfig();

        this.contextPath = context.getContextPath();
        this.sessionFactory = createSessionFactory();

        dispatcher.getDefaultContextObjects().put(OpenfactApplication.class, this);
        ResteasyProviderFactory.pushContext(OpenfactApplication.class, this);
        context.setAttribute(OpenfactSessionFactory.class.getName(), this.sessionFactory);

        singletons.add(new ServerVersionResourceImpl());
        singletons.add(new RobotsResourceImpl());
        singletons.add(new OrganizationsResourceImpl());
        singletons.add(new AdminRootImpl());

        classes.add(OpenfactTransactionCommitter.class);

        singletons.add(new ObjectMapperResolver(Boolean.parseBoolean(System.getProperty("openfact.jsonPrettyPrint", "false"))));

        ExportImportManager[] exportImportManager = new ExportImportManager[1];

        OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

            @Override
            public void run(OpenfactSession lockSession) {
                DBLockManager dbLockManager = new DBLockManager(lockSession);
                dbLockManager.checkForcedUnlock();
                DBLockProvider dbLock = dbLockManager.getDBLock();
                dbLock.waitForLock();
                try {
                    exportImportManager[0] = migrateAndBootstrap();
                } finally {
                    dbLock.releaseLock();
                }
            }

        });

        if (exportImportManager[0].isRunExport()) {
            exportImportManager[0].runExport();
        }

        boolean bootstrapAdminUser = false;
        OpenfactSession session = sessionFactory.create();
        try {
            session.getTransaction().begin();
            bootstrapAdminUser = new ApplianceBootstrap(session).isNoMasterUser();

            session.getTransaction().commit();
        } finally {
            session.close();
        }

        sessionFactory.publish(new PostMigrationEvent());

        singletons.add(new WelcomeResourceImpl(bootstrapAdminUser));

        setupScheduledTasks(sessionFactory);
    }

    // Migrate model, bootstrap master organization, import organizations and
    // create admin
    // user. This is done with acquired dbLock
    protected ExportImportManager migrateAndBootstrap() {
        ExportImportManager exportImportManager;
        migrateModel();

        OpenfactSession session = sessionFactory.create();
        try {
            session.getTransaction().begin();

            ApplianceBootstrap applianceBootstrap = new ApplianceBootstrap(session);
            exportImportManager = new ExportImportManager(session);

            boolean createMasterRealm = applianceBootstrap.isNewInstall();
            if (exportImportManager.isRunImport() && exportImportManager.isImportMasterIncluded()) {
                createMasterRealm = false;
            }

            if (createMasterRealm) {
                applianceBootstrap.createMasterRealm(contextPath);
            }
            session.getTransaction().commit();
        } catch (RuntimeException re) {
            if (session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw re;
        } finally {
            session.close();
        }

        if (exportImportManager.isRunImport()) {
            exportImportManager.runImport();
        } else {
            importOrganizations();
        }

        importAddUser();

        return exportImportManager;
    }

    protected void migrateModel() {
        OpenfactSession session = sessionFactory.create();
        try {
            session.getTransaction().begin();
            MigrationModelManager.migrate(session);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Failed to migrate datamodel");
            throw e;
        } finally {
            session.close();
        }
    }

    public String getContextPath() {
        return contextPath;
    }

    /**
     * Get base URI of WAR distribution, not JAX-RS
     *
     * @param uriInfo
     * @return
     */
    public URI getBaseUri(UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder().replacePath(getContextPath()).build();
    }

    public static void loadConfig() {
        try {
            JsonNode node = null;

            String configDir = System.getProperty("jboss.server.config.dir");
            if (configDir != null) {
                Path path = Paths.get(configDir + FileSystems.getDefault().getSeparator() + "openfact-server.json");
                if (Files.isRegularFile(path)) {
                    logger.info("Loading config from " + path.toAbsolutePath().toString());
                    node = new ObjectMapper().readTree(Files.newInputStream(path));
                }
            }

            if (node == null) {
                URL resource = Thread.currentThread().getContextClassLoader().getResource("META-INF/openfact-server.json");
                if (resource != null) {
                    logger.info("Loading config from " + resource);
                    node = new ObjectMapper().readTree(resource);
                }
            }

            if (node != null) {
                Properties properties = new SystemEnvProperties();
                Config.init(new JsonConfigProvider(node, properties));
                return;
            } else {
                throw new RuntimeException("Config 'openfact-server.json' not found");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    public static OpenfactSessionFactory createSessionFactory() {
        DefaultOpenfactSessionFactory factory = new DefaultOpenfactSessionFactory();
        factory.init();
        return factory;
    }

    public static void setupScheduledTasks(final OpenfactSessionFactory sessionFactory) {
        long interval = Config.scope("scheduled").getLong("interval", 60L) * 1000;

        OpenfactSession session = sessionFactory.create();
        try {
            // TimerProvider timer = session.getProvider(TimerProvider.class);
            // timer.schedule(new
            // ClusterAwareScheduledTaskRunner(sessionFactory, new
            // ClearExpiredEvents(), interval), interval, "ClearExpiredEvents");
            // timer.schedule(new
            // ClusterAwareScheduledTaskRunner(sessionFactory, new
            // ClearExpiredUserSessions(), interval), interval,
            // "ClearExpiredUserSessions");
            // new UsersSyncManager().bootstrapPeriodic(sessionFactory, timer);
        } finally {
            session.close();
        }
    }

    public OpenfactSessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    public void importOrganizations() {
        String files = System.getProperty("openfact.import");
        if (files != null) {
            StringTokenizer tokenizer = new StringTokenizer(files, ",");
            while (tokenizer.hasMoreTokens()) {
                String file = tokenizer.nextToken().trim();
                OrganizationRepresentation rep;
                try {
                    rep = loadJson(new FileInputStream(file), OrganizationRepresentation.class);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                importOrganization(rep, "file " + file);
            }
        }
    }

    public void importOrganization(OrganizationRepresentation rep, String from) {
       
    }

    public void importAddUser() {
       
    }

    private static <T> T loadJson(InputStream is, Class<T> type) {
        try {
            return JsonSerialization.readValue(is, type);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse json", e);
        }
    }

}

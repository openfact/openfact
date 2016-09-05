package org.openfact.services.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.Config;
import org.openfact.common.util.SystemEnvProperties;
import org.openfact.exportimport.ExportImportManager;
import org.openfact.migration.MigrationModelManager;
import org.openfact.models.InvoiceModel;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.models.OrganizationModel;
import org.openfact.models.dblock.DBLockManager;
import org.openfact.models.dblock.DBLockProvider;
import org.openfact.models.utils.PostMigrationEvent;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.DefaultOpenfactSessionFactory;
import org.openfact.services.ServicesLogger;
import org.openfact.services.filters.OpenfactTransactionCommitter;
import org.openfact.services.managers.ApplianceBootstrap;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.admin.AdminRootImpl;
import org.openfact.services.scheduled.ClearExpiredEvents;
import org.openfact.services.scheduled.ClusterAwareScheduledTaskRunner;
import org.openfact.services.scheduled.SendRequiredInvoiceEmail;
import org.openfact.services.scheduled.SendRequiredInvoiceUbl;
import org.openfact.services.util.JsonConfigProvider;
import org.openfact.services.util.ObjectMapperResolver;
import org.openfact.timer.TimerProvider;
import org.openfact.util.JsonSerialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author carlosthe19916@gmail.com
 * @version 1.0.0.Final
 */
public class OpenfactApplication extends Application {

    protected static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;
    
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
            session.getTransactionManager().begin();
            bootstrapAdminUser = new ApplianceBootstrap(session).isNoMasterUser();

            session.getTransactionManager().commit();
        } finally {
            session.close();
        }

        sessionFactory.publish(new PostMigrationEvent());

        singletons.add(new WelcomeResourceImpl(bootstrapAdminUser));

        setupScheduledTasks(sessionFactory);
    }

    // Migrate model, bootstrap master organization, import organizations. This
    // is done with acquired dbLock
    protected ExportImportManager migrateAndBootstrap() {
        ExportImportManager exportImportManager;
        migrateModel();

        OpenfactSession session = sessionFactory.create();
        try {
            session.getTransactionManager().begin();

            ApplianceBootstrap applianceBootstrap = new ApplianceBootstrap(session);
            exportImportManager = new ExportImportManager(session);

            boolean createMasterOrganization = applianceBootstrap.isNewInstall();
            if (exportImportManager.isRunImport() && exportImportManager.isImportMasterIncluded()) {
                createMasterOrganization = false;
            }

            if (createMasterOrganization) {
                applianceBootstrap.createMasterOrganization(contextPath);
            }
            session.getTransactionManager().commit();
        } catch (RuntimeException re) {
            if (session.getTransactionManager().isActive()) {
                session.getTransactionManager().rollback();
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

        importAddInvoice();

        return exportImportManager;
    }

    protected void migrateModel() {
        OpenfactSession session = sessionFactory.create();
        try {
            session.getTransactionManager().begin();
            MigrationModelManager.migrate(session);
            session.getTransactionManager().commit();
        } catch (Exception e) {
            session.getTransactionManager().rollback();
            logger.migrationFailure(e);
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
                File f = new File(configDir + File.separator + "openfact-server.json");
                if (f.isFile()) {
                    logger.loadingFrom(f.getAbsolutePath());
                    node = new ObjectMapper().readTree(f);
                }
            }

            if (node == null) {
                URL resource = Thread.currentThread().getContextClassLoader().getResource("META-INF/openfact-server.json");
                if (resource != null) {
                    logger.loadingFrom(resource);
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
            TimerProvider timer = session.getProvider(TimerProvider.class);
            timer.schedule(new ClusterAwareScheduledTaskRunner(sessionFactory, new ClearExpiredEvents(), interval), interval, "ClearExpiredEvents");
            timer.schedule(new ClusterAwareScheduledTaskRunner(sessionFactory, new SendRequiredInvoiceEmail(), interval), interval, "SendRequiredInvoiceEmail");
            timer.schedule(new ClusterAwareScheduledTaskRunner(sessionFactory, new SendRequiredInvoiceUbl(), interval), interval, "SendRequiredInvoiceUbl");
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
        OpenfactSession session = sessionFactory.create();
        boolean exists = false;
        try {
            session.getTransactionManager().begin();

            try {
                OrganizationManager manager = new OrganizationManager(session);
                manager.setContextPath(getContextPath());

                if (rep.getId() != null && manager.getOrganization(rep.getId()) != null) {
                    logger.organizationExists(rep.getName(), from);
                    exists = true;
                }

                if (manager.getOrganizationByName(rep.getName()) != null) {
                    logger.organizationExists(rep.getName(), from);
                    exists = true;
                }
                if (!exists) {
                    OrganizationModel organization = manager.importOrganization(rep);
                    logger.importedOrganization(organization.getName(), from);
                }
                session.getTransactionManager().commit();
            } catch (Throwable t) {
                session.getTransactionManager().rollback();
                if (!exists) {
                    logger.unableToImportOrganization(t, rep.getName(), from);
                }
            }
        } finally {
            session.close();
        }
    }
    
    public void importAddInvoice() {
        String configDir = System.getProperty("jboss.server.config.dir");
        if (configDir != null) {
            File addInvoiceFile = new File(configDir + File.separator + "openfact-add-invoice.json");
            if (addInvoiceFile.isFile()) {
                logger.importingInvoicesFrom(addInvoiceFile);

                List<OrganizationRepresentation> organizations;
                try {
                    organizations = JsonSerialization.readValue(new FileInputStream(addInvoiceFile), new TypeReference<List<OrganizationRepresentation>>() {
                    });
                } catch (IOException e) {
                    logger.failedToLoadInvoices(e);
                    return;
                }

                for (OrganizationRepresentation organizationRep : organizations) {
                    for (InvoiceRepresentation invoiceRep : organizationRep.getInvoices()) {
                        OpenfactSession session = sessionFactory.create();
                        try {
                            session.getTransactionManager().begin();

                            OrganizationModel organization = session.organizations().getOrganizationByName(organizationRep.getName());
                            if (organization == null) {
                                logger.addInvoiceFailedOrganizationNotFound(String.valueOf(invoiceRep.getInvoiceSeries() + invoiceRep.getInvoiceNumber()), organizationRep.getName());
                            } else {
                                InvoiceModel invoice = RepresentationToModel.createInvoice(session, organization, invoiceRep);                                
                            }

                            session.getTransactionManager().commit();
                            logger.addInvoiceSuccess(String.valueOf(invoiceRep.getInvoiceSeries() + invoiceRep.getInvoiceNumber()), organizationRep.getName());
                        } catch (ModelDuplicateException e) {
                            session.getTransactionManager().rollback();
                            logger.addInvoiceFailedInvoiceExists(String.valueOf(invoiceRep.getInvoiceSeries() + invoiceRep.getInvoiceNumber()), organizationRep.getName());
                        } catch (Throwable t) {
                            session.getTransactionManager().rollback();
                            logger.addInvoiceFailed(t, String.valueOf(invoiceRep.getInvoiceSeries() + invoiceRep.getInvoiceNumber()), organizationRep.getName());
                        } finally {
                            session.close();
                        }
                    }
                }

                if (!addInvoiceFile.delete()) {
                    logger.failedToDeleteFile(addInvoiceFile.getAbsolutePath());
                }
            }
        }
    }

    private static <T> T loadJson(InputStream is, Class<T> type) {
        try {
            return JsonSerialization.readValue(is, type);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse json", e);
        }
    }

}

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
import javax.ws.rs.ApplicationPath;
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
import org.openfact.models.RepeidSession;
import org.openfact.models.RepeidSessionFactory;
import org.openfact.models.dblock.DBLockProvider;
import org.openfact.models.utils.PostMigrationEvent;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.DefaultOpenfactSessionFactory;
import org.openfact.services.filters.OpenfactTransactionCommitter;
import org.openfact.services.managers.ApplianceBootstrap;
import org.openfact.services.managers.DBLockManager;
import org.openfact.services.resources.admin.AdminRootImpl;
import org.openfact.services.util.JsonConfigProvider;
import org.openfact.util.JsonSerialization;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@ApplicationPath("/")
public class RepeidApplication extends Application {

	private static final Logger logger = Logger.getLogger(RepeidApplication.class);

	protected Set<Object> singletons = new HashSet<>();
	protected Set<Class<?>> classes = new HashSet<>();

	protected RepeidSessionFactory sessionFactory;
	protected String contextPath;

	public RepeidApplication(@Context ServletContext context, @Context Dispatcher dispatcher) {			
		loadConfig();		
		
		this.contextPath = context.getContextPath();
		this.sessionFactory = createSessionFactory();

		dispatcher.getDefaultContextObjects().put(RepeidApplication.class, this);
		ResteasyProviderFactory.pushContext(RepeidApplication.class, this);	
		context.setAttribute(RepeidSessionFactory.class.getName(), this.sessionFactory);

		singletons.add(new ServerVersionResourceImpl());
		singletons.add(new RobotsResourceImpl());
		singletons.add(new OrganizationsResourceImpl());
		singletons.add(new AdminRootImpl());

		classes.add(OpenfactTransactionCommitter.class);

		// singletons.add(new
		// ObjectMapperResolver(Boolean.parseBoolean(System.getProperty("repeid.jsonPrettyPrint",
		// "false"))));

		ExportImportManager exportImportManager;

		DBLockManager dbLockManager = new DBLockManager(sessionFactory.create());
		dbLockManager.checkForcedUnlock();
		DBLockProvider dbLock = dbLockManager.getDBLock();
		dbLock.waitForLock();

		try {
			migrateModel();

			RepeidSession session = sessionFactory.create();
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
				importRealms();
			}

			importAddUser();
		} finally {
			dbLock.releaseLock();
		}

		if (exportImportManager.isRunExport()) {
			exportImportManager.runExport();
		}

		boolean bootstrapAdminUser = false;
		RepeidSession session = sessionFactory.create();
		try {
			session.getTransaction().begin();
			bootstrapAdminUser = new ApplianceBootstrap(session).isNoMasterUser();

			session.getTransaction().commit();
		} finally {
			session.close();
		}

		sessionFactory.publish(new PostMigrationEvent());

		//singletons.add(new WelcomeResourceImpl(bootstrapAdminUser));

		setupScheduledTasks(sessionFactory);
	}

	protected void migrateModel() {
		RepeidSession session = sessionFactory.create();
		try {
			session.getTransaction().begin();
			MigrationModelManager.migrate(session);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error("Migration failure " + e);
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
				Path path = Paths.get(configDir + FileSystems.getDefault().getSeparator() + "repeid-server.json");
				if (Files.isRegularFile(path)) {
					logger.info("Loading config from " + path.toAbsolutePath().toString());
					node = new ObjectMapper().readTree(Files.newInputStream(path));
				}
			}

			if (node == null) {
				URL resource = Thread.currentThread().getContextClassLoader()
						.getResource("META-INF/repeid-server.json");
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
				throw new RuntimeException("Config 'repeid-server.json' not found");
			}
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config", e);
		}
	}

	public static RepeidSessionFactory createSessionFactory() {
		DefaultOpenfactSessionFactory factory = new DefaultOpenfactSessionFactory();
		factory.init();
		return factory;
	}

	public static void setupScheduledTasks(final RepeidSessionFactory sessionFactory) {
		long interval = Config.scope("scheduled").getLong("interval", 60L) * 1000;

		RepeidSession session = sessionFactory.create();
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

	public RepeidSessionFactory getSessionFactory() {
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

	public void importRealms() {
		String files = System.getProperty("keycloak.import");
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
				importRealm(rep, "file " + file);
			}
		}
	}

	public void importRealm(OrganizationRepresentation rep, String from) {
		/*
		 * RepeidSession session = sessionFactory.create(); boolean exists =
		 * false; try { session.getTransaction().begin();
		 * 
		 * try { OrganizationManager manager = new OrganizationManager(session);
		 * manager.setContextPath(getContextPath());
		 * 
		 * if (rep.getId() != null && manager.getRealm(rep.getId()) != null) {
		 * logger.realmExists(rep.getRealm(), from); exists = true; }
		 * 
		 * if (manager.getRealmByName(rep.getRealm()) != null) {
		 * logger.realmExists(rep.getRealm(), from); exists = true; } if
		 * (!exists) { RealmModel realm = manager.importRealm(rep);
		 * logger.importedRealm(realm.getName(), from); }
		 * session.getTransaction().commit(); } catch (Throwable t) {
		 * session.getTransaction().rollback(); if (!exists) {
		 * logger.unableToImportRealm(t, rep.getRealm(), from); } } } finally {
		 * session.close(); }
		 */
	}

	public void importAddUser() {
		/*
		 * String configDir = System.getProperty("jboss.server.config.dir"); if
		 * (configDir != null) { File addUserFile = new File(configDir +
		 * File.separator + "keycloak-add-user.json"); if (addUserFile.isFile())
		 * { logger.imprtingUsersFrom(addUserFile);
		 * 
		 * List<RealmRepresentation> realms; try { realms =
		 * JsonSerialization.readValue(new FileInputStream(addUserFile), new
		 * TypeReference<List<RealmRepresentation>>() { }); } catch (IOException
		 * e) { logger.failedToLoadUsers(e); return; }
		 * 
		 * for (RealmRepresentation realmRep : realms) { for (UserRepresentation
		 * userRep : realmRep.getUsers()) { KeycloakSession session =
		 * sessionFactory.create(); try { session.getTransaction().begin();
		 * 
		 * RealmModel realm =
		 * session.realms().getRealmByName(realmRep.getRealm()); if (realm ==
		 * null) { logger.addUserFailedRealmNotFound(userRep.getUsername(),
		 * realmRep.getRealm()); } else { UserModel user =
		 * session.users().addUser(realm, userRep.getUsername());
		 * user.setEnabled(userRep.isEnabled());
		 * RepresentationToModel.createCredentials(userRep, user);
		 * RepresentationToModel.createRoleMappings(userRep, user, realm); }
		 * 
		 * session.getTransaction().commit();
		 * logger.addUserSuccess(userRep.getUsername(), realmRep.getRealm()); }
		 * catch (ModelDuplicateException e) {
		 * session.getTransaction().rollback();
		 * logger.addUserFailedUserExists(userRep.getUsername(),
		 * realmRep.getRealm()); } catch (Throwable t) {
		 * session.getTransaction().rollback(); logger.addUserFailed(t,
		 * userRep.getUsername(), realmRep.getRealm()); } finally {
		 * session.close(); } } }
		 * 
		 * if (!addUserFile.delete()) {
		 * logger.failedToDeleteFile(addUserFile.getAbsolutePath()); } } }
		 */
	}

	private static <T> T loadJson(InputStream is, Class<T> type) {
		try {
			return JsonSerialization.readValue(is, type);
		} catch (IOException e) {
			throw new RuntimeException("Failed to parse json", e);
		}
	}

}

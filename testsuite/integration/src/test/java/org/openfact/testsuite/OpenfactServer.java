/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openfact.testsuite;

import io.undertow.Undertow;
import io.undertow.Undertow.Builder;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DefaultServletConfig;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.FilterInfo;
import io.undertow.servlet.api.ServletInfo;
import org.jboss.logging.Logger;
import org.jboss.resteasy.plugins.server.servlet.HttpServlet30Dispatcher;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.filters.OpenfactSessionServletFilter;
import org.openfact.services.managers.ApplianceBootstrap;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.OpenfactApplication;
import org.openfact.testsuite.util.cli.TestsuiteCLI;
import org.openfact.util.JsonSerialization;

import javax.servlet.DispatcherType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class OpenfactServer {

    private static final Logger log = Logger.getLogger(OpenfactServer.class);

    private boolean sysout = false;

    public static class OpenfactServerConfig {
        private String host = "localhost";
        private int port = 8081;
        private int workerThreads = Math.max(Runtime.getRuntime().availableProcessors(), 2) * 8;
        private String resourcesHome;

        public String getHost() {
            return host;
        }

        public int getPort() {
            return port;
        }

        public String getResourcesHome() {
            return resourcesHome;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public void setResourcesHome(String resourcesHome) {
            this.resourcesHome = resourcesHome;
        }

        public int getWorkerThreads() {
            return workerThreads;
        }

        public void setWorkerThreads(int workerThreads) {
            this.workerThreads = workerThreads;
        }
    }

    public static <T> T loadJson(InputStream is, Class<T> type) {
        try {
            return JsonSerialization.readValue(is, type);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse json", e);
        }
    }

    public static void main(String[] args) throws Throwable {
        bootstrapOpenfactServer(args);
    }

    public static OpenfactServer bootstrapOpenfactServer(String[] args) throws Throwable {
        File f = new File(System.getProperty("user.home"), ".openfact-server.properties");
        if (f.isFile()) {
            Properties p = new Properties();
            p.load(new FileInputStream(f));
            System.getProperties().putAll(p);
        }

        OpenfactServerConfig config = new OpenfactServerConfig();

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-b")) {
                config.setHost(args[++i]);
            }

            if (args[i].equals("-p")) {
                config.setPort(Integer.valueOf(args[++i]));
            }
        }

        if (System.getProperty("openfact.port") != null) {
            config.setPort(Integer.valueOf(System.getProperty("openfact.port")));
        }

        if (System.getProperty("openfact.bind.address") != null) {
            config.setHost(System.getProperty("openfact.bind.address"));
        }

        if (System.getenv("OPENFACT_DEV_PORT") != null) {
            config.setPort(Integer.valueOf(System.getenv("OPENFACT_DEV_PORT")));
        }

        if (System.getProperties().containsKey("resources")) {
            String resources = System.getProperty("resources");
            if (resources == null || resources.equals("") || resources.equals("true")) {
                if (System.getProperties().containsKey("maven.home")) {
                    resources = System.getProperty("user.dir").replaceFirst("testsuite.integration.*", "");
                } else {
                    for (String c : System.getProperty("java.class.path").split(File.pathSeparator)) {
                        if (c.contains(File.separator + "testsuite" + File.separator + "integration")) {
                            resources = c.replaceFirst("testsuite.integration.*", "");
                        }
                    }
                }
            }

            File dir = new File(resources).getAbsoluteFile();
            if (!dir.isDirectory()) {
                throw new RuntimeException("Invalid base resources directory");

            }
            if (!new File(dir, "themes").isDirectory()) {
                throw new RuntimeException("Invalid resources forms directory");
            }

            if (!System.getProperties().containsKey("openfact.theme.dir")) {
                System.setProperty("openfact.theme.dir", file(dir.getAbsolutePath(), "themes", "src", "main", "resources", "theme").getAbsolutePath());
            } else {
                String foo = System.getProperty("openfact.theme.dir");
                System.out.println(foo);
            }

            if (!System.getProperties().containsKey("openfact.theme.cacheTemplates")) {
                System.setProperty("openfact.theme.cacheTemplates", "false");
            }

            if (!System.getProperties().containsKey("openfact.theme.cacheThemes")) {
                System.setProperty("openfact.theme.cacheThemes", "false");
            }

            if (!System.getProperties().containsKey("openfact.theme.staticMaxAge")) {
                System.setProperty("openfact.theme.staticMaxAge", "-1");
            }

            config.setResourcesHome(dir.getAbsolutePath());
        }

        if (System.getProperties().containsKey("undertowWorkerThreads")) {
            int undertowWorkerThreads = Integer.parseInt(System.getProperty("undertowWorkerThreads"));
            config.setWorkerThreads(undertowWorkerThreads);
        }

        final OpenfactServer openfact = new OpenfactServer(config);
        openfact.sysout = true;
        openfact.start();

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-import")) {
                openfact.importOrganization(new FileInputStream(args[++i]));
            }
        }

        if (System.getProperties().containsKey("import")) {
            openfact.importOrganization(new FileInputStream(System.getProperty("import")));
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                openfact.stop();
            }
        });

        if (System.getProperties().containsKey("startTestsuiteCLI")) {
            new TestsuiteCLI(openfact).start();
        }

        return openfact;
    }

    private OpenfactServerConfig config;

    private OpenfactSessionFactory sessionFactory;

    private UndertowJaxrsServer server;

    public OpenfactServer() {
        this(new OpenfactServerConfig());
    }

    public OpenfactServer(OpenfactServerConfig config) {
        this.config = config;
    }

    public OpenfactSessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public UndertowJaxrsServer getServer() {
        return server;
    }

    public OpenfactServerConfig getConfig() {
        return config;
    }

    public void importOrganization(InputStream organization) {
        OrganizationRepresentation rep = loadJson(organization, OrganizationRepresentation.class);
        importOrganization(rep);
    }

    public void importOrganization(OrganizationRepresentation rep) {
        OpenfactSession session = sessionFactory.create();;
        session.getTransactionManager().begin();

        try {
            OrganizationManager manager = new OrganizationManager(session);

            if (rep.getId() != null && manager.getOrganization(rep.getId()) != null) {
                info("Not importing organization " + rep.getOrganization() + " organization already exists");
                return;
            }

            if (manager.getOrganizationByName(rep.getOrganization()) != null) {
                info("Not importing organization " + rep.getOrganization() + " organization already exists");
                return;
            }
            manager.setContextPath("/openfact");
            OrganizationModel organization = manager.importOrganization(rep);

            info("Imported organization " + organization.getName());

            session.getTransactionManager().commit();
        } finally {
            session.close();
        }
    }

    protected void setupDevConfig() {
        if (System.getProperty("openfact.createAdminUser", "true").equals("true")) {
            OpenfactSession session = sessionFactory.create();
            try {
                session.getTransactionManager().begin();
                if (new ApplianceBootstrap(session).isNoMasterOrganization()) {
                    new ApplianceBootstrap(session).createMasterOrganizationUser("admin", "admin");
                }
                session.getTransactionManager().commit();
            } finally {
                session.close();
            }
        }
    }

    public void start() throws Throwable {
        long start = System.currentTimeMillis();

        ResteasyDeployment deployment = new ResteasyDeployment();
        deployment.setApplicationClass(OpenfactApplication.class.getName());

        Builder builder = Undertow.builder()
                .addHttpListener(config.getPort(), config.getHost())
                .setWorkerThreads(config.getWorkerThreads())
                .setIoThreads(config.getWorkerThreads() / 8);

        server = new UndertowJaxrsServer();
        try {
            server.start(builder);

            DeploymentInfo di = server.undertowDeployment(deployment, "");
            di.setClassLoader(getClass().getClassLoader());
            di.setContextPath("/openfact");
            di.setDeploymentName("Openfact");
            di.setDefaultEncoding("UTF-8");

            di.addInitParameter("openfact.embedded", "true");

            di.setDefaultServletConfig(new DefaultServletConfig(true));

            ServletInfo restEasyDispatcher = Servlets.servlet("Openfact REST Interface", HttpServlet30Dispatcher.class);

            restEasyDispatcher.addInitParam("resteasy.servlet.mapping.prefix", "/");
            restEasyDispatcher.setAsyncSupported(true);

            di.addServlet(restEasyDispatcher);

            FilterInfo filter = Servlets.filter("SessionFilter", OpenfactSessionServletFilter.class);

            filter.setAsyncSupported(true);

            di.addFilter(filter);
            di.addFilterUrlMapping("SessionFilter", "/*", DispatcherType.REQUEST);

            server.deploy(di);

            sessionFactory = ((OpenfactApplication) deployment.getApplication()).getSessionFactory();

            setupDevConfig();

            if (config.getResourcesHome() != null) {
                info("Loading resources from " + config.getResourcesHome());
            }

            info("Started Openfact (http://" + config.getHost() + ":" + config.getPort() + "/openfact) in "
                    + (System.currentTimeMillis() - start) + " ms\n");
        } catch (RuntimeException e) {
            server.stop();
            throw e;
        }
    }

    private void info(String message) {
        if (sysout) {
            System.out.println(message);
        } else {
            log.info(message);
        }
    }

    public void stop() {
        sessionFactory.close();
        server.stop();

        info("Stopped Openfact");
    }

    private static File file(String... path) {
        StringBuilder s = new StringBuilder();
        for (String p : path) {
            s.append(File.separator);
            s.append(p);
        }
        return new File(s.toString());
    }

}

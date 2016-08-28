package org.openfact.testsuite.rule;

import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.ErrorPage;
import io.undertow.servlet.api.FilterInfo;
import io.undertow.servlet.api.LoginConfig;
import io.undertow.servlet.api.SecurityConstraint;
import io.undertow.servlet.api.SecurityInfo;
import io.undertow.servlet.api.ServletInfo;
import io.undertow.servlet.api.WebResourceCollection;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;
import org.openfact.Config;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactTransaction;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.InvoiceRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.testsuite.Retry;
import org.openfact.testsuite.OpenfactServer;
import org.openfact.util.JsonSerialization;
import org.openfact.common.util.Time;

import javax.servlet.DispatcherType;
import javax.servlet.Servlet;
import javax.ws.rs.core.Application;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Map;

public abstract class AbstractOpenfactRule extends ExternalResource {

    protected TemporaryFolder temporaryFolder;

    protected OpenfactServer server;

    protected void before() throws Throwable {
        temporaryFolder = new TemporaryFolder();
        temporaryFolder.create();
        System.setProperty("openfact.tmp.dir", temporaryFolder.newFolder().getAbsolutePath());

        server = new OpenfactServer();

        configureServer(server);

        server.start();

        removeTestRealms();

        setupOpenfact();
    }

    protected void configureServer(OpenfactServer server) {

    }

    public InvoiceRepresentation getInvoice(String organization, int series, int number) {
        OpenfactSession session = server.getSessionFactory().create();
        session.getTransaction().begin();
        try {
            OrganizationModel organizationByName = session.organizations().getOrganizationByName(organization);
            InvoiceModel invoice = session.invoices().getInvoiceBySeriesAndNumber(series, number, organizationByName);
            InvoiceRepresentation invoiceRep = invoice != null ? ModelToRepresentation.toRepresentation(invoice) : null;
            session.getTransaction().commit();
            return invoiceRep;
        } finally {
            session.close();
        }
    }

    public InvoiceRepresentation getInvoiceById(String organization, String id) {
    	OpenfactSession session = server.getSessionFactory().create();
        session.getTransaction().begin();
        try {
            OrganizationModel organizationByName = session.organizations().getOrganizationByName(organization);
            InvoiceRepresentation invoiceRep = ModelToRepresentation.toRepresentation(session.invoices().getInvoiceById(id, organizationByName));
            session.getTransaction().commit();
            return invoiceRep;
        } finally {
            session.close();
        }
    }

    protected void setupOpenfact() {
        OpenfactSession session = server.getSessionFactory().create();
        session.getTransaction().begin();

        try {
            OrganizationManager manager = new OrganizationManager(session);

            OrganizationModel adminstrationOrganization = manager.getOrganization(Config.getAdminOrganization());

            configure(session, manager, adminstrationOrganization);

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void update(OpenfactRule.OpenfactSetup configurer, String organizationId) {
        OpenfactSession session = server.getSessionFactory().create();
        session.getTransaction().begin();

        try {
            OrganizationManager manager = new OrganizationManager(session);
            manager.setContextPath("/auth");

            OrganizationModel adminstrationOrganization = manager.getOrganization(Config.getAdminOrganization());
            OrganizationModel appOrganization = manager.getOrganization(organizationId);

            configurer.session = session;
            configurer.config(manager, adminstrationOrganization, appOrganization);

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    protected void configure(OpenfactSession session, OrganizationManager manager, OrganizationModel adminRealm) {

    }

    public void deployServlet(String name, String contextPath, Class<? extends Servlet> servletClass) {
        DeploymentInfo deploymentInfo = createDeploymentInfo(name, contextPath, servletClass);
        server.getServer().deploy(deploymentInfo);
    }


    public DeploymentInfo createDeploymentInfo(String name, String contextPath, Class<? extends Servlet> servletClass) {
        DeploymentInfo deploymentInfo = new DeploymentInfo();
        deploymentInfo.setClassLoader(getClass().getClassLoader());
        deploymentInfo.setDeploymentName(name);
        deploymentInfo.setContextPath(contextPath);

        ServletInfo servlet = new ServletInfo(servletClass.getSimpleName(), servletClass);
        servlet.addMapping("/*");

        deploymentInfo.addServlet(servlet);
        return deploymentInfo;
    }


    public DeploymentBuilder createApplicationDeployment() {
        return new DeploymentBuilder();
    }

    /*public void addErrorPage(String errorPage, DeploymentInfo di) {
        ServletInfo servlet = new ServletInfo("Error Page", ErrorServlet.class);
        servlet.addMapping("/error.html");
        SecurityConstraint constraint = new SecurityConstraint();
        WebResourceCollection collection = new WebResourceCollection();
        collection.addUrlPattern("/error.html");
        constraint.addWebResourceCollection(collection);
        constraint.setEmptyRoleSemantic(SecurityInfo.EmptyRoleSemantic.PERMIT);
        di.addSecurityConstraint(constraint);
        di.addServlet(servlet);
        di
                .addErrorPage(new ErrorPage(errorPage, 400))
                .addErrorPage(new ErrorPage(errorPage, 401))
                .addErrorPage(new ErrorPage(errorPage, 403))
                .addErrorPage(new ErrorPage(errorPage, 500));
    }*/

    public void deployJaxrsApplication(String name, String contextPath, Class<? extends Application> applicationClass, Map<String,String> initParams) {
        ResteasyDeployment deployment = new ResteasyDeployment();
        deployment.setApplicationClass(applicationClass.getName());

        DeploymentInfo di = server.getServer().undertowDeployment(deployment, "");
        di.setClassLoader(getClass().getClassLoader());
        di.setContextPath(contextPath);
        di.setDeploymentName(name);

        for (Map.Entry<String,String> param : initParams.entrySet()) {
            di.addInitParameter(param.getKey(), param.getValue());
        }

        server.getServer().deploy(di);
    }

    @Override
    protected void after() {
        removeTestRealms();
        stopServer();
        Time.setOffset(0);

        temporaryFolder.delete();
        System.getProperties().remove("openfact.tmp.dir");
    }

    protected void removeTestRealms() {
        OpenfactSession session = server.getSessionFactory().create();
        try {
            session.getTransaction().begin();
            OrganizationManager organizationManager = new OrganizationManager(session);
            for (String organizationName : getTestRealms()) {
                OrganizationModel organization = organizationManager.getOrganizationByName(organizationName);
                if (organization != null) {
                    organizationManager.removeOrganization(organization);
                }
            }
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public OrganizationRepresentation loadJson(String path) throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        int c;
        while ((c = is.read()) != -1) {
            os.write(c);
        }
        byte[] bytes = os.toByteArray();
        return JsonSerialization.readValue(bytes, OrganizationRepresentation.class);
    }

    public OpenfactSession startSession() {
        OpenfactSession session = server.getSessionFactory().create();
        session.getTransaction().begin();
        return session;
    }

    public void stopSession(OpenfactSession session, boolean commit) {
        OpenfactTransaction transaction = session.getTransaction();
        if (commit && !transaction.getRollbackOnly()) {
            transaction.commit();
        } else {
            transaction.rollback();
        }
        session.close();
    }

    public void restartServer() {
        try {
            stopServer();
            server.start();
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private void stopServer() {
        server.stop();

        // Add some variable delay (Some windows envs have issues as server is not stopped immediately after server.stop)
        try {
            Retry.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        Socket s = new Socket(server.getConfig().getHost(), server.getConfig().getPort());
                        s.close();
                        throw new IllegalStateException("Server still running");
                    } catch (IOException expected) {
                    }
                }

            }, 10, 500);
            Thread.sleep(100);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    protected String[] getTestRealms() {
        return new String[]{"test", "demo"};
    }

    public class DeploymentBuilder {

        private String name;
        private String contextPath;
        private Class<? extends Servlet> servletClass;
        private String adapterConfigPath;
        private String role;
        private boolean isConstrained = true;
        //private Class<? extends KeycloakConfigResolver> openfactConfigResolver;
        private String constraintUrl = "/*";
        private String errorPage = "/error.html";

        public DeploymentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DeploymentBuilder contextPath(String contextPath) {
            this.contextPath = contextPath;
            return this;
        }

        public DeploymentBuilder servletClass(Class<? extends Servlet> servletClass) {
            this.servletClass = servletClass;
            return this;
        }

        public DeploymentBuilder adapterConfigPath(String adapterConfigPath) {
            this.adapterConfigPath = adapterConfigPath;
            return this;
        }

        public DeploymentBuilder role(String role) {
            this.role = role;
            return this;
        }

        public DeploymentBuilder isConstrained(boolean isConstrained) {
            this.isConstrained = isConstrained;
            return this;
        }

       /* public DeploymentBuilder openfactConfigResolver(Class<? extends KeycloakConfigResolver> openfactConfigResolver) {
            this.openfactConfigResolver = openfactConfigResolver;
            return this;
        }*/

        public DeploymentBuilder constraintUrl(String constraintUrl) {
            this.constraintUrl = constraintUrl;
            return this;
        }

        public DeploymentBuilder errorPage(String errorPage) {
            this.errorPage = errorPage;
            return this;
        }

        public void deployApplication() {
            /*DeploymentInfo di = createDeploymentInfo(name, contextPath, servletClass);
            if (null == openfactConfigResolver) {
                di.addInitParameter("openfact.config.file", adapterConfigPath);
            } else {
                di.addInitParameter("openfact.config.resolver", openfactConfigResolver.getCanonicalName());
            }
            if (isConstrained) {
                SecurityConstraint constraint = new SecurityConstraint();
                WebResourceCollection collection = new WebResourceCollection();
                collection.addUrlPattern(constraintUrl);
                constraint.addWebResourceCollection(collection);
                constraint.addRoleAllowed(role);
                di.addSecurityConstraint(constraint);
            }
            LoginConfig loginConfig = new LoginConfig("KEYCLOAK", "demo", null, null);
            di.setLoginConfig(loginConfig);
            addErrorPage(errorPage, di);

            server.getServer().deploy(di);*/
        }

        /*public void deployApplicationWithFilter() {
            DeploymentInfo di = createDeploymentInfo(name, contextPath, servletClass);
            FilterInfo filter = new FilterInfo("openfact-filter", KeycloakOIDCFilter.class);
            if (null == openfactConfigResolver) {
                filter.addInitParam("openfact.config.file", adapterConfigPath);
            } else {
                filter.addInitParam("openfact.config.resolver", openfactConfigResolver.getCanonicalName());
            }
            di.addFilter(filter);
            di.addFilterUrlMapping("openfact-filter", constraintUrl, DispatcherType.REQUEST);
            server.getServer().deploy(di);



        }*/

    }

}

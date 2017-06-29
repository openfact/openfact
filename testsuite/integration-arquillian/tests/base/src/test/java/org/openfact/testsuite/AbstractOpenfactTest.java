package org.openfact.testsuite;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.junit.runner.RunWith;
import org.openfact.testsuite.arquillian.OfArquillian;

import javax.ws.rs.NotFoundException;

import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(OfArquillian.class)
@RunAsClient
public abstract class AbstractOpenfactTest {

    protected Logger log = Logger.getLogger(this.getClass());

    @ArquillianResource
    protected SuiteContext suiteContext;

    @ArquillianResource
    protected TestContext testContext;

    protected Keycloak adminClient;

    protected KeycloakTestingClient testingClient;

    @ArquillianResource
    protected OAuthClient oauth;

    protected List<RealmRepresentation> testRealmReps;

    @Drone
    protected WebDriver driver;

    @Page
    protected AuthServerContextRoot authServerContextRootPage;
    @Page
    protected AuthServer authServerPage;

    @Page
    protected AuthRealm masterRealmPage;

    @Page
    protected Account accountPage;
    @Page
    protected OIDCLogin loginPage;
    @Page
    protected UpdatePassword updatePasswordPage;

    @Page
    protected WelcomePage welcomePage;

    protected UserRepresentation adminUser;

    private PropertiesConfiguration constantsProperties;

    private boolean resetTimeOffset;

}

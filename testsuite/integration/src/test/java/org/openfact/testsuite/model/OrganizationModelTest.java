package org.openfact.testsuite.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

@RunWith(Arquillian.class)
@UsingDataSet("empty.xml")
public class OrganizationModelTest {

    public static final String ORGANIZATION_NAME = "SISTCOOP S.A.C.";

    public OrganizationModel ORGANIZATION;

    @Inject
    public OrganizationProvider organizationProvider;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addAsResource("persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClasses(TestUtil.getBasicClasses())
                .addClasses(TestUtil.getOrganizationClasses())
                .addPackage(TestUtil.getEntitiesPackage());
        return archive.addAsLibraries(libs);
    }

    @Before
    public void before() {
        ORGANIZATION = organizationProvider.createOrganization(ORGANIZATION_NAME);
    }

    @Test
    public void test_supported_locales_success() {
        Set<String> supportedLocales = new HashSet<>();
        supportedLocales.add("es");
        supportedLocales.add("en");

        Set<String> initialSupportedLocales = ORGANIZATION.getSupportedLocales();
        ORGANIZATION.setSupportedLocales(supportedLocales);
        Set<String> currentSupportedLocales = ORGANIZATION.getSupportedLocales();

        assertThat("Result should never be null", initialSupportedLocales, is(notNullValue()));
        assertThat("Initial Size should be empty", initialSupportedLocales.size(), is(equalTo(0)));
        assertThat("Result should never be null", currentSupportedLocales, is(notNullValue()));
        assertThat("Incorrect number ", currentSupportedLocales.size(), is(equalTo(2)));
    }

    @Test
    public void test_supported_currencies_success() {
        Set<String> supportedCurrencies = new HashSet<>();
        supportedCurrencies.add("PEN");
        supportedCurrencies.add("US");

        Set<String> initialSupportedCurrencies = ORGANIZATION.getSupportedCurrencies();
        ORGANIZATION.setSupportedCurrencies(supportedCurrencies);
        Set<String> currentSupportedCurrencies = ORGANIZATION.getSupportedCurrencies();

        assertThat("Result should never be null", initialSupportedCurrencies, is(notNullValue()));
        assertThat("Initial Size should be empty", initialSupportedCurrencies.size(), is(equalTo(0)));
        assertThat("Result should never be null", currentSupportedCurrencies, is(notNullValue()));
        assertThat("Incorrect number", currentSupportedCurrencies.size(), is(equalTo(2)));
    }

    @Test
    public void test_events_listener_success() {
        Set<String> eventsListener = new HashSet<>();
        eventsListener.add("Listener1");
        eventsListener.add("Listener2");

        Set<String> initialEventsListener = ORGANIZATION.getEventsListeners();
        ORGANIZATION.setEventsListeners(eventsListener);
        Set<String> currentEventsListener = ORGANIZATION.getEventsListeners();

        assertThat("Result should never be null", initialEventsListener, is(notNullValue()));
        assertThat("Initial Size should be empty", initialEventsListener.size(), is(equalTo(0)));
        assertThat("Result should never be null", currentEventsListener, is(notNullValue()));
        assertThat("Incorrect number", currentEventsListener.size(), is(equalTo(2)));
    }

    @Test
    public void test_enabled_event_types_success() {
        Set<String> enabledEventTypes = new HashSet<>();
        enabledEventTypes.add("Event1");
        enabledEventTypes.add("Event2");

        Set<String> initialEnabledEventTypes = ORGANIZATION.getEnabledEventTypes();
        ORGANIZATION.setEnabledEventTypes(enabledEventTypes);
        Set<String> currentEnabledEventTypes = ORGANIZATION.getEnabledEventTypes();

        assertThat("Result should never be null", initialEnabledEventTypes, is(notNullValue()));
        assertThat("Initial Size should be empty", initialEnabledEventTypes.size(), is(equalTo(0)));
        assertThat("Result should never be null", currentEnabledEventTypes, is(notNullValue()));
        assertThat("Incorrect number", currentEnabledEventTypes.size(), is(equalTo(2)));
    }

    @Test
    public void test_smtp_config_success() {
        Map<String, String> smtpConfig = new HashMap<>();
        smtpConfig.put("key1", "value1");
        smtpConfig.put("key2", "value2");

        Map<String, String> initialSmtpConfig = ORGANIZATION.getSmtpConfig();
        ORGANIZATION.setSmtpConfig(smtpConfig);
        Map<String, String> currentSmtpConfig = ORGANIZATION.getSmtpConfig();

        assertThat("Result should never be null", initialSmtpConfig, is(notNullValue()));
        assertThat("Initial Size should be empty", initialSmtpConfig.size(), is(equalTo(0)));
        assertThat("Result should never be null", currentSmtpConfig, is(notNullValue()));
        assertThat("Incorrect number", currentSmtpConfig.size(), is(equalTo(2)));
        assertThat("Incorrect number", currentSmtpConfig.get("key1"), is(equalTo("value1")));
        assertThat("Incorrect number", currentSmtpConfig.get("key2"), is(equalTo("value2")));
    }

    @Test
    public void test_browser_security_header_success() {
        Map<String, String> browserSecurityHeader = new HashMap<>();
        browserSecurityHeader.put("key1", "value1");
        browserSecurityHeader.put("key2", "value2");

        Map<String, String> initialBrowserSecurityHeader = ORGANIZATION.getBrowserSecurityHeaders();
        ORGANIZATION.setBrowserSecurityHeaders(browserSecurityHeader);
        Map<String, String> currentBrowserSecurityHeader = ORGANIZATION.getBrowserSecurityHeaders();

        assertThat("Result should never be null", initialBrowserSecurityHeader, is(notNullValue()));
        assertThat("Initial Size should be empty", initialBrowserSecurityHeader.size(), is(equalTo(0)));
        assertThat("Result should never be null", currentBrowserSecurityHeader, is(notNullValue()));
        assertThat("Incorrect number", currentBrowserSecurityHeader.size(), is(equalTo(2)));
        assertThat("Incorrect number", currentBrowserSecurityHeader.get("key1"), is(equalTo("value1")));
        assertThat("Incorrect number", currentBrowserSecurityHeader.get("key2"), is(equalTo("value2")));
    }

    @Test
    public void test_attribute_success() {
        ORGANIZATION.setAttribute("string", "value");
        ORGANIZATION.setAttribute("boolean", true);
        ORGANIZATION.setAttribute("integer", 1);
        ORGANIZATION.setAttribute("long", 1L);

        assertThat("Values are not the same", ORGANIZATION.getAttribute("string"), is(equalTo("value")));

        assertThat("Values are not the same", ORGANIZATION.getAttribute("boolean"), is(equalTo("true")));
        assertThat("Values are not the same", ORGANIZATION.getAttribute("boolean", false), is(equalTo(true)));
        assertThat("Values are not the same", ORGANIZATION.getAttribute("boolean1", true), is(equalTo(true)));

        assertThat("Values are not the same", ORGANIZATION.getAttribute("integer"), is(equalTo("1")));
        assertThat("Values are not the same", ORGANIZATION.getAttribute("integer", 0), is(equalTo(1)));
        assertThat("Values are not the same", ORGANIZATION.getAttribute("integer1", 0), is(equalTo(0)));

        assertThat("Values are not the same", ORGANIZATION.getAttribute("long"), is(equalTo("1")));
        assertThat("Values are not the same", ORGANIZATION.getAttribute("long", 0L), is(equalTo(1L)));
        assertThat("Values are not the same", ORGANIZATION.getAttribute("long1", 0L), is(equalTo(0L)));

        // remove attribute
        ORGANIZATION.removeAttribute("string");
        assertThat("Values are not the same", ORGANIZATION.getAttribute("string"), is(nullValue()));
    }

    @Test
    public void test_remove_organization_cascade_success() {
        ORGANIZATION.setAttribute("string", "value");
        ORGANIZATION.setAttribute("boolean", true);
        ORGANIZATION.setAttribute("integer", 1);
        ORGANIZATION.setAttribute("long", 1L);

        // Remove Organization
        boolean result = organizationProvider.removeOrganization(ORGANIZATION);
        assertThat("Result should be true", result, equalTo(true));
    }

    @Test(expected = ModelDuplicateException.class)
    public void test_update_duplicate_name_fail() {
        OrganizationModel organization = organizationProvider.createOrganization("SoftGreen S.A.C.");
        organization.setName(ORGANIZATION_NAME);
    }

}

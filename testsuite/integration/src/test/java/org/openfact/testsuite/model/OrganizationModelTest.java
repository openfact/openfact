package org.openfact.testsuite.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
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

public class OrganizationModelTest extends AbstractModelTest {

    public static final String ORGANIZATION_NAME = "SISTCOOP S.A.C.";

    public OrganizationModel ORGANIZATION;

    @Inject
    public OrganizationProvider organizationProvider;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = buildArchive().addClasses(TestUtil.getOrganizationClasses());
        return archive.addAsLibraries(libs);
    }

    @Before
    public void before() {
        ORGANIZATION = organizationProvider.createOrganization(ORGANIZATION_NAME);
    }

    @Test
    public void configSupportedLocales() {
        Set<String> supportedLocales = new HashSet<>();
        supportedLocales.add("es");
        supportedLocales.add("en");

        // Get initial supported locales
        Set<String> initialSupportedLocales = ORGANIZATION.getSupportedLocales();

        // Change supported locales
        ORGANIZATION.setSupportedLocales(supportedLocales);

        // Get supported locales
        Set<String> currentSupportedLocales = ORGANIZATION.getSupportedLocales();

        assertThat(initialSupportedLocales, is(notNullValue()));
        assertThat(initialSupportedLocales.size(), is(equalTo(0)));
        assertThat(currentSupportedLocales, is(notNullValue()));
        assertThat(currentSupportedLocales.size(), is(equalTo(2)));
    }

    @Test
    public void configSupportedCurrencies() {
        Set<String> supportedCurrencies = new HashSet<>();
        supportedCurrencies.add("PEN");
        supportedCurrencies.add("US");

        // Get initial supported currencies
        Set<String> initialSupportedCurrencies = ORGANIZATION.getSupportedCurrencies();

        // Change supported currencies
        ORGANIZATION.setSupportedCurrencies(supportedCurrencies);

        // Get supported currencies
        Set<String> currentSupportedCurrencies = ORGANIZATION.getSupportedCurrencies();

        assertThat(initialSupportedCurrencies, is(notNullValue()));
        assertThat(initialSupportedCurrencies.size(), is(equalTo(0)));
        assertThat(currentSupportedCurrencies, is(notNullValue()));
        assertThat(currentSupportedCurrencies.size(), is(equalTo(2)));
    }

    @Test
    public void configEventListeners() {
        Set<String> eventsListener = new HashSet<>();
        eventsListener.add("Listener1");
        eventsListener.add("Listener2");

        // Get initial event listeners
        Set<String> initialEventsListener = ORGANIZATION.getEventsListeners();

        // Change event listeners
        ORGANIZATION.setEventsListeners(eventsListener);

        // Get event listeners
        Set<String> currentEventsListener = ORGANIZATION.getEventsListeners();

        assertThat(initialEventsListener, is(notNullValue()));
        assertThat(initialEventsListener.size(), is(equalTo(0)));
        assertThat(currentEventsListener, is(notNullValue()));
        assertThat(currentEventsListener.size(), is(equalTo(2)));
    }

    @Test
    public void configEventTypes() {
        Set<String> enabledEventTypes = new HashSet<>();
        enabledEventTypes.add("Event1");
        enabledEventTypes.add("Event2");

        // Get initial enabled event types
        Set<String> initialEnabledEventTypes = ORGANIZATION.getEnabledEventTypes();

        // Change enabled event types
        ORGANIZATION.setEnabledEventTypes(enabledEventTypes);

        // Get enabled event types
        Set<String> currentEnabledEventTypes = ORGANIZATION.getEnabledEventTypes();

        assertThat(initialEnabledEventTypes, is(notNullValue()));
        assertThat(initialEnabledEventTypes.size(), is(equalTo(0)));
        assertThat(currentEnabledEventTypes, is(notNullValue()));
        assertThat(currentEnabledEventTypes.size(), is(equalTo(2)));
    }

    @Test
    public void configSmtp() {
        Map<String, String> smtpConfig = new HashMap<>();
        smtpConfig.put("key1", "value1");
        smtpConfig.put("key2", "value2");

        // Get initial smtp
        Map<String, String> initialSmtpConfig = ORGANIZATION.getSmtpConfig();

        // Change smtp
        ORGANIZATION.setSmtpConfig(smtpConfig);

        // Get smtp
        Map<String, String> currentSmtpConfig = ORGANIZATION.getSmtpConfig();

        assertThat(initialSmtpConfig, is(notNullValue()));
        assertThat(initialSmtpConfig.size(), is(equalTo(0)));
        assertThat(currentSmtpConfig, is(notNullValue()));
        assertThat(currentSmtpConfig.size(), is(equalTo(2)));
        assertThat(currentSmtpConfig.get("key1"), is(equalTo("value1")));
        assertThat(currentSmtpConfig.get("key2"), is(equalTo("value2")));
    }

    @Test
    public void configBrowserSecurityHeaders() {
        Map<String, String> browserSecurityHeader = new HashMap<>();
        browserSecurityHeader.put("key1", "value1");
        browserSecurityHeader.put("key2", "value2");

        // Get initial browser security headers
        Map<String, String> initialBrowserSecurityHeader = ORGANIZATION.getBrowserSecurityHeaders();

        // Change browser security headers
        ORGANIZATION.setBrowserSecurityHeaders(browserSecurityHeader);

        // Get browser security headers
        Map<String, String> currentBrowserSecurityHeader = ORGANIZATION.getBrowserSecurityHeaders();

        assertThat(initialBrowserSecurityHeader, is(notNullValue()));
        assertThat(initialBrowserSecurityHeader.size(), is(equalTo(0)));
        assertThat(currentBrowserSecurityHeader, is(notNullValue()));
        assertThat(currentBrowserSecurityHeader.size(), is(equalTo(2)));
        assertThat(currentBrowserSecurityHeader.get("key1"), is(equalTo("value1")));
        assertThat(currentBrowserSecurityHeader.get("key2"), is(equalTo("value2")));
    }

    @Test
    public void configAttributes() {
        ORGANIZATION.setAttribute("string", "value");
        ORGANIZATION.setAttribute("boolean", true);
        ORGANIZATION.setAttribute("integer", 1);
        ORGANIZATION.setAttribute("long", 1L);

        assertThat(ORGANIZATION.getAttribute("string"), is(equalTo("value")));

        assertThat(ORGANIZATION.getAttribute("boolean"), is(equalTo("true")));
        assertThat(ORGANIZATION.getAttribute("boolean", false), is(equalTo(true)));
        assertThat(ORGANIZATION.getAttribute("boolean1", true), is(equalTo(true)));

        assertThat(ORGANIZATION.getAttribute("integer"), is(equalTo("1")));
        assertThat(ORGANIZATION.getAttribute("integer", 0), is(equalTo(1)));
        assertThat(ORGANIZATION.getAttribute("integer1", 0), is(equalTo(0)));

        assertThat(ORGANIZATION.getAttribute("long"), is(equalTo("1")));
        assertThat(ORGANIZATION.getAttribute("long", 0L), is(equalTo(1L)));
        assertThat(ORGANIZATION.getAttribute("long1", 0L), is(equalTo(0L)));

        // remove attribute
        ORGANIZATION.removeAttribute("string");
        assertThat(ORGANIZATION.getAttribute("string"), is(nullValue()));
    }

    @Test
    public void removeOrganization() {
        ORGANIZATION.setAttribute("string", "value");
        ORGANIZATION.setAttribute("boolean", true);
        ORGANIZATION.setAttribute("integer", 1);
        ORGANIZATION.setAttribute("long", 1L);

        // Remove Organization
        boolean result = organizationProvider.removeOrganization(ORGANIZATION);
        assertThat("Result should be true", result, equalTo(true));
    }

    @Test(expected = ModelDuplicateException.class)
    public void updateAndDupplicate() {
        OrganizationModel organization = organizationProvider.createOrganization("SoftGreen S.A.C.");
        organization.setName(ORGANIZATION_NAME);
    }

}

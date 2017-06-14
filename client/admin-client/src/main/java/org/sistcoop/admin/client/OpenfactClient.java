package org.sistcoop.admin.client;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.sistcoop.admin.client.resource.OrganizationsResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OpenfactClient {

    private Openfact openfact;

    private static final Properties ofProperties = new Properties();
    private static final Properties kcProperties = new Properties();

    static {
        InputStream ofIs = OpenfactClient.class.getClassLoader().getResourceAsStream("META-INF/openfact.properties");
        InputStream kcIs = OpenfactClient.class.getClassLoader().getResourceAsStream("META-INF/keycloak.properties");

        try {
            if (ofIs != null) {
                ofProperties.load(ofIs);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Invalid Openfact configuration");
        }

        try {
            if (kcIs != null) {
                kcProperties.load(kcIs);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Invalid Keycloak configuration");
        }
    }

    private OpenfactClient() throws IOException {
        this(ofProperties.getProperty("serverUrl"));
    }

    private OpenfactClient(String serverUrl) throws IOException {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(kcProperties.getProperty("serverUrl"))
                .realm(kcProperties.getProperty("realm"))
                .username(kcProperties.getProperty("username"))
                .password(kcProperties.getProperty("password"))
                .clientId(kcProperties.getProperty("clientId"))
                .clientSecret(kcProperties.getProperty("clientSecret")).build();

        openfact = OpenfactBuilder.builder().serverUrl(serverUrl).keycloakClient(keycloak).build();
    }

    private OpenfactClient(String serverUrl, Keycloak keycloak) throws IOException {
        openfact = OpenfactBuilder.builder().serverUrl(serverUrl).keycloakClient(keycloak).build();
    }

    public static OpenfactClient buildTarget() {
        try {
            return new OpenfactClient();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static OpenfactClient buildTarget(String serverUrl) {
        try {
            return new OpenfactClient(serverUrl);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static OpenfactClient buildTarget(String serverUrl, Keycloak keycloak) {
        try {
            return new OpenfactClient(serverUrl, keycloak);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public OrganizationsResource organizations() {
        return openfact.organizations();
    }

    public ResteasyWebTarget target(String uri) {
        return openfact.target(uri);
    }

    public Openfact getOpenfact() {
        return this.openfact;
    }

}

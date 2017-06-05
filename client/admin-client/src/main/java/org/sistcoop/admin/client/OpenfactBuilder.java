package org.sistcoop.admin.client;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.keycloak.admin.client.Keycloak;

public class OpenfactBuilder {

    private String serverUrl;

    private Keycloak keycloakClient;
    private ResteasyClient resteasyClient;

    public OpenfactBuilder serverUrl(String serverUrl) {
        this.serverUrl = serverUrl;
        return this;
    }

    public OpenfactBuilder keycloakClient(Keycloak keycloakClient) {
        this.keycloakClient = keycloakClient;
        return this;
    }

    public OpenfactBuilder resteasyClient(ResteasyClient resteasyClient) {
        this.resteasyClient = resteasyClient;
        return this;
    }

    /**
     * Builds a new Openfact client from this builder.
     */
    public Openfact build() {
        if (serverUrl == null) {
            throw new IllegalStateException("serverUrl required");
        }

        if (keycloakClient == null) {
            throw new IllegalStateException("keycloakClient required");
        }

        return new Openfact(serverUrl, keycloakClient, resteasyClient);
    }

    private OpenfactBuilder() {
    }

    /**
     * Returns a new Openfact builder.
     */
    public static OpenfactBuilder builder() {
        return new OpenfactBuilder();
    }
}

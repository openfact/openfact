package org.sistcoop.admin.client;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.BearerAuthFilter;
import org.sistcoop.admin.client.resource.OrganizationResource;
import org.sistcoop.admin.client.resource.OrganizationsResource;

import java.net.URI;

public class Openfact {

    private final Config config;
    private final Keycloak keycloakClient;
    private final ResteasyWebTarget target;
    private final ResteasyClient client;

    Openfact(String serverUrl, Keycloak keycloakClient, ResteasyClient resteasyClient) {
        this.config = new Config(serverUrl);
        this.client = resteasyClient != null ? resteasyClient : new ResteasyClientBuilder().connectionPoolSize(10).build();
        this.keycloakClient = keycloakClient;

        this.client.register(newAuthFilter());
        this.target = client.target(config.getServerUrl());
        //this.target.register(newAuthFilter());
    }

    private BearerAuthFilter newAuthFilter() {
        return new BearerAuthFilter(keycloakClient.tokenManager());
    }

    public ResteasyWebTarget target(String uri) {
        return client.target(uri);
    }

    public OrganizationsResource organizations() {
        return target.proxy(OrganizationsResource.class);
    }

    public OrganizationResource organization(String organizationName) {
        return organizations().organization(organizationName);
    }

    /**
     * Create a secure proxy based on an absolute URI.
     * All set up with appropriate token
     *
     * @param proxyClass
     * @param absoluteURI
     * @param <T>
     * @return
     */
    public <T> T proxy(Class<T> proxyClass, URI absoluteURI) {
        return client.target(absoluteURI).proxy(proxyClass);
    }

    /**
     * Closes the underlying client. After calling this method, this <code>Openfact</code> instance cannot be reused.
     */
    public void close() {
        client.close();
    }

}
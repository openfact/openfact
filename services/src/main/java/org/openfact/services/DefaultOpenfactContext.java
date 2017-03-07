package org.openfact.services;

import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.OpenfactContext;
import org.openfact.models.OrganizationModel;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

public class DefaultOpenfactContext implements OpenfactContext {

    private OrganizationModel organization;
    private ClientConnection connection;

    @Override
    public URI getOpenfactServerUrl() {
        UriInfo uri = getUri();
        OpenfactApplication openfactApplication = getContextObject(OpenfactApplication.class);
        return openfactApplication.getBaseUri(uri);
    }

    @Override
    public String getContextPath() {
        OpenfactApplication app = getContextObject(OpenfactApplication.class);
        if (app == null) return null;
        return app.getContextPath();
    }

    @Override
    public UriInfo getUri() {
        return getContextObject(UriInfo.class);
    }

    @Override
    public HttpHeaders getRequestHeaders() {
        return getContextObject(HttpHeaders.class);
    }

    @Override
    public <T> T getContextObject(Class<T> clazz) {
        return ResteasyProviderFactory.getContextData(clazz);
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public void setOrganization(OrganizationModel organization) {
        this.organization = organization;
    }

    @Override
    public ClientConnection getConnection() {
        return connection;
    }

    @Override
    public void setConnection(ClientConnection connection) {
        this.connection = connection;
    }

}

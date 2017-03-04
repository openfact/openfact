package org.openfact.models;

import org.openfact.common.ClientConnection;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

public interface OpenfactContext {

    URI getOpenfactServerUrl();

    String getContextPath();

    UriInfo getUri();

    HttpHeaders getRequestHeaders();

    <T> T getContextObject(Class<T> clazz);

    OrganizationModel getOrganization();

    void setOrganization(OrganizationModel organization);

    ClientConnection getConnection();

    void setConnection(ClientConnection connection);

}

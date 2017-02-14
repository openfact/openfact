package org.openfact.models;

import org.openfact.common.ClientConnection;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.Locale;

public interface OpenfactContext {

    URI getAuthServerUrl();

    String getContextPath();

    UriInfo getUri();

    HttpHeaders getRequestHeaders();

    <T> T getContextObject(Class<T> clazz);

    OrganizationModel getOrganization();

    void setOrganization(OrganizationModel organization);

    ClientConnection getConnection();

    void setConnection(ClientConnection connection);

    Locale resolveLocale(UserModel user);

}

package org.openfact.models;

import java.net.URI;
import java.util.Locale;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import org.openfact.common.ClientConnection;
import org.openfact.models.utils.OrganizationImporter;

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

    OrganizationImporter getOrganizationManager();

    Locale resolveLocale(UserModel user);

}

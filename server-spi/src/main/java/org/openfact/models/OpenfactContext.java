package org.openfact.models;

import java.net.URI;
import java.util.Locale;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import org.openfact.common.ClientConnection;

public interface OpenfactContext {

    URI getAuthServerUrl();

    String getContextPath();

    UriInfo getUri();

    HttpHeaders getRequestHeaders();

    <T> T getContextObject(Class<T> clazz);

    OrganizationModel getOrganization();

    void setOrganization(OrganizationModel organization);

    //ClientModel getClient();

    //void setClient(ClientModel client);

    ClientConnection getConnection();

    void setConnection(ClientConnection connection);

    //OrganizationImporter getRealmManager();

    //Locale resolveLocale(UserModel user);

}

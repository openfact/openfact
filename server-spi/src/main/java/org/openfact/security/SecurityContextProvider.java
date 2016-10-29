package org.openfact.security;

import javax.ws.rs.core.HttpHeaders;

import org.openfact.models.UserModel;
import org.openfact.provider.Provider;

/**
 * The security context used by the REST API to determine whether the current
 * user has appropriate access to see specific data or perform certain actions.
 *
 * @author carlosthe19916@sistcoop.com
 */
public interface SecurityContextProvider extends Provider {

    String getCurrentOrganizationName(HttpHeaders headers);

    UserModel getCurrentUser(HttpHeaders headers);

    String getRequestHeader(String headerName);

}

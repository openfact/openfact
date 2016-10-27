package org.openfact.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;

import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;
import org.openfact.provider.Provider;

public interface AuthenticationProvider extends Provider {

    String getOrganizationName(HttpHeaders headers, HttpServletRequest request);

    UserModel getUser(HttpHeaders headers, HttpServletRequest request);

}

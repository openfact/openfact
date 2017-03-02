package org.openfact.services.resources.admin.interceptors;

import org.openfact.models.OrganizationModel;
import org.openfact.security.SecurityContextProvider;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.admin.AdminAuth;
import org.openfact.services.resources.admin.interceptors.OrganizationAuth;

import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.NotAuthorizedException;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;

@OrganizationAuth
@Interceptor
public class OrganizationAuthInterceptor {

    @Inject
    private SecurityContextProvider authResult;

    @AroundInvoke
    private Object intercept(InvocationContext ic) throws Exception {
        /*String organizationName = authResult.getCurrentOrganizationName(headers);
        OrganizationManager organizationManager = new OrganizationManager(session);
        OrganizationModel organization = organizationManager.getOrganizationByName(organizationName);
        if (organization == null) {
            throw new NotAuthorizedException("Unknown organization in token");
        }*/

        try {
            return ic.proceed();
        } finally {
        }
    }
}
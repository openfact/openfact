/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.services.resources.admin;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;
import org.jboss.resteasy.spi.NoLogWebApplicationException;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.AdminRoles;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.security.SecurityContextProvider;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.Cors;
import org.openfact.services.resources.admin.info.ServerInfoAdminResource;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.IOException;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Path("/admin")
public class AdminRoot {

    protected static final Logger logger = Logger.getLogger(AdminRoot.class);

    @Context
    protected UriInfo uriInfo;

    @Context
    protected ClientConnection clientConnection;

    @Context
    protected HttpRequest request;

    @Context
    protected HttpResponse response;

    @Context
    protected OpenfactSession session;

    public AdminRoot() {
    }

    public static UriBuilder adminBaseUrl(UriInfo uriInfo) {
        return adminBaseUrl(uriInfo.getBaseUriBuilder());
    }

    public static UriBuilder adminBaseUrl(UriBuilder base) {
        return base.path(AdminRoot.class);
    }

    public static UriBuilder adminConsoleUrl(UriInfo uriInfo) {
        return adminConsoleUrl(uriInfo.getBaseUriBuilder());
    }

    public static UriBuilder adminConsoleUrl(UriBuilder base) {
        return adminBaseUrl(base).path(AdminRoot.class, "getAdminConsole");
    }

    public static UriBuilder organizationsUrl(UriInfo uriInfo) {
        return organizationsUrl(uriInfo.getBaseUriBuilder());
    }

    public static UriBuilder organizationsUrl(UriBuilder base) {
        return adminBaseUrl(base).path(AdminRoot.class, "getOrganizationsAdmin");
    }

    public static Theme getTheme(OpenfactSession session, OrganizationModel organization) throws IOException {
        ThemeProvider themeProvider = session.getProvider(ThemeProvider.class, "extending");
        return themeProvider.getTheme("adminTheme", Theme.Type.ADMIN);
    }

    /**
     * Convenience path to master Organization admin console
     *
     * @return
     * @exclude
     */
    @GET
    public Response masterOrganizationAdminConsoleRedirect() {
        OrganizationModel master = new OrganizationManager(session).getOpenfactAdminstrationOrganization();
        return Response.status(302).location(uriInfo.getBaseUriBuilder().path(AdminRoot.class)
                .path(AdminRoot.class, "getAdminConsole").path("/").build(master.getName())).build();
    }

    /**
     * Convenience path to master Organization admin console
     *
     * @return
     * @exclude
     */
    @GET
    @Path("index.{html:html}")
    public Response masterOrganizationAdminConsoleRedirectHtml() {
        return masterOrganizationAdminConsoleRedirect();
    }

    protected OrganizationModel locateOrganization(String name, OrganizationManager organizationManager) {
        OrganizationModel organization = organizationManager.getOrganizationByName(name);
        if (organization == null) {
            throw new NotFoundException("Organization not found.  Did you type in a bad URL?");
        }
        session.getContext().setOrganization(organization);
        return organization;
    }

    /**
     * path to Organization admin console ui
     *
     * @param name Organization name (not id!)
     * @return
     * @exclude
     */
    @Path("{organization}/console")
    public AdminConsole getAdminConsole(final @PathParam("organization") String name) {
        OrganizationManager organizationManager = new OrganizationManager(session);
        OrganizationModel organization = locateOrganization(name, organizationManager);
        AdminConsole service = new AdminConsole(organization);
        ResteasyProviderFactory.getInstance().injectProperties(service);
        return service;
    }

    protected AdminAuth authenticateOrganizationAdminRequest(HttpHeaders headers) {
        SecurityContextProvider authResult = session.getProvider(SecurityContextProvider.class);
        String organizationName = authResult.getCurrentOrganizationName(headers);
        OrganizationManager organizationManager = new OrganizationManager(session);
        OrganizationModel organization = organizationManager.getOrganizationByName(organizationName);
        if (organization == null) {
            throw new NotAuthorizedException("Unknown organization in token");
        }
        session.getContext().setOrganization(organization);

        return new AdminAuth(organization, authResult.getCurrentUser(headers));
    }

    /**
     * Base Path to Organization admin REST interface
     *
     * @param headers
     * @return
     */
    @Path("organizations")
    public OrganizationsAdminResource getOrganizationsAdmin(@Context final HttpHeaders headers) {
        handlePreflightRequest();

        AdminAuth auth = authenticateOrganizationAdminRequest(headers);
        if (auth != null) {
            logger.debug("authenticated admin access for: " + auth.getUser().getUsername());
        }

        Cors.add(request).allowedOrigins("*").allowedMethods("GET", "PUT", "POST", "DELETE")
                .exposedHeaders("Location").auth().build(response);

        OrganizationsAdminResource adminResource = new OrganizationsAdminResource(auth);
        ResteasyProviderFactory.getInstance().injectProperties(adminResource);
        return adminResource;
    }

    /**
     * General information about the server
     *
     * @param headers
     * @return
     */
    @Path("serverinfo")
    public ServerInfoAdminResource getServerInfo(@Context final HttpHeaders headers) {
        handlePreflightRequest();

        AdminAuth auth = authenticateOrganizationAdminRequest(headers);
        if (!isAdmin(auth)) {
            throw new ForbiddenException();
        }

        if (auth != null) {
            logger.debug("authenticated admin access for: " + auth.getUser().getUsername());
        }

        Cors.add(request).allowedOrigins("*").allowedMethods("GET", "PUT", "POST", "DELETE").auth()
                .build(response);

        ServerInfoAdminResource adminResource = new ServerInfoAdminResource();
        ResteasyProviderFactory.getInstance().injectProperties(adminResource);
        return adminResource;
    }

    protected boolean isAdmin(AdminAuth auth) {
        OrganizationManager organizationManager = new OrganizationManager(session);
        if (auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization())) {
            if (auth.hasOneOfOrganizationRole(AdminRoles.ADMIN, AdminRoles.CREATE_ORGANIZATION)) {
                return true;
            }
            return false;
        }
        return false;
    }

    protected void handlePreflightRequest() {
        if (request.getHttpMethod().equalsIgnoreCase("OPTIONS")) {
            logger.debug("Cors admin pre-flight");
            Response response = Cors.add(request, Response.ok()).preflight()
                    .allowedMethods("GET", "PUT", "POST", "DELETE").auth().build();
            throw new NoLogWebApplicationException(response);
        }
    }

    @Path("commons")
    public CommonsAdminResource getCommonsResource(@Context final HttpHeaders headers) {
        handlePreflightRequest();

        AdminAuth auth = authenticateOrganizationAdminRequest(headers);
        if (auth != null) {
            logger.debug("authenticated admin access for: " + auth.getUser().getUsername());
        }

        Cors.add(request).allowedOrigins("*").allowedMethods("GET", "PUT", "POST", "DELETE")
                .exposedHeaders("Location").auth().build(response);

        CommonsAdminResource commonsResource = new CommonsAdminResource(auth);
        ResteasyProviderFactory.getInstance().injectProperties(commonsResource);
        return commonsResource;
    }

}

/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.services.resources.admin;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.AdminRoles;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.AuthzManager;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.OpenfactApplication;

public class OrganizationsAdminResource {

    public static final String SCOPE_ORGANIZATION_VIEW = "urn:openfact.com:scopes:admin:organization:view";
    public static final String SCOPE_ORGANIZATION_MANAGE = "urn:openfact.com:scopes:admin:organization:manage";
    public static final String SCOPE_ORGANIZATION_DELETE = "urn:openfact.com:scopes:admin:organization:delete";

    public static final CacheControl noCache = new CacheControl();

    protected static final Logger logger = Logger.getLogger(OrganizationsAdminResource.class);

    static {
        noCache.setNoCache(true);
    }

    protected AdminAuth auth;

    @Context
    protected OpenfactSession session;

    @Context
    protected OpenfactApplication openfact;

    @Context
    protected ClientConnection clientConnection;

    public OrganizationsAdminResource(AdminAuth auth) {
        this.auth = auth;
    }

    /**
     * Create a new organization.
     *
     * @param rep The representation of the organization that will be created
     * @return The organization created on Response format
     * @summary Create a new organization
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response importOrganization(@Context final UriInfo uriInfo,
                                       @Valid final OrganizationRepresentation rep) {
        OrganizationManager organizationManager = new OrganizationManager(session);
        organizationManager.setContextPath(openfact.getContextPath());
        if (!auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization())) {
            throw new ForbiddenException();
        }
        if (!auth.hasOrganizationRole(AdminRoles.ADMIN)) {
            throw new ForbiddenException();
        }

        logger.debugv("importOrganization: {0}", rep.getOrganization());

        try {
            OrganizationModel organization = organizationManager.importOrganization(rep);

            URI location = AdminRoot.organizationsUrl(uriInfo).path(organization.getName()).build();
            logger.debugv("imported organization success, sending back: {0}", location.toString());

            return Response.created(location).build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Organization with same name exists");
        }
    }

    /**
     * Get all organizations.
     *
     * @return All organizations
     * @summary Get all organizations
     */
    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrganizationRepresentation> getOrganizations() {
        OrganizationManager organizationManager = new OrganizationManager(session);
        List<OrganizationRepresentation> reps = new ArrayList<>();

        if (auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization())) {
            List<OrganizationModel> organizations = session.organizations().getOrganizations();
            for (OrganizationModel organization : organizations) {
                addOrganizationRep(reps, organization);
            }
        } else {
            addOrganizationRep(reps, auth.getOrganization());
        }

        if (reps.isEmpty()) {
            throw new ForbiddenException();
        }

        logger.debug(("getOrganizations()"));
        return reps;
    }

    protected void addOrganizationRep(List<OrganizationRepresentation> reps, OrganizationModel organization) {
        if (auth.hasAppRole(AdminRoles.VIEW_ORGANIZATION)) {
            reps.add(ModelToRepresentation.toRepresentation(organization, false));
        } else if (auth.hasOneOfAppRole(AdminRoles.ALL_ORGANIZATION_ROLES)) {
            OrganizationRepresentation rep = new OrganizationRepresentation();
            rep.setOrganization(organization.getName());
            reps.add(rep);
        }
    }

    /**
     * @param organization The organization name
     */
    @Path("{organization}")
    public OrganizationAdminResource getOrganizationAdmin(@Context final HttpHeaders headers,
                                                          @PathParam("organization") final String name) {
        OrganizationManager organizationManager = new OrganizationManager(session);
        OrganizationModel organization = organizationManager.getOrganizationByName(name);
        if (organization == null)
            throw new NotFoundException("Organization not found.");

        if (!auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization()) && !auth.getOrganization().equals(organization)) {
            throw new ForbiddenException();
        }

        OrganizationAuth organizationAuth = new OrganizationAuth(auth);

        AdminEventBuilder adminEvent = new AdminEventBuilder(organization, auth, session, clientConnection);
        session.getContext().setOrganization(organization);

        OrganizationAdminResource adminResource = new OrganizationAdminResource(organizationAuth, organization, adminEvent);
        ResteasyProviderFactory.getInstance().injectProperties(adminResource);
        // resourceContext.initResource(adminResource);
        return adminResource;
    }

}

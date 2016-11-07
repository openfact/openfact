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
import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.AdminRoles;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.OpenfactApplication;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizationsAdminResource {

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
     * @param rep
     *            The representation of the organization that will be created
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
        if (!auth.hasOrganizationRole(AdminRoles.CREATE_ORGANIZATION)) {
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
    public List<OrganizationRepresentation> getOrganizations(@QueryParam("filterText") String filterText,
                                                             @QueryParam("organization") String organizationName,
                                                             @QueryParam("supplierName") String supplierName,
                                                             @QueryParam("registrationName") String registrationName, @QueryParam("first") Integer firstResult,
                                                             @QueryParam("max") Integer maxResults) {

        OrganizationManager organizationManager = new OrganizationManager(session);
        List<OrganizationRepresentation> reps = new ArrayList<>();

        if (auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization())) {
            firstResult = firstResult != null ? firstResult : -1;
            maxResults = maxResults != null ? maxResults : -1;

            List<OrganizationModel> organizations;
            if (filterText != null) {
                organizations = session.organizations().searchForOrganization(filterText.trim(), firstResult,
                        maxResults);
            } else if (organizationName != null || supplierName != null || registrationName != null) {
                Map<String, String> attributes = new HashMap<String, String>();
                if (organizationName != null) {
                    attributes.put(OrganizationModel.NAME, organizationName);
                }
                if (supplierName != null) {
                    attributes.put(OrganizationModel.SUPPLIER_NAME, supplierName);
                }
                if (registrationName != null) {
                    attributes.put(OrganizationModel.REGISTRATION_NAME, registrationName);
                }
                organizations = session.organizations().searchForOrganization(attributes, firstResult,
                        maxResults);
            } else {
                organizations = session.organizations().getOrganizations(firstResult, maxResults);
            }

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

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public SearchResultsRepresentation<OrganizationRepresentation> searchOrganizations(
            @Valid final SearchCriteriaRepresentation criteria) {
        OrganizationManager organizationManager = new OrganizationManager(session);
        if (auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization())) {
            SearchCriteriaModel criteriaModel = RepresentationToModel.toModel(criteria);

            String filterText = criteria.getFilterText();
            SearchResultsModel<OrganizationModel> results = null;
            if (filterText != null) {
                results = session.organizations().searchForOrganization(criteriaModel, filterText);
            } else {
                results = session.organizations().searchForOrganization(criteriaModel);
            }
            SearchResultsRepresentation<OrganizationRepresentation> rep = new SearchResultsRepresentation<>();
            List<OrganizationRepresentation> items = new ArrayList<>();
            results.getModels().forEach(f -> items.add(ModelToRepresentation.toRepresentation(f, true)));
            rep.setItems(items);
            rep.setTotalSize(results.getTotalSize());

            logger.debug(("searchOrganizations()"));
            return rep;
        } else {
            throw new ForbiddenException();
        }
    }

    /**
     * @param organization
     *            The organization name
     */
    @Path("{organization}")
    public OrganizationAdminResource getOrganizationAdmin(@Context final HttpHeaders headers,
                                                          @PathParam("organization") final String name) {
        OrganizationManager organizationManager = new OrganizationManager(session);
        OrganizationModel organization = organizationManager.getOrganizationByName(name);
        if (organization == null)
            throw new NotFoundException("Organization not found.");

        if (!auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization())
                && !auth.getOrganization().equals(organization)) {
            throw new ForbiddenException();
        }

        OrganizationAuth organizationAuth = new OrganizationAuth(auth);

        AdminEventBuilder adminEvent = new AdminEventBuilder(organization, auth, session, clientConnection);
        session.getContext().setOrganization(organization);

        OrganizationAdminResource adminResource = new OrganizationAdminResource(organizationAuth,
                organization, adminEvent);
        ResteasyProviderFactory.getInstance().injectProperties(adminResource);
        // resourceContext.initResource(adminResource);
        return adminResource;
    }

}

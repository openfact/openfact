package org.openfact.services.resources.admin;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
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

public class OrganizationsAdminResourceImpl implements OrganizationsAdminResource {

    protected static final Logger logger = Logger.getLogger(OrganizationsAdminResourceImpl.class);

    protected AdminAuth auth;

    @Context
    protected OpenfactSession session;

    @Context
    protected OpenfactApplication openfact;

    @Context
    protected ClientConnection clientConnection;

    public OrganizationsAdminResourceImpl(AdminAuth auth) {
        this.auth = auth;
    }

    public static final CacheControl noCache = new CacheControl();

    static {
        noCache.setNoCache(true);
    }

    @Override
    public Response importOrganization(UriInfo uriInfo, OrganizationRepresentation rep) {
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

            URI location = AdminRootImpl.organizationsUrl(uriInfo).path(organization.getName()).build();
            logger.debugv("imported organization success, sending back: {0}", location.toString());

            return Response.created(location).build();
        } catch (ModelDuplicateException e) {
            return ErrorResponse.exists("Organization with same name exists");
        }
    }

    @Override
    public List<OrganizationRepresentation> getOrganizations(String filterText, String organizationName,
            String supplierName, String registrationName, Integer firstResult, Integer maxResults) {

        OrganizationManager organizationManager = new OrganizationManager(session);
        List<OrganizationRepresentation> reps = new ArrayList<>();

        if (auth.getOrganization().equals(organizationManager.getOpenfactAdminstrationOrganization())) {
            firstResult = firstResult != null ? firstResult : -1;
            maxResults = maxResults != null ? maxResults : -1;

            List<OrganizationModel> organizations;
            if (filterText != null) {
                organizations = session.organizations().searchForOrganization(filterText.trim(), firstResult, maxResults);
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

    @Override
    public SearchResultsRepresentation<OrganizationRepresentation> searchOrganizations(SearchCriteriaRepresentation criteria) {
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

    @Override
    public OrganizationAdminResource getOrganizationAdmin(HttpHeaders headers, String name) {
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

        OrganizationAdminResource adminResource = new OrganizationAdminResourceImpl(organizationAuth, organization, adminEvent);
        ResteasyProviderFactory.getInstance().injectProperties(adminResource);
        // resourceContext.initResource(adminResource);
        return adminResource;
    }

}

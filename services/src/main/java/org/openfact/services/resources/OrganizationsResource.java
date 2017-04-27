package org.openfact.services.resources;

import org.jboss.resteasy.spi.HttpRequest;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.representations.idm.PublishedOrganizationRepresentation;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resource.OrganizationResourceProvider;

import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.Iterator;

@Stateless
@Path("/organizations")
public class OrganizationsResource {

    @Context
    private HttpRequest request;

    @Context
    private UriInfo uriInfo;

    @Context
    private OpenfactSession session;

    @Inject
    private OrganizationManager organizationManager;

    @Inject
    @Any
    private Instance<OrganizationResourceProvider> organizationResourceProviders;

    private OrganizationModel init(String organizationName) {
        OrganizationModel organization = organizationManager.getOrganizationByName(organizationName);
        if (organization == null) {
            throw new NotFoundException("Organization does not exist");
        }
        session.getContext().setOrganization(organization);
        return organization;
    }

    @GET
    @Path("/{organization}")
    @Produces(MediaType.APPLICATION_JSON)
    public PublishedOrganizationRepresentation getOrganization(final @PathParam("organization") String name) {
        OrganizationModel organization = init(name);
        return organizationRep(organization, uriInfo);
    }

    public static PublishedOrganizationRepresentation organizationRep(OrganizationModel organization, UriInfo uriInfo) {
        PublishedOrganizationRepresentation rep = new PublishedOrganizationRepresentation();
        rep.setOrganization(organization.getName());
        return rep;
    }

    /**
     * A JAX-RS sub-resource locator that uses the
     * {@link org.openfact.services.resource.OrganizationResourceProvider} to resolve
     * sub-resources instances given an <code>unknownPath</code>.
     *
     * @param extension a path that could be to a REST extension
     * @return a JAX-RS sub-resource instance for the REST extension if found.
     * Otherwise null is returned.
     */
    @Path("{organization}/{extension}")
    public Object resolveOrganizationExtension(@PathParam("organization") String organizationName,
                                               @PathParam("extension") String extension) {

        Iterator<OrganizationResourceProvider> iterator = organizationResourceProviders.iterator();
        while (iterator.hasNext()) {
            OrganizationResourceProvider provider = iterator.next();
            if (provider.getPath().equals(extension)) {
                init(organizationName);
                Object resource = provider.getResource();
                if (resource != null) {
                    return resource;
                }
            }
        }

        throw new NotFoundException();
    }

}

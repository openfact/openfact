package org.openfact.services.resources;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resource.OrganizationResourceProvider;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Path("/organizations")
public class OrganizationsResource {

    @Context
    protected OpenfactSession session;

    @Context
    protected ClientConnection clientConnection;

    @Context
    private HttpRequest request;

    @Context
    private UriInfo uriInfo;

    public static UriBuilder organizationBaseUrl(UriInfo uriInfo) {
        UriBuilder baseUriBuilder = uriInfo.getBaseUriBuilder();
        return organizationBaseUrl(baseUriBuilder);
    }

    public static UriBuilder organizationBaseUrl(UriBuilder baseUriBuilder) {
        return baseUriBuilder.path(OrganizationsResource.class).path(OrganizationsResource.class,
                "getOrganizationResource");
    }

    public static UriBuilder accountUrl(UriBuilder base) {
        return base.path(OrganizationsResource.class).path(OrganizationsResource.class, "getAccountService");
    }

    public static UriBuilder protocolUrl(UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder().path(OrganizationsResource.class).path(OrganizationsResource.class,
                "getProtocol");
    }

    public static UriBuilder protocolUrl(UriBuilder builder) {
        return builder.path(OrganizationsResource.class).path(OrganizationsResource.class, "getProtocol");
    }

    public static UriBuilder clientRegistrationUrl(UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder().path(OrganizationsResource.class).path(OrganizationsResource.class,
                "getClientsService");
    }

    public static UriBuilder brokerUrl(UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder().path(OrganizationsResource.class).path(OrganizationsResource.class,
                "getBrokerService");
    }

    public static UriBuilder wellKnownProviderUrl(UriBuilder builder) {
        return builder.path(OrganizationsResource.class).path(OrganizationsResource.class, "getWellKnown");
    }

    @Path("{organization}")
    public PublicOrganizationResource getOrganizationResource(final @PathParam("organization") String name) {
        OrganizationModel organization = init(name);
        PublicOrganizationResource organizationResource = new PublicOrganizationResource(organization);
        ResteasyProviderFactory.getInstance().injectProperties(organizationResource);
        return organizationResource;
    }

    private OrganizationModel init(String organizationName) {
        OrganizationManager organizationManager = new OrganizationManager(session);
        OrganizationModel organization = organizationManager.getOrganizationByName(organizationName);
        if (organization == null) {
            throw new NotFoundException("Organization does not exist");
        }
        session.getContext().setOrganization(organization);
        return organization;
    }

    /**
     * A JAX-RS sub-resource locator that uses the
     * {@link org.openfact.services.resource.OrganizationResourceSPI} to resolve
     * sub-resources instances given an <code>unknownPath</code>.
     *
     * @param extension
     *            a path that could be to a REST extension
     * @return a JAX-RS sub-resource instance for the REST extension if found.
     *         Otherwise null is returned.
     */
    @Path("{organization}/{extension}")
    public Object resolveOrganizationExtension(@PathParam("organization") String organizationName,
            @PathParam("extension") String extension) {
        OrganizationResourceProvider provider = session.getProvider(OrganizationResourceProvider.class,
                extension);
        if (provider != null) {
            init(organizationName);
            Object resource = provider.getResource();
            if (resource != null) {
                return resource;
            }
        }

        throw new NotFoundException();
    }

}

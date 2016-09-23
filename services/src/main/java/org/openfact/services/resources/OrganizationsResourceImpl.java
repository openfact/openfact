package org.openfact.services.resources;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.models.OrganizationModel;
import org.openfact.common.ClientConnection;
import org.openfact.models.OpenfactSession;
import org.openfact.services.managers.OrganizationManager;
import org.openfact.services.resources.OrganizationsResource;
import org.openfact.services.resources.PublicOrganizationResource;
import org.jboss.resteasy.spi.HttpRequest;

public class OrganizationsResourceImpl implements OrganizationsResource {

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
        return baseUriBuilder.path(OrganizationsResource.class).path(OrganizationsResource.class, "getOrganizationResource");
    }

    public static UriBuilder accountUrl(UriBuilder base) {
        return base.path(OrganizationsResource.class).path(OrganizationsResource.class, "getAccountService");
    }

    public static UriBuilder protocolUrl(UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder().path(OrganizationsResource.class).path(OrganizationsResource.class, "getProtocol");
    }

    public static UriBuilder protocolUrl(UriBuilder builder) {
        return builder.path(OrganizationsResource.class).path(OrganizationsResource.class, "getProtocol");
    }

    public static UriBuilder clientRegistrationUrl(UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder().path(OrganizationsResource.class).path(OrganizationsResource.class, "getClientsService");
    }

    public static UriBuilder brokerUrl(UriInfo uriInfo) {
        return uriInfo.getBaseUriBuilder().path(OrganizationsResource.class).path(OrganizationsResource.class, "getBrokerService");
    }

    public static UriBuilder wellKnownProviderUrl(UriBuilder builder) {
        return builder.path(OrganizationsResource.class).path(OrganizationsResource.class, "getWellKnown");
    }
    
	@Override
	public PublicOrganizationResource getOrganizationResource(String name) {
		OrganizationModel organization = init(name);
		PublicOrganizationResource organizationResource = new PublicOrganizationResourceImpl(organization);
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

}

package org.openfact.services.resources.admin;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelReadOnlyException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.catalog.CodeCatalogRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.OrganizationManager;

public class CodeCatalogAdminResourceImpl implements CodeCatalogAdminResource {

	protected static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

	protected OrganizationAuth auth;
	protected OrganizationModel organization;
	private AdminEventBuilder adminEvent;

	@Context
	protected OpenfactSession session;

	@Context
	protected UriInfo uriInfo;

	@Context
	protected ClientConnection connection;

	@Context
	protected HttpHeaders headers;

	public CodeCatalogAdminResourceImpl(OrganizationAuth auth, OrganizationModel organization, AdminEventBuilder adminEvent) {
		this.auth = auth;
		this.organization = organization;
		this.adminEvent = adminEvent.organization(organization);

		auth.init(OrganizationAuth.Resource.REALM);
		auth.requireAny();
	}

    @Override
    public CodeCatalogRepresentation getCodeCatalog() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response updateCodeCatalog(CodeCatalogRepresentation rep) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response deleteCodeCatalog() {
        // TODO Auto-generated method stub
        return null;
    }

	

}

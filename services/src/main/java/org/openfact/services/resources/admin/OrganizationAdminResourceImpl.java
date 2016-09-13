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
import org.openfact.representations.idm.CurrencyRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.OrganizationManager;

public class OrganizationAdminResourceImpl implements OrganizationAdminResource {

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

	public OrganizationAdminResourceImpl(OrganizationAuth auth, OrganizationModel organization, AdminEventBuilder adminEvent) {
		this.auth = auth;
		this.organization = organization;
		this.adminEvent = adminEvent.organization(organization);

		auth.init(OrganizationAuth.Resource.REALM);
		auth.requireAny();
	}

	@Override
	public OrganizationRepresentation getOrganization() {
		if (auth.hasView()) {
			return ModelToRepresentation.toRepresentation(organization, true);
		} else {
			auth.requireAny();

			OrganizationRepresentation rep = new OrganizationRepresentation();
			rep.setName(organization.getName());
			return rep;
		}
	}

	@Override
	public Response updateOrganization(OrganizationRepresentation rep) {
		auth.requireManage();
		logger.debug("updating organization: " + organization.getName());
		try {
			RepresentationToModel.updateOrganization(rep, organization);
			return Response.noContent().build();
		} catch (ModelDuplicateException e) {
			return ErrorResponse.exists("Organization with same name exists");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ErrorResponse.error("Failed to update organization", Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<CurrencyRepresentation> getCurrencies() {
		auth.requireView();

		return organization.getCurrencies().stream().map(f -> ModelToRepresentation.toRepresentation(f))
				.collect(Collectors.toList());
	}

	@Override
	public Response deleteOrganization() {
		auth.requireManage();

		if (organization == null) {
			throw new NotFoundException("Organization not found");
		}

		try {
			OrganizationManager manager = new OrganizationManager(session);
			if (organization.equals(manager.getOpenfactAdminstrationOrganization())) {
				throw new ModelReadOnlyException();
			}

			boolean removed = manager.removeOrganization(organization);
			if (removed) {
				return Response.noContent().build();
			} else {
				return ErrorResponse.error("Organization couldn't be deleted", Response.Status.BAD_REQUEST);
			}
		} catch (ModelReadOnlyException e) {
			return ErrorResponse.exists("Organization " + organization.getName() + " could not be deleted");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ErrorResponse.error("Failed to delete organization", Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public DocumentsAdminResource documents() {
		DocumentsAdminResource documents = new DocumentsAdminResourceImpl(organization, auth);
		ResteasyProviderFactory.getInstance().injectProperties(documents);
		// resourceContext.initResource(invoices);
		return documents;
	}

	@Override
	public InvoicesAdminResource invoices() {
		InvoicesAdminResource invoices = new InvoicesAdminResourceImpl(organization, auth);
		ResteasyProviderFactory.getInstance().injectProperties(invoices);
		// resourceContext.initResource(invoices);
		return invoices;
	}
	
    @Override
    public org.openfact.services.resources.admin.ubl.InvoicesAdminResource invoicesUbl() {
        org.openfact.services.resources.admin.ubl.InvoicesAdminResource invoices = new org.openfact.services.resources.admin.ubl.InvoicesAdminResourceImpl(organization, auth, adminEvent);
        ResteasyProviderFactory.getInstance().injectProperties(invoices);
        // resourceContext.initResource(invoices);
        return invoices;
    }

	@Override
	public CertificatesAdminResource certificates() {
		CertificatesAdminResource certificate = new CertificatesAdminResourceImpl(organization, auth, adminEvent);
		ResteasyProviderFactory.getInstance().injectProperties(certificate);
		// resourceContext.initResource(certificate);
		return certificate;
	}   

}

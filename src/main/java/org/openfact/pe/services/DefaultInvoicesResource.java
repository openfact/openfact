package org.openfact.pe.services;

import org.jboss.logging.Logger;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.core.security.ISecurityContext;
import org.openfact.core.models.PermissionType;
import org.openfact.pe.InvoicesResource;
import org.openfact.pe.managers.TypeManager;
import org.openfact.pe.models.InvoiceModel;
import org.openfact.pe.models.InvoiceProvider;
import org.openfact.pe.models.utils.ModelToRepresentation;
import org.openfact.pe.representations.idm.InvoiceRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class DefaultInvoicesResource implements InvoicesResource {

    private static final Logger logger = Logger.getLogger(DefaultInvoicesResource.class);

    @Inject
    private ISecurityContext securityContext;

    @Inject
    private TypeManager typeManager;

    @Inject
    private InvoiceProvider invoiceProvider;

    @Inject
    private ResourceManager resourceManager;

    @Inject
    private OrganizationProvider organizationProvider;

    @Override
    public List<InvoiceRepresentation> getInvoices(String organizationId, String filterText, int offset, int limit) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(NotFoundException::new);
        return invoiceProvider.buscarInvoice(organization, filterText, offset, limit)
                .stream()
                .map(f -> ModelToRepresentation.toRepresentation(f, true))
                .collect(Collectors.toList());
    }

    @Override
    public InvoiceRepresentation crearInvoice(String organizationId, Boolean async, InvoiceRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        InvoiceModel invoice = resourceManager.crearInvoice(organizationId, rep);
        Future<InvoiceModel> future = typeManager.buildInvoice(invoice.getId());
        if (!async) {
            try {
                invoice = future.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e);
            }
        }

        return ModelToRepresentation.toRepresentation(invoice, true);
    }

    @Override
    public InvoiceRepresentation getInvoice(String organizationId, String invoiceId) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(NotFoundException::new);
        InvoiceModel invoice = invoiceProvider.getInvoice(organization, invoiceId).orElseThrow(NotFoundException::new);
        return ModelToRepresentation.toRepresentation(invoice, true);
    }

    @Override
    public InvoiceRepresentation actualizarInvoice(String organizationId, String invoiceId, Boolean async, InvoiceRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        InvoiceModel invoice = resourceManager.actualizarInvoice(organizationId, invoiceId, rep);
        Future<InvoiceModel> future = typeManager.buildInvoice(invoice.getId());
        if (!async) {
            try {
                invoice = future.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e);
            }
        }

        return ModelToRepresentation.toRepresentation(invoice, true);
    }

    @Override
    public void eliminarInvoice(String organizationId, String idDocumento) {
        throw new ForbiddenException();
    }

}

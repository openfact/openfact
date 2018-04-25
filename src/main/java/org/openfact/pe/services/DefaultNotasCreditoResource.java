package org.openfact.pe.services;

import org.jboss.logging.Logger;
import org.openfact.core.models.OrganizationModel;
import org.openfact.core.security.ISecurityContext;
import org.openfact.core.security.PermissionType;
import org.openfact.pe.NotasCreditoResource;
import org.openfact.pe.managers.TypeManager;
import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.NotaCreditoModel;
import org.openfact.pe.models.NotaCreditoProvider;
import org.openfact.pe.models.utils.ModelToRepresentation;
import org.openfact.pe.models.utils.RepresentationToModel;
import org.openfact.pe.representations.idm.NotaCreditoRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class DefaultNotasCreditoResource implements NotasCreditoResource {

    private static final Logger logger = Logger.getLogger(DefaultNotasCreditoResource.class);

    @Inject
    private ISecurityContext securityContext;

    @Inject
    private TypeManager typeManager;

    @Inject
    private NotaCreditoProvider notaCreditoProvider;

    @Inject
    private ResourceManager resourceManager;

    @Override
    public List<NotaCreditoRepresentation> getNotasCredito(String organizationId, String estado, int offset, int limit) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        EstadoComprobantePago estadoComprobantePago = EstadoComprobantePago.valueOf(estado.toUpperCase());
        return notaCreditoProvider.getNotasCredito(organizationId, estadoComprobantePago, offset, limit).stream()
                .map(f -> ModelToRepresentation.toRepresentation(f, true))
                .collect(Collectors.toList());
    }

    @Override
    public NotaCreditoRepresentation crearNotaCredito(String organizationId, Boolean async, NotaCreditoRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        NotaCreditoModel notaCredito = resourceManager.crearNotaCredito(organizationId, rep);
        Future<NotaCreditoModel> futureNotaCredito = typeManager.buildNotaCredito(notaCredito.getId());
        if (!async) {
            try {
                notaCredito = futureNotaCredito.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e);
            }
        }

        return ModelToRepresentation.toRepresentation(notaCredito, true);
    }

    @Override
    public NotaCreditoRepresentation getNotaCredito(String organizationId, String idDocumento) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        NotaCreditoModel factura = notaCreditoProvider.getNotaCredito(idDocumento, organizationId).orElseThrow(() -> new NotFoundException("Nota crédito no encontrada"));
        return ModelToRepresentation.toRepresentation(factura, true);
    }

    @Override
    public NotaCreditoRepresentation actualizarNotaCredito(String organizationId, String idDocumento, Boolean async, NotaCreditoRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        NotaCreditoModel notaCredito = resourceManager.actualizarNotaCredito(organizationId, idDocumento, rep);
        Future<NotaCreditoModel> futureNotaCredito = typeManager.buildNotaCredito(notaCredito.getId());
        if (!async) {
            try {
                notaCredito = futureNotaCredito.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e);
            }
        }

        return ModelToRepresentation.toRepresentation(notaCredito, true);
    }

    @Override
    public void eliminarNotaCredito(String organizationId, String idDocumento) {
        throw new ForbiddenException();
    }

}

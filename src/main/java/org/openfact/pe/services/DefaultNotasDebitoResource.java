package org.openfact.pe.services;

import org.jboss.logging.Logger;
import org.openfact.core.security.ISecurityContext;
import org.openfact.core.security.PermissionType;
import org.openfact.pe.NotasDebitoResource;
import org.openfact.pe.managers.TypeManager;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.NotaDebitoModel;
import org.openfact.pe.models.NotaDebitoProvider;
import org.openfact.pe.models.utils.ModelToRepresentation;
import org.openfact.pe.representations.idm.NotaDebitoRepresentation;

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
public class DefaultNotasDebitoResource implements NotasDebitoResource {

    private static final Logger logger = Logger.getLogger(DefaultNotasDebitoResource.class);

    @Inject
    private ISecurityContext securityContext;

    @Inject
    private TypeManager typeManager;

    @Inject
    private NotaDebitoProvider notaDebitoProvider;

    @Inject
    private ResourceManager resourceManager;

    @Override
    public List<NotaDebitoRepresentation> getNotasDebito(String organizationId, String estado, int offset, int limit) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        EstadoComprobantePago estadoComprobantePago = EstadoComprobantePago.valueOf(estado.toUpperCase());
        return notaDebitoProvider.getNotasDebito(organizationId, estadoComprobantePago, offset, limit).stream()
                .map(f -> ModelToRepresentation.toRepresentation(f, true))
                .collect(Collectors.toList());
    }

    @Override
    public NotaDebitoRepresentation crearNotaDebito(String organizationId, Boolean async, NotaDebitoRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        NotaDebitoModel notaDebito = resourceManager.crearNotaDebito(organizationId, rep);
        Future<NotaDebitoModel> futureNotaDebito = typeManager.buildNotaDebito(notaDebito.getId());
        if (!async) {
            try {
                notaDebito = futureNotaDebito.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e);
            }
        }

        return ModelToRepresentation.toRepresentation(notaDebito, true);
    }

    @Override
    public NotaDebitoRepresentation getNotaDebito(String organizationId, String idDocumento) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        NotaDebitoModel factura = notaDebitoProvider.getNotaDebito(idDocumento, organizationId).orElseThrow(() -> new NotFoundException("Nota crédito no encontrada"));
        return ModelToRepresentation.toRepresentation(factura, true);
    }

    @Override
    public NotaDebitoRepresentation actualizarNotaDebito(String organizationId, String idDocumento, Boolean async, NotaDebitoRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        NotaDebitoModel notaDebito = resourceManager.actualizarNotaDebito(organizationId, idDocumento, rep);
        Future<NotaDebitoModel> futureNotaDebito = typeManager.buildNotaDebito(notaDebito.getId());
        if (!async) {
            try {
                notaDebito = futureNotaDebito.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e);
            }
        }

        return ModelToRepresentation.toRepresentation(notaDebito, true);
    }

    @Override
    public void eliminarNotaDebito(String organizationId, String idDocumento) {
        throw new ForbiddenException();
    }

}

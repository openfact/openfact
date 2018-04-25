package org.openfact.pe.services;

import org.jboss.logging.Logger;
import org.openfact.core.security.ISecurityContext;
import org.openfact.core.security.PermissionType;
import org.openfact.pe.BoletasResource;
import org.openfact.pe.managers.TypeManager;
import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.BoletaProvider;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.utils.ModelToRepresentation;
import org.openfact.pe.representations.idm.BoletaRepresentation;

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
public class DefaultBoletasResource implements BoletasResource {

    private static final Logger logger = Logger.getLogger(DefaultBoletasResource.class);

    @Inject
    private ISecurityContext securityContext;

    @Inject
    private TypeManager typeManager;

    @Inject
    private BoletaProvider boletaProvider;

    @Inject
    private ResourceManager resourceManager;

    @Override
    public List<BoletaRepresentation> getBoletas(String organizationId, String estado, int offset, int limit) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        EstadoComprobantePago estadoComprobantePago = EstadoComprobantePago.valueOf(estado.toUpperCase());
        return boletaProvider.getBoletas(organizationId, estadoComprobantePago, offset, limit)
                .stream()
                .map(f -> ModelToRepresentation.toRepresentation(f, true))
                .collect(Collectors.toList());
    }

    @Override
    public BoletaRepresentation crearBoleta(String organizationId, Boolean async, BoletaRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        BoletaModel boleta = resourceManager.crearBoleta(organizationId, rep);
        Future<BoletaModel> futureBoleta = typeManager.buildBoleta(boleta.getId());
        if (!async) {
            try {
                boleta = futureBoleta.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e);
            }
        }

        return ModelToRepresentation.toRepresentation(boleta, true);
    }

    @Override
    public BoletaRepresentation getBoleta(String organizationId, String idDocumento) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        BoletaModel boleta = boletaProvider.getBoleta(idDocumento, organizationId).orElseThrow(() -> new NotFoundException("Boleta o Factura no encontrada"));
        return ModelToRepresentation.toRepresentation(boleta, true);
    }

    @Override
    public BoletaRepresentation actualizarBoleta(String organizationId, String idDocumento, Boolean async, BoletaRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        BoletaModel boleta = resourceManager.actualizarBoleta(organizationId, idDocumento, rep);
        Future<BoletaModel> futureBoleta = typeManager.buildBoleta(boleta.getId());
        if (!async) {
            try {
                boleta = futureBoleta.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e);
            }
        }

        return ModelToRepresentation.toRepresentation(boleta, true);
    }

    @Override
    public void eliminarBoleta(String organizationId, String idDocumento) {
        throw new ForbiddenException();
    }

}

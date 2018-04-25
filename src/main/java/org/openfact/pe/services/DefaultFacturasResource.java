package org.openfact.pe.services;

import org.jboss.logging.Logger;
import org.openfact.core.security.ISecurityContext;
import org.openfact.core.security.PermissionType;
import org.openfact.pe.FacturasResource;
import org.openfact.pe.managers.TypeManager;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.FacturaProvider;
import org.openfact.pe.models.utils.ModelToRepresentation;
import org.openfact.pe.representations.idm.FacturaRepresentation;

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
public class DefaultFacturasResource implements FacturasResource {

    private static final Logger logger = Logger.getLogger(DefaultFacturasResource.class);

    @Inject
    private ISecurityContext securityContext;

    @Inject
    private TypeManager typeManager;

    @Inject
    private FacturaProvider facturaProvider;

    @Inject
    private ResourceManager resourceManager;

    @Override
    public List<FacturaRepresentation> getFacturas(String organizationId, String estado, int offset, int limit) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        EstadoComprobantePago estadoComprobantePago = EstadoComprobantePago.valueOf(estado.toUpperCase());
        return facturaProvider.getFacturas(organizationId, estadoComprobantePago, offset, limit).stream()
                .map(f -> ModelToRepresentation.toRepresentation(f, true))
                .collect(Collectors.toList());
    }

    @Override
    public FacturaRepresentation crearFactura(String organizationId, Boolean async, FacturaRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        FacturaModel factura = resourceManager.crearFactura(organizationId, rep);
        Future<FacturaModel> futureFactura = typeManager.buildFactura(factura.getId());
        if (!async) {
            try {
                factura = futureFactura.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e);
            }
        }

        return ModelToRepresentation.toRepresentation(factura, true);
    }

    @Override
    public FacturaRepresentation getFactura(String organizationId, String idDocumento) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        FacturaModel factura = facturaProvider.getFactura(idDocumento, organizationId).orElseThrow(() -> new NotFoundException("Boleta o Factura no encontrada"));
        return ModelToRepresentation.toRepresentation(factura, true);
    }

    @Override
    public FacturaRepresentation actualizarFactura(String organizationId, String idDocumento, Boolean async, FacturaRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        FacturaModel factura = resourceManager.actualizarFactura(organizationId, idDocumento, rep);
        Future<FacturaModel> futureFactura = typeManager.buildFactura(factura.getId());
        if (!async) {
            try {
                factura = futureFactura.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e);
            }
        }

        return ModelToRepresentation.toRepresentation(factura, true);
    }

    @Override
    public void eliminarFactura(String organizationId, String idDocumento) {
        throw new ForbiddenException();
    }

}

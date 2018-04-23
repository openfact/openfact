package org.openfact.pe.services;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.core.security.ISecurityContext;
import org.openfact.core.security.PermissionType;
import org.openfact.pe.FacturasResource;
import org.openfact.pe.representations.idm.FacturaRepresentation;
import org.openfact.pe.managers.TypeManager;
import org.openfact.pe.models.*;
import org.openfact.pe.models.utils.ModelToRepresentation;
import org.openfact.pe.models.utils.RepresentationToModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class DefaultFacturasResource implements FacturasResource {

    @Inject
    private ISecurityContext securityContext;

    @Inject
    private TypeManager typeManager;

    @Inject
    private FacturaProvider facturaProvider;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private ResourceManager resourceManager;

    @Override
    public List<FacturaRepresentation> getFacturas(String organizationId, String estado, int offset, int limit) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        EstadoComprobantePago estadoComprobantePago = EstadoComprobantePago.valueOf(estado.toUpperCase());
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        return facturaProvider.getFacturas(organization, estadoComprobantePago, offset, limit).stream()
                .map(f -> ModelToRepresentation.toRepresentation(f, true))
                .collect(Collectors.toList());
    }

    @Override
    public FacturaRepresentation crearFactura(String organizationId, FacturaRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        FacturaRepresentation result = resourceManager.crearFactura(organizationId, rep);
        typeManager.buildFactura(result.getId());
        return result;
    }

    @Override
    public FacturaRepresentation getFactura(String organizationId, String idDocumento) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        FacturaModel factura = facturaProvider.getFactura(idDocumento, organization).orElseThrow(() -> new NotFoundException("Boleta o Factura no encontrada"));
        return ModelToRepresentation.toRepresentation(factura, true);
    }

    @Override
    public void actualizarFactura(String organizationId, String idDocumento, FacturaRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        FacturaModel factura = facturaProvider.getFactura(idDocumento, organization).orElseThrow(() -> new NotFoundException("Factura no encontrada"));
        RepresentationToModel.modelToRepresentation(factura, rep);

        if (factura.getEstado().equals(EstadoComprobantePago.CERRADO)) {
            throw new BadRequestException("Comprobante ABIERTO o ya fue declarado a la SUNAT, no se puede eliminar");
        }

        // Recalcular XML
        typeManager.buildFactura(factura.getId());
    }

    @Override
    public void eliminarFactura(String organizationId, String idDocumento) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        FacturaModel factura = facturaProvider.getFactura(idDocumento, organization).orElseThrow(() -> new NotFoundException("Boleta o Factura no encontrada"));

        if (factura.getEstado().equals(EstadoComprobantePago.CERRADO)) {
            throw new BadRequestException("Comprobante ABIERTO o ya fue declarado a la SUNAT, no se puede eliminar");
        }

        boolean result = facturaProvider.remove(factura);
        if (!result) {
            throw new InternalServerErrorException("Error interno, no se pudo eliminar la Factura");
        }
    }

}

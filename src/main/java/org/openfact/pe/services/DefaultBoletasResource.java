package org.openfact.pe.services;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.core.security.ISecurityContext;
import org.openfact.core.security.PermissionType;
import org.openfact.pe.BoletasResource;
import org.openfact.pe.representations.idm.BoletaRepresentation;
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
public class DefaultBoletasResource implements BoletasResource {

    @Inject
    private ISecurityContext securityContext;

    @Inject
    private TypeManager typeManager;

    @Inject
    private BoletaProvider boletaProvider;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private ResourceManager resourceManager;

    @Override
    public List<BoletaRepresentation> getBoletas(String organizationId, String estado, int offset, int limit) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        EstadoComprobantePago estadoComprobantePago = EstadoComprobantePago.valueOf(estado.toUpperCase());

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));

        return boletaProvider.getBoletas(organization, estadoComprobantePago, offset, limit).stream()
                .map(f -> ModelToRepresentation.toRepresentation(f, true))
                .collect(Collectors.toList());
    }

    @Override
    public BoletaRepresentation crearBoleta(String organizationId, BoletaRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        BoletaRepresentation result = resourceManager.crearBoleta(organizationId, rep);
        typeManager.buildBoleta(result.getId());
        return result;
    }

    @Override
    public BoletaRepresentation getBoleta(String organizationId, String idDocumento) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_view, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        BoletaModel boleta = boletaProvider.getBoleta(idDocumento, organization).orElseThrow(() -> new NotFoundException("Boleta o Factura no encontrada"));
        return ModelToRepresentation.toRepresentation(boleta, true);
    }

    @Override
    public void actualizarBoleta(String organizationId, String idDocumento, BoletaRepresentation rep) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        BoletaModel boleta = boletaProvider.getBoleta(idDocumento, organization).orElseThrow(() -> new NotFoundException("Boleta o Factura no encontrada"));

        if (boleta.getEstado().equals(EstadoComprobantePago.CERRADO)) {
            throw new BadRequestException("Comprobante CERRADO o ya fue declarado a la SUNAT, no se puede eliminar");
        }

        RepresentationToModel.modelToRepresentation(boleta, rep);

        // Recalcular XML
        typeManager.buildBoleta(boleta.getId());
    }

    @Override
    public void eliminarBoleta(String organizationId, String idDocumento) {
        if (!securityContext.isAdmin() && !securityContext.hasPermission(PermissionType.document_manage, organizationId)) {
            throw new ForbiddenException();
        }

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        BoletaModel boleta = boletaProvider.getBoleta(idDocumento, organization).orElseThrow(() -> new NotFoundException("Boleta no encontrada"));

        if (boleta.getEstado().equals(EstadoComprobantePago.CERRADO)) {
            throw new BadRequestException("Comprobante ABIERTO o ya fue declarado a la SUNAT, no se puede eliminar");
        }

        boolean result = boletaProvider.remove(boleta);
        if (!result) {
            throw new InternalServerErrorException("Error interno, no se pudo eliminar la Boleta");
        }
    }

}

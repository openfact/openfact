package org.openfact.pe.services;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.pe.FacturasResource;
import org.openfact.pe.idm.FacturaRepresentation;
import org.openfact.pe.managers.TypeManager;
import org.openfact.pe.models.*;
import org.openfact.pe.models.utils.ModelToRepresentation;
import org.openfact.pe.models.utils.RepresentationToModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class DefaultFacturasResource implements FacturasResource {

    @Inject
    private TypeManager typeManager;

    @Inject
    private FacturaProvider facturaProvider;

    @Inject
    private OrganizationProvider organizationProvider;

    @Override
    public List<FacturaRepresentation> getFacturas(String organizationId, String estado, int offset, int limit) {
        EstadoComprobantePago estadoComprobantePago = EstadoComprobantePago.valueOf(estado.toUpperCase());

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));

        return facturaProvider.getFacturas(organization, estadoComprobantePago, offset, limit).stream()
                .map(f -> ModelToRepresentation.toRepresentation(f, true))
                .collect(Collectors.toList());
    }

    @Override
    public FacturaRepresentation crearFactura(String organizationId, FacturaRepresentation rep) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));

        String serie = rep.getSerie();
        Integer numero = rep.getNumero();

        FacturaModel factura;
        if (serie == null) {
            if (numero == null) {
                factura = facturaProvider.createFactura(organization);
            } else {
                throw new BadRequestException("Petición invalida: [serie=null, numero=not null]");
            }
        } else {
            if (numero == null) {
                factura = facturaProvider.createFactura(organization, serie);
            } else {
                factura = facturaProvider.createFactura(organization, serie, numero);
            }
        }

        // Datos por defecto si no son especificadas
        if (rep.getFecha() == null) {
            factura.getFecha().setEmision(Calendar.getInstance().getTime());
            factura.getFecha().setVencimiento(Calendar.getInstance().getTime());
        }
        if (rep.getEnviarSunat() == null) {
            factura.setEnviarSunat(true);
        }
        if (rep.getEnviarCliente() == null) {
            factura.setEnviarCliente(true);
        }

        // Merge
        RepresentationToModel.modelToRepresentation(factura, rep);

        // Recalcular XML
        typeManager.buildFactura(organization, factura);

        return ModelToRepresentation.toRepresentation(factura, true);
    }

    @Override
    public void actualizarFactura(String organizationId, String idDocumento, FacturaRepresentation rep) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        FacturaModel factura = facturaProvider.getFactura(organization, idDocumento).orElseThrow(() -> new NotFoundException("Factura no encontrada"));
        RepresentationToModel.modelToRepresentation(factura, rep);

        if (factura.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            throw new BadRequestException("Comprobante REGISTRADO o ya fue declarado a la SUNAT, no se puede eliminar");
        }

        // Recalcular XML
        typeManager.buildFactura(organization, factura);
    }

    @Override
    public void eliminarFactura(String organizationId, String idDocumento) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        FacturaModel factura = facturaProvider.getFactura(organization, idDocumento).orElseThrow(() -> new NotFoundException("Boleta o Factura no encontrada"));

        if (factura.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            throw new BadRequestException("Comprobante REGISTRADO o ya fue declarado a la SUNAT, no se puede eliminar");
        }

        boolean result = facturaProvider.remove(factura);
        if (!result) {
            throw new InternalServerErrorException("Error interno, no se pudo eliminar la Factura");
        }
    }

}

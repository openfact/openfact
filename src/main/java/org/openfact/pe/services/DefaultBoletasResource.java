package org.openfact.pe.services;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.pe.BoletasResource;
import org.openfact.pe.idm.BoletaRepresentation;
import org.openfact.pe.managers.TypeManager;
import org.openfact.pe.models.*;
import org.openfact.pe.models.utils.ModelToRepresentation;
import org.openfact.pe.models.utils.RepresentationToModel;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
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
public class DefaultBoletasResource implements BoletasResource {

    @Inject
    private TypeManager typeManager;

    @Inject
    private BoletaProvider boletaProvider;

    @Inject
    private OrganizationProvider organizationProvider;

    @Override
    public List<BoletaRepresentation> getBoletas(String organizationId, String estado, int offset, int limit) {
        EstadoComprobantePago estadoComprobantePago = EstadoComprobantePago.valueOf(estado.toUpperCase());

        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));

        return boletaProvider.getBoletas(organization, estadoComprobantePago, offset, limit).stream()
                .map(f -> ModelToRepresentation.toRepresentation(f, true))
                .collect(Collectors.toList());
    }

    @Override
    public BoletaRepresentation crearBoleta(String organizationId, BoletaRepresentation rep) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));

        String serie = rep.getSerie();
        Integer numero = rep.getNumero();

        BoletaModel boleta;
        if (serie == null) {
            if (numero == null) {
                boleta = boletaProvider.createBoleta(organization);
            } else {
                throw new BadRequestException("Petición invalida: [serie=null, numero=not null]");
            }
        } else {
            if (numero == null) {
                boleta = boletaProvider.createBoleta(organization, serie);
            } else {
                boleta = boletaProvider.createBoleta(organization, serie, numero);
            }
        }

        // Datos por defecto si no son especificadas
        if (rep.getFecha() == null) {
            boleta.getFecha().setEmision(Calendar.getInstance().getTime());
            boleta.getFecha().setVencimiento(Calendar.getInstance().getTime());
        }
        if (rep.getEnviarSunat() == null) {
            boleta.setEnviarSunat(true);
        }
        if (rep.getEnviarCliente() == null) {
            boleta.setEnviarCliente(true);
        }

        // Merge
        RepresentationToModel.modelToRepresentation(boleta, rep);

        // Recalcular XML
        typeManager.buildBoleta(organization, boleta);

        return ModelToRepresentation.toRepresentation(boleta, true);
    }

    @Override
    public void actualizarBoleta(String organizationId, String idDocumento, BoletaRepresentation rep) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        BoletaModel boleta = boletaProvider.getBoleta(organization, idDocumento).orElseThrow(() -> new NotFoundException("Boleta o Factura no encontrada"));

        if (boleta.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            throw new BadRequestException("Comprobante REGISTRADO o ya fue declarado a la SUNAT, no se puede eliminar");
        }

        RepresentationToModel.modelToRepresentation(boleta, rep);

        // Recalcular XML
        typeManager.buildBoleta(organization, boleta);
    }

    @Override
    public void eliminarBoleta(String organizationId, String idDocumento) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        BoletaModel boleta = boletaProvider.getBoleta(organization, idDocumento).orElseThrow(() -> new NotFoundException("Boleta no encontrada"));

        if (boleta.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            throw new BadRequestException("Comprobante REGISTRADO o ya fue declarado a la SUNAT, no se puede eliminar");
        }

        boolean result = boletaProvider.remove(boleta);
        if (!result) {
            throw new InternalServerErrorException("Error interno, no se pudo eliminar la Boleta");
        }
    }

}

package org.openfact.pe.services;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.pe.BoletasResource;
import org.openfact.pe.idm.*;
import org.openfact.pe.managers.JAXBManager;
import org.openfact.pe.models.*;
import org.openfact.pe.models.types.TipoInvoice;
import org.openfact.pe.models.utils.ModelToRepresentation;
import org.openfact.pe.models.utils.RepresentationToModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import java.util.Calendar;
import java.util.regex.Pattern;

@Transactional
@ApplicationScoped
public class DefaultBoletasResource implements BoletasResource {

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private BoletaProvider boletaProvider;

    @Inject
    private JAXBManager jaxbManager;

    @Override
    public BoletaRepresentation crearBoleta(String organizacionId, BoletaRepresentation representation) {
        OrganizationModel organizacion = organizationProvider.getOrganization(organizacionId).orElseThrow(() -> new NotFoundException("Organizacion no encontrada"));

        String serie = representation.getSerie();
        Integer numero = representation.getNumero();

        BoletaModel boleta;
        if (serie == null) {
            if (numero == null) {
                boleta = boletaProvider.createBoleta(organizacion);
            } else {
                throw new BadRequestException("peticion invalida: [serie=null, numero=not null]");
            }
        } else {
            Pattern pattern = Pattern.compile(TipoInvoice.BOLETA.getSeriePattern());
            if (!pattern.matcher(serie).matches()) {
                throw new BadRequestException("Serie Invalida, no cumple con el patron [BXXX...]");
            }
            if (numero == null) {
                boleta = boletaProvider.createBoleta(organizacion, serie);
            } else {
                boleta = boletaProvider.createBoleta(organizacion, serie, numero);
            }
        }

        // Datos por defecto si no son espeficificadas
        if (representation.getFecha() == null) {
            boleta.setFechaEmision(Calendar.getInstance().getTime());
        }
        if (representation.getEnviarSUNAT() == null) {
            boleta.setEnviarSUNAT(representation.getEnviarSUNAT());
        }
        if (representation.getEnviarCliente() == null) {
            boleta.setEnviarCliente(representation.getEnviarCliente());
        }

        // Merge
        RepresentationToModel.modelToRepresentation(boleta, representation);

        // JAXB
        if (boleta.getEnviarSUNAT()) {
            jaxbManager.buildBoleta(boleta);
        }

        return ModelToRepresentation.toRepresentation(boleta, true);
    }

    @Override
    public void actualizarBoleta(String organizacionId, String idDocumento, BoletaRepresentation representation) {
        OrganizationModel organizacion = organizationProvider.getOrganization(organizacionId).orElseThrow(() -> new NotFoundException("Organizacion no encontrada"));
        BoletaModel boleta = boletaProvider.getBoletaFactura(organizacion, idDocumento).orElseThrow(() -> new NotFoundException("Boleta o Factura no encontrada"));
        RepresentationToModel.modelToRepresentation(boleta, representation);

        // JAXB
        if (boleta.getEnviarSUNAT()) {
            jaxbManager.buildBoleta(boleta);
        }
    }

    @Override
    public void eliminarBoleta(String organizacionId, String idDocumento) {
        OrganizationModel organizacion = organizationProvider.getOrganization(organizacionId).orElseThrow(() -> new NotFoundException("Organizacion no encontrada"));
        BoletaModel boleta = boletaProvider.getBoletaFactura(organizacion, idDocumento).orElseThrow(() -> new NotFoundException("Boleta o Factura no encontrada"));
        if (boleta.getEstado().equals(EstadoComprobantePago.BLOQUEADO)) {
            throw new BadRequestException("Comprobante BLOQUEADO o ya fue declarado a la SUNAT, no se puede eliminar");
        }
        boolean result = boletaProvider.remove(organizacion, boleta);
        if (!result) {
            throw new InternalServerErrorException("Error interno, no se pudo eliminar la Boleta");
        }
    }

}

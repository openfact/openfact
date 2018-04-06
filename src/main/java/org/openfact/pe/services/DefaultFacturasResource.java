package org.openfact.pe.services;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.pe.FacturasResource;
import org.openfact.pe.idm.FacturaRepresentation;
import org.openfact.pe.managers.JAXBManager;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.FacturaProvider;
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
public class DefaultFacturasResource implements FacturasResource {

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private FacturaProvider facturaProvider;

    @Inject
    private JAXBManager jaxbManager;

    @Override
    public FacturaRepresentation crearFactura(String organizationId, FacturaRepresentation representation) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));

        String serie = representation.getSerie();
        Integer numero = representation.getNumero();

        FacturaModel factura;
        if (serie == null) {
            if (numero == null) {
                factura = facturaProvider.createFactura(organization);
            } else {
                throw new BadRequestException("Petición invalida: [serie=null, numero=not null]");
            }
        } else {
            Pattern pattern = Pattern.compile(TipoInvoice.FACTURA.getSeriePattern());
            if (!pattern.matcher(serie).matches()) {
                throw new BadRequestException("Serie Invalida, no cumple con el patron [F...]");
            }
            if (numero == null) {
                factura = facturaProvider.createFactura(organization, serie);
            } else {
                factura = facturaProvider.createFactura(organization, serie, numero);
            }
        }

        // Datos por defecto si no son especificadas
        if (representation.getFecha() == null) {
            factura.setFechaEmision(Calendar.getInstance().getTime());
        }
        if (representation.getEnviarSUNAT() == null) {
            factura.setEnviarSUNAT(representation.getEnviarSUNAT());
        }
        if (representation.getEnviarCliente() == null) {
            factura.setEnviarCliente(representation.getEnviarCliente());
        }

        // Merge
        RepresentationToModel.modelToRepresentation(factura, representation);

        // Recalcular XML
        jaxbManager.buildBoleta(factura);

        return ModelToRepresentation.toRepresentation(factura, true);
    }

    @Override
    public void actualizarFactura(String organizationId, String idDocumento, FacturaRepresentation representation) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        FacturaModel factura = facturaProvider.getFactura(organization, idDocumento).orElseThrow(() -> new NotFoundException("Factura no encontrada"));
        RepresentationToModel.modelToRepresentation(factura, representation);

        // Recalcular XML
        jaxbManager.buildBoleta(factura);
    }

    @Override
    public void eliminarFactura(String organizationId, String idDocumento) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(() -> new NotFoundException("Organización no encontrada"));
        FacturaModel factura = facturaProvider.getFactura(organization, idDocumento).orElseThrow(() -> new NotFoundException("Boleta o Factura no encontrada"));
        if (factura.getEstado().equals(EstadoComprobantePago.BLOQUEADO)) {
            throw new BadRequestException("Comprobante BLOQUEADO o ya fue declarado a la SUNAT, no se puede eliminar");
        }
        boolean result = facturaProvider.remove(factura);
        if (!result) {
            throw new InternalServerErrorException("Error interno, no se pudo eliminar la Factura");
        }
    }

}

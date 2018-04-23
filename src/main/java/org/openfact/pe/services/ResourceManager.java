package org.openfact.pe.services;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.core.security.ISecurityContext;
import org.openfact.core.security.PermissionType;
import org.openfact.pe.managers.TypeManager;
import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.BoletaProvider;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.FacturaProvider;
import org.openfact.pe.models.utils.ModelToRepresentation;
import org.openfact.pe.models.utils.RepresentationToModel;
import org.openfact.pe.representations.idm.BoletaRepresentation;
import org.openfact.pe.representations.idm.FacturaRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import java.util.Calendar;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class ResourceManager {

    @Inject
    private BoletaProvider boletaProvider;

    @Inject
    private FacturaProvider facturaProvider;

    @Inject
    private OrganizationProvider organizationProvider;

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
        return ModelToRepresentation.toRepresentation(boleta, true);
    }

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

        RepresentationToModel.modelToRepresentation(factura, rep);
        return ModelToRepresentation.toRepresentation(factura, true);
    }

}

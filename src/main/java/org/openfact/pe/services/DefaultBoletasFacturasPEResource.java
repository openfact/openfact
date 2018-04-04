package org.openfact.pe.services;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.OrganizationProvider;
import org.openfact.core.models.utils.ModelToRepresentation;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.BoletasFacturasPEResource;
import org.openfact.pe.idm.BoletaFacturaPERepresentation;
import org.openfact.pe.idm.NotaCreditoPERepresentation;
import org.openfact.pe.models.*;
import org.openfact.pe.models.utils.ModelPEUtils;
import org.openfact.pe.models.utils.ModelToRepresentationPE;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class DefaultBoletasFacturasPEResource implements BoletasFacturasPEResource {

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private BoletaFacturaPEProvider boletaFacturaProvider;

    @Inject
    private ContadorSerieNumeroPEProvider contadorSerieNumeroProvider;

    @Override
    public BoletaFacturaPERepresentation crearBoletaFactura(String organizacionId, BoletaFacturaPERepresentation rep) {
        OrganizationModel organizacion = organizationProvider.getCompany(organizacionId).orElseThrow(() -> new NotFoundException("Organizacion no encontrada"));

        String serie = rep.getSerie();
        Integer numero = rep.getNumero();
        TipoInvoice tipoInvoice = TipoInvoice.valueOf(rep.getTipoInvoice().toUpperCase());

        String idAsignado;
        if (serie != null && numero != null) {
            idAsignado = serie + "-" + numero;
        } else if (serie != null) {
            ContadorSerieNumeroPEModel contadorSerieNumero = contadorSerieNumeroProvider.getNextAndBlock(organizacion, tipoInvoice.toString(), serie);
            idAsignado = ModelPEUtils.getIdAsignadoBoletaFactura(tipoInvoice, Optional.ofNullable(contadorSerieNumero.getPrefijo()), contadorSerieNumero.getSerie(), contadorSerieNumero.getNumero());
        } else if (numero != null) {
            throw new BadRequestException("peticion invalida: [serie=null, numero=not null]");
        } else {
            ContadorSerieNumeroPEModel contadorSerieNumero = contadorSerieNumeroProvider.getNextAndBlock(organizacion, tipoInvoice.toString());
            idAsignado = ModelPEUtils.getIdAsignadoBoletaFactura(tipoInvoice, Optional.ofNullable(contadorSerieNumero.getPrefijo()), contadorSerieNumero.getSerie(), contadorSerieNumero.getNumero());
        }

        BoletaFacturaPEModel boletaFacturaModel = boletaFacturaProvider.addBoletaFactura(organizacion, idAsignado);
        return ModelToRepresentationPE.toRepresentation(boletaFacturaModel, true);
    }

    @Override
    public void actualizarBoletaFactura(String organizacionId, String idDocumento, BoletaFacturaPERepresentation rep) {

    }

    @Override
    public void eliminarBoletaFactura(String organizacionId, String idDocumento) {

    }

}

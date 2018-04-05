package org.openfact.pe.services;

import org.openfact.core.models.OrganizationProvider;
import org.openfact.pe.BoletasFacturasResource;
import org.openfact.pe.idm.BoletaFacturaRepresentation;
import org.openfact.pe.models.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class DefaultBoletasFacturasPEResource implements BoletasFacturasResource {

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private BoletaFacturaProvider boletaFacturaProvider;

    @Inject
    private ContadorSerieNumeroPEProvider contadorSerieNumeroProvider;

    @Override
    public BoletaFacturaRepresentation crearBoletaFactura(String organizacionId, BoletaFacturaRepresentation rep) {
//        OrganizationModel organizacion = organizationProvider.getCompany(organizacionId).orElseThrow(() -> new NotFoundException("Organizacion no encontrada"));
//
//        String serie = rep.getSerie();
//        Integer numero = rep.getNumero();
//        TipoInvoice tipoInvoice = TipoInvoice.valueOf(rep.getTipoInvoice().toUpperCase());
//
//        String idAsignado;
//        if (serie != null && numero != null) {
//            idAsignado = serie + "-" + numero;
//        } else if (serie != null) {
//            ContadorSerieNumeroPEModel contadorSerieNumero = contadorSerieNumeroProvider.getNextAndBlock(organizacion, tipoInvoice.toString(), serie);
//            idAsignado = ModelPEUtils.getIdAsignadoBoletaFactura(tipoInvoice, Optional.ofNullable(contadorSerieNumero.getPrefijo()), contadorSerieNumero.getSerie(), contadorSerieNumero.getNumero());
//        } else if (numero != null) {
//            throw new BadRequestException("peticion invalida: [serie=null, numero=not null]");
//        } else {
//            ContadorSerieNumeroPEModel contadorSerieNumero = contadorSerieNumeroProvider.getNextAndBlock(organizacion, tipoInvoice.toString());
//            idAsignado = ModelPEUtils.getIdAsignadoBoletaFactura(tipoInvoice, Optional.ofNullable(contadorSerieNumero.getPrefijo()), contadorSerieNumero.getSerie(), contadorSerieNumero.getNumero());
//        }
//
//        BoletaFacturaModel boletaFacturaModel = boletaFacturaProvider.addBoletaFactura(organizacion, idAsignado);
//        return ModelToRepresentation.toRepresentation(boletaFacturaModel, true);
        return null;
    }

    @Override
    public void actualizarBoletaFactura(String organizacionId, String idDocumento, BoletaFacturaRepresentation rep) {

    }

    @Override
    public void eliminarBoletaFactura(String organizacionId, String idDocumento) {

    }

}

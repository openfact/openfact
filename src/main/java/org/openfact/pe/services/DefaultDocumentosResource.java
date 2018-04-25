package org.openfact.pe.services;

import org.openfact.pe.DocumentosResource;
import org.openfact.pe.models.BoletaProvider;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.FacturaProvider;
import org.openfact.pe.representations.idm.ResumenDocumentosObservadosRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class DefaultDocumentosResource implements DocumentosResource {

    @Inject
    private BoletaProvider boletaProvider;

    @Inject
    private FacturaProvider facturaProvider;

    @Override
    public ResumenDocumentosObservadosRepresentation getResumenDocumentosObservados(String organizationId) {
        long totalBoletasAbiertas = boletaProvider.getTotalBoletasPorEstado(organizationId, EstadoComprobantePago.ABIERTO);
        long totalFacturasAbiertas = facturaProvider.getTotalFacturasPorEstado(organizationId, EstadoComprobantePago.ABIERTO);

        ResumenDocumentosObservadosRepresentation resumen = new ResumenDocumentosObservadosRepresentation();
        resumen.setBoletas(totalBoletasAbiertas);
        resumen.setFacturas(totalFacturasAbiertas);

        resumen.setTotal(totalBoletasAbiertas + totalFacturasAbiertas);
        return resumen;
    }

}

package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.Optional;

public interface BoletaProvider {

    BoletaModel createBoleta(OrganizationModel organizacion);

    BoletaModel createBoleta(OrganizationModel organizacion, String serie);

    BoletaModel createBoleta(OrganizationModel organizacion, String serie, int numero);

    Optional<BoletaModel> getBoletaFactura(OrganizationModel organizacion, String idDocumento);

    boolean remove(OrganizationModel organizacion, BoletaModel factura);
}

package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.List;
import java.util.Optional;

public interface BoletaProvider {

    BoletaModel createBoleta(OrganizationModel organization);
    BoletaModel createBoleta(OrganizationModel organization, String serie);
    BoletaModel createBoleta(OrganizationModel organization, String serie, int numero);

    Optional<BoletaModel> getBoleta(OrganizationModel organization, String id);

    List<BoletaModel> getBoletas(OrganizationModel organization, EstadoComprobantePago estado);
    List<BoletaModel> getBoletas(OrganizationModel organization, EstadoComprobantePago estado, int offset, int limit);

    boolean remove(BoletaModel boleta);

}

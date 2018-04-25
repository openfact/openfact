package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.List;
import java.util.Optional;

public interface BoletaProvider {

    BoletaModel createBoleta(OrganizationModel organization);
    BoletaModel createBoleta(OrganizationModel organization, String serie);
    BoletaModel createBoleta(OrganizationModel organization, String serie, int numero);

    Optional<BoletaModel> getBoleta(String id);
    Optional<BoletaModel> getBoleta(String id, String organizationId);
    Optional<BoletaModel> getBoleta(String id, OrganizationModel organization);

    Optional<BoletaModel> getBoletaBySerieYNumero(String serie, int numero, OrganizationModel organization);

    List<BoletaModel> getBoletas(String organizationId, EstadoComprobantePago estado);
    List<BoletaModel> getBoletas(String organizationId, EstadoComprobantePago estado, int offset, int limit);

    List<BoletaModel> getBoletas(OrganizationModel organization, EstadoComprobantePago estado);
    List<BoletaModel> getBoletas(OrganizationModel organization, EstadoComprobantePago estado, int offset, int limit);

    long getTotalBoletasPorEstado(OrganizationModel organization, EstadoComprobantePago estado);
    long getTotalBoletasPorEstado(String organizationId, EstadoComprobantePago estado);

}

package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.List;
import java.util.Optional;

public interface FacturaProvider {

    FacturaModel createFactura(OrganizationModel organization);
    FacturaModel createFactura(OrganizationModel organization, String serie);
    FacturaModel createFactura(OrganizationModel organization, String serie, int numero);

    Optional<FacturaModel> getFactura(String id);
    Optional<FacturaModel> getFactura(String id, OrganizationModel organization);
    Optional<FacturaModel> getFactura(String id, String organizationId);

    Optional<FacturaModel> getFacturaBySerieYNumero(String serie, int numero, OrganizationModel organization);

    List<FacturaModel> getFacturas(String organizationId, EstadoComprobantePago estado);
    List<FacturaModel> getFacturas(String organizationId, EstadoComprobantePago estado, int offset, int limit);

    List<FacturaModel> getFacturas(OrganizationModel organization, EstadoComprobantePago estado);
    List<FacturaModel> getFacturas(OrganizationModel organization, EstadoComprobantePago estado, int offset, int limit);

    long getTotalFacturasPorEstado(OrganizationModel organization, EstadoComprobantePago estado);
    long getTotalFacturasPorEstado(String organizationId, EstadoComprobantePago estado);

}

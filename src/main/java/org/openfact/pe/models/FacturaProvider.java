package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.Optional;

public interface FacturaProvider {

    FacturaModel createFactura(OrganizationModel organizacion);

    FacturaModel createFactura(OrganizationModel organizacion, String serie);

    FacturaModel createFactura(OrganizationModel organizacion, String serie, int numero);

    Optional<FacturaModel> getBoletaFactura(OrganizationModel organizacion, String idDocumento);

    boolean remove(OrganizationModel organizacion, FacturaModel factura);
}

package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.Optional;

public interface FacturaProvider {

    FacturaModel createFactura(OrganizationModel organization);

    FacturaModel createFactura(OrganizationModel organization, String serie);

    FacturaModel createFactura(OrganizationModel organization, String serie, int numero);

    Optional<FacturaModel> getFactura(OrganizationModel organization, String id);

    boolean remove(FacturaModel factura);

}

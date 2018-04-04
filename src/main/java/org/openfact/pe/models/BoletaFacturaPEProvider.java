package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

public interface BoletaFacturaPEProvider {

    BoletaFacturaPEModel addBoletaFactura(OrganizationModel organizacion, String idAsignado);

}

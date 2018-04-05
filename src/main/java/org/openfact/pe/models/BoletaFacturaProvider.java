package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

public interface BoletaFacturaProvider {

    BoletaFacturaModel addBoletaFactura(OrganizationModel organizacion, String idAsignado);

}

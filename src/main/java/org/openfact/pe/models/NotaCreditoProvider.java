package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

public interface NotaCreditoProvider {

    NotaCreditoPEModel addNotaCredito(OrganizationModel organizacion, String idAsignado);

}

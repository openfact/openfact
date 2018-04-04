package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

public interface NotaCreditoPEProvider {

    NotaCreditoPEModel addNotaCredito(OrganizationModel organizacion, String idAsignado);

}

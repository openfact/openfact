package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

public interface NotaDebitoProvider {

    NotaDebitoPEModel addNotaDebito(OrganizationModel organizacion, String idAsignado);

}

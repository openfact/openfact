package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

public interface NotaDebitoPEProvider {

    NotaDebitoPEModel addNotaDebito(OrganizationModel organizacion, String idAsignado);

}

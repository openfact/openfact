package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.Optional;

public interface ContadorSerieNumeroPEProvider {

    ContadorSerieNumeroPEModel getSiguiente(OrganizationModel organization, String tipoDocumento, String serie);

}

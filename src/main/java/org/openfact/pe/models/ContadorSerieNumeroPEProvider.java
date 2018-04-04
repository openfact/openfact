package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.Optional;

public interface ContadorSerieNumeroPEProvider {

    ContadorSerieNumeroPEModel getNext(OrganizationModel organization, String tipoDocumento);

    ContadorSerieNumeroPEModel getNext(OrganizationModel organization, String tipoDocumento, String serie);

    ContadorSerieNumeroPEModel getNextAndBlock(OrganizationModel organization, String tipoDocumento);

    ContadorSerieNumeroPEModel getNextAndBlock(OrganizationModel organization, String tipoDocumento, String serie);

    Optional<ContadorSerieNumeroPEModel> getCurrent(OrganizationModel organization, String tipoDocumento);

    Optional<ContadorSerieNumeroPEModel> getCurrent(OrganizationModel organization, String tipoDocumento, String serie);

}

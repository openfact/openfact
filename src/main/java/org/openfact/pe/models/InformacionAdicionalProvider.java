package org.openfact.pe.models;

import org.openfact.core.models.OrganizationModel;

import java.util.Optional;

public interface InformacionAdicionalProvider {

    Optional<InformacionAdicionalModel> getOrganizacionInformacionAdicional(String id);

    Optional<InformacionAdicionalModel> getOrganizacionInformacionAdicional(OrganizationModel organization);

}
